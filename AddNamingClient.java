import java.util.Properties;
import java.io.*;
import org.omg.CORBA.*;
import AddNaming.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;


public class AddNamingClient
{
    public static NamingContextExt rootCtx;

    public static void list(NamingContext n, String indent) {
        try {
                final int batchSize = 1;
                BindingListHolder bList = new BindingListHolder() ;
                BindingIteratorHolder bIterator = new BindingIteratorHolder();
                n.list(batchSize, bList, bIterator) ;
                if (bList.value.length != (int) 0)
                    for (int i = 0; i < bList.value.length; i++) {
                        BindingHolder bh = new BindingHolder(bList.value[0]);
                        do {
                            String stringName = rootCtx.to_string(bh.value.binding_name);
                            System.out.println(indent + stringName) ;
                            if (bh.value.binding_type.value() == BindingType._ncontext) {
                                String _indent = "----" + indent;

                                NameComponent [] name = rootCtx.to_name(stringName);
                                NamingContext sub_context = NamingContextHelper.narrow(n.resolve(name));
                                list(sub_context, _indent);
                            }
                        } while (bIterator.value.next_one(bh));
                    }
                else
                    System.out.println(indent + "Nothing more in this context.") ;
        }
        catch (Exception e) {
            System.out.println("An exception occurred. " + e) ;
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
	try{
            NameComponent nc[]= new NameComponent[2];

	    // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            rootCtx = NamingContextExtHelper.narrow(objRef);
        
            list(rootCtx, "---->");
            System.out.println("Printing Done");
        
            nc[0] = new NameComponent("Add2", "Context");
            nc[1] = new NameComponent("Number2", "Object");
        
            org.omg.CORBA.Object objRefAdd = rootCtx.resolve(nc);
            Add addRef = AddHelper.narrow(objRefAdd);
        
            String add = addRef.addMethod(); 
            System.out.println(add);

            // Call the list function to iterate through the Name Space
            

            } catch (Exception e) {
                System.out.println("ERROR : " + e) ;
                e.printStackTrace(System.out);
            }
	}
}

