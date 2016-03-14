/*
 * The MIT License
 *
 * Copyright 2016 delicia.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.dkbrummitt.cs101.arrays;

import com.dkbrummitt.cs101.utils.GeneratorUtil;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author delicia
 */
public class ArrayDemoTest {

    ArrayDemo functionalDemo;
    ArrayDemo performanceDemo;
    int functionalTestSize = 5;
    int performanceTestSize = 1000;
    int stringSize = 10;

    public ArrayDemoTest() {
    }

    private void initArray(String[] anArray) {

        for (int ndx = 0; ndx < anArray.length; ndx++) {
            anArray[ndx] = GeneratorUtil.randomString(stringSize);
        }
    }

    @Before
    public void setUp() {
        String[] functionalArray = new String[functionalTestSize];
        String[] performanceArray = new String[performanceTestSize];
        initArray(functionalArray);
        initArray(performanceArray);
        System.out.println("performanceArray[1]=" + performanceArray[1]);
        System.out.println("functionalArray[1]=" + functionalArray[1]);

        performanceDemo = new ArrayDemo(performanceArray);
        functionalDemo = new ArrayDemo(functionalArray);

    }

    @Test
    public void access_functional_SHOULD_null_WHEN_InvalidIndex() {
        int invalidIndex = -1;
        String expect = null;
        String result = functionalDemo.access(invalidIndex);
        assertEquals("acccess() should return null when invalid index, result=" + result, expect, result);
    }

    @Test
    public void access_performance_SHOULD_constant_WHEN_validIndex() {
        int validIndex = 15;
        String expect = null;
        String result = performanceDemo.access(validIndex);
        assertNotEquals("acccess() should return NOT return null when valid index, result=" + result, expect, result);
    }

}
