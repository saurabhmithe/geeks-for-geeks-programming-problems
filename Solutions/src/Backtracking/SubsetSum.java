package Backtracking;

public class SubsetSum {

    // Subset sum problem is to find subset of elements that are selected from a given set whose
    // sum adds up to a given number K. We are considering the set contains non-negative values.
    // It is assumed that the input set is unique (no duplicates are presented).

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] a = {1, 3, 2, 5, 4, 9};
        subsetSum.subsetSum(a, 13, 0, 0);
    }

    public void subsetSum(int[] nums, int K, int index, int sum) {
        if (index >= nums.length || sum > K) return;
        sum += nums[index];
        if (sum == K) System.out.println();
    }
}
