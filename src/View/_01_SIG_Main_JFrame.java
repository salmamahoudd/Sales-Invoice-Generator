/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Listener;
import Model.Invoice_Header;
import Model.Invoice_Header_Table_Model;
import Model.Invoice_Lines_Table_Model;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Kimo Store
 */
public class _01_SIG_Main_JFrame extends javax.swing.JFrame
{
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeadrTableScrollPane = new javax.swing.JScrollPane();
        InvoicesHeaderTable = new javax.swing.JTable();
        InvoicesHeaderTable.getSelectionModel().addListSelectionListener(Listener);
        CreateBtn = new javax.swing.JButton();
        CreateBtn.addActionListener(Listener);
        DeleteBtn = new javax.swing.JButton();
        DeleteBtn.addActionListener(Listener);
        InvoiceNumberLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        InvoiceCSNameLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        CustomerNameTF = new javax.swing.JTextField();
        DateTF = new javax.swing.JTextField();
        NumberLbl = new javax.swing.JLabel();
        TotalLbl = new javax.swing.JLabel();
        InvoiceLinesScrollPane = new javax.swing.JScrollPane();
        InvoiceLinesTable = new javax.swing.JTable();
        CreateLineBtn = new javax.swing.JButton();
        CreateLineBtn.addActionListener(Listener);
        DeleteLineBtn = new javax.swing.JButton();
        DeleteLineBtn.addActionListener(Listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadItem = new javax.swing.JMenuItem();
        loadItem.addActionListener(Listener);
        SaveItem = new javax.swing.JMenuItem();
        SaveItem.addActionListener(Listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoicesHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        HeadrTableScrollPane.setViewportView(InvoicesHeaderTable);

        CreateBtn.setText("Create New Invoice");
        CreateBtn.setActionCommand("CreateNewInvoice");
        CreateBtn.setEnabled(false);

        DeleteBtn.setText("Delete Invoice");
        DeleteBtn.setActionCommand("DeleteInvoice");
        DeleteBtn.setEnabled(false);

        InvoiceNumberLabel.setText("Invoice Number");

        InvoiceDateLabel.setText("Invoice Date");

        InvoiceCSNameLabel.setText("Customer Name");

        InvoiceTotalLabel.setText("Invoice Total");

        InvoiceLinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        InvoiceLinesScrollPane.setViewportView(InvoiceLinesTable);

        CreateLineBtn.setText("Create New Line");
        CreateLineBtn.setActionCommand("CreateNewLine");
        CreateLineBtn.setEnabled(false);

        DeleteLineBtn.setText("Delete Line");
        DeleteLineBtn.setActionCommand("DeleteLine");
        DeleteLineBtn.setEnabled(false);

        jMenu1.setText("File");

        loadItem.setText("Load File");
        loadItem.setActionCommand("LoadFile");
        jMenu1.add(loadItem);

        SaveItem.setText("Save File");
        SaveItem.setActionCommand("SaveFile");
        jMenu1.add(SaveItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HeadrTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceCSNameLabel)
                                    .addComponent(InvoiceNumberLabel)
                                    .addComponent(InvoiceDateLabel)
                                    .addComponent(InvoiceTotalLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustomerNameTF)
                                    .addComponent(DateTF)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NumberLbl)
                                            .addComponent(TotalLbl))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InvoiceLinesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(CreateBtn)
                        .addGap(81, 81, 81)
                        .addComponent(DeleteBtn)
                        .addGap(156, 156, 156)
                        .addComponent(CreateLineBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteLineBtn)
                        .addGap(74, 74, 74)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HeadrTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceNumberLabel)
                            .addComponent(NumberLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceDateLabel)
                            .addComponent(DateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceCSNameLabel)
                            .addComponent(CustomerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceTotalLabel)
                            .addComponent(TotalLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InvoiceLinesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(CreateLineBtn)
                    .addComponent(DeleteLineBtn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public _01_SIG_Main_JFrame()
    {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(_01_SIG_Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_01_SIG_Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_01_SIG_Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_01_SIG_Main_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        initComponents();
        //Set locatio of Jframe to be ceneterd regardless of monitor resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBtn;
    private javax.swing.JButton CreateLineBtn;
    private javax.swing.JTextField CustomerNameTF;
    private javax.swing.JTextField DateTF;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DeleteLineBtn;
    private javax.swing.JScrollPane HeadrTableScrollPane;
    private javax.swing.JLabel InvoiceCSNameLabel;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JScrollPane InvoiceLinesScrollPane;
    private javax.swing.JTable InvoiceLinesTable;
    private javax.swing.JLabel InvoiceNumberLabel;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JTable InvoicesHeaderTable;
    private javax.swing.JLabel NumberLbl;
    private javax.swing.JMenuItem SaveItem;
    private javax.swing.JLabel TotalLbl;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem loadItem;
    // End of variables declaration//GEN-END:variables

        private List<Invoice_Header> invoicesList = new ArrayList<>();
        private Invoice_Header_Table_Model InvHeaderTableModel;
        private Invoice_Lines_Table_Model InvLinesTableModel;
        private _02_Invoice_Header_Dialog HeaderDialog;
        private _03_Invoice_Line_Dialog LineDialog;
        private _04_InvoiceDateFieldChange_Dialog changeDate_Dialog;
        private _05_InvoiceCSNameFieldChange_Dialog cSNameFieldChange_Dialog;
        private Listener Listener = new Listener(this);
        
    public Listener getListener()
    {
     return Listener;
    }

    public void setHeaderDialog(_02_Invoice_Header_Dialog HeaderDialog) 
    {
       this.HeaderDialog = HeaderDialog;
    }
    
    public void setChangeDateDialog(_04_InvoiceDateFieldChange_Dialog changeDate_Dialog) 
    {
       this.changeDate_Dialog = changeDate_Dialog;
    }
    
    public void setCSNameFieldChangeDialog(_05_InvoiceCSNameFieldChange_Dialog cSNameFieldChange_Dialog) 
    {
       this.cSNameFieldChange_Dialog = cSNameFieldChange_Dialog;
    }
    
    public void setLineDialog(_03_Invoice_Line_Dialog LineDialog)
    {
       this.LineDialog = LineDialog;
    }

    public void setInvHeaderTableModel(Invoice_Header_Table_Model InvHeaderTableModel)
    {
       this.InvHeaderTableModel = InvHeaderTableModel;
    }

    public void setInvLinesTableModel(Invoice_Lines_Table_Model InvLinesTableModel)
    {
       this.InvLinesTableModel = InvLinesTableModel;
    }

    public JButton getCreateBtn()   
    {
        return CreateBtn;
    }

    public JButton getCreateLineBtn()
    {
        return CreateLineBtn;
    }

    public JTextField getCustomerNameTF() 
    {
       return CustomerNameTF;
    }

    public JButton getDeleteBtn()
    {
        return DeleteBtn;
    }

    public JButton getDeleteLineBtn()  
    {
        return DeleteLineBtn;
    }

    public JTextField getDateTF()  
    {
       return DateTF;
    }

     public JTable getInvoiceLinesJTable()
    
    {
        return InvoiceLinesTable;
    }

    public JLabel getNumberLbl() 
    {
        return NumberLbl;
    }

    public JLabel getTotalLbl()
    {
        return TotalLbl;
    }

    public JMenuItem getloadItem() 
    {
        return loadItem;
    }

    public JMenuItem getSaveItem() 
    {
        return SaveItem;
    }

    public List<Invoice_Header> getInvoicesList()  
    {
        return invoicesList;
    }

    public Invoice_Header_Table_Model getInvHeaderTableModel() 
    {
        return InvHeaderTableModel;
    }

    public Invoice_Lines_Table_Model getInvLinesTableModel() 
    {
        return InvLinesTableModel;
    }

    public _02_Invoice_Header_Dialog getHeaderDialog() 
    {
        return HeaderDialog;
    }

    public _03_Invoice_Line_Dialog getLineDialog()  
    {
        return LineDialog;
    }
    
    public _04_InvoiceDateFieldChange_Dialog getChangeDateDialog()
    {
        return changeDate_Dialog;
    }
    
    public _05_InvoiceCSNameFieldChange_Dialog getCSNameFieldChangeDialog()
    {
        return cSNameFieldChange_Dialog;
    }
    
    public JTable getInvoicesTable()
    {
        return InvoicesHeaderTable; 
    }

    public JMenu getjMenu1() 
    {
        return jMenu1;
    }

    public JLabel getInvoiceDateLabel() 
    {
        return InvoiceDateLabel;
    }
    
}
