package AddNaming;


/**
* AddNaming/AddHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Add.idl
* Saturday, February 18, 2017 3:09:26 PM GMT
*/

abstract public class AddHelper
{
  private static String  _id = "IDL:AddNaming/Add:1.0";

  public static void insert (org.omg.CORBA.Any a, AddNaming.Add that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static AddNaming.Add extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (AddNaming.AddHelper.id (), "Add");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static AddNaming.Add read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_AddStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, AddNaming.Add value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static AddNaming.Add narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof AddNaming.Add)
      return (AddNaming.Add)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      AddNaming._AddStub stub = new AddNaming._AddStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static AddNaming.Add unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof AddNaming.Add)
      return (AddNaming.Add)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      AddNaming._AddStub stub = new AddNaming._AddStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
