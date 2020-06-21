package topic.algorithms.book.liang;

import topic.util.StopWatch;
import topic.util.StopWatchNano;

public class GCD {
	public static void main(String[] args) {
		int m = 1222222225 ;
		int n = 133331212;
		StopWatch watch = new StopWatchNano();
		watch.start();
		System.out.format("GCD of %d and %d = %d \n", m, n, bruteGCD(m, n));
		watch.stop();
		System.out.format("Duration in millis =%d \n",watch.durationInMillis());
		
		watch.reset();
		
		watch.start();
		System.out.format("GCD of %d and %d = %d \n", m, n, optimalGCD(m, n));
		watch.stop();
		System.out.format("Duration in millis =%d \n",watch.durationInMillis());
		
	}
	
	public static int bruteGCD(int m, int n){
		int gcd = 1;
		for(int k=2; k<=m && k<=n; k++){
			if(m % k ==0 && n % k ==0) {
				gcd = k;
			}
		}
		return gcd;
	}
	
	public static int optimalGCD(int m, int n){
		int gcd = 1;
		if(m % n == 0) return n;
		for(int k = n/2; k >= 1 ; k--){
			if(m % k ==0 && n % k ==0) {
				gcd = k;
				break;
			}
		}
		return gcd;
	}
}
