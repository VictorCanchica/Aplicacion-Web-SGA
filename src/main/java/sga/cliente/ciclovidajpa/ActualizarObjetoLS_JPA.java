package sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sga.domain.Persona;

public class ActualizarObjetoLS_JPA {
        static Logger log=LogManager.getRootLogger();
    
    public static void main (String[] args){
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
    EntityManager em=emf.createEntityManager();
    
    // paso 1 inicia la transaccion
    EntityTransaction tx= em.getTransaction();
    tx.begin();
    
    //paso 2 ejecutamos sql tipo select
    Persona persona1=em.find(Persona.class, 11);
    log.debug("Objeto encontrado "+persona1);
    
    //paso 3 setvalue
    persona1.setEmail("victorcanchicov@gmail.com");
    
    persona1.setNombre("Vikthor");
    
    //paso4 cerramos tx
    tx.commit();
    log.debug("Objeto modificado "+persona1);
   //cerramos el em
    em.close();
    }
    
}

    

