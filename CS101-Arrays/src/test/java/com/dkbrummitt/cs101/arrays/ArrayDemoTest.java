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
import java.util.Arrays;

/**
 *
 * @author delicia
 */
public class ArrayDemoTest {

    ArrayDemo functionalDemo;
    int functionalTestSize = 5;

    public ArrayDemoTest() {}

    private void initArray(String[] anArray) {
        for (int ndx = 0; ndx < anArray.length; ndx++) {
            anArray[ndx] = Integer.toString(ndx);
        }
    }

    @Before
    public void setUp() {
        String[] functionalArray = new String[functionalTestSize];
        initArray(functionalArray);

        functionalDemo = new ArrayDemo(functionalArray);
    }

    @Test
    public void access_SHOULD_null_WHEN_InvalidIndex() {
        int invalidIndex = -1;
        String expect = null;
        String result = functionalDemo.access(invalidIndex);
        assertEquals("access(int) should return null when invalid index, result=" + result, expect, result);
    }

    @Test
    public void access_SHOULD_ReturnString_WHEN_ValidIndex(){
        int validIndex = 0;
        String expect = Integer.toString(validIndex);
        String result = functionalDemo.access(validIndex);
        assertNotNull("access(int) should not return null when using a valid index and the array element is not null.", result);
        assertEquals("access(int) should return a string equivalent to the index value when valid index, result=" + result, expect, result);
    }

    @Test
    public void insert_SHOULD_ChangeArray_WHEN_ValidIndex(){
      int validIndex = 2;
      String insertValue = "0";
      String[] functionalArrayCopy = new String[functionalTestSize];
      System.arraycopy(functionalDemo.getArray(), 0, functionalArrayCopy, 0, functionalArrayCopy.length);
      functionalDemo.insert(insertValue, validIndex);

      System.out.println("\ninsert_SHOULD_ChangeArray_WHEN_ValidIndex");
      System.out.println("Modified Array");
      ArrayDemo.printArray(functionalDemo.getArray());
      System.out.println("Original Array");
      ArrayDemo.printArray(functionalArrayCopy);

      boolean expectArraysDifferent = !Arrays.deepEquals(functionalDemo.getArray(), functionalArrayCopy);
      boolean expectArrayLonger = (functionalDemo.getArray().length == functionalTestSize + 1);
      boolean expectValueInserted = functionalDemo.getArray()[validIndex] == insertValue;

      assertTrue("insert(String, int) should have changed the array", expectArraysDifferent);
      assertTrue("insert(String, int) should have increased the array length", expectArrayLonger);
      assertTrue("insert(String, int) should have the correct value in at the index", expectValueInserted);
    }

    @Test
    public void insert_SHOULD_ChangeArray_WHEN_Appending(){
      int validIndex = functionalDemo.getArray().length;
      String insertValue = "0";
      String[] functionalArrayCopy = new String[functionalTestSize];
      System.arraycopy(functionalDemo.getArray(), 0, functionalArrayCopy, 0, functionalArrayCopy.length);
      functionalDemo.insert(insertValue, validIndex);

      System.out.println("\ninsert_SHOULD_ChangeArray_WHEN_Appending");
      System.out.println("Modified Array");
      ArrayDemo.printArray(functionalDemo.getArray());
      System.out.println("Original Array");
      ArrayDemo.printArray(functionalArrayCopy);

      boolean expectArraysDifferent = !Arrays.deepEquals(functionalDemo.getArray(), functionalArrayCopy);
      boolean expectArrayLonger = (functionalDemo.getArray().length == functionalTestSize + 1);
      boolean expectValueInserted = functionalDemo.getArray()[validIndex] == insertValue;

      assertTrue("insert(String, int) should have changed the array", expectArraysDifferent);
      assertTrue("insert(String, int) should have increased the array length", expectArrayLonger);
      assertTrue("insert(String, int) should have the correct value in at the index", expectValueInserted);
    }

    @Test
    public void insert_SHOULD_NotChangeArray_WHEN_InvalidIndex(){
      int invalidIndex = -1;
      String insertValue = "0";
      String[] functionalArrayCopy = new String[functionalTestSize];
      System.arraycopy(functionalDemo.getArray(), 0, functionalArrayCopy, 0, functionalArrayCopy.length);
      functionalDemo.insert(insertValue, invalidIndex);

      System.out.println("\ninsert_SHOULD_NotChangeArray_WHEN_InvalidIndex");
      System.out.println("Modified Array");
      ArrayDemo.printArray(functionalDemo.getArray());
      System.out.println("Original Array");
      ArrayDemo.printArray(functionalArrayCopy);

      boolean expectArraysSame = Arrays.deepEquals(functionalDemo.getArray(), functionalArrayCopy);

      assertTrue("insert(String, int) should have NOT changed the array expectArraysSame=" + expectArraysSame, expectArraysSame);
    }
}
