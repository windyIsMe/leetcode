class Solution:
    def canCompleteCircuit(self, gas: list, cost: list) -> int:
        sum = 0
        start = 0
        total = 0
        for i in range(len(gas)):
            sum += gas[i] - cost[i]
            total += gas[i] - cost[i]
            if sum < 0:
                start = i + 1
                sum = 0
        if total < 0:
            return -1
        else:
            return start

if __name__ == '__main__':
    gas = [1, 2, 3, 4, 5]
    cost = [3, 4, 5, 1, 2]
    gas1 = [2, 3, 4]
    cost1 = [3, 4, 3]
    print(Solution().canCompleteCircuit(gas1, cost1))