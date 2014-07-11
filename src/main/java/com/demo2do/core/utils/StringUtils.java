package com.demo2do.core.utils;

import java.util.Map;

/**
 * String related utilities
 */
public abstract class StringUtils {

    /**
     * Replace place holder with parameters
     *
     * @param template
     * @param valueMap
     * @return
     */
    public static String replacePlaceHolder(String template, Map<String, String> valueMap) {

        if (template.indexOf("${") == -1) {
            return template;
        }

        while (true) {
            int start = template.indexOf("${");
            int end = template.indexOf("}", start);

            if (start != -1 && end != -1) {
                String temp = template.substring(start + 2, end);

                if (valueMap.keySet().contains(temp)) { // contains the dynamic string then replace
                    template = template.substring(0, start) + (String) valueMap.get(temp) + template.substring(end + 1);
                } else {
                    template = template.substring(0, start) + template.substring(end + 1);
                }

            } else {
                break;
            }
        }

        return template;
    }

    /**
     * Determine a template has a placeHolder
     *
     * @param template the input string
     * @return result
     */
    public static boolean hasPlaceHolder(String template) {
        if (template.indexOf("${") == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Determine a string is template string
     *
     * @param string the input string
     * @return result
     */
    public static boolean isTempateString(String string) {
        if (string.indexOf("{") == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Connect strings together
     *
     * @param parts the input string(s)
     * @return the connected result
     */
    public static String connect(String... parts) {
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(part);
        }
        return sb.toString();
    }

    /**
     * camelize seperated strings together
     *
     * @param parts the input string(s)
     * @return the camelized result
     */
    public static String camelize(String... parts) {
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(org.apache.commons.lang.StringUtils.capitalize(part));
        }
        return org.apache.commons.lang.StringUtils.uncapitalize(sb.toString());
    }

    /**
     * Convert camel naming to any naming using seperator
     *
     * @param template the input string
     * @param seperator the seperator
     * @return converted string
     */
    public static String convertCamel(String template, String seperator) {
        StringBuilder result = new StringBuilder();
        if (template != null && template.length() > 0) {
            result.append(template.substring(0, 1).toLowerCase());
            for (int i = 1; i < template.length(); i++) {
                String s = template.substring(i, i + 1);
                if (s.equals(s.toUpperCase()) && !s.equals(seperator)) {
                    result.append(seperator);
                    result.append(s.toLowerCase());
                } else {
                    result.append(s);
                }
            }
        }
        return result.toString();
    }

    /**
     * Gets the leftmost len characters of a String.
     *
     * @param string the input string
     * @param length the length
     * @return result
     */
    public static String left(String string, int length) {
        return org.apache.commons.lang.StringUtils.left(string, length);
    }

    /**
     * split input string using separator
     *
     * @param string the input string
     * @param separator the separator string
     * @return split string array
     */
    public static String[] split(String string, String separator) {
        return org.apache.commons.lang.StringUtils.split(string, separator);
    }

    /**
     * Find parameter value from uri
     *
     * @param uri the uri to look up
     * @param param the parameter name
     * @return parameter value
     */
    public static String findParameterFromURI(String uri, String param) {
        for(String nameValuePair : org.apache.commons.lang.StringUtils.split(uri.substring(uri.indexOf("?") + 1), "&")) {
            if(nameValuePair.startsWith(param + "=")) {
                return nameValuePair.substring(nameValuePair.indexOf("=") + 1);
            }
        }
        return null;
    }

    /**
     * Checks if a String is empty ("") or null.
     *
     * @param string the input string
     * @return result
     */
    public static boolean isEmpty(String string) {
        return org.apache.commons.lang.StringUtils.isEmpty(string);
    }
}
