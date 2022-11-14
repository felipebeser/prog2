package cardinalidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="estados")
public class DoisUmEstado {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String sigla;
	@OneToOne
	@JoinColumn(name="governador_id")
	private DoisUmGovernador governador;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public DoisUmGovernador getGovernador() {
		return governador;
	}
	public void setGovernador(DoisUmGovernador governador) {
		this.governador = governador;
	}
	
	
}
