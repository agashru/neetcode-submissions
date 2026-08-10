class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;

        while(left < right){
            int result = numbers[right] + numbers[left];
            if(result == target){
                return new int[] {left +1, right + 1};
            } else if( result < target){
                left++;
            } else{
                right --;
            }
        }

        return new int[] {-1, -1};
        
    }
}
