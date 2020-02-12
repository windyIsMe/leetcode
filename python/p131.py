class Solution:
    def partition(self, s: str) -> list:
        strList, resList = [], []
        self.backtrack(s, 0, strList, resList)
        return resList

    def backtrack(self, s: str, start: int, strList: list, resList: list):
        if start >= len(s) and strList:
            resList.append(list(strList))
        for i in range(start, len(s)):
            substr = s[start:i+1]
            if self.isPalindrome(substr):
                strList.append(substr)
                self.backtrack(s, i+1, strList, resList)
                strList.pop()

    def isPalindrome(self, s: str):
        return s == s[::-1]

if __name__ == '__main__':
    print(Solution().partition("aab"))