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
public class Invoice_Header_Table_Model extends AbstractTableModel {

    private List<Invoice_Header> invoicesList;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Invoice_Header_Table_Model(List<Invoice_Header> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public List<Invoice_Header> getInvoicesList() {
        return invoicesList;
    }

    @Override
    public int getRowCount() {
        return invoicesList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Invoice Number";

            case 1:
                return "Customer Name";

            case 2:
                return "Invoice Date";

            case 3:
                return "Invoice Total";
            default:
                return "";

        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;

            case 1:
                return String.class;

            case 2:
                return String.class;

            case 3:
                return Double.class;

            default:
                return Object.class;
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice_Header row = invoicesList.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return row.getNumber();

            case 1:
                return row.getCustomer();

            case 2:
                return dateFormat.format(row.getDate());

            case 3:
                return row.getTotal();

            default:
                return "";

        }

    }
}
