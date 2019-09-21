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

import Datos.Datos_Producto;
import Datos.Datos_Proveedor;
import Logica.Metodo_form_Producto2;
import Logica.Metodo_form_Proveedor2;
import Logica.Metodo_form_trabajador;
import Logica.MiRender;
import Presentacion.Form_Producto.Lamina2_Form_Producto;
import Presentacion.Form_Producto.Lamina_Form_Producto;

public class Form_Proveedor extends JFrame{
	public Container contentPane=new Container();
	public Lamina_Form_Proveedor lamina=new Lamina_Form_Proveedor();
	public Lamina2_Form_Proveedor lamina2=new Lamina2_Form_Proveedor();
	
	public Form_Proveedor(){
		setTitle("PROVEEDOR");
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
	class Lamina_Form_Proveedor extends JPanel{
		
		public String accion="Guardar";
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button nuevo=new Accion_Button("Nuevo",new ImageIcon("src/Files/nuevo.png"));
		public Accion_Button guardar=new Accion_Button("Guardar",new ImageIcon("src/Files/guardar.png"));
		public Accion_Button cancelar=new Accion_Button("Cancelar",new ImageIcon("src/Files/borrar.png"));
		
		public JLabel L_Titulo=new JLabel("REGISTRO PROVEEDOR");
		public JLabel L_Nom_Proveedor=new JLabel("Proveedor");
		public JLabel L_Direccion=new JLabel("Direccion");
		public JLabel L_Celular=new JLabel("Celular");
		public JLabel L_Distrito=new JLabel("Distrito");

		public JTextField id_Proveedor=new JTextField(10);
		public JTextField Nom_Proveedor=new JTextField(10);
		public JTextField Celular=new JTextField(10);
		public JTextField id_Distrito=new JTextField(10);
		
		public JComboBox Distrito=new JComboBox();
		
		public JTextArea Direccion=new JTextArea();
		public JScrollPane sc_dir=new JScrollPane(Direccion);
		
		public JButton bot_nuevo=new JButton(nuevo);
		public JButton bot_guardar=new JButton(guardar);
		public JButton bot_cancelar=new JButton(cancelar);
		
		public Lamina_Form_Proveedor(){
			
			Direccion.setLineWrap(true);
			
			Mostrar_Distrito();
			
			setLayout(new Proveedor_EnColumnas1());
			
			L_Titulo.setForeground(new Color(0,230,64));
			L_Titulo.setFont(new Font("Jokerman",1,20));
			
			L_Nom_Proveedor.setForeground(Color.WHITE);
			L_Nom_Proveedor.setFont(new Font("Tahoma",1,15));
			
			L_Direccion.setForeground(Color.WHITE);
			L_Direccion.setFont(new Font("Tahoma",1,15));
			
			L_Celular.setForeground(Color.WHITE);
			L_Celular.setFont(new Font("Tahoma",1,15));
			
			L_Distrito.setForeground(Color.WHITE);
			L_Distrito.setFont(new Font("Tahoma",1,15));
			
			Nom_Proveedor.setBackground(new Color(103,128,159));
			Nom_Proveedor.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Nom_Proveedor.setForeground(Color.WHITE);
			Nom_Proveedor.setFont(new Font("Tahoma",1,15));
			
			Celular.setBackground(new Color(103,128,159));
			Celular.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Celular.setForeground(Color.WHITE);
			Celular.setFont(new Font("Tahoma",1,15));
			
			Distrito.setBackground(new Color(103,128,159));
			Distrito.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Distrito.setForeground(Color.WHITE);
			Distrito.setFont(new Font("Tahoma",1,15));
			
			Direccion.setBackground(new Color(103,128,159));
			Direccion.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Direccion.setForeground(Color.WHITE);
			Direccion.setFont(new Font("Tahoma",1,15));
			
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
			add(id_Proveedor);
			add(L_Nom_Proveedor);
			add(Nom_Proveedor);
			add(L_Direccion);
			add(sc_dir);
			add(L_Celular);
			add(Celular);
			add(L_Distrito);
			add(Distrito);

			add(bot_nuevo);
			add(bot_guardar);
			add(bot_cancelar);
			
			add(id_Distrito);
			
			Distrito.addActionListener(new Evento_Combo());
		}
		
		public void Mostrar_Distrito(){
			try{
				
				Metodo_form_trabajador metodo=new Metodo_form_trabajador();
				
				Distrito=metodo.Combo_Distrito();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		private class Evento_Combo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==Distrito){
					
					Metodo_form_trabajador metod=new Metodo_form_trabajador();
					
					id_Distrito.setText(String.valueOf(metod.Id_Distrito((String)Distrito.getSelectedItem())));
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
					
					Datos_Proveedor dts=new Datos_Proveedor();
					Metodo_form_Proveedor2 metod=new Metodo_form_Proveedor2();
					
					dts.Set_Nom_Proveedor(Nom_Proveedor.getText());
					dts.Set_Direccion(Direccion.getText());
					dts.Set_Cel(Celular.getText());
					
					dts.Set_Id_Distrito((Integer.parseInt(id_Distrito.getText())));
					
					if(accion.equalsIgnoreCase("Guardar")){
						if(metod.Insertar(dts)){
							JOptionPane.showMessageDialog(null,"El proveedor fue registrado correctamente");
							lamina2.Mostrar("");
							Deshabilitar();
						}
					}else{
						if(accion.equalsIgnoreCase("Editar")){
							dts.Set_Id_Proveedor(Integer.parseInt(id_Proveedor.getText()));
							lamina2.Mostrar("");
							
							if(metod.Editar(dts)){
								JOptionPane.showMessageDialog(null,"El proveedor fue editado correctamente");
								lamina2.Mostrar("");
								Deshabilitar();
							}
							
						}
						
					}
				}
				
			}
		}
		
		public void Habilitar(){
			id_Distrito.setVisible(false);
			id_Proveedor.setVisible(false);
			Nom_Proveedor.setEnabled(true);
			Direccion.setEnabled(true);
			Celular.setEnabled(true);
			Distrito.setEnabled(true);
			
			bot_guardar.setEnabled(true);
			bot_cancelar.setEnabled(true);
			
			id_Proveedor.setText("");
			Nom_Proveedor.setText("");
			Direccion.setText("");
			Celular.setText("");
			id_Distrito.setText("");
		}
		
		public void Deshabilitar(){
			id_Distrito.setVisible(false);
			id_Proveedor.setVisible(false);
			Nom_Proveedor.setEnabled(false);
			Direccion.setEnabled(false);
			Celular.setEnabled(false);
			Distrito.setEnabled(false);
			
			bot_guardar.setEnabled(false);
			bot_cancelar.setEnabled(false);
			
			id_Proveedor.setText("");
			Nom_Proveedor.setText("");
			Direccion.setText("");
			Celular.setText("");
			id_Distrito.setText("");
		}
	}
	
	//SEGUNDA LAMINA PARA MOSTRAR LA TABLA DE CLIENTES
	class Lamina2_Form_Proveedor extends JPanel{
		
		public JTable tabla;
		public DefaultTableModel modelo;
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button2 buscar=new Accion_Button2("Buscar",new ImageIcon("src/Files/buscar.png"));
		public Accion_Button2 eliminar=new Accion_Button2("Eliminar",new ImageIcon("src/Files/eliminar.png"));
		
		public JLabel L_Titulo2=new JLabel ("LISTADO DE PROVEEDORES");
		public JLabel L_Buscar=new JLabel("Buscar: ");
		public JTextField Proveedor=new JTextField(10);
		
		public JButton bot_buscar=new JButton(buscar);
		public JButton bot_eliminar=new JButton(eliminar);

	
		public Lamina2_Form_Proveedor(){
			setLayout(new Proveedor_EnColumnas2());
			
			L_Titulo2.setForeground(new Color(0,230,64));
			L_Titulo2.setFont(new Font("Jokerman",1,20));
			
			L_Buscar.setForeground(Color.WHITE);
			L_Buscar.setFont(new Font("Tahoma",1,15));
			
			Proveedor.setBackground(new Color(103,128,159));
			Proveedor.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Proveedor.setForeground(Color.WHITE);
			Proveedor.setFont(new Font("Tahoma",1,15));
			
			bot_buscar.setBackground(new Color(0,230,64));
			bot_buscar.setForeground(Color.WHITE);
			bot_buscar.setFont(new Font("Tahoma",1,12));
			
			bot_eliminar.setBackground(new Color(3,201,169));
			bot_eliminar.setForeground(Color.WHITE);
			bot_eliminar.setFont(new Font("Tahoma",1,12));
			
			add(L_Titulo2);
			add(L_Buscar);
			add(Proveedor);
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
				
				Metodo_form_Proveedor2 metodo=new Metodo_form_Proveedor2();
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
				
				lamina.id_Proveedor.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Nom_Proveedor.setText(tabla.getValueAt(fila,1).toString());
				lamina.Direccion.setText(tabla.getValueAt(fila, 2).toString());
				lamina.Celular.setText(tabla.getValueAt(fila, 3).toString());
				lamina.Distrito.setSelectedItem(tabla.getValueAt(fila, 4).toString());

				
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
					
					if(!lamina.id_Proveedor.getText().equalsIgnoreCase("")){
						int confirmacion=JOptionPane.showConfirmDialog(null,"¿Estas seguro que deseas eliminar este Proveedor?","Confirmacion",2);
						
						if(confirmacion==0){
							Metodo_form_Proveedor2 metod=new Metodo_form_Proveedor2();
							Datos_Proveedor dts=new Datos_Proveedor();
							
							dts.Set_Id_Proveedor(Integer.parseInt(lamina.id_Proveedor.getText()));
							if(metod.Eliminar(dts)){
								JOptionPane.showMessageDialog(null, "El Proveedor fue eliminado correctamente");
								Mostrar("");
								lamina.Deshabilitar();
							}
						}
					}
				}
				
				if(e.getSource()==bot_buscar){
					Mostrar(Proveedor.getText());
				}
			}
			
		}
	}
}

class Proveedor_EnColumnas1 implements LayoutManager{
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
				c.setBounds(x,30,150 ,20);
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
				c.setBounds(x,140,250 ,70);
				break;
			case 6:
				c.setBounds(x,230,150 ,20);
				break;
			case 7:
				c.setBounds(x,230,150 ,20);
				break;
			case 8:
				c.setBounds(x,260,150 ,20);
				break;
			case 9:
				c.setBounds(x,260,200 ,20);
				break;
				
			case 10:
				c.setBounds(x,380,120 ,30);
				break;	
			case 11:
				c.setBounds(230,380,120,30);
				break;	
			case 12:
				c.setBounds(400,380,120,30);
				break;
				
			case 13:
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

class Proveedor_EnColumnas2 implements LayoutManager{

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
