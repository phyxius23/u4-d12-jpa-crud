package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "evento")
@Getter
@Setter
@ToString
public class Evento {

	// Attributi
	@Id
	@GeneratedValue
	private long id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	//private EventType tipoEvento;
	private int numeroMassimoPartecipanti;

	// Costruttore
	public Evento() {
	}

	public Evento(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		//this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

}
