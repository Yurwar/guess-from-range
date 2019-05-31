package com.yuwar.model;

import com.yuwar.exception.OutOfRangeException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ModelTest {
    private Model model;
    private int expectedResult;
    private int userNumber;

    public ModelTest(int userNumber, int expectedResult) {
        this.userNumber = userNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initModel() {
        model = new Model();
        model.initGame(0, 100);
    }

    @Parameterized.Parameters public static Collection<Object[]> numbersValuesTable() {
        return Arrays.asList(new Object[][] {
                {1, -1},
                {70, 1},
                {50, 0}
        });
    }
    @Test
    public void compareUserNumber() throws OutOfRangeException {
        int secretNumber = 50;
        model.setSecretNumber(secretNumber);

        int actual = model.compareUserNumber(this.userNumber);
        int expected = this.expectedResult;

        assertEquals(expected, actual);
    }
}