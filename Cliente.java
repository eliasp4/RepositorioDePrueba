package unidad6.tarea.t6;

public class Cliente {

	private String nombre;
	private int telefono;
	private String tipoPelo;
	private boolean peloCortado;

	public Cliente(String nombre, int telefono, String tipoPelo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipoPelo = tipoPelo;
		this.peloCortado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public boolean isPeloCortado() {
		return peloCortado;
	}

	public void setPeloCortado(boolean peloCortado) {
		this.peloCortado = peloCortado;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", tipoPelo=" + tipoPelo + ", peloCortado="
				+ peloCortado + "]";
	}

}
