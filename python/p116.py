from node import Node

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return root

        level = [root]
        while len(level) != 0:
            nextLevel = []
            for i in range(0, len(level) - 1):
                level[i].next = level[i + 1]
                if level[i].left is not None:
                    nextLevel.append(level[i].left)
                    nextLevel.append(level[i].right)
            level[len(level)-1].next = None
            if level[len(level)-1].left is not None:
                nextLevel.append(level[len(level)-1].left)
                nextLevel.append(level[len(level)-1].right)
            level = nextLevel

        return root
