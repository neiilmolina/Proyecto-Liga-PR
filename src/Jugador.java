
public class Jugador {

	private String nombre;
	private String curso;
	private String nombreEquipo;

	public Jugador() {
		super();
	}

	public Jugador(String nombre, String curso) {
		super();
		this.nombre = nombre;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", curso=" + curso + ", nombreEquipo=" + nombreEquipo + "]";
	}

}
