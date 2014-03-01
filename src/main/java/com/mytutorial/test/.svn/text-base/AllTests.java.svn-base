package com.mytutorial.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;
@RunWith(Suite.class)
@Suite.SuiteClasses( {MyTest.class,TestSpreadSheet.class })
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.mytutorial.test");
		//$JUnit-BEGIN$
		
		//$JUnit-END$
		return suite;
	}
	
	 /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
