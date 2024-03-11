package unidad6.tarea.t6;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);

		Peluqueria p = new Peluqueria("Peluqueria Elisa", "Avenida Juan Carlos 1");

		int opcion = 0;
		Peluqueria.datosFicticios();

		final String MENU = "\n1 -- Añadir Cliente Nuevo" + "\n2 -- Cortar el Pelo"
				+ "\n3 -- Lista de Clientes con el Pelo Cortado" + "\n4 -- Lista de Clientes sin el Pelo Cortado"
				+ "\n5 -- Eliminar Cliente" + "\n6 -- Salir";
		do {
			try {
				System.out.println(MENU);
				System.out.print("Introduzca una de las opciones que aparecen en el menu anterior: ");
				opcion = scNum.nextInt();

				switch (opcion) {
				case 1:
					Cliente c = Peluqueria.crearCliente();

					Peluqueria.getListaClientes().add(c);

					break;
				case 2:
					int telefono = 0;
					boolean encontrado = false;
					Cliente cortarPelo;
					do {
						Peluqueria.pintarLista(false, false);
						telefono = Peluqueria
								.correccionErrores("\nIntroduzca el telefono del cliente que desea cortar el pelo: ");
						cortarPelo = Peluqueria.buscarCliente(telefono);
						if (cortarPelo == null) {
							System.out.println("No se ha encontrado el numero '" + telefono + "'");
							encontrado = false;
						} else {
							System.out.println("\nPelo Cortado!!!");
							encontrado = true;

						}
					} while (!encontrado);
					cortarPelo.setPeloCortado(true);
					break;
				case 3:
					System.out.println("\n-------- CLIENTES CON EL PELO CORTADO --------");
					Peluqueria.pintarLista(true, false);

					break;
				case 4:
					System.out.println("\n-------- CLIENTES SIN EL PELO CORTADO --------");
					Peluqueria.pintarLista(false, false);

					break;
				case 5:
					Peluqueria.pintarLista(true, true);

					Peluqueria.eliminarCliente();
					break;
				case 6:

					break;
				default:
					break;
				}
			} catch (Exception ex) {
				System.err.println("ERROR -- INTRODUZCA NUMEROS!!!");
				scNum.next();
			}
		} while (opcion != 6);
	}

}
