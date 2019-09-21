package Datos;

public class Datos_Venta_Reporte {
	public String cod_prod;
	public String producto;
	public String cantidad;
	public String precio;
	public String total;
	
	public Datos_Venta_Reporte(String cod_prod,String producto,String cantidad,String precio,String total){
		this.cod_prod=cod_prod;
		this.producto=producto;
		this.cantidad=cantidad;
		this.precio=precio;
		this.total=total;
	}
	
	public String getCod_prod(){
		return cod_prod;
	}
	public void setCod_prod(String cod_prod){
		this.cod_prod=cod_prod;
	}
	
	public String getProducto(){
		return producto;
	}
	public void setProducto(String producto){
		this.producto=producto;
	}
	
	public String getCantidad(){
		return cantidad;
	}
	public void setCantidad(String cantidad){
		this.cantidad=cantidad;
	}
	
	public String getPrecio(){
		return precio;
	}
	public void setPrecio(String precio){
		this.precio=precio;
	}
	
	public String getTotal(){
		return total;
	}
	public void setTotal(String total){
		this.total=total;
	}
	
	
	
}
