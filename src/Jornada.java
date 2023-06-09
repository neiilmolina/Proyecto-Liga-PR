
import java.util.ArrayList;

public class Jornada {

	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();

	@Override
	public String toString() {
		return "Jornada [equipos=" + equipos + "]";
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Jornada() {
		super();
	}

	public void add(Equipo nuevo) {
		equipos.add(nuevo);
	}

	// Imprime por pantalla con quien juega cada equipo en cada jornada:Andres

	public ArrayList<String> partidos() {
		final String CYAN = "\u001B[36m";
		final String AMARILLO = "\u001B[33m";
		final String RESETEAR = "\u001B[0m";
		ArrayList<String> totalPartidos = new ArrayList<String>();
		int longitud = equipos.size();
		int contador1 = longitud;
		int contador2 = 1;

		if (longitud % 2 == 0) {
			for (int i = 1; i < longitud; i++) {
				System.out.println(CYAN + "Jornada " + i + RESETEAR);
				System.out.println("Equipo " + equipos.get(0).getNombre() + " VS " + "Equipo "
						+ (equipos.get(contador1 - 1).getNombre()));

				totalPartidos.add("Equipo " + equipos.get(0).getNombre() + " VS " + "Equipo "
						+ (equipos.get(contador1 - 1).getNombre()));

				for (int j = 1; j < longitud / 2; j++) {

					if (contador1 > 2) {
						contador1--;
					} else {
						contador1 = longitud;
					}
					if (contador2 > longitud - 1) {
						contador2 = 2;
					} else {
						contador2++;
					}
					System.out.println("Equipo " + equipos.get(contador2 - 1).getNombre() + " VS " + "Equipo "
							+ (equipos.get(contador1 - 1).getNombre()));
					totalPartidos.add("Equipo " + equipos.get(contador2 - 1).getNombre() + " VS " + "Equipo "
							+ (equipos.get(contador1 - 1).getNombre()));
				}
				contador1 = longitud - i;
				contador2 = longitud - i;
			}
			// IMPARES
		} else {
			for (int i = 1; i <= longitud; i++) {

				System.out.println(CYAN + "Jornada " + i + RESETEAR);
				System.out.println();
				System.out.println("Descansa " + (equipos.get(contador1 - 1).getNombre()));

				for (int j = 0; j < (longitud / 2); j++) {

					if (contador1 > 1) {
						contador1--;
					} else {
						contador1 = longitud;
					}

					System.out.println("Equipo " + AMARILLO + equipos.get(contador2 - 1).getNombre() + RESETEAR + " VS "
							+ "Equipo " + AMARILLO + (equipos.get(contador1 - 1).getNombre()) + RESETEAR);
					totalPartidos.add("Equipo " + equipos.get(contador2 - 1).getNombre() + " VS " + "Equipo "
							+ (equipos.get(contador1 - 1).getNombre()));
					if (contador2 > longitud - 1) {
						contador2 = 1;
					} else {
						contador2++;
					}
				}
				System.out.println();
				contador1 = longitud - i;
				contador2 = longitud - i + 1;
			}
		}
		return totalPartidos;

	}

	// Ordena los equipos por puntos, de mayor a menor :Gonzalo/Neil
	public void getClasificacion() {
		int longitud = equipos.size();
		Equipo mayor;

		for (int i = 0; i < longitud; i++) {
			equipos.get(i);
			for (int j = 0; j < longitud; j++) {
				equipos.get(j);
				if (equipos.get(i).getPuntos() > equipos.get(j).getPuntos()) {
					mayor = equipos.get(i);
					equipos.set(i, equipos.get(j));
					equipos.set(j, mayor);
				}

			}
		}

		System.out.println(equipos.toString());

	}

}
