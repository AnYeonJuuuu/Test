package main;

import person.Person;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== Objest Practice =====");
		
		Person p1 = new Person();

		p1.setAddr("테헤란");
		p1.setAge(20);
		p1.setBirth(20021222);
		p1.setGender('F');
		p1.setName("안연주");
		
		System.out.println(p1.getAddr());
		System.out.println(p1.getAge());
		System.out.println(p1.getBirth());
		System.out.println(p1.getGender());
		System.out.println(p1.getName());
	}

}
