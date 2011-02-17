package type;


/**
* type/CodonTranslationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/


/**
   * Translation rule specifying the amino acid encoded by a codon.
   * Standard rules are defined by the genetic code of an organism.
   * If a CDS uses non-standard rules, this can be annotated with
   * qualifier codon (value type CodonTranslation_s). 
   * <p>
   * <dt> codon
       * <dd> literal sequence of the codon.
       * <dt> amino_acid
       * <dd> amino acid used.
       * <dd> No modified AA are allowed.
       */
abstract public class CodonTranslationHelper
{
  private static String  _id = "IDL:type/CodonTranslation:1.0";

  public static void insert (org.omg.CORBA.Any a, type.CodonTranslation that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static type.CodonTranslation extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "codon",
            _tcOf_members0,
            null);
          _tcOf_members0 = type.AminoAcidHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "amino_acid",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (type.CodonTranslationHelper.id (), "CodonTranslation", _members0);
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

  public static type.CodonTranslation read (org.omg.CORBA.portable.InputStream istream)
  {
    type.CodonTranslation value = new type.CodonTranslation ();
    value.codon = istream.read_string ();
    value.amino_acid = type.AminoAcidHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, type.CodonTranslation value)
  {
    ostream.write_string (value.codon);
    type.AminoAcidHelper.write (ostream, value.amino_acid);
  }

}