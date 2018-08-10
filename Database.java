import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
/*
 * public class Database
 */
public class Database {

	Connection conn=null;
	int flag=0;
	int flag1=0;
	int flag2=0;
	int stk=0;
	int stk2;
	String name1="";
	String name2="";
	int price=0;
	/*
	 * void databaseConnection method
	 */
	public void databaseConnection()
	{
		String hostname = "localhost:3306";
		String dbName = "saichoud_db";
		String url = "jdbc:mysql://" + hostname + "/" + dbName;
		String username = "saichoud";
		String password = "saichoud";
		System.out.println("Connecting database...");
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = (Connection) DriverManager.getConnection(url, username, password);		
		    	System.out.println("Database connected!");
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e){
       		e.printStackTrace();
		}
	}
	/*
	 * int customerregister()
	 */
   public int customerRegister(String s,String p)
   {
	   if(conn != null) {
			Statement stmt = null;
			//int rs;
			
			try {
				stmt = (Statement) conn.createStatement();
				
				try {
					 stmt.executeUpdate("INSERT INTO Customer VALUES ('"+s+"','"+p+"')");
					
				} catch (SQLException e) {
					System.err.println("Unable execute query!");
					flag=1;
					e.printStackTrace();
				}
				flag=0;
				stmt.close();
				
			}  catch (SQLException e1) {
				System.err.println("Unable to create SQL statement!");
				flag=1;
				e1.printStackTrace();
			}
		}
	   return flag;
   }
   /*
    * customerLogin()
    */
   public  int customerLogin(String s,String p)
   {
	   if(conn != null) {
   		//System.out.println("in conn not null register");
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				//System.out.println(s+""+p);
				stmt =  (Statement) conn.createStatement();
				stmt.executeQuery("SELECT Username,Password from Customer where Customer.Username='"+s+"' and Customer.Password='"+p+"'");
					rs=stmt.getResultSet();
					while (rs.next())  {
				        String Username = rs.getString("Username");
				        String password = rs.getString("Password");
				        System.out.println("username" + Username + "\t" + "password" + password);
				        if(s.equals(Username)&&p.equals(password))
                         {
                               flag1=1;
                         }
				        else
				        {
				        	flag1=0;
				        }
					}
				} catch (SQLException e) {
					flag1=0;
					System.err.println("Unable execute query!");
					e.printStackTrace();
				}
		}
	   return flag1;
   }
   /*
    * int adminLogin
    */
   public  int adminLogin(String s,String p)
   {
	   if(conn != null) {
   		//System.out.println("in conn not null register");
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				//System.out.println(s+""+p);
				stmt = (PreparedStatement) conn.prepareStatement("SELECT * from Admin where Admin.Username=? and Admin.Password=?");
			    stmt.setString(1,s);
			    stmt.setString(2,p);
				try {
					rs = stmt.executeQuery();
					
					while (rs.next())  {
				        String Username = rs.getString("Username");
				        String password = rs.getString("Password");
				        System.out.println("username" + Username + "\t" + "password" + password);
				        if(s.equals(Username)&&p.equals(password))
                         {
                               flag2=1;
                         }
				    }
				} catch (SQLException e) {
					flag2=0;
					System.err.println("Unable execute query!");
					e.printStackTrace();
				}
				
				stmt.close();
				
			} catch (SQLException e1) {
				flag2=0;
				System.err.println("Unable to create SQL statement!");
				e1.printStackTrace();
			}
		}
	   return flag2;
   }
   /*
    * int addAdmin()
    */
   public  int addAdmin(String s3,String p3)
   {
	   flag=0;
	   if(conn != null) {
			Statement stmt = null;
			//int rs;
			
			try {
				stmt = (Statement) conn.createStatement();
				
				try {
					 stmt.executeUpdate("INSERT INTO Admin VALUES ('"+s3+"','"+p3+"')");
					
				} catch (SQLException e) {
					flag=1;
					System.err.println("Unable execute query!");
					e.printStackTrace();
				}
				flag=0;
				stmt.close();
			}  catch (SQLException e1) {
				flag=1;
				System.err.println("Unable to create SQL statement!");
				e1.printStackTrace();
			}
		System.out.println("New admin added");
		
      	
	}
	   return flag;
   }
   /*
    * void updateItems 
    */
      public  void updateItems(String name,int price,int stock)
      {
    	  if(conn != null) {
				Statement stmt = null;
				//int rs;
				
				try {
					stmt = (Statement) conn.createStatement();
					
					try {
						 stmt.executeUpdate("UPDATE Item set Item.Stock=Stock+"+stock+",Item.price="+price+" where Item.Itemname='"+name+"'");
						
					} catch (SQLException e) {
						System.err.println("Unable execute query!");
						e.printStackTrace();
					}
					
					stmt.close();
				}  catch (SQLException e1) {
					System.err.println("Unable to create SQL statement!");
					e1.printStackTrace();
				}
			}
      }
      /*
       * int purchaseItems
       */
      public  int purchaseItems(String query,String name,String username,int stock)
      {
    	  if(conn != null) {
  			Statement stmt = null;
  			Statement stmt1=null;
  			Statement stmt2=null;
  			
  			Statement stmt4=null;
  			Statement stmt5=null;
  			ResultSet rs=null;
  			ResultSet rs1=null;
  			
  			flag=0;
  			//int rs;
  			System.out.println(name);
  			try {
  				stmt = (Statement) conn.createStatement();
  				stmt1=(Statement)conn.createStatement();
  				stmt2=(Statement)conn.createStatement();
  				
  				stmt4=(Statement)conn.createStatement();
  				stmt5=(Statement)conn.createStatement();
  				if(query.equalsIgnoreCase("y"))
  				{
  				try {
  					
  					rs=stmt2.executeQuery("SELECT Stock from Item where Item.Itemname='"+name+"'");
  					while(rs.next())
  					{
  						stk=rs.getInt("Stock");
  					}
  					
  					int i=stk-stock;
  					
  					if(stk>0 && i>=0)
  					{
  					 stmt5.executeQuery("SELECT Item.Itemname,Item.Price from Item where Item.Itemname=('"+name+"')");	
  					 rs1=stmt5.getResultSet();
  					 while(rs1.next())
  					 {
  						  name2=rs1.getString("Itemname");
  						  price=rs1.getInt("Price");
  					 }
  					
  					 stmt.executeUpdate("INSERT INTO Cart(Name,Price,Username,Quantity) VALUES('"+name2+"',"+price+",'"+username+"',"+stock+")");
  					 
  					stmt1.executeUpdate("UPDATE Item SET Stock="+i+" WHERE Itemname='"+name+"'and Stock>= 0");
  					
  				
  					}
  					if(stk==0 && i<0)
  					{
  						//System.out.println("Item is out of stock");
  						flag=2;
  					}
  					
  				}
  				 catch (SQLException e) {
  					flag=1;
  					System.err.println("Unable execute query!");
  					e.printStackTrace();
  				}
  				
  				stmt.close();
  			}
  				else if(query.equalsIgnoreCase("n"))
  				{
  					stmt1.executeUpdate("UPDATE Item SET Stock=Stock WHERE Itemname='"+name+"'and Stock>= 0");
  					flag=3;
  				}
  			}catch (SQLException e1) {
  				flag=1;
  				
  				System.err.println("Unable to create SQL statement!");
  				e1.printStackTrace();
  			}
  		}
		return flag;
      }
      /*
       * void addItem
       */
      public  void addItem(String name, int stock,int price)
      {
    	  int t=0;
  		
			if(conn != null) {
				Statement stmt = null;
				//int rs;
				
				try {
					stmt = (Statement) conn.createStatement();
					
					try {
						 stmt.executeUpdate("INSERT INTO Item VALUES ("+t+",'"+name+"',"+stock+","+price+")");
						
					} catch (SQLException e) {
						System.err.println("Unable execute query!");
						e.printStackTrace();
					}
					
					stmt.close();
				}  catch (SQLException e1) {
					System.err.println("Unable to create SQL statement!");
					e1.printStackTrace();
				}
			}
      }
      /*
       * void deleteItems
       */
      public  void deleteItem(String name)
      {
    	  if(conn != null) {
				Statement stmt = null;
				//int rs;
				
				try {
					stmt = (Statement) conn.createStatement();
					
					try {
						 stmt.executeUpdate("DELETE FROM Item where Item.Itemname='"+name+"'");
						
					} catch (SQLException e) {
						System.err.println("Unable execute query!");
						e.printStackTrace();
					}
					
					stmt.close();
				}  catch (SQLException e1) {
					System.err.println("Unable to create SQL statement!");
					e1.printStackTrace();
				}
	
	                 }
      }
      /*
       * String searchItem
       */
      public  String searchItem(String name)
      {
    	  if(conn != null) {
      		
  			PreparedStatement stmt = null;
  			ResultSet rs = null;
  			
  			try {
  				
  				stmt = (PreparedStatement)conn.prepareStatement("SELECT Itemname,Stock,Price from Item where Item.Itemname=?");
  			    stmt.setString(1,name);
  				//}
  			    //stmt.setString(2,p);
  				try {
  					rs = stmt.executeQuery();
  					
  					while (rs.next())  {
  				         name1 = rs.getString("Itemname");
  				         int stk = rs.getInt("Stock");
  				         int pze = rs.getInt("Price");
  				        //String password = rs.getString("Password");
  				        System.out.println("name" + name1+"stock"+stk+"price"+pze);
  				        return "name" + name1+"stock"+stk+"price"+pze ;
  				    }
  					
  				} catch (SQLException e) {
  					System.err.println("Unable execute query!");
  					e.printStackTrace();
  				}
  				
  				stmt.close();
  				
  			} catch (SQLException e1) {
  				System.err.println("Unable to create SQL statement!");
  				e1.printStackTrace();
  			}
  		}
		return "";
      }
      /*
       * int emptyCart 
       */
      public  int emptyCart(String name,String username)
      {
    	  
    	  flag1=0;
    	  String stk1="";
    	
    	  ResultSet rs;
    	
  			Statement stmt = null;
  			PreparedStatement stmt1=null;;
  			
  			
  			try {
  				stmt1 = (PreparedStatement)conn.prepareStatement("SELECT Username from Cart where Cart.Username=?");
  			    stmt1.setString(1,username);
  				stmt = (Statement)conn.createStatement();
  				
  				try {
  					rs=stmt1.executeQuery();
  					while (rs.next())  {
 				        
 				          stk1 = rs.getString("Username");
 				    }
  					
  					if(!stk1.isEmpty())
  					{
  					 stmt.executeUpdate("DELETE FROM Cart where Cart.name='"+name+"'and Cart.Username='"+username+"'");
  					}
  					else
  					{
  						flag1=2;
  					}
  				} catch (SQLException e) {
  					System.err.println("Unable execute query!");
  					e.printStackTrace();
  				}
  				
  				stmt.close();
  			}  catch (SQLException e1) {
  				System.err.println("Unable to create SQL statement!");
  				e1.printStackTrace();
  			}

                   // }
    	//}
		return flag1;
  		}
      
}
