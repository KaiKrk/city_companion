package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
import com.oc.p12.Bean.MailDetails;
import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    MailDetails mailDetails = new MailDetails();

    @Autowired
    DashboardService dashboardService;
    @Autowired
    AccountService accountService;

    public Properties getProperties (){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return properties;
    }

    public Session getSession(){
        Session session = Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailDetails.getMyAccountEmail(), mailDetails.getPassword());
            }
        });
        return session;
    }

    public void sendAccountCreationSuccessMail(String email) throws Exception {

        Message message = prepareMessage(getSession(), mailDetails.getMyAccountEmail(), email);
        System.out.println(message);
        Transport.send(message);

    }

    public void sendEmailDailyInformations(String email, int accountId) throws Exception {
        GeneralDashboardInformation dto = dashboardService.getDashboardInformations(accountId);
        String name = accountService.findById(accountId).getName();
        System.out.println(" email : " + mailDetails.getMyAccountEmail() + "  " + mailDetails.getPassword());
        Message message = prepareMessageForDailyInfo(getSession(), mailDetails.getMyAccountEmail(), email, name, dto);
        System.out.println(message);
        Transport.send(message);

    }

    private Message prepareMessage(Session session, String myAccountEmail, String recepient) throws MessagingException {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(mailDetails.getSubject());
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Message prepareMessageForDailyInfo(Session session, String myAccountEmail, String recepient, String name, GeneralDashboardInformation dto) throws MessagingException {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(mailDetails.getSubject());
            message.setContent(mailDetails.getDailyHTMLMessage(name,dto), "text/html");
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }
}
