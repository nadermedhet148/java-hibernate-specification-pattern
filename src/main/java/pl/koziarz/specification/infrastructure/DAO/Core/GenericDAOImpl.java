package pl.koziarz.specification.infrastructure.DAO.Core;

import pl.koziarz.specification.domain.specification.AbstractSpecification;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDAOImpl<T, ID extends Serializable>
    implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    protected final Class<T> entityClass;

    protected GenericDAOImpl(Class<T> entityClass , EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }


    public List<T> findAllBySpecification(AbstractSpecification<T> specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(specification.getType());
        Root<T> root = criteriaQuery.from(specification.getType());

        Predicate predicate = specification.toPredicate(root, criteriaBuilder);

        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }


    public T findById(ID id) {
        return em.find(entityClass, id,  LockModeType.NONE);
    }



    public Long getCount(AbstractSpecification<T> specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Long> c =
           em.getCriteriaBuilder().createQuery(Long.class);

        Root<T> root = c.from(specification.getType());

        Predicate predicate = specification.toPredicate(root, criteriaBuilder);
        c.select(criteriaBuilder.count(root)).where(predicate);
        return em.createQuery(c).getSingleResult();
    }

    public T makePersistent(T instance) {
        return em.merge(instance);
    }

    public void makeTransient(T instance) {
        em.remove(instance);
    }

}
