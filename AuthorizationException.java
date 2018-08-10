/*
 * AuthorizationException class 
 * @param serialversionUID : version control in a serializable class
 */
public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 5528415690278423524L;
// @param methodName
// method AuthorizationException: Deny access if invalid authorization.
	public AuthorizationException(String methodName) {
		super("Invalid Authorization - Access Denined to " + methodName + "() function!");
	}
}