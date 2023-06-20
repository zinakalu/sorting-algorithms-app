package com.sortingalgos.SortingAlgorithmssApplication.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller 
@RequestMapping(path= "/sorting")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping("/bubble_sort")
    public @ResponseBody String bubbleSort(@RequestBody List<Integer> array){
        try{
            return sortingService.bubbleSort(array);
        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Bubble Sort temporarily unavailable");
        }
        
        
    }

    @PostMapping("/insertion_sort")
    public @ResponseBody String insertionSort(@RequestBody List<Integer> array){
        try{
            return sortingService.insertionSort(array);
        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Insertion Sort temporarily unavailable");
        }
    }

    @PostMapping("/merge_sort")
    public @ResponseBody String mergeSort(@RequestBody List<Integer> array){
        try{
            return sortingService.mergeSort(array);
        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Merge Sort temporarily unavailable");
        }
    }

    @PostMapping("/quick_sort")
    public @ResponseBody String quickSort(@RequestBody List<Integer> array){
        try{
            return sortingService.quickSort(array);
        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Quick Sort temporarily unavailable");
        }
    }
    @PostMapping("/selection_sort")
    public @ResponseBody String selectionSort(@RequestBody List<Integer> array){
        try{
            return sortingService.selectionSort(array);
        }
        catch(IOException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Selection Sort temporarily unavailable");
        }
    }
    
}



