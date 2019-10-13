package com.example.neeta.shaadi.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.neeta.shaadi.entity.Profile;

import java.util.List;

/**
 * Created by Neeta on 10/9/2019.
 */

@Dao
public interface UserProfileDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAllEntry(List<Profile> profile);

   @Query("Select * from profile")
   List<Profile> getAllProfile();

   @Query("Select * from profile where status = :status")
    List<Profile> getAllProfileApproved(int status);

   @Query("Update profile set status=:status where uuid = :uuid")
    void update(String uuid,int status);
}
