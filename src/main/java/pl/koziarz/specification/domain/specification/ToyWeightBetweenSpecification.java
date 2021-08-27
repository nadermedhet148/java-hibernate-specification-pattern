package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.domain.entity.Toy;

public class ToyWeightBetweenSpecification extends AbstractSpecification<Toy> {
	
	private int min;
	private int max;
	
	public ToyWeightBetweenSpecification(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public boolean isSatisfiedBy(Toy t) {
		return ( t.getWeight() > min && t.getWeight() < max );
	}

}
