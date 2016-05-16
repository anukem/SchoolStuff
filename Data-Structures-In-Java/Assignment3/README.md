Assignment 3:

(35 pts) Implementing Expression Trees:

Implement a class called ExpressionTree . The constructor to ExpressionTree will take in a String that contains a postfix expression. The operands will be integers and the binary operators will be restricted to +, -, *, and divide. Individual tokens, that is the operands and operators, will be delimited by spaces. So for example:

34 2 - 5 *

would mean (34-2)*5.

Your constructor will run the stack based algorithm we discussed in class to build an expression tree. ExpressionNodes will be a nested class within ExpressionTree. You may use any code posted on canvas or from the Weiss textbook as a starting point for this class.
Once you have the ExpressionTree constructed you should provide the following four methods:

public int eval() - this method, when invoked on an expression tree object will return the integer value associated with evaluating the expression tree. It will need to call a private recursive method that takes in the root.
public String postfix() - this method, when invoked on an expression tree object will return a String that contains the corresponding postfix expression. It will need to call a private recursive method that takes in the root.
public String prefix() - this method, when invoked on an expression tree object will return a String that contains the corresponding prefix expression. It will need to call a private recursive method that takes in the root.
public String infix() - this method, when invoked on an expression tree object will return a String that contains the corresponding correct infix expression. Keep in mind that parenthesis will be needed (excessive parenthesis will be tolerated as long as it is correct). It will need to call a private recursive method that takes in the root.
Write a class called Problem1.java that instantiates an expression, and demonstrate your methods.

(30 pts) Write a command line application, in the file Problem2.java that indexes the words contained in a text file (provided to the program as a command line argument).  Your program should go through the input file line by line.  For each line, extract each word, and insert that word, along with it's location into an AVL tree.  Each element of the AVL tree should contain a unique word and a linked list of line numbers where that word occurs.  If word already exists in the AVL Tree, simply add the new line number to the existing node.  If a word appears on the same line twice, it should only have one entry in the list for that line.  When you have finished, print out each unique word that appeared in the input file along with a list of line numbers on which that word appears. You may use Weiss' AVL tree code (available from the textbook website and attached herePreview the documentView in a new window - also note you must include the Weiss' UnderFlowException class, which is attached herePreview the documentView in a new window) as a starting point for your program, you will need to modify it.  Ignore case (insert everything as lower case), and strip out all punctuation.  You may test your file on the attached text file 2016su.txtPreview the documentView in a new window.
