package pl.koziarz.specification.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Toy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column()
	private String name;
	@Column()
	private String color;
	@Column()
	private String type;
	@Column()
	private double weight;

	@ManyToMany(mappedBy = "favouriteToys")
	private Set<Child> children  = new HashSet<>();

	public Toy(){

	}
	
	public Toy(String name, String color, String type, double weight) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Toy [name=" + name + ", color=" + color + ", type=" + type + ", weight=" + weight + "]";
	}
}
