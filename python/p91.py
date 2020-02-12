class Solution:
    def numDecodings(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        if s[0] == '0':
            return 0
        num1 = 1
        num2 = 1
        strlen = len(s)
        for i in range(1, strlen):
            temp = num2
            doubleDigit = int(s[i-1:i+1])
            if s[i] == '0':
                if s[i-1] == '1' or s[i-1] == '2':
                    num2 = num1
                else:
                    return 0
            elif doubleDigit > 10 and doubleDigit <= 26:
                num2 = num1+num2
            num1 = temp
        return num2

if __name__ == '__main__':
    sol = Solution()
    print(sol.numDecodings("24726"))