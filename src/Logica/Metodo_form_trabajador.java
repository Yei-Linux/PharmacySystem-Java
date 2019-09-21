package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Cliente;
import Datos.Datos_Trabajador;

public class Metodo_form_trabajador {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String SQL="";
	private String SQL2="";
	public int TotalRegistros;
	
	public DefaultTableModel Mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","AP_PATERNO","AP_MATERNO","NOMBRE","DIRECCION","FEC_NAC","CEL","FEC_INGRESO","USER","PASS","TIPO_USER","DISTRITO","SEDE"};
		String []registro=new String[13];
		
		TotalRegistros=0;
		
		modelo=new DefaultTableModel(null,titulo);
		
		SQL="SELECT e.COD_EMPLEADO,e.APELL_PATERNO_EMP,e.APELL_MATERNO_EMP,e.NOMBRE_EMP,e.DIR_NAC_EMP,e.FEC_NAC_EMP,e.CELULAR_EMP,e.FECHA_INGRESO,u.USUARIO,u.PASS,t.NOM_TIPO_USU,d.NOM_DISTRITO,s.NOM_SEDE FROM distrito as d INNER JOIN empleado as e on d.COD_DISTRITO=e.COD_DISTRITO inner JOIN sede as s on e.COD_SEDE=s.COD_SEDE INNER JOIN usuario as u ON e.COD_USUARIO=u.COD_USUARIO INNER JOIN tipo_usuario as t ON u.COD_TIPO_USU=t.COD_TIPO_USU where e.COD_EMPLEADO like '%"+buscar+"%' order by e.COD_EMPLEADO";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			while(rs.next()){
				
				registro[0]=rs.getString("COD_EMPLEADO");
				registro[1]=rs.getString("APELL_PATERNO_EMP");
				registro[2]=rs.getString("APELL_MATERNO_EMP");
				registro[3]=rs.getString("NOMBRE_EMP");
				registro[4]=rs.getString("DIR_NAC_EMP");
				registro[5]=rs.getString("FEC_NAC_EMP");
				registro[6]=rs.getString("CELULAR_EMP");
				registro[7]=rs.getString("FECHA_INGRESO");
				registro[8]=rs.getString("USUARIO");
				registro[9]=rs.getString("PASS");
				registro[10]=rs.getString("NOM_TIPO_USU");
				registro[11]=rs.getString("NOM_DISTRITO");
				registro[12]=rs.getString("NOM_SEDE");
				
				TotalRegistros++;
				
				modelo.addRow(registro);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		return modelo;
	}
	
	public boolean Insertar(Datos_Trabajador dts){
		
		SQL="INSERT INTO usuario(USUARIO,PASS,COD_TIPO_USU) VALUES(?,?,?)";
		SQL2="INSERT INTO empleado(APELL_PATERNO_EMP,APELL_MATERNO_EMP,NOMBRE_EMP,DIR_NAC_EMP,FEC_NAC_EMP,CELULAR_EMP,FECHA_INGRESO,COD_USUARIO,COD_DISTRITO,COD_SEDE)"+
	        " VALUES(?,?,?,?,?,?,(SELECT CURDATE()),(SELECT MAX(COD_USUARIO) FROM usuario),?,?)";
		
		try{
			PreparedStatement pst=cn.prepareStatement(SQL);
			PreparedStatement pst2=cn.prepareStatement(SQL2);
			
			pst.setString(1, dts.Get_User());
			pst.setString(2,dts.Get_Pass());
			pst.setInt(3, dts.Get_Tipo_User());
			
			
			pst2.setString(1,dts.Get_Ap_Paterno());
			pst2.setString(2,dts.Get_Ap_Materno());
			pst2.setString(3,dts.Get_Nom_Emp());
			pst2.setString(4,dts.Get_Dir());
			pst2.setString(5,dts.Get_Fec_Nac());
			pst2.setString(6,dts.Get_Cel());
			pst2.setInt(7,dts.Get_Cod_Distrito());
			pst2.setInt(8,dts.Get_Cod_Sede());
			
			int n=pst.executeUpdate();
			
			if(n!=0){
				int n2=pst2.executeUpdate();
				if(n2!=0){
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
	
	public boolean Editar(Datos_Trabajador dts){
		
		SQL="UPDATE empleado as e INNER JOIN usuario as u on e.COD_USUARIO=u.COD_USUARIO SET e.APELL_PATERNO_EMP=?,e.APELL_MATERNO_EMP=?,e.NOMBRE_EMP=?,e.DIR_NAC_EMP=?,e.FEC_NAC_EMP=?,e.CELULAR_EMP=?,u.USUARIO=?,u.PASS=?,u.COD_TIPO_USU=?,e.COD_DISTRITO=?,e.COD_SEDE=? where e.COD_EMPLEADO=?";

		
		try{
			PreparedStatement pst=cn.prepareStatement(SQL);
			
			pst.setString(1,dts.Get_Ap_Paterno());
			pst.setString(2,dts.Get_Ap_Materno());
			pst.setString(3,dts.Get_Nom_Emp());
			pst.setString(4,dts.Get_Dir());
			pst.setString(5,dts.Get_Fec_Nac());
			pst.setString(6,dts.Get_Cel());
			pst.setString(7,dts.Get_User());
			pst.setString(8,dts.Get_Pass());
			pst.setInt(9,dts.Get_Tipo_User());
			pst.setInt(10,dts.Get_Cod_Distrito());
			pst.setInt(11,dts.Get_Cod_Sede());
			pst.setInt(12,dts.Get_Cod_Emp());
			
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
	
	public boolean Eliminar(Datos_Trabajador dts){
		
		SQL="delete from empleado where COD_EMPLEADO=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(SQL);
			
			pst.setInt(1,dts.Get_Cod_Emp());
			
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
	
	public DefaultTableModel Log_in(String login,String password){
		DefaultTableModel modelo;
		
		String []titulo={"ID","AP_PATERNO","AP_MATERNO","NOMBRE","DIRECCION","FEC_NAC","CEL","FEC_INGRESO","USER","PASS","TIPO_USER","DISTRITO","SEDE"};
		String []registro=new String[13];
		
		TotalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		SQL="SELECT e.COD_EMPLEADO,e.APELL_PATERNO_EMP,e.APELL_MATERNO_EMP,e.NOMBRE_EMP,e.DIR_NAC_EMP,e.FEC_NAC_EMP,e.CELULAR_EMP,e.FECHA_INGRESO,u.USUARIO,u.PASS,t.NOM_TIPO_USU,e.COD_DISTRITO,e.COD_SEDE FROM empleado as e inner JOIN usuario as u ON e.COD_USUARIO=u.COD_USUARIO INNER JOIN tipo_usuario as t ON u.COD_TIPO_USU=t.COD_TIPO_USU where u.USUARIO='"+login+"' AND u.PASS='"+password+"'";
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				
				registro[0]=rs.getString("COD_EMPLEADO");
				registro[1]=rs.getString("APELL_PATERNO_EMP");
				registro[2]=rs.getString("APELL_MATERNO_EMP");
				registro[3]=rs.getString("NOMBRE_EMP");
				registro[4]=rs.getString("DIR_NAC_EMP");
				registro[5]=rs.getString("FEC_NAC_EMP");
				registro[6]=rs.getString("CELULAR_EMP");
				registro[7]=rs.getString("FECHA_INGRESO");
				registro[8]=rs.getString("USUARIO");
				registro[9]=rs.getString("PASS");
				registro[10]=rs.getString("NOM_TIPO_USU");
				registro[11]=rs.getString("COD_DISTRITO");
				registro[12]=rs.getString("COD_SEDE");
				
				
				TotalRegistros++;
				modelo.addRow(registro);
			}
			
			return modelo;
		}catch(Exception e){
			
			JOptionPane.showConfirmDialog(null, e);
			
			return null;
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
	
public JComboBox Combo_Tipo_Usuario(){
		
		JComboBox combo=new JComboBox();;
		
		SQL="SELECT * from tipo_usuario";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			combo.removeAllItems();
			
			while(rs.next()){
				combo.addItem(rs.getString("NOM_TIPO_USU"));
			}
			
			return combo;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
	}
	
	public int Id_Tipo_Usuario (String buscar){
		
		int id;
		
		SQL="SELECT * from tipo_usuario where NOM_TIPO_USU='"+buscar+"'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			
			rs.next();
			
			id=rs.getInt("COD_TIPO_USU");
			
			return id;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return 0;
		}
		
	}
}
