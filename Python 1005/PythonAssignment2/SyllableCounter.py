#**********************
# John Anukem
# Adam Cannon
# February 15th, 2015
# Syllable Counter 
#**********************
#Assign variables
syllableCounter = 0
vowels = "aeiouyAEIOUY"
word = input("What word would you like to know the number of syllables for? ")
#Set the condition for the first letter of the word
if word[0] in vowels:
    syllableCounter = syllableCounter + 1
#Use a for loop to check the rest of the letters as well as the letter behind it
for i in range(1,int(len(word))):
    if word[i] in vowels and word[i-1] not in vowels:
        syllableCounter = syllableCounter + 1
if word[int(len(word)-1)] == "e":
    syllableCounter = syllableCounter - 1
if syllableCounter == 0:
    syllableCounter = syllableCounter + 1
print("Word       Syllables")
print(word + "      " + str(syllableCounter))



