import java.io.Serializable;
/*
 * class Session 
 * @param serialversionUID : version control in a serializable class
 */
public class Session implements Serializable {
	private static final long serialVersionUID = -6745473220581903527L;
	
	private User user;
	
	public Session(String userType) {
		user = new User(userType);
	}
	
	public User getUser() {
		return user;
	}
}