import java.util.ArrayList;
import java.util.Scanner;

//Clase Equipo entera Javier
public class Equipo {

	// Declaracion de los atributos
	private ArrayList<Jugador> plantilla = new ArrayList<Jugador>();
	private String nombre;
	private int puntos;

	// Generacion de los constructores
	public Equipo() {
		super();
	}

	public Equipo(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}

	// Generacion de getters y setters
	public ArrayList<Jugador> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(ArrayList<Jugador> plantilla) {
		this.plantilla = plantilla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "El equipo " + nombre + " ha conseguido " + puntos + " puntos";
	}

	// Metodo encargado de añadir a los objetos de jugadoe al arraylist de jugador
	public void fichar(Jugador jugador) {
		plantilla.add(jugador);
		jugador.setNombreEquipo(nombre);

	}

	// Metodo encargado de listar el contenido de los jugadores dando la opcion si
	// listar por nombre, curso, nombre del equipo o todo.
	public void listar() {

		int opcion;

		Scanner lector = new Scanner(System.in);

		System.out.println("Opcion de listado: \n 1-Todo, \n 2-Nombre, 3-Curso, 4-Nombre de Equipo");
		opcion = lector.nextInt();
		lector.nextLine();

		switch (opcion) {
		case 1:
			for (Jugador elemento : plantilla) {

				System.out.println(elemento.toString());

			}
			break;
		case 2:
			for (Jugador elemento : plantilla) {

				System.out.println(elemento.getNombre());

			}
			break;
		case 3:
			for (Jugador elemento : plantilla) {

				System.out.println(elemento.getCurso());

			}
			break;
		case 4:
			for (Jugador elemento : plantilla) {

				System.out.println(elemento.getNombreEquipo());

			}
			break;
		}
	}

	// Metodo encargado de eliminar a un jugador que este en el arraylist plantilla
	// dando la opcionde despedir por:
	// 1-Nombre, 2-Curso, 3-Nombre de Equipo, 4-Ninguno
	public void despedir(Equipo seleccionado) {
		String nombre = "";
		String nombreEquipo = "";
		String curso = "";
		int opcion;

		Scanner lector = new Scanner(System.in);

		System.out.println(
				"Selecciona la opciona para despedir: \n 1-Nombre \n 2-Curso \n 3-Nombre de Equipo \n 4-Ninguno");
		opcion = lector.nextInt();
		lector.nextLine();

		switch (opcion) {
		case 1:
			System.out.println("Que nombre desea eliminar?");
			nombre = lector.nextLine();

			seleccionado.despedirNombre(nombre);
			break;
		case 2:
			System.out.println("Que curso desea eliminar?");
			curso = lector.nextLine();

			seleccionado.despedirCurso(curso);
			break;
		case 3:
			System.out.println("Que nombre de equipo desea eliminar?");
			nombreEquipo = lector.nextLine();

			seleccionado.despedirNombreEquipo(nombreEquipo);
			break;
		default:
		}
	}

	// Metodo encargado de despedir segun el nombre que introduzca el usuario
	public void despedirNombre(String nombre) {
		boolean esta = false;
		int contador = 0;
		int pos = buscarJugador(nombre);
		if (pos != -1) {
			plantilla.remove(contador);
		} else {
			System.out.println("El nombre introducido no esta en la plantilla del " + nombre);
		}
	}

	// Metodo encargado de despedir segun el curso que introduzca el usuario
	public void despedirCurso(String curso) {
		for (int i = 0; i < plantilla.size(); i++) {
			if (curso.equals(plantilla.get(i).getCurso())) {
				plantilla.remove(i);
			}
		}
	}

	// Metodo encargado de despedir segun el nombre del equipo que introduzca el
	// usuario
	public void despedirNombreEquipo(String nombreEquipo) {
		for (int i = 0; i < plantilla.size(); i++) {
			if (nombreEquipo.equals(plantilla.get(i).getNombreEquipo())) {
				plantilla.remove(i);
			}
		}
	}

	// Metodo encargado de modificar o el nombre, curso o nombre del equipo de un
	// jugador
	public void modificar(Equipo seleccionado) {
		String nombre = "";
		String nombrec = "";
		String curso = "";
		String cursoCambiado = "";
		String nombreEquipo = "";
		String nombreEquipoCambiado = "";
		int opcion;
		Scanner lector = new Scanner(System.in);

		System.out.println(
				"Selecciona el elemento a modificar:  \n 1-Nombre \n 2-Curso \n 3-Nombre de Equipo \n 4-Ninguno");
		opcion = lector.nextInt();
		lector.nextLine();

		switch (opcion) {
		case 1:
			System.out.println("Que nombre desea modificar?");
			nombrec = lector.nextLine();

			System.out.println("Que nombre desea poner");
			nombre = lector.nextLine();

			seleccionado.modificarNombre(nombre, nombrec);
			break;
		case 2:
			System.out.println("Que curso desea modificar?");
			cursoCambiado = lector.nextLine();

			System.out.println("Que curso desea poner");
			curso = lector.nextLine();

			seleccionado.modificarCurso(curso, cursoCambiado);
			break;
		case 3:
			System.out.println("Que nombre de equipo desea modificar?");
			nombreEquipoCambiado = lector.nextLine();

			System.out.println("Que nombre de equipo desea poner");
			nombreEquipo = lector.nextLine();

			seleccionado.modificarNombreEquipo(nombreEquipo, nombreEquipoCambiado);
		default:
		}
	}

	private int buscarJugador(String nombre) {
		boolean esta = false;
		int pos = -1;
		int contador = 0;
		while (!esta && contador < plantilla.size()) {
			if (nombre.equals(plantilla.get(contador).getNombre())) {
				pos = contador;
				esta = true;
			}
			contador++;
		}
		return pos;
	}

	// Metodo encargado de modificar el nombre que introduzca el usuario
	public void modificarNombre(String nombre, String nombreCambiado) {
		int pos = buscarJugador(nombre);
		if (pos != -1) {
			plantilla.get(pos).setNombre(nombreCambiado);
		} else {
			System.out.println("El nombre introducido no esta en la plantilla del " + nombre);
		}
	}

	// Metodo encargado de modificar el curso que introduzca el usuario
	public void modificarCurso(String curso, String cursoCambiado) {
		int pos = buscarJugador(nombre);
		if (pos != -1) {
			plantilla.get(pos).setCurso(cursoCambiado);
		} else {
			System.out.println("El nombre introducido no esta en la plantilla del " + nombre);
		}
	}

	// Metodo encargado de modificar el nombre del equipo que introduzca el usuario
	public void modificarNombreEquipo(String nombreEquipo, String nombreEquipoCambiado) {
		int pos = buscarJugador(nombre);
		if (pos != -1) {
			plantilla.get(pos).setNombreEquipo(nombreEquipoCambiado);
		} else {
			System.out.println("El nombre introducido no esta en la plantilla del " + nombre);
		}
	}

	// Metodo que srive solo para mostrar los nombres a la hora de preguntar que
	// equipo se quiere modificar.
	public static String mostrarNombres(ArrayList<Equipo> item) {
		String result = "";
		for (Equipo elemento : item) {
			result = result + " " + elemento.getNombre();
		}
		return result;
	}
}