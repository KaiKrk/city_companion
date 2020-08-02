package com.oc.p12.Bean.Dto.CarTraffic;

import java.util.List;

public class DistanceInformationDto {

    private List<DistanceElementsDto> elements;

    public DistanceInformationDto() {
    }

    public List<DistanceElementsDto> getElements() {
        return elements;
    }

    public void setElements(List<DistanceElementsDto> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "DistanceInformationDto{" +
                "elements=" + elements +
                '}';
    }
}
