package pl.koziarz.specification.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Toy.class)
public abstract class Toy_ {

	public static volatile SingularAttribute<Toy, String> color;
	public static volatile SetAttribute<Toy, Child> children;
	public static volatile SingularAttribute<Toy, String> name;
	public static volatile SingularAttribute<Toy, Double> weight;
	public static volatile SingularAttribute<Toy, Long> id;
	public static volatile SingularAttribute<Toy, String> type;

}

