package Presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

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

import Logica.Metodo_Consulta_Compra;
import Logica.Metodo_Consulta_Venta;
import Logica.MiRender;
import Presentacion.Consulta_Venta.Lamina2_Form_Venta;


public class Consulta_Compra extends JFrame{
	public Lamina2_Form_Compra lamina2 =new Lamina2_Form_Compra();
	public Container contentPane=new Container();
	public String cod;
	public String valor;
	
	public Consulta_Compra(){
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("");
		setContentPane(contentPane);
		

		lamina2.setBounds(50,50,700,480);
		lamina2.setBackground(new Color(52,73,94));
		lamina2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		contentPane.add(lamina2);
		
		lamina2.Mostrar("");

	}
	
class Lamina2_Form_Compra extends JPanel{
		
		//Form_Habitacion ventana=new Form_Habitacion();
		
		private JTable tabla;
		private DefaultTableModel modelo;
		
		private Accion_Boton2 buscar=new Accion_Boton2("Buscar",new ImageIcon("src/Files/buscar.png"));
		
		private JButton boton_buscar;
		
		private JLabel lab_Cliente=new JLabel("Buscar");
		private JLabel lab_Listado_Cliente=new JLabel("LISTADO DE VENTAS");
		
		private JTextField Cliente=new JTextField(10);
		
		public Lamina2_Form_Compra(){
			
			boton_buscar=new JButton(buscar);
			
			setLayout(new con2_vista_EnColumnas2_3());
			
			lab_Listado_Cliente.setForeground(new Color(0,230,64));
			lab_Listado_Cliente.setFont(new Font("Jokerman",1,20));
			
			lab_Cliente.setForeground(Color.WHITE);
			lab_Cliente.setFont(new Font("Tahoma",1,15));
			
			Cliente.setBackground(new Color(103,128,159));
			Cliente.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Cliente.setForeground(Color.WHITE);
			Cliente.setFont(new Font("Tahoma",1,15));
			
			boton_buscar.setBackground(new Color(0,230,64));
			boton_buscar.setForeground(Color.WHITE);
			boton_buscar.setFont(new Font("Tahoma",1,12));
			
			add(lab_Listado_Cliente);
			add(lab_Cliente);
			add(Cliente);
			add(boton_buscar);
			
			set_Table();
			
			
			
		}
		
		public void set_Table(){
			
			modelo = new DefaultTableModel();
			tabla = new JTable();
			JScrollPane JS=new JScrollPane(tabla);
			
			JS.setPreferredSize(new Dimension(400,450));
			tabla.setModel(modelo);
			
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
				Metodo_Consulta_Compra func=new Metodo_Consulta_Compra();
				modelo=func.mostrar(buscar);
				
				lamina2.tabla.setModel(modelo);
				lamina2.tabla.setDefaultRenderer(Object.class,new MiRender());
				lamina2.tabla.getTableHeader().setPreferredSize(new Dimension(0,80));
				lamina2.tabla.getTableHeader().setBackground(Color.WHITE);
				lamina2.tabla.getTableHeader().setFont(new Font("Tahoma",1,12));
				
			}catch(Exception e){
				JOptionPane.showConfirmDialog(null,e );
			}
		}
		
		
		private class Accion_Boton2 extends AbstractAction{
			
			public Accion_Boton2(String nombre2,Icon icono2){
				putValue(Action.NAME,nombre2);
				putValue(Action.SMALL_ICON,icono2);
				putValue(Action.SHORT_DESCRIPTION,"Haga click para "+nombre2);
			}

			public void actionPerformed(ActionEvent e) {
				
				

					Mostrar(Cliente.getText());
			
					


			}
			
		}
	}
}

class con2_vista_EnColumnas2_3 implements LayoutManager{

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
					c.setBounds(50, 120, 600, 300);
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
