package Presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Logica.Metodo_form_Producto;
import Logica.MiRender;

public class Vista_Producto extends JFrame{
	public Lamina2_Form_producto lamina2 =new Lamina2_Form_producto();
	private Container contentPane=new Container();
	public String cod;
	public String valor;
	public String valor2;
	public String valor3;
	public String valor4;
	
	public Vista_Producto(){
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("");
		setContentPane(contentPane);
		
		lamina2.setBounds(50,50,500,480);
		lamina2.setBackground(new Color(52,73,94));
		lamina2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		contentPane.add(lamina2);
		
		lamina2.Mostrar("");
	}
	
	class Lamina2_Form_producto extends JPanel{
		
		//Form_Habitacion ventana=new Form_Habitacion();
		
		private JTable tabla;
		private DefaultTableModel modelo;
		
		private Accion_Boton2 buscar=new Accion_Boton2("Buscar",new ImageIcon("src/Files/buscar.png"));
		
		private JButton boton_buscar=new JButton(buscar);
		
		private JLabel lab_Prod=new JLabel("Buscar");
		private JLabel lab_Listado_Prod=new JLabel("LISTADO DE PRODUCTOS");
		
		private JTextField Producto=new JTextField(10);
		
		public Lamina2_Form_producto(){
			setLayout(new form_vista_prod2());
			
			lab_Listado_Prod.setForeground(new Color(0,230,64));
			lab_Listado_Prod.setFont(new Font("Jokerman",1,20));
			
			lab_Prod.setForeground(Color.WHITE);
			lab_Prod.setFont(new Font("Tahoma",1,15));
			
			Producto.setBackground(new Color(103,128,159));
			Producto.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Producto.setForeground(Color.WHITE);
			Producto.setFont(new Font("Tahoma",1,15));
			
			boton_buscar.setBackground(new Color(0,230,64));
			boton_buscar.setForeground(Color.WHITE);
			boton_buscar.setFont(new Font("Tahoma",1,12));
			
			add(lab_Listado_Prod);
			add(lab_Prod);
			add(Producto);
			add(boton_buscar);

			set_Table();
			
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
		
		public void Ocultar_columna(){
			tabla.getColumnModel().getColumn(0).setMaxWidth(0);
			tabla.getColumnModel().getColumn(0).setMinWidth(0);
			tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		
		public void Mostrar(String buscar){
			try{
				DefaultTableModel modelo;
				Metodo_form_Producto func=new Metodo_form_Producto();
				modelo=func.mostrar(buscar);
				
				lamina2.tabla.setModel(modelo);
				lamina2.tabla.setDefaultRenderer(Object.class,new MiRender());
				lamina2.tabla.getTableHeader().setPreferredSize(new Dimension(0,80));
				lamina2.tabla.getTableHeader().setBackground(Color.WHITE);
				lamina2.tabla.getTableHeader().setFont(new Font("Tahoma",1,12));
				Ocultar_columna();
				
			}catch(Exception e){
				JOptionPane.showConfirmDialog(null,e );
			}
		}
		
		private class Evento_click implements MouseListener{

			public void mouseClicked(MouseEvent e) {
					if(e.getSource()==tabla){
					
					int fila=tabla.getSelectedRow();
					
					
					cod=tabla.getValueAt(fila, 0).toString();
					valor=tabla.getValueAt(fila, 1).toString();
					valor2=tabla.getValueAt(fila, 2).toString();
					valor3=tabla.getValueAt(fila, 3).toString();
					valor4=tabla.getValueAt(fila, 4).toString();
					
					Vista_Producto.this.dispose();
					
					Form_Venta.id_Producto.setText(cod);
					Form_Venta.Producto.setText(valor);
					Form_Venta.Stock.setText(valor2);
					Form_Venta.Precio.setText(valor3);
					Form_Venta.Igv.setText(valor4);
					
					//Form_consumo.id_Producto.setText(cod);
					//Form_consumo.producto.setText(valor);
					//Form_consumo.precio_Venta.setText(valor2);
				
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {

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
				
				if(e.getSource()==boton_buscar){
					Mostrar(Producto.getText());
				}

			}
		}
	}
}	

class form_vista_prod2 implements LayoutManager{

	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	public void layoutContainer(Container miContenedor) {
		int n=miContenedor.getComponentCount();
		
		for(int i=0;i<n;i++){
			
			Component c=miContenedor.getComponent(i);
			
			switch (i){
				case 0:
					c.setBounds(10,10,300,30);
					break;
				case 1:
					c.setBounds(20,60,90,20);
					break;
				case 2:
					c.setBounds(80,60,150,20);
					break;
				case 3:
					c.setBounds(240,55,120,30);
					break;
				case 4:
					c.setBounds(50, 120, 400, 300);
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

