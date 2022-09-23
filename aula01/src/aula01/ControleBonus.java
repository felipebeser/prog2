package aula01;

public class ControleBonus {
	private double totalBonus;

	public double getTotalBonus() {
		return this.totalBonus;
	}

	public void setTotalBonus(Funcionario f1) {
		this.totalBonus += f1.getBonus();
	}
}
