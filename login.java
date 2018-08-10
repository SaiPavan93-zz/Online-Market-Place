
import java.rmi.RemoteException;
import java.util.concurrent.*;
/**
 * Concrete Command Class
 * @param a
 * @param y
 * @param i
 */
public class login implements Command{
	String a;
	String y;
	int i;
	 Ecommerce newEcommerce;
	MarketView sd=new MarketView();
	/**
	 * Constructor
	 * @param ecommerce
	 */
	login(Ecommerce ecommerce)
	{
		newEcommerce=ecommerce;
		
	}
	
	/**
	 * Execute Command Method
	 */
	@Override
	/*
	 * 
	 * (non-Javadoc)
	 * @see Command#execute()
	 */
	public void execute() {
		
		 
		 String b;
		
		 Session session;
		// TODO Auto-generated method stub
		try {
		 sd.display();
		 sd.registerLogin();
		 a=sd.option;
		 if(sd.query.equalsIgnoreCase("y"))
		 {
			i=newEcommerce.register(sd.query,sd.s,sd.p);
			i=newEcommerce.loginAfterRegister(sd.s1,sd.p1);
			y=newEcommerce.clientDisplay(i);
			System.out.println(y);
			
		 }
		 if(sd.query.equalsIgnoreCase("N")||sd.query.equalsIgnoreCase("not"))
		 {
			 i=newEcommerce.register(sd.query,sd.s,sd.p);
			 y=newEcommerce.clientDisplay(i);
			 System.out.println(y);
			 if(i==2)
			 {
				 System.exit(0);
			 }
		 }
		 
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Client Exception: " + e.getMessage());
		}
		outer:
		try{
			System.out.println("\n\n Adding a new ADMINISTRATOR----->Only Admin can do");
			session=newEcommerce.process(a);
			if(a.equalsIgnoreCase("admin") && sd.s.equals("Pavan") && sd.p.equals("java@2345"))
			{
			sd.addAdministrator();
			if(sd.s2.equals("Pavan") && sd.p2.equals("java@2345"))
			{
			b=newEcommerce.addAdmin(session,sd.s2, sd.p2, sd.s3, sd.p3);
		    System.out.println(b);
		   
			}
			else
			{
				System.out.println("Admin credentials Invalid");
				System.exit(0);
			}
			}
			else if(a.equalsIgnoreCase("customer"))
			{
				session=newEcommerce.process(a);
				System.out.println("User cant add administrators");
				b=newEcommerce.addAdmin(session,sd.s2, sd.p2, sd.s3, sd.p3);
			    System.out.println(b);
			}
			else
			{
				System.out.println("Admin credentials Invalid");
				System.exit(0);
			}
			System.out.println("Do you want to continue adding more admins----Y/N?");
			String query=System.console().readLine();
			while((!(query.equalsIgnoreCase("n"))) && (!(sd.query.equalsIgnoreCase("n"))) && !(a.equalsIgnoreCase("customer")))
			{
				if((query.equalsIgnoreCase("n") || sd.query.equalsIgnoreCase("n")))
				{
					break outer;
				}
			
				else if((query.equalsIgnoreCase("y")))
			{
				
				 sd.addMoreAdmin();
				 
				
				    if(sd.s2.equals("Pavan") && sd.p2.equals("java@2345"))
					{
					b=newEcommerce.addAdmin(session,sd.s2, sd.p2, sd.s3, sd.p3);
				    System.out.println(b);
				  
					}
			}
				    else
					{
						System.out.println("Admin credentials Invalid");
						System.exit(0);
					}
				
				 
			}	    
		} catch(Exception e){
			// TODO Auto-generated catch block
			System.out.println("You dont have authorization");
			System.out.println("Client Exception: " + e.getMessage());
		}
		outer1:
		try{
			System.out.println("\n\n For UPDATING ITEMS----->Only Admin can do");
			session=newEcommerce.process(a);
			if(a.equalsIgnoreCase("admin"))
			{
			sd.updateItems();
			//int stock=45;
			b=newEcommerce.updateItems(session, sd.id, sd.price, sd.stockitem);
			System.out.println(b);
			}
			else if(a.equalsIgnoreCase("customer"))
			{
				session=newEcommerce.process(a);
				System.out.println("User cant update details");
				b=newEcommerce.updateItems(session, sd.id, sd.price, sd.stock);
				System.out.println(b);
				
			}
		   }
		    catch(Exception e){
		    	// TODO Auto-generated catch block
			     System.out.println("You dont have authorization");
			     System.out.println("Client Exception: " + e.getMessage());
		         }
		
		try{
			System.out.println("\n\n For ADDING ITEMS----->Only Admin can do");
			session=newEcommerce.process(a);
			if(a.equalsIgnoreCase("admin"))
			{
			sd.addItem();
			b=newEcommerce.addItem(session, sd.name,sd.stock,sd.price);
			System.out.println(b);
			}
			else if(a.equalsIgnoreCase("customer"))
			{
				session=newEcommerce.process(a);
				System.out.println("User cant add Items");
				b=newEcommerce.addItem(session, sd.id,sd.stock,sd.price);
				System.out.println(b);
				
			}
		   }
		    catch(Exception e){
		    	// TODO Auto-generated catch block
			     System.out.println("You dont have authorization");
			     System.out.println("Client Exception: " + e.getMessage());
		         }
		
		try{
			System.out.println("\n\nFor Searching ITEMS----->Admin and  customer can do");
			sd.searchItem();
			b=newEcommerce.searchItems(sd.name);
			System.out.println(b);
		}
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Client Exception: " + e.getMessage());
			}
		
		try{
			System.out.println("\n\nFor Purchasing ITEMS----->Only customer can do");
			
			session=newEcommerce.process(a);
			if(a.equalsIgnoreCase("customer")){
			sd.purchaseItem();
			if(sd.query1.equalsIgnoreCase("y") && a.equalsIgnoreCase("customer"))
			{
			
			System.out.println("THANK YOU!!!!");	
			//sd.emptyCart();
			b=newEcommerce.purchaseItems(session,sd.query1,sd.name1,sd.s,sd.stock);
			
			System.out.println(b);
			session=newEcommerce.process(a);
			sd.emptyCart();
			b=newEcommerce.dispatchRequest(session, sd.query2, sd.name1, sd.s);
			System.out.println(b);
			}
			else if(sd.query1.equalsIgnoreCase("N") && a.equalsIgnoreCase("customer"))
			{
				b=newEcommerce.purchaseItems(session,sd.query1,sd.name1,sd.s,sd.stock);
				System.out.println("Cart is empty");
			}
			}
			else
			{
				System.out.println("Admin cant purchase");
				session=newEcommerce.process(a);	
				b=newEcommerce.purchaseItems(session,sd.query1,sd.name,sd.s,sd.stock);
			}
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			System.out.println("You dont have authorization");
			e.printStackTrace();
			System.out.println("Client Exception: " + e.getMessage());
		}
		
		/*try{
               System.out.println("\n\nFor completing Purchasing ----->Only customer can do");
			
			   session=newEcommerce.process(a);
			   sd.emptyCart();
			   if(sd.query1.equalsIgnoreCase("y"))
			   {
				   b=newEcommerce.emptyCart(session, sd.query1,sd.name1,sd.s);
				   System.out.println(b);
				}
			   else
			   {
				   System.out.println("Items are present in cart");
			   }
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			System.out.println("You dont have authorization");
			System.out.println("Client Exception: " + e.getMessage());
		}*/
		
		try{
			System.out.println("\n\n For DELETING ITEMS----->Only Admin can do");
			session=newEcommerce.process(a);
			if(a.equalsIgnoreCase("admin"))
			{
			sd.deleteItem();
			b=newEcommerce.deleteItem(session, sd.name);
			System.out.println(b);
			}
			else if(a.equalsIgnoreCase("customer"))
			{
				session=newEcommerce.process(a);
				System.out.println("User cant delete Items");
				b=newEcommerce.deleteItem(session, sd.name);
				System.out.println(b);
				
			}
		   }
		    catch(Exception e){
		    	// TODO Auto-generated catch block
			     System.out.println("You dont have authorization");
			     System.out.println("Client Exception: " + e.getMessage());
		         }
	}

}
