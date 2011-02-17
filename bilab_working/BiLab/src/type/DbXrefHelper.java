package type;


/**
* type/DbXrefHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/


/**
   * Database cross-reference. The list of valid database identifiers
   * used by the collaboration is defined at the 
   * <A href="http://www.ncbi.nlm.nih.gov/collab/db_xref.html">NCBI
      collaborative web server</A> 
   * <dl>
   * <dt>db
   * <dd>database identifier
   * <dt>primary_id
   * <dd>object identifier in the database
   * <dt>version
   * <dd> if the referenced database supports versioning, version
   *      refers to the version of the object, when the cross-reference 
   *      was generated. If can be used to verify that a cross-reference
   *      is up to date.
   * <dt>label
   * <dd>secondary identifier, possibly used to indicate a sub/super-part of
   *     the primary object or an alternative name to the primary id. 
   *     The label can contain information for the convenience
   *     of the user, but no assumptions should be made on the long-term 
   *     stability of it.
   * </dl>
   */
abstract public class DbXrefHelper
{
  private static String  _id = "IDL:type/DbXref:1.0";

  public static void insert (org.omg.CORBA.Any a, type.DbXref that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static type.DbXref extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "db",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "primary_id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ulong);
          _members0[2] = new org.omg.CORBA.StructMember (
            "version",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "label",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (type.DbXrefHelper.id (), "DbXref", _members0);
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

  public static type.DbXref read (org.omg.CORBA.portable.InputStream istream)
  {
    type.DbXref value = new type.DbXref ();
    value.db = istream.read_string ();
    value.primary_id = istream.read_string ();
    value.version = istream.read_ulong ();
    value.label = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, type.DbXref value)
  {
    ostream.write_string (value.db);
    ostream.write_string (value.primary_id);
    ostream.write_ulong (value.version);
    ostream.write_string (value.label);
  }

}
