package pe.edu.idat.model;

public class Producto {
	
	private Long id_producto;
	private String descripcion;
	private String presentacion;
	private double precio;
	private int cantidad;



	public Producto() {
		super();
	}


	public Producto(Long id_producto, String descripcion, String presentacion, double precio, int cantidad) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
		this.precio = precio;
		this.cantidad = cantidad;
	}



	public Long getId_producto() {
		return id_producto;
	}



	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getPresentacion() {
		return presentacion;
	}



	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
