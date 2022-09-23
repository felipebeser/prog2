package aula01;

public class ControleSalarial {
	private double totalSalarios;

	public double getTotalSalarios() {
		return this.totalSalarios;
	}

	public void setTotalSalarios(Funcionario f1) {
		this.totalSalarios += f1.getSalario();
	}
	
	
}
