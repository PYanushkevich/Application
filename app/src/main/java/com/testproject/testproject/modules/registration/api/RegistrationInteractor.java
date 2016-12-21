package com.testproject.testproject.modules.registration.api;

import android.content.Context;
import android.os.CountDownTimer;

/**
 * Created by AlexanderFomich on 21.12.16.
 */

public class RegistrationInteractor {

    public interface Callback {
        void onSuccess();
        void onError(final String error);
    }


    public static void sendRegistrationRequest(final Context context, final String username, final Callback callback) {
        //Imitate request
        final CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                callback.onSuccess();
            }
        }.start();
    }

}
