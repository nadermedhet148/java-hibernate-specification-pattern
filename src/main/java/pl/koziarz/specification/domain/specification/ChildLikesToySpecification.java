package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.domain.entity.Child;
import pl.koziarz.specification.domain.entity.Toy;

public class ChildLikesToySpecification extends AbstractSpecification<Child> {
	
	private Toy toy;

	public ChildLikesToySpecification(Toy toy) {
		super();
		this.toy = toy;
	}

	@Override
	public boolean isSatisfiedBy(Child t) {
		return t.getFavouriteToys().contains(toy);
	}

}
