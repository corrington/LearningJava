/*
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:
    Input: nums = [1,2,2,3]
    Output: true

Example 2:
    Input: nums = [6,5,4,4]
    Output: true

Example 3:
    Input: nums = [1,3,2]
    Output: false

Constraints:
    1 <= nums.length <= 105
    -105 <= nums[i] <= 105
 */
public class MonotonicArray {


    public boolean isMonotonic1(int[] nums) {

        enum State {UNKNOWN, DECREASING, INCREASING}

        if (nums.length == 0) return false;
        if (nums.length == 1) return true;

        State state = State.UNKNOWN;
        int prevValue = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int currValue = nums[i];
            // First, determine which way we're going, up or down
            if (state == State.UNKNOWN) {
                if (prevValue < currValue) {
                    state = State.INCREASING;
                } else if (prevValue > currValue) {
                    state = State.DECREASING;
                } // if
            } else {
                // Once we know which way we're supposed to go,
                // if we find a counterfactual, we bug out
                if ((prevValue < currValue) && (state == State.DECREASING)) {
                    return false;
                } else if ((prevValue > currValue) && (state == State.INCREASING)) {
                    return false;
                } // if
            }
            prevValue = currValue;
        } // for i

        return true;

    } // isMonotonic1()

    public boolean isMonotonic2(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            // we should have an increasing monotonic... let's confirm.
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1])
                    return false;
            } // for i
        } else {
            // We should have a decreasing monotonic... let's confirm.
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1])
                    return false;
            } // for i
        } // if

        return true;

    } // isMonotonic2()

} // class MonotonicArray
