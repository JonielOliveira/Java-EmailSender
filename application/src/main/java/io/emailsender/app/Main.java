package io.emailsender.app;

import io.emailsender.utils.EmailSender;
import io.emailsender.utils.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) {
        
        BufferedReader reader = null;
        String sendTo = "";
        String subject = "";
        String content = "";
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

            System.out.println("Para: ");
            sendTo = reader.readLine();
            
            System.out.println("Assunto: ");
            subject = reader.readLine();
        
            System.out.println("Conteúdo: ");
            content = reader.readLine();

        } catch (UnsupportedEncodingException e) {
            System.err.println("Erro: a codificação UTF-8 não é suportada.");
        } catch (IOException e) {
            System.err.println("Erro: ao ler a entrada do usuário.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Erro: ao fechar o BufferedReader.");
                }
            }
        }
        
        if (!content.isEmpty()) {
            String dateNow = Date.getNow();
            content = content.concat("\nEnviado em: " + dateNow);    
            
            try {
                EmailSender.sendEmail(sendTo, subject, content);
                System.out.println("Status: o e-mail foi enviado com sucesso!");
            } catch (MessagingException e) {
                System.out.println("Status: o e-mail não foi enviado. Erro de conexão!");
            }
        }
    }
}
