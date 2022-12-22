/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Date_InStore {

    private String id, dat, mony, state, nots, Y_id;

    public Date_InStore(String id, String dat, String mony, String state, String nots) {
        this.id = id;
        this.dat = dat;
        this.mony = mony;
        this.state = state;
        this.nots = nots;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public void setMony(String mony) {
        this.mony = mony;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setNots(String nots) {
        this.nots = nots;
    }

    public void setY_id(String Y_id) {
        this.Y_id = Y_id;
    }

    public String getId() {
        return id;
    }

    public String getDat() {
        return dat;
    }

    public String getMony() {
        return mony;
    }

    public String getState() {
        return state;
    }

    public String getNots() {
        return nots;
    }

    public String getY_id() {
        return Y_id;
    }

}
