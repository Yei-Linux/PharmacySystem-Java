package Datos;

public class Datos_Producto {
	public int id_Producto;
	public String Nom_Producto;
	public double Precio;
	public double igv;
	public int id_Proveedor;
	public int id_Categoria;
	public int id_Almacen;
	
	public Datos_Producto(int id_Producto,String Nom_Producto,double Precio,double igv,int id_Proveedor,int id_Categoria,int id_Almacen){
		this.id_Producto=id_Producto;
		this.Nom_Producto=Nom_Producto;
		this.Precio=Precio;
		this.igv=igv;
		this.id_Proveedor=id_Proveedor;
		this.id_Categoria=id_Categoria;
		this.id_Almacen=id_Almacen;
	}
	
	public Datos_Producto(){
		
	}
	
	public int Get_id_Producto(){
		return id_Producto;
	}
	public void Set_id_Producto(int id_Producto){
		this.id_Producto=id_Producto;
	}
	
	public String Get_Nom_Producto(){
		return Nom_Producto;
	}
	public void Set_Nom_Producto(String Nom_Producto){
		this.Nom_Producto=Nom_Producto;
	}
	
	public double Get_Precio(){
		return Precio;
	}
	public void Set_Precio(double Precio){
		this.Precio=Precio;
	}
	
	public double Get_igv(){
		return igv;
	}
	public void Set_igv(double igv){
		this.igv=igv;
	}
	
	public int Get_id_Proveedor(){
		return id_Proveedor;
	}
	public void Set_id_Proveedor(int id_Proveedor){
		this.id_Proveedor=id_Proveedor;
	}
	
	public int Get_id_Categoria(){
		return id_Categoria;
	}
	public void Set_id_Categoria(int id_Categoria){
		this.id_Categoria=id_Categoria;
	}
	
	public int Get_id_Almacen(){
		return id_Almacen;
	}
	public void Set_id_Almacen(int id_Almacen){
		this.id_Almacen=id_Almacen;
	}
	
	
}
