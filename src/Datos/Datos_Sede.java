package Datos;

public class Datos_Sede {
	public int id_Sede;
	public String Nom_Sede;
	public int id_Distrito;
	public String Nom_Almacen;
	public String Direccion;
	
	public Datos_Sede(){
		
	}
	
	public Datos_Sede(int id_Sede,String Nom_Sede,int id_Distrito,String Nom_Almacen,String Direccion){
		this.id_Distrito=id_Sede;
		this.Nom_Sede=Nom_Sede;
		this.id_Distrito=id_Distrito;
		this.Nom_Almacen=Nom_Almacen;
		this.Direccion=Direccion;
	}
	
	public int Get_Id_Sede(){
		return id_Sede;
	}
	public void Set_Id_Sede(int id_Sede){
		this.id_Sede=id_Sede;
	}
	
	public String Get_Sede(){
		return Nom_Sede;
	}
	public void Set_Sede(String Nom_Sede){
		this.Nom_Sede=Nom_Sede;
	}
	
	public int Get_Id_Distrito(){
		return id_Distrito;
	}
	public void Set_Id_Distrito(int id_Distrito){
		this.id_Distrito=id_Distrito;
	}
	
	public String Get_Almacen(){
		return Nom_Almacen;
	}
	public void Set_Almacen(String Nom_Almacen){
		this.Nom_Almacen=Nom_Almacen;
	} 
	
	public String Get_Direccion(){
		return Direccion;
	}
	public void Set_Direccion(String Direccion){
		this.Direccion=Direccion;
	}
	

}
