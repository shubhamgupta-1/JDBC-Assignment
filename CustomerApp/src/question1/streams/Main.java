package question1.streams;

import java.util.*;

public class Main {
	public static void main(String[] args) {
//		Q1. consider Map and data as given below:
		Map<String, Integer> map1=new HashMap<>();
				map1.put("raj", 95);
				map1.put("ekta", 75);
				map1.put("rajiv", 85);
				map1.put("sunita", 66);
				map1.put("gunika", 99);	
				

				System.out.println("\n1. print map using stream");
				map1.entrySet().stream().forEach( s->System.out.println(s.getKey()+" = "+s.getValue()));

				System.out.println("\n2. print only that recrods that contain key contains raj");
				map1.entrySet().stream()
				.filter(s-> s.getKey().contains("raj"))
				.forEach( s->System.out.println(s.getKey()+" = "+s.getValue()));
				
				
				System.out.println("\n3. print map sorted by key");
				map1.entrySet().stream()
				.sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
				.forEach( s->System.out.println(s.getKey()+" = "+s.getValue()));
				
				System.out.println("\n4. print map sorted by values");
				map1.entrySet().stream()
				.sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
				.forEach( s->System.out.println(s.getKey()+" = "+s.getValue()));
				
				System.out.println("\n5. print map reverse sorted by the key");
				map1.entrySet().stream()
				.sorted((e1,e2) -> e2.getKey().compareTo(e1.getKey()))
				.forEach( s->System.out.println(s.getKey()+" = "+s.getValue()));
				
				
//		5. consider key as user define key:
		 	Map<Student, Integer> map=new HashMap<>();
				map.put(new Student(109, "raj", 95), 95);
				map.put(new Student(1, "keta", 78), 78);
				map.put(new Student(11, "gunika", 98), 98);
				map.put(new Student(19, "keshav", 97), 97);
				

				System.out.println("\nPrint all records sorted as per name of the student");
				map.entrySet().stream()
				.sorted((e1,e2) -> e1.getKey().getName().compareTo(e2.getKey().getName()))
				.forEach( s->System.out.println(s.getKey()));

				System.out.println("\nPrint all records sorted as per id of the student");
				map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getId)))
				.forEach(e-> System.out.println(e.getKey()));
	}

}
