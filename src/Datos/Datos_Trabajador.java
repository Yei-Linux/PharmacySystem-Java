package Datos;

public class Datos_Trabajador {
	
	public int cod_trabajador;
	public String ap_materno;
	public String ap_paterno;
	public String nombre_emp;
	public String Direccion;
	public String Fec_Nac_Emp;
	public String Cel;
	public String User;
	public String Pass;
	public int Tipo_Usu;
	
	public int Cod_Distrito;
	public int Cod_Sede;
	
	public Datos_Trabajador(int cod_trabajador,String ap_materno,String ap_paterno,String nombre_emp,String Direccion,String Fec_Nac_Emp,String Cel,String User,String Pass,int Tipo_Usu,int Cod_Distrito,int Cod_Sede){
		this.cod_trabajador=cod_trabajador;
		this.ap_paterno=ap_paterno;
		this.ap_materno=ap_materno;
		this.nombre_emp=nombre_emp;
		this.Direccion=Direccion;
		this.Fec_Nac_Emp=Fec_Nac_Emp;
		this.Cel=Cel;
		this.User=User;
		this.Pass=Pass;
		this.Tipo_Usu=Tipo_Usu;
		this.Cod_Distrito=Cod_Distrito;
		this.Cod_Sede=Cod_Sede;
		
	}
	
	public Datos_Trabajador(){
		
	}
	
	public int Get_Cod_Emp(){
		return cod_trabajador;
	}
	public void Set_Cod_Emp(int cod_trabajador){
		this.cod_trabajador=cod_trabajador;
	}
	
	public String Get_Ap_Paterno(){
		return ap_paterno;
	}
	public void Set_Ap_Paterno(String ap_paterno){
		this.ap_paterno=ap_paterno;
	}
	
	public String Get_Ap_Materno(){
		return ap_materno;
	}
	public void Set_Ap_Materno(String ap_materno){
		this.ap_materno=ap_materno;
	}
	
	public String Get_Nom_Emp(){
		return nombre_emp;
	}
	public void Set_Nom_Emp(String nombre_emp){
		this.nombre_emp=nombre_emp;
	}
	
	public String Get_Dir(){
		return Direccion;
	}
	public void Set_Direccion(String Direccion){
		this.Direccion=Direccion;
	}
	
	public String Get_Fec_Nac(){
		return Fec_Nac_Emp;
	}
	public void Set_Fec_Nac(String Fec_Nac_Emp){
		this.Fec_Nac_Emp=Fec_Nac_Emp;
	}
	
	public String Get_Cel(){
		return Cel;
	}
	public void Set_Cel(String Cel){
		this.Cel=Cel;
	}
	
	public String Get_User(){
		return User;
	}
	public void Set_User(String User){
		this.User=User;
	}
	
	public String Get_Pass(){
		return Pass;
	}
	public void Set_Pass(String Pass){
		this.Pass=Pass;
	}
	
	public int Get_Tipo_User(){
		return Tipo_Usu;
	}
	public void Set_Tipo_User(int Tipo_Usu){
		this.Tipo_Usu=Tipo_Usu;
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

}
