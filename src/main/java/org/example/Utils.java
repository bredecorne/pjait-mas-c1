package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date createDate(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    }

    public static void checkIfNull(Object... values) throws NullPointerException {
        for (Object value : values) {
            if (value == null) {
                throw new NullPointerException("Null value is not allowed.");
            }
            if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    throw new NullPointerException("Empty value is not allowed.");
                }
            }
        }
    }
}
