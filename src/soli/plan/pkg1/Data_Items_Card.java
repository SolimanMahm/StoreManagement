/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_Items_Card {
    private String C_id ,C_name ,C_supply_price ,C_wholesale_price ,C_Consumer_selling_price ,Y_id ;

    public Data_Items_Card(String C_id, String C_name, String C_supply_price, String C_wholesale_price, String C_Consumer_selling_price) {
        this.C_id = C_id;
        this.C_name = C_name;
        this.C_supply_price = C_supply_price;
        this.C_wholesale_price = C_wholesale_price;
        this.C_Consumer_selling_price = C_Consumer_selling_price;
    }
    
    public void setC_id(String C_id) {
        this.C_id = C_id;
    }

    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    public void setC_supply_price(String C_supply_price) {
        this.C_supply_price = C_supply_price;
    }

    public void setC_wholesale_price(String C_wholesale_price) {
        this.C_wholesale_price = C_wholesale_price;
    }

    public void setC_Consumer_selling_price(String C_Consumer_selling_price) {
        this.C_Consumer_selling_price = C_Consumer_selling_price;
    }

    public void setY_id(String Y_id) {
        this.Y_id = Y_id;
    }

    public String getC_id() {
        return C_id;
    }

    public String getC_name() {
        return C_name;
    }

    public String getC_supply_price() {
        return C_supply_price;
    }

    public String getC_wholesale_price() {
        return C_wholesale_price;
    }

    public String getC_Consumer_selling_price() {
        return C_Consumer_selling_price;
    }

    public String getY_id() {
        return Y_id;
    }
    
    
}
