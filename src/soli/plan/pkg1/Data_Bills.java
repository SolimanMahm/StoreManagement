/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_Bills {

    String state, name, date, total, all_discount, nots;

    public Data_Bills(String state, String name, String date, String total, String all_discount, String nots) {
        this.state = state;
        this.name = name;
        this.date = date;
        this.total = total;
        this.all_discount = all_discount;
        this.nots = nots;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAll_discount() {
        return all_discount;
    }

    public void setAll_discount(String all_discount) {
        this.all_discount = all_discount;
    }

    public String getNots() {
        return nots;
    }

    public void setNots(String nots) {
        this.nots = nots;
    }

}
