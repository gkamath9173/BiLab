package type;


/**
* type/SpliceConsensusListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:37 PM BST
*/

public final class SpliceConsensusListHolder implements org.omg.CORBA.portable.Streamable
{
  public type.SpliceConsensus value[] = null;

  public SpliceConsensusListHolder ()
  {
  }

  public SpliceConsensusListHolder (type.SpliceConsensus[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.SpliceConsensusListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.SpliceConsensusListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.SpliceConsensusListHelper.type ();
  }

}
