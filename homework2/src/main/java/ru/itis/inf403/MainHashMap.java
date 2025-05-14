package ru.itis.inf403;

import java.util.*;

public class MainHashMap {
    public static void main(String[] args) {
        String str = "Дождь дождь идет идет по по улице улице, а а я я стою стою под под зонтом зонтом и и мечтаю мечтаю о о лете лете.";
        textHandler(str);

        int[] array = {1,4,8,6,4,1};
        System.out.println(checkArray(3,array));

        int[] array1 = {1,1,1,5,5,5,8,9,9,4,4};
        int[] array2 = {1,1,1,1,9,4,4,4,9};
        System.out.println(Arrays.toString(mergeArrays(array1,array2)));


    }

    public static void textHandler(String text) {
        String text1 = text.replaceAll("[?.,!;]","");
        String[] array = text1.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.merge(array[i],1,(o1,o2) -> o1+o2);
        }
        map.forEach((key,value) -> System.out.println(key+ " " + value));
    }

    public static boolean checkArray(int k, int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i],i+1,(o1,o2) -> {
                if (Math.abs(o1-o2)<=k) {
                    return k;
                } else {
                    return o2;
                }
            });
            if (map.get(nums[i]).equals(k) && map.get(nums[i])!=i+1) {
                return true;
            }
        }
        return false;
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map1.merge(array1[i],1,(o1,o2) -> o1+o2);
        }
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < array2.length; i++) {
            map2.merge(array2[i],1,(o1,o2) -> o1+o2);
        }

        for (Map.Entry<Integer, Integer> n : map2.entrySet()) {
            if (map1.containsKey(n.getKey())) {
                map2.merge(n.getKey(),map1.get(n.getKey()),(o1,o2) -> {
                    if (o1<o2) {
                        return o1;
                    }
                    return o2;
                });
            } else {
                map2.remove(n.getKey());
            }
        }
        int length = map2
                .entrySet()
                .stream()
                .map(o1 -> o1.getValue())
                .toList()
                .stream()
                .reduce((a,b) -> a+b)
                .get();
        int cnt = 0;
        int[] fin = new int[length];
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                fin[cnt++] = number;
            }
        }
        return fin;
    }
}
