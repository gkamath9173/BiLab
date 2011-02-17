package type;

/**
* type/DateHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from corba/types.idl
* Monday, August 23, 2004 12:02:36 PM BST
*/


/**
   * Date is a struct to describe a date, independent of any report format
   * <dl>
   * <dt>day
   * <dd>day of month as a number between 1-31 (inclusive)
   * <dt>month
   * <dd> month of the year as a number between 1-12 (inclusive)
   * <dt>year
   * <dd>year as a 4 digit number
   * </dl>
   */
public final class DateHolder implements org.omg.CORBA.portable.Streamable
{
  public type.Date value = null;

  public DateHolder ()
  {
  }

  public DateHolder (type.Date initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = type.DateHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    type.DateHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return type.DateHelper.type ();
  }

}