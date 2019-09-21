package Presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import Datos.Datos_Compra;
import Datos.Datos_Compra_Reporte;
import Datos.Datos_Venta;
import Datos.Datos_Venta_Reporte;
import Logica.Metodo_form_Compra;
import Logica.Metodo_form_Venta;
import Logica.MiRender;
import Presentacion.Form_Venta.Lamina2_Form_reserva;
import Presentacion.Form_Venta.Lamina_Form_reserva;


public class Form_Compra extends JFrame{
	public Lamina_Form_Compra lamina =new Lamina_Form_Compra();
	public Lamina2_Form_Compra lamina2 =new Lamina2_Form_Compra();
	public Container contentPane=new Container();
	
	public static JTextField id_Producto;
	public static JTextField Producto;
	public static JTextField Stock;
	public static JTextField Precio;
	public static JTextField Igv;
	public static JTextField id_Sede;
	public static JTextField Sede;
	public static JTextField id_Proveedor;
	public static JTextField Proveedor;
	public static int id_user;
	
	public Form_Compra(){
		setTitle("CLIENTE");
		setSize(1250,650);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		lamina.setBounds(50,50,550,530);
		lamina.setBackground(new Color(52,73,94));
		lamina.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		
		lamina2.setBounds(650,50,550,530);
		lamina2.setBackground(new Color(52,73,94));
		lamina2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		contentPane.add(lamina);
		contentPane.add(lamina2);
		
		lamina.Inhabilitar();
	}
	
	class Lamina_Form_Compra extends JPanel{
		
		public DefaultTableModel modelo;
		
		public String []registro=new String[5];

		public String accion="guardar";
		
		public Accion_Boton nuevo=new Accion_Boton("Nuevo",new ImageIcon("src/Files/nuevo.png"));
		public Accion_Boton agregar=new Accion_Boton("Agregar",new ImageIcon("src/Files/agregar.png"));
		public Accion_Boton eliminar=new Accion_Boton("Eliminar",new ImageIcon("src/Files/eliminar.png"));
		
		public Accion_Boton ver_sed=new Accion_Boton("",new ImageIcon("src/Files/Sede.png"));
		public Accion_Boton ver_prod=new Accion_Boton("",new ImageIcon("src/Files/Producto.png"));
		public Accion_Boton ver_prov=new Accion_Boton("",new ImageIcon("src/Files/Proveedor.png"));
		
		public JLabel lab_Titulo_lam=new JLabel("REGISTRO DE COMPRAS");
		public JLabel lab_Sede=new JLabel("Sede");
		public JLabel lab_Proveedor=new JLabel("Proveedor");
		public JLabel lab_Producto=new JLabel("Producto");
		public JLabel lab_Stock=new JLabel("Stock");
		public JLabel lab_Precio=new JLabel("Precio");
		public JLabel lab_Igv=new JLabel("Igv");
		public JLabel lab_Cantidad=new JLabel("Cantidad");
		public JLabel lab_Total=new JLabel("Total");
		
		public JTextField id_Compra=new JTextField(10);
		
		public JTextField Cantidad=new JTextField(7);
		public JTextField Total=new JTextField(7);
		
		public JButton nuevo_comp=new JButton(nuevo);
		public JButton agregar_comp=new JButton(agregar);
		public JButton eliminar_comp=new JButton(eliminar);
		
		public JButton ver_sede=new JButton(ver_sed);
		public JButton ver_producto=new JButton(ver_prod);
		public JButton ver_proveedor=new JButton(ver_prov);
		
		
		public Lamina_Form_Compra(){
			
				id_Producto=new JTextField(10);
				Producto=new JTextField(10);
				Stock=new JTextField(20);
				Precio=new JTextField(7);
				Igv=new JTextField(7);
				id_Sede=new JTextField(7);
				Sede=new JTextField(7);
				id_Proveedor=new JTextField(7);
				Proveedor=new JTextField(7);
				
				setLayout(new Compra_EnColumnas1());
				
				lab_Titulo_lam.setForeground(new Color(0,230,64));
				lab_Titulo_lam.setFont(new Font("Jokerman",1,20));
				
				lab_Sede.setForeground(Color.WHITE);
				lab_Sede.setFont(new Font("Tahoma",1,15));
				
				lab_Proveedor.setForeground(Color.WHITE);
				lab_Proveedor.setFont(new Font("Tahoma",1,15));
				
				lab_Producto.setForeground(Color.WHITE);
				lab_Producto.setFont(new Font("Tahoma",1,15));
				
				lab_Stock.setForeground(Color.WHITE);
				lab_Stock.setFont(new Font("Tahoma",1,15));
				
				lab_Precio.setForeground(Color.WHITE);
				lab_Precio.setFont(new Font("Tahoma",1,15));
				
				lab_Igv.setForeground(Color.WHITE);
				lab_Igv.setFont(new Font("Tahoma",1,15));
				
				lab_Cantidad.setForeground(Color.WHITE);
				lab_Cantidad.setFont(new Font("Tahoma",1,15));
				
				lab_Total.setForeground(Color.WHITE);
				lab_Total.setFont(new Font("Tahoma",1,15));
				
				Cantidad.setBackground(new Color(103,128,159));
				Cantidad.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Cantidad.setForeground(Color.WHITE);
				Cantidad.setFont(new Font("Tahoma",1,15));
				
				Total.setBackground(new Color(103,128,159));
				Total.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Total.setForeground(Color.WHITE);
				Total.setFont(new Font("Tahoma",1,15));
				
				Producto.setBackground(new Color(103,128,159));
				Producto.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Producto.setForeground(Color.WHITE);
				Producto.setFont(new Font("Tahoma",1,15));
				
				Stock.setBackground(new Color(103,128,159));
				Stock.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Stock.setForeground(Color.WHITE);
				Stock.setFont(new Font("Tahoma",1,15));
				
				Precio.setBackground(new Color(103,128,159));
				Precio.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Precio.setForeground(Color.WHITE);
				Precio.setFont(new Font("Tahoma",1,15));
				
				Igv.setBackground(new Color(103,128,159));
				Igv.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Igv.setForeground(Color.WHITE);
				Igv.setFont(new Font("Tahoma",1,15));
				
				Sede.setBackground(new Color(103,128,159));
				Sede.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Sede.setForeground(Color.WHITE);
				Sede.setFont(new Font("Tahoma",1,15));
				
				Proveedor.setBackground(new Color(103,128,159));
				Proveedor.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
				Proveedor.setForeground(Color.WHITE);
				Proveedor.setFont(new Font("Tahoma",1,15));
				
				nuevo_comp.setBackground(new Color(0,230,64));
				nuevo_comp.setForeground(Color.WHITE);
				nuevo_comp.setFont(new Font("Tahoma",1,12));
				
				agregar_comp.setBackground(new Color(3,201,169));
				agregar_comp.setForeground(Color.WHITE);
				agregar_comp.setFont(new Font("Tahoma",1,12));
				
				eliminar_comp.setBackground(new Color(242,38,19));
				eliminar_comp.setForeground(Color.WHITE);
				eliminar_comp.setFont(new Font("Tahoma",1,12));
				
				ver_sede.setBackground(new Color(0,230,64));
				ver_sede.setForeground(Color.WHITE);
				ver_sede.setFont(new Font("Tahoma",1,12));
				
				ver_producto.setBackground(new Color(3,201,169));
				ver_producto.setForeground(Color.WHITE);
				ver_producto.setFont(new Font("Tahoma",1,12));
				
				ver_proveedor.setBackground(new Color(242,38,19));
				ver_proveedor.setForeground(Color.WHITE);
				ver_proveedor.setFont(new Font("Tahoma",1,12));
				
				add(lab_Titulo_lam);
				add(id_Compra);
				
				add(lab_Sede);
				add(id_Sede);
				add(Sede);
				add(ver_sede);
				
				add(lab_Producto);
				add(id_Producto);
				add(Producto);
				add(ver_producto);
				
				add(lab_Proveedor);
				add(id_Proveedor);
				add(Proveedor);
				add(ver_proveedor);
				
				add(lab_Stock);
				add(Stock);
				
				add(lab_Precio);
				add(Precio);
				
				add(lab_Igv);
				add(Igv);
				
				add(lab_Cantidad);
				add(Cantidad);
				
				add(lab_Total);
				add(Total);
				
				add(nuevo_comp);
				add(agregar_comp);
				add(eliminar_comp);
				
				Cantidad.addKeyListener(new Evento_Tecla());
				Modelo_Tabla();
		}
		
		public DefaultTableModel Modelo_Tabla(){
			 String []titulo={"ID","Nombre","Cantidad","Precio","Total"};
			
			 modelo=new DefaultTableModel(null,titulo);
			 
			 return modelo;
		}
		
		public void Inhabilitar(){
			id_Compra.setVisible(false);
			id_Sede.setVisible(false);
			Sede.setEnabled(false);
			id_Producto.setVisible(false);
			Producto.setEnabled(false);
			id_Proveedor.setVisible(false);
			Proveedor.setEnabled(false);
			Stock.setEnabled(false);
			Precio.setEnabled(false);
			Igv.setEnabled(false);
			Cantidad.setEnabled(false);
			Total.setEnabled(false);

			nuevo_comp.setEnabled(true);
			agregar_comp.setEnabled(false);
			eliminar_comp.setEnabled(false);
			ver_sede.setEnabled(false);
			ver_producto.setEnabled(false);
			ver_proveedor.setEnabled(false);
			
			id_Compra.setText("");
			id_Producto.setText("");
			Producto.setText("");
			Stock.setText("");
			Precio.setText("");
			Igv.setText("");
			Cantidad.setText("");
			Total.setText("");
		}
		
		public void Habilitar(){
			id_Compra.setVisible(false);
			id_Sede.setVisible(false);
			Sede.setEnabled(false);
			id_Producto.setVisible(false);
			Producto.setEnabled(false);
			id_Proveedor.setVisible(false);
			Proveedor.setEnabled(false);
			Stock.setEnabled(false);
			Precio.setEnabled(false);
			Igv.setEnabled(false);
			Cantidad.setEnabled(true);
			Total.setEnabled(false);

			nuevo_comp.setEnabled(true);
			agregar_comp.setEnabled(true);
			eliminar_comp.setEnabled(false);
			ver_sede.setEnabled(true);
			ver_producto.setEnabled(true);
			ver_proveedor.setEnabled(true);
			
			id_Compra.setText("");
			id_Producto.setText("");
			Producto.setText("");
			Stock.setText("");
			Precio.setText("");
			Igv.setText("");
			Cantidad.setText("");
			Total.setText("");
		}
		
		private class Evento_Tecla implements KeyListener{

			public void keyPressed(KeyEvent arg0) {
				
			}

			public void keyReleased(KeyEvent e) {

				if(!Cantidad.getText().equalsIgnoreCase("")){
					Total.setText("");
					Total.setText(Double.toString(Integer.parseInt(Cantidad.getText())*Double.parseDouble(Precio.getText())));
				}else{
					Total.setText("");
				}
				
			}

			public void keyTyped(KeyEvent e) {	
				
			}
			
		}
		
		public double Obtener_Igv(){
			return ((double)Math.round((Obtener_Total()-Obtener_Subtotal()) * 100d) / 100d);
		}
		
		public double Obtener_Subtotal(){
				return ((double)Math.round( ((Obtener_Total()*100)/118)* 100d) / 100d);

			
		}
		
		public double Obtener_Total(){
			
			double total=0;
			
			for(int i=0;i<lamina2.tabla.getRowCount();i++){
				
				total=Double.parseDouble(lamina2.tabla.getValueAt(i,4).toString())+total;
			}
			
			return ((double)Math.round(total * 100d) / 100d);
		}
		
		private class Accion_Boton extends AbstractAction {
			public Accion_Boton(String nombre,Icon icono){
				putValue(Action.NAME,nombre);
				putValue(Action.SMALL_ICON,icono);
				putValue(Action.SHORT_DESCRIPTION,"Haga click para "+nombre);
			}

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()== nuevo_comp){
					Habilitar();
				}
				
				if(e.getSource()==agregar_comp){
					
					registro[0]=id_Producto.getText();
					registro[1]=Producto.getText();
					registro[2]=Cantidad.getText();
					registro[3]=Precio.getText();
					registro[4]=Total.getText();

					modelo.addRow(registro);
					lamina2.tabla.setModel(modelo);
					lamina2.tabla.setDefaultRenderer(Object.class,new MiRender());
					lamina2.tabla.getTableHeader().setPreferredSize(new Dimension(0,80));
					lamina2.tabla.getTableHeader().setBackground(Color.WHITE);
					lamina2.tabla.getTableHeader().setFont(new Font("Tahoma",1,12));
					
					
					lamina2.Total.setText(Double.toString(Obtener_Total()));
					lamina2.Subtotal.setText(Double.toString(Obtener_Subtotal()));
					lamina2.IGV.setText(Double.toString(Obtener_Igv()));
					
					Inhabilitar();
					
				}
				
				if(e.getSource()==eliminar_comp){
					
					int confirmacion=JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar la reserva?","Confirmacion",2);
					
					if(confirmacion==0){
						DefaultTableModel model=(DefaultTableModel)lamina2.tabla.getModel();
						model.removeRow((Integer.parseInt(id_Compra.getText())));
						id_Compra.setText("");
						eliminar_comp.setEnabled(false);
						lamina2.Total.setText(Double.toString(Obtener_Total()));
						lamina2.Subtotal.setText(Double.toString(Obtener_Subtotal()));
						lamina2.IGV.setText(Double.toString(Obtener_Igv()));
					}
				}
				
				if(e.getSource()==ver_sede){
					Vista_Sede vista4=new Vista_Sede();
					vista4.show();
					
				}
				
				if(e.getSource()==ver_proveedor){
					Vista_Proveedor vista3=new Vista_Proveedor();
					vista3.show();
				}
				
				if(e.getSource()==ver_producto){
					
					Vista_ProductoC vista2=new Vista_ProductoC();
					vista2.show();
				}
			}
			
		}
		
	}
	class Lamina2_Form_Compra extends JPanel{
		
		
		private JTable tabla;
		private DefaultTableModel modelo;
		
		private Accion_Boton2 buscar=new Accion_Boton2("Buscar",new ImageIcon("src/Presesentacion/bola1.png"));
		private Accion_Boton2 eliminar=new Accion_Boton2("Eliminar",new ImageIcon("src/Presesentacion/bola1.png"));
		private Accion_Boton2 salir=new Accion_Boton2("Salir",new ImageIcon("src/Presesentacion/bola1.png"));
		private Accion_Boton2 bot_importe=new Accion_Boton2("Importe",new ImageIcon("src/Files/importe.png"));
		private Accion_Boton2 bot_realizar_pag=new Accion_Boton2("Pagos",new ImageIcon("src/Files/pagos.png"));
		
		
		private JButton boton_buscar=new JButton(buscar);
		private JButton boton_eliminar=new JButton(eliminar);
		private JButton boton_salir=new JButton(salir);
		private JButton boton_importe=new JButton(bot_importe);
		private JButton boton_realizar_pagos=new JButton(bot_realizar_pag);
		
		private JLabel lab_Listado_Prod=new JLabel("LISTADO DE PRODUCTOS EN LA COMPRA");
		
		public JLabel l_Importe=new JLabel("IMPO.");
		public JLabel l_Cambio=new JLabel("CAMB.");
		public JLabel l_Descuento=new JLabel("DESC.");
		public JLabel l_Subtotal=new JLabel("SUBTO.");
		public JLabel l_IGV=new JLabel("IGV");
		public JLabel l_Total=new JLabel("TOTAL");
		
		public JTextField Importe=new JTextField(10);
		public JTextField Cambio=new JTextField(10);
		public JTextField Descuento=new JTextField(10);
		public JTextField Subtotal=new JTextField(10);
		public JTextField IGV=new JTextField(10);
		public JTextField Total=new JTextField(10);
		
		public Lamina2_Form_Compra(){
			setLayout(new Compra_EnColumnas2());
			add(lab_Listado_Prod);
			
			lab_Listado_Prod.setForeground(new Color(0,230,64));
			lab_Listado_Prod.setFont(new Font("Jokerman",1,20));

			l_Importe.setForeground(Color.WHITE);
			l_Importe.setFont(new Font("Tahoma",1,15));
			
			l_Cambio.setForeground(Color.WHITE);
			l_Cambio.setFont(new Font("Tahoma",1,15));
			
			l_Subtotal.setForeground(Color.WHITE);
			l_Subtotal.setFont(new Font("Tahoma",1,15));
			
			l_Descuento.setForeground(Color.WHITE);
			l_Descuento.setFont(new Font("Tahoma",1,15));
			
			l_IGV.setForeground(Color.WHITE);
			l_IGV.setFont(new Font("Tahoma",1,15));
			
			l_Total.setForeground(Color.WHITE);
			l_Total.setFont(new Font("Tahoma",1,15));
			
			Importe.setBackground(new Color(103,128,159));
			Importe.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Importe.setForeground(Color.WHITE);
			Importe.setFont(new Font("Tahoma",1,15));
			
			Cambio.setBackground(new Color(103,128,159));
			Cambio.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Cambio.setForeground(Color.WHITE);
			Cambio.setFont(new Font("Tahoma",1,15));
			
			Descuento.setBackground(new Color(103,128,159));
			Descuento.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Descuento.setForeground(Color.WHITE);
			Descuento.setFont(new Font("Tahoma",1,15));
			
			Subtotal.setBackground(new Color(103,128,159));
			Subtotal.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Subtotal.setForeground(Color.WHITE);
			Subtotal.setFont(new Font("Tahoma",1,15));
			
			IGV.setBackground(new Color(103,128,159));
			IGV.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			IGV.setForeground(Color.WHITE);
			IGV.setFont(new Font("Tahoma",1,15));
			
			Total.setBackground(new Color(103,128,159));
			Total.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Total.setForeground(Color.WHITE);
			Total.setFont(new Font("Tahoma",1,15));
			
			boton_importe.setBackground(new Color(0,230,64));
			boton_importe.setForeground(Color.WHITE);
			boton_importe.setFont(new Font("Tahoma",1,12));
			
			boton_realizar_pagos.setBackground(new Color(3,201,169));
			boton_realizar_pagos.setForeground(Color.WHITE);
			boton_realizar_pagos.setFont(new Font("Tahoma",1,12));
			
			set_Table();
			
			add(l_Importe);
			add(l_Cambio);
			add(l_Descuento);
			add(l_Subtotal);
			add(l_IGV);
			add(l_Total);
			
			add(Importe);
			add(Cambio);
			add(Descuento);
			add(Subtotal);
			add(IGV);
			add(Total);
			
			add(boton_importe);
			add(boton_realizar_pagos);
			
			Habilitar();
			
		}
		
		public void set_Table(){
			
			modelo = new DefaultTableModel();
			tabla = new JTable();
			JScrollPane JS=new JScrollPane(tabla);
			
			JS.setPreferredSize(new Dimension(400,450));
			tabla.setModel(modelo);
			
			Evento_click evento=new Evento_click();
			tabla.addMouseListener(evento);
			
			add(JS);
		}
		
		public void Habilitar(){
			Importe.setEnabled(false);
			Cambio.setEnabled(true);
			
			Subtotal.setEnabled(false);
			Descuento.setEnabled(true);
			IGV.setEnabled(false);
			
			Total.setEnabled(false);
		}
		
		public void Reset(){
			
			Sede.setText("");
			Importe.setText("");
			Cambio.setText("");
			Descuento.setText("");
			Subtotal.setText("");
			IGV.setText("");
			Total.setText("");
			Proveedor.setText("");
			
			tabla.setModel(lamina.Modelo_Tabla());	
			
			
			}
		
		private class Evento_click implements MouseListener{

			public void mouseClicked(MouseEvent e) {
				
				int fila=tabla.rowAtPoint(e.getPoint());
				lamina.id_Compra.setText(Integer.toString(fila));
				lamina.eliminar_comp.setEnabled(true);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		private class Accion_Boton2 extends AbstractAction{
			
			public Accion_Boton2(String nombre2,Icon icono2){
				putValue(Action.NAME,nombre2);
				putValue(Action.SMALL_ICON,icono2);
				putValue(Action.SHORT_DESCRIPTION,"Haga click para "+nombre2);
			}

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==boton_eliminar){
			
				}
				
				if(e.getSource()==boton_buscar){
				}
				if(e.getSource()==boton_salir){
					//ventana.dispose();
				}
				
				if(e.getSource()==boton_importe){
					
					String importe=JOptionPane.showInputDialog("Inserte el importe a pagar");
					
					if(!importe.equalsIgnoreCase("")){
						Importe.setText(importe);
						Cambio.setText(Double.toString(Double.parseDouble(importe)-lamina.Obtener_Total()));
					}
					
					
				}
				
				if(e.getSource()==boton_realizar_pagos){
					
					Datos_Compra dts=new Datos_Compra();
					Metodo_form_Compra metod=new Metodo_form_Compra();
					
					dts.Set_Modelo(tabla.getModel());
					dts.Set_Id_Sede(Integer.parseInt(id_Sede.getText()));
					dts.Set_Id_Proveedor(Integer.parseInt(id_Proveedor.getText()));
					dts.Set_Importe(Double.parseDouble(Importe.getText()));
					dts.Set_Total(Double.parseDouble(Total.getText()));
					
					if(metod.Insertar(dts) && metod.Editar(dts)){
						JOptionPane.showMessageDialog(null,"La compra fue registrada correctamente");
						
						Datos_Compra_Reporte em;
				        List <Datos_Compra_Reporte>lista = new ArrayList<>(); 
				        for(int i=0; i<tabla.getRowCount(); i++){ 
				            em = new Datos_Compra_Reporte(tabla.getValueAt(i, 0).toString(),tabla.getValueAt(i,1).toString(), 
				            	tabla.getValueAt(i, 2).toString(),tabla.getValueAt(i, 3).toString(),tabla.getValueAt(i,4).toString());
				            lista.add(em); 
				        }
				        
				        JasperReport reporte;
				        
				        String path = "Reports/MyReports/Reporte2.jasper";
				        
				        try {
				        	
				            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); 
				            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista)); 
				            JasperViewer viewer = new JasperViewer(jprint, false);
				            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
				            viewer.setVisible(true);
				            
				        } catch (JRException ex) {
				           System.out.println(ex);
				        }
						
						Reset();
						lamina.Inhabilitar();
					}else{
						JOptionPane.showMessageDialog(null,"La compra no fue registrada correctamente");
					}
				}
			}
			
		}
	}
}

class Compra_EnColumnas1 implements LayoutManager{
	private int x;
	private int cont;

	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	public void layoutContainer(Container miContenedor) {
		int n=miContenedor.getComponentCount();
		x=50;
		cont=0;
		
		for(int i=0;i<n;i++){
			Component c=miContenedor.getComponent(i);
			
			if(cont%2==0){
				x=50;
			}
			
			switch (i){
			case 0:
				c.setBounds(10,10,300 ,30);
				cont++;
				break;
			case 1:
				c.setBounds(x,30,100 ,20);
				cont++;
				break;
				
				
			case 2:
				c.setBounds(x,60,150,20);
				cont++;
				break;
			case 3:
				c.setBounds(200,60,50,20);
				break;
			case 4:
				c.setBounds(x-200,60,150,20);
				cont++;
				break;
			case 5:
				c.setBounds(450,50,50,30);
				break;
				
				
			case 6:
				c.setBounds(x,90,150,20);
				cont++;
				break;
			case 7:
				c.setBounds(200,90,50,20);
				break;
			case 8:
				c.setBounds(x-200,90,150,20);
				cont++;
				break;
			case 9:
				c.setBounds(450,85,50,30);
				break;
				
				
			case 10:
				c.setBounds(x,120,150,20);
				cont++;
				break;
			case 11:
				c.setBounds(200,120,50,20);
				break;
			case 12:
				c.setBounds(x-200,120,150,20);
				cont++;
				break;
			case 13:
				c.setBounds(450,120,50,30);
				break;
				
				
			case 14:
				c.setBounds(x,150,150 ,20);
				cont++;
				break;
			case 15:
				c.setBounds(x,150,150 ,20);
				cont++;
				break;

			case 16:
				c.setBounds(x,180,100 ,20);
				cont++;
				break;
			case 17:
				c.setBounds(x,180,100 ,20);
				cont++;
				break;
				
			case 18:
				c.setBounds(x,210,100 ,20);
				cont++;
				break;
			case 19:
				c.setBounds(x,210,100 ,20);
				cont++;
				break;
				
				
			case 20:
				c.setBounds(x,240,100 ,20);
				cont++;
				break;
			case 21:
				c.setBounds(x,240,100 ,20);
				cont++;
				break;
				
				
			case 22:
				c.setBounds(x,270,100 ,20);
				cont++;
				break;
			case 23:
				c.setBounds(x,270,100,20);
				cont++;
				break;
				
			case 24:
				c.setBounds(x,380,120,30);
				cont++;
				break;	
			case 25:
				c.setBounds(230,380,120,30);
				cont++;
				break;
			case 26:
				c.setBounds(400,380,120,30);
				cont++;
				break;
			}
			
				x+=200;
		}
		
	}

	public Dimension minimumLayoutSize(Container arg0) {

		return null;
	}

	public Dimension preferredLayoutSize(Container arg0) {

		return null;
	}

	public void removeLayoutComponent(Component arg0) {

		
	}
	
}

class Compra_EnColumnas2 implements LayoutManager{

	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	public void layoutContainer(Container miContenedor) {
		int n=miContenedor.getComponentCount();
		
		for(int i=0;i<n;i++){
			
			Component c=miContenedor.getComponent(i);
			
			switch (i){
				case 0:
					c.setBounds(50,50,500,30);
					break;
				case 1:
					c.setBounds(50, 120, 450, 150);
					break;
				case 2:
					c.setBounds(50, 290, 60, 20);
					break;
				case 3:
					c.setBounds(120, 290, 60, 20);
					break;
				case 4:
					c.setBounds(190, 290, 80, 20);
					break;
				case 5:
					c.setBounds(260, 290, 60, 20);
					break;
				case 6:
					c.setBounds(330, 290, 60, 20);
					break;
				case 7:
					c.setBounds(400, 290, 60, 20);
					break;
				case 8:
					c.setBounds(50, 310, 60, 30);
					break;
				case 9:
					c.setBounds(120, 310, 60, 30);
					break;
				case 10:
					c.setBounds(190, 310, 60, 30);
					break;
				case 11:
					c.setBounds(260, 310, 60, 30);
					break;
				case 12:
					c.setBounds(330, 310, 60, 30);
					break;
				case 13:
					c.setBounds(400, 310, 60, 30);
					break;
				case 14:
					c.setBounds(100,360,150,30);
					break;
				case 15:
					c.setBounds(300,360,150,30);
					break;
			}
		}
		
	}

	public Dimension minimumLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension preferredLayoutSize(Container arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeLayoutComponent(Component arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

