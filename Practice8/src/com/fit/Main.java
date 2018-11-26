package com.fit;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<POJO> set = init();
        System.out.println("\nHashSet:");
        display(set);
        System.out.println("___");
        System.out.println("Result: ");
        display(getElements(set));
    }
    public static HashSet<POJO> init(){
        HashSet<POJO> set = new HashSet<>();

        System.out.println(set.add(new POJO("P0", "t0", 0)));
        System.out.println(set.add(new POJO("P1", "t1", 1)));
        System.out.println(set.add(new POJO("P1", "t2", 2)));
        System.out.println(set.add(new POJO("P2", "t2", 2)));
        System.out.println(set.add(new POJO("P3", "t3", 2)));
        System.out.println(set.add(new POJO("P3", "t3", 3)));

        return set;
    }
    public static void display(HashSet<POJO> set){
        for(POJO element : set){
            System.out.println(element);
        }
    }
    public static HashSet<POJO> getElements(HashSet<POJO> set){
        HashSet<POJO> uniqueElements = new HashSet<POJO>();
        HashSet<POJO> forDelete;
        for(POJO item : set) {
            boolean isUnique = true;
            forDelete = new HashSet<POJO>();
            for (POJO checkItem : uniqueElements) {
                if (POJO.isEqual(item, checkItem)) {
                    forDelete.add(checkItem);
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                uniqueElements.add(item);
            }
            else
            {
                for (POJO pojoDel : forDelete) {
                    uniqueElements.remove((pojoDel));
                }
                forDelete.clear();
            }
        }
        return uniqueElements;
    }
}
