package com.youtube.sandbox;

import java.util.*;
import java.util.stream.*;

public class SortingMaps {

    public static void main(String[] args) {
        Map<String, Integer> initMap = new HashMap();
        initMap.put("B", 99);
        initMap.put("E", 1);
        initMap.put("W", 23);
        initMap.put("Z", 9);
        initMap.put("C", 54);
        initMap.put("P", 76);
        initMap.put("A", 32);

        System.out.println("Initial map: " + initMap);
        System.out.println("Sorted map by value: " + sortMapByValueAlg(initMap));
        System.out.println("Sorted map by value: " + sortMapByValue(initMap));
        System.out.println("Sorted map by key: " + sortMapByKeyAlg(initMap));
        System.out.println("Sorted map by key: " + sortMapByKey(initMap));
    }

    //Сортируем руками по значению
    public static Map sortMapByValueAlg(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap();
        List<Integer> list = new LinkedList(map.values());
        list.sort(Comparator.naturalOrder());

        for (Integer value : list) {
            String key = map.entrySet().stream()
                    .filter(entry -> value.equals(entry.getValue()))
                    .map(Map.Entry::getKey).findFirst().get();
            result.put(key, value);
        }

        return result;
    }

    //Сортируем стримом по значению
    public static Map sortMapByValue(Map<String, Integer> value) {
        return value.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o1) -> o, LinkedHashMap::new));
    }

    //Сортируем руками по ключу
    public static Map sortMapByKeyAlg(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap();
        List<String> list = new LinkedList(map.keySet());
        list.sort(Comparator.naturalOrder());

        for (String key : list) {
            Integer value = map.entrySet().stream()
                    .filter(entry -> key.equals(entry.getKey()))
                    .map(Map.Entry::getValue).findFirst().get();
            result.put(key, value);
        }
        return result;
    }

    //Сортируем стримом по ключу
    public static Map sortMapByKey(Map<String, Integer> value) {
        return value.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, o1) -> o, LinkedHashMap::new));
    }
}
