package ru.nikartm.calendarevent.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Ivan Vodyasov on 11.07.2017.
 */

public class Utils {

    /**
     * @param date for formatting
     * @return formatted date to view
     */
    public static String getDateTimeEvent(long date) {
        return new SimpleDateFormat("dd.MM.yyyy - HH:mm", Locale.ENGLISH).format(new Date(date));
    }

    /**
     * Checks whether the device currently has a network connection.
     * @return true if the device has a network connection, false otherwise.
     */
    public static boolean isDeviceOnline(Context ctx) {
        ConnectivityManager connMgr =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
