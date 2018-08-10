import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
 * class AuthorizationInvocationHandler implementing dynamic proxy
 *  @param serialversionUID : version control in a serializable class
 */
public class AuthorizationInvocationHandler implements InvocationHandler, Serializable {
	private static final long serialVersionUID = 6925780928377938176L;
	private Object objectImpl;
 
	public AuthorizationInvocationHandler(Object impl) {
	   this.objectImpl = impl;
	}
	 
	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try
		{
			if (method.isAnnotationPresent(RequiresRole.class)) {
		
			RequiresRole test = method.getAnnotation(RequiresRole.class);
			//System.out.println("You dont have authorization");
			Session session = (Session) args[0];
			
			if (session.getUser().getRoleType().equals(test.value())) {
				 return method.invoke(objectImpl, args);
            } else {
            	throw new AuthorizationException(method.getName());
            }
		} else {
			return method.invoke(objectImpl, args);
		} 
		}
		catch (InvocationTargetException e) {
            throw e.getCause();
        }
	}
}