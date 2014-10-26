package test.com.testapplication.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * A class that holds all simple utility methods for network operations,
 * to avoid boiler plate code.
 *
 * Created by abhijitnukalapati on 10/26/14.
 */
public class NetworkUtil {
    /**
     * Uses {@link android.net.ConnectivityManager} to determine if a network
     * connection is available
     * @param context a Context object
     * @return {@code true} if the network is available, {@code false} otherwise
     */
    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }
}
