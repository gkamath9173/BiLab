package type;

/**
* type/NoWritePermissionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:36 PM BST
*/


/**
   * If no write permission is granted (i.e. a set-method cannot be performed)
   * the NoWritePermission is raised
   */
public final class NoWritePermissionHolder implements org.omg.CORBA.portable.Streamable
{
  public type.NoWritePermission value = null;

  public NoWritePermissionHolder ()
  {
  }

  public NoWritePermissionHolder (type.NoWritePermission initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.NoWritePermissionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.NoWritePermissionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.NoWritePermissionHelper.type ();
  }

}
