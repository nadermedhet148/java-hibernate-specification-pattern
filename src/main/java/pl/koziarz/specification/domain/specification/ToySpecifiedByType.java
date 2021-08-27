package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.abstracts.specification.Specification;
import pl.koziarz.specification.domain.entity.Toy;
import pl.koziarz.specification.domain.entity.ToyType;

public class ToySpecifiedByType extends AbstractSpecification<Toy> {

	private Specification<ToyType> spec;

	public ToySpecifiedByType(Specification<ToyType> spec) {
		super();
		this.spec = spec;
	}
	
	public boolean isSatisfiedBy(Toy t) {
		return spec.isSatisfiedBy(t.getType());
	}
	
}
