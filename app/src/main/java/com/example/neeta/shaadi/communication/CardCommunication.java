package com.example.neeta.shaadi.communication;

import com.example.neeta.shaadi.entity.Profile;

import java.util.List;

/**
 * Created by Neeta on 10/11/2019.
 */

public interface CardCommunication {

    public void callSelectQuery(int call);

    public void setAdapter(List<Profile> profiles);

    public void updateProfile(String uuid,int status);

}
