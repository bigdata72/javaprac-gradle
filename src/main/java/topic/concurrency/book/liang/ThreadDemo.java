package topic.concurrency.book.liang;

public class ThreadDemo {
	public static void main(String[] args) {
		ThreadDemo demo = new ThreadDemo();
		
		PrintChar printA = new PrintChar('a', 100);
		PrintChar printB = new PrintChar('b', 100);
		PrintNum printNum = new PrintNum(100);
		
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(printNum);
		// test thread interactions by setting a high priority
		thread3.setPriority(Thread.MAX_PRIORITY); // set high priority
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class PrintChar implements Runnable{
	private char c;
	private int times;
	PrintChar(char c, int times){
		this.c = c;
		this.times = times;
	}
	
	@Override
	public void run() {
		for(int i=0; i<times; i++)
			System.out.print(c);
	}
}

class PrintNum implements Runnable{
	private int N = 0;
	PrintNum(int N){
		this.N = N;
	}
	
	@Override
	public void run() {
		//runWithoutYieldOrSleep();
		runWithYield();
		//runWithSleep();
		//runWithJoin();
	}
	
	private void runWithoutYieldOrSleep(){
		for(int i=1; i<=N; i++){
			System.out.print(" " + i);
		}
		/**
		 * Run 1: aaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 2: bbbbbbbbbbbbbbbbbbbbbbbaab 1 2 3 4 5 6 7 8 9 10 11 12bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaabbbb 13 14 15 16 17 18aa 19 20aaaaaaaa 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39aaaaaaaaaa 40 41 42 43aaaaaaaaaaaaaaaaaaaaa 44 45aaaaaaaaaaaaaaaaaa 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74aaa 75aaaaaaaaaaaaaaaaa 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100aaaaaaaaaaaaaaa
		 * Run 3: abbbbaaaaaaaaaaa 1bbbbbbbb 2aaaaa 3 4 5 6bbbbbbbbbbbbbbbbbbbbbbb 7aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 8bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30aaaaaaaaaaaaaaaaa 31 32 33 34 35 36 37 38 39 40 41 42 43bbbbbbbbbbbbbbbbbbb 44 45 46 47 48 49 50 51 52bbbbbbbbbbbbbbb 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 4: (thread 3 at max priority, finishes first)
		 * abbbbbbbbbbbb 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbb
		 */
	}
	
	private void runWithYield(){
		for(int i=1; i<=N; i++){
			System.out.print(" " + i);
			Thread.yield();
		}
		// yields to the other threads
		/**
		 * Run 1 : aaaaaaaaabbbbbbbbbbbbbbbbb 1b 2 3 4aaaaaaa 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 2425 26 27 28bbb 29aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 30bbb 31bbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbb 32 33 34 35 36 37 38 39 40 41 42 43bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaa 44aaaaaaaaaaaaaaa 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 2 : aaaaaaaaaa 1bbbbbbbbbbbbbbbbbbbbbb 2 3 4 5 6a 7bbbbbbbbbbbbbbbbbbbbbbb 8aaaaaaaaaaaaaaaaaaaaaa 9bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb 10 11 12 13 14 15 16 17 18aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34bbbbbbbbbbbbbbbaaaaaaa 35 36 37bbbb 38aaaaaaaaaabbbbbb 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 3 : aaaaaaaaabbbbbbbbbbbbbbbbb 1aaaaaaaaaaaaaaaaaa 2 3 4 5 6bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb 7bbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 8 9 10 11 12 13 14 15 16 17bbbbbbbb 18aaaaaaaaaaaaaaaaaaaaaaaa 19aaaaaaaaa 20aaaaaa 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 */
	}
	
	private void runWithSleep(){
		try {
			for (int i = 1; i <= N; i++) {
				System.out.print(" " + i);
				Thread.sleep(1);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		// effect of sleep is apparent
		/**
		 * Run 1:bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbb 1bbbbbbbbbbaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbaaaaa 2aaaaaaaaaaaaaaaaaaaaaaaaaaaa 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 2:aaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbb 2bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 3:abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb 1baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 */
	}
	
	private void runWithJoin(){
		Thread thread4 = new Thread(new PrintChar('c', 100));
		thread4.start();
		try {
			for (int i = 1; i <= N; i++) {
				System.out.print(" " + i);
				if (i == 50) thread4.join();
			}
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		/**
		 * Run 1: abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaa 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 2: abbbbbbbbbaaaaaaaaaabaaaaaccaaaaaaaaa 1a 2 3 4 5 6 7aaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccccccaa 8aaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaa 9aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 3: aaabbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbaaaaaaccccccccc 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42c 43 44 45 46 47 48 49 50aaaaaaaaaaaaabbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100
		 * Run 4 (thread 3 at MAX priority) :
		 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccaccccccccccccccc 1cccccccccccccccccccccccc 2 3cccccccccccccccccc 4caccccc 5cccccccccccccccc 6 7 8 9 10 11 12 13 14 15 16a 17 18 19 20 21aaaaaaaaabbbbbbbbbbbbbbbbbb 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54abbbbbbbaaaa 55 56 57 58 59 60 61 62 63 64 65 66 67 68baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab 69b 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93b 94 95 96 97 98 99 100bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
		 * abbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccbaaa 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30bbbbbbbbbbbbbbbbbbbbbbbccccccccccc 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50bbbbbbbbbbbbbbbbbbbbbbbbbabccccccccccccccccccccccccccc 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95bbbbbbbbbbbbbb 96 97 98 99 100bbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		 */
	}
}

