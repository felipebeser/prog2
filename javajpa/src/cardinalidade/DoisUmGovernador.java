package cardinalidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="governadores")
public class DoisUmGovernador {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	@OneToOne(mappedBy = "governador")
	private DoisUmEstado estado;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public DoisUmEstado getEstado() {
		return estado;
	}
	public void setEstado(DoisUmEstado estado) {
		this.estado = estado;
	}
	
	
}
