package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.EventType;
import entities.Evento;
import utils.JpaUtil;

public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		LocalDate data = LocalDate.now();

		logger.info("Ciao");

		//		LocalDate data1 = data.

		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);

		Evento cenaColosseo = new Evento("Cena al Colosseo3", data.plusDays(4), "Lorem ipsum dolor sit amet",
				EventType.PRIVATO, 1000);
		ed.save(cenaColosseo);
		System.out.println(ed.getById(3).toString());

		ed.delete(1);

		ed.refresh(6);

		ed.modify(8);

		em.close();
		emf.close();

	}

}
