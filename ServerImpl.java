import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/*
 * Server Controller ServerImpl
 * @param flag,option2,s2,p2
 * @param serialversionUID : version control in a serializable class
 */
public class ServerImpl extends UnicastRemoteObject implements Ecommerce {
	
	int flag=0;
	String option2;
	String s2;
	String p2;
    String query="";
   
   // ServerImpl obj=new ServerImpl();
    	//Connection conn=null;
  
	private static final long serialVersionUID = -5485952710128132535L;
	
	Database database=new Database();
	protected ServerImpl() throws RemoteException {
		database.databaseConnection();
	}


	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#clientDisplay(int)
	 */
	
	
	public synchronized String clientDisplay(int g) throws RemoteException {
		// TODO Auto-generated method stub
		
		if(g==0)
   	 {
  		          return "Successfully registered"+" "+" User Successfully Logged in";
  	         
   	 }
   	 if(g==1)
   	 {
   		 return "User Successfully Logged in";
   	 }
   	 if(g==2)
   	 {
   		 return "Enter correctly";
   		
   	 }
   	if(g==3)
  	 {
  		 return "Welcome Admin"+"  "+ "Admin Logged in";
  		 
  	 }
   	 return "";
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#register(java.lang.String, java.lang.String, java.lang.String)
	 */
	public synchronized int register(String option,String s,String p)
	{
		//System.out.print("control in serverimpl");
		option2=option;
		s2=s;
		p2=p;
		/*query="INSERT INTO Customer (Username,Password) VALUES (s,p);";*/
	      
	      if(option.equalsIgnoreCase("Y") && s.length()!=0 &&p.length()!=0)
		    {
	    	      int temp=database.customerRegister(s, p);
	    	      if(temp==1)
	    	      {
	              System.out.println("Successfully registered");
	              flag=0;
	    	      }
		    }
	      //query="";
	       //query="SELECT * from Customer where Customer.Username='"+s+"' and Customer.Password='"+p+"'";
	      
		   if(option.equalsIgnoreCase("N"))
		   {
			   int temp=database.customerLogin(s, p);
			   if (temp==1)
				{
				   //flag=0;
				   System.out.println("Logged in");
				   flag=1;
				}
			   else
				{
					System.out.print("name and pwd donot match");
				    flag=2;
				   
				}
		   }
		   if((option.equals("not")))
	       {
			   int temp=database.adminLogin(s, p);
		   if(temp==1 )
		   {
			   System.out.println("Welcome Admin");
			   flag=3;
		   }
		   else
			{
				System.out.print("name and pwd donot match");
			    flag=2;
			    
			}
		   }
		   
	 return flag;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#loginAfterRegister(java.lang.String, java.lang.String)
	 */
	public synchronized int loginAfterRegister(String s1,String p1)
	{
		
		if(s1.equals(s2) &&p1.equals(p2) )
	    {
              
              flag=0;
              //System.out.println("Enter correctly");
	    }
		else if (!s1.equals(s2) || !p1.equals(p2))
		{
			flag=2;
			System.out.println("Enter correctly");
		}
		else
		{
			flag=2;
			System.out.println("Enter correctly");
		}
		return flag;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#addAdmin(Session, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public synchronized String addAdmin(Session session,String s2, String p2, String s3, String p3) throws RemoteException {
		// TODO Auto-generated method stub
		if(s2.equals("Pavan") && p2.equals("java@2345"))
		{
			int temp=database.addAdmin(s3, p3);
			if(temp==1)
			{
			return "New admin added";
			}
			return "";
			}
		
		else
		{
			System.out.println("Please login as admin or enter correct credentials");
			return "Please login as admin or enter correct credentials";
		}
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#process(java.lang.String)
	 */
	public Session process(String userType) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = new Session(userType);
		return session;
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#updateItems(Session, int, int, int)
	 */
	public synchronized String updateItems(Session session, String name,int price,int stock) throws RemoteException {
		// TODO Auto-generated method stub
		
			database.updateItems(name,price, stock);
		
		System.out.println("The price of the Item and stock is changed to  "+ price+ stock);
			return "The price of the Item and stock is changed to  "+ price+ stock;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#purchaseItems(Session)
	 */
	public synchronized String purchaseItems(Session session,String Query,String name,String username,int stock) throws RemoteException {
		// TODO Auto-generated method stub
		int temp=0;
		System.out.println(username);
		synchronized(this){
		temp=database.purchaseItems(Query,name,username,stock);
		}
		
		if(temp==2){
			System.out.println("Item is out of stock");
			return "Item is out of stock";
		}
		else if(temp==1)
		{
		System.out.println("error");
		return "error";
		}
		else if(temp==0)
		{
			System.out.println("Item added to cart");
			return "Item added to cart"; 
		}
		else if(temp==3)
		{
			System.out.println("Item added to inventory");
			return "Item added to inventory"; 
		}
		
		return "";
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#addItem(Session, java.lang.String, int)
	 */
	public synchronized String addItem(Session session, String name, int stock,int price) throws RemoteException {
		// TODO Auto-generated method stub
		database.addItem(name, stock, price);
		System.out.println("Item"+name+"is added");
		System.out.println("Total stock added is" +(stock));
		return "Total stock added is" +(stock);
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#deleteItem(Session, java.lang.String, int)
	 */
	public synchronized String deleteItem(Session session, String name) throws RemoteException {
		// TODO Auto-generated method stub
		       database.deleteItem(name);
				System.out.println("Item deleted is" +(name));
				return "Item deleted is" +(name);
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#searchItems(java.lang.String)
	 */
	public synchronized String searchItems(String name) throws RemoteException {
		// TODO Auto-generated method stub
		String get=database.searchItem(name);
		return get;
	}


	@Override
	/*
	 * (non-Javadoc)
	 * @see Ecommerce#dispatchRequest(Session, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String dispatchRequest(Session session,  String Query, String name,String username) throws RemoteException {
		// TODO Auto-generated method stub
		EmptyCart mycart=new EmptyCart(Query,name,username);
		 ExecutorService threadpool = Executors.newFixedThreadPool(3);
		 Future<?> future = threadpool.submit(mycart);
		 while (!future.isDone()) {
	           // System.out.println("Task is not completed yet....");
	            try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //sleep for 1 millisecond before checking again
	        }
		
			 //notifyAll();
			 int emptyCart = 0;
			try {
				emptyCart = (Integer)future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //System.out.println("number is in dispatchRequest : "+emptyCart);

		        threadpool.shutdown();
			 if(emptyCart==0){
			 System.out.println("Congrats "+username+"\t"+name+"purchased");
			 return "Successfully purchased Congrats "+username+"\t"+name+"purchased";
			 }
			 else if(emptyCart==2){
				 System.out.println("Item not added to cart as it is out of stock");
				 return"Item not added to cart as it is out of stock";
			 }
		 
		return "";
	}

}