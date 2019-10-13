package com.example.neeta.shaadi.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.example.neeta.shaadi.database.AppDatabase;

/**
 * Created by Neeta on 10/9/2019.
 */

public class UpdateProfileData extends AsyncTask<Void, Void, Void> {

    AppDatabase ap;
    String uuid;
    Context context;
    int status;

    public UpdateProfileData(AppDatabase ap, Context context,String uuid,int status) {
        this.ap = ap;
        this.context = context;
        this.uuid = uuid;
        this.status = status;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        ap.userProfileDao().update(uuid, status);
        return null;

    }
}



