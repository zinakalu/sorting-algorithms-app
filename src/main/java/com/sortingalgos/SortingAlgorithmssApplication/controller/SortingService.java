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


    // public String bubbleSort(List<Integer> unsorted_ints) throws IOException { //2
    //     ProcessBuilder pb = new ProcessBuilder("python", "./sorting-algos-python/bubble_sort.py"); //same as what we use to run the file in python //3
    //     Process sortingProcess = pb.start(); //4

       //Converting list of integers to a comma-separated string 
    //     String inputString = unsorted_ints.stream() //the stream method is used to transform the elements of a list
    //                                       .map(String::valueOf) //equals .map(x -> String.valueOf(x)) and used to transform each element in the stream, here it converts each integer into a string.
    //                                       .collect(Collectors.joining(",")); //collects all the strings into a single string, separated by commas
    //     System.out.println("Sending input to Python script: " + inputString);                                  
        
        //write the string to the process's output stream //5
    //     PrintWriter writer = new PrintWriter(sortingProcess.getOutputStream()); 
    //     writer.println(inputString); //writes 'inputString' to the output stream. the 'println' method writes thes tring followed by a newline. This data is sent to the Python script
    //     writer.flush();                       


       //read the output from the process's input stream
    //     String sorted_ints = new BufferedReader(new InputStreamReader(sortingProcess.getInputStream())).readLine();

        // String sorted_ints = sortingProcess.inputReader().readLine(); //python's output is java's input
    //     System.out.println("Received output from Python script: " + sorted_ints);
    //     return sorted_ints;
    // }


//1: SpringBoot manages the class as a bean, and it can be injected into other classes
//2: the method takes a list of integers as an argument and returns a 'String'
//3: ProcessBuilder is used to start a process, here, the process is running a Python script('bubble_sort.py'). The Python script is located in './sorting-algos-python/'
//4: starts the process and returns a 'Process' instance which represents the running process

//5: For the Java porgram, 'sortingProcess.getOutputStream()' is an output stream b/c Java sends data (i.e talking into a pipe) to this stream. For the python script, the same stream is an input stream b/c Python is reading data from the stream (i.e listening from the other end of the pipe)
//5: The 'PrintWriter' class helps in writing characters to an output destination and in the code the 'PrintWriter' is configured to write data into the output stream of the process, meaning it sends data to the Python script
//The PrintWriter instance is assigned to the variable called 'writer', and the 'writer' variable is used to send data through the pipe
