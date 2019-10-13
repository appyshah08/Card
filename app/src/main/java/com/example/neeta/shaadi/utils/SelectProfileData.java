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

public class SelectProfileData extends AsyncTask<Void,Void,List<Profile>> {

    AppDatabase ap;
    Profile profile;
    Context context;

    public SelectProfileData(AppDatabase ap, Context context)
    {
        this.ap=ap;
        this.context=context;
    }


    @Override
    protected List<Profile> doInBackground(Void... voids) {
        return ap.userProfileDao().getAllProfileApproved(Constant.STATUS_APPROVED);

    }


    @Override
    protected void onPostExecute(List<Profile> profiles) {
        ((MainActivity)context).setAdapter(profiles);
    }
}
