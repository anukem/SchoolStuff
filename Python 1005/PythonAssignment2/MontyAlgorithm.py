#************************
# John Anukem
# Adam Cannon
# February 19th, 2015
# Monty Hall Simulator
#************************
#Use a while loop to satisfy the 1000 iterations and define the change and stay options
import random
changeOption = 0
stayOption = 0
while stayOption + changeOption < 1000:
#Assign a variable for the doors
    doors = ["goat", "goat", "goat"]
#Use a random generator to assign a place for the car
    carPlace = random.randint(0,2)
    doors[carPlace] = "car"
#Have the player choose a door
    player = random.randint(0,2)
    playerChoice = doors[player]
#Have the host get rid of one of the goat doors
    host = random.randint(0,2)
    hostChoice = doors[host]
    if host == player or hostChoice == carPlace:
        hostChoice = doors[random.randint(0,2)]
#Record whether or not the user should've switched
    if playerChoice == "car":
        stayOption = stayOption + 1
    else:
        changeOption = changeOption + 1
#Print the results

print("If you decided to change your door, you would be right about " + str(changeOption) + " times.")
print("Otherwise, it would've been better to stay about " + str(stayOption) + " times")
 
