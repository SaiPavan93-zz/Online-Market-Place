/*
 * Implementing Abstract Interface 
 * It directs towards the customer page
 */
public class Customer implements AbCommand  {
	//instantiating Userview object.
	UserView user;
	/*
	  * Constructor
	  * @param newuser
	  */
	    Customer(UserView newuser)
	   {
		   user=newuser;
	   }
	 @Override
 /*
 * 
 * (non-Javadoc)
 * @see AbCommand#dispatch(java.lang.String)
 */
	 // @param request
	 //void method dispatch
	   public void dispatch(String request)
	   {
		   if(request.equalsIgnoreCase("Customer"))
		   {
			   user.showView();
		   }
		   else
		   {
			   System.out.println("Enter only specified options");
		   }
	   }

}


