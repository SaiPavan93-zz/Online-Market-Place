
/*
 * RMI Interface for Online Market place Example
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutionException;

public interface Ecommerce extends Remote
{
	String clientDisplay(int g) throws java.rmi.RemoteException;
	int  register(String q,String s,String p) throws java.rmi.RemoteException;
	int loginAfterRegister(String s1,String p1) throws java.rmi.RemoteException;
	@RequiresRole("admin")
	String addAdmin(Session session,String s2,String p2, String s3,String p3) throws java.rmi.RemoteException;
	@RequiresRole("admin")
	String updateItems(Session session,String id,int price,int stock) throws java.rmi.RemoteException;
	@RequiresRole("admin")
	String addItem(Session session,String name,int stock,int price) throws java.rmi.RemoteException;
	@RequiresRole("admin")
	String deleteItem(Session session,String name) throws java.rmi.RemoteException;
	String searchItems(String name) throws java.rmi.RemoteException;
	@RequiresRole("customer")
	String purchaseItems(Session session,String Query,String name,String username,int stock) throws java.rmi.RemoteException;
	@RequiresRole("customer")
	String dispatchRequest(Session session,String Query,String name,String username)throws java.rmi.RemoteException;
	public Session process(String userType) throws RemoteException;
}