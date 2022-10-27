package com.example.springdemo.bean.annotation.property.many.ex;

public class ServerInfo {
    private String ipNum;
    private String portNum;

    public ServerInfo(String ipNum, String portNum) {
        this.ipNum = ipNum;
        this.portNum = portNum;
    }

    public String getIpNum() {
        return ipNum;
    }

    public void setIpNum(String ipNum) {
        this.ipNum = ipNum;
    }

    public String getPortNum() {
        return portNum;
    }

    public void setPortNum(String portNum) {
        this.portNum = portNum;
    }
}
