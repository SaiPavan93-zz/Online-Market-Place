/*
 * Abstract class it contains abstract method which has no implementation.
 * It is used for the abstract factory  pattern
 */
public abstract class AbstractFactory {
	//Abstract method.
	// @param a
	//AbCommand is the Interface implementing the Abstract Factory Pattern
	//getpage method
 abstract AbCommand getpage(String a);
}
