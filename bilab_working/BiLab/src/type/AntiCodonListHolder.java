package type;


/**
* type/AntiCodonListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/

public final class AntiCodonListHolder implements org.omg.CORBA.portable.Streamable
{
  public type.AntiCodon value[] = null;

  public AntiCodonListHolder ()
  {
  }

  public AntiCodonListHolder (type.AntiCodon[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.AntiCodonListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.AntiCodonListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.AntiCodonListHelper.type ();
  }

}
