package com.sortingalgos.SortingAlgorithmssApplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;


@Component //1
public class SortingService {
    public String sortingGenericMethod(List<Integer> unsorted_ints, String scriptPath) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("python", scriptPath);
        Process sortingProcess = pb.start();

        String inputString = unsorted_ints.stream()
                                          .map(x -> String.valueOf(x))
                                          .collect(Collectors.joining(","));
        
        System.out.println("Sending input to Python script: " + inputString);
        
        PrintWriter writer = new PrintWriter(sortingProcess.getOutputStream());
        writer.println(inputString);
        writer.flush();

        String sorted_ints = new BufferedReader(new InputStreamReader(sortingProcess.getInputStream())).readLine();
        System.out.println("Received output from Python script: " + sorted_ints);
        return sorted_ints;

    }

    public String bubbleSort(List<Integer> unsorted_ints) throws IOException{
        return sortingGenericMethod(unsorted_ints, "./sorting-algos-python/bubble_sort.py");
    }

    public String insertionSort(List<Integer> unsorted_ints) throws IOException{
        return sortingGenericMethod(unsorted_ints, "./sorting-algos-python/insertion_sort.py");
    }

    public String mergeSort(List<Integer> unsorted_ints) throws IOException{
        return sortingGenericMethod(unsorted_ints, "./sorting-algos-python/merge_sort.py");
    }

    public String quickSort(List<Integer> unsorted_ints) throws IOException{
        return sortingGenericMethod(unsorted_ints, "./sorting-algos-python/quick_sort.py");
    }
    
    public String selectionSort(List<Integer> unsorted_ints) throws IOException{
        return sortingGenericMethod(unsorted_ints, "./sorting-algos-python/selection_sort.py");
    }


}


   
