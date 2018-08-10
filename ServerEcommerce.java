
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.lang.reflect.Proxy;

/**
 * Java RMI Market Server Example
 */

public class ServerEcommerce
{
	public static void main(String args[]){
	
		/*
		 * Try-Catch necessary to handle any problems with the binding of
		 * the server. 
		 */		
		try
		{
			System.out.println("Server Created");
			/*
			 * This is the hostname where we are running the server.
			 * Note: We could also specify the host here - without it, it 
			 * will use the default host: 1099.
			 */
			String name="//in-csci-rrpc01.cs.iupui.edu/ServerEcommerce";
			// Create a new instance of a server.
			//ServerEcommerce ecommerce=new ServerEcommerce (name);
			System.out.println("Server: Binding it to name" +name);
			//new proxyInstance
			Ecommerce assignment = (Ecommerce) Proxy.newProxyInstance(Ecommerce.class.getClassLoader(),
	                      new Class<?>[] {Ecommerce.class},
	                               new AuthorizationInvocationHandler(new ServerImpl()));
			//Binding of the newly created server instance to the RMI Lookup.
			Naming.rebind(name, assignment);
			System.out.println("Server Created");
		}
		//--------------------catch block-----------------------------------------
		     catch (Exception e)
		    {
		    	System.out.println("Server Exception: " + e.getMessage());
				e.printStackTrace();
			}
		
	}
	

}
