package pl.koziarz.specification.domain.specification;

import pl.koziarz.specification.abstracts.specification.AbstractSpecification;
import pl.koziarz.specification.domain.entity.Child;

public class ChildAgeBetweenInclSpecification extends AbstractSpecification<Child> {

	private int min;
	private int max;
	
	public ChildAgeBetweenInclSpecification( int min, int max ) {
		this.min=min;
		this.max=max;
	}

	@Override
	public boolean isSatisfiedBy(Child t) {
		return t.getAge()>=min && t.getAge()<=max;
	}
	
	
	
}
