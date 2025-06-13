import java.util.Arrays;

public class Main {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        int leftI = 0;
        int rightI = 0;
        int centerI = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(currentSum - target);

                if (currentDiff == 0) {
                    centerI = i;
                    rightI = right;
                    leftI = left;
                    System.out.println(leftI + " " + centerI + " " + rightI);
                    return currentSum;
                }

                if (currentDiff < minDiff) {
                    centerI = i;
                    rightI = right;
                    leftI = left;
                    minDiff = currentDiff;
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(leftI + " " + centerI + " " + rightI);
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = threeSumClosest(nums, target);
        System.out.println("Ближайшая сумма к " + target + ": " + result); // Вывод: 2
    }
}
