package pl.koziarz.specification;

import java.util.List;
import java.util.Set;

import pl.koziarz.specification.domain.entity.Child;
import pl.koziarz.specification.domain.entity.ChildNameSpecification;
import pl.koziarz.specification.domain.entity.Toy;
import pl.koziarz.specification.infrastructure.Connection.JPASetup;
import pl.koziarz.specification.infrastructure.DAO.ChildDAO;
import pl.koziarz.specification.infrastructure.DAO.ToyDAO;

import javax.persistence.EntityManager;

public class App {

	public static void main(String[] args) throws Exception {


		JPASetup JPA = new JPASetup("APP");

		seedWithData(JPA.createEntityManager());



		ChildDAO childDAO = new ChildDAO(JPA.createEntityManager());
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nChildren whose name is Johny");
		ChildNameSpecification spec_johny = new ChildNameSpecification("Johny");
		List<Child> children =  childDAO.findAllBySpecification(spec_johny);
		printSpecified(children);
		System.out.println("--------------------------------------------------------------------");

	}

	private static void seedWithData(EntityManager em) {
		ChildDAO childDAO = new ChildDAO(em);
		ToyDAO toyDOA = new ToyDAO(em);
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

		em.getTransaction().begin();


		toyDOA.makePersistent(ferrari);
		toyDOA.makePersistent(laFireTruck);
		toyDOA.makePersistent(policeCar);
		toyDOA.makePersistent(timmy);
		childDAO.makePersistent(johny);
		childDAO.makePersistent(johny2);
		childDAO.makePersistent(max);
		childDAO.makePersistent(jenny);

		em.getTransaction().commit();
	}

	static <T> void printSpecified(List<T> set) {
		for(T t : set) {
			System.out.println(t);
		}
	}

}
