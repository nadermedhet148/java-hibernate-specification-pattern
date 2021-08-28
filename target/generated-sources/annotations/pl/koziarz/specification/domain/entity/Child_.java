package pl.koziarz.specification.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Child.class)
public abstract class Child_ {

	public static volatile SetAttribute<Child, Toy> favouriteToys;
	public static volatile SingularAttribute<Child, String> name;
	public static volatile SingularAttribute<Child, Long> id;
	public static volatile SingularAttribute<Child, Integer> age;

}

