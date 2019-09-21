package Datos;

public class Datos_Proveedor {
	public int id_Proveedor;
	public String Nom_Proveedor;
	public String Direccion;
	public String Celular;
	public int id_Distrito;
	
	public Datos_Proveedor(){
		
	}
	
	public Datos_Proveedor(int id_Proveedor,String Nom_Proveedor,String Direccion,String Celular,int id_Distrito){
		this.id_Proveedor=id_Proveedor;
		this.Nom_Proveedor=Nom_Proveedor;
		this.Direccion=Direccion;
		this.Celular=Celular;
		this.id_Distrito=id_Distrito;
	}
	
	public int Get_Id_Proveedor(){
		return id_Proveedor;
	}
	public void Set_Id_Proveedor(int id_Proveedor){
		this.id_Proveedor=id_Proveedor;
	}
	
	public String Get_Nom_Proveedor(){
		return Nom_Proveedor;
	}
	public void Set_Nom_Proveedor(String Nom_Proveedor){
		this.Nom_Proveedor=Nom_Proveedor;
	}
	
	public String Get_Direccion(){
		return Direccion;
	}
	public void Set_Direccion(String Direccion){
		this.Direccion=Direccion;
	}
	
	public String Get_Cel(){
		return Celular;
	}
	public void Set_Cel(String Celular){
		this.Celular=Celular;
	}
	
	public int Get_Id_Distrito(){
		return id_Distrito;
	}
	public void Set_Id_Distrito(int id_Distrito){
		this.id_Distrito=id_Distrito;
	}
}
