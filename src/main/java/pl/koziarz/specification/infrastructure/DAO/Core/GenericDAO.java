package pl.koziarz.specification.infrastructure.DAO.Core;

import pl.koziarz.specification.domain.specification.AbstractSpecification;

import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id);

    List<T> findAllBySpecification(AbstractSpecification<T> specification);

    Long getCount(AbstractSpecification<T> specification);

    T makePersistent(T entity);
    void makeTransient(T entity);


}
