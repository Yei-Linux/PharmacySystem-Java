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
import Logica.Metodo_form_cliente;
import Logica.Metodo_form_trabajador;
import Logica.MiRender;

public class Form_Cliente extends JFrame{
	
	public Container contentPane=new Container();
	public Lamina_Form_Cliente lamina=new Lamina_Form_Cliente();
	public Lamina2_Form_Cliente lamina2=new Lamina2_Form_Cliente();
	
	public Form_Cliente(){
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
		
		lamina2.Mostrar("");
		lamina.Deshabilitar();
	}
	
	//PRIMERA LAMINA PARA REGISTRAR O EDITAR CLIENTES
	class Lamina_Form_Cliente extends JPanel{
		
		public String accion="Guardar";
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button nuevo=new Accion_Button("Nuevo",new ImageIcon("src/Files/nuevo.png"));
		public Accion_Button guardar=new Accion_Button("Guardar",new ImageIcon("src/Files/guardar.png"));
		public Accion_Button cancelar=new Accion_Button("Cancelar",new ImageIcon("src/Files/borrar.png"));
		
		public JLabel L_Titulo=new JLabel("REGISTRO CLIENTES");
		public JLabel L_Ap_Paterno=new JLabel("Ape_Paterno");
		public JLabel L_Ap_Materno=new JLabel("Ape_Materno");
		public JLabel L_Nombre=new JLabel("Nombre");
		public JLabel L_Ruc=new JLabel("Ruc");
		public JLabel L_Dni=new JLabel("Dni");
		public JLabel L_Genero=new JLabel("Genero");
		public JLabel L_Direcc=new JLabel("Direccion");
		public JLabel L_Distrito=new JLabel("Distrito");
		public JLabel L_Sede=new JLabel("Sede");
		public JLabel L_Celular=new JLabel("Celular");

		public JTextField id_Cliente=new JTextField(10);
		public JTextField Ap_paterno=new JTextField(10);
		public JTextField Ap_Materno=new JTextField(10);
		public JTextField Nom_Cli=new JTextField(10);
		public JTextField Ruc=new JTextField(10);
		public JTextField Dni=new JTextField(10);
		public JTextField Celular=new JTextField(10);
		public JTextField id_Sede=new JTextField(10);
		public JTextField id_Distrito=new JTextField(10);
		
		public JTextArea direccion=new JTextArea(5,5);
		public JScrollPane scroll_dir=new JScrollPane(direccion);
		
		public JComboBox Genero=new JComboBox();
		public JComboBox Distrito=new JComboBox();
		public JComboBox Sede=new JComboBox();
		
		public JButton bot_nuevo=new JButton(nuevo);
		public JButton bot_guardar=new JButton(guardar);
		public JButton bot_cancelar=new JButton(cancelar);
		
		public Lamina_Form_Cliente(){
			
			direccion.setLineWrap(true);
			
			Genero.addItem("H");
			Genero.addItem("M");
			
			Mostrar_Sede();
			Mostrar_Distrito();
			
			setLayout(new Cliente_EnColumnas1());
			
			L_Titulo.setForeground(new Color(0,230,64));
			L_Titulo.setFont(new Font("Jokerman",1,20));
			
			L_Ap_Paterno.setForeground(Color.WHITE);
			L_Ap_Paterno.setFont(new Font("Tahoma",1,15));
			
			L_Ap_Materno.setForeground(Color.WHITE);
			L_Ap_Materno.setFont(new Font("Tahoma",1,15));
			
			L_Nombre.setForeground(Color.WHITE);
			L_Nombre.setFont(new Font("Tahoma",1,15));
			
			L_Ruc.setForeground(Color.WHITE);
			L_Ruc.setFont(new Font("Tahoma",1,15));
			
			L_Dni.setForeground(Color.WHITE);
			L_Dni.setFont(new Font("Tahoma",1,15));
			
			L_Genero.setForeground(Color.WHITE);
			L_Genero.setFont(new Font("Tahoma",1,15));
			
			L_Direcc.setForeground(Color.WHITE);
			L_Direcc.setFont(new Font("Tahoma",1,15));
			
			L_Distrito.setForeground(Color.WHITE);
			L_Distrito.setFont(new Font("Tahoma",1,15));
			
			L_Sede.setForeground(Color.WHITE);
			L_Sede.setFont(new Font("Tahoma",1,15));
			
			L_Celular.setForeground(Color.WHITE);
			L_Celular.setFont(new Font("Tahoma",1,15));

			Ap_paterno.setBackground(new Color(103,128,159));
			Ap_paterno.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Ap_paterno.setForeground(Color.WHITE);
			Ap_paterno.setFont(new Font("Tahoma",1,15));
			
			Ap_Materno.setBackground(new Color(103,128,159));
			Ap_Materno.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Ap_Materno.setForeground(Color.WHITE);
			Ap_Materno.setFont(new Font("Tahoma",1,15));
			
			Nom_Cli.setBackground(new Color(103,128,159));
			Nom_Cli.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Nom_Cli.setForeground(Color.WHITE);
			Nom_Cli.setFont(new Font("Tahoma",1,15));
			
			direccion.setBackground(new Color(103,128,159));
			direccion.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			direccion.setForeground(Color.WHITE);
			direccion.setFont(new Font("Tahoma",1,15));
			
			Distrito.setBackground(new Color(103,128,159));
			Distrito.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Distrito.setForeground(Color.WHITE);
			Distrito.setFont(new Font("Tahoma",1,15));
			
			Sede.setBackground(new Color(103,128,159));
			Sede.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Sede.setForeground(Color.WHITE);
			Sede.setFont(new Font("Tahoma",1,15));
			
			Celular.setBackground(new Color(103,128,159));
			Celular.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Celular.setForeground(Color.WHITE);
			Celular.setFont(new Font("Tahoma",1,15));
			
			Ruc.setBackground(new Color(103,128,159));
			Ruc.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Ruc.setForeground(Color.WHITE);
			Ruc.setFont(new Font("Tahoma",1,15));
			
			Dni.setBackground(new Color(103,128,159));
			Dni.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Dni.setForeground(Color.WHITE);
			Dni.setFont(new Font("Tahoma",1,15));
			
			Genero.setBackground(new Color(103,128,159));
			Genero.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Genero.setForeground(Color.WHITE);
			Genero.setFont(new Font("Tahoma",1,15));
			
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
			add(id_Cliente);
			add(L_Ap_Paterno);
			add(Ap_paterno);
			add(L_Ap_Materno);
			add(Ap_Materno);
			add(L_Nombre);
			add(Nom_Cli);
			add(L_Ruc);
			add(Ruc);
			add(L_Dni);
			add(Dni);
			add(L_Genero);
			add(Genero);
			add(L_Direcc);
			add(scroll_dir);
			add(L_Distrito);
			add(Distrito);
			add(L_Sede);
			add(Sede);
			add(L_Celular);
			add(Celular);
			
			add(bot_nuevo);
			add(bot_guardar);
			add(bot_cancelar);
			
			add(id_Distrito);
			add(id_Sede);
			
			Sede.addActionListener(new Evento_Combo());
			Distrito.addActionListener(new Evento_Combo());
			
		}
		
		public void Mostrar_Sede(){
			try{
				
				Metodo_form_trabajador metodo=new Metodo_form_trabajador();
				
				Sede=metodo.Combo_Sede();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
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
				
				if(e.getSource()==Sede){
					
					Metodo_form_trabajador metod=new Metodo_form_trabajador();
					
					id_Sede.setText(String.valueOf(metod.Id_Sede((String)Sede.getSelectedItem())));
				}
				
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
					
					Datos_Cliente dts=new Datos_Cliente();
					Metodo_form_cliente metod=new Metodo_form_cliente();
					
					dts.Set_ap_materno(Ap_Materno.getText());
					dts.Set_ap_paterno(Ap_paterno.getText());
					dts.Set_Nombre_cli(Nom_Cli.getText());
					dts.Set_Ruc(Ruc.getText());
					dts.Set_Dni(Dni.getText());
					dts.Set_Direccion(direccion.getText());
					dts.Set_Cel(Celular.getText());
					
					int seleccionado=Genero.getSelectedIndex();
					dts.Set_Genero((String) Genero.getItemAt(seleccionado));

					dts.Set_Cod_Distrito(Integer.parseInt(id_Distrito.getText()));

					dts.Set_Cod_Sede(Integer.parseInt(id_Sede.getText()));
					
					if(accion.equalsIgnoreCase("Guardar")){
						if(metod.Insertar(dts)){
							JOptionPane.showMessageDialog(null,"El cliente fue registrado correctamente");
							lamina2.Mostrar("");
							Deshabilitar();
						}
					}else{
						if(accion.equalsIgnoreCase("Editar")){
							dts.Set_Cod_Cliente(Integer.parseInt(id_Cliente.getText()));
							lamina2.Mostrar("");
							
							if(metod.Editar(dts)){
								JOptionPane.showMessageDialog(null,"El cliente fue editado correctamente");
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
			id_Sede.setVisible(false);
			id_Cliente.setVisible(false);
			Ap_paterno.setEnabled(true);
			Ap_Materno.setEnabled(true);
			Nom_Cli.setEnabled(true);
			Ruc.setEnabled(true);
			Dni.setEnabled(true);
			Genero.setEnabled(true);
			direccion.setEnabled(true);
			Distrito.setEnabled(true);
			Sede.setEnabled(true);
			Celular.setEnabled(true);
			
			bot_guardar.setEnabled(true);
			bot_cancelar.setEnabled(true);
			
			id_Cliente.setText("");
			Ap_paterno.setText("");
			Ap_Materno.setText("");
			Nom_Cli.setText("");
			Ruc.setText("");
			Dni.setText("");
			direccion.setText("");
			Celular.setText("");
			id_Sede.setText("");
			id_Distrito.setText("");
		}
		
		public void Deshabilitar(){
			id_Distrito.setVisible(false);
			id_Sede.setVisible(false);
			id_Cliente.setVisible(false);
			Ap_paterno.setEnabled(false);
			Ap_Materno.setEnabled(false);
			Nom_Cli.setEnabled(false);
			Ruc.setEnabled(false);
			Dni.setEnabled(false);
			Genero.setEnabled(false);
			direccion.setEnabled(false);
			Distrito.setEnabled(false);
			Sede.setEnabled(false);
			Celular.setEnabled(false);
			
			bot_guardar.setEnabled(false);
			bot_cancelar.setEnabled(false);
			
			id_Cliente.setText("");
			Ap_paterno.setText("");
			Ap_Materno.setText("");
			Nom_Cli.setText("");
			Ruc.setText("");
			Dni.setText("");
			direccion.setText("");
			Celular.setText("");
			id_Sede.setText("");
			id_Distrito.setText("");
		}
	}
	
	//SEGUNDA LAMINA PARA MOSTRAR LA TABLA DE CLIENTES
	class Lamina2_Form_Cliente extends JPanel{
		
		public JTable tabla;
		public DefaultTableModel modelo;
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button2 buscar=new Accion_Button2("Buscar",new ImageIcon("src/Files/buscar.png"));
		public Accion_Button2 eliminar=new Accion_Button2("Eliminar",new ImageIcon("src/Files/eliminar.png"));
		
		public JLabel L_Titulo2=new JLabel ("LISTADO DE CLIENTES");
		public JLabel L_Buscar=new JLabel("Buscar: ");
		public JTextField Cliente=new JTextField(10);
		
		public JButton bot_buscar=new JButton(buscar);
		public JButton bot_eliminar=new JButton(eliminar);

	
		public Lamina2_Form_Cliente(){
			setLayout(new Cliente_EnColumnas2());
			
			L_Titulo2.setForeground(new Color(0,230,64));
			L_Titulo2.setFont(new Font("Jokerman",1,20));
			
			L_Buscar.setForeground(Color.WHITE);
			L_Buscar.setFont(new Font("Tahoma",1,15));
			
			Cliente.setBackground(new Color(103,128,159));
			Cliente.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Cliente.setForeground(Color.WHITE);
			Cliente.setFont(new Font("Tahoma",1,15));
			
			bot_buscar.setBackground(new Color(0,230,64));
			bot_buscar.setForeground(Color.WHITE);
			bot_buscar.setFont(new Font("Tahoma",1,12));
			
			bot_eliminar.setBackground(new Color(3,201,169));
			bot_eliminar.setForeground(Color.WHITE);
			bot_eliminar.setFont(new Font("Tahoma",1,12));
			
			add(L_Titulo2);
			add(L_Buscar);
			add(Cliente);
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
				
				Metodo_form_cliente metodo=new Metodo_form_cliente();
				modelo=metodo.Mostrar(buscar);				
				
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
				
				lamina.id_Cliente.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Ap_Materno.setText(tabla.getValueAt(fila,1).toString());
				lamina.Ap_paterno.setText(tabla.getValueAt(fila, 2).toString());
				lamina.Nom_Cli.setText(tabla.getValueAt(fila, 3).toString());
				lamina.Ruc.setText(tabla.getValueAt(fila, 4).toString());
				lamina.Dni.setText(tabla.getValueAt(fila, 5).toString());
				lamina.Genero.setSelectedItem(tabla.getValueAt(fila, 6).toString());
				lamina.direccion.setText(tabla.getValueAt(fila, 7).toString());
				lamina.Celular.setText(tabla.getValueAt(fila, 8).toString());
				lamina.Distrito.setSelectedItem(tabla.getValueAt(fila, 9).toString());
				lamina.Sede.setSelectedItem(tabla.getValueAt(fila,10).toString());
				
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
					if(!lamina.id_Cliente.getText().equalsIgnoreCase("")){
						int confirmacion=JOptionPane.showConfirmDialog(null,"�Estas seguro que deseas eliminar este cliente?","Confirmacion",2);
						
						if(confirmacion==0){
							Metodo_form_cliente metod=new Metodo_form_cliente();
							Datos_Cliente dts=new Datos_Cliente();
							
							dts.Set_Cod_Cliente(Integer.parseInt(lamina.id_Cliente.getText()));
							if(metod.Eliminar(dts)){
								JOptionPane.showMessageDialog(null, "El cliente fue eliminado correctamente");
								Mostrar("");
								lamina.Deshabilitar();
							}
						}
					}
				}
				
				if(e.getSource()==bot_buscar){
					Mostrar(Cliente.getText());
				}
			}
			
		}
	}
}

class Cliente_EnColumnas1 implements LayoutManager{
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
				c.setBounds(x,60,200 ,20);
				break;
			case 3:
				c.setBounds(x,60,150 ,20);
				break;
			case 4:
				c.setBounds(x,90,200 ,20);
				break;
			case 5:
				c.setBounds(x,90,150 ,20);
				break;
			case 6:
				c.setBounds(x,120,200 ,20);
				break;
			case 7:
				c.setBounds(x,120,150 ,20);
				break;
			case 8:
				c.setBounds(x,150,200 ,20);
				break;
			case 9:
				c.setBounds(x,150,150 ,20);
				break;
			case 10:
				c.setBounds(x,180,100 ,20);
				break;
			case 11:
				c.setBounds(x,180,100 ,20);
				break;
			case 12:
				c.setBounds(x,210,100 ,20);
				break;
			case 13:
				c.setBounds(x,210,100 ,20);
				break;
			case 14:
				c.setBounds(x,240,100 ,20);
				break;
			case 15:
				c.setBounds(x,240,250 ,50);
				break;
			case 16:
				c.setBounds(x,300,100 ,20);
				break;
			case 17:
				c.setBounds(x,300,200 ,20);
				break;
			case 18:
				c.setBounds(x,330,100 ,20);
				break;
			case 19:
				c.setBounds(x,330,200 ,20);
				break;
			case 20:
				c.setBounds(x,360,100 ,20);
				break;
			case 21:
				c.setBounds(x,360,100 ,20);
				break;
				
			case 22:
				c.setBounds(x,460,120,30);
				break;
			case 23:
				c.setBounds(230,460,120,30);
				break;
			case 24:
				c.setBounds(400,460,120,30);
				break;
				
			case 25:
				c.setBounds(450,300,20 ,20);
				break;
			case 26:
				c.setBounds(450,330,20 ,20);
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

class Cliente_EnColumnas2 implements LayoutManager{

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
