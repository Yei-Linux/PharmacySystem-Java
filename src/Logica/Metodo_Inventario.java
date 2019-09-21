package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodo_Inventario {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar,String buscar2){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Producto","Categoria","Stock","Precio","Proveedor"};
		String []registro=new String[6];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT p.COD_PRODUCTO,p.NOM_PRODUCTO,c.NOM_CATEGORIA,det.STOCK,p.PRECIO_VENTA,pv.NOM_PROVEEDOR FROM categoria as c INNER JOIN producto as p on c.COD_CATEGORIA=p.COD_CATEGORIA INNER JOIN proveedor as pv on p.COD_PROVEEDOR=pv.COD_PROVEEDOR INNER JOIN detalle_producto_almacen as det on p.COD_PRODUCTO=det.COD_PRODUCTO INNER JOIN almacen as a on a.COD_ALMACEN=det.COD_ALMACEN INNER JOIN sede as s ON a.COD_ALMACEN=s.COD_ALMACEN where s.COD_SEDE='"+buscar2+"' and p.NOM_PRODUCTO like '%"+buscar+"%' order by s.COD_SEDE";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PRODUCTO");
				registro[1]=rs.getString("NOM_PRODUCTO");
				registro[2]=rs.getString("NOM_CATEGORIA");
				registro[3]=rs.getString("STOCK");
				registro[4]=rs.getString("PRECIO_VENTA");
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
	
public JComboBox Combo_Sede(){
		
		JComboBox combo=new JComboBox();;
		
		sSQL="select * from sede";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
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
		
		sSQL="select * from sede where NOM_SEDE='"+buscar+"'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			rs.next();
			
			id=rs.getInt("COD_SEDE");
			
			return id;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return 0;
		}
		
	}
}
