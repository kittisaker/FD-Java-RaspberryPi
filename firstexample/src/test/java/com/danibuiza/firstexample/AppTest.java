package com.danibuiza.firstexample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        assertTrue( true );
    }

    public void testAppAddition() {
        assertEquals(7, App.addition(3, 4));
    }
     
    public void testAppDivide() {
        assertEquals(8.0, App.divide(80, 10));
    } 
}
