package com.spring.calculator.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    //Persistence unit yra konfiguracija, kuri sujungia objektus ir su jais susijusius parametrus,
    //leidziancius tvarkyti ir islaikyti duomenis duomenu bazeje.
    //Persistence unit yra apibreziamas persistence.xml faile, esanciame META-INF kataloge.
    //Siame faile nurodoma kaip objektai yra valdomi ir saugomi duomenu bazeje.
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    //EntityManagerFactory yra atsakingas uz EntityManager egzemplioriu (instanciju) sukurima,
    //naudojamu sveikai su duomenu baze, kurima ir tvarkyma
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown(){
        if(factory != null){
            factory.close();
        }
    }
}
