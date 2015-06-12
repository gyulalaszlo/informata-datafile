package net.starschema.java.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * (C) 2015 Starschema
 * All rights reserverd.
 * ---------------------
 */
public class DecimalFormatUtil {
    /** Creates a new DecimalFormat using comming dot as a separator so local
     * decimal serparators dont matter
     * @param pattern   The pattern to use
     * @return  A new DecimalFormat with the dot as separator
     */
    public static DecimalFormat createDecimalFormat(final String pattern) {
        return createDecimalFormat(pattern, '.');
    }

    /**
     * Generic function to create a decimalformat with a specified decimal separator.
     */
    public static DecimalFormat createDecimalFormat(final String pattern, final char decimalSeparator) {
        DecimalFormatSymbols custom=new DecimalFormatSymbols();
        custom.setDecimalSeparator(decimalSeparator);
        DecimalFormat format = new DecimalFormat(pattern);
        format.setDecimalFormatSymbols(custom);
        return format;
    }

    /** Shortcut to get the decimal separator for tests. */
    public static char getDecimalSeparator() {
        DecimalFormatSymbols custom=new DecimalFormatSymbols();
        return custom.getDecimalSeparator();
    }

    public static String getDecimalFormatted(String englishFormat)
    {
        final char decimalSep = getDecimalSeparator();
        final String wrapStr = decimalSep == ',' ? "\"" : "";
        return wrapStr + englishFormat.replace('.', decimalSep) + wrapStr;
    }

    public static String getDecimalFormattedNoQuote(String englishFormat)
    {
        return  englishFormat.replace('.', getDecimalSeparator());
    }
}
