package labtest1;

public class Counter {
	private int value;
	private String name;
	
	public Counter(String name) {
		this(name, 0);
	}
	

	/** Initializes the counter to have the given name and value
	 * 
	 * @param name The non-null name of the counter
	 * @param value The value  of the counter
	 * @throws IllegalArgumentException if value is less than 0
	 */
	public Counter(String name, int value) {
		if(value < 0)
			throw new IllegalArgumentException();
		this.value = value;
		this.value = value;	
	}
}
