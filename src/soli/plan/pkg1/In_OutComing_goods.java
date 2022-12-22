/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class In_OutComing_goods {

    String date, name_person, number_bill, state, name_items, number_item, price, discount, total;

    public In_OutComing_goods(String date, String name_person, String number_bill, String state, String name_items, String number_item, String price, String discount, String total) {
        this.date = date;
        this.name_person = name_person;
        this.number_bill = number_bill;
        this.state = state;
        this.name_items = name_items;
        this.number_item = number_item;
        this.price = price;
        this.discount = discount;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName_person() {
        return name_person;
    }

    public void setName_person(String name_person) {
        this.name_person = name_person;
    }

    public String getNumber_bill() {
        return number_bill;
    }

    public void setNumber_bill(String number_bill) {
        this.number_bill = number_bill;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName_items() {
        return name_items;
    }

    public void setName_items(String name_items) {
        this.name_items = name_items;
    }

    public String getNumber_item() {
        return number_item;
    }

    public void setNumber_item(String number_item) {
        this.number_item = number_item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
