package com.example.encuesta_restaurante.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateFormatter {

    public LocalDate dateStringToLocalDate(String fecha){

        return fecha != null ? LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    public String LocalDateToStringDate(LocalDate fecha){
        return fecha !=null ? fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")):null;
    }
}
