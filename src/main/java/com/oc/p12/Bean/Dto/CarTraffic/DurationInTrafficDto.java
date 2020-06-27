package com.oc.p12.Bean.Dto.CarTraffic;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DurationInTrafficDto {

    private String text;
    private String value;

    public DurationInTrafficDto() {
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
        return "DurationInTrafficDto{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
