# -*- coding: utf-8 -*-
"""
Created on Sat May  3 20:55:05 2014

@author: prasanna
"""

def find_chars_slow(string1, string2):
    "return common characters in order slow version: find_char_slow(string, string) => string"
    common = ""    
    for s1 in string1:
        for s2 in string2:
            if s1==s2:
                common = common+s1
    return common            
                
def find_chars_fast(string1, string2):
    "return common characters in order fast version: find_char_slow(string, string) => string"
    common = "" 
    D = dict()
    for c in string1:
        D[c] = 1
    for c in string2:
       if c in D:
        common = common+c
    return common       
           
               