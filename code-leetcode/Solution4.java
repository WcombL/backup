import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        Solution4 sol = new Solution4();
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        // 归并排序
        int length1 = nums1.length;
        int length2 = nums2.length;

        int len = Math.min(length1, length2);
        int m = 0, n = 0, i = 0;
        
        while(m < length1 && n < length2){
            if (nums1[m] < nums2[n]) {
                nums[i++] = nums1[m++];
            } else if (nums1[m] == nums2[n]) {
                nums[i++] = nums1[m++];
                nums[i++] = nums2[n++];
            } else {
                nums[i++] = nums2[n++];
            }
        }

        while(m < length1){
            nums[i++] = nums1[m++];
        }

        while(n < length2){
            nums[i++] = nums2[n++];
        }

        int odd = nums.length & 1;
        double median = 0D;

        if(odd == 1){
            median = nums[(nums.length-1)/2];
        }else{
            int mid = nums.length/2;
            median = (nums[mid] + nums[mid-1])/2D;
        }

        return median;
    }
}