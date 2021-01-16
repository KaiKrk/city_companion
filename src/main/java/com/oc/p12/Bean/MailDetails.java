package com.oc.p12.Bean;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
import com.oc.p12.Bean.Dto.Dashboard.WeatherDashboardDto;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.ScheduleDetail;
import lombok.Data;

@Data
public class MailDetails {

    private  String myAccountEmail = "annalibraryoc@gmail.com";

    private  String password = "LibraryOCP7openclassrooms";

    private String subject = "Indicateur du jour";

    private String accountCreationSubject = " Bienvenue chez City Companion";

    private String accountCreationMessage = " Nous vous confirmons que votre compte a bien été crée avec succès";

    private String dailyInfoHTMLMessage = "\"<h1>Bonjour \n" +
            "   HTML tags</h1>";

    public String getDailyHTMLMessage(String name, GeneralDashboardInformation dto){
        String nextPublicTransportDepartures = new String();
        if (!dto.getPublicTransport().getNextDepartures().isEmpty()){
            for (ScheduleDetail scheduleDetail : dto.getPublicTransport().getNextDepartures()
            ) {

            nextPublicTransportDepartures.concat(scheduleDetail.getDestination() + " " + scheduleDetail.getMessage());
            }
        }

        return "<h1>Bonjour \n" + name +" </h1> <h4>Voici les informations du jour </h4>" + " " +
                "            <p>Date :+" + dto.getDate() +" </p>\n" +
                "            <h5>Meteo</h5>\n" +
                "            <p>Pluie : "+ dto.getWeather().getRain() +" (" + dto.getWeather().rainProbability+"%)</p>\n" +
                "            <p>Température : "+dto.getWeather().getTemperature() +"</p>\n" +
                "            <p>Température ressentie: "+dto.getWeather().getFeelsLike() +"</p>\n" +
                "            <h5>Qualite de l'air </h5>\n" +
                "            <p>Index : "+ dto.getAirQuality().getIndex()+"</p>\n" +
                "            <p>Qualité : "+ dto.getAirQuality().getQuality()+"</p>\n" +
                "            <p>Concentration de particules : </p>\n" +
                "            <p>PM2.5 : "+ dto.getAirQuality().getPm25() +"</p> <p>PM10 : "+ dto.getAirQuality().getPm10() +"</p>  <p>O2 : "+ dto.getAirQuality().getO3()+"</p>\n" +
                "            <h5>Condition de circulation</h5>\n" +
                "            <p>Temps de parcours normal : "+ dto.getCarTraffic().getTravelTime()+"</p>\n" +
                "            <p>Temps de parcours estimé actuel : "+ dto.getCarTraffic().getEstimatedTravelTime()+"</p>\n" +
                "            <h5>Condition du reseau de transport en commun</h5>\n" +
                "            <p>Ligne : "+nullChecker(dto.getPublicTransport().getTransportLine())+"</p>\n" +
                "            <p>Arret : "+ nullChecker(dto.getPublicTransport().getStation()) +"</p>\n" +
                "            <p class=\"card-text\">Etat de la ligne : "+ nullChecker(dto.getPublicTransport().getLineStatus())+"</p>\n" +
                "            <p class=\"card-text\">Prochains départ :   </p>\n" + nextPublicTransportDepartures;
    };

    public String getSubject() {
        return subject;
    }

    public String nullChecker(String value){
        if (value.equalsIgnoreCase("null") | value.isEmpty() | value == null){
            value = "Non référencé";
            return value;
        }
        return value;
    }
}
