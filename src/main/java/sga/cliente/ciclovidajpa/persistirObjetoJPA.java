package sga.cliente.ciclovidajpa;


import javax.persistence.*;
import org.apache.logging.log4j.*;
import sga.domain.Persona;

public class persistirObjetoJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main (String[] args){
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
    EntityManager em=emf.createEntityManager();
    EntityTransaction tx= em.getTransaction();
    //inicia la transaccion
    //Paso 1. crea nuevo objeto
    //objeto en estado transitivo
    Persona persona1=new Persona("Pedro", "Luna", "pl@mail.com", "123456");
    
    //paso 2 inica la transaccion
    tx.begin();
    //paso 3 Ejecuta SQL
    em.persist(persona1);
    log.debug("Objeto persistido-aun sin commit "+persona1);
    //paso 4 Commit o rollback
    tx.commit();
    //objeto en estado detached
    log.debug("Objeto persistido-estado detached "+persona1);
    //paso 5 cerramos em
    em.close();
    }
    
}
