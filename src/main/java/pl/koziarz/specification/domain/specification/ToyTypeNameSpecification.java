package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;

public class ToyTypeNameSpecification extends AbstractSpecification<String> {

	private String name;

	public ToyTypeNameSpecification(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean isSatisfiedBy(String t) {
		return t.equals(name);
	}

}
