package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.abstracts.specification.Specification;
import pl.koziarz.specification.domain.entity.Child;
import pl.koziarz.specification.domain.entity.Toy;

public class ChildLikesSpecifiedToySpecification extends AbstractSpecification<Child> {

	private Specification<Toy> s;
	
	public ChildLikesSpecifiedToySpecification(Specification<Toy> s) {
		super();
		this.s = s;
	}

	@Override
	public boolean isSatisfiedBy(Child c) {
		for( Toy t : c.getFavouriteToys()) {
			if( s.isSatisfiedBy(t) )
				return true;
		}
		return false;
	}

}
