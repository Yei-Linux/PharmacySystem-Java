package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Trabajador;
import Datos.Datos_Venta;

public class Metodo_form_Venta {
	private Conexion mysql=new Conexion();
	private Connection cn=mysql.conectar();
	private String SQL="",SQL2="",SQL3="";
	public int totalRegistros;
	
	public boolean Insertar(Datos_Venta dts){
		
		SQL="INSERT INTO pedido_venta(FECHA_PEDIDO,DESCUENTO,SUBTOTAL,COD_CLIENTE,COD_EMPLEADO) VALUES((SELECT CURDATE()),?,?,?,?)";
		SQL2="INSERT INTO detalle_pedido_venta_sede (COD_PEDIDO_VENTA,COD_SEDE) VALUES((SELECT MAX(COD_PEDIDO_VENTA) FROM pedido_venta),?)";
		SQL3="INSERT INTO pedido_venta_producto(COD_PEDIDO_VENTA,COD_PRODUCTO,CANTIDAD,PRECIO_VENTA,IMPORTE)"+
	        " VALUES((SELECT MAX(COD_PEDIDO_VENTA) FROM pedido_venta),?,?,?,?)";
		
		try{
			PreparedStatement pst=cn.prepareStatement(SQL);
			PreparedStatement pst2=cn.prepareStatement(SQL2);
			PreparedStatement []pst3=new PreparedStatement[dts.Get_Modelo().getRowCount()];
			//PreparedStatement pst3=cn.prepareStatement(SQL3);
			
			pst.setDouble(1, dts.Get_Descuento());
			pst.setDouble(2,dts.Get_Subtotal());
			pst.setInt(3, dts.Get_Id_Cliente());
			pst.setInt(4,dts.Get_Id_Empleado());
			
			
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

	public boolean Editar(Datos_Venta dts){
		
		SQL="UPDATE detalle_producto_almacen as d INNER JOIN almacen as a on d.COD_ALMACEN=a.COD_ALMACEN INNER JOIN sede as s on a.COD_ALMACEN=s.COD_ALMACEN "+
		"SET d.STOCK=d.STOCK-? WHERE d.COD_PRODUCTO=? AND s.COD_SEDE=?";
	
		
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
