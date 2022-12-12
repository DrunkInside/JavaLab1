package bsu.rfe.java.group10.lab1.Slavinsky.varC4;

public class Apple extends Food {

	private String size;
	
	public Apple(String size) {
		super("Яблоко");
		this.size = size;
	}
	
	public void consume() {
		System.out.println(this + " съедено");
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public boolean equals(Object arg0) {
		if (super.equals(arg0)) { 
			if (!(arg0 instanceof Apple)) return false; 
			return size.equals(((Apple)arg0).size); 
		} else
			return false;
	}
	
	public String toString() {
		return super.toString() + " размера '" + size.toUpperCase() + "'";
	}

	@Override
	public int calculateCalories() {
		if (size.equals("малое"))
			return 25;
		return 50;
	}
	
	public String[] getParametrs() {
		if(size == null)
			return new String[0];
		
		String[] answer = new String[1];
		answer[0] = size;
		return answer;
	}
}
