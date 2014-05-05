# -*- coding: utf-8 -*-
"""
Created on Sun May  4 17:41:35 2014

@author: prasanna
"""
import numpy as np

def perceptron(w,thres):
    "outer perceptron"
    def perceptron_inner(x):
        "inner perceptron"
        return np.sign(w.T.dot(x)-thres)
    return perceptron_inner

def maker(n):
  def action(x):
    return x ** n
  return action    
  
if __name__== '__main__':
    f1 = perceptron(np.random.rand(5,1),0.5)
    print type(f1)
    print f1(np.random.rand(5,1))