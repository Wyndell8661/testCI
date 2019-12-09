package com.example.demo.entities;

import com.example.demo.selector.MySelector;

public class Systems {
    public String ip;
    public String systemName;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return "Systems{" +
                "ip='" + ip + '\'' +
                ", systemName='" + systemName + '\'' +
                '}';
    }


}
