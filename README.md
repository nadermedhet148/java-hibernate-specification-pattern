# specification-pattern-example
An example how to implement specification pattern in Java

## Specification Pattern - what it is?
Specification object represents conditions that should be met by an object of given type.
Specification must implement method ``toPredicate(Object o)`` that checks, whether object is meeting
expected conditions.
They are especially helpful when retrieving objects from Repositories
(a DAO object with simplified and precised responsibility).

## Example by example
Let's imagine a  management system. We have children who has their names, age and they like toys. Toys have their color, type and weight. Headmaster often wants to query the system for reports. As he doesn't know SQL (but knows a little Java) it would be nice to give him a set of tools to do his daily job in a convenient way.

In our system we have some toys: A red racing ferrari, red fire truck, white police car and a brown teddy bear named Timmy. Children have their preferences regarding toys. Johny (7 y.o.) likes all red cars. Second Johny likes only a white police car, while Max likes fire truck and a police car and Jenny likes only her fluffy Timmy.

Headmaster achieves his goals by using Specifications provided by his development team. They are a fine-grained conditions that are used to query system.

### Simple specification
Simplest form of specification may be the one that is satisfied by children of given name.
```java
public class ChildNameSpecification extends AbstractSpecification<Child> {
	private String name;
	public ChildNameSpecification(String name) {
		this.name=name;
	}
	@Override
	public Predicate toPredicate(Root<Child> ch, CriteriaBuilder cb) {
		return cb.like(ch.get("name") , name);
	}
}
```
So headmaster can create specification for finding all children named Johny:
```java
Specification<Child> findJohny = new ChildNameSpecification("Johny");
```

### Composite specifications
But what if headmaster wants to find children named Johny or Jenny?
Thanks to methods ``or()``, ``and()`` and ``not()`` specifications may be joined using these logic operations. Specification below allows to find all Johnys and Jennys in system:
```java
Specification<Child> findJohnyOrJenny = new ChildNameSpecification("Johny").or(new ChildNameSpecification("Jenny"));
```
Or, headmaster may find all children that are not named Johny:
```java
Specification<Child> findAllButJohny = new ChildNameSpecification("Johny").not();
```
