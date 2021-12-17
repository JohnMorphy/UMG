package com.company;

public class Main {
    public static void main(String[] args) {

        int list[] = {6,11,43,15,16,1,2,166,8,11,4,55,22,15,2};
        int auxList[] = new int[list.length];

        BinaryNumbers.PrintList(list);
        MergeSort.MergeSortExecute(list, auxList);
        BinaryNumbers.PrintList(list);
        int x = 3;
        int n=BinarySearch.Search(list, x);
    }
}