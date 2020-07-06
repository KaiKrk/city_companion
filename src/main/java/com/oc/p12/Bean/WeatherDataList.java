package com.oc.p12.Bean;

import com.oc.p12.Entity.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataList {
    private List<Weather> weathers;

    public WeatherDataList() {
        weathers = new ArrayList<>();
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }
}
