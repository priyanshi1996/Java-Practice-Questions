package practice;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LambdaExample {
	
	public static void main(String[] args) {
		Comparator<Student> comparator = (s1,s2) -> {
			if(s1.marks < s2.marks)
					return -1;
			else return 1;
		};
		Set<Student> set = new TreeSet<>(comparator);
		set.add(new Student(10,"priya"));
		set.add(new Student(34,"agarwal"));
		set.add(new Student(3,"abcde"));
		System.out.println(set);
		
	}

}

class Student{
	int marks;
	String name;
	Student(int marks, String name){
		this.marks = marks;
		this.name = name;
	}
	
	public String toString() {
		return marks+" "+name;
	}
}
