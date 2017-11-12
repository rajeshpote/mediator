/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016. Toggle INC and/or its affiliates. All rights reserved.
 * TOGGLE INC PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.command.mediator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on 06/12/2016, 12:20 PM
 * StringUtils.java
 *
 * @author vicky
 */

public class StringUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);


    static final byte[] HEX_CHAR_TABLE = {
            (byte) '0', (byte) '1', (byte) '2', (byte) '3',
            (byte) '4', (byte) '5', (byte) '6', (byte) '7',
            (byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
            (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
    };

    static NumberFormat twoDigitNumber = NumberFormat.getInstance();
    static NumberFormat threeDigitNumber = NumberFormat.getInstance();
    static NumberFormat fourDigitNumber = NumberFormat.getInstance();

    static {
        twoDigitNumber.setGroupingUsed(false);
        twoDigitNumber.setMinimumIntegerDigits(2);

        threeDigitNumber.setGroupingUsed(false);
        threeDigitNumber.setMinimumIntegerDigits(3);

        fourDigitNumber.setGroupingUsed(false);
        fourDigitNumber.setMinimumIntegerDigits(4);
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] split(String str1, String str2) {
        return org.springframework.util.StringUtils.split(str1, str2);
    }

    public static String replace(String src, String target, String rWith) {
        return org.springframework.util.StringUtils.replace(src, target, rWith);
    }

    public static boolean equals(String str1, String str2) {
        return org.springframework.util.StringUtils.pathEquals(str1, str2);
    }

    /**
     * replace all commas with spaces
     *
     * @param l
     * @return
     */
    public static String commaToSpace(String l) {
        return l.replaceAll(",", " ");
    }

    public static String getHexString(byte[] raw) throws UnsupportedEncodingException {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
            int v = b & 0xFF;
            hex[index++] = HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }
        return new String(hex, "ASCII");
    }

    public static String arrayToString(String[] a, String separator) {
        StringBuffer result = new StringBuffer();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i = 1; i < a.length; i++) {
                result.append(separator);
                result.append(a[i]);
            }
        }
        return result.toString();
    }

    public static List stringToList(String str, String separator) {
        if (isNotEmpty(str)) {
            return Arrays.asList(split(str, separator));
        }
        return Collections.emptyList();
    }

    public static String[] stringToArray(String str, String separator) {
        String[] result = null;
        if (isNotEmpty(str)) {
            result = split(str, separator);
        }
        return result;
    }

    public static String to2Digits(int value) {
        return twoDigitNumber.format(value);
    }

    public static String to3Digits(int value) {
        return threeDigitNumber.format(value);
    }

    public static String to4Digits(int value) {
        return fourDigitNumber.format(value);
    }

    public static String to4Digits(String value, int lowValue, int def) {
        int v;
        try {
            v = isNotEmpty(value) ? Integer.parseInt(value) : def;
            if (v < lowValue)
                v = def;
        } catch (Exception e) {
            v = def;
        }
        return to4Digits(v);
    }

    public static String encodeStringToUTF8(String value) {
        try {
            value = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error encoding string to UTF-8 " + e);
        }

        return value;
    }

    public static String detectLanguage(String inputString) {
        String english2LetterCode = "en";
        String arabic2LetterCode = "ar";
        if (isNotEmpty(inputString)) {
            //get the first alphabet of the word check for arabic range.
            int c = inputString.codePointAt(0);
            if (c >= 0x0621 && c <= 0x064A) {
                return arabic2LetterCode;
            }
        }
        return english2LetterCode;
    }

}
