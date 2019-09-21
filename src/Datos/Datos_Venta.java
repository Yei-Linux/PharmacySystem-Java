package Datos;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Datos_Venta {
	
	public TableModel modelo;
	public int id_Sede;
	public int id_Empleado;
	public int id_Cliente;
	public double Descuento;
	public double Subtotal;
	public double Importe;
	
	public Datos_Venta(TableModel modelo){
		this.modelo=modelo;
	}
	
	public Datos_Venta(){
		
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
	
	public int Get_Id_Empleado(){
		return id_Empleado;
	}
	public void Set_Id_Empleado(int id_Empleado){
		this.id_Empleado=id_Empleado;
	}
	
	public int Get_Id_Cliente(){
		return id_Cliente;
	}
	public void Set_Id_Cliente(int id_Cliente){
		this.id_Cliente=id_Cliente;
	}
	
	public double Get_Descuento(){
		return Descuento;
	}
	public void Set_Descuento(double Descuento){
		this.Descuento=Descuento;
	}
	
	public double Get_Subtotal(){
		return this.Subtotal;
	}
	public void Set_Subtotal(double Subtotal){
		this.Subtotal=Subtotal;
	}
	
	public double Get_Importe(){
		return Importe;
	}
	public void Set_Importe(double Importe){
		this.Importe=Importe;
	}
	

}
