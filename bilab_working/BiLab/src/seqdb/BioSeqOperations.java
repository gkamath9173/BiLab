package seqdb;


/**
* seqdb/BioSeqOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/seqdb.idl
* Monday, August 23, 2004 12:02:46 PM BST
*/


/** 
       * generic biosequence. Provides al functionality we would like to see 
       * on any sequence.
       */
public interface BioSeqOperations 
{

  /**
  	 * retrieve unique identifier
  	 */
  String getBioSeqId ();

  /**
  	 * length (nr of elements) of the biosequence
  	 */
  int getLength ();

  /**
  	 * sequence of objects describing the elements in the biosequence
  	 * This is a generic description. Most subclasses
  	 * will define more convenient methods for accessing the biosequence.
  	 * @returns any containing an set of objects. The any should have 
  	 *          a typecode tk_array.
  	 */
  org.omg.CORBA.Any getAnySeq ();

  /**
  	 * Return current version of the BioSeq. returns 0 if versioning is not
  	 * implemented on the bioseq.
  	 */
  int getBioSeqVersion ();
} // interface BioSeqOperations
