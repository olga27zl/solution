package com.example.solution;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<Character> pickOutVowels(String sentence) {
        List<Character> vowels = List.of('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U');

        return sentence.chars().mapToObj(c -> (char) c).filter(vowels::contains).collect(Collectors.toList());
    }
}
