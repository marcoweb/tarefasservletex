package tarefasservlet.models;

import java.util.Hashtable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TarefaRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TarefaPU");
    private EntityManager em = emf.createEntityManager();

    public Hashtable<Integer, Tarefa> fetchAll() {
        Hashtable<Integer, Tarefa> resultado = new Hashtable<Integer, Tarefa>();

        for (Tarefa t : em.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList()) {
            resultado.put(t.getId(), t);
        }

        return resultado;
    }

    public void save(Tarefa tarefa) {
        em.getTransaction().begin();
        em.persist(tarefa);
        em.getTransaction().commit();
    }
}
