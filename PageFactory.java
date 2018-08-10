/*
 * PageFactory is the abstract factory for customers
 * It directs towards the Customer to get the desired page
 * Extends abstract class and also the method in it.
 * @param a
 */

public class PageFactory extends AbstractFactory {

	@Override
	/*
	 * (non-Javadoc)
	 * @see AbstractFactory#getpage(java.lang.String)
	 */
	AbCommand getpage(String a) {
		// TODO Auto-generated method stub
		UserView user=new UserView();
		
		if(a.equals(null))
		{
		   return null;
		}
		 
		 if(a.equalsIgnoreCase("Customer"))
		 {
			 return new Customer(user);
		 }
		return null;
	}

}
