package nsdb.EmblPackage;


/**
* nsdb/EmblPackage/Superceded.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb.idl
* Monday, August 23, 2004 12:02:41 PM BST
*/

public final class Superceded extends org.omg.CORBA.UserException
{
  public String bio_seq_ids[] = null;

  public Superceded ()
  {
    super(SupercededHelper.id());
  } // ctor

  public Superceded (String[] _bio_seq_ids)
  {
    super(SupercededHelper.id());
    bio_seq_ids = _bio_seq_ids;
  } // ctor


  public Superceded (String $reason, String[] _bio_seq_ids)
  {
    super(SupercededHelper.id() + "  " + $reason);
    bio_seq_ids = _bio_seq_ids;
  } // ctor

} // class Superceded