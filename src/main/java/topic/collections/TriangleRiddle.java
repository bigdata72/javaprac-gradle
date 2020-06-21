package topic.collections;

public class TriangleRiddle {
	public static void main(String[] args) {
		// the angles of a triangle are squares of numbers. find them
		int [] squares = {4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169};
		Angles a = computeAngles(squares);
		System.out.printf("Angles are : %d, %d, %d",a.getOne(), a.getTwo(), a.getThree());
	}
	
	private static Angles computeAngles(int[] a){
		for(int i=0; i<a.length;i++)
			for(int j=1+1; j<a.length; j++)
				for(int k=j+1; k<a.length;k++){
					if(a[i] + a[j] + a[k] == 180){
						Angles angles = new Angles(a[i], a[j], a[k]);
						return angles;
			}
		}
		return null;
	}
}

class Angles{
	int one;
	int two;
	int three;
	
	public Angles(int one, int two, int three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	public int getOne() {
		return one;
	}
	
	public int getTwo() {
		return two;
	}
	
	public int getThree() {
		return three;
	}
}
