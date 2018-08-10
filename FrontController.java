/**
 * Java implementation of Front Controller Design Pattern.
 */
public class FrontController {
    /*
     * @param flag,dispatcher
     */
	   int flag;
	  Dispatcher dispatcher;
	 /**
	 * Front Controller Constructor
	 * @param dispatcher
	 */
	   public FrontController()
	   {
		this.dispatcher=dispatcher;
	   }
	   
	   /**
		 * Attempt to authentic user login.
		 * 
		 * 
		 */
	   public void AutheticUser(int i) throws Exception
	   {
		   if(i==1||i==0)
		   {
		   System.out.println("User Authenticated successfully...");
		    flag = 1;
		   }
		   else if(i==3)
		   {
			   System.out.println("Admin  Authenticated successfully...");
			    flag = 1;
		   }
		   else if(i==2)
		   {
			        flag=0;
			    	System.out.println("Enter valid credentials");
			    	System.exit(0);
		   }   
		   else
		   {
			   flag=0;
		    	System.out.println("Enter valid credentials"); 
		    	System.exit(0);
		   }
	   }
	   /*
	    * void method Dispatchrequest
	    * @param request
	    */
	   public void Dispatchrequest(String request) throws Exception 
	   {
		  String request1=request;
		   System.out.println("Page Requested "+ request);
		   if(flag==1)
		   {
			   dispatcher.getFactory(request1);
			   //System.exit(0);
		   }
	   }
}
