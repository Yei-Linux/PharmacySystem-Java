package Logica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MiRender extends DefaultTableCellRenderer{
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasfocus, int row, int column){
		
		JLabel cell=(JLabel) super.getTableCellRendererComponent(table, value,isSelected,hasfocus,row,column);
		
		if(row%2==0){
			cell.setBackground(new Color(197,239,247));
		}else{
			cell.setBackground(new Color(228,241,254));
		}
		
		return cell;
		
	}

}
