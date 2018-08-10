/*
 * Dispatcher class
 * Directs towards the PageFactory and Adminfactory
 * 
 */
public class Dispatcher {
	// @param a
public static AbstractFactory getFactory(String a)
 {
	if(a.equalsIgnoreCase("Customer"))
	{
		return new PageFactory();
	}
	if(a.equalsIgnoreCase("Admin"))
	{
		return new AdminFactory();
	}
	return null;
 }
}
