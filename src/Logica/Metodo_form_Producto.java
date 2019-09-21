package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_form_Producto{
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Nombre","Stock","Precio","IGV","Proveedor"};
		String []registro=new String[6];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT p.COD_PRODUCTO,p.NOM_PRODUCTO,d.STOCK,p.PRECIO_VENTA,p.IGV,pv.NOM_PROVEEDOR FROM proveedor as pv INNER JOIN producto as p on pv.COD_PROVEEDOR=p.COD_PROVEEDOR INNER JOIN detalle_producto_almacen as d on p.COD_PRODUCTO=d.COD_PRODUCTO INNER JOIN almacen as a on a.COD_ALMACEN=d.COD_ALMACEN INNER JOIN sede as s on s.COD_ALMACEN=a.COD_ALMACEN WHERE s.NOM_SEDE like '%"+buscar+"%'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PRODUCTO");
				registro[1]=rs.getString("NOM_PRODUCTO");
				registro[2]=rs.getString("STOCK");
				registro[3]=rs.getString("PRECIO_VENTA");
				registro[4]=rs.getString("IGV");
				registro[5]=rs.getString("NOM_PROVEEDOR");

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
