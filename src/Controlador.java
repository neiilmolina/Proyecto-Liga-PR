import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		// 1º- Fichar
		// 2º- Despedir
		// 3º- Modificar
		// 4º- Listar

		// Creacion de objetos e implementar los metodos de las clase Equipo para fichar
		// y añadir el equipo: Javier
		int opcion;

		Jornada jornada = new Jornada();

		ArrayList<Equipo> equipos = new ArrayList<Equipo>();

		Scanner lector = new Scanner(System.in);

		Jugador Andres = new Jugador("Jose Luis", "DAM");
		Jugador Neil = new Jugador("Pepe", "DAW");
		Jugador Gonzalo = new Jugador("Jose", "DAW");
		Jugador Javier = new Jugador("Javier", "DAM");
		Jugador pepe = new Jugador("Pepe", "DAW");
		Jugador lola = new Jugador("Lola", "DAM");
		Jugador alex = new Jugador("Alex", "DAW");

		Equipo ErVeti = new Equipo("Betis", 0);
		Equipo ErGranada = new Equipo("Granada", 0);
		Equipo ErRayo = new Equipo("Rayo", 0);

		Jornada partidos = new Jornada();

		ErGranada.fichar(Andres);
		ErGranada.fichar(Neil);
		ErGranada.fichar(Javier);
		ErGranada.fichar(Gonzalo);

		ErVeti.fichar(pepe);
		ErVeti.fichar(lola);

		ErRayo.fichar(alex);

		equipos.add(ErVeti);
		equipos.add(ErRayo);
		equipos.add(ErGranada);

		jornada.setEquipos(equipos);
		partidos.setEquipos(equipos);

		// Este bucle do while esta para que el usuario pueda hacer mas de una consulta
		// sin que se detenga el programa

		// Bucle do while Andres
		do {
			System.out.println(
					"Elige la opción que desee realizar: \n1-Modificar Equipos\n2-Añadir Equipo\n3-Mostrar Jornadas\n4-Introducir Resultados\n5-Mostrar Clasificación\n6-Parar");
			opcion = lector.nextInt();
			lector.nextLine();

			switch (opcion) {
			case 1:
				modificarEquipos(equipos);
				break;
			case 2:
				System.out.println("\nIntroduzca el nombre del equipo");
				equipos.add(new Equipo(lector.nextLine(), 0));
				break;
			case 3:
				partidos.partidos();
				break;
			case 4:
				asignarGanador(equipos, jornada);
				break;
			case 5:
				partidos.getClasificacion();
				break;
			case 6:
				System.out.println("\nLa ejecucion del programa ha terminado");
				break;
			default:
				System.out.println("\nLa opcion que has escogido no esta disponible");
				break;
			}

//		System.out.println(partidos.partidos());
//			asignarGanador(equipos, jornada);
		} while (opcion != 6);

		lector.close();
	}

	// Andres
	public static void escribir(ArrayList<Equipo> equipos) {
		String str = equipos.toString();
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("test.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void ganador(ArrayList<Equipo> equipos, String nombre) {
		int sumar = 3;
		int longitud = equipos.size();
		int puntos;
		int contI = 0;
		boolean encontrado = false;

		while (contI < longitud && !encontrado) {
			if (equipos.get(contI).getNombre().equals(nombre)) {
				encontrado = true;
				puntos = equipos.get(contI).getPuntos();
				equipos.get(contI).setPuntos(puntos + sumar);

			}
			contI++;
		}

	}

	// Metodo que pregunta quien ha sido el ganador y le suma puntos: Gonzalo
	private static void asignarGanador(ArrayList<Equipo> equipos, Jornada jornada) {

		ArrayList<String> partidos = jornada.partidos();
		int longitud = partidos.size();
		String[] participantes;
		String participante1, participante2;
		String equipo = "";
		boolean correcto = false;

		Scanner lector = new Scanner(System.in);

		for (int i = 0; i < longitud; i++) {

			do {
				System.out.println(partidos.get(i));
				System.out.println("¿Quien ha ganado?");
				participantes = partidos.get(i).split("VS");
				participante1 = participantes[0].substring(7, participantes[0].length()).trim();
				participante2 = participantes[1].substring(7, participantes[1].length()).trim();
				equipo = lector.nextLine();
				// Comprueba si el equipo elegido es uno de los dos disponibles
				if (equipo.equals(participante1) || equipo.equals(participante2)) {
					ganador(equipos, equipo);
					correcto = true;
				} else {
					System.out.println("\nNo ha introducido bien el nombre del equipo,introduzcalo de nuevo");
				}

			} while (!correcto);

		}

	}

	// Javier
	private static void modificarEquipos(ArrayList<Equipo> equipos) {

		String opcionEquipo;
		int opcionE;
		int contador = 0;
		boolean esta = false;
		String nombre, curso;

		Scanner lector = new Scanner(System.in);

		Equipo seleccionado = new Equipo();
		do {
			System.out.println("\nElige el equipo que quieras modificar: " + Equipo.mostrarNombres(equipos));
			opcionEquipo = lector.nextLine();

			// Con este while se selecciona el equipo con el que se va a interactuar
			while (contador < equipos.size() && !esta) {
				if (opcionEquipo.equals(equipos.get(contador).getNombre())) {
					seleccionado = equipos.get(contador);
					esta = true;
				}
				contador++;
			}
			contador = 0;
			if (!esta) {
				System.out.println("\nEquipo introducido incorrecto");
			}
		} while (!esta);
		do {
			System.out.println(
					"Elige la opción a realizar \n 1-Despedir \n 2-Modificar \n 3-Listar \n 4-Ficha \n 5-Ninguno/Parar");
			opcionE = lector.nextInt();
			lector.nextLine();

			switch (opcionE) {
			// Parte del switch para despedir a un jugador
			case 1:
				seleccionado.despedir(seleccionado);
				break;
			case 2:
				// Parte del switch para modificar un jugador
				seleccionado.modificar(seleccionado);
				break;
			case 3:
				// Parte del switch para listar
				seleccionado.listar();
				break;
			case 4:
				System.out.println("\nIntroduzca el nombre del jugador");
				nombre = lector.nextLine();
				System.out.println("\nIntroduzca el curso del jugador");
				curso = lector.nextLine();
				seleccionado.fichar(new Jugador(nombre, curso));
				break;
			default:
				opcionE = 5;
				break;
			}
		} while (opcionE != 5);
	}
}