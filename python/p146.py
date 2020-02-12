# -*- coding: utf-8 -*

class Node:
    def __init__(self, k, v):
        self.key = k
        self.val = v
        self.prev = None
        self.next = None

class LRUCache:
    '''
    Use dict and doubleLinkedList to store
    '''
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dic = dict()
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key in self.dic:
            n = self.dic[key]
            self.__remove(n)
            self.__append(n)
            return n.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            self.__remove(self.dic[key])
        n = Node(key, value)
        self.__append(n)
        self.dic[key] = n
        if len(self.dic) > self.capacity:
            n = self.head.next
            self.__remove(n)
            del self.dic[n.key]

    def __remove(self, node):
        p = node.prev
        n = node.next
        p.next = n
        n.prev = p

    def __append(self, node):
        p = self.tail.prev
        p.next = node
        node.next = self.tail
        node.prev = p
        self.tail.prev = node

if __name__ == '__main__':
    cache = LRUCache(2)
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1)
    cache.put(3, 3)
    cache.get(2)
    cache.put(4, 4)
    cache.get(1)
    cache.get(3)
    cache.get(4)
