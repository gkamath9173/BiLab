package nsdb;


/**
* nsdb/_EmblStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/nsdb.idl
* Monday, August 23, 2004 12:02:41 PM BST
*/


/**
 * Entry point for Nucleotide Sequence Database.
 * Query methods on the database are defined here.
 * Currently this is minimal, but should be extended later on.
 */
public class _EmblStub extends org.omg.CORBA.portable.ObjectImpl implements nsdb.Embl
{


  /**
     * retrieve Nucleotide sequence, given it's accession number. If a client only supports
     * NucSeq, and not EmblSeq, than it can widen the EmblSeq to a NucSeq (implicit).
     * @raises type::NoResult if the accession number does not exist.
     * @raises Superceded if the sequence referenced by the accession
     *   number does not exist any more, because it was merged, or split.
     */
  public nsdb.EmblSeq getEmblSeq (String bio_seq_id) throws type.NoResult, nsdb.EmblPackage.Superceded
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getEmblSeq", true);
                $out.write_string (bio_seq_id);
                $in = _invoke ($out);
                nsdb.EmblSeq $result = nsdb.EmblSeqHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:type/NoResult:1.0"))
                    throw type.NoResultHelper.read ($in);
                else if (_id.equals ("IDL:nsdb/Embl/Superceded:1.0"))
                    throw nsdb.EmblPackage.SupercededHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getEmblSeq (bio_seq_id        );
            } finally {
                _releaseReply ($in);
            }
  } // getEmblSeq

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:nsdb/Embl:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _EmblStub