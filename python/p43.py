class Solution:
    def multiply(self, num1: str, num2: str):
        if (num1 == '0' or num2 == '0'):
            return '0'
        len1 = len(num1)
        len2 = len(num2)
        pro = [0]*(len1+len2)
        for i in range(len1-1,-1,-1):
            for j in range(len2-1,-1,-1):
                sum = pro[i+j+1] + int(num1[i])*int(num2[j])
                pro[i+j+1] = sum % 10
                pro[i+j] += sum // 10
        result = ''
        if (pro[0] != 0):
            result += str(pro[0])
        for i in range(1, len(pro)):
            result += str(pro[i])
        return result

s = Solution()
print(s.multiply("123","456"))