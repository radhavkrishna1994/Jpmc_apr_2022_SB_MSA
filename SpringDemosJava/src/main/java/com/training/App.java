package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.classes.OperatorDemo;
import com.training.config.MyConfiguration;
import com.training.interfaces.Operator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        OperatorDemo op = context.getBean(OperatorDemo.class);
        
        System.out.println(op.getResult(12, 10));
    }
}
