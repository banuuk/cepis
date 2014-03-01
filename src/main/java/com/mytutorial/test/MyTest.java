package com.mytutorial.test;


import java.util.Arrays;

import org.junit.Test;

import com.mytutorial.test.SpreadSheet.CircularReferenceException;

public class MyTest extends TestCase{


	@Test
	 public void testRPN() {
        SpreadSheet sp = new SpreadSheet(2,2,
                "10 1 1 + / 1 +", "A1 A2 +",
                "10 2 3 + / 4 5 + *", "A1 B1 +"
        );
        Double[] result = sp.dump();
        assertEqualWithin(1e-4, new Number[]{
                6, 24,
                18, 30
        }, result);
    }
	
	@Test
    public void testCircular() {
        SpreadSheet sp = new SpreadSheet(3,3,
                "B1",       "C1", "A2",
                "B2",       "C2", "A3",
                "B3",		"C3",	"A1"
        );
        try {
            sp.dump();
        } catch (CircularReferenceException e) {
            return; // good
        }
        fail("should fail for circular reference");
    }
	
	public void assertEqualWithin(double precision, Number[] expected, Number[] actual) {
        if (expected == null) {
            if (actual != null) fail("expected null, actual "+Arrays.toString(actual));
            return;
        }
        if (actual == null) fail("expected "+Arrays.toString(expected)+", actual is null");
        if (expected.length != actual.length) fail("expected "+Arrays.toString(expected)+", actual is "+Arrays.toString(actual)+" (different length)");
        for (int i=0; i<expected.length; i++) {
            if (expected[i] == null) {
                if (actual[i] != null) fail("expected "+Arrays.toString(expected)+", actual is "+Arrays.toString(actual)+" (element "+i+" is not null)");
            } else {
                double diff = Math.abs(expected[i].doubleValue() - actual[i].doubleValue());
                if (diff > precision)
                    fail("expected "+Arrays.toString(expected)+", actual is "+Arrays.toString(actual)+" (element "+i+" is too different)");
            }
        }
    }

}
