package facades;

import dtos.ConferenceDTO;
import dtos.RenameMeDTO;
import entities.Conference;
import entities.RenameMe;
import utils.EMF_Creator;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    public List<ConferenceDTO> getAllConferences(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("SELECT c FROM Conference c", Conference.class);
        List<Conference> rms = query.getResultList();
        return ConferenceDTO.getDtos(rms);
    }
}
