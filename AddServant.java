import AddNaming.*;

class AddServant extends _AddImplBase
{
    public String addMethod()
    {
		System.out.println("Received a call.");
        int a = 10;
        int b = 20;
        int ans = a+b;
        String result = String.valueOf(ans);
		return "10 + 20 = "+result;
    }
}
