package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_Consulta_Venta {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Producto","Categoria","Cantidad","Precio","Total"};
		String []registro=new String[6];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT v.COD_PEDIDO_VENTA,p.NOM_PRODUCTO,c.NOM_CATEGORIA,v.CANTIDAD,v.PRECIO_VENTA,(v.CANTIDAD*v.PRECIO_VENTA) as TOTAL from cliente as cl INNER JOIN pedido_venta as pv ON cl.COD_CLIENTE=pv.COD_CLIENTE INNER JOIN pedido_venta_producto as v on pv.COD_PEDIDO_VENTA=v.COD_PEDIDO_VENTA INNER join producto as p on v.COD_PRODUCTO=p.COD_PRODUCTO INNER JOIN categoria as c on c.COD_CATEGORIA=p.COD_CATEGORIA where cl.DNI_CLI like '%"+buscar+"%'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PEDIDO_VENTA");
				registro[1]=rs.getString("NOM_PRODUCTO");
				registro[2]=rs.getString("NOM_CATEGORIA");
				registro[3]=rs.getString("CANTIDAD");
				registro[4]=rs.getString("PRECIO_VENTA");
				registro[5]=rs.getString("TOTAL");

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
