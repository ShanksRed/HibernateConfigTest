package com.example.HiberTest.Algorithm;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;

@Component
public class AlgorithmImpl implements statAlgrithm{
    @Override
    public HashMap<String, Integer> analysis(String text) {
        //if(!map.containsKey(chars[i]))
        //   map.put(chars[i],0);
        //Character[] chars = text.toCharArray();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        Character[] chars = text.toUpperCase(Locale.ROOT).chars().mapToObj(i -> (char)i).toArray(Character[]::new);


        // System.out.println(chars);

        for (int i = 0; i < chars.length-4; i++) {
            //map.putIfAbsent(chars[i],0);
            //map.computeIfPresent(chars[i], (k,v) -> v +1);
            map.putIfAbsent(String.valueOf(chars[i]),0);
            map.putIfAbsent(String.valueOf(chars[i]) + String.valueOf(chars[i+1]),0);
            map.putIfAbsent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2]),0);
            map.putIfAbsent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2])+String.valueOf(chars[i+3]),0);
            map.putIfAbsent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2])+String.valueOf(chars[i+3]) + String.valueOf(chars[i+4]),0);
            map.computeIfPresent(String.valueOf(chars[i]), (k,v) -> v +1);
            map.computeIfPresent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2]), (k,v) -> v +1);
            map.computeIfPresent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2])+String.valueOf(chars[i+3]), (k,v) -> v +1);
            map.computeIfPresent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2])+String.valueOf(chars[i+3]), (k,v) -> v +1);
            map.computeIfPresent(String.valueOf(chars[i]) + String.valueOf(chars[i+1])+String.valueOf(chars[i+2])+String.valueOf(chars[i+3]) + String.valueOf(chars[i+4]), (k,v) -> v +1);


        }

        return map;
    }
}
