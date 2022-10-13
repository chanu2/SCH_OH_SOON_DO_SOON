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

    public List<Participation> findReserveInfo(Long id){
        return em.createQuery("select distinct p from Participation p"+
                " left join fetch p.member m"+
                " left join fetch p.reserve r"+
                " where r.id = :id ",Participation.class).setParameter("id",id).getResultList();
    }


}


/**
 *
 * 1. reserve id 값에 있는 정보만 가져올 수 있는지??
 * 2. 위 코드 방법처럼 했을 때 경기 정보가 아닌 참여한 사용자 정보만을 가져올 수 있는지?
 * 3. 애초에 api를 2개 만들기, 1) 경기 정보를 가져오기 2) 경기 참여한 사용자 정보 가져오기
 *
 * */