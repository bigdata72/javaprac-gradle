package topic.core.book.corejava;

public class MutableProperty implements Cloneable{
	private int value=10;
	MutableProperty(int val){
		this.value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public MutableProperty clone() throws CloneNotSupportedException{
		return (MutableProperty)super.clone();
	}
}
