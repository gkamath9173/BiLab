package nsdb;

/**
* nsdb/ServerInfoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb_write.idl
* Monday, August 23, 2004 12:02:44 PM BST
*/

public final class ServerInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public nsdb.ServerInfo value = null;

  public ServerInfoHolder ()
  {
  }

  public ServerInfoHolder (nsdb.ServerInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = nsdb.ServerInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    nsdb.ServerInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return nsdb.ServerInfoHelper.type ();
  }

}
