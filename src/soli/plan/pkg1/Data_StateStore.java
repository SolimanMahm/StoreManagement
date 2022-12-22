/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soli.plan.pkg1;

/**
 *
 * @author DELL
 */
public class Data_StateStore {

    private String id, state;

    public Data_StateStore(String id, String state) {
        this.state = state;
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(String id) {
        this.id = id;
    }

}
