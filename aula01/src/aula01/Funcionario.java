package aula01;

public class Funcionario {
	protected String cpf;
	protected String nome;
	protected String departamento;
	protected String status;
	protected double salario;
	
//	void bonificacao(double bonus) {
//		salario += bonus;
//	}
	
	
	double getBonus() {
		return this.salario * 0.1;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
