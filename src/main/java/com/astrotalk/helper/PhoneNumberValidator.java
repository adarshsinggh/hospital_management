package com.astrotalk.helper;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final String PHONE_NUMBER_REGEX = "\\d{10}"; // Assuming 10-digit phone number format

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        return pattern.matcher(phoneNumber).matches();
    }
}