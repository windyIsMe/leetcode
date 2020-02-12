class Solution:
    def numTrees(self, n: int) -> int:
        num = [1,1,2]
        for i in range(3, n+1):
            sum = 0
            for j in range(0, i):
                sum += num[j]*num[i-1-j]
            num.append(sum)
        return num[n]

if __name__ == '__main__':
    print(Solution().numTrees(3))