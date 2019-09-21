package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Cliente;

import java.sql.Statement;

public class Metodo_form_cliente {
	
		private Conexion mysql=new Conexion();
		private Connection cn=mysql.conectar();
		private String SQL="";
		private String SQL2="";
		private int TotalRegistros;
		
		public DefaultTableModel Mostrar(String buscar){
			DefaultTableModel modelo;
			
			String []titulo={"ID","AP_PATERNO","AP_MATERNO","NOMBRE","RUC","DNI","GENERO","DIRECCION","CEL","DISTRITO","SEDE"};
			String []registro=new String[11];
			
			TotalRegistros=0;
			
			modelo=new DefaultTableModel(null,titulo);
			
			SQL="select c.COD_CLIENTE,c.APELL_MATERNO_CLI,c.APELL_PATERNO_CLI,c.APELL_PATERNO_CLI,c.NOM_CLI,c.RUC_CLI,c.DNI_CLI,c.DNI_CLI,c.GENERO_CLI,c.DIR_CLI,c.CEL_CLI,d.NOM_DISTRITO,s.NOM_SEDE from cliente as c INNER JOIN sede as s on s.COD_SEDE=c.COD_SEDE INNER JOIN distrito as d on d.COD_DISTRITO=c.COD_DISTRITO where c.DNI_CLI like '%"+buscar+"%' order by c.COD_CLIENTE";
			
			try{
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(SQL);
				
				while(rs.next()){
					
					registro[0]=rs.getString("COD_CLIENTE");
					registro[1]=rs.getString("APELL_MATERNO_CLI");
					registro[2]=rs.getString("APELL_PATERNO_CLI");
					registro[3]=rs.getString("NOM_CLI");
					registro[4]=rs.getString("RUC_CLI");
					registro[5]=rs.getString("DNI_CLI");
					registro[6]=rs.getString("GENERO_CLI");
					registro[7]=rs.getString("DIR_CLI");
					registro[8]=rs.getString("CEL_CLI");
					registro[9]=rs.getString("NOM_DISTRITO");
					registro[10]=rs.getString("NOM_SEDE");
					
					TotalRegistros++;
					
					modelo.addRow(registro);
				}
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
			
			return modelo;
		}
		
		public boolean Insertar(Datos_Cliente dts){
			SQL="INSERT INTO cliente(APELL_MATERNO_CLI,APELL_PATERNO_CLI,NOM_CLI,RUC_CLI,DNI_CLI,GENERO_CLI,DIR_CLI,CEL_CLI,COD_DISTRITO,COD_SEDE)"+
		        " VALUES(?,?,?,?,?,?,?,?,?,?) ";
			
			try{
				PreparedStatement pst=cn.prepareStatement(SQL);
				
				pst.setString(1,dts.Get_ap_materno());
				pst.setString(2,dts.Get_ap_paterno());
				pst.setString(3,dts.Get_Nombre_cli());
				pst.setString(4,dts.Get_Ruc());
				pst.setString(5,dts.Get_Dni());
				pst.setString(6,dts.Get_Genero());
				pst.setString(7,dts.Get_Direccion());
				pst.setString(8,dts.Get_Cel());
				pst.setInt(9,dts.Get_Cod_Distrito());
				pst.setInt(10,dts.Get_Cod_Sede());
				
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
		
		public boolean Editar(Datos_Cliente dts){
			
			SQL="update cliente set APELL_MATERNO_CLI=?,APELL_PATERNO_CLI=?,NOM_CLI=?,RUC_CLI=?,DNI_CLI=?,GENERO_CLI=?,DIR_CLI=?,CEL_CLI=?,COD_DISTRITO=?,COD_SEDE=? where COD_CLIENTE=?";
			
			try{
				PreparedStatement pst=cn.prepareStatement(SQL);
				
				pst.setString(1,dts.Get_ap_materno());
				pst.setString(2,dts.Get_ap_paterno());
				pst.setString(3,dts.Get_Nombre_cli());
				pst.setString(4,dts.Get_Ruc());
				pst.setString(5,dts.Get_Dni());
				pst.setString(6,dts.Get_Genero());
				pst.setString(7,dts.Get_Direccion());
				pst.setString(8,dts.Get_Cel());
				pst.setInt(9,dts.Get_Cod_Distrito());
				pst.setInt(10,dts.Get_Cod_Sede());
				pst.setInt(11,dts.Get_Cod_Cliente());
				
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
		
		public boolean Eliminar(Datos_Cliente dts){
			
			SQL="delete from cliente where COD_CLIENTE=?";
			
			try{
				PreparedStatement pst=cn.prepareStatement(SQL);
				
				pst.setInt(1,dts.Get_Cod_Cliente());
				
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
		
		public JComboBox Combo_Sede(){
			
			JComboBox combo=new JComboBox();;
			
			SQL="select * from sede";
			
			try{
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(SQL);
				
				combo.removeAllItems();
				
				while(rs.next()){
					combo.addItem(rs.getString("NOM_SEDE"));
				}
				
				return combo;
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null, e);
				
				return null;
			}
		}
		
		public int Id_Sede (String buscar){
			
			int id;
			
			SQL="select * from sede where NOM_SEDE='"+buscar+"'";
			
			try{
				
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(SQL);
				
				rs.next();
				
				id=rs.getInt("COD_SEDE");
				
				return id;
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null, e);
				
				return 0;
			}
			
		}
		
	public JComboBox Combo_Distrito(){
			
			JComboBox combo=new JComboBox();;
			
			SQL="select * from distrito";
			
			try{
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(SQL);
				
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
			
			SQL="select * from distrito where NOM_DISTRITO='"+buscar+"'";
			
			try{
				
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery(SQL);
				
				rs.next();
				
				id=rs.getInt("COD_DISTRITO");
				
				return id;
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null, e);
				
				return 0;
			}
			
		}
}
