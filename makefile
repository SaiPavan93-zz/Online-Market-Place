JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \ AbCommand.java \ AbstractFactory.java \ AdminFactory.java \ AdminView.java \ AuthorizationException.java \ AuthorizationInvocationHandler.java \ Command.java \
          \ CommerceClient.java \ Customer.java \ Dispatcher.java \ Ecommerce.java \ FrontController.java \ Invoker.java \ login.java \ MarketView.java \
		  \ PageFactory.java \ PatternAbstract.java \ RequiresRole.java \ ServerEcommerce.java \ ServerImpl.java \ Session.java \ User.java \ UserView.java \ Database.java \
		  \ EmptyCart.java \
	
	
classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class	