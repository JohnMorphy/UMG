package com.company;

public class BinarySearch {
    public static int Search(int [] list, int value)
    {
        int middle;
        int fromPosition=0;
        int toPosition=list.length;
        while(!(fromPosition>toPosition)) {
            middle = fromPosition + (toPosition - fromPosition) / 2;
            if (value < list[middle])
                toPosition = middle - 1;
            else if (value > list[middle])
                fromPosition = middle + 1;
            else {
                System.out.println("value " + value + " was found on " + middle + " index of the sorted list");
                return middle;
            }
        }
        System.out.println("there is no such value on this list");
        return -1;
    }
}
