
import java.rmi.Naming;
import java.util.Scanner;
/**
 * Market Client
 */
public class CommerceClient
{
   public static void main(String args[])
     {
	   // Java RMI Security Manager
	   System.setSecurityManager(new SecurityManager());
	   // Try-Catch is necessary for remote exceptions.
	   String name = "//in-csci-rrpc01.cs.iupui.edu/ServerEcommerce";	
	   Ecommerce b=null;
	   Session session = null;
	    try
	      {
		    /*
		    * This is our hostname where our RMI server is running. We
		    * can also specify the port here.
		    * We are going to attempt to locate the server.
		    */
		    b = (Ecommerce) Naming.lookup(name);	
	      }
	          catch(Exception e)
	            {
	               /*
	               * Catch Block if there is an error in locating the server
	               */
		            System.out.println("Client Exception: " + e.getMessage());
	            }
	                  try
	                    { 
                          /* Calling a few  remote methods...  
                          * Implementing the command Pattern,
                          * Front Controller pattern, Abstract factory Pattern
                          */
	                	    FrontController front = new FrontController();
                            login comm=new login(b);    
                            Invoker in=new Invoker();
                            in.sample(comm);
                            in.saas(); 
                            front.AutheticUser(comm.i);
                            front.Dispatchrequest(comm.a);
                            AbstractFactory abs= Dispatcher.getFactory(comm.a);
                            AbCommand cmd=abs.getpage(comm.a);
                            cmd.dispatch(comm.a);
	                     }  	 
     //catch block--------------------------------------------------------------
                           catch (Exception e)
	                        {
	                            System.out.println("OOPS! Enter the details correctly!!");
    	                        e.printStackTrace(); 
                            }
	       // Terminate the program.
	       System.exit(0);
     }
}
