// John Anukem
// jea2161
// March 4, 2016
public class ExpressionTree {

	public ExpressionNodes root;

	//Constructor
	public ExpressionTree(String exp ) {
		String[] arrayOfTokens = exp.split(" ");
		MyStack<ExpressionNodes> stackOfNodes = new MyStack<ExpressionNodes>();

		//Stack algorithm used in class
		for(int i = 0; i < arrayOfTokens.length; i++) {
			if(isInteger(arrayOfTokens[i])) {
				ExpressionNodes number = new ExpressionNodes(arrayOfTokens[i], null, null);
				stackOfNodes.push(number);

			}

			else {
				ExpressionNodes rightOperand = stackOfNodes.pop();
				ExpressionNodes leftOperand = stackOfNodes.pop();
				ExpressionNodes operator = new ExpressionNodes(arrayOfTokens[i], leftOperand, rightOperand);
				stackOfNodes.push(operator);
				root = operator;
			}
		}


	}

	public class ExpressionNodes {

		public String token;
		public ExpressionNodes leftChild;
		public ExpressionNodes rightChild;

		public ExpressionNodes(String token, ExpressionNodes leftChild, ExpressionNodes rightChild) {

			this.token = token;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	private int eval(ExpressionNodes x) {
		
		//Checks the operator and returns the proper result.
		if(x.token.equals("+")) {

			return eval(x.leftChild) + eval(x.rightChild);
		}

		else if(x.token.equals("-")) {
			return eval(x.leftChild) - eval(x.rightChild);
		}

		else if(x.token.equals("*")) {
			return eval(x.leftChild) * eval(x.rightChild);
		}

		else if(x.token.equals("/")) {
			return eval(x.leftChild)/eval(x.rightChild);
		}

		else {return Integer.parseInt(x.token);}
	}

	public int eval() {

		return eval(root);
	}


	public String postfix() {

		return postfix(root);

	}

	private String postfix(ExpressionNodes x) {

		//puts the oeprator last, and operands first.
		StringBuilder postfix = new StringBuilder(100);
		if(x.token.equals("+")) {
			postfix.append( postfix(x.leftChild) +  postfix(x.rightChild) + "+");
			return postfix.toString();
		}

		else if(x.token.equals("-")) {
			postfix.append( postfix(x.leftChild) +  postfix(x.rightChild) + "-");
			return postfix.toString();
		}

		else if(x.token.equals("*")) {
			postfix.append( postfix(x.leftChild) +  postfix(x.rightChild) + "*");
			return postfix.toString();
		}

		else if(x.token.equals("/")) {
			postfix.append( postfix(x.leftChild) +  postfix(x.rightChild) + "/");
			return postfix.toString();
		}

		else {return x.token;}
	}

	public String prefix() {

		return prefix(root);

	}

	private String prefix(ExpressionNodes x) {

		//puts the operator first, and operands second
		StringBuilder prefix = new StringBuilder(100);
		if(x.token.equals("+")) {
			prefix.append( "+" + prefix(x.leftChild) +  prefix(x.rightChild));
			return prefix.toString();
		}

		else if(x.token.equals("-")) {
			prefix.append( "-" + prefix(x.leftChild) +  prefix(x.rightChild));
			return prefix.toString();
		}

		else if(x.token.equals("*")) {
			prefix.append( "*" + prefix(x.leftChild) +  prefix(x.rightChild));
			return prefix.toString();
		}

		else if(x.token.equals("/")) {
			prefix.append( "/" + prefix(x.leftChild) +  prefix(x.rightChild));
			return prefix.toString();
		}

		else {return x.token;}
	}

	public String infix() {
		return infix(root);
	}
	private String infix(ExpressionNodes x ){

		//puts each operator in the correct order
		StringBuilder infixExp = new StringBuilder(100); 
		if(x.token.equals("+")) {
			infixExp.append("(" + infix(x.leftChild) + ")" +  "+" + "(" +  infix(x.rightChild) + ")");
			return infixExp.toString();
		}

		else if(x.token.equals("-")) {
			infixExp.append("(" + infix(x.leftChild) + ")" +  "-" + "(" +  infix(x.rightChild) + ")");
			return infixExp.toString();
		}

		else if(x.token.equals("*")) {
			return "(" + infix(x.leftChild) + ")" +  "*" + "(" +  infix(x.rightChild) + ")";
		}

		else if(x.token.equals("/")) {
			return "(" + infix(x.leftChild) + ")" +  "/" + "(" +  infix(x.rightChild) + ")";
		}

		else {return x.token;}

	}

	//Checks to see if the string is an integer
	public boolean isInteger( String input ){
   		try{
      		Integer.parseInt( input );
      		return true;
   		}
   		catch( Exception e){
      		return false;
   		}
}
}