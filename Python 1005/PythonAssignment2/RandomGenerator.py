#********************
# John Anukem
# Adam Cannon
# February 18th, 2015
# PseudoRandom Generator
#********************

#Set a variable for the seed and constants
a = 32310901
b = 1729
m = 2**24
seed = int(input("Please enter a seed value "))
i = 0
#use a loop to iterate 100 times
while i<100:
    i = i+1
    newSeed = (a*seed + b)%m
    seed = newSeed
    print(seed)


