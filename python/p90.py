class Solution:
    def subsetsWithDup(self, nums):
        nums.sort()
        result = [[]]
        numList = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                numList = [num+[nums[i]] for num in numList]
            else:
                numList = [num+[nums[i]] for num in result]
            result += numList
        return result

if __name__ == '__main__':
    print(Solution().subsetsWithDup([1,2,2]))

