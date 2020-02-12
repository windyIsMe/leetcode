class Solution:
    def minimumTotal(self, triangle: list) -> int:
        levelNum = len(triangle)
        minList = triangle[levelNum-1]
        for level in range(levelNum-2, -1, -1):
            for i in range(level+1):
                minList[i] = min(minList[i], minList[i+1])+triangle[level][i]
        return minList[0]

if __name__ == '__main__':
    triangle = [
                     [2],
                    [3,4],
                   [6,5,7],
                  [4,1,8,3]
                ]
    print(Solution().minimumTotal(triangle))