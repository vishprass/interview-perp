# -*- coding: utf-8 -*-
"""
Created on Sun May  4 21:14:46 2014

@author: prasanna
"""

import numpy as np
import random

def binTrail(u):
    def sample():
        if np.random.rand(1)<u:
            return 1
        return 0
    return sample
    
def errTrial(u,e):
    def sample(v):
        if abs(u-v)>e:
            return 1
        return 0
    return sample    
    
def bound(N,e):
    return 2*np.exp(0-(2*(e**2)*N))

if __name__ == '__main__':
    # create a binomial distribution with val = 1 with prob u
    u = 0.2    
    draw = binTrail(u)
    
    N = random.randint(10,10000) # number of samples
    e = random.random()*0.1
    limit = bound(N,e)
    
    T = 1000    
    err = errTrial(u,e)# estimate prob of error
    v = float(sum(err(float(sum(draw() for i in xrange(N)))/float(N)) for j in xrange(T)))/float(T)
    print "ProbErr: "+str(v)+" Bound: "+str(limit)    
    assert(v<=limit),"Impossible ;)"
    print "Hoeffding is Happy"
    
        
            