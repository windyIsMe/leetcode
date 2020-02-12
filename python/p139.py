class Solution:
    def wordBreak(self, s: str, wordDict: list) -> bool:
        canBreak = [True] + [False] * len(s)
        for i in range(1, len(s) + 1):
            for j in range(i):
                if canBreak[j] and s[j:i] in wordDict:
                    canBreak[i] = True
                    break
        return canBreak[len(s)]

if __name__ == '__main__':
    s = "catsandog"
    wordDict = ["cats", "dog", "sand", "and", "cat"]
    print(Solution().wordBreak(s, wordDict))
