package com.example.neeta.shaadi.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.example.neeta.shaadi.activity.MainActivity;
import com.example.neeta.shaadi.database.AppDatabase;
import com.example.neeta.shaadi.entity.Profile;

import java.util.List;

/**
 * Created by Neeta on 10/9/2019.
 */

public class InsertProfileData extends AsyncTask<Void,Void,Boolean> {

    AppDatabase ap;
    List<Profile> profile;
    Context context;

    public InsertProfileData(AppDatabase ap, List<Profile> profile, Context context)
    {
        this.ap=ap;
        this.profile=profile;
        this.context = context;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        ap.userProfileDao().insertAllEntry(profile);
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        ((MainActivity)context).callSelectQuery(1);
    }
}
