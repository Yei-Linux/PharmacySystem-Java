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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Datos.Datos_Trabajador;
import Logica.Metodo_form_trabajador;


public class Login extends JFrame{
	
	public Login(){
		
		setSize(700,320);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LOG IN");
		
		setUndecorated(true); 
		
		Lamina_Login lamina=new Lamina_Login();
		lamina.setBackground(new Color(52,73,94));
		add(lamina);
		
	}


	class Lamina_Login extends JPanel{
		
		private JTable tabla=new JTable();
		private JScrollPane JS=new JScrollPane(tabla);
		
		public Accion_Boton ingresar=new Accion_Boton("Ingresar",new ImageIcon("src/Presesentacion/bola1.png"));
		public Accion_Boton cancelar=new Accion_Boton("Cancelar",new ImageIcon("src/Presesentacion/bola1.png"));
		
		public Accion_Boton Cerrar=new Accion_Boton("",new ImageIcon("src/Files/cancelar.png"));
		public Accion_Boton Minimizar=new Accion_Boton("",new ImageIcon("src/Files/minimizar.png"));
		
		private JLabel barra=new JLabel("jesus");
		private JLabel etiqueta1=new JLabel("Username:");
		private JLabel etiqueta2=new JLabel("Password:");
		private JLabel etiqueta3=new JLabel("");
		
		private JTextField login=new JTextField(10);
		private JPasswordField pass=new JPasswordField(10);
		
		private JButton boton1=new JButton(ingresar);
		private JButton boton2=new JButton(cancelar);
		private JButton boton3=new JButton(Cerrar);
		private JButton boton4=new JButton(Minimizar);
		
		public Lamina_Login(){
			
			
			setLayout(new EnColumnas_Login());
			
			
			add(etiqueta1);
			add(login);
			add(etiqueta2);
			add(pass);
			add(boton1);
			add(boton2);
			add(etiqueta3);
			add(boton3);
			add(boton4);
			add(barra);
			
			barra.setForeground(Color.WHITE);
			barra.setBackground(Color.WHITE);
			barra.setOpaque(true);
			
			etiqueta3.setIcon(new ImageIcon("src/Files/Login2.png"));
			
			etiqueta1.setFont(new Font("Tahoma",1,15));
			etiqueta2.setFont(new Font("Tahoma",1,15));
			etiqueta1.setForeground(Color.WHITE);
			etiqueta2.setForeground(Color.WHITE);
			
			login.setBackground(new Color(103,128,159));
			login.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(103,128,159)));
			pass.setBackground(new Color(103,128,159));
			pass.setBorder(BorderFactory.createMatteBorder(5,5,5,5,new Color(103,128,159)));
			
			boton1.setBackground(new Color(242,38,19));
			boton1.setForeground(Color.WHITE);
			boton1.setFont(new Font("Tahoma",1,12));
			boton2.setBackground(new Color(25,181,254));
			boton2.setForeground(Color.WHITE);
			boton2.setFont(new Font("Tahoma",1,12));
			
			boton3.setFocusable(false);
			boton4.setFocusable(false);
		}
		
		private class Accion_Boton extends AbstractAction {
			public Accion_Boton(String nombre,Icon icono){
				putValue(Action.NAME,nombre);
				putValue(Action.SMALL_ICON,icono);
				putValue(Action.SHORT_DESCRIPTION,"Haga click para "+nombre);
			}
	
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==boton1){
					
					try{
						DefaultTableModel modelo;
						Metodo_form_trabajador func=new Metodo_form_trabajador();
						
						Datos_Trabajador dts=new Datos_Trabajador();
						
						dts.Set_User(login.getText());
						dts.Set_Pass(pass.getText());
						
						modelo=func.Log_in(dts.Get_User(), dts.Get_Pass());
						
						tabla.setModel(modelo);
						
						if(func.TotalRegistros>0){
						
							Menu_Principal menu=new Menu_Principal();
							menu.setVisible(true);
	
							menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							
							menu.l_Id.setText(tabla.getValueAt(0,0).toString());
							menu.l_Apellidos.setText(tabla.getValueAt(0,1).toString());
							menu.l_Nombres.setText(tabla.getValueAt(0,3).toString());
							menu.l_Usuario.setText(tabla.getValueAt(0,8).toString());
							menu.l_Tipo_Usuario.setText(tabla.getValueAt(0,10).toString());
							menu.l_Celular.setText(tabla.getValueAt(0,6).toString());
							menu.l_Sede.setText(tabla.getValueAt(0,12).toString());
							
							menu.getId_trab(tabla.getValueAt(0,0).toString());
							menu.getTrab(tabla.getValueAt(0,3).toString());
							
							System.out.println(tabla.getValueAt(0,0).toString());
							System.out.println(tabla.getValueAt(0,3).toString());
							
							if(tabla.getValueAt(0,10).toString().equalsIgnoreCase("DIGITADOR")){
								
								menu.Empleado.setEnabled(false);
								
								menu.Producto.setEnabled(false);
								menu.Categoria.setEnabled(false);
								menu.Sede.setEnabled(false);
								
								menu.Compra.setEnabled(false);
								menu.Proveedor.setEnabled(false);
								
							}else{
								if(tabla.getValueAt(0,10).toString().equalsIgnoreCase("ALMACENERO")){
									
									menu.Empleado.setEnabled(false);
									
									menu.Venta.setEnabled(false);
									menu.Cliente.setEnabled(false);
									menu.Verificar_Producto.setEnabled(false);
								}
							}
							
							
							/*
							menu..setText(tabla.getValueAt(0,0).toString()+"\n"
							+tabla.getValueAt(0,1).toString()+"\n"+tabla.getValueAt(0,2).toString()+
							"\n"+tabla.getValueAt(0,3).toString()+"\n"+tabla.getValueAt(0,4).toString()+"\n");
							
							menu.getId_trab(tabla.getValueAt(0,0).toString());
							menu.getTrab(tabla.getValueAt(0,1).toString()+" "+tabla.getValueAt(0,2).toString());
							
							
							if(!tabla.getValueAt(0,4).toString().equals("A")){
								menu.Archivo.setEnabled(false);
								menu.Configuraciones.setEnabled(false);
							}*/
						}else{
							JOptionPane.showMessageDialog(null, "Acceso Denegado","Acceso al Sistema",JOptionPane.ERROR_MESSAGE);
						}
						
						
					}catch(Exception error){
						JOptionPane.showConfirmDialog(null, error);
					}
				}
			}
		}
	}
}

class EnColumnas_Login implements LayoutManager{
	
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
				c.setBounds(x,110,200 ,20);
				break;
			case 1:
				c.setBounds(x,110,150 ,20);
				break;
			case 2:
				c.setBounds(x,140,200 ,20);
				break;
			case 3:
				c.setBounds(x,140,150 ,20);
				break;
			case 4:
				c.setBounds(x,200,120 ,30);
				break;
			case 5:
				c.setBounds(x,200,120 ,30);
				break;
			case 6:
				c.setBounds(400,50,256,256);
				break;
			case 7:
				c.setBounds(590,5,32,32);
				break;
			case 8:
				c.setBounds(640,5,32,32);
				break;
			case 9:
				c.setBounds(0,0,750,40);
				break;
			}
				x+=150;
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

