package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.domain.entity.Toy;

public class ToyColorSpecification extends AbstractSpecification<Toy> {

	private String color;

	public ToyColorSpecification(String color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isSatisfiedBy(Toy t) {
		return t.getColor().equals(color);
	}

}
