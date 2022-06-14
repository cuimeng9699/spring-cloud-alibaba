package com.example.openfeign.utils;

/**
 * @ClassName HalveSearchUtils
 * @Description 折半查找
 * @Author Mr.Cui
 * @Date 6/8/22 10:26 AM
 */
public class HalveSearchUtils {

    public static void getHalveIndex(Integer [] numArray, Integer key){
        System.out.println("\nKey to be searched=" + key);
        // set first to first index
        int first = 0;
        // set last to last elements in array
        int last = numArray.length - 1;
        // calculate mid of the array
        int mid = (first + last) / 2;
        // while first and last do not overlap
        while (first <= last) {
            // if the mid < key, then key to be searched is in the first half of array
            if (numArray[mid] < key) {
                first = mid + 1;
            } else if (numArray[mid].equals(key) ) {
                // if key = element at mid, then print the location
                System.out.println("Element is found at index: " + mid);
                break;
            } else {
                // the key is to be searched in the second half of the array
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        // if first and last overlap, then key is not present in the array
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }
}
