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

import Datos.Datos_Trabajador;
import Logica.Metodo_Consulta_Empleado;
import Logica.Metodo_form_trabajador;
import Logica.MiRender;
import Presentacion.Form_Trabajador.Lamina2_Form_Trabajador;
import Presentacion.Form_Trabajador.Lamina_Form_Trabajador;

public class Consulta_Empleado extends JFrame{
	public Container contentPane=new Container();
	public Lamina_Form_Trabajador lamina=new Lamina_Form_Trabajador();
	public Lamina2_Form_Trabajador lamina2=new Lamina2_Form_Trabajador();
	
	public Consulta_Empleado(){
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
		
		lamina2.Mostrar("",(String)lamina2.sede.getItemAt(lamina2.sede.getSelectedIndex()));
		lamina.Deshabilitar();
	}
	
	//PRIMERA LAMINA PARA REGISTRAR O EDITAR CLIENTES
	class Lamina_Form_Trabajador extends JPanel{
		
		public String accion="Guardar";
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public JLabel L_Titulo=new JLabel("EMPLEADO");
		public JLabel L_Ap_Paterno=new JLabel("Ape_Paterno");
		public JLabel L_Ap_Materno=new JLabel("Ape_Materno");
		public JLabel L_Nombre=new JLabel("Nombre");
		public JLabel L_Direcc=new JLabel("Direccion");
		public JLabel L_Distrito=new JLabel("Distrito");
		public JLabel L_Sede=new JLabel("Sede");
		public JLabel L_Celular=new JLabel("Celular");
		public JLabel L_Fec_Nac=new JLabel("Fec_Nac");
		public JLabel L_Usuario=new JLabel("Usuario");
		public JLabel L_Pass=new JLabel("Password");
		public JLabel L_Tipo_Usuario=new JLabel("Tipo User");
		

		public JLabel id_Trabajador=new JLabel("");
		public JLabel Ap_paterno=new JLabel("");
		public JLabel Ap_Materno=new JLabel("");
		public JLabel Nom_Emp=new JLabel("");
		public JLabel Celular=new JLabel("");
		public JLabel Fec_Nac=new JLabel("");
		public JLabel Usuario=new JLabel("");
		public JLabel Pass=new JLabel("");
		
		public JLabel direccion=new JLabel("");

		
		public JLabel Distrito=new JLabel("");
		public JLabel Sede=new JLabel("");
		public JLabel Tipo_User=new JLabel("");
		
		public Lamina_Form_Trabajador(){
			
			setLayout(new con_Trabajador_EnColumnas1());
			
			L_Titulo.setForeground(new Color(0,230,64));
			L_Titulo.setFont(new Font("Jokerman",1,20));
			
			L_Ap_Paterno.setForeground(Color.WHITE);
			L_Ap_Paterno.setFont(new Font("Tahoma",1,15));
			
			L_Ap_Materno.setForeground(Color.WHITE);
			L_Ap_Materno.setFont(new Font("Tahoma",1,15));
			
			L_Nombre.setForeground(Color.WHITE);
			L_Nombre.setFont(new Font("Tahoma",1,15));
			
			L_Direcc.setForeground(Color.WHITE);
			L_Direcc.setFont(new Font("Tahoma",1,15));
			
			L_Distrito.setForeground(Color.WHITE);
			L_Distrito.setFont(new Font("Tahoma",1,15));
			
			L_Sede.setForeground(Color.WHITE);
			L_Sede.setFont(new Font("Tahoma",1,15));
			
			L_Celular.setForeground(Color.WHITE);
			L_Celular.setFont(new Font("Tahoma",1,15));
			
			L_Fec_Nac.setForeground(Color.WHITE);
			L_Fec_Nac.setFont(new Font("Tahoma",1,15));
			
			L_Usuario.setForeground(Color.WHITE);
			L_Usuario.setFont(new Font("Tahoma",1,15));
			
			L_Pass.setForeground(Color.WHITE);
			L_Pass.setFont(new Font("Tahoma",1,15));
			
			L_Tipo_Usuario.setForeground(Color.WHITE);
			L_Tipo_Usuario.setFont(new Font("Tahoma",1,15));
			
			Ap_paterno.setForeground(Color.BLACK);
			Ap_paterno.setFont(new Font("Tahoma",1,15));
			Ap_paterno.setBackground(Color.WHITE);
			Ap_paterno.setOpaque(true);
			
			Ap_Materno.setForeground(Color.BLACK);
			Ap_Materno.setFont(new Font("Tahoma",1,15));
			Ap_Materno.setBackground(Color.WHITE);
			Ap_Materno.setOpaque(true);
			
			Nom_Emp.setForeground(Color.BLACK);
			Nom_Emp.setFont(new Font("Tahoma",1,15));
			Nom_Emp.setBackground(Color.WHITE);
			Nom_Emp.setOpaque(true);
			
			direccion.setForeground(Color.BLACK);
			direccion.setFont(new Font("Tahoma",1,15));
			direccion.setBackground(Color.WHITE);
			direccion.setOpaque(true);
			
			Distrito.setForeground(Color.BLACK);
			Distrito.setFont(new Font("Tahoma",1,15));
			Distrito.setBackground(Color.WHITE);
			Distrito.setOpaque(true);
			
			Sede.setForeground(Color.BLACK);
			Sede.setFont(new Font("Tahoma",1,15));
			Sede.setBackground(Color.WHITE);
			Sede.setOpaque(true);
			
			Celular.setForeground(Color.BLACK);
			Celular.setFont(new Font("Tahoma",1,15));
			Celular.setBackground(Color.WHITE);
			Celular.setOpaque(true);
			
			Fec_Nac.setForeground(Color.BLACK);
			Fec_Nac.setFont(new Font("Tahoma",1,15));
			Fec_Nac.setBackground(Color.WHITE);
			Fec_Nac.setOpaque(true);
			
			Usuario.setForeground(Color.BLACK);
			Usuario.setFont(new Font("Tahoma",1,15));
			Usuario.setBackground(Color.WHITE);
			Usuario.setOpaque(true);
	
			Pass.setForeground(Color.BLACK);
			Pass.setFont(new Font("Tahoma",1,15));
			Pass.setBackground(Color.WHITE);
			Pass.setOpaque(true);
			
			Tipo_User.setForeground(Color.BLACK);
			Tipo_User.setFont(new Font("Tahoma",1,15));
			Tipo_User.setBackground(Color.WHITE);
			Tipo_User.setOpaque(true);

			add(L_Titulo);
			add(id_Trabajador);
			add(L_Ap_Paterno);
			add(Ap_paterno);
			add(L_Ap_Materno);
			add(Ap_Materno);
			add(L_Nombre);
			add(Nom_Emp);
			add(L_Direcc);
			add(direccion);
			add(L_Distrito);
			add(Distrito);
			add(L_Sede);
			add(Sede);
			add(L_Celular);
			add(Celular);
			add(L_Fec_Nac);
			add(Fec_Nac);
			add(L_Usuario);
			add(Usuario);
			add(L_Pass);
			add(Pass);
			add(L_Tipo_Usuario);
			add(Tipo_User);
			
		}
		
		
		
		public void Habilitar(){
			id_Trabajador.setVisible(false);
			Ap_paterno.setEnabled(true);
			Ap_Materno.setEnabled(true);
			Nom_Emp.setEnabled(true);
			direccion.setEnabled(true);
			Distrito.setEnabled(true);
			Sede.setEnabled(true);
			Celular.setEnabled(true);
			Fec_Nac.setEnabled(true);
			Usuario.setEnabled(true);
			Pass.setEnabled(true);
			Tipo_User.setEnabled(true);

			
			id_Trabajador.setText("");
			Ap_paterno.setText("");
			Ap_Materno.setText("");
			Nom_Emp.setText("");
			direccion.setText("");
			Celular.setText("");
			Fec_Nac.setText("");
			Usuario.setText("");
			Pass.setText("");

		}
		
		public void Deshabilitar(){
			
			id_Trabajador.setVisible(false);
			Ap_paterno.setEnabled(false);
			Ap_Materno.setEnabled(false);
			Nom_Emp.setEnabled(false);
			direccion.setEnabled(false);
			Distrito.setEnabled(false);
			Sede.setEnabled(false);
			Celular.setEnabled(false);
			Fec_Nac.setEnabled(false);
			Usuario.setEnabled(false);
			Pass.setEnabled(false);
			Tipo_User.setEnabled(false);

			
			id_Trabajador.setText("");
			Ap_paterno.setText("");
			Ap_Materno.setText("");
			Nom_Emp.setText("");
			direccion.setText("");
			Celular.setText("");
			Fec_Nac.setText("");
			Usuario.setText("");
			Pass.setText("");
			
	
		}
	}
	
	//SEGUNDA LAMINA PARA MOSTRAR LA TABLA DE TRABAJADORES
	class Lamina2_Form_Trabajador extends JPanel{
		
		public JTable tabla;
		public DefaultTableModel modelo;
		
		public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
		
		public Accion_Button2 buscar=new Accion_Button2("Buscar",new ImageIcon("src/Files/buscar.png"));
		
		public JLabel L_Titulo2=new JLabel ("LISTADO DE EMPLEADOS");
		public JLabel L_Buscar=new JLabel("Buscar: ");
		public JTextField Trabajador=new JTextField(10);
		public JComboBox sede=new JComboBox();
		public JTextField id_Sede=new JTextField(10);
		
		public JButton bot_buscar=new JButton(buscar);
	
		public Lamina2_Form_Trabajador(){
			
			Mostrar_Sede();
			
			setLayout(new con_Trabajador_EnColumnas2());
			
			L_Titulo2.setForeground(new Color(0,230,64));
			L_Titulo2.setFont(new Font("Jokerman",1,20));
			
			L_Buscar.setForeground(Color.WHITE);
			L_Buscar.setFont(new Font("Tahoma",1,15));
			
			Trabajador.setBackground(new Color(103,128,159));
			Trabajador.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			Trabajador.setForeground(Color.WHITE);
			Trabajador.setFont(new Font("Tahoma",1,15));
			
			bot_buscar.setBackground(new Color(0,230,64));
			bot_buscar.setForeground(Color.WHITE);
			bot_buscar.setFont(new Font("Tahoma",1,12));
		
			sede.setBackground(new Color(103,128,159));
			sede.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(103,128,159)));
			sede.setForeground(Color.WHITE);
			sede.setFont(new Font("Tahoma",1,15));
			
			id_Sede.setVisible(false);

			add(L_Titulo2);
			add(L_Buscar);
			add(Trabajador);
			add(bot_buscar);
			add(sede);
			setTable();
			
			add(id_Sede);
			
			sede.addActionListener(new Evento_Combo());
		}
		
		public void Mostrar_Sede(){
			try{
				
				Metodo_Consulta_Empleado metodo=new Metodo_Consulta_Empleado();
				
				sede=metodo.Combo_Sede();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		}
		
		private class Evento_Combo implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==sede){
					
					Metodo_Consulta_Empleado metod=new Metodo_Consulta_Empleado();
					
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
				
				Metodo_Consulta_Empleado metodo=new Metodo_Consulta_Empleado();
				modelo=metodo.Mostrar(buscar,buscar2);				
				
				tabla.setModel(modelo);
				tabla.setDefaultRenderer(Object.class,new MiRender());
				tabla.getTableHeader().setPreferredSize(new Dimension(0,80));
				tabla.getTableHeader().setBackground(Color.WHITE);
				tabla.getTableHeader().setFont(new Font("Tahoma",1,12));
			
				
				
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null,e);
				
			}
			
		}
		
		private class Evento_click implements MouseListener{
			
			public Evento_click(){
				
			}

			public void mouseClicked(MouseEvent e) {
				
				int fila=tabla.rowAtPoint(e.getPoint());
				
				lamina.id_Trabajador.setText(tabla.getValueAt(fila, 0).toString());
				lamina.Ap_paterno.setText(tabla.getValueAt(fila,1).toString());
				lamina.Ap_Materno.setText(tabla.getValueAt(fila, 2).toString());
				lamina.Nom_Emp.setText(tabla.getValueAt(fila, 3).toString());
				lamina.direccion.setText(tabla.getValueAt(fila, 4).toString());
				lamina.Fec_Nac.setText(tabla.getValueAt(fila, 5).toString());
				lamina.Celular.setText(tabla.getValueAt(fila, 6).toString());
				lamina.Usuario.setText(tabla.getValueAt(fila, 8).toString());
				lamina.Pass.setText(tabla.getValueAt(fila, 9).toString());
				lamina.Tipo_User.setText(tabla.getValueAt(fila, 10).toString());
				lamina.Distrito.setText(tabla.getValueAt(fila, 11).toString());
				lamina.Sede.setText(tabla.getValueAt(fila,12).toString());
				
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
					Mostrar(Trabajador.getText(),id_Sede.getText());
				}
			}
			
		}
	}
}

class con_Trabajador_EnColumnas1 implements LayoutManager{
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
				c.setBounds(190,30,300 ,30);
				break;
			case 1:
				c.setBounds(x,30,100 ,20);
				break;
			case 2:
				c.setBounds(x,110,200 ,20);
				break;
			case 3:
				c.setBounds(x,110,150 ,20);
				break;
			case 4:
				c.setBounds(x,140,200 ,20);
				break;
			case 5:
				c.setBounds(x,140,150 ,20);
				break;
			case 6:
				c.setBounds(x,170,200 ,20);
				break;
			case 7:
				c.setBounds(x,170,150 ,20);
				break;
			case 8:
				c.setBounds(x,200,200 ,20);
				break;
			case 9:
				c.setBounds(x,200,250 ,50);
				break;
			case 10:
				c.setBounds(x,260,100 ,20);
				break;
			case 11:
				c.setBounds(x,260,100 ,20);
				break;
			case 12:
				c.setBounds(x,290,100 ,20);
				break;
			case 13:
				c.setBounds(x,290,100 ,20);
				break;
			case 14:
				c.setBounds(x,320,100 ,20);
				break;
			case 15:
				c.setBounds(x,320,100 ,20);
				break;
			case 16:
				c.setBounds(x,350,100 ,20);
				break;
			case 17:
				c.setBounds(x,350,100 ,20);
				break;
			case 18:
				c.setBounds(x,380,100 ,20);
				break;
			case 19:
				c.setBounds(x,380,100 ,20);
				break;
			case 20:
				c.setBounds(x,410,100 ,20);
				break;	
			case 21:
				c.setBounds(x,410,100 ,20);
				break;	
			case 22:
				c.setBounds(x,440,100 ,20);
				break;	
			case 23:
				c.setBounds(x,440,150 ,20);
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

class con_Trabajador_EnColumnas2 implements LayoutManager{

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



