package br.edu.ifsp.work;

import java.time.LocalDate;

import br.edu.ifsp.labors.Doctor;
import br.edu.ifsp.labors.Engineer;
import br.edu.ifsp.labors.Professor;

public class Start {
	
	public static void main(String[] args) {
		//testEngineer();
		//testDoctor();
		//testProfessor();
	}

	private static void testProfessor() {
		LocalDate now = LocalDate.now();
		Professor p1 = new Professor("Roberto Bolgheroni", now);
		Professor p2 = new Professor("Roberto Bolgheroni", now);
		//
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1.equals(p2));
		//
		p2.setName("Roberto Oliveira");
		//
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p1.equals(p2));		
	}

	private static void testDoctor() {
		LocalDate now = LocalDate.now();
		Doctor d1 = new Doctor("Lucas Viana", 15, now);
		Doctor d2 = new Doctor("Lucas Viana", 15, now);
		//
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		System.out.println(d1.equals(d2));
		//
		d2.setName("Lucas Souza");
		//
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		System.out.println(d1.equals(d2));
	}

	private static void testEngineer() {
		Engineer e1 = new Engineer("Henrique Bolgheroni", "123.456.789-00");
		Engineer e2 = new Engineer("Henrique Bolgheroni", "123.456.789-00");
		//
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e1.equals(e2));
		//
		e2.setName("Roberto Bolgheroni");
		//
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e1.equals(e2));
	}
	
}
