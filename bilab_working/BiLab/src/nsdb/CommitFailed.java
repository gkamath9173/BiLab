package nsdb;


/**
* nsdb/CommitFailed.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb_write.idl
* Monday, August 23, 2004 12:02:44 PM BST
*/

public final class CommitFailed extends org.omg.CORBA.UserException
{
  public String reason = null;

  public CommitFailed ()
  {
    super(CommitFailedHelper.id());
  } // ctor

  public CommitFailed (String _reason)
  {
    super(CommitFailedHelper.id());
    reason = _reason;
  } // ctor


  public CommitFailed (String $reason, String _reason)
  {
    super(CommitFailedHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class CommitFailed
