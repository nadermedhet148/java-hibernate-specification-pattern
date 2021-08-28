package pl.koziarz.specification.infrastructure.DAO;

import pl.koziarz.specification.domain.entity.Child;
import pl.koziarz.specification.infrastructure.DAO.Core.GenericDAOImpl;

import javax.persistence.EntityManager;

public class ChildDAO extends GenericDAOImpl<Child , Long> {
    public ChildDAO(EntityManager em){
        super(Child.class,em);
    }
}
