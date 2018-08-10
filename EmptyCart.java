import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmptyCart implements Callable<Object> {

	Database database=new Database();
	    String a1,b1,c1;
	    int flag;
	    int cart;
 public EmptyCart(String a,String b,String c)
 {
	 database.databaseConnection();
	  a1=a;
		b1=b;
		 c1=c;
		
	 //super();
 }
	@Override
	public Integer call() throws Exception {
		int temp=0;
		try{
		temp=emptyCart(a1,b1,c1);}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return temp;	
	}

	public  int emptyCart( String Query,String name,String username) throws InterruptedException  {
		// TODO Auto-generated method stub
		
	  int temp=0;
	  synchronized(this){
		if(Query.equalsIgnoreCase("y"))
  		{
			 temp=database.emptyCart(name,username);
  		}
		
		//System.out.println("value is"+temp);
	  }
	  return temp;
		
	}
}
