package pl.koziarz.specification.abstracts.specification;

public interface Specification<T> {
	public boolean isSatisfiedBy(T t);
}
