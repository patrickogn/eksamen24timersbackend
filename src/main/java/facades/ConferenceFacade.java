package facades;

import dtos.ConferenceDTO;
import dtos.RenameMeDTO;
import entities.Conference;
import entities.ConferenceHasTalk;
import entities.RenameMe;
import utils.EMF_Creator;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ConferenceFacade {
    private static ConferenceFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private ConferenceFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static ConferenceFacade getConferenceFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ConferenceFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ConferenceDTO createConference(ConferenceDTO rm){
        Conference conference = new Conference(rm.getId(), rm.getName(), rm.getLocation(), rm.getCapacity(), rm.getDate(), rm.getTime());
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(conference);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ConferenceDTO(conference);
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

    public List<ConferenceDTO> getAllConferences(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("SELECT c FROM Conference c", Conference.class);
        List<Conference> rms = query.getResultList();
        return ConferenceDTO.getDtos(rms);
    }

    public ConferenceDTO createConference(Integer id, String name, String location, Integer capacity, Date date, Time time) {
        EntityManager em = emf.createEntityManager();


        Conference conference = new Conference(id,name,location,capacity,date,time);

        try {
            em.getTransaction().begin();
            em.persist(conference);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ConferenceDTO(conference);
    }

    public List<ConferenceDTO> getConferenceTalks(Integer id_conference) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c.talk.id, c.talk.topic, c.talk.time FROM ConferenceHasTalk c WHERE c.conference.id =:id_conference", ConferenceHasTalk.class);
        query.setParameter("id_conference", id_conference);

        return query.getResultList();
    }
}
