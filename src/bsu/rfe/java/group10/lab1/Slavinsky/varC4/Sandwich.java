package bsu.rfe.java.group10.lab1.Slavinsky.varC4;

public class Sandwich extends Food {
	private String[] fillings;
	
	public Sandwich(String fil1, String fil2) {
		super("Бутерброт");
		fillings = new String[2]; 
		fillings[0] = fil1;
		fillings[1] = fil2;
	}
	
	public Sandwich(String fil1) {
		super("Бутерброт");
		fillings = new String[1]; 
		fillings[0] = fil1;
	}
	
	public Sandwich() {
		super("Бутерброт");
		fillings = new String[0];
	}
	
	public void SetFillings(String fil1, String fil2) {
		fillings = new String[2]; 
		fillings[0] = fil1;
		fillings[1] = fil2;
	}
	
	public void SetFillings(String fil1) {
		fillings = new String[1]; 
		fillings[0] = fil1;
	}
	
	public void SetFillings() {
		fillings = null;
	}
	
	public String[] GetFilling() {
		return fillings;
	}
	
	@Override
	public void consume() {
		String ans = this.toString();
		
		if(fillings.length > 0) {
			ans += " с начинкой: ";
			
			for(String s : fillings)
				ans += s + " ";
		}
		
		System.out.println(ans);
	}

	public boolean equals(Object arg0) {
		if (super.equals(arg0)) { 
			if (!(arg0 instanceof Sandwich)) 
				return false;
			
			return fillings.equals(((Sandwich)arg0).fillings); 
		} else
			return false;
	}
	
	@Override
	public int calculateCalories() {
		return 75 + fillings.length * 100;
	}
	
	public String[] getParametrs() {
		return fillings;
	}
}
