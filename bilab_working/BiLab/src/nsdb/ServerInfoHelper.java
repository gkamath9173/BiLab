package nsdb;


/**
* nsdb/ServerInfoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb_write.idl
* Monday, August 23, 2004 12:02:43 PM BST
*/

abstract public class ServerInfoHelper
{
  private static String  _id = "IDL:nsdb/ServerInfo:1.0";

  public static void insert (org.omg.CORBA.Any a, nsdb.ServerInfo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static nsdb.ServerInfo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = nsdb.EntryStatsHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "entry_stats_list",
            _tcOf_members0,
            null);
          _tcOf_members0 = nsdb.EntryStatsHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "file_stats_list",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (nsdb.ServerInfoHelper.id (), "ServerInfo", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static nsdb.ServerInfo read (org.omg.CORBA.portable.InputStream istream)
  {
    nsdb.ServerInfo value = new nsdb.ServerInfo ();
    int _len0 = istream.read_long ();
    value.entry_stats_list = new nsdb.EntryStats[_len0];
    for (int _o1 = 0;_o1 < value.entry_stats_list.length; ++_o1)
      value.entry_stats_list[_o1] = nsdb.EntryStatsHelper.read (istream);
    int _len1 = istream.read_long ();
    value.file_stats_list = new nsdb.EntryStats[_len1];
    for (int _o2 = 0;_o2 < value.file_stats_list.length; ++_o2)
      value.file_stats_list[_o2] = nsdb.EntryStatsHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, nsdb.ServerInfo value)
  {
    ostream.write_long (value.entry_stats_list.length);
    for (int _i0 = 0;_i0 < value.entry_stats_list.length; ++_i0)
      nsdb.EntryStatsHelper.write (ostream, value.entry_stats_list[_i0]);
    ostream.write_long (value.file_stats_list.length);
    for (int _i1 = 0;_i1 < value.file_stats_list.length; ++_i1)
      nsdb.EntryStatsHelper.write (ostream, value.file_stats_list[_i1]);
  }

}
