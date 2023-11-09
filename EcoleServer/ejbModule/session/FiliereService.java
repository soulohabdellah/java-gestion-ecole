package session;

import java.util.List;

import dao.IDao;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class FiliereService implements IDao<Filiere> {

    @PersistenceContext
    private EntityManager em;
 
	@Override
	@PermitAll    public boolean create(Filiere filiere) {
        try {
            em.persist(filiere);
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }

	@Override
	@PermitAll    public boolean update(Filiere filiere) {
        try {
            em.merge(filiere); 
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public boolean delete(Filiere filiere) {
        try {
            em.remove(filiere);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	@PermitAll    public Filiere findById(int id) {
        return em.find(Filiere.class, id);
    }

	@Override
	@PermitAll    public List<Filiere> findAll() {
        jakarta.persistence.Query query = em.createQuery("SELECT f FROM Filiere f", Filiere.class);
        return query.getResultList();
    }
}
