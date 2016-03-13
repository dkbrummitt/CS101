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
package com.dkbrummitt.cs101.utils;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;

/**
 *
 * @author delicia
 */
public class ValidationUtil {

    private ValidationUtil() {
        //prevent instantiation. 
    }

    public static boolean isNullOrEmpty(Object anObject) {
        boolean nill = false;
        boolean empty = false;
        String aString;
        Collection aCollection;
        Map aMap;
        Enumeration anEnumeration;
        Dictionary aDictionary;

        if (anObject == null) {
            nill = true;
        } else {
            if (anObject instanceof Collection) {
                aCollection = Collection.class.cast(anObject);
                empty = aCollection.isEmpty();
            } else if (anObject instanceof String) {
                aString = String.class.cast(anObject);
                empty = aString.isEmpty();
            } else if (anObject instanceof Map) {
                aMap = Map.class.cast(anObject);
                empty = aMap.isEmpty();
            } else if (anObject instanceof Enumeration) {
                anEnumeration = Enumeration.class.cast(anObject);
                empty = !anEnumeration.hasMoreElements();
            } else if (anObject instanceof Dictionary) {
                aDictionary = Dictionary.class.cast(anObject);
                empty = aDictionary.isEmpty();
            }
        }
        return nill || empty;
    }

    public static boolean isBetween(int a, int b, int value) {
        boolean between;
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        between = value >= min && value <= max;

        return between;
    }

    public static boolean isAccessible(Collection aCollection, int ndx) {
        boolean accessible = false;
        if (!isNullOrEmpty(aCollection) && isBetween(0, aCollection.size() - 1, ndx)) {
            return accessible;
        }
        return accessible;
    }
}
