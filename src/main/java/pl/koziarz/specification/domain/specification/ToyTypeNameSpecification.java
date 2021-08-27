package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.abstracts.specification.Specification;
import pl.koziarz.specification.domain.entity.Toy;
import pl.koziarz.specification.domain.entity.ToyType;

public class ToyTypeNameSpecification extends AbstractSpecification<ToyType> {

	private String name;

	public ToyTypeNameSpecification(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean isSatisfiedBy(ToyType t) {
		return t.getName().equals(name);
	}

}
