package com.example.admin.practice;

/**
 * Created by Admin on 27-Sep-16.
 */
public class Device {
    private String frame;
    private String flight_cont;
    private String name;
    private String motor;
    private String esc;
    private String battery;
    private String fpv;
    private String vtx;




    public Device(String name, String frame, String flight_cont, String motor,String esc,String battery,String fpv,String vtx){
        this.setFrame(frame);
        this.setFlight_cont(flight_cont);
        this.setName(name);
        this.setMotor(motor);
        this.setEsc(esc);
        this.setBattery(battery);
        this.setFpv(fpv);
        this.setVtx(vtx);

    }

    private void setName(String name) {
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFlight_cont() {
        return flight_cont;
    }

    public void setFlight_cont(String flight_cont) {
        this.flight_cont = flight_cont;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getEsc() {
        return esc;
    }

    public void setEsc(String esc) {
        this.esc = esc;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getVtx() {
        return vtx;
    }

    public void setVtx(String vtx) {
        this.vtx = vtx;
    }

    public String getFpv() {
        return fpv;
    }

    public void setFpv(String fpv) {
        this.fpv = fpv;
    }
}
