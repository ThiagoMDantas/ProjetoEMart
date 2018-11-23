/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author paulojca
 */
public class Email {

    
    
    public boolean enviar(String nome,String emailto) {

        try {
            Properties props = System.getProperties();

            String from = "emart.tads@gmail.com";
            String host = "smtp.gmail.com";
            String pass = "emart@123";
          

            String to = emailto; //aqui sera o email para quem vc vai enviar a mensagem

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            // To get the array of addresses
            InternetAddress obj = new InternetAddress(to);

            message.addRecipient(Message.RecipientType.TO, obj);
            
            message.setSubject("Bem vindo a Emart");
                        
            message.setContent("<html><body><h1>Olá, " + nome + "</h1><h2>Seja bem vindo(a) ao nosso sistema EMart Supermercados...</h2><p><a href='localhost:8080/ControleHome'> clique aqui </a></p></body></html>", "text/html; charset=utf-8");

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (AddressException ae) {
            ae.printStackTrace();
            return false;
        } catch (MessagingException me) {
            me.printStackTrace();
            return false;
        }
    }

}
