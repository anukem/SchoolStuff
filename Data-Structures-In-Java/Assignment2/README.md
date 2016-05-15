Assignment 2

Palindrome Detector (30 pts) : A palindrome is a phrase that reads the same forwards as it does backwards. For example, "a man, a plan, canal, Panama." is a palindrome. Ignore white space and punctuation. Write a program that uses a stack to check for palindromes in each line of a text file. The main method should be in a class called FindPalindromes.java.The text file should be provided as a command line argument (remember String[] args from main). Try your program on the example text file palindromes.txtPreview the documentView in a new window attached to this assignment. Your program should output the palindromes that it finds in the document. For example:

       java FindPalindromes palindromes.txt

       "a man, a plan, a canal, Panama" is a palindrome.

       "Don't nod" is a palindrome.

       "Taco Cat!" is a palindrome.

You must write your own MyStack class for this problem.
 It must be generic,
 in the sense that you should be able to use this stack with any type of object.  Don't use the built in Stack, instead build your stack from java.util.LinkedList.  Do not use the builtin push/pop methods from LinkedList. 

Two Stack Queue (30 pts):  Build a queue out of two completely separate stacks, S1 and S2. Enqueu operations happen by pushing the data on to stack 1.  Dequeue operations are completed with a pop from stack 2.  Obviously you will have to find some way to get the input stack information over to the output stack.  Your job is to figure out how and when to do that, using only push and pop operations.

Write a class TwoStackQueue that implements the Queue ADT using two stacks. Your class should be generic. Write an enqueue and a dequeue method. Your class should not use any additional memory to store the data in the queue except for the two stacks. Use your stack implementation from programming problem 1.
Write a tester class with a main method to demonstrate that your TwoStackQueue works correctly (by enqueueing a number of objects and then dequeueing and printing them in the correct order).   Call your tester class Program2.java.
In a file called Program2.txt, discuss the big-O running time of the enqueue and dequeue operation for your queue implementation.
