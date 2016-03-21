package com.dkbrummitt.cs101.arrays;

import com.dkbrummitt.cs101.utils.ValidationUtil;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
class ArrayDemo {

    private static final String NOTHING = null;
    private String[] stringArray_;

    public static enum CodeStyle {

        old_skool,
        enhanced,
        java8
    };

    public ArrayDemo(String... stringArray) {
        stringArray_ = stringArray;
    }

    public String[] getArray(){
      return stringArray_;
    }

    public String access(final int ndx) {
        if (ValidationUtil.isAccessible(Arrays.asList(stringArray_), ndx)) {
            return (stringArray_[ndx]);
        }
        return NOTHING;
    }

    public void insert(final String aValue, final int ndx) {
      if (!ValidationUtil.isAccessible(Arrays.asList(stringArray_), ndx)
        && !ValidationUtil.isBetween(0, stringArray_.length, ndx)) {
        return;//quit early, nothing to do here.
      }
        String[] newStringArray = new String[stringArray_.length + 1];

        System.arraycopy(stringArray_, 0, newStringArray, 0, ndx);
        newStringArray[ndx] = aValue;
        System.arraycopy(stringArray_, ndx, newStringArray, ndx + 1, newStringArray.length - (ndx+1));

        stringArray_ = newStringArray;
    }

    public void delete(final int ndx) {
      if (!ValidationUtil.isAccessible(Arrays.asList(stringArray_), ndx)) {
        return;//quit early, nothing to do here.
      }

        String[] newStringArray = new String[stringArray_.length - 1];

        System.arraycopy(stringArray_, 0, newStringArray, 0, ndx - 1);
        System.arraycopy(stringArray_, ndx + 1, newStringArray, ndx, stringArray_.length);

        stringArray_ = newStringArray;
    }

    public void swap(String[] anArray, int a, int b) {
        String aValue = anArray[a];
        anArray[a] = anArray[b];
        anArray[b] = aValue;
    }

    public int searchOldSkool(String aValue) {
        int index = -1;

        for (int ndx = 0; ndx < stringArray_.length; ndx++) {
            if (aValue == stringArray_[ndx]) {
                return ndx;
            }
        }

        return index;
    }

    public int searchEnhanced(String aValue) {
        throw new IllegalArgumentException("You can't return an index using enhanced for loops...well, with Java anyway");
    }

    public int searchLambda(String aValue) {
        int index = -1;

        OptionalInt optional = IntStream.range(0, stringArray_.length).filter(ndx -> stringArray_[ndx] == aValue).findFirst();
        if (optional.isPresent()) {
            index = optional.getAsInt();
        }

        return index;
    }

    public int searchRealWord(String aValue) {
        return Arrays.asList(stringArray_).indexOf(aValue);
    }

    public boolean search(String aValue, CodeStyle style) {
        boolean found = false;

        return found;
    }

    public String[] getStringArray() {
        return stringArray_;
    }

    public void setStringArray(final String[] stringArray_) {
        this.stringArray_ = stringArray_;
    }

    public String[] quickSort(String[] input, int high, int low) {
        String[] results = input;
        if (input == null) {
            results = stringArray_;
        }
        if (low < high) {
            int partition = quickSortPartition(results, high, low);
            results = quickSort(results, high, partition + 1);
            results = quickSort(results, partition - 1, low);
        }
        return results;
    }

    public int quickSortPartition(String[] input, int high, int low) {
        int partition = low;
        String pivot = input[high];
        for (int ndx = low; ndx < high; ndx++) {
            if (input[ndx].compareTo(pivot) < 0) {
                //outreach e .org
                swap(input, partition, ndx);
                partition = partition + 1;
            }
        }

        return partition;
    }

    public static void printArray(final String[] anArray){
      StringBuilder state = new StringBuilder();
      state.append("[");
      state.append(String.join(",", anArray));
      state.append("]");
      System.out.println(state);
    }
}
