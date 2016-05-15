//John Anukem
//jea2161
//January 20th, 2015
public class Problem3 {

	public static void main(String[] args) {
		//Runtime for Algorithm 1
		System.out.println("codeFragment1 runtimes:");
		for(int i = 1; i < 100000000; i = i*10) {
			//codeFragment1(i);
			System.out.println(i);
		}
		//Runtime for Algorithm 2
		System.out.println("codeFragment2 runtimes:");
		for(int i = 1000; i < 100000; i*= 2) {
			codeFragment2(i);
		}
		//Runtime for algorithm 3
		System.out.println("codeFragment3 runtimes: ");
		for(int i = 1; i < 10000000; i*=5) {
			int starTime = (int)System.nanoTime();
			codeFragment3(i, 2);
			int endTime = (int)System.nanoTime();
			int timeElapsed = endTime - starTime;
			System.out.println(timeElapsed);	
		}
		
		
	}

	public static int codeFragment1(int n){
		int starTime = (int)System.currentTimeMillis();
		int sum = 0;
		for ( int i = 0; i < 23; i ++)
   			for ( int j = 0; j < n ; j ++)	
        		sum += Math.random();
        int endTime = (int)System.currentTimeMillis();
		int timeElapsed = endTime - starTime;
        System.out.println(timeElapsed);
        return sum;
	}

	public static int codeFragment2(int n) {
		int starTime = (int)System.currentTimeMillis();
		int sum = 0;
		for ( int i = 0; i < n ; i ++)
    		for ( int k = i ; k < n ; k ++)
       			sum += Math.random();

       	int endTime = (int)System.currentTimeMillis();
		int timeElapsed = endTime - starTime;
        System.out.println(timeElapsed);
       	return sum;
	}

	public static int codeFragment3(int n, int k) {
   		if(n<=k)
        	return 1;
    else
        return codeFragment3(n/k,k) + 1;
	}
}


