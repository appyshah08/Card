package com.example.neeta.shaadi.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.neeta.shaadi.dao.UserProfileDao;
import com.example.neeta.shaadi.entity.Profile;

/**
 * Created by Neeta on 10/9/2019.
 */
@Database(entities = {Profile.class},version = 1,exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract UserProfileDao userProfileDao();

    public static synchronized AppDatabase getAppDatabaseInstance(Context context){
        if(appDatabase == null)
        {
           appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"profile-database").build();
        }
        return  appDatabase;
    }


}
