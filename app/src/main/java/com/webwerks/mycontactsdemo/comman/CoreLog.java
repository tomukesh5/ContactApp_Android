package com.webwerks.mycontactsdemo.comman;

import android.util.Log;


/**
 * Created by webwerks on 24/01/18.
 */

public class CoreLog {
    private static final boolean DEBUG_MODE=true;//false;//true;
    public static void e(String tag, String msg){
        if(DEBUG_MODE) {
            Log.e(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(DEBUG_MODE) {
            Log.d(tag, msg);
        }
    }
}
