package com.oc.p12.Bean;

import lombok.Data;

@Data
public class MailDetails {

    private  String myAccountEmail = "annalibraryoc@gmail.com";

    private  String password = "LibraryOCP7openclassrooms";

    private String subject = "Indicateur du jour";

    private String message = "Bonjour vous avez oublier de rendre votre livre veuillez nous le faire parvenir.\n Livre : ";

    private String cityCompanionMessage = "Bonjour un livre sur lequel vous etiez en liste d'attente est desormais disponible" +
            " veuillez venir le recuperer sous 48 heures sinon le livre ne vous sera plus reservé." +
            "\n Libre concerné : ";



    public String getSubject() {
        return subject;
    }
}
