package facades;

import dtos.*;
import entities.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class SpeakerFacade {
    private static SpeakerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private SpeakerFacade() {}

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */

    public static SpeakerFacade getSpeakerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SpeakerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public RenameMeDTO create(RenameMeDTO rm){
        RenameMe rme = new RenameMe(rm.getDummyStr1(), rm.getDummyStr2());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RenameMeDTO(rme);
    }
    public RenameMeDTO getById(long id) { //throws RenameMeNotFoundException {
        EntityManager em = emf.createEntityManager();
        RenameMe rm = em.find(RenameMe.class, id);
//        if (rm == null)
//            throw new RenameMeNotFoundException("The RenameMe entity with ID: "+id+" Was not found");
        return new RenameMeDTO(rm);
    }

    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = getEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }

    public List<SpeakerDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Speaker> query = em.createQuery("SELECT s FROM Speaker s", Speaker.class);
        List<Speaker> rms = query.getResultList();
        return TalkDTO.getDtos(rms);
    }

    public List<SpeakerHasTalkDTO> getTalksFromSpeceficSpeaker(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT t.talk.id, t.talk.topic, t.talk.time FROM SpeakerHasTalk t WHERE t.speaker.id =:id", SpeakerHasTalk.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}

