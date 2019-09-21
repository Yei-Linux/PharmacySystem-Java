package Datos;

public class Datos_Cliente {
	
	public int cod_cliente;
	public String ap_materno;
	public String ap_paterno;
	public String nombre_cli;
	public String Ruc;
	public String Dni;
	public String Genero;
	public String Direccion;
	public int Cod_Distrito;
	public int Cod_Sede;
	public String Cel;
	
	public Datos_Cliente(int cod_cliente,String ap_materno,String ap_paterno,String nombre_cli,String Ruc,String Dni,String Genero,String Direccion,int Cod_Distrito,int Cod_Sede,String Cel){
		
		this.cod_cliente=cod_cliente;
		this.ap_materno=ap_materno;
		this.ap_paterno=ap_paterno;
		this.nombre_cli=nombre_cli;
		this.Ruc=Ruc;
		this.Dni=Dni;
		this.Genero=Genero;
		this.Direccion=Direccion;
		this.Cod_Distrito=Cod_Distrito;
		this.Cod_Sede=Cod_Sede;
		this.Cel=Cel;
		
	}
	
	public Datos_Cliente(){
		
	}
	
	public int 	Get_Cod_Cliente(){
		return cod_cliente;
	}
	
	public void Set_Cod_Cliente(int cod_cliente){
		this.cod_cliente=cod_cliente;
	}
	
	public String Get_ap_materno(){
		return ap_materno;
	}
	public void Set_ap_materno(String ap_materno){
		this.ap_materno=ap_materno;
	}
	
	public String Get_ap_paterno(){
		return ap_paterno;
	}
	public void Set_ap_paterno(String ap_paterno){
		this.ap_paterno=ap_paterno;
	}
	
	public String Get_Nombre_cli(){
		return nombre_cli;
	}
	public void Set_Nombre_cli(String nombre_cli){
		this.nombre_cli=nombre_cli;
	}
	
	public String Get_Ruc(){
		return Ruc;
	}
	public void Set_Ruc(String Ruc){
		this.Ruc=Ruc;
	}
	
	public String Get_Dni(){
		return Dni;
	}
	public void Set_Dni(String Dni){
		this.Dni=Dni;
	}
	
	public String Get_Genero(){
		return Genero;
	}
	public void Set_Genero(String Genero){
		this.Genero=Genero;
	}
	
	public String Get_Direccion(){
		return Direccion;
	}
	public void Set_Direccion(String Direccion){
		this.Direccion=Direccion;
	}
	
	public int Get_Cod_Distrito(){
		return Cod_Distrito;
	}
	public void Set_Cod_Distrito(int Cod_Distrito){
		this.Cod_Distrito=Cod_Distrito;
	}
	
	public int Get_Cod_Sede(){
		return Cod_Sede;
	}
	public void Set_Cod_Sede(int Cod_Sede){
		this.Cod_Sede=Cod_Sede;
	}
	
	public String Get_Cel(){
		return Cel;
	}
	public void Set_Cel(String Cel){
		this.Cel=Cel;
	}
}
