
public class GenericClass <T>{
	
	private T value;
	
	public GenericClass(T value) {
		setValue(value);
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		GenericClass<Integer> x = new GenericClass<Integer>(20);
		x.setValue(30);
		System.out.println(x.getValue());
		
	}

}
