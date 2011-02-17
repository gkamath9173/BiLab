package type;


/**
* type/TranslationException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/


/**
   * Translation exception of a single triplet within a sequence.
   * <p>
   * <dl>
   * <dt> primary_acc
   * <dd> This attribute is likely to change in the future. It is very rarely
   *      used, but it is needed for translation exceptions on CDS's 
   *     spanning entries    
   * <dt> start
   * <dd> startposition of exception in the sequence.
   * <dt> end
   * <dd> endposition of exception in the sequence
   * <dt> amino_acid
   * <dd> amino acid used in this exception.
   * <dd> No modified AA are allowed. 
   *</dl>
   */
public final class TranslationException implements org.omg.CORBA.portable.IDLEntity
{
  public String primary_acc = null;
  public int start = (int)0;
  public int end = (int)0;
  public type.AminoAcid amino_acid = null;

  public TranslationException ()
  {
  } // ctor

  public TranslationException (String _primary_acc, int _start, int _end, type.AminoAcid _amino_acid)
  {
    primary_acc = _primary_acc;
    start = _start;
    end = _end;
    amino_acid = _amino_acid;
  } // ctor

} // class TranslationException
