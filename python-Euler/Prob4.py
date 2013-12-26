# -*- coding: utf-8 -*-
"""
Created on Sun Dec 22 12:31:59 2013

@author: prasanna
"""

def prob4():
    
    num1 = 999
    num2 = 999
    end1 = 100    
    end2 = 100    
    
    palin = 0
    
    for i in xrange(num1,end1,-1):
        for j in xrange(num2,end2,-1):
            prod = i*j
            prodStr = str(prod)
            if (prodStr[::-1] ==prodStr):
                if (prod>palin):
                    palin = prod
                    end2 = j
                    end1 = j
                    num1 = num1-1
                    
    print palin
                    
                    
                
            
            
    
