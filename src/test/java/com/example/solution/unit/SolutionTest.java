package com.example.solution.unit;

import com.example.solution.Solution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void simplePositive() {
        Assert.assertEquals(solution.pickOutVowels("Hello, today is Monday"), List.of('e', 'o', 'o', 'a', 'i', 'o', 'a'),
                "List of vowels is correct");
    }

    @Test
    public void simpleNegative() {
        Assert.assertNotEquals(solution.pickOutVowels("Hello, today is Monday"), List.of('a', 'o', 'e', 'i', 'u'),
                "List of vowels is correct");
    }

    @Test
    public void emptyString() {
        Assert.assertTrue(solution.pickOutVowels("").isEmpty(), "List of vowels is correct");
    }

    @Test
    public void stringWithNoVowels() {
        Assert.assertTrue(solution.pickOutVowels("Hll, tdy s Mndy").isEmpty(), "List of vowels is correct");
    }

    @Test
    public void stringWithUpperCase() {
        Assert.assertEquals(solution.pickOutVowels("HEllO, today is Monday"), List.of('E', 'O', 'o', 'a', 'i', 'o', 'a'),
                "List of vowels is correct");
    }
}
