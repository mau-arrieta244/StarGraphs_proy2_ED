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

/**
 *
 * @author mauar
 */
public class TableRendererClean implements TableCellRenderer {
    
    private static final TableCellRenderer RENDERER = new DefaultTableCellRenderer();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
                                    boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = RENDERER.getTableCellRendererComponent(table,value,
                          isSelected,hasFocus,row,column);
        
        c.setBackground(Color.white);
        
        return c;
    }
    
}