import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * 
 * @param s,s2,p2,s3,p3
 * @param s1,price,stock
 * @param query,id
 * @param p,query1
 * @param p1
 * @param option
 * @param option2
 * @param count,count1
 */
public class MarketView {
	 String s2="";
	 String p2="";
	 String s3="";
	 String p3="";
	 String s;
	 String s1;
	 String query="";
	 String query1;
	 String query2;
	 String p;
	 String p1;
	 String option="";
	 String option2="";
	 String id="";
	 int price=0;
	 int stock=0;
	 String name ="";
	 int count=0;
	 int count1=0;
	 int stockitem=0;
	 String name1="";
	 Scanner sc=new Scanner(System.in);
	 /*
	  * void method display
	  */
	 void method()
	 {
		 System.out.println("Are you Customer or Admin");
	   	    option=sc.next();
	   	    if(option.equalsIgnoreCase("Customer"))
	   	    {
	   	    	System.out.println("1)Register");
	   	    	System.out.println("2)Login");
	   	    	System.out.println("3)Search");
	   	    	System.out.println("4)Add to Cart");
	   	    	System.out.println("5)Purchase");
	   	    }
	   	 if(option.equalsIgnoreCase("Admin"))
	   	    {
	   	    	System.out.println("Please login to access these functions");
	   	    	System.out.println("1)Add Administrators");
	   	    	System.out.println("2)Update");
	   	    	System.out.println("3)Add");
	   	    	System.out.println("4)Delete");
	   	    	System.out.println("5)Search");
	   	    	 //adminsOption=sc.nextInt();
	   	    }
	 }
	void display ()
	{
		method();
		//System.out.println("Are you Customer or Admin");
   	    //option=sc.next();
   	    if(option.equalsIgnoreCase("Customer"))
   	    {
   	      System.out.println("Do you want to register Y or N");
   	      query=sc.next();
   	      if(query.equalsIgnoreCase("Y"))
   	      {
	      System.out.println("Enter the username");
	      s=sc.next();
	      System.out.println("Enter the pwd");
	      p=sc.next();
   	      }
   	      if(query.equalsIgnoreCase("N"))
   	      {
   	    	System.out.println("Enter the Username and Passphrase to login");
   		    s=System.console().readLine();
   		    p=System.console().readLine();	  
   	      }
   	    }
   	    if(option.equalsIgnoreCase("Admin"))
   	    {
   	    	query="not";
   	    	System.out.println("Enter the Username and Passphrase to login");
   		    s=System.console().readLine();
   		    p=System.console().readLine();
   	    }
	}
	/*
	 * void method registerLogin
	 */
	void registerLogin()
	{
		if(query.equalsIgnoreCase("Y"))
 	      {
	      System.out.println("Enter the username you have just registered");
	      s1=sc.next();
	      System.out.println("Enter the pwd");
	      p1=sc.next();
 	      }
	}
	/*
	 * void method addAdministrator
	 */
	void addAdministrator()
	{
		
		count++;
		s2="";p2="";s3="";p3="";
		
		System.out.println("Enter the Username and Passphrase of Admin to login for adding new Administrator");
		s2=System.console().readLine();
		p2=System.console().readLine();
		if(s2.equals("Pavan") && p2.equals("java@2345"))
		{
		System.out.println("Enter the username for new Admin to login");
	    s3=sc.next();
	    System.out.println("Enter the pwd for Admin\t"+s3);
	    p3=sc.next();
		}
		
		
	}
	
	/*
	 * void method updateItems
	 */
	
	 void updateItems()
	{
		count1++;
		System.out.println("Enter the name of item which is to be updated");
		id=sc.next();
		
		System.out.println("Enter the new Price in dollars($)");
		price=sc.nextInt();
             
		System.out.println("Enter the new stock added in quantity");
		stockitem=sc.nextInt();

	}
	/*
	 * void method purchaseItem
	 */
	void purchaseItem()
	{
		stock=0;
		System.out.println("Enter the name of the product");
		name1=sc.next();
		System.out.println("Enter the stock amount you want to purchase");
		stock=sc.nextInt();
		System.out.println("Do you want to purchase the Item Y/N ?");
		query1=sc.next();
		
	}
	
	void emptyCart()
	{
		query2="";
		System.out.println("Do you want to complete the purchase   Y/N");
		query2=sc.next();
	}
	/*
	 * void method addItem
	 */
	void addItem()
	{
		System.out.println("Enter the name of item which is to be added");
		name=sc.next();
		System.out.println("Enter total Items added to stock");
		stock=sc.nextInt();
		System.out.println("Enter the new Price in dollars($)");
		price=sc.nextInt();
	}
	/*
	 * void method deleteItem
	 */
	void deleteItem()
	{
		System.out.println("Enter the name of item which is to be deleted");
		name=sc.next();
	
	}
	/*
	 * void method searchItem
	 */
	void searchItem()
	{
		System.out.println("Enter the name of the item to be searched");
		name=sc.next();
		}
	
	/*
	 * void method addMoreAdmin
	 */
	void addMoreAdmin()
	{
		System.out.println("Do you want to add more admin---Y/N ?");
		query =sc.next();
		if(query.equalsIgnoreCase("Y"))
		{
			addAdministrator();
		}
		if(query.equalsIgnoreCase("N"))
		{
			System.out.print("only" +count+ "admin added");
		}
	}
	
}
