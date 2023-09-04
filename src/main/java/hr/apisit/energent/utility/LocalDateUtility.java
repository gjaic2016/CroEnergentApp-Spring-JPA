package hr.apisit.energent.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class LocalDateUtility {

    public static final String DEFAULT_DATE_FORMAT = "dd.MM.yyyy.";

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

    public static LocalDate convertStringToLocalDate(String localDateString) {
        return LocalDate.parse(localDateString, formatter);

    }

    public static String convertlocalDateToString(LocalDate localDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        String formattedString = localDate.format(formatter);

        return formattedString;
    }

}
