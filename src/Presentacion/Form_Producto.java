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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Cliente;
import Datos.Datos_Producto;
import Logica.Metodo_form_Producto;
import Logica.Metodo_form_Producto2;
import Logica.Metodo_form_cliente;
import Logica.Metodo_form_trabajador;
import Logica.MiRender;
import Presentacion.Form_Cliente.Lamina2_Form_Cliente;
import Presentacion.Form_Cliente.Lamina_Form_Cliente;



public class Form_Producto extends JFrame{
	public Container contentPane=new Container();
	public Lamina_Form_Producto lamina=new Lamina_Form_Producto();
	public Lamina2_Form_Producto lamina2=new Lamina2_Form_Producto();
	
	public Form_Producto(){
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
		
		lamina2.Mostrar("");
		lamina.Deshabilitar();
	}
	
	//PRIMERA LAMINA PARA REGISTRAR O EDITAR CLIENTES
	class Lamina_Form_Producto extends JPanel{
		
		public String accion="Guardar";
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button nuevo=new Accion_Button("Nuevo",new ImageIcon("src/Files/nuevo.png"));
		public Accion_Button guardar=new Accion_Button("Guardar",new ImageIcon("src/Files/guardar.png"));
		public Accion_Button cancelar=new Accion_Button("Cancelar",new ImageIcon("src/Files/borrar.png"));
		
		public JLabel L_Titulo=new JLabel("REGISTRO PRODUCTOS");
		public JLabel L_Nom_Producto=new JLabel("Producto");
		public JLabel L_Precio=new JLabel("Precio");
		public JLabel L_Proveedor=new JLabel("Proveedor");
		public JLabel L_Categoria=new JLabel("Categoria");
		public JLabel L_Igv=new JLabel("Igv");
		public JLabel L_Sede=new JLabel("Sede");

		public JTextField id_Producto=new JTextField(10);
		public JTextField Nom_Producto=new JTextField(10);
		public JTextField Precio=new JTextField(10);
		public JTextField Igv=new JTextField(10);
		public JTextField id_Sede=new JTextField(10);
		public JTextField id_Proveedor=new JTextField(10);
		public JTextField id_Categoria=new JTextField(10);
		
		public JComboBox Sede=new JComboBox();
		public JComboBox Proveedor=new JComboBox();
		public JComboBox Categoria=new JComboBox();
		
		public JButton bot_nuevo=new JButton(nuevo);
		public JButton bot_guardar=new JButton(guardar);
		public JButton bot_cancelar=new JButton(cancelar);
		
		public Lamina_Form_Producto(){
			
			setLayout(new Producto_EnColumnas1());
			
			Mostrar_Sede();
			Mostrar_Proveedor();
			Mostrar_Categoria();
			
			L_Titulo.setForeground(new Color(0,230,64));
			L_Titulo.setFont(new Font("Jokerman",1,20));
			
			L_Nom_Producto.setForeground(Color.WHITE);
			L_Nom_Producto.setFont(new Font("Tahoma",1,15));
			
			L_Precio.setForeground(Color.WHITE);
			L_Precio.setFont(new Font("Tahoma",1,15));
			
			L_Proveedor.setForeground(Color.WHITE);
			L_Proveedor.setFont(new Font("Tahoma",1,15));
			
			L_Categoria.setForeground(Color.WHITE);
			L_Categoria.setFont(new Font("Tahoma",1,15));
			
			L_Igv.setForeground(Color.WHITE);
			L_Igv.setFont(new Font("Tahoma",1,15));
			
			L_Sede.setForeground(Color.WHITE);
			L_Sede.setFont(new Font("Tahoma",1,15));
			
			Nom_Producto.setBackground(new Color(103,128,159));
			Nom_Producto.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Nom_Producto.setForeground(Color.WHITE);
			Nom_Producto.setFont(new Font("Tahoma",1,15));
			
			Precio.setBackground(new Color(103,128,159));
			Precio.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Precio.setForeground(Color.WHITE);
			Precio.setFont(new Font("Tahoma",1,15));
			
			Igv.setBackground(new Color(103,128,159));
			Igv.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Igv.setForeground(Color.WHITE);
			Igv.setFont(new Font("Tahoma",1,15));
			
			Categoria.setBackground(new Color(103,128,159));
			Categoria.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Categoria.setForeground(Color.WHITE);
			Categoria.setFont(new Font("Tahoma",1,15));
			
			Proveedor.setBackground(new Color(103,128,159));
			Proveedor.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Proveedor.setForeground(Color.WHITE);
			Proveedor.setFont(new Font("Tahoma",1,15));
			
			Sede.setBackground(new Color(103,128,159));
			Sede.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Sede.setForeground(Color.WHITE);
			Sede.setFont(new Font("Tahoma",1,15));
			
			bot_nuevo.setBackground(new Color(0,230,64));
			bot_nuevo.setForeground(Color.WHITE);
			bot_nuevo.setFont(new Font("Tahoma",1,12));
			
			bot_guardar.setBackground(new Color(3,201,169));
			bot_guardar.setForeground(Color.WHITE);
			bot_guardar.setFont(new Font("Tahoma",1,12));
			
			bot_cancelar.setBackground(new Color(242,38,19));
			bot_cancelar.setForeground(Color.WHITE);
			bot_cancelar.setFont(new Font("Tahoma",1,12));
			
			add(L_Titulo);
			add(id_Producto);
			add(L_Nom_Producto);
			add(Nom_Producto);
			add(L_Precio);
			add(Precio);
			add(L_Proveedor);
			add(Proveedor);
			add(L_Categoria);
			add(Categoria);
			add(L_Igv);
			add(Igv);
			add(L_Sede);
			add(Sede);
			
			add(bot_nuevo);
			add(bot_guardar);
			add(bot_cancelar);
			
			add(id_Proveedor);
			add(id_Categoria);
			add(id_Sede);
			
			Sede.addActionListener(new Evento_Combo());
			Proveedor.addActionListener(new Evento_Combo());
			Categoria.addActionListener(new Evento_Combo());
		}
		
		public void Mostrar_Sede(){
			try{
				
				Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
				
				Sede=metodo.Combo_Sede();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		public void Mostrar_Proveedor(){
			try{
				
				Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
				
				Proveedor=metodo.Combo_Proveedor();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		public void Mostrar_Categoria(){
			try{
				
				Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
				
				Categoria=metodo.Combo_Categoria();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		private class Evento_Combo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==Sede){
					
					Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
					
					id_Sede.setText(String.valueOf(metodo.Id_Sede((String)Sede.getSelectedItem())));
				}
				
				if(e.getSource()==Proveedor){
					
					Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
					
					id_Proveedor.setText(String.valueOf(metodo.Id_Proveedor((String)Proveedor.getSelectedItem())));
				}
				
				if(e.getSource()==Categoria){
					
					Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
					
					id_Categoria.setText(String.valueOf(metodo.Id_Categoria((String)Categoria.getSelectedItem())));
				}
				
			}
			
		}
		
		private class Accion_Button extends AbstractAction{
			public Accion_Button(String nombre,Icon icono){
				putValue(Action.NAME,nombre);
				putValue(Action.SMALL_ICON,icono);
				putValue(Action.SHORT_DESCRIPTION,"Haga click para " + nombre);
			}

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bot_nuevo){
					Habilitar();
					bot_guardar.setText("Guardar");
					accion="Guardar";
					
				}
				if(e.getSource()==bot_guardar){
					
					Datos_Producto dts=new Datos_Producto();
					Metodo_form_Producto2 metod=new Metodo_form_Producto2();
					
					dts.Set_Nom_Producto(Nom_Producto.getText());
					dts.Set_Precio(Double.parseDouble(Precio.getText()));
					dts.Set_igv(Double.parseDouble(Igv.getText()));

					dts.Set_id_Proveedor(Integer.parseInt(id_Proveedor.getText()));

					dts.Set_id_Categoria(Integer.parseInt(id_Categoria.getText()));

					dts.Set_id_Almacen(Integer.parseInt(id_Sede.getText()));
					
					if(accion.equalsIgnoreCase("Guardar")){
						if(metod.Insertar(dts)){
							JOptionPane.showMessageDialog(null,"El producto fue registrado correctamente");
							lamina2.Mostrar("");
							Deshabilitar();
						}
					}else{
						if(accion.equalsIgnoreCase("Editar")){
							dts.Set_id_Producto(Integer.parseInt(id_Producto.getText()));
							lamina2.Mostrar("");
							
							if(metod.Editar(dts)){
								JOptionPane.showMessageDialog(null,"El producto fue editado correctamente");
								lamina2.Mostrar("");
								Deshabilitar();
							}
							
						}
						
					}
				}
				
			}
		}
		
		public void Habilitar(){
			id_Sede.setVisible(false);
			id_Proveedor.setVisible(false);
			id_Categoria.setVisible(false);
			id_Producto.setVisible(false);
			Nom_Producto.setEnabled(true);
			Precio.setEnabled(true);
			Proveedor.setEnabled(true);
			Categoria.setEnabled(true);
			Igv.setEnabled(true);
			
			bot_guardar.setEnabled(true);
			bot_cancelar.setEnabled(true);
			
			id_Producto.setText("");
			Nom_Producto.setText("");
			Precio.setText("");
			Igv.setText("");
			id_Sede.setText("");
			id_Proveedor.setText("");
			id_Categoria.setText("");
			
		}
		
		public void Deshabilitar(){
			
			id_Sede.setVisible(false);
			id_Proveedor.setVisible(false);
			id_Categoria.setVisible(false);
			id_Producto.setVisible(false);
			Nom_Producto.setEnabled(false);
			Precio.setEnabled(false);
			Proveedor.setEnabled(false);
			Categoria.setEnabled(false);
			Igv.setEnabled(false);
			
			bot_guardar.setEnabled(false);
			bot_cancelar.setEnabled(false);
			
			id_Producto.setText("");
			Nom_Producto.setText("");
			Precio.setText("");
			Igv.setText("");
			id_Sede.setText("");
			id_Proveedor.setText("");
			id_Categoria.setText("");
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
		public JButton bot_eliminar=new JButton(eliminar);
	
		public Lamina2_Form_Producto(){
			setLayout(new Producto_EnColumnas2());
			
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
			
			bot_eliminar.setBackground(new Color(3,201,169));
			bot_eliminar.setForeground(Color.WHITE);
			bot_eliminar.setFont(new Font("Tahoma",1,12));
			
			add(L_Titulo2);
			add(L_Buscar);
			add(Producto);
			add(bot_buscar);
			add(bot_eliminar);
			setTable();
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
		
		public void Mostrar (String buscar){
			try{
				DefaultTableModel modelo;
				
				Metodo_form_Producto2 metodo=new Metodo_form_Producto2();
				modelo=metodo.mostrar(buscar);				
				
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
				
				lamina.bot_guardar.setText("Editar");
				lamina.Habilitar();
				lamina.accion="Editar";
				
				int fila=tabla.rowAtPoint(e.getPoint());
				
				lamina.id_Producto.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Nom_Producto.setText(tabla.getValueAt(fila,1).toString());
				lamina.Precio.setText(tabla.getValueAt(fila, 2).toString());
				lamina.Igv.setText(tabla.getValueAt(fila, 3).toString());
				lamina.Proveedor.setSelectedItem(tabla.getValueAt(fila, 4).toString());
				lamina.Categoria.setSelectedItem(tabla.getValueAt(fila, 5).toString());
				lamina.Sede.setSelectedItem(tabla.getValueAt(fila, 6).toString());
				
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
				
				if(e.getSource()==bot_eliminar){
					
					if(!lamina.id_Producto.getText().equalsIgnoreCase("")){
						int confirmacion=JOptionPane.showConfirmDialog(null,"¿Estas seguro que deseas eliminar este Producto?","Confirmacion",2);
						
						if(confirmacion==0){
							Metodo_form_Producto2 metod=new Metodo_form_Producto2();
							Datos_Producto dts=new Datos_Producto();
							
							dts.Set_id_Producto(Integer.parseInt(lamina.id_Producto.getText()));
							if(metod.Eliminar(dts)){
								JOptionPane.showMessageDialog(null, "El Producto fue eliminado correctamente");
								Mostrar("");
								lamina.Deshabilitar();
							}
						}
					}
				}
				
				if(e.getSource()==bot_buscar){
					Mostrar(Producto.getText());
				}
			}
			
		}
	}
}

class Producto_EnColumnas1 implements LayoutManager{
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
				c.setBounds(10,10,300 ,30);
				break;
			case 1:
				c.setBounds(x,30,100 ,20);
				break;
			case 2:
				c.setBounds(x,110,150 ,20);
				break;
			case 3:
				c.setBounds(x,110,150 ,20);
				break;
			case 4:
				c.setBounds(x,140,150 ,20);
				break;
			case 5:
				c.setBounds(x,140,150 ,20);
				break;
			case 6:
				c.setBounds(x,170,150 ,20);
				break;
			case 7:
				c.setBounds(x,170,200 ,20);
				break;
			case 8:
				c.setBounds(x,200,150 ,20);
				break;
			case 9:
				c.setBounds(x,200,200 ,20);
				break;
			case 10:
				c.setBounds(x,230,150 ,20);
				break;
			case 11:
				c.setBounds(x,230,150 ,20);
				break;
			case 12:
				c.setBounds(x,260,150 ,20);
				break;
			case 13:
				c.setBounds(x,260,200 ,20);
				break;
				
			case 14:
				c.setBounds(x,380,120 ,30);
				break;	
			case 15:
				c.setBounds(230,380,120,30);
				break;	
			case 16:
				c.setBounds(400,380,120,30);
				break;
				
			case 17:
				c.setBounds(470,170,20 ,20);
				break;
			case 18:
				c.setBounds(470,200,20 ,20);
				break;
			case 19:
				c.setBounds(470,260,20 ,20);
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

class Producto_EnColumnas2 implements LayoutManager{

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


