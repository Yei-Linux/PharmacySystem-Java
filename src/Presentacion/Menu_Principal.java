package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;



public class Menu_Principal extends JFrame{
	
	public Container contentPane=new Container();
	public Lamina_Menu lamina=new Lamina_Menu();
	public Lamina2_Menu lamina2=new Lamina2_Menu();
	
	public JLabel l_Usuario;
	public JLabel l_Apellidos;
	public JLabel l_Nombres;
	public JLabel l_Tipo_Usuario;
	public JLabel l_Sede;
	public JLabel l_Celular;
	public JLabel l_Id;
	
	public JMenuItem Empleado;
	
	public JMenuItem Producto;
	public JMenuItem Categoria;
	public JMenuItem Sede;
	
	public JMenuItem Compra;
	public JMenuItem Proveedor;
	
	public JMenuItem Venta;
	public JMenuItem Cliente;
	public JMenuItem Verificar_Producto;
	
	public JMenuItem Venta2;
	public JMenuItem Compra2;
	public JMenuItem Empleado2;
	public JMenuItem Cliente2;
	
	public String cadena;
	public String cadena2;
	
	public Menu_Principal(){
		
		setSize(1500,800);
		setLocationRelativeTo(null);
		setTitle("Menu de Inicio");
		setContentPane(contentPane);
		
		setUndecorated(true); 
		
		lamina2.setBounds(0,0,1500,150);
		lamina.setBounds(0,150,1500,650);
		
		lamina.setBackground(Color.WHITE);
		
		contentPane.add(lamina);
		contentPane.add(lamina2);
	}
	
	public void getId_trab(String cadena){
		this.cadena=cadena;
	}
	

	
	public void getTrab(String cadena2){
		this.cadena2=cadena2;
	}

class Lamina_Menu extends JPanel{
	
	public JTextPane area=new JTextPane();
	public JScrollPane scroll=new JScrollPane(area);
	
	public JLabel Apellidos=new JLabel("Apellidos:");
	public JLabel Nombres=new JLabel("Nombres:");
	public JLabel Usuario=new JLabel("Usuario:");
	public JLabel Tipo_Usuario=new JLabel("Tipo Usuario:");
	public JLabel Sede=new JLabel("Sede:");
	public JLabel Celular=new JLabel("Celular:");
	
	private JLabel perfil=new JLabel("");
	
	
	public Lamina_Menu(){
		
		l_Apellidos=new JLabel("--------------------");
		l_Nombres=new JLabel("--------------------");
		l_Usuario=new JLabel("--------------------");
		l_Tipo_Usuario=new JLabel("--------------------");
		l_Sede=new JLabel("--------------------");
		l_Celular=new JLabel("--------------------");
		l_Id=new JLabel("----------------");
		
		l_Id.setVisible(false);
		
		setLayout(null);
		
		add(Apellidos);
		add(Nombres);
		add(Usuario);
		add(Tipo_Usuario);
		add(Sede);
		add(Celular);
		
		add(l_Apellidos);
		add(l_Nombres);
		add(l_Usuario);
		add(l_Tipo_Usuario);
		add(l_Sede);
		add(l_Celular);
		add(l_Id);
		
		add(perfil);
		
		perfil.setIcon(new ImageIcon("src/Files/login.png"));
		
		Apellidos.setBounds(150,0,200,200);
		Nombres.setBounds(150,50,200,200);
		Usuario.setBounds(150,100,200,200);
		Tipo_Usuario.setBounds(150,150,200,200);
		Sede.setBounds(150,200,200,200);
		Celular.setBounds(150,250,200,200);
		
		l_Apellidos.setBounds(350,0,200,200);
		l_Nombres.setBounds(350,50,200,200);
		l_Usuario.setBounds(350,100,200,200);
		l_Tipo_Usuario.setBounds(350,150,200,200);
		l_Sede.setBounds(350,200,200,200);
		l_Celular.setBounds(350,250,200,200);
		l_Id.setBounds(350,300,200,200);
		
		perfil.setBounds(650, 100,256,256);

	}
}

class Lamina2_Menu extends JPanel{
	
	private JLabel barra=new JLabel("jesus");
	public Accion_Boton Cerrar=new Accion_Boton("",new ImageIcon("src/Files/cancelar.png"));
	public Accion_Boton Minimizar=new Accion_Boton("",new ImageIcon("src/Files/minimizar.png"));
	
	private JButton boton3=new JButton(Cerrar);
	
	private JButton boton4=new JButton(Minimizar);
	public JMenuBar bar=new JMenuBar();
		
	public ImageIcon imagen=new ImageIcon("src/Files/bola1.png");
	public JMenu Archivo=new JMenu("Archivo");
	public JMenu Almacen=new JMenu("Almacen");
	public JMenu Compras=new JMenu("Compras");
	public JMenu Ventas=new JMenu("Ventas");
	public JMenu Consultas=new JMenu("Consultas");
	public JMenu Herramientas=new JMenu("Herramientas");
	public JMenu Ayuda=new JMenu("Ayuda");
	public JMenu Salir=new JMenu("Salir");
	
	public JMenuItem In_Sesion=new JMenuItem("Iniciar Sesion",new ImageIcon("src/Files/In_Sesion.png"));
	public JMenuItem Cer_Sesion=new JMenuItem("Cerrar Sesion",new ImageIcon("src/Files/Cer_Sesion.png"));
	
	public Lamina2_Menu(){
		
		Empleado=new JMenuItem("Empleado",new ImageIcon("src/Files/Empleado.png"));
		
		Producto=new JMenuItem("Producto",new ImageIcon("src/Files/Producto.png"));
		Categoria=new JMenuItem("Categoria",new ImageIcon("src/Files/Categoria.png"));
		Sede=new JMenuItem("Sede",new ImageIcon("src/Files/Sede.png"));
		
		Compra=new JMenuItem("Compras",new ImageIcon("src/Files/Compra.png"));
		Proveedor=new JMenuItem("Proveedor",new ImageIcon("src/Files/Proveedor.png"));
		
		Venta=new JMenuItem("Ventas",new ImageIcon("src/Files/Venta.png"));
		Cliente=new JMenuItem("Cliente",new ImageIcon("src/Files/Cliente.png"));
		Verificar_Producto=new JMenuItem("Verificar Producto",new ImageIcon("src/Files/Veri_Prod.png"));
		
		Venta2=new JMenuItem("Ventas",new ImageIcon("src/Files/Venta.png"));
		Compra2=new JMenuItem("Compras",new ImageIcon("src/Files/Compra.png"));
		Empleado2=new JMenuItem("Empleado",new ImageIcon("src/Files/Empleado.png"));
		Cliente2=new JMenuItem("Cliente",new ImageIcon("src/Files/Cliente.png"));
		
		setLayout(null);
		
		bar.add(Archivo);
		bar.add(Almacen);
		bar.add(Compras);
		bar.add(Ventas);
		bar.add(Consultas);
		bar.add(Herramientas);
		bar.add(Ayuda);
		bar.add(Salir);
		
		add(bar);
		
		bar.setBackground(new Color(52,73,94));
		
		bar.setBounds(0, 50, 1500, 100);
		
		Archivo.add(In_Sesion);
		Archivo.add(Cer_Sesion);
		Archivo.add(Empleado);
		Archivo.setForeground(Color.WHITE);
		Archivo.setFont(new Font("Tahoma",1,15));
		
		Almacen.add(Producto);
		Almacen.add(Categoria);
		Almacen.add(Sede);
		Almacen.setForeground(Color.WHITE);
		Almacen.setFont(new Font("Tahoma",1,15));
		
		Compras.add(Compra);
		Compras.add(Proveedor);
		Compras.setBackground(Color.WHITE);
		Compras.setForeground(Color.WHITE);
		Compras.setFont(new Font("Tahoma",1,15));
		
		Ventas.add(Venta);
		Ventas.add(Cliente);
		Ventas.add(Verificar_Producto);
		Ventas.setBackground(Color.WHITE);
		Ventas.setForeground(Color.WHITE);
		Ventas.setFont(new Font("Tahoma",1,15));
		
		Consultas.add(Venta2);
		Consultas.add(Compra2);
		Consultas.add(Empleado2);
		Consultas.add(Cliente2);
		Consultas.setBackground(Color.WHITE);
		Consultas.setForeground(Color.WHITE);
		Consultas.setFont(new Font("Tahoma",1,15));
		
		Herramientas.setForeground(Color.WHITE);
		Herramientas.setFont(new Font("Tahoma",1,15));
		
		Ayuda.setForeground(Color.WHITE);
		Ayuda.setFont(new Font("Tahoma",1,15));
		
		Salir.setForeground(Color.WHITE);
		Salir.setFont(new Font("Tahoma",1,15));
	
		add(boton3);
		add(boton4);
		add(barra);
		
		barra.setForeground(Color.WHITE);
		barra.setBackground(Color.WHITE);
		barra.setOpaque(true);
		
		boton3.setFocusable(false);
		boton4.setFocusable(false);
	
		boton3.setBounds(1250,5,32,32);
		boton4.setBounds(1300,5,32,32);
		barra.setBounds(0,0,1500,50);
		
		Archivo.setIcon(new ImageIcon("src/Files/2.png"));
		Almacen.setIcon(new ImageIcon("src/Files/Almacen.png"));
		Compras.setIcon(new ImageIcon("src/Files/Compras.png"));
		Ventas.setIcon(new ImageIcon("src/Files/Ventas.png"));
		Consultas.setIcon(new ImageIcon("src/Files/Consultas.png"));
		Herramientas.setIcon(new ImageIcon("src/Files/Herr.png"));
		Ayuda.setIcon(new ImageIcon("src/Files/Ayuda.png"));
		Salir.setIcon(new ImageIcon("src/Files/Salir.png"));
		
		
		Empleado.addActionListener(new Evento_click());
		Producto.addActionListener(new Evento_click());
		Sede.addActionListener(new Evento_click());
		Compra.addActionListener(new Evento_click());
		Proveedor.addActionListener(new Evento_click());
		Venta.addActionListener(new Evento_click());
		Cliente.addActionListener(new Evento_click());
		Cliente2.addActionListener(new Evento_click());
		Verificar_Producto.addActionListener(new Evento_click());
		Empleado2.addActionListener(new Evento_click());
		Venta2.addActionListener(new Evento_click());
		Compra2.addActionListener(new Evento_click());
	}
	
	private class Accion_Boton extends AbstractAction {
		public Accion_Boton(String nombre,Icon icono){
			putValue(Action.NAME,nombre);
			putValue(Action.SMALL_ICON,icono);
			putValue(Action.SHORT_DESCRIPTION,"Haga click para "+nombre);
		}

		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	
	private class Evento_click implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Lamina_Menu lam=new Lamina_Menu();
			
			if(e.getSource()==Empleado){
				Form_Trabajador marco=new Form_Trabajador();
				marco.toFront();
				marco.setVisible(true);
			}
			
			if(e.getSource()==Producto){
				Form_Producto marco2=new Form_Producto();
				marco2.toFront();
				marco2.setVisible(true);
			}
			
			if(e.getSource()==Verificar_Producto){
				Inventario marco3=new Inventario();
				marco3.toFront();
				marco3.setVisible(true);
			}
			
			if(e.getSource()==Sede){
				Form_Sede_Almacen marco4=new Form_Sede_Almacen();
				marco4.toFront();
				marco4.setVisible(true);
			}
			
			if(e.getSource()==Compra){
				Form_Compra marco5=new Form_Compra();
				marco5.toFront();
				marco5.setVisible(true);
			}
			
			if(e.getSource()==Proveedor){
				Form_Proveedor marco6=new Form_Proveedor();
				marco6.toFront();
				marco6.setVisible(true);
				
			}
			if(e.getSource()==Venta){
				Form_Venta marco7=new Form_Venta();
				System.out.println(cadena);
				System.out.println(cadena2);
				marco7.Empleado.setText(cadena2);
				marco7.id_Empleado.setText(cadena);
				marco7.toFront();
				marco7.setVisible(true);
			}
			if(e.getSource()==Cliente){
				Form_Cliente marco8=new Form_Cliente();
				marco8.toFront();
				marco8.setVisible(true);
			}
			
			if(e.getSource()==Cliente2){
				System.out.println("fallo");
				Consulta_Cliente marco9=new Consulta_Cliente();
				marco9.toFront();
				marco9.setVisible(true);
			}
			if(e.getSource()==Empleado2){
				Consulta_Empleado marco10=new Consulta_Empleado();
				marco10.toFront();
				marco10.setVisible(true);
			}
			
			if(e.getSource()==Venta2){
				Consulta_Venta marco11=new Consulta_Venta();
				marco11.toFront();
				marco11.setVisible(true);
			}
			if(e.getSource()==Compra2){
				Consulta_Compra marco12=new Consulta_Compra();
				marco12.toFront();
				marco12.setVisible(true);
			}
			if(e.getSource()==Salir){
				
			}
		}
		
	}
}
}
