package sga.cliente.cascada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;
import sga.domain.Persona;
import sga.domain.Usuario;

public class PersistenciaCascadaJPA {
    
    static Logger log=LogManager.getRootLogger();
    public static void main (String[] args){
EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
EntityManager em=emf.createEntityManager();
EntityTransaction tx=em.getTransaction();
tx.begin();

//paso 1 creamos un nuevo objeto
Persona persona1=new Persona("Huugo", "Hernandez", "hher@mail.com", "555444");
//creamos objeto usuario
Usuario usuario1=new Usuario("hheeer", "123", persona1);

//paso 3 persistimos el objeto usuario unicamente
em.persist(usuario1);
tx.commit();
log.debug("objeto persistido persona: "+persona1);
log.debug("objeto persistido usuario: "+usuario1);
em.close();



    
    }
    
}
