package ec.edu.ups.ppw.pruebafinal.dao;

import java.util.List;

import ec.edu.ups.ppw.pruebafinal.model.Consumo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ConsumoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Consumo consumo) {
        em.persist(consumo);
    }

    public void update(Consumo consumo) {
        em.merge(consumo);
    }

    public void delete(int id) {
        Consumo consumo = this.read(id);
        em.remove(consumo);
    }

    public Consumo read(int id) {
        return em.find(Consumo.class, id);
    }

    public List<Consumo> getAll() {
        String jpql = "SELECT c FROM Consumo c";
        Query query = em.createQuery(jpql, Consumo.class);
        return query.getResultList();
    }

    public List<Consumo> findByCedula(String cedula) {
        String jpql = "SELECT c FROM Consumo c WHERE c.cedula = :cedula";
        Query query = em.createQuery(jpql, Consumo.class);
        query.setParameter("cedula", cedula);
        return query.getResultList();
    }
}
