package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Producto;
import Datos.Datos_Proveedor;

public class Metodo_form_Proveedor2 {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Nombre","Direccion","Celular","Distrito"};
		String []registro=new String[5];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT pv.COD_PROVEEDOR,pv.NOM_PROVEEDOR,pv.DIR_PROVEEDOR,pv.CEL_PROVEEDOR,d.NOM_DISTRITO FROM proveedor as pv INNER JOIN distrito as d on pv.COD_DISTRITO=d.COD_DISTRITO where pv.COD_PROVEEDOR like '%"+buscar+"%' order by pv.COD_PROVEEDOR";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PROVEEDOR");
				registro[1]=rs.getString("NOM_PROVEEDOR");
				registro[2]=rs.getString("DIR_PROVEEDOR");
				registro[3]=rs.getString("CEL_PROVEEDOR");
				registro[4]=rs.getString("NOM_DISTRITO");

				totalRegistros++;
				modelo.addRow(registro);
			}
			
			return modelo;
		}catch(Exception e){
			
			JOptionPane.showConfirmDialog(null, e);
			
			return null;
		}
	}
	
	public boolean Insertar(Datos_Proveedor dts){
		sSQL="INSERT INTO proveedor(NOM_PROVEEDOR,DIR_PROVEEDOR,CEL_PROVEEDOR,COD_DISTRITO)"+
	        " VALUES(?,?,?,?) ";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			pst.setString(1,dts.Get_Nom_Proveedor());
			pst.setString(2,dts.Get_Direccion());
			pst.setString(3,dts.Get_Cel());
			pst.setInt(4,dts.Get_Id_Distrito());
			
			int n=pst.executeUpdate();
			
			if(n!=0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
			return false;
		}
	}
	
	public boolean Editar(Datos_Proveedor dts){
		
		sSQL="update proveedor set NOM_PROVEEDOR=?,DIR_PROVEEDOR=?,CEL_PROVEEDOR=?,COD_DISTRITO=? where COD_PROVEEDOR=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			pst.setString(1,dts.Get_Nom_Proveedor());
			pst.setString(2,dts.Get_Direccion());
			pst.setString(3,dts.Get_Cel());
			pst.setInt(4,dts.Get_Id_Distrito());
			
			pst.setInt(5,dts.Get_Id_Proveedor());
			
			int n=pst.executeUpdate();
			
			if(n!=0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
			return false;
		}
		
	}
	
	public boolean Eliminar(Datos_Proveedor dts){
		
		sSQL="delete from proveedor where COD_PROVEEDOR=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			pst.setInt(1,dts.Get_Id_Proveedor());
			
			int n=pst.executeUpdate();
			
			if(n!=0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
			return false;
		}
	}
	
public JComboBox Combo_Distrito(){
		
		JComboBox combo=new JComboBox();;
		
		sSQL="select * from distrito";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			combo.removeAllItems();
			
			while(rs.next()){
				combo.addItem(rs.getString("NOM_DISTRITO"));
			}
			
			return combo;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
	}
	
	public int Id_Distrito (String buscar){
		
		int id;
		
		sSQL="select * from distrito where NOM_DISTRITO='"+buscar+"'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			rs.next();
			
			id=rs.getInt("COD_DISTRITO");
			
			return id;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return 0;
		}
		
	}
}
