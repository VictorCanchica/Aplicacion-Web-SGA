package sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sga.domain.Persona;

public class ActualizarObjetoJPA {
        static Logger log=LogManager.getRootLogger();
    
    public static void main (String[] args){
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
    EntityManager em=emf.createEntityManager();
    
    // paso 1 inicia la transaccion
    EntityTransaction tx= em.getTransaction();
    tx.begin();
    
    //Paso 2 ejecuta sql tipo select
    Persona persona1=em.find(Persona.class, 11);
    //paso 3 termina la tx
    tx.commit();
    //objeto en estado detached
    log.debug("objeto recuperado  "+persona1);
    //paso 4 set value
    persona1.setApellido("Jimenez");
    //paso 5 inicia tx 2
    EntityTransaction tx2=em.getTransaction();
    tx2.begin();
    //paso 6  modificamos el objeto
    em.merge(persona1);
    //paso 7 terminamos la tx
    tx2.commit();
    //objeto en estado detached ya modificado
    log.debug("objeto recuperado "+persona1);
   //cerramos el em
    em.close();
    }
    
}

    

