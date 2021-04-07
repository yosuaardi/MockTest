package org.mockExample;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CarMockTest {
    private Car myCar = mock(Car.class);

    @Test
    public void testIfCarMyCarIsCar(){
        assertTrue(myCar instanceof Car);
    }

    @Test
    public void testDefaultValueOfMyCar(){
        assertFalse("my car need fuel", myCar.needsFuel());
        assertEquals("my car engine temperature should be 0.0", 0.0, myCar.getEngineTemperature(), 1e-15);
    }

    @Test
    public void testStubbing(){
        assertFalse("my car don't need fuel", myCar.needsFuel());
        when(myCar.needsFuel()).thenReturn(true);
        assertTrue("my car need fuel", myCar.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void testMyCarHaveException(){
        when(myCar.needsFuel()).thenThrow(new RuntimeException());
        myCar.needsFuel();
    }

    @Test
    public void verifyThatMockMethodBeingCalled(){
        myCar.driveTo("Sweet Campus UKDW");
        myCar.needsFuel();
        verify(myCar).driveTo("Sweet Campus UKDW");
        //any akan mengabaikan value dari input param,
        //hanya fokus pada ada atau tidaknya input param saja
//        verify(myCar).driveTo(any()); //any input selama string
        verify(myCar).needsFuel();
    }

    @Test
    public void testVerificationFailure(){
        myCar.needsFuel();
        verify(myCar).getEngineTemperature();
    }

    @Test
    public void testVerificationFailureArguments(){
        myCar.driveTo("Sweet CampusUKDW");
        verify(myCar).driveTo("Home Sweet Home");
    }


}
