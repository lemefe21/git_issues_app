package com.leme.gitissuesapp.handler;

import com.leme.gitissuesapp.R;
import java.io.IOException;
import retrofit2.HttpException;

public class ExceptionHandler {

    public static int FormatErrorToUi(Throwable throwable) {

        if(throwable instanceof HttpException) {
            return R.string.error_server;
        } else if(throwable instanceof IOException) {
            return R.string.error_network;
        } else {
            return R.string.error_unknown;
        }

    }

}
