package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Datos.Datos_Compra;
import Datos.Datos_Venta;

public class Metodo_form_Compra {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String SQL="",SQL2="",SQL3="";
	public int totalRegistros;
	
	public boolean Insertar(Datos_Compra dts){
		
		SQL="INSERT INTO pedido_compra(FECHA_PEDIDO,COD_PROVEEDOR,COD_SEDE,TOTAL) VALUES((SELECT CURDATE()),?,?,?)";
		SQL2="INSERT INTO detalle_pedido_compra_almacen (COD_PEDIDO_COMPRA,COD_ALMACEN) VALUES((SELECT MAX(COD_PEDIDO_COMPRA) FROM pedido_compra),?)";
		SQL3="INSERT INTO pedido_compra_producto(COD_PEDIDO_COMPRA,COD_PRODUCTO,CANTIDAD,PRECIO_COMPRA,IMPORTE)"+
	        " VALUES((SELECT MAX(COD_PEDIDO_COMPRA) FROM pedido_compra),?,?,?,?)";
		
		try{
			PreparedStatement pst=cn.prepareStatement(SQL);
			PreparedStatement pst2=cn.prepareStatement(SQL2);
			PreparedStatement []pst3=new PreparedStatement[dts.Get_Modelo().getRowCount()];
			//PreparedStatement pst3=cn.prepareStatement(SQL3);
			
			pst.setInt(1, dts.Get_Id_Proveedor());
			pst.setInt(2,dts.Get_Id_Sede());
			pst.setDouble(3, dts.Get_Total());
			
			
			pst2.setInt(1,dts.Get_Id_Sede());

			for(int i=0;i<dts.Get_Modelo().getRowCount();i++){
				
				pst3[i]=cn.prepareStatement(SQL3);
				
				pst3[i].setInt(1,Integer.parseInt((String) dts.Get_Modelo().getValueAt(i,0)));
				pst3[i].setDouble(2,Double.parseDouble((String)dts.Get_Modelo().getValueAt(i,2)));
				pst3[i].setDouble(3,Double.parseDouble((String)dts.Get_Modelo().getValueAt(i, 3)));
				pst3[i].setDouble(4,dts.Get_Importe());
			}
			
			int n=pst.executeUpdate();
			boolean flag=true;
			if(n!=0){
				int n2=pst2.executeUpdate();
				if(n2!=0){
					for(int i=0;i<dts.Get_Modelo().getRowCount();i++){
						int n3=pst3[i].executeUpdate();
						if(n3==0){
							
							flag=false;
						}
					}
					
					return flag;
					
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

	public boolean Editar(Datos_Compra dts){
		
		SQL="UPDATE detalle_producto_almacen as d INNER JOIN almacen as a on d.COD_ALMACEN=a.COD_ALMACEN INNER JOIN sede as s on a.COD_ALMACEN=s.COD_ALMACEN "+
		"SET d.STOCK=d.STOCK+? WHERE d.COD_PRODUCTO=? AND s.COD_SEDE=?";
	
		
		try{
			PreparedStatement []pst=new PreparedStatement[dts.Get_Modelo().getRowCount()];
			
			for(int i=0;i<dts.Get_Modelo().getRowCount();i++){
				
				pst[i]=cn.prepareStatement(SQL);
				
				pst[i].setDouble(1,Double.parseDouble((String)dts.Get_Modelo().getValueAt(i,2)));
				pst[i].setInt(2,Integer.parseInt((String) dts.Get_Modelo().getValueAt(i,0)));
				pst[i].setInt(3,dts.Get_Id_Sede());
			}
			
			boolean flag=true;
			for(int i=0;i<dts.Get_Modelo().getRowCount();i++){
				int n=pst[i].executeUpdate();
				if(n==0){
					
					flag=false;
				}
			}
			
			return flag;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
			return false;
		}
		
	}
}
