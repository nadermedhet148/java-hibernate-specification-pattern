package pl.koziarz.specification.domain.entity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import pl.koziarz.specification.domain.specification.AbstractSpecification;

public class ChildNameSpecification extends AbstractSpecification<Child> {
	public String name;
	public ChildNameSpecification(String name){
		this.name = name;
	}
	@Override
	public Predicate toPredicate(Root<Child> ch, CriteriaBuilder cb) {
		return cb.like(ch.get("name") , name);
	}

}
