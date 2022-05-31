/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kimo Store
 */
public class Invoice_Lines_Table_Model extends AbstractTableModel
{

    private List<Invoice_Line> invoiceLines;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public Invoice_Lines_Table_Model() {
    }
    
    
    public Invoice_Lines_Table_Model(List<Invoice_Line> invoiceLines)
    {
        this.invoiceLines = invoiceLines;
    }

    
    public List<Invoice_Line> getInvoiceLines()
    {
        return invoiceLines;
    }
    
    
    @Override
    public int getRowCount()
    {
        return invoiceLines.size();
    }

    
    @Override
    public int getColumnCount() 
    {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) 
    {
        switch (columnIndex) {
            case 0:
                return "Item Name";
                
            case 1:
                return "Item Price";
                
            case 2:
                return "Count";
                
            case 3:
                return "Total";
                
            default:
                return "";
                
        }
        
    }

    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        switch (columnIndex) {
            case 0:
                return String.class;
                
            case 1:
                return Double.class;
                
            case 2:
                return Integer.class;
                
            case 3:
                return Double.class;
                
            default:
                return Object.class;
                
        }
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Invoice_Line row = invoiceLines.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return row.getItemName();
                
            case 1:
                return row.getItemPrice();
                
            case 2:
                return row.getCount();
                
            case 3:
                return row.getLineTotal();
                
            default:
                return "";
        }
        
        
    }
    
    
    
    
}
