package com.example.cssemobileapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Patterns;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonUtils {

    /**
     * validate email addresses
     * @param target text box
     * @return
     */
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    /**
     * check password's stng levels
     * @param password
     * @return
     * @throws IllegalArgumentException
     */
    public static float getPasswordRating(String password) throws IllegalArgumentException {
        if (password == null) {throw new IllegalArgumentException();}
        int passwordStrength = 0;
        if (password.length() > 7) {passwordStrength++;} // minimal pw length of 6
        if (password.toLowerCase()!= password) {passwordStrength++;} // lower and upper case
        if (password.length() > 8) {passwordStrength++;} // good pw length of 9+
        int numDigits= validationUtils.getNumberDigits(password);
        if (numDigits > 0 && numDigits != password.length()) {passwordStrength++;} // contains digits and non-digits
        return (float)passwordStrength;
    }

    /**
     * Check internet connection is available or not
     * @param context
     * @return
     */
    public static boolean isInternetAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

        } catch (Exception e) {
            return false;
        }
    }

    public static String dateToStringFormat(Date date, String format){
        Format formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}
