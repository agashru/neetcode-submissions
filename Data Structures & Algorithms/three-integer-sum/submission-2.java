class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSum(nums, i + 1, n - 1, -nums[i], result);
        }
        return result;
    }

    public void twoSum(int[] numbers, int i , int j , int target, List<List<Integer>> result){
        while(i < j){
            if(numbers[i] + numbers[j] < target){
                i++;
            } else if(numbers[i] + numbers[j] > target){
                j--;
            } else{
                result.add(Arrays.asList(-target, numbers[i], numbers[j]));

                while(i < j && numbers[i] == numbers[i+1]){
                    i++;
                }

                while(i < j && numbers[j] == numbers[j-1]){
                    j--;
                }
                i++;
                j--;
            }
        }
    }
}
