package pl.koziarz.specification.domain.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column()
	private String name;

	@Column()
	private int age;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "CHILD_TOY",
			joinColumns = @JoinColumn(name = "CHILD_ID"),
			inverseJoinColumns = @JoinColumn(name = "TOY_ID")
	)
	private Set<Toy> favouriteToys = new HashSet<>();
	
	public Child(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Child() {
	}
	
	public int getAge() {
		return age;
	}
	
	public Set<Toy> getFavouriteToys() {
		return favouriteToys;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFavouriteToys(Set<Toy> favouriteToys) {
		this.favouriteToys = favouriteToys;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + ", favouriteToys=" + favouriteToys + "]";
	}
	
}
