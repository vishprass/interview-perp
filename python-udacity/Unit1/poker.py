"""
Unit1: Poker
Author: Prasanna 
Date: May 3, 2014 
"""

def poker(hands):
    "Return the best hand: poker([hand,...]) => hand"
    return max(hands, key = hand_rank)

def hand_rank(hand):
    "Return th erank of the hand: hand_rank(hand) => rank"
    return     