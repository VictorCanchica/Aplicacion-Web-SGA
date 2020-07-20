package sga.cliente.ciclovidajpa;


import javax.persistence.*;
import org.apache.logging.log4j.*;
import sga.domain.Persona;

public class EncontrarObjetoJPA {
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
   log.debug("objeto recuperado "+persona1);
   //cerramos el em
    em.close();
    }
    
}
