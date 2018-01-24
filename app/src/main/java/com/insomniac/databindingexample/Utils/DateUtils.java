package com.insomniac.databindingexample.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Sanjeev on 1/24/2018.
 */

public class DateUtils {

    private static final DateFormat DATE_FORMAT = DateFormat.getInstance();

    public static String formatDate(final Date date) {
        return DATE_FORMAT.format(date);
    }

    public static Date parseDate(final String dateString){
        try{
            return DATE_FORMAT.parse(dateString);
        }catch (ParseException p){
            return null;
        }
    }
}
