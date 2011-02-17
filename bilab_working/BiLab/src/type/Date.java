package type;


/**
* type/Date.java .
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
public final class Date implements org.omg.CORBA.portable.IDLEntity
{
  public short day = (short)0;
  public short month = (short)0;
  public short year = (short)0;

  public Date ()
  {
  } // ctor

  public Date (short _day, short _month, short _year)
  {
    day = _day;
    month = _month;
    year = _year;
  } // ctor

} // class Date
