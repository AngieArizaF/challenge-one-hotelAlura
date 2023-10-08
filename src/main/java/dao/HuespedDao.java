package dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import modelo.Huesped;

public class HuespedDao implements IDao<Huesped> {
	
	private EntityManager entityManager;

	public HuespedDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Optional<Huesped> get(long id) {
		return Optional.ofNullable(entityManager.find(Huesped.class, id));
	}

	@Override
	public List<Huesped> getAll() {
		String jpql = "SELECT h FROM Huesped AS h";
		Query query = entityManager.createQuery(jpql, Huesped.class);
        return query.getResultList();
	}

	@Override
	public void save(Huesped huesped) {
		executeInsideTransaction(entityManager -> entityManager.persist(huesped));
	}

	@Override
	public void update(Huesped huesped) {
		executeInsideTransaction(entityManager -> entityManager.merge(huesped));
	}

	@Override
	public void delete(Huesped huesped) {
		executeInsideTransaction(entityManagerP -> entityManagerP.remove(huesped));		
	}

	//Consumer<EntityManager> action = 
	//						entityManager -> entityManager.remove(huesped)
	//																.accept(entityManager)
	
	//void action(EntityManager entityManager){
	//		entityManager.remove(huesped)}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit(); 
        }
        catch (RuntimeException e) {
        	//Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            tx.rollback();
            throw e;
        }
    }
}




