package nsdb;

/**
* nsdb/EntryStatsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb_write.idl
* Monday, August 23, 2004 12:02:43 PM BST
*/

public final class EntryStatsHolder implements org.omg.CORBA.portable.Streamable
{
  public nsdb.EntryStats value = null;

  public EntryStatsHolder ()
  {
  }

  public EntryStatsHolder (nsdb.EntryStats initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = nsdb.EntryStatsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    nsdb.EntryStatsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return nsdb.EntryStatsHelper.type ();
  }

}
