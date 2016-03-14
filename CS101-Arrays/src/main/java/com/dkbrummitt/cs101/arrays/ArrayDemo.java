package com.dkbrummitt.cs101.arrays;

import com.dkbrummitt.cs101.utils.ValidationUtil;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
class ArrayDemo {

    private static final String NOTHING = null;
    private String[] stringArray_;
    
    public ArrayDemo(String... stringArray){
        stringArray_ = stringArray;
    }

    public String access(int ndx) {
        if (ValidationUtil.isAccessible(Arrays.asList(stringArray_), ndx)) {
            return (stringArray_[ndx]);
        }
        return NOTHING;
    }

    public String[] getStringArray() {
        return stringArray_;
    }

    public void setStringArray(String[] stringArray_) {
        this.stringArray_ = stringArray_;
    }

    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
