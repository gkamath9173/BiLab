package scigol;

import java.util.*;  
  
public class Matrix
{
  public Matrix()
  {
    _rows = _cols = 0;
    a = new ArrayList();
  }

  
  public Matrix(double n)
  {
    _rows = _cols = 1;
    a = new ArrayList();
    Vector row = new Vector(n);
    a.add(row);
  }
  
  
  public Matrix(Vector row)
  {
    _rows = 1; _cols = row.get_size();
    a = new ArrayList();
    a.add(row);
  }
  
  
  public static Matrix zero(int rows, int cols)
  {
    Matrix m = new Matrix();
    for(int r=0; r<rows; r++)
      m.appendRowVector(Vector.zero(cols));
    return m;
  }
  
  
  public static Matrix identity(int dim)
  {
    Matrix m = new Matrix();
    for(int r=0; r<dim; r++) {
      Vector v = Vector.zero(dim);
      v.set_Item(r,new Any(new Double(1.0)));
      m.appendRowVector(v);
    }
    return m;
  }
  
  
  
  
  @accessor
  public int get_rows()
  {
    return _rows; 
  }
  
  
  @accessor
  public int get_cols()
  {
    return _cols; 
  }
  
  
  public Vector row(int i)
  {
    Debug.Assert((i>=0) && (i < get_rows()));
    return (Vector)a.get(i);
  }
  
  
  public Vector col(int i)
  {
    Debug.Assert((i>=0) && (i < get_cols()));
    
    Vector _col = new Vector();
    for(int r=0; r<get_rows();r++)
      _col.appendElement(((Vector)a.get(r)).get_Item(i));
    return _col;
  }
  
  
  
  
  public static Matrix op_Prime(Matrix m)
  {
    Matrix t = new Matrix(m.col(0));
    for(int c=1; c<m.get_cols();c++) 
      t.appendRowVector(m.col(c));
    
    return t;
  }
  
  
  public static Matrix op_UnaryNegation(Matrix m)
  {
    Matrix mm = new Matrix(Vector.op_UnaryNegation(m.row(0)));
    for(int r=1; r<m.get_rows();r++)
      mm.appendRowVector( Vector.op_UnaryNegation(m.row(r)) );
    return mm;
  }
  
  public static Matrix op_Addition(Matrix m1, Matrix m2) 
  {
    if ((m1.get_rows() != m2.get_rows()) || (m1.get_cols() != m2.get_cols()))
      throw new IllegalArgumentException("matrices have incompatible dimensions for addition");
    
    Matrix m = new Matrix( Vector.op_Addition(m1.row(0), m2.row(0)) );
    
    for(int r=1; r<m1.get_rows(); r++) {
      m.appendRowVector( Vector.op_Addition(m1.row(r), m2.row(r)) );
    }
    
    return m;
  }
  
  
  public static Matrix op_Subtraction(Matrix m1, Matrix m2) 
  {
    if ((m1.get_rows() != m2.get_rows()) || (m1.get_cols() != m2.get_cols()))
      throw new IllegalArgumentException("matrices have incompatible dimensions for subtraction");
    
    Matrix m = new Matrix( Vector.op_Subtraction( m1.row(0), m2.row(0)) );
    
    for(int r=1; r<m1.get_rows(); r++) {
      m.appendRowVector( Vector.op_Subtraction(m1.row(r), m2.row(r)) );
    }
    
    return m;
  }
  

  public static Matrix op_Multiply(Matrix m1, Matrix m2) 
  {
    //!!! only works for real & int matrices, fix that by looking up the operator* & operator+ for the element type
    if ((m1.get_cols() != m2.get_rows()))
      throw new IllegalArgumentException("matrices have incompatible dimensions for multiplication");

    Matrix m = null;
    
    if (m1.get_Item(0,0).value instanceof Double) {
    
      m = zero(m1.get_rows(), m2.get_cols());
      
      for(int i=0; i<m1.get_rows(); i++)
        for(int j=0; j<m2.get_cols(); j++) {
          //m.set_Item(i,j,new Any(new Double(0)));
          for(int k=0; k<m1.get_cols(); k++) {
            double mij = ((Double)m.get_Item(i,j).value).doubleValue();
            mij += ((Double)m1.get_Item(i,k).value).doubleValue() * ((Double)m2.get_Item(k,j).value).doubleValue();
            m.set_Item(i,j, new Any(new Double(mij)));
          }
        }
    }
    else if (m1.get_Item(0,0).value instanceof Integer) {

      // make int 0 matrix
      m = new Matrix();
      for(int r=0; r<m1.get_rows(); r++) {
        Vector v = new Vector();
        for(int c=0; c<m2.get_cols(); c++)
          v.appendElement(new Integer(0));
        m.appendRowVector(v);
      }
      
      for(int i=0; i<m1.get_rows(); i++)
        for(int j=0; j<m2.get_cols(); j++) {
          //m.set_Item(i,j,new Any(new Double(0)));
          for(int k=0; k<m1.get_cols(); k++) {
            int mij = ((Integer)m.get_Item(i,j).value).intValue();
            mij += ((Integer)m1.get_Item(i,k).value).intValue() * ((Integer)m2.get_Item(k,j).value).intValue();
            m.set_Item(i,j, new Any(new Integer(mij)));
          }
        }

    }
    else
      Debug.Unimplemented();
    
    return m;
  }
  
  
  
  @accessor
  public Matrix get_Item(Range rr, Range cc)
  {
    Debug.Unimplemented("submatrices");
    return this;
  }

  
  @accessor
  public void set_Item(Range rr, Range cc, Matrix value)
  {
    Debug.Unimplemented("submatrices");      
  }
  
  
  
  @accessor
  public Any get_Item(int r, int c)
  {
    if ((r >= 0) && (r < get_rows()) && (c >= 0) && (c < get_cols()))
      return ((Vector)a.get(r)).get_Item(c);
    else
      throw new IndexOutOfBoundsException("matrix index ("+r+", "+c+") out of range (0.."+(get_rows()-1)+"), (0.."+(get_cols()-1)+")");
  }
  
  
  @accessor 
  public void set_Item(int r, int c, Any value)
  {
    if ((r >= 0) && (r < get_rows()) && (c >= 0) && (c < get_cols()))
      ((Vector)a.get(r)).set_Item(c, value);
    else
      throw new IndexOutOfBoundsException("matrix index ("+r+", "+c+") out of range (0.."+(get_rows()-1)+"), (0.."+(get_cols()-1)+")");
  }
  
  
  @accessor
  public Any get_Item(int r)
  {
    if ((r >= 0) && (r < get_rows()))
      return new Any((Vector)a.get(r));
    else
      throw new IndexOutOfBoundsException("matrix row index ("+r+") out of range (0.."+(get_rows()-1)+")");
    
  }
  
  @accessor
  public void set_Item(int r, Any value)
  {
    if (    !TypeSpec.typeOf(value.value).equals(TypeSpec.vectorTypeSpec)
         || ((Vector)value.value).get_size() != get_cols()  )
      throw new IllegalArgumentException("vector with dimension equals to number of matrix columns required");
    
    //!!! check vector element type is compatible here too
    
    if ((r >= 0) && (r < get_rows()))
      a.set(r,value.value);
    else
      throw new IndexOutOfBoundsException("matrix row index ("+r+") out of range (0.."+(get_rows()-1)+")");
    
  }
  
  
  
  //!!! hide
  public void appendRowVector(Object r)
  {
    Debug.Assert(r instanceof Vector);
    Vector v = (Vector)r;
    
    if (_rows == 0) {
//!!! fix this to use TypeSpec for type compatibility comparison!!!      
//      if (!((Vector)a.get(0)).get_Item(0).getClass().equals( v.get_Item(0).getClass() ) )
//        ScigolTreeParser.semanticError("expected element of type "+TypeSpec.typeName(((Vector)a.get(0)).get_Item(0))+", not "+TypeSpec.typeName(v.get_Item(0)));
      _cols = v.get_size();
    }
    else
      if (v.get_size() != ((Vector)a.get(0)).get_size())
        ScigolTreeParser.semanticError("incorrect number of elements in row vector");

    a.add(v);
    ++_rows;
  }
  
  public String toString()
  {
    String s="";
    for(int r=0; r<_rows; r++)
      s += ((Vector)a.get(r)).toString()+Utils.nl;
    return s;
  }  
  
  protected int _rows;
  protected int _cols;
  protected ArrayList a;  
}

