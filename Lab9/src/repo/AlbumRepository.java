package repo;

import entity.Album;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    PersistenceUtil persistenceUtil =  PersistenceUtil.getInstance();
    EntityManagerFactory entityManagerFactory = persistenceUtil.getEntityManagerFactory();
    EntityManager em = entityManagerFactory.createEntityManager();

    public AlbumRepository() {
        em.getTransaction().begin();
    }
    public void create(Album album){
        em.persist(album);
    }

    public Album findById( int id) {
        return em.find(Album.class, id);
    }

    public List<Album> findByName(String name) {
        List<Album> albumList;
        TypedQuery<Album> query =
                em.createNamedQuery("Album.findByName", Album.class).setParameter("name", name);
        albumList = query.getResultList();
        return albumList;
    }

    public List<Album> findByArtist(int artistID) {
        List<Album> albumList = new ArrayList<>();
        TypedQuery<Album> query =
                em.createNamedQuery("Album.findByArtist", Album.class).setParameter("artistId", artistID);
        albumList = query.getResultList();
        return albumList;
    }
}
