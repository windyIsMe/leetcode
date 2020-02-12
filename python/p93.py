class Solution:
    def restoreIpAddresses(self, s: str):
        res = []
        strlen = len(s)
        for i in range(1, min(4, strlen - 2)):
            for j in range(i + 1, min(i + 4, strlen - 1)):
                for k in range(j + 1, min(j + 4, strlen)):
                    s1, s2, s3, s4 = s[0:i], s[i:j], s[j:k], s[k:strlen]
                    if (self.isValid(s1) and self.isValid(s2) and self.isValid(s3) and self.isValid(s4)):
                        res.append(s1 + "." + s2 + "." + s3 + "." + s4)
        return res

    def isValid(self, str):
        return int(str) >= 0 and int(str) <= 255 and not (str[0] == '0' and len(str) > 1)


if __name__ == '__main__':
    print(Solution().restoreIpAddresses("010010"))
