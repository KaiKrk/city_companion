package com.oc.p12.Bean.Dto.CarTraffic;

public class DistanceDto {

    private String text;
    private String value;

    public DistanceDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DistanceDto{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
