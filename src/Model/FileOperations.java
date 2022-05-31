/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Listener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Kimo Store
 */
public class FileOperations {

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void loadFile() {
        //clean both tables and all of it's content
        Listener.cleanInvoicesLinesTable();
        Listener.cleanInvoicesHeadeTable();
        //clean right side fields (CSname ,date,invoice number and total)
        Listener.cleanRightSideFields();
        JOptionPane.showMessageDialog(Listener.frame, "Please Select Header File", "Warning",
                JOptionPane.WARNING_MESSAGE);
        JFileChooser openDialog = new JFileChooser();
        //Set defult directory to the same as program directory 
        openDialog.setCurrentDirectory(new File(System.getProperty("user.dir")));
        //Set default selected file name to "InvoiceHeader.csv"
        openDialog.setSelectedFile(new File("InvoiceHeader.csv"));
        int choice = openDialog.showOpenDialog(Listener.frame);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File headerFile = openDialog.getSelectedFile();
            try {
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerFileLine = null;

                while ((headerFileLine = headerBr.readLine()) != null) {
                    String[] headerFields = headerFileLine.split(",");
                    String invoiceNumberString = headerFields[0];
                    String invoiceDateString = headerFields[1];
                    String invoicecustomerName = headerFields[2];
                    int invoiceNumber = Integer.parseInt(invoiceNumberString);
                    dateFormat.setLenient(false);
                    Date invoiceDate = dateFormat.parse(invoiceDateString);
                    Invoice_Header invoiceHeader = new Invoice_Header(invoiceNumber, invoicecustomerName, invoiceDate);
                    Listener.frame.getInvoicesList().add(invoiceHeader);
                }
                JOptionPane.showMessageDialog(Listener.frame, "Please Select Lines File", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                //Set default selected file name to "InvoiceLine.csv"
                openDialog.setSelectedFile(new File("InvoiceLine.csv"));
                choice = openDialog.showOpenDialog(Listener.frame);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openDialog.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invoiceNumberString = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceString = lineParts[2];
                        String itemCountStrring = lineParts[3];
                        int invoiceNumber = Integer.parseInt(invoiceNumberString);
                        double itemPrice = Double.parseDouble(itemPriceString);
                        int itemCount = Integer.parseInt(itemCountStrring);
                        Invoice_Header header = Listener.findInvoiceByNum(invoiceNumber);
                        Invoice_Line invLine = new Invoice_Line(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                    Listener.frame.setInvHeaderTableModel(new Invoice_Header_Table_Model(Listener.frame.getInvoicesList()));
                    Listener.frame.getInvoicesTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    Listener.frame.getInvoicesTable().setModel(Listener.frame.getInvHeaderTableModel());
                    Listener.frame.getInvoicesTable().validate();
                    Listener.frame.getCreateBtn().setEnabled(true);
                } else {
                    Listener.frame.getInvoicesList().clear();
                    Listener.frame.getCreateBtn().setEnabled(false);
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(Listener.frame, "Date Format Error\n", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Listener.frame, "Number Format Error\n", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(Listener.frame, "File Error\n", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(Listener.frame, "Read Error\n", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Listener.frame.getInvoicesList().clear();
            Listener.frame.getCreateBtn().setEnabled(false);
        }
        if (!(Listener.frame.getInvoicesList().isEmpty())) {
            Listener.displayInvoices();
        }
    }

    public void saveData() {
        String invoiceHeaders = "";
        String invoiceLines = "";
        for (Invoice_Header header : Listener.frame.getInvoicesList()) {
            invoiceHeaders += header.getDataAsCSV();
            invoiceHeaders += "\n";
            for (Invoice_Line line : header.getLines()) {
                invoiceLines += line.getDataAsCSV();
                invoiceLines += "\n";
            }
        }
        //This trick to remove the latest character which is '/n' because it's not needed
        invoiceHeaders = invoiceHeaders.subSequence(0, invoiceHeaders.length() - 1).toString();
        invoiceLines = invoiceLines.subSequence(0, invoiceLines.length() - 1).toString();
        JOptionPane.showMessageDialog(Listener.frame, "Select File to Save Header Data",
                "Warning", JOptionPane.WARNING_MESSAGE);
        JFileChooser openDialog = new JFileChooser();
        //Set defult directory to the same as program directory 
        openDialog.setCurrentDirectory(new File(System.getProperty("user.dir")));
        //Set default selected file name to "InvoiceHeader.csv"
        openDialog.setSelectedFile(new File("InvoiceHeader.csv"));
        int choice = openDialog.showSaveDialog(Listener.frame);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File headerFile = openDialog.getSelectedFile();
            try {
                FileWriter headerFileWriter = new FileWriter(headerFile);
                headerFileWriter.write(invoiceHeaders);
                headerFileWriter.flush();
                headerFileWriter.close();

                JOptionPane.showMessageDialog(Listener.frame, "Select File to Save Lines Data",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                //Set default selected file name to "InvoiceHeader.csv"
                openDialog.setSelectedFile(new File("InvoiceLine.csv"));
                choice = openDialog.showSaveDialog(Listener.frame);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openDialog.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(linesFile);
                    lineFileWriter.write(invoiceLines);
                    lineFileWriter.flush();
                    lineFileWriter.close();

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Listener.frame, "Error: "
                        , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(Listener.frame, "Files Overwritten Successfully", "Success",
                 JOptionPane.INFORMATION_MESSAGE);

    }
}
