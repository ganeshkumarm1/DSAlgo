package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack {
    public static List<List<Integer>> combinationSum(int[] candidates, int target, int index, List<Integer> currCombination, List<List<Integer>> result) {
        if(target < 0)
            return null;
        if(target == 0) {
            result.add(currCombination);
            return null;
        }

        for(int i = index; i < candidates.length; i ++) {
            List<Integer> temp = new ArrayList<>(currCombination);
            temp.add(candidates[i]);

            combinationSum(candidates, target - candidates[i], i, temp, result);
        }

        return result;
    }

    public static void main(String[] args) {
        // Problem Statement: https://leetcode.com/problems/combination-sum/

        int[] candidates = new int[] { 2, 3, 6, 7 };
        int target = 7;

        List<Integer> currCombination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        System.out.println(combinationSum(candidates, target, 0, new ArrayList<>(), new ArrayList<>()));
    }
}
