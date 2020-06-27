package com.oc.p12.Bean.Dto.CarTraffic;

public class DurationDto {

    private String text;
    private String value;

    public DurationDto() {
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
        return "DurationDto{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
