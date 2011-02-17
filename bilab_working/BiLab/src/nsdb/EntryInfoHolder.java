package nsdb;

/**
* nsdb/EntryInfoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb.idl
* Monday, August 23, 2004 12:02:40 PM BST
*/


/**
       * The EMBL database contains information, which is not really part of the
       * sequence information. This information is stored in the EntryInfo.
       */
public final class EntryInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public nsdb.EntryInfo value = null;

  public EntryInfoHolder ()
  {
  }

  public EntryInfoHolder (nsdb.EntryInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = nsdb.EntryInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    nsdb.EntryInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return nsdb.EntryInfoHelper.type ();
  }

}
