/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_Suppliers_Customers {

    private String S_id, S_name, S_address, Y_id, den, state_den;
    private String C_id, C_name, C_address, C_den, C_state_den;

    public Data_Suppliers_Customers(String S_id, String S_name, String S_address, String den, String state_den) {
        this.S_id = S_id;
        this.S_name = S_name;
        this.S_address = S_address;
        this.den = den;
        this.state_den = state_den;
    }

    public Data_Suppliers_Customers(String C_id, String C_name, String C_address, String C_den, String C_state_den, int x) {
        this.C_id = C_id;
        this.C_name = C_name;
        this.C_address = C_address;
        this.C_den = C_den;
        this.C_state_den = C_state_den;
    }

    public void setC_id(String C_id) {
        this.C_id = C_id;
    }

    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    public void setC_address(String C_address) {
        this.C_address = C_address;
    }

    public void setC_den(String C_den) {
        this.C_den = C_den;
    }

    public void setC_state_den(String C_state_den) {
        this.C_state_den = C_state_den;
    }

    public String getC_id() {
        return C_id;
    }

    public String getC_name() {
        return C_name;
    }

    public String getC_address() {
        return C_address;
    }

    public String getC_den() {
        return C_den;
    }

    public String getC_state_den() {
        return C_state_den;
    }

    public void setS_id(String S_id) {
        this.S_id = S_id;
    }

    public void setS_name(String S_name) {
        this.S_name = S_name;
    }

    public void setS_address(String S_address) {
        this.S_address = S_address;
    }

    public void setY_id(String Y_id) {
        this.Y_id = Y_id;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public void setState_den(String state_den) {
        this.state_den = state_den;
    }

    public String getS_id() {
        return S_id;
    }

    public String getS_name() {
        return S_name;
    }

    public String getS_address() {
        return S_address;
    }

    public String getY_id() {
        return Y_id;
    }

    public String getDen() {
        return den;
    }

    public String getState_den() {
        return state_den;
    }

}
