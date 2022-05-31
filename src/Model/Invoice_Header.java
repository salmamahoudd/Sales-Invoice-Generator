/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice_Header {

    private int Number;
    private Date Date;
    private String Customer;
    private ArrayList<Invoice_Line> Lines;

    public Invoice_Header(int Number, String Customer, Date Date) {
        this.Number = Number;
        this.Customer = Customer;
        this.Date = Date;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public ArrayList<Invoice_Line> getLines() {
        if (Lines == null) {
            Lines = new ArrayList<>();
        }

        return Lines;
    }

    public void setLines(ArrayList<Invoice_Line> Lines) {
        this.Lines = Lines;
    }

    public double getTotal() {

        double Total = 0.0;
        for (int i = 0; i < getLines().size(); i++) {
            Total += getLines().get(i).getLineTotal();
        }
        return Total;
    }

    public void addInvLine(Invoice_Line line) {
        getLines().add(line);
    }

    public String getDataAsCSV() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getNumber() + "," + dateFormat.format(getDate()) + "," + getCustomer();
    }
}
