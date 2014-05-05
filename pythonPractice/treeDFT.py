# -*- coding: utf-8 -*-
"""
Created on Sat May  3 18:47:37 2014

@author: prasanna
"""

class tree:
    "tree object "
    def __init__(self, data, left = None, right = None):
        "create a node and connections in a tree"
        self.data = data
        self.left = left
        self.right = right
     
    def __unicode__(self):
        "print the contents of the node"
        print self.data
        
    def recursive_dfs(self):
        root = self
        self._recursive_dfsT(root)
        
    def _recursive_dfsT(self, Btree):
        nodes = []
        if( Btree!= None):
            nodes.append(Btree.data)
            nodes.extend(self._recursive_dfsT(Btree.left))
            nodes.extend(self._recursive_dfsT(Btree.right))
            print nodes
        return nodes
        
    def bfs(self):
        root = self
        self._bfs(root)
     
    def _bfs(self, Btree):
        nodes = []
        queue = []
        if(Btree != None):
            nodes.append(Btree.data)
            queue.append(Btree.right)
            nodes.extend(self._bfs(Btree.left))
         
