package schjoin.SCH.repository;

import org.springframework.stereotype.Repository;
import schjoin.SCH.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }

    public List<User> findAll(){
        return em.createQuery("select m from Member m", User.class)
                .getResultList();
    }

    public List<User> findByLoginId(String LoginId){
        return em.createQuery("select m from Member m where m.loginId = :loginId", User.class)
                .setParameter("loginId",LoginId)
                .getResultList();
    }


}