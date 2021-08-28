package pl.koziarz.specification;

import java.util.HashSet;
import java.util.Set;

import pl.koziarz.specification.abstracts.specification.Specification;
import pl.koziarz.specification.domain.entity.Child;
import pl.koziarz.specification.domain.entity.Toy;
import pl.koziarz.specification.domain.specification.ChildLikesSpecifiedToySpecification;
import pl.koziarz.specification.domain.specification.ChildNameSpecification;
import pl.koziarz.specification.domain.specification.SchoolChildrenSpecification;
import pl.koziarz.specification.domain.specification.ToyColorSpecification;

public class App {

	public static void main(String[] args) {
		

		Toy ferrari = new Toy("Ferrari","Red","racing car",0.4);
		Toy laFireTruck = new Toy("Los Angeles Fire Truck","Red","fire truck",3.0);
		Toy policeCar = new Toy("New York Police Department car","White","police car",0.9);
		Toy timmy = new Toy(" Timmy The Bear","Brown","teddy b ear",0.35);
		
		Child johny = new Child("Johny",7);
		johny.getFavouriteToys().add(ferrari);
		johny.getFavouriteToys().add(laFireTruck);
		
		Child johny2 = new Child("Johny",10);
		johny2.getFavouriteToys().add(policeCar);
		
		Child max = new Child("Max",8);
		max.getFavouriteToys().add(policeCar);
		max.getFavouriteToys().add(laFireTruck);
		
		Child jenny = new Child("Jenny",5);
		jenny.getFavouriteToys().add(timmy);
		
		Set<Child> children = new HashSet<>();
		children.add(johny);
		children.add(johny2);
		children.add(max);
		children.add(jenny);
		
		
		/*
		  Let's find all children named Johny
		 */
		
		ChildNameSpecification spec_johny = new ChildNameSpecification("Johny");
		System.out.println("\nChildren whose name is Johny");
		printSpecified(children, spec_johny);

		/*
		  Let's find all children who like red toys
		 */

		Specification<Child> spec_red_toy = new ChildLikesSpecifiedToySpecification(new ToyColorSpecification("Red"));
		System.out.println("\nChildren who likes some red toys");
		printSpecified(children, spec_red_toy);
		
		/*
		  Let's find all children who likes a toy that's not red
		 */
		Specification<Child> spec_not_red_toy = new ChildLikesSpecifiedToySpecification(new ToyColorSpecification("Red").not());
		System.out.println("\nChildren who likes a toy that's not red");
		printSpecified(children, spec_not_red_toy);
		
		/*
		  Let's find all Johnys who like red toys
		 */
		
		Specification<Child> spec_johny_likes_red_toys = spec_johny.and(spec_red_toy);
		System.out.println("\nJohnys who like red toys");
		printSpecified(children, spec_johny_likes_red_toys);
		
		/*
		  Let's find all children, who are going to school (in Poland - from 6 years old to 19 y.o.)
		 */
		Specification<Child> spec_schoolchildren = new SchoolChildrenSpecification();
		System.out.println("\nSchool Children");
		printSpecified(children, spec_schoolchildren);
	}
	
	static <T> void printSpecified(Set<T> set, Specification<T> spec) {
		for(T t : set) {
			if( spec.isSatisfiedBy(t) ) {
				System.out.println(t);
			}
		}
	}

}
