/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColorCellRenderer implements TableCellRenderer {
    
    private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
                                    boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = RENDERER.getTableCellRendererComponent(table,value,
                          isSelected,hasFocus,row,column);
        
        Object result = table.getModel().getValueAt(row,column);
        String valor = new String();
            
        if(result != null )
            valor = result.toString();
         
        //fuentes de poder en rojo
        if(".".equals(valor))
            c.setBackground(Color.RED);
        
        //naves en amarillo
        else if(",".equals(valor))
            c.setBackground(Color.yellow);
        
        //soldados en celeste/cyan
        else if("..".equals(valor))
            c.setBackground(Color.CYAN);
        
        //los que no tienen arista vacios / blanco
        else{
            c.setBackground(Color.white);
        }
        return c;
    }
    
}
