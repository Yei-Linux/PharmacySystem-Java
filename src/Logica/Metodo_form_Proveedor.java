package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_form_Proveedor {
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
		
		sSQL="SELECT p.COD_PROVEEDOR,p.NOM_PROVEEDOR,p.DIR_PROVEEDOR,p.CEL_PROVEEDOR,d.NOM_DISTRITO FROM proveedor as p INNER JOIN distrito as d on p.COD_DISTRITO=d.COD_DISTRITO where p.COD_PROVEEDOR like '%"+buscar+"%' order by p.COD_PROVEEDOR";
		
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
}
