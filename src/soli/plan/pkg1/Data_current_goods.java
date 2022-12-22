/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_current_goods {

    String name_items, In_items, Out_items, Current_items, price, total;

    public Data_current_goods(String name_items, String In_items, String Out_items, String Current_items, String price, String total) {
        this.name_items = name_items;
        this.In_items = In_items;
        this.Out_items = Out_items;
        this.Current_items = Current_items;
        this.price = price;
        this.total = total;
    }

    public String getName_items() {
        return name_items;
    }

    public void setName_items(String name_items) {
        this.name_items = name_items;
    }

    public String getIn_items() {
        return In_items;
    }

    public void setIn_items(String In_items) {
        this.In_items = In_items;
    }

    public String getOut_items() {
        return Out_items;
    }

    public void setOut_items(String Out_items) {
        this.Out_items = Out_items;
    }

    public String getCurrent_items() {
        return Current_items;
    }

    public void setCurrent_items(String Current_items) {
        this.Current_items = Current_items;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
