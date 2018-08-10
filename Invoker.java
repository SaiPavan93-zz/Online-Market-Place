import java.util.List;
import java.util.ArrayList;

/**
 * Invoker Object
 * ArrayList of type Command is implemented.
 */

public class Invoker {
  List<Command> orderList = new ArrayList<Command>();
  /**
	 * Given a command request take the command.
	 * 
	 * @param com
	 */
  public void sample(Command com)
  {
	  orderList.add(com);
  }
  /**
	 * Execute each command that has been taken.
	 */
  public void saas()
  {
	for(Command com : orderList){
      com.execute();
  }
	orderList.clear();
  }
}