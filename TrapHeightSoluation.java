/*
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/

public class TrapHeightSolution {
    static int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int maxHeight=0;
        for(int i=0;i<n;i++){
            left[i]=maxHeight;
            maxHeight=Math.max(maxHeight,height[i]);
        }
        maxHeight=0;
        for(int i=n-1;i>=0;i--){
            right[i]=maxHeight;
            maxHeight=Math.max(maxHeight,height[i]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            int heightOfTrap=Math.max(Math.min(left[i],right[i])-height[i],0);
            total +=heightOfTrap;
        }
        return total;
    }
    
    public static void main(String[] args){
        int[] height = {4,2,0,3,2,5};
        int result=trap(height);
        System.out.println("Result : "+result);
    }
}