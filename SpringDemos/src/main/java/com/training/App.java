//test program
package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;

public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	HelloWorld helloBean = (HelloWorld)context.getBean("hello");
    	
    	System.out.println(helloBean.sayHello());
    	
    	OperatorDemo opBean = (OperatorDemo)context.getBean("demo");
    	
    	System.out.println(opBean.getResult(12, 45));
    	
    	
    	
    }
}
