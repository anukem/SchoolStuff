#*********************
# John Anukem
# Adam Cannon
# February 18, 2015
# Binary in Reverse
#*********************

#Get the number from the user
number = int(input("Please enter a integer "))
#Use a while loop to run through the integer until the bunary is produced
while number > 0:
    print(str(number % 2))
    number = number//2
