package in.ashokit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.beans.TokenGenerator;

public class Test {

	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// after above line only our object will be created(only for singleton scope) no need to mention below lines also as we defined constructor in class we can see that here
		// to get different object for every getBean call define scope as prototype in Xml file
		TokenGenerator t1 = context.getBean(TokenGenerator.class);
		System.out.println(t1.hashCode());
		
		
		TokenGenerator t2= context.getBean(TokenGenerator.class);
		System.out.println(t1.hashCode());// this way only one object is created and all other declarations are mapped to this object
		// when we configure our java class as spring bean by default the scope will be singleton(only  one object will be created and all other declarations are mapped to this object only)
	// if we call our class without configuring our class as spring bean we get a NOSuchBeanDefination exception 
	}
	
}
