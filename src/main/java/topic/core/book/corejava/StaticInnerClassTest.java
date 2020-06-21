package topic.core.book.corejava;

public class StaticInnerClassTest {
	public static void main(String[] args) {
		// create a double array of size 100
		double[] d = new double[100];
		for (int i = 0; i < d.length; i++) {
			d[i] = 100 * Math.random();
		}
		int count = 0;
		for (double dbl : d) {
			System.out.println(++count + ")" + dbl);
		}
		// compute min and max
		ArrAlg.Pair pair = ArrAlg.minMax(d);
		System.out.println("Min = "+pair.getMin());
		System.out.println("Max =" +pair.getMax());
	}
}
	
	class ArrAlg {
		
		public static class Pair {
			private double min;
			private double max;
			
			public Pair(double d1, double d2) {
				this.min = d1;
				this.max = d2;
			}
			
			public double getMin() {
				return min;
			}
			
			public void setMin(double min) {
				this.min = min;
			}
			
			public double getMax() {
				return max;
			}
			
			public void setMax(double max) {
				this.max = max;
			}
		} // EOF Pair
		
		public static Pair minMax(double[] d) {
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			for (double dbl : d) {
				if (min > dbl) min = dbl;
				if (max < dbl) max = dbl;
			}
			return new Pair(min, max);
		}
	}
