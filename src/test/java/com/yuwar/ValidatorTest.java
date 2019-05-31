package com.yuwar;

import com.yuwar.exception.OutOfRangeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    @Test(expected = OutOfRangeException.class)
    public void checkNumberInRangeForLowerBorder() throws OutOfRangeException {
        Validator.checkNumberInRange(0, 0, 100);
    }

    @Test(expected = OutOfRangeException.class)
    public void checkNumberInRangeForUpperBorder() throws OutOfRangeException {
        Validator.checkNumberInRange(101, 0, 100);
    }
}