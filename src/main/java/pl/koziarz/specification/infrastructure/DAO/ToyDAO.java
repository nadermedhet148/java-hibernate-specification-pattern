package pl.koziarz.specification.infrastructure.DAO;

import pl.koziarz.specification.domain.entity.Toy;
import pl.koziarz.specification.infrastructure.DAO.Core.GenericDAOImpl;

import javax.persistence.EntityManager;

public class ToyDAO extends GenericDAOImpl<Toy, Long> {
    public ToyDAO(EntityManager em){
        super(Toy.class,em);
    }
}
