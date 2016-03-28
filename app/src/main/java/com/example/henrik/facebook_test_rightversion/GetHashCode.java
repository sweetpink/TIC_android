package com.example.henrik.facebook_test_rightversion;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class GetHashCode extends Application {        //Klass bara för att få fram hashkod. Kommer inte att användas mer än det.

    public void onCreate(){
        super.onCreate();
        try {
            printHashKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void printHashKey() throws NoSuchAlgorithmException {
        try{
            PackageInfo info = getPackageManager().getPackageInfo("com.example.henrik.facebook_test_rightversion", PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures){
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Se hit:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
