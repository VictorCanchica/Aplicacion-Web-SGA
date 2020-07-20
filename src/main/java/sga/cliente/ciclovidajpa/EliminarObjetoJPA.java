package sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sga.domain.Persona;

public class EliminarObjetoJPA {
        static Logger log=LogManager.getRootLogger();
    
    public static void main (String[] args){
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
    EntityManager em=emf.createEntityManager();
    
    // paso 1 inicia la transaccion
    EntityTransaction tx= em.getTransaction();
    tx.begin();
    //paso 2 ejecutamos el sql select
    Persona persona1=em.find(Persona.class, 11);
    //paso 3 cerramos tx1
    tx.commit();
    log.debug("objeto encontrado " +persona1);
    //paso 4 iniciamos 2da tx
    EntityTransaction tx2= em.getTransaction();
    tx2.begin();
    //paso 5 ejecutamos delete sql
    em.remove(em.merge(persona1));
    //paso 6  cerramos tx2
    tx2.commit();
   //objeto en estado detached
   log.debug("objeto ya eliminado "+persona1);
   //cerramos el em
    em.close();
    }
    
}


