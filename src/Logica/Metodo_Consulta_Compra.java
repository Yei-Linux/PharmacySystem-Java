package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_Consulta_Compra {
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
		
		sSQL="SELECT pc.COD_PEDIDO_COMPRA,p.NOM_PRODUCTO,c.NOM_CATEGORIA,co.CANTIDAD,co.PRECIO_COMPRA,(co.CANTIDAD*co.PRECIO_COMPRA) as TOTAL from proveedor as pv INNER JOIN pedido_compra as pc ON pv.COD_PROVEEDOR=pc.COD_PROVEEDOR INNER JOIN pedido_compra_producto as co on pc.COD_PEDIDO_COMPRA=co.COD_PEDIDO_COMPRA INNER join producto as p on co.COD_PRODUCTO=p.COD_PRODUCTO INNER JOIN categoria as c on c.COD_CATEGORIA=p.COD_CATEGORIA where pv.NOM_PROVEEDOR like '%"+buscar+"%'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PEDIDO_COMPRA");
				registro[1]=rs.getString("NOM_PRODUCTO");
				registro[2]=rs.getString("NOM_CATEGORIA");
				registro[3]=rs.getString("CANTIDAD");
				registro[4]=rs.getString("PRECIO_COMPRA");
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
