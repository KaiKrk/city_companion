package com.oc.p12.Bean;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
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
        String nextPublicTransportDepartures = "";;
        System.out.println("prochain départ" +dto.getPublicTransport().getNextDepartures());
        if (!dto.getPublicTransport().getNextDepartures().isEmpty()){
            for (ScheduleDetail scheduleDetail : dto.getPublicTransport().getNextDepartures()
            ) {
            nextPublicTransportDepartures = nextPublicTransportDepartures.concat(scheduleDetail.getDestination() + " " + scheduleDetail.getMessage() + " / ");
            }
            System.out.println("email départ" +  nextPublicTransportDepartures);
        }

        return "<h1>Bonjour \n" + name +" </h1> <h2>Voici les informations du jour </h2>" + " " +
                "            <p>Date :+" + dto.getDate() +" </p>\n" +
                "            <h3>Meteo</h3>\n" +
                "            <p>Pluie : "+ dto.getWeather().getRain() +" (" + dto.getWeather().rainProbability+"%)</p>\n" +
                "            <p>Température : "+dto.getWeather().getTemperature() +"</p>\n" +
                "            <p>Température ressentie: "+dto.getWeather().getFeelsLike() +"</p>\n" +
                "            <h3>Qualite de l'air </h3>\n" +
                "            <p>Index : "+ dto.getAirQuality().getIndex()+"</p>\n" +
                "            <p>Qualité : "+ dto.getAirQuality().getQuality()+"</p>\n" +
                "            <p>Concentration de particules : </p>\n" +
                "            <p>PM2.5 : "+ dto.getAirQuality().getPm25() +" µg/m³" +"</p> <p>PM10 : "+ dto.getAirQuality().getPm10() +" µg/m³"+"</p>  <p>O2 : "+ dto.getAirQuality().getO3()+" µg/m³"+"</p>\n" +
                "            <h3>Condition de circulation</h3>\n" +
                "            <p>Temps de parcours normal : "+ dto.getCarTraffic().getTravelTime()+"</p>\n" +
                "            <p>Temps de parcours estimé actuel : "+ dto.getCarTraffic().getEstimatedTravelTime()+"</p>\n" +
                "            <h3>Condition du reseau de transport en commun</h3>\n" +
                "            <p>Ligne : "+nullChecker(dto.getPublicTransport().getTransportLine())+"</p>\n" +
                "            <p>Arret : "+ nullChecker(dto.getPublicTransport().getStation()) +"</p>\n" +
                "            <p class=\"card-text\">Etat de la ligne : "+ nullChecker(dto.getPublicTransport().getLineStatus())+"</p>\n" +
                "            <p class=\"card-text\">Prochains départ :   </p>\n" + nextPublicTransportDepartures;
    };

    public String getSubject() {
        return subject;
    }

    public String getSubjectAccountCreation() {
        return accountCreationSubject;
    }

    public String nullChecker(String value){
        System.out.println("value " + value);
        if (value == null){
            value = "Non référencé";
            return value;
        }
        return value;
    }
}
