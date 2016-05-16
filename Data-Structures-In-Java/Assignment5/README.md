Assignment 5:

(35 points) Based on Weiss Exercise 5.21 - implement this problem as described with the exception of the secondary dictionary.  Your program, called SpellChecker.java should take two command line arguments, the dictionary (provided here as words.txtPreview the documentView in a new window), and the text that you wish to spellcheck. Provide some sample text.  Your program should be case insensitive (so you can toLower everything).  Numbers and contractions are considered valid words.  You may use the java HashTable or HashMap to implement this program; but it must use some kind of hash table.
(25 points) Finding the k-largest values in a set of data - Assume you are given a sequence of values. We do not know how many elements there are in this sequence. In fact, there could be infinitely many. Implement the class
KBestCounter<T extends Comparable<? super T>> that keeps track of the k-largest elements seen so far in a set of data. The class should have two methods:
public void count(T x) - process the next element in the set of data. This operation should run in the at worst O(log k) time.
public List<T> kbest() - return a sorted (largest to smallest) list of the k largest elements. This should run in O(k log k) time. The method should restore the priority queue to its original state after retrieving the k largest elements. If you run this method twice in a row, it should return the same values.
Use a Priority Queue to implement this functionality. We suggest using the built-in java.util.PriorityQueue, which implements a min-heap for you. You should never have more than k elements inserted into the Priority Queue at any given time.

An example illustrates how KBestCounter could be used in this attached tester class: TestKBest.javaPreview the documentView in a new window.  We also include a skeleton for the KBestCounter class in the following file: KBestCounter.javaPreview the documentView in a new window.

(5 points) Make sure to include a README.txt.

