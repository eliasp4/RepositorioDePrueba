package unidad6.tarea.t6;

import java.util.ArrayList;
import java.util.Scanner;

public class Peluqueria {
	
	private String nombre;
	private String direccion;
	private static ArrayList<Cliente> listaClientes;
	
	

	public Peluqueria(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaClientes = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(ArrayList<Cliente> listaClientes) {
		Peluqueria.listaClientes = listaClientes;
	}

	public static void datosFicticios() {
		
		Peluqueria p = new Peluqueria("Peluqueria Elisa", "Avenida Juan Carlos 1");
		
		Cliente c = new Cliente("Carmen", 663475480, "Ondulado");
		
		c.setPeloCortado(true);
		
		listaClientes.add(c);
		
		Cliente c2 = new Cliente("Marta", 667334560, "Liso");
		
		listaClientes.add(c2);
		
		Cliente c3 = new Cliente("Olga", 626517043, "Ondulado");
		
		listaClientes.add(c3);
		
		Cliente c4 = new Cliente("Carolina", 655287518, "Liso");
		
		c4.setPeloCortado(true);
		
		listaClientes.add(c4);
		
		Cliente c5 = new Cliente("Ana", 674954362, "Rizado");
		
		listaClientes.add(c5);
		
		Cliente c6 = new Cliente("Paula", 636197648, "Rizado");
		
		c6.setPeloCortado(true);
		
		listaClientes.add(c6);
		
	}
	
	public static void pintarLista(boolean pelado, boolean pintarTodos) {
		if (pelado == true && pintarTodos == false) {
			for (Cliente cliente : listaClientes) {
				if (cliente.isPeloCortado() == true) {
					System.out.println("\nNombre: " + cliente.getNombre() + "\nTelefono: " + cliente.getTelefono()
							+ "\nTipo de Pelo: " + cliente.getTipoPelo() + "\nPelo Cortado: "
							+ cliente.isPeloCortado());
				}
			}
		} else if(pelado == false && pintarTodos == false) {
			for (Cliente cliente : listaClientes) {
				if (cliente.isPeloCortado() == false) {
					System.out.println("\nNombre: " + cliente.getNombre() + "\nTelefono: " + cliente.getTelefono()
							+ "\nTipo de Pelo: " + cliente.getTipoPelo() + "\nPelo Cortado: "
							+ cliente.isPeloCortado());
				}
			}
	} else if(pelado == true && pintarTodos == true) {
		for (Cliente cliente : listaClientes) {
				System.out.println("\nNombre: " + cliente.getNombre() + "\nTelefono: " + cliente.getTelefono()
						+ "\nTipo de Pelo: " + cliente.getTipoPelo() + "\nPelo Cortado: "
						+ cliente.isPeloCortado());
			}
		
	}
	}
	
	public static Cliente crearCliente() {
		
		Scanner sc = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);
		
		
		System.out.println("Introduzca el nombre del cliente: ");
		String nombre = sc.nextLine();
		
		int telefono = correccionErrores("Introduzca el telefono: ");
		
		String tipoPelo = comprobarTipoPelo();
		
		boolean cortePelo = comprobarCortePelo();
		
		
		System.out.println("Introduzca su direccion: ");
		String direccion = sc.nextLine();
		
		Cliente c = new Cliente(nombre, telefono, tipoPelo);
		
		c.setPeloCortado(cortePelo);
		
		return c;
	}
	
	private static String comprobarTipoPelo() {
		Scanner sc = new Scanner(System.in);

		
		String tipoPelo = "";
		
		boolean valido = false;
		
		do {
			System.out.println("Introduzca el tipo de pelo: ");
			tipoPelo = sc.nextLine();
		
		
			if(tipoPelo.equalsIgnoreCase("liso")) {
				valido = true;
			} else if(tipoPelo.equalsIgnoreCase("ondulado")) {
				valido = true;

			} else if(tipoPelo.equalsIgnoreCase("rizado")) {
				valido = true;
			} else {
				System.out.println("\nIntroduzca uno de estos tres tipos -- 'Liso' 'Ondulado' 'Rizado' --");
			}
		
		}while(!valido);
		
		return tipoPelo;
	}
	
	public static Cliente buscarCliente(int telefono) {
		
		for (Cliente cliente : listaClientes) {
			if(telefono == cliente.getTelefono()) {
				return cliente;
			}
		}
		
		return null;
	}
	
	public static boolean comprobarCortePelo() {
		Scanner sc = new Scanner(System.in);
		boolean encontrado = false;
		boolean valido = false;

		do {
		System.out.println("Introduzca si tiene o no el pelo cortado: ");
		String peloCortado = sc.nextLine();
		
		if(peloCortado.equalsIgnoreCase("si")) {
			encontrado = true;
			valido = true;
			
		} else if(peloCortado.equalsIgnoreCase("no")) {
			encontrado = false;
			valido = true;
			
		}
		}while(!valido);

		return encontrado;
	}
	
	public static void eliminarCliente() {
		Scanner scNum = new Scanner(System.in);

		int telefono = 0;
		boolean encontrado = false;
		
		do {
		
		telefono = correccionErrores("\nIntroduzca el telefono del cliente que desea eliminar: ");
		
		Cliente clienteEliminar = buscarCliente(telefono);
		
		if(clienteEliminar == null) {
			System.out.println("No se ha encontrado al cliente con el numero '" + telefono + "'");
		}else {
			System.out.println("\nEl Cliente '" + clienteEliminar.getNombre() + "' ha sido eliminado con exito!!");
			listaClientes.remove(clienteEliminar);
			encontrado = true;
		}
		}while(!encontrado);
		
	}
	
	public static int correccionErrores(String pregunta) {
		Scanner scNum = new Scanner(System.in);
		boolean valido = false;
		int error = 0;
		do {
			System.out.println(pregunta);
			try {
				error = scNum.nextInt();
				valido = true;

			} catch (Exception ex) {
				System.err.println("\nERROR!!! INTRODUZCA NUMEROS");
				scNum.next();
				error = 0;
			}

		} while (!valido);

		return error;
	}
	
	
	
	
	

}
