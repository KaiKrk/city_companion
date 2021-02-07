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

/**
 * email service
 */
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

    /**
     * send email to confirm account creation
     * @param email
     * @throws Exception
     */
    public void sendAccountCreationSuccessMail(String email) throws Exception {

        Message message = prepareMessageForAccountCreation(getSession(), mailDetails.getMyAccountEmail(), email);
        Transport.send(message);

    }

    /**
     * send daily email to users with the informations of the day
     * @param email
     * @param accountId
     * @throws Exception
     */
    public void sendEmailDailyInformations(String email, int accountId) throws Exception {
        GeneralDashboardInformation dto = dashboardService.getDashboardInformations(accountId);
        String name = accountService.findById(accountId).getName();
        System.out.println(" email : " + mailDetails.getMyAccountEmail() + "  " + mailDetails.getPassword());
        Message message = prepareMessageForDailyInfo(getSession(), mailDetails.getMyAccountEmail(), email, name, dto);
        System.out.println(message);
        Transport.send(message);

    }

    /**
     * prepares message for account creation before sending
     * @param session
     * @param myAccountEmail
     * @param recepient
     * @return
     * @throws MessagingException
     */
    private Message prepareMessageForAccountCreation(Session session, String myAccountEmail, String recepient) throws MessagingException {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(mailDetails.getSubjectAccountCreation());
            message.setContent(mailDetails.getAccountCreationMessage(),"text/html; charset=UTF-8");
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * prepare message for daily informations before sending
     * @param session
     * @param myAccountEmail
     * @param recepient
     * @param name
     * @param dto
     * @return
     * @throws MessagingException
     */
    private Message prepareMessageForDailyInfo(Session session, String myAccountEmail, String recepient, String name, GeneralDashboardInformation dto) throws MessagingException {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(mailDetails.getSubject());
            message.setContent(mailDetails.getDailyHTMLMessage(name,dto), "text/html; charset=UTF-8");
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }
}
