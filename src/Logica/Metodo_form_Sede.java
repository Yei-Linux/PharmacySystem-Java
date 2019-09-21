package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_form_Sede {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Nombre","Distrito","Almacen"};
		String []registro=new String[4];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT s.COD_SEDE,s.NOM_SEDE,d.NOM_DISTRITO,a.NOM_ALMACEN FROM sede as s INNER JOIN distrito as d ON s.COD_DISTRITO=d.COD_DISTRITO INNER JOIN almacen as a ON s.COD_ALMACEN=a.COD_ALMACEN where s.COD_SEDE like '%"+buscar+"%' order by s.COD_SEDE";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_SEDE");
				registro[1]=rs.getString("NOM_SEDE");
				registro[2]=rs.getString("NOM_DISTRITO");
				registro[3]=rs.getString("NOM_ALMACEN");

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
