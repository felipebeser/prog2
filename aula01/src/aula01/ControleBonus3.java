package aula01;

public class ControleBonus3 {
	private double totalBonus;

	public double getTotalBonus() {
		return this.totalBonus;
	}

	public void setTotalBonus(Funcionario3 f3) {
		this.totalBonus += f3.getBonus();
	}
}
