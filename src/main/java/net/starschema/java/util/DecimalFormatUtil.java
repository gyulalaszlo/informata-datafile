/*
 * (C) 2015 Starschema
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package net.starschema.java.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Helper class for handling local-dependent decimal formats.
 *
 * Mainly useful for testing.
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
