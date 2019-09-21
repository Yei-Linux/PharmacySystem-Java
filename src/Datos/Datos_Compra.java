package Datos;

import javax.swing.table.TableModel;

public class Datos_Compra {
	public TableModel modelo;
	public int id_Sede;
	public int id_Proveedor;
	public double Total;
	public double Importe;
	
	public Datos_Compra(TableModel modelo){
		this.modelo=modelo;
	}
	
	public Datos_Compra(){
		
	}
	
	public TableModel Get_Modelo(){
		return modelo;
	}
	
	public void Set_Modelo(TableModel modelo){
		this.modelo=modelo;
	}
	
	public int Get_Id_Sede(){
		return id_Sede;
	}
	public void Set_Id_Sede(int id_Sede){
		this.id_Sede=id_Sede;
	}
	
	public int Get_Id_Proveedor(){
		return id_Proveedor;
	}
	public void Set_Id_Proveedor(int id_Proveedor){
		this.id_Proveedor=id_Proveedor;
	}

	
	public double Get_Total(){
		return this.Total;
	}
	public void Set_Total(double Total){
		this.Total=Total;
	}
	
	public double Get_Importe(){
		return Importe;
	}
	public void Set_Importe(double Importe){
		this.Importe=Importe;
	}
}
