package io.emailsender.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Date {
    
    public static String getNow() {
        // Obtém a data e hora atual
        LocalDateTime now = LocalDateTime.now();
        // Formatação da data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (O)");
        // Obtém o UTC como um offset fixo (UTC-3)
        ZoneOffset utcOffset = ZoneOffset.ofHours(-3);     
        // Combina a data e hora local com o offset específico para criar um OffsetDateTime
        OffsetDateTime offsetDateTime = now.atOffset(utcOffset); 
        // Formata a data e hora atual com o UTC
        String dateTimeWithUTC = offsetDateTime.format(formatter);
        // Exibe o resultado
        return dateTimeWithUTC;
    }
}
