package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static PersistenceUtil single_instance = null;
    private final EntityManagerFactory factory;

    //constructor privat
    private PersistenceUtil() {
        factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    // pentru a face clasa de tip singleton
    // apelam constructorul doar daca nu am creat nicio instanta pana acum
    public static PersistenceUtil getInstance(){
        if (single_instance == null)
            single_instance = new PersistenceUtil();
        return single_instance;
    }

    public  EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
}
