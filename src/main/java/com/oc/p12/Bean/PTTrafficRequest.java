package com.oc.p12.Bean;

public class PTTrafficRequest {

    public int line;

    public PTTrafficRequest(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "PTTrafficRequest{" +
                "line=" + line +
                '}';
    }
}
