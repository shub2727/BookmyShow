package com.BookMyShow_User.Util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String to, String subject,String body){
        boolean isMailSend= false;
        try {
            MimeMessage createMessage= mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(createMessage);

            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom("BookmyShow.com");
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body,true);
            mailSender.send(createMessage);

            isMailSend= true;

        }catch (Exception e){
           e.printStackTrace();
        }




        return isMailSend;
    }


    public String readRegEmailBody(String fullName){
        String fileName="send.txt";

        String mailBody;
        try {
            FileReader fr= new FileReader("D:\\BookMyShow\\BookMyShow_User\\send.txt");
            BufferedReader br= new BufferedReader(fr);

            StringBuffer buffer= new StringBuffer();
            String line= br.readLine();
            while (line !=null){
                buffer.append(line);
                line= br.readLine();
            }

            br.close();

            mailBody= buffer.toString();
            mailBody= mailBody.replace("{FULLNAME}",fullName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mailBody;
    }
}
