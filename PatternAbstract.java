/*
 * Implementing Abstract Interface 
 * 
 */
public class PatternAbstract implements AbCommand {

	 private AdminView admin;
	 /*
	  * Constructor
	  * @param newadmin
	  */
	 public PatternAbstract(AdminView newadmin)
	   {
		   admin=newadmin;
	   }
	@Override
	/*
	 * (non-Javadoc)
	 * @see AbCommand#dispatch(java.lang.String)
	 */
	// @param request
	public void dispatch(String request) throws Exception {
		// TODO Auto-generated method stub
		{
			   
			    if(request.equalsIgnoreCase("Admin"))
			   {
				   admin.showView();
			   }
			   else
			   {
				   System.out.println("Enter only specified options");
			   }
		   }
	}

}
