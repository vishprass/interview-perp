# -*- coding: utf-8 -*-
"""
Created on Sun Dec 22 11:53:46 2013

@author: prasanna
"""

def prob2():
    
    prev = 1
    result = 0
    current = 1;
    
    while current<4000000:
        
        if current%2==0:
            result = result+current
            
        new = current+prev
        prev = current
        current = new    
            
    return result
        
        