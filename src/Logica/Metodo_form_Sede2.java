package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Cliente;
import Datos.Datos_Sede;

public class Metodo_form_Sede2 {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="",sSQL2="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Sede","Distrito","Almacen","Direccion"};
		String []registro=new String[5];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT s.COD_SEDE,s.NOM_SEDE,d.NOM_DISTRITO,a.NOM_ALMACEN,a.DIREC_ALMACEN from distrito as d INNER JOIN sede as s on d.COD_DISTRITO=s.COD_DISTRITO INNER JOIN almacen as a on s.COD_ALMACEN=a.COD_ALMACEN where s.COD_SEDE like '%"+buscar+"%' order by s.COD_SEDE";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_SEDE");
				registro[1]=rs.getString("NOM_SEDE");
				registro[2]=rs.getString("NOM_DISTRITO");
				registro[3]=rs.getString("NOM_ALMACEN");
				registro[4]=rs.getString("DIREC_ALMACEN");
				
				totalRegistros++;
				modelo.addRow(registro);
			}
			
			return modelo;
		}catch(Exception e){
			
			JOptionPane.showConfirmDialog(null, e);
			
			return null;
		}
	}
	
	public boolean Insertar(Datos_Sede dts){
		sSQL="INSERT INTO almacen(NOM_ALMACEN,DIREC_ALMACEN)"+
	        " VALUES(?,?)";
		sSQL2="INSERT INTO sede(NOM_SEDE,COD_DISTRITO,COD_ALMACEN)"+
	        " VALUES(?,?,(SELECT MAX(COD_ALMACEN) FROM almacen))";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			PreparedStatement pst2=cn.prepareStatement(sSQL2);
			
			pst.setString(1,dts.Get_Almacen());
			pst.setString(2,dts.Get_Direccion());
			
			pst2.setString(1,dts.Get_Sede());
			pst2.setInt(2,dts.Get_Id_Distrito());
			
			
			int n=pst.executeUpdate();
			
			if(n!=0){
				int n1=pst2.executeUpdate();
				if(n1!=0){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
			return false;
		}
	}
	
	public boolean Editar(Datos_Sede dts){
		
		sSQL="UPDATE sede as s INNER JOIN almacen as a on s.COD_ALMACEN=a.COD_ALMACEN set s.NOM_SEDE=?,s.COD_DISTRITO=?,a.NOM_ALMACEN=?,a.DIREC_ALMACEN=? where s.COD_SEDE=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			
			pst.setString(1,dts.Get_Sede());
			pst.setInt(2,dts.Get_Id_Distrito());
			pst.setString(3,dts.Get_Almacen());
			pst.setString(4,dts.Get_Direccion());
			
			pst.setInt(5, dts.Get_Id_Sede());
			
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
	
	public boolean Eliminar(Datos_Sede dts){
		
		sSQL="delete from sede where COD_SEDE=?";
		sSQL2="delete from almacen where COD_ALAMACEN=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			PreparedStatement pst2=cn.prepareStatement(sSQL2);
			
			pst.setInt(1,dts.Get_Id_Sede());
			
			pst2.setInt(1,dts.Get_Id_Sede());
			
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
