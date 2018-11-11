package com.fit;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        HashSet<POJO> set = new HashSet<>();

        System.out.println(set.add(new POJO("P0", "t0", 0)));
        System.out.println(set.add(new POJO("P1", "t1", 1)));
        System.out.println(set.add(new POJO("P1", "t1", 2)));
        System.out.println(set.add(new POJO("P2", "t2", 2)));
        System.out.println(set.add(new POJO("P3", "t3", 2)));
        System.out.println(set.add(new POJO("P3", "t3", 3)));

        System.out.println("\nHashSet:");
        for(POJO element : set){
            System.out.println(element);
        }
        System.out.println("___");

        LinkedList<POJO> uniqueElements = getElements(set);

        System.out.println("Result: ");
        for(POJO element : uniqueElements){
            System.out.println(element);
        }
    }

    public static LinkedList<POJO> getElements(HashSet<POJO> set){
        LinkedList<POJO> uniqueElements = new LinkedList<POJO>();
        for(POJO item : set){
            boolean isUnique = true;
            for(POJO checkItem : uniqueElements){
                if(POJO.isEqual(item, checkItem)){
                    uniqueElements.remove(checkItem);
                    isUnique =false;
                }
            }
            if(isUnique){
                uniqueElements.add(item);
            }
        }
        return uniqueElements;
    }
}
