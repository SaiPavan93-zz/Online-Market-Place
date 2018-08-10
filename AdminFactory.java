//Abstract factory created for Admin
/* 
 * Admin factory is the abstract factory for administrators
 * It directs towards the PatternAbstract to get the desired page
 * It extends the AbstractFactory which is an abstract class
*/

public class AdminFactory extends AbstractFactory {
	//@param a
	//getpage method [AbstractFactory Method]
	AbCommand getpage(String a) {
		// TODO Auto-generated method stub
		AdminView admin=new AdminView();
		if(a.equals(null))
		{
		   return null;
		}
		 if(a.equalsIgnoreCase("Admin"))
		   {
			   
			   return new PatternAbstract(admin);
		   }
		return null;
	}
}
