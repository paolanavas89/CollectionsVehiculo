
public class Vehiculo {

	private String matricula;
	private String color;

	public Vehiculo() {

	}

	public Vehiculo(String matricula, String color) {

		this.matricula = matricula;
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {

		return matricula + " " + color + " ";
	}

}
