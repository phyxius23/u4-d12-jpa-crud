package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;

public class EventoDAO {

	// Attributo
	private final EntityManager em;

	// Costruttore
	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	// SAVE
	public void save(Evento e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
		transaction.commit();
	}

	// GETBYID
	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

	// DELETE
	public void delete(long id) {
		Evento found = em.find(Evento.class, id);

		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento con id " + id + " è stato eliminato!");
		}
	}

	// REFRESH
	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		found.setNumeroMassimoPartecipanti(50);
		found.setDescrizione("Descrizione cambiata2");
		found.setTitolo("Cena con delitto");
		System.out.println("PRIMA DEL REFRESH: " + found);
		em.refresh(found);
		System.out.println("DOPO IL REFRESH: " + found);
	}

}
