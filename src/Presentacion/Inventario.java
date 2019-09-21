package Presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import Datos.Datos_Producto;
import Logica.Metodo_Consulta_Empleado;
import Logica.Metodo_Inventario;
import Logica.Metodo_form_Producto2;
import Logica.MiRender;
import Presentacion.Form_Producto.Lamina2_Form_Producto;
import Presentacion.Form_Producto.Lamina_Form_Producto;

public class Inventario extends JFrame{
	public Container contentPane=new Container();
	public Lamina_Form_Producto lamina=new Lamina_Form_Producto();
	public Lamina2_Form_Producto lamina2=new Lamina2_Form_Producto();
	
	public Inventario(){
		setTitle("CLIENTE");
		setSize(1250,650);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		
		lamina.setBounds(50,50,550,530);
		lamina.setBackground(new Color(52,73,94));
		lamina.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		
		lamina2.setBounds(650,50,550,530);
		lamina2.setBackground(new Color(52,73,94));
		lamina2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
		
		contentPane.add(lamina);
		contentPane.add(lamina2);
		
		lamina2.Mostrar("",(String)lamina2.id_Sede.getText());
		lamina.Habilitar();
	}
	
	//PRIMERA LAMINA PARA REGISTRAR O EDITAR CLIENTES
	class Lamina_Form_Producto extends JPanel{
		
		public String accion="Guardar";
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public JLabel L_Titulo=new JLabel("PRODUCTO");
		public JLabel L_Nom_Producto=new JLabel("Producto");
		public JLabel L_Precio=new JLabel("Precio");
		public JLabel L_Stock=new JLabel("Stock");
		public JLabel L_Categoria=new JLabel("Categoria");
		public JLabel L_Cod_Producto=new JLabel("ID");
		public JLabel L_Proveedor=new JLabel("Proveedor");

		public JTextField id_Producto=new JTextField(10);
		public JLabel Nom_Producto=new JLabel("");
		public JLabel Stock=new JLabel("");
		public JLabel Precio=new JLabel("");
		public JLabel Cod_Producto=new JLabel("");
		public JLabel Categoria=new JLabel("");
		public JLabel Proveedor=new JLabel("");
		
		public Lamina_Form_Producto(){
			
			setLayout(new con_Producto_EnColumnas1());
			
			L_Titulo.setForeground(new Color(0,230,64));
			L_Titulo.setFont(new Font("Jokerman",1,20));
			
			L_Nom_Producto.setForeground(Color.WHITE);
			L_Nom_Producto.setFont(new Font("Tahoma",1,15));
			
			L_Precio.setForeground(Color.WHITE);
			L_Precio.setFont(new Font("Tahoma",1,15));
			
			L_Stock.setForeground(Color.WHITE);
			L_Stock.setFont(new Font("Tahoma",1,15));
			
			L_Categoria.setForeground(Color.WHITE);
			L_Categoria.setFont(new Font("Tahoma",1,15));
			
			L_Cod_Producto.setForeground(Color.WHITE);
			L_Cod_Producto.setFont(new Font("Tahoma",1,15));
			
			L_Proveedor.setForeground(Color.WHITE);
			L_Proveedor.setFont(new Font("Tahoma",1,15));
			
			Nom_Producto.setForeground(Color.BLACK);
			Nom_Producto.setFont(new Font("Tahoma",1,15));
			Nom_Producto.setBackground(Color.WHITE);
			Nom_Producto.setOpaque(true);
			
			Precio.setForeground(Color.BLACK);
			Precio.setFont(new Font("Tahoma",1,15));
			Precio.setBackground(Color.WHITE);
			Precio.setOpaque(true);
			
			Categoria.setForeground(Color.BLACK);
			Categoria.setFont(new Font("Tahoma",1,15));
			Categoria.setBackground(Color.WHITE);
			Categoria.setOpaque(true);
			
			Cod_Producto.setForeground(Color.BLACK);
			Cod_Producto.setFont(new Font("Tahoma",1,15));
			Cod_Producto.setBackground(Color.WHITE);
			Cod_Producto.setOpaque(true);
			
			Stock.setForeground(Color.BLACK);
			Stock.setFont(new Font("Tahoma",1,15));
			Stock.setBackground(Color.WHITE);
			Stock.setOpaque(true);
			
			Proveedor.setForeground(Color.BLACK);
			Proveedor.setFont(new Font("Tahoma",1,15));
			Proveedor.setBackground(Color.WHITE);
			Proveedor.setOpaque(true);
			
			
			add(L_Titulo);
			add(id_Producto);
			add(L_Cod_Producto);
			add(Cod_Producto);
			add(L_Nom_Producto);
			add(Nom_Producto);
			add(L_Categoria);
			add(Categoria);
			add(L_Stock);
			add(Stock);
			add(L_Precio);
			add(Precio);
			add(L_Proveedor);
			add(Proveedor);

		}
		
		public void Habilitar(){
			id_Producto.setVisible(false);
			Nom_Producto.setEnabled(true);
			Precio.setEnabled(true);
			Stock.setEnabled(true);
			Categoria.setEnabled(true);
			Cod_Producto.setEnabled(true);
			Proveedor.setEnabled(true);
			
			id_Producto.setText("");
			Nom_Producto.setText("");
			Precio.setText("");
			Cod_Producto.setText("");
			Stock.setText("");
			Categoria.setText("");
			Proveedor.setText("");
		}
		
		public void Deshabilitar(){
			
			id_Producto.setVisible(false);
			Nom_Producto.setEnabled(false);
			Precio.setEnabled(false);
			Stock.setEnabled(false);
			Categoria.setEnabled(false);
			Cod_Producto.setEnabled(false);
			Proveedor.setEnabled(false);
			
			id_Producto.setText("");
			Nom_Producto.setText("");
			Precio.setText("");
			Cod_Producto.setText("");
			Stock.setText("");
			Categoria.setText("");
			Proveedor.setText("");
	
		}
	}
	
	//SEGUNDA LAMINA PARA MOSTRAR LA TABLA DE CLIENTES
	class Lamina2_Form_Producto extends JPanel{
		
		public JTable tabla;
		public DefaultTableModel modelo;
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button2 buscar=new Accion_Button2("Buscar",new ImageIcon("src/Files/buscar.png"));
		public Accion_Button2 eliminar=new Accion_Button2("Eliminar",new ImageIcon("src/Files/eliminar.png"));
		
		public JLabel L_Titulo2=new JLabel ("LISTADO DE PRODUCTOS");
		public JLabel L_Buscar=new JLabel("Buscar: ");
		public JTextField Producto=new JTextField(10);
		
		public JButton bot_buscar=new JButton(buscar);
		
		public JComboBox sede=new JComboBox();
		public JTextField id_Sede=new JTextField(10);
	
		public Lamina2_Form_Producto(){
			
			Mostrar_Sede();
			
			id_Sede.setVisible(false);
			
			setLayout(new con_Producto_EnColumnas2());
			
			L_Titulo2.setForeground(new Color(0,230,64));
			L_Titulo2.setFont(new Font("Jokerman",1,20));
			
			L_Buscar.setForeground(Color.WHITE);
			L_Buscar.setFont(new Font("Tahoma",1,15));
			
			Producto.setBackground(new Color(103,128,159));
			Producto.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Producto.setForeground(Color.WHITE);
			Producto.setFont(new Font("Tahoma",1,15));
			
			bot_buscar.setBackground(new Color(0,230,64));
			bot_buscar.setForeground(Color.WHITE);
			bot_buscar.setFont(new Font("Tahoma",1,12));
			
			sede.setBackground(new Color(103,128,159));
			sede.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			sede.setForeground(Color.WHITE);
			sede.setFont(new Font("Tahoma",1,15));
			
			add(L_Titulo2);
			add(L_Buscar);
			add(Producto);
			add(bot_buscar);
			add(sede);
			setTable();
			
			add(id_Sede);
			
			sede.addActionListener(new Evento_Combo());
		}
		
		public void Mostrar_Sede(){
			try{
				
				Metodo_Inventario metodo=new Metodo_Inventario();
				
				sede=metodo.Combo_Sede();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		private class Evento_Combo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==sede){
					
					Metodo_Inventario metod=new Metodo_Inventario();
					
					id_Sede.setText(String.valueOf(metod.Id_Sede((String)sede.getSelectedItem())));
				}
				
			}
			
		}
		
		public void setTable(){
			modelo=new DefaultTableModel();
			tabla=new JTable();
			JScrollPane scroll_tabla=new JScrollPane(tabla);

			scroll_tabla.setPreferredSize(new Dimension(400,450));
			tabla.setModel(modelo);
			
			add(scroll_tabla);
			
			tabla.addMouseListener(new Evento_click());
		}
		
		public void Ocultar_Columna(){
			tabla.getColumnModel().getColumn(0).setMaxWidth(0);
			tabla.getColumnModel().getColumn(0).setMinWidth(0);
			tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		
		public void Mostrar (String buscar,String buscar2){
			try{
				DefaultTableModel modelo;
				
				Metodo_Inventario metodo=new Metodo_Inventario();
				modelo=metodo.mostrar(buscar,buscar2);				
				
				tabla.setModel(modelo);
				tabla.setDefaultRenderer(Object.class,new MiRender());
				tabla.getTableHeader().setPreferredSize(new Dimension(0,80));
				tabla.getTableHeader().setBackground(Color.WHITE);
				tabla.getTableHeader().setFont(new Font("Tahoma",1,12));
				
				Ocultar_Columna();
				
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null,e);
				
			}
			
		}
		
		private class Evento_click implements MouseListener{
			
			public Evento_click(){
				
			}

			public void mouseClicked(MouseEvent e) {
				

				
				int fila=tabla.rowAtPoint(e.getPoint());
				
				lamina.id_Producto.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Cod_Producto.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Nom_Producto.setText(tabla.getValueAt(fila,1).toString());
				lamina.Categoria.setText(tabla.getValueAt(fila, 2).toString());
				lamina.Stock.setText(tabla.getValueAt(fila, 3).toString());
				lamina.Precio.setText(tabla.getValueAt(fila, 4).toString());
				lamina.Proveedor.setText(tabla.getValueAt(fila, 5).toString());
				
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
		
		private class Accion_Button2 extends AbstractAction{
			
			public Accion_Button2(String nombre,Icon icono){
				putValue(Action.NAME,nombre);
				putValue(Action.SMALL_ICON,icono);
				putValue(Action.SHORT_DESCRIPTION,"Haz click para " + nombre);
			}
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource()==bot_buscar){
					Mostrar(Producto.getText(),id_Sede.getText());
				}
			}
			
		}
	}
}

class con_Producto_EnColumnas1 implements LayoutManager{
	private int x;

	public void addLayoutComponent(String arg0, Component arg1) {
		// TODO Auto-generated method stub
		
	}

	public void layoutContainer(Container miContenedor) {
		int n=miContenedor.getComponentCount();
		x=50;
		
		for(int i=0;i<n;i++){
			Component c=miContenedor.getComponent(i);
			
			if(i%2==0){
				x=50;
			}
			
			switch (i){
			case 0:
				c.setBounds(200,70,300 ,30);
				break;
			case 1:
				c.setBounds(x,30,100 ,20);
				break;
			case 2:
				c.setBounds(x,160,150 ,20);
				break;
			case 3:
				c.setBounds(x,160,150 ,20);
				break;
			case 4:
				c.setBounds(x,210,150 ,20);
				break;
			case 5:
				c.setBounds(x,210,150 ,20);
				break;
			case 6:
				c.setBounds(x,260,150 ,20);
				break;
			case 7:
				c.setBounds(x,260,100 ,20);
				break;
			case 8:
				c.setBounds(x,310,150 ,20);
				break;
			case 9:
				c.setBounds(x,310,100 ,20);
				break;
			case 10:
				c.setBounds(x,360,150 ,20);
				break;
			case 11:
				c.setBounds(x,360,150 ,20);
				break;
			case 12:
				c.setBounds(x,410,150 ,20);
				break;
			case 13:
				c.setBounds(x,410,150 ,20);
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

class con_Producto_EnColumnas2 implements LayoutManager{

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
					c.setBounds(370,55,120,30);
					break;
				case 5:
					c.setBounds(10, 120, 530, 350);
					break;
				case 6:
					c.setBounds(510,55,20,20);
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



