
public class StaticFields {
	
	private static int nOfBicycles = 0;
	private int serialNumber;
	
	public StaticFields() {
		serialNumber = StaticFields.nOfBicycles;
		nOfBicycles++;
	}
	
	public StaticFields(int sn) {
		this.serialNumber = sn;
	}
	
	// static factory method example
	public static StaticFields newConstructor(int newSN) {
		return new StaticFields(newSN);
	}
	
	public static void main(String[] args) {
		StaticFields s1 = new StaticFields();
		
		StaticFields s2 = new StaticFields();
		StaticFields s3 = new StaticFields();
		System.out.println(s1.serialNumber + " " + s2.serialNumber + " " + s3.serialNumber);
		System.out.println("Total number of bikes created: " + nOfBicycles);
		deleteBikes();
		System.out.println("Total number of bikes created: " + nOfBicycles);
	}
	
	public static int deleteBikes() {
		System.out.println("One bike garbaged");
		return --nOfBicycles;
	}
}

