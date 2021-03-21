package assignment7.part3and4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    //Given two strings s and t , write a function to determine if t is an anagram of s.
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for (int j : map) {
            if (j != 0)
                return false;
        }

        return true;
    }

    //Given an array of integers arr, write a function that returns true if and only if the number of
    //occurrences of each value in the array is unique.
    public boolean uniqueOccurrences(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int a : arr)
            map.put(a, map.getOrDefault(a, 0)+1);

        Set<Integer> set = new HashSet<>();
        for(int key : map.keySet()){
            if(set.contains(map.get(key)))
                return false;
            set.add(map.get(key));
        }
        return true;
    }

}
