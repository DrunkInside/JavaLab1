package bsu.rfe.java.group10.lab1.Slavinsky.varC4;

public class Cheese extends Food {

	public Cheese() {
			super("Сыр");
		}
	public void consume() {
		System.out.println(this + " съеден");
	}

	public int calculateCalories() {
		return 100;
	}
	public String[] getParametrs() {
		return new String[0];
	}
}
