package com.yuwar;

import com.yuwar.exception.OutOfRangeException;

public class Validator {
    public static void checkNumberInRange(int userNumber,
                                           int lowerBorder,
                                           int upperBorder) throws OutOfRangeException {
        if (userNumber >= upperBorder || userNumber <= lowerBorder) {
            throw new OutOfRangeException(userNumber
                    + " is out of range "
                    + "]" + lowerBorder + ", " + upperBorder + "[");
        }
    }
}
