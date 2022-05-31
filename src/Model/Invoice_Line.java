/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kimo Store
 */
public class Invoice_Line {

    private String ItemName;
    private int Count;
    private double ItemPrice;
    private Invoice_Header Header;

    public Invoice_Line(String itemName, double ItemPrice, int Count, Invoice_Header Header) {
        this.ItemName = itemName;
        this.ItemPrice = ItemPrice;
        this.Count = Count;
        this.Header = Header;

    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {

        this.ItemName = ItemName;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public Invoice_Header getHeader() {
        return Header;
    }

    public void setHeader(Invoice_Header Header) {
        this.Header = Header;
    }

    public double getLineTotal() {
        return (Count * ItemPrice);
    }

    public String getDataAsCSV() {
        return "" + getHeader().getNumber() + "," + getItemName() + ","
                + getItemPrice() + "," + getCount();

    }

}
