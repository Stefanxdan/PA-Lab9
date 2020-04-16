package repo;

import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {

    PersistenceUtil persistenceUtil =  PersistenceUtil.getInstance();
    EntityManagerFactory entityManagerFactory = persistenceUtil.getEntityManagerFactory();
    EntityManager em = entityManagerFactory.createEntityManager();

    public ArtistRepository() {
        em.getTransaction().begin();
    }

    public void create(Artist artist){
        em.persist(artist);
    }

    public Artist findById( int id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> findByName(String name) {
        List<Artist> artistList;
        TypedQuery<Artist> query =
                em.createNamedQuery("Artist.findByName", Artist.class).setParameter("name", name);
        artistList = query.getResultList();
        return artistList;
    }
}
