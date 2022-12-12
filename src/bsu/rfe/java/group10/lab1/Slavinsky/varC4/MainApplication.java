package bsu.rfe.java.group10.lab1.Slavinsky.varC4;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

class MainApplication {

	public static void main(String[] args) throws Exception {
		final int breakfastSize = 20;
		
		Food[] breakfast = new Food[breakfastSize];
		boolean needSort = false;
		boolean needCalc = false;

		int itemId = 0;
		
		for (String arg: args) {
			
			if(arg.equals("-calories")) {
				needCalc = true;
				continue;
			}
			
			if(arg.equals("-sort")) {
				needSort = true;
				continue;
			}
			
			if(itemId >= breakfastSize)
				continue;
			
			String[] parts = arg.split("/");
			
			try {
				Class<?> myClass = Class.forName("bsu.rfe.java.group10.lab1.Slavinsky.varC4." + parts[0]);
				
				if(parts.length == 1) {
					Constructor<?> constuctor = myClass.getConstructor();
					breakfast[itemId] = (Food)constuctor.newInstance();
				}
				else if(parts.length == 2) {
					Constructor<?> constuctor = myClass.getConstructor(String.class);
					breakfast[itemId] = (Food)constuctor.newInstance(parts[1]);
				}
				else if(parts.length == 3) {
					Constructor<?> constuctor = myClass.getConstructor(String.class, String.class);
					breakfast[itemId] = (Food)constuctor.newInstance(parts[1], parts[2]);
				}
			}
			catch (ClassNotFoundException e) {
				System.out.println(parts[0] + " нельзя добавить в завтрак");
				continue;
			}
			catch(NoSuchMethodException e) {
				String answer = parts[0] + " нельзя добавить с параметрами: ";
				for(int i = 1; i < parts.length; ++i)
					answer += parts[i] + " ";
				System.out.println(answer);
				continue;
			}
			
			itemId++;
		}
		
		if(needSort) {
			Arrays.sort(breakfast, new Comparator<Food>() {
				public int compare(Food o1, Food o2) {
					if(o1 == null || o2 == null)
						return 0;
					
					int s1 = o1.getParametrs().length;
					int s2 = o2.getParametrs().length;
					
					if(s1 > s2)
						return -1;
					if(s1 < s2)
						return 1;
					return 0;
				}
			});
		}
		
		
		for (Food item: breakfast)
			if (item!=null)
				item.consume();
			else
				break;
		
		if(needCalc) {
			int calories = 0;
			for(Food f : breakfast) {
				if (f == null)
					continue;
				calories += f.calculateCalories();
			}
			System.out.println("Количество каллорий: " + Integer.toString(calories));
		}
		
		System.out.println("Всего хорошего!");
	}

}
