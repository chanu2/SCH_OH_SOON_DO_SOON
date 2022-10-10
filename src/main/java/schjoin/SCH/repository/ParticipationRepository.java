package schjoin.SCH.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import schjoin.SCH.domain.Participation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipationRepository {

    private final EntityManager em;

    public void save(Participation participation){
        em.persist(participation);
    }

    public Participation findOne(Long id){
        return em.find(Participation.class,id);
    }



    public void delete(Long id){
         em.createQuery("delete from Participation p where p.id = :id ").setParameter("id",id).executeUpdate();
    }


}