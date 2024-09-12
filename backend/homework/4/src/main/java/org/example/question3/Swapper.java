package org.example.question3;

import org.example.LoggerFile;

import java.util.*;

public class Swapper {

    private static final LoggerFile log = new LoggerFile();

    /**
     * swap function swaps 2 elements of an array irrespective of their data types
     *
     * @param list
     * @param elementOne
     * @param elementTwo
     * @param <T>
     */
    public static <T> void swap(List<T> list, T elementOne, T elementTwo) {
        int indexOne = list.indexOf(elementOne);
        int indexTwo = list.indexOf(elementTwo);

        if (indexOne == -1 || indexTwo == -1) {
            log.logError("Elements not found in the list.");
            return;
        }

        T temp = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, temp);
    }

    public static void main(String[] args) {

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        log.logInfo("Before swap: " + integerList);

        swap(integerList, 1, 3);
        swap(integerList, 1, 4);

        log.logInfo("After swap: " + integerList);
    }
}
