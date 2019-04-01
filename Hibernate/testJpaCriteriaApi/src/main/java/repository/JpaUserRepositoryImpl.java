package repository;

import org.springframework.stereotype.Repository;
import user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public User get(int id) {
        return null;
    }


    //https://stackoverflow.com/questions/12199433/jpa-criteria-api-with-multiple-parameters
    public List<User> search() {

        String name = "User";

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<User> root = cq.from(User.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (name != null) {
            predicates.add(qb.equal(root.get("name"), name));
        }

        cq.select(root).where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }

    /*
    String param1 = "1";
    String paramNull = null;

    CriteriaBuilder qb = em.getCriteriaBuilder();
    CriteriaQuery cq = qb.createQuery();
    Root<A> customer = cq.from(A.class);

    //Constructing list of parameters
    List<Predicate> predicates = new ArrayList<Predicate>();

    //Adding predicates in case of parameter not being null
    if (param1 != null) {
        predicates.add(
                qb.equal(customer.get("someAttribute"), param1));
    }
    if (paramNull != null) {
        predicates.add(
                qb.equal(customer.get("someOtherAttribute"), paramNull));
    }
    //query itself
    cq.select(customer)
            .where(predicates.toArray(new Predicate[]{}));
    //execute query and do something with result
    em.createQuery(cq).getResultList();
     */
}
