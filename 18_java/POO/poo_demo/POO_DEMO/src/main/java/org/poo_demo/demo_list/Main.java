package org.poo_demo.demo_list;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Vector<String> vectorList = new Vector<>();
//        List<String> vectorList = new Vector<>();
        vectorList.add("Apple");
        vectorList.add("Banana");
        vectorList.add("Orange");
        System.out.println("vectorList = " + vectorList);
        System.out.println("vectorList.size() = " + vectorList.size());
        System.out.println("vectorList.get(1) = " + vectorList.get(1));
        System.out.println("vectorList.firstElement() = " + vectorList.firstElement());
        System.out.println("vectorList.contains(\"Apple\") = " + vectorList.contains("Apple"));
        vectorList.forEach(System.out::println);
        Iterator<String> it = vectorList.iterator();
        while (it.hasNext()) {
            System.out.println( "In iteration => "+ it.next());
        }

        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Java");
        sortedSet.add("Javascript");
        sortedSet.add("C");
        sortedSet.addAll(vectorList);
        sortedSet.add("Objective-C");
        sortedSet.add("E");
        sortedSet.add("Python");
        sortedSet.add("C++");
        sortedSet.add("C#");
        System.out.println("sortedSet.first() = " + sortedSet.first());
        System.out.println("sortedSet.last() = " + sortedSet.last());
        System.out.println("sortedSet.subSet(\"F\", \"P\") = " + sortedSet.subSet("F", "P"));
        
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(1.0);
        linkedList.add(2.5);
        linkedList.add(3.75);
        System.out.println("linkedList = " + linkedList);

        System.out.println("linkedList.getFirst() = " + linkedList.getFirst());
        System.out.println("linkedList.getLast() = " + linkedList.getLast());
        System.out.println("linkedList.removeFirst() = " + linkedList.removeFirst());
        linkedList.addFirst(11.333);

        SortedMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 3);
        treeMap.put("Apple", 1250);
        treeMap.put("Orange", 1);
        System.out.println("treeMap = " + treeMap);
        Set<String> keySet = treeMap.keySet();
        Collection<Integer> values = treeMap.values();
        System.out.println("keySet = " + keySet);
        System.out.println("values = " + values);

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Java", 3);
        hashMap.put("Javascript", 1250);
        hashMap.put("C", 1);
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.get(\"Java\") = " + hashMap.get("Java"));
        System.out.println("hashMap.containsKey(\"Test\") = " + hashMap.containsKey("Test"));
        System.out.println("hashMap.keySet() = " + hashMap.keySet());
        hashMap.remove("C");
        System.out.println("hashMap = " + hashMap);
    }
}
