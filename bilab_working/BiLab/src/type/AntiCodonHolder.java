package type;

/**
* type/AntiCodonHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/


/**
   * Location of the anticodon of tRNA and the amino acid for which
   * it codes.
   * <p>
   * <dl>
   * <dt> start
   * <dd> start position of the anticodon
   * <dt> end
   * <dd> end position of the anticodon
   * <dt> amino_acid
   * <dd> amino acid used. 
   * <dd> No modified AA are allowed.
   * </dl>
   */
public final class AntiCodonHolder implements org.omg.CORBA.portable.Streamable
{
  public type.AntiCodon value = null;

  public AntiCodonHolder ()
  {
  }

  public AntiCodonHolder (type.AntiCodon initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.AntiCodonHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.AntiCodonHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.AntiCodonHelper.type ();
  }

}
