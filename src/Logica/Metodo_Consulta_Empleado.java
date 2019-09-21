package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_Consulta_Empleado {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String SQL="";
	private String SQL2="";
	public int TotalRegistros;
	
	public DefaultTableModel Mostrar(String buscar,String buscar2){
		DefaultTableModel modelo;
		
		String []titulo={"ID","AP_PATERNO","AP_MATERNO","NOMBRE","DIRECCION","FEC_NAC","CEL","FEC_INGRESO","USER","PASS","TIPO_USER","DISTRITO","SEDE"};
		String []registro=new String[13];
		
		TotalRegistros=0;
		
		modelo=new DefaultTableModel(null,titulo);
		
		SQL="SELECT e.COD_EMPLEADO,e.APELL_PATERNO_EMP,e.APELL_MATERNO_EMP,e.NOMBRE_EMP,e.DIR_NAC_EMP,e.FEC_NAC_EMP,e.CELULAR_EMP,e.FECHA_INGRESO,u.USUARIO,u.PASS,t.NOM_TIPO_USU,d.NOM_DISTRITO,s.NOM_SEDE FROM distrito as d INNER JOIN empleado as e on d.COD_DISTRITO=e.COD_DISTRITO inner join sede as s on s.COD_SEDE=e.COD_SEDE inner JOIN usuario as u ON e.COD_USUARIO=u.COD_USUARIO INNER JOIN tipo_usuario as t ON u.COD_TIPO_USU=t.COD_TIPO_USU where e.COD_EMPLEADO like '%"+buscar+"%'and e.COD_SEDE='"+buscar2+"' order by e.COD_EMPLEADO";
		
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
}
