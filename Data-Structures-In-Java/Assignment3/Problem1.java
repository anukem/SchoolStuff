// John Anukem
// jea2161
// March 4, 2016
public class Problem1 {

	public static void main(String[] args) {
		
		//Tests all methods
		ExpressionTree ayee = new ExpressionTree("1 2 + 3 4 5 + * *");
		System.out.println(ayee.eval());
		System.out.println(ayee.prefix());
		System.out.println(ayee.infix());
		System.out.println(ayee.postfix());
	}
}