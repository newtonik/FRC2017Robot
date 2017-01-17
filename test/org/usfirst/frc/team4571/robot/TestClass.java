package org.usfirst.frc.team4571.robot;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author arjunrao87
 *
 */
public class TestClass {
	
	@Test
	public void testIfTrue(){
		Assert.assertTrue(4<5);
	}
	//How to make epoch time to human time
	public static void main( String...strings ){
		TestClass testClass = new TestClass();
		long startTime = System.currentTimeMillis();
		long finishTime = 10000;
		while( System.currentTimeMillis() - startTime <= finishTime ){
			System.out.println("Printing time = " + System.currentTimeMillis() );
		}
		
	}
	
}
