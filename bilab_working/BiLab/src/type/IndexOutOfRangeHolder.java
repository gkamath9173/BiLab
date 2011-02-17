package type;

/**
* type/IndexOutOfRangeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:36 PM BST
*/


/**
   * If a number indicating a position in a sequence is
   * outside the limits of the sequence, or more elements are associated to
   * an object than it can handle, 
   * an IndexOutOfRange exception is raised
   */
public final class IndexOutOfRangeHolder implements org.omg.CORBA.portable.Streamable
{
  public type.IndexOutOfRange value = null;

  public IndexOutOfRangeHolder ()
  {
  }

  public IndexOutOfRangeHolder (type.IndexOutOfRange initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.IndexOutOfRangeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.IndexOutOfRangeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.IndexOutOfRangeHelper.type ();
  }

}