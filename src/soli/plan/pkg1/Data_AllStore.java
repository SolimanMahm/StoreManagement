/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_AllStore {

    private String data, in_mony, out_mony;

    public Data_AllStore(String data, String in_mony, String out_mony) {
        this.data = data;
        this.in_mony = in_mony;
        this.out_mony = out_mony;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIn_mony(String in_mony) {
        this.in_mony = in_mony;
    }

    public void setOut_mony(String out_mony) {
        this.out_mony = out_mony;
    }

    public String getData() {
        return data;
    }

    public String getIn_mony() {
        return in_mony;
    }

    public String getOut_mony() {
        return out_mony;
    }

}
