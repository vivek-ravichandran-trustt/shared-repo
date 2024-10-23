package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams{
    public static void main(String[] args) {
        
        // Stream from a List (Collection)
        List<String> names = Arrays.asList("Suba", "Harini", "Sristi", "Thanu", "Sristi", "Kirthik");
        List<String> resultFromList = names.stream() 
            .filter(name -> name.length() > 3)       
            .distinct()                             
            .sorted()                              
            .map(String::toUpperCase)        
             // Terminal: collect into a List
            .collect(Collectors.toList());          

        System.out.println("Stream from List: " + resultFromList);
        
        // Stream from an Array
        String[] nameArray = {"Suba", "Swetha", "Harsha", "Swetha", "Dharani"};
        List<String> resultFromArray = Arrays.stream(nameArray)  
            .filter(name -> name.length() > 3)                   
            .distinct()                                         
            .map(String::toUpperCase)                           
            .sorted()               
            // Terminal: collect into a List
            .collect(Collectors.toList());                      

        System.out.println("Stream from Array: " + resultFromArray);
        
        // 3. Stream from Values
        Stream<String> nameStream = Stream.of("Akshu", "Arul", "Suba", "Akshu", "Thithi");
        List<String> resultFromValues = nameStream          
            .filter(name -> name.length() > 3)             
            .distinct()                                    
            .sorted()                                      
            .map(String::toUpperCase)    
            // Terminal: collect into a List
            .collect(Collectors.toList());                 

        System.out.println("Stream from Values: " + resultFromValues);
        
        // 4. Stream from an IntStream (primitive stream)
        int[] numbers = {5, 3, 9, 2, 4, 7, 9, 2};
        List<Integer> resultFromIntStream = IntStream.of(numbers)  
            .distinct()                                            
            .filter(num -> num > 3)                                
            .sorted()             
            // Convert primitive int to Integer (boxed)
            .boxed()             
            // Terminal: collect into a List                                  
            .collect(Collectors.toList());                         

        System.out.println("Stream from IntStream: " + resultFromIntStream);
        
        // 5. Terminal operation with forEach (Side-effect terminal operation)
        System.out.println("Using forEach Terminal Operation:");
        names.stream()                          
            .filter(name -> name.length() > 3)  
            .distinct()                        
            .map(String::toUpperCase)    
            // Terminal: forEach to print each element      
            .forEach(System.out::println);     
    }
}

