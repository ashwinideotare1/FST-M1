package activities;

import java.util.HashSet;

public class Activity10 {
	
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        
        //Add hashset
        hs.add("M");
        hs.add("B");
        hs.add("C");
        hs.add("A");
        hs.add("M");
        hs.add("X");
        
        //Print HashSet
        System.out.println("Original HashSet: " + hs);   
        
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hs.size());
        
        //Remove element
        System.out.println("Removing A from HashSet: " + hs.remove("A"));
        
        //Remove element that is not present
        if(hs.remove("B")) {
        	System.out.println("B removed from the Set");
        } else {
        	System.out.println("B is not present in the Set");
        }
        
        //Search for element
        System.out.println("Checking if M is present: " + hs.contains("M"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);
    }
}