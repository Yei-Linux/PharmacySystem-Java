package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Cliente;
import Datos.Datos_Producto;

public class Metodo_form_Producto2 {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String sSQL="",sSQL2="";
	public int totalRegistros;
	
	public DefaultTableModel mostrar(String buscar){
		DefaultTableModel modelo;
		
		String []titulo={"ID","Nombre","Precio","IGV","Proveedor","Categoria","Sede"};
		String []registro=new String[7];
		
		totalRegistros=0;
		modelo=new DefaultTableModel(null,titulo);
		
		sSQL="SELECT p.COD_PRODUCTO,p.NOM_PRODUCTO,p.PRECIO_VENTA,p.IGV,prov.NOM_PROVEEDOR,c.NOM_CATEGORIA,s.NOM_SEDE from categoria as c INNER JOIN producto as p on p.COD_CATEGORIA=c.COD_CATEGORIA INNER JOIN proveedor as prov ON p.COD_PROVEEDOR=prov.COD_PROVEEDOR INNER JOIN detalle_producto_almacen as det ON p.COD_PRODUCTO=det.COD_PRODUCTO INNER join almacen as a ON det.COD_ALMACEN=a.COD_ALMACEN INNER JOIN sede as s on s.COD_ALMACEN=a.COD_ALMACEN where p.NOM_PRODUCTO like '%"+buscar+"%' order by p.COD_PRODUCTO";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			while(rs.next()){//ACA MUESTRO TODAS LAS CELDAS QUE COINCIDAN CON LA CONSULTA
				registro[0]=rs.getString("COD_PRODUCTO");
				registro[1]=rs.getString("NOM_PRODUCTO");
				registro[2]=rs.getString("PRECIO_VENTA");
				registro[3]=rs.getString("IGV");
				registro[4]=rs.getString("NOM_PROVEEDOR");
				registro[5]=rs.getString("NOM_CATEGORIA");
				registro[6]=rs.getString("NOM_SEDE");

				totalRegistros++;
				modelo.addRow(registro);
			}
			
			return modelo;
		}catch(Exception e){
			
			JOptionPane.showConfirmDialog(null, e);
			
			return null;
		}
	}
	
	public boolean Insertar(Datos_Producto dts){
		sSQL="INSERT INTO producto(NOM_PRODUCTO,PRECIO_VENTA,IGV,COD_PROVEEDOR,COD_CATEGORIA)"+
	        " VALUES(?,?,?,?,?) ";
		sSQL2="INSERT INTO detalle_producto_almacen(COD_PRODUCTO,COD_ALMACEN,STOCK)"+
		        " VALUES((SELECT MAX(COD_PRODUCTO) FROM producto),?,0) ";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			PreparedStatement pst2=cn.prepareStatement(sSQL2);
			
			pst.setString(1,dts.Get_Nom_Producto());
			pst.setDouble(2,dts.Get_Precio());
			pst.setDouble(3,dts.Get_igv());
			pst.setInt(4,dts.Get_id_Proveedor());
			pst.setInt(5,dts.Get_id_Categoria());
			
			pst2.setInt(1,dts.Get_id_Almacen());
			
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
	
	public boolean Editar(Datos_Producto dts){
		
		sSQL="update producto set NOM_PRODUCTO=?,PRECIO_VENTA=?,IGV=?,COD_PROVEEDOR=?,COD_CATEGORIA=? where COD_PRODUCTO=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			pst.setString(1,dts.Get_Nom_Producto());
			pst.setDouble(2,dts.Get_Precio());
			pst.setDouble(3,dts.Get_igv());
			pst.setInt(4,dts.Get_id_Proveedor());
			pst.setInt(5,dts.Get_id_Categoria());
			
			pst.setInt(6,dts.Get_id_Producto());
			
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
	
	public boolean Eliminar(Datos_Producto dts){
		
		sSQL="delete from producto where COD_PRODUCTO=?";
		
		try{
			PreparedStatement pst=cn.prepareStatement(sSQL);
			
			pst.setInt(1,dts.Get_id_Producto());
			
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
	
public JComboBox Combo_Proveedor(){
		
		JComboBox combo=new JComboBox();;
		
		sSQL="select * from proveedor";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			combo.removeAllItems();
			
			while(rs.next()){
				combo.addItem(rs.getString("NOM_PROVEEDOR"));
			}
			
			return combo;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
	}
	
	public int Id_Proveedor (String buscar){
		
		int id;
		
		sSQL="select * from proveedor where NOM_PROVEEDOR='"+buscar+"'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			rs.next();
			
			id=rs.getInt("COD_PROVEEDOR");
			
			return id;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return 0;
		}
		
	}
	
	public JComboBox Combo_Categoria(){
		
		JComboBox combo=new JComboBox();;
		
		sSQL="SELECT * from categoria";
		
		try{
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			combo.removeAllItems();
			
			while(rs.next()){
				combo.addItem(rs.getString("NOM_CATEGORIA"));
			}
			
			return combo;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return null;
		}
	}
	
	public int Id_Categoria (String buscar){
		
		int id;
		
		sSQL="SELECT * from categoria where NOM_CATEGORIA='"+buscar+"'";
		
		try{
			
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sSQL);
			
			rs.next();
			
			id=rs.getInt("COD_CATEGORIA");
			
			return id;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, e);
			
			return 0;
		}
		
	}
	
}
