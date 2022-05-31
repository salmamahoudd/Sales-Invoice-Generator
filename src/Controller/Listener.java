/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FileOperations;
import Model.Invoice_Header;
import Model.Invoice_Line;
import View._01_SIG_Main_JFrame;
import Model.Invoice_Lines_Table_Model;
import View._02_Invoice_Header_Dialog;
import View._03_Invoice_Line_Dialog;
import View._04_InvoiceDateFieldChange_Dialog;
import View._05_InvoiceCSNameFieldChange_Dialog;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Kimo Store
 */
public class Listener implements ActionListener, ListSelectionListener {

    static public _01_SIG_Main_JFrame frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    //object to call save and load mthods
    FileOperations fileOperations = new FileOperations();
    //to handel name and date changes
    static public DateTextFieldChangeHandler dateLabelChangeHandler;
    static public CSNameTexFieldChangeHandler cSNameTexFieldChangeHandler;

    public Listener(_01_SIG_Main_JFrame frame) {
        this.frame = frame;
        dateLabelChangeHandler = new DateTextFieldChangeHandler(this.frame);
        cSNameTexFieldChangeHandler = new CSNameTexFieldChangeHandler(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                displayNewInvoiceDialog();
                break;
            case "DeleteInvoice":
                deleteInvoice();
                break;
            case "CreateNewLine":
                displayNewLineDialog();
                break;
            case "DeleteLine":
                deleteLine();
                break;
            case "LoadFile":
                fileOperations.loadFile();
                break;
            case "SaveFile":
                fileOperations.saveData();
                break;
            case "createInvoiceCancel":
                createInvCancel();
                break;
            case "createInvoiceOK":
                createInvOK();
                break;
            case "createLineCancel":
                createLineCancel();
                break;
            case "createLineOK":
                createLineOK();
                break;
            case "NewInvoiceDateOK":
                NewInvoiceDateDialogOK();
                break;
            case "NewInvoiceDateCancel":
                NewInvoiceDateDialogCancel();
                break;
            case "NewCustomerNameOK":
                NewCustomerNameOK();
                break;
            case "NewCustomerNameCancel":
                NewCustomerNameCancel();
                break;
        }
    }

    static public Invoice_Header findInvoiceByNum(int invoiceNum) {
        Invoice_Header header = null;
        for(int i=0;i<frame.getInvoicesList().size();i++)
        {
            if(invoiceNum == frame.getInvoicesList().get(i).getNumber())
            {
                header = frame.getInvoicesList().get(i);
                break;
            }
        }
        return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        invoicesTableRowSelected();
    }

    private void displayNewInvoiceDialog() {
        frame.setHeaderDialog(new _02_Invoice_Header_Dialog(frame));
        //set location of Jdialog
        frame.getHeaderDialog().setLocationRelativeTo(frame);
        //Make dialog unfoucsuable
        frame.getHeaderDialog().setModal(true);
        frame.getHeaderDialog().setVisible(true);
    }

    private void invoicesTableRowSelected() {
        int selectedRowIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            Invoice_Header row = frame.getInvHeaderTableModel().getInvoicesList().get(selectedRowIndex);
            frame.getCustomerNameTF().setText(row.getCustomer());
            frame.getDateTF().setText(dateFormat.format(row.getDate()));
            frame.getNumberLbl().setText("" + row.getNumber());
            frame.getTotalLbl().setText("" + row.getTotal());
            ArrayList<Invoice_Line> lines = row.getLines();
            // send crossponding lines of the selected header to right side table
            frame.setInvLinesTableModel(new Invoice_Lines_Table_Model(lines));
            //make it only single row selection mode
            frame.getInvoiceLinesJTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            frame.getInvoiceLinesJTable().setModel(frame.getInvLinesTableModel());
            frame.getInvLinesTableModel().fireTableDataChanged();
            //toggle focus listener for date and cs name fileds
            frame.getDateTF().removeFocusListener(dateLabelChangeHandler);
            frame.getDateTF().addFocusListener(dateLabelChangeHandler);
            frame.getCustomerNameTF().removeFocusListener(cSNameTexFieldChangeHandler);
            frame.getCustomerNameTF().addFocusListener(cSNameTexFieldChangeHandler);
        } else {
            frame.getDateTF().removeFocusListener(dateLabelChangeHandler);
        }
    }

    private void createInvCancel() {
        //return to main frame and hide the Jdialog
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void displayNewLineDialog() {
        frame.setLineDialog(new _03_Invoice_Line_Dialog(frame));
        //set location of Jdialog
        frame.getLineDialog().setLocationRelativeTo(frame);
        //Make dialog unfoucsuable
        frame.getLineDialog().setModal(true);
        frame.getLineDialog().setVisible(true);
    }

    private void createInvOK() {
        String custName = frame.getHeaderDialog().getCustomerJText().getText();
        String invDateStr = frame.getHeaderDialog().getDateJText().getText();
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);

        try {
            dateFormat.setLenient(false);
            Date invDate = dateFormat.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            Invoice_Header invoiceHeader = new Invoice_Header(invNum, custName, invDate);
            frame.getInvoicesList().add(invoiceHeader);
            frame.getInvHeaderTableModel().fireTableDataChanged();
            if ((frame.getInvoicesTable().getRowCount() > 0)) {
                frame.getInvoicesTable().setRowSelectionInterval(frame.getInvoicesTable().getRowCount() - 1, frame.getInvoicesTable().getRowCount() - 1);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Wrong date format entered", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private int getNextInvoiceNum() {

        int max = 0;
        //using for each loop to itterate over all headers to get the next new invoice num
        for (Invoice_Header Header : frame.getInvoicesList()) {
            if (Header.getNumber() > max) {
                max = Header.getNumber();

            }
        }
        return max + 1;
    }

    private void createLineOK() {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        String ItemName = frame.getLineDialog().getItemNameJText().getText();
        String CountStr = frame.getLineDialog().getItemCountJText().getText();
        String ItemPriceStr = frame.getLineDialog().getItemPriceJText().getText();
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
        //flag to check price and count formats (i.e didn't allow alphabitic charter inside one of them)
        boolean everyThingIsOK = false;
        int Count = 0;
        double ItemPrice = 0;
        try {
            Count = Integer.parseInt(CountStr);
            everyThingIsOK = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Wrong Item Count format", "Error", JOptionPane.ERROR_MESSAGE);
            everyThingIsOK = false;
        }
        try {
            ItemPrice = Double.parseDouble(ItemPriceStr);
            if (everyThingIsOK) {
                everyThingIsOK = true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Wrong Item Price format", "Error", JOptionPane.ERROR_MESSAGE);
            if (everyThingIsOK) {
                everyThingIsOK = false;
            }
        }
        //if every thing is ok (i.e price and count is fine)
        if (everyThingIsOK) {
            int headerIndex = frame.getInvoicesTable().getSelectedRow();
            Invoice_Header invoice = frame.getInvHeaderTableModel().getInvoicesList().get(headerIndex);

            Invoice_Line invoiceLine = new Invoice_Line(ItemName, ItemPrice, Count, invoice);
            invoice.addInvLine(invoiceLine);

            frame.getInvLinesTableModel().fireTableDataChanged();
            frame.getInvHeaderTableModel().fireTableDataChanged();
            frame.getTotalLbl().setText("" + invoice.getTotal());
        }
        frame.getInvoicesTable().setRowSelectionInterval(selectedRow, selectedRow);
    }

    private void createLineCancel() {

        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);

    }

    private void deleteInvoice() {
        int invIndex = frame.getInvoicesTable().getSelectedRow();
        Invoice_Header Header = frame.getInvHeaderTableModel().getInvoicesList().get(invIndex);
        frame.getInvHeaderTableModel().getInvoicesList().remove(invIndex);
        frame.getInvHeaderTableModel().fireTableDataChanged();
        frame.setInvLinesTableModel(new Invoice_Lines_Table_Model(new ArrayList<Invoice_Line>()));
        frame.getInvoiceLinesJTable().setModel(frame.getInvLinesTableModel());
        frame.getInvLinesTableModel().fireTableDataChanged();
        frame.getCustomerNameTF().setText("");
        frame.getDateTF().setText("");
        frame.getNumberLbl().setText("");
        frame.getTotalLbl().setText("");
        //check if row count of left side table is have at least one row
        if ((frame.getInvoicesTable().getRowCount() > 0)) {
            frame.getInvoicesTable().setRowSelectionInterval(frame.getInvoicesTable().getRowCount() - 1, frame.getInvoicesTable().getRowCount() - 1);
        }
    }

    static public void displayInvoices() {
        String temp = "";
        for (int i = 0; i < frame.getInvoicesList().size(); i++) {
            System.out.println("Invoice " + (i + 1));
            System.out.println("------------------------------------------------");
            temp = frame.getInvoicesList().get(i).getDataAsCSV() + ", " + frame.getInvoicesList().get(i).getCustomer() + "\n";
            for (int j = 0; j < frame.getInvoicesList().get(i).getLines().size(); j++) {
                temp += frame.getInvoicesList().get(i).getLines().get(j).getItemName() + ", "
                        + frame.getInvoicesList().get(i).getLines().get(j).getItemPrice() + ", "
                        + frame.getInvoicesList().get(i).getLines().get(j).getItemPrice() + "\n";
            }
            System.out.println(temp + "________________________________________________" + "\n");
        }
    }

    private void deleteLine() {
        int lastSelecRow = frame.getInvoicesTable().getSelectedRow();
        int lineIndex = frame.getInvoiceLinesJTable().getSelectedRow();
        Invoice_Line line = frame.getInvLinesTableModel().getInvoiceLines().get(lineIndex);
        frame.getInvLinesTableModel().getInvoiceLines().remove(lineIndex);
        frame.getInvLinesTableModel().fireTableDataChanged();
        frame.getInvHeaderTableModel().fireTableDataChanged();
        frame.getTotalLbl().setText("" + line.getHeader().getTotal());
        frame.getInvoicesTable().setRowSelectionInterval(lastSelecRow, lastSelecRow);
        if (frame.getInvoiceLinesJTable().getRowCount() > 0) {
            if ((lineIndex == 0) && (frame.getInvoiceLinesJTable().getRowCount() > 1)) {
                frame.getInvoiceLinesJTable().setRowSelectionInterval(lineIndex + 1, lineIndex + 1);
            } else if ((lineIndex == 0) && (frame.getInvoiceLinesJTable().getRowCount() == 1)) {
                frame.getInvoiceLinesJTable().setRowSelectionInterval(0, 0);
            } else {
                frame.getInvoiceLinesJTable().setRowSelectionInterval(lineIndex - 1, lineIndex - 1);
            }
        }
    }

    static public void cleanInvoicesLinesTable() {
        //Looping Until No Rows Remaining In Invoice Line Table
        while (frame.getInvoiceLinesJTable().getRowCount() > 0) {
            //Clear each header's lines
            frame.getInvoicesList().get(frame.getInvoicesTable().getSelectedRow()).getLines().clear();
            //Update table after changes
            frame.getInvLinesTableModel().fireTableRowsDeleted(0, 0);
        }
    }

    static public void cleanInvoicesHeadeTable() {
        //Looping Until No Rows Remaining In Invoice Headr Table
        while (frame.getInvoicesTable().getRowCount() > 0) {
            //Clear each header row
            frame.getInvoicesList().remove(0);
            //Update table after changes
            frame.getInvHeaderTableModel().fireTableRowsDeleted(0, 0);
        }
        //Make sure that the data array list is empty
        frame.getInvoicesList().clear();
    }

    static public void cleanRightSideFields() {
        frame.getCustomerNameTF().setText("");
        frame.getDateTF().setText("");
        frame.getNumberLbl().setText("");
        frame.getTotalLbl().setText("");
    }

    static public void showNewInvoiceDateDialog() {
        frame.setChangeDateDialog(new _04_InvoiceDateFieldChange_Dialog(frame));
        //set location of Jdialog
        frame.getChangeDateDialog().setLocationRelativeTo(frame);
        //Make dialog unfoucsuable
        frame.getChangeDateDialog().setModal(true);
        frame.getChangeDateDialog().setVisible(true);
    }

    static public void showNewCSNameFieldDialog() {
        frame.setCSNameFieldChangeDialog(new _05_InvoiceCSNameFieldChange_Dialog(frame));
        //set location of Jdialog
        frame.getCSNameFieldChangeDialog().setLocationRelativeTo(frame);
        //Make dialog unfoucsuable
        frame.getCSNameFieldChangeDialog().setModal(true);
        frame.getCSNameFieldChangeDialog().setVisible(true);
    }

    private void NewInvoiceDateDialogOK() {
        int lastSelecRow = frame.getInvoicesTable().getSelectedRow();
        frame.getChangeDateDialog().setVisible(false);
        String invDateStr = frame.getChangeDateDialog().getNewDateJText().getText();
        frame.getChangeDateDialog().dispose();
        frame.getChangeDateDialog().getNewDateJText().setText("");
        frame.setChangeDateDialog(null);
        try {
            dateFormat.setLenient(false);
            Date invDate = dateFormat.parse(invDateStr);
            frame.getInvoicesList().get(frame.getInvoicesTable().getSelectedRow()).setDate(invDate);
            frame.getInvHeaderTableModel().fireTableDataChanged();
            if ((frame.getInvoicesTable().getRowCount() > 0)) {
                frame.getInvoicesTable().setRowSelectionInterval(lastSelecRow, lastSelecRow);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void NewInvoiceDateDialogCancel() {
        frame.getChangeDateDialog().setVisible(false);
    }

    private void NewCustomerNameOK() {
        int lastSelecRow = frame.getInvoicesTable().getSelectedRow();
        frame.getCSNameFieldChangeDialog().setVisible(false);
        String csName = frame.getCSNameFieldChangeDialog().getNewCustomerNameJText().getText();
        frame.getCSNameFieldChangeDialog().dispose();
        frame.getCSNameFieldChangeDialog().getNewCustomerNameJText().setText("");
        frame.setCSNameFieldChangeDialog(null);
        frame.getInvoicesList().get(frame.getInvoicesTable().getSelectedRow()).setCustomer(csName);
        frame.getInvHeaderTableModel().fireTableDataChanged();
        if ((frame.getInvoicesTable().getRowCount() > 0)) {
            frame.getInvoicesTable().setRowSelectionInterval(lastSelecRow, lastSelecRow);
        }
    }

    private void NewCustomerNameCancel() {
        frame.getCSNameFieldChangeDialog().setVisible(false);
    }

}
