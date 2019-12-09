package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

public class SensitivePeople {

    private String priId;

    @Email(message = "不正确的主账号名称")
    private String priName;

    private String miId;

    private String miName;
    
    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public String getMiId() {
        return miId;
    }

    public void setMiId(String miId) {
        this.miId = miId;
    }

    public String getMiName() {
        return miName;
    }

    public void setMiName(String miName) {
        this.miName = miName;
    }

    @Override
    public String toString() {
        return "SensitivePeople{" +
                "priId='" + priId + '\'' +
                ", priName='" + priName + '\'' +
                ", miId='" + miId + '\'' +
                ", miName='" + miName + '\'' +
                '}';
    }
}
