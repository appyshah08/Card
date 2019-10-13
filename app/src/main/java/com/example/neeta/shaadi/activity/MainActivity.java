package com.example.neeta.shaadi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.neeta.shaadi.R;
import com.example.neeta.shaadi.communication.CardCommunication;
import com.example.neeta.shaadi.database.AppDatabase;
import com.example.neeta.shaadi.entity.Profile;
import com.example.neeta.shaadi.model.JsonResponseGetResult;
import com.example.neeta.shaadi.model.Result;
import com.example.neeta.shaadi.utils.Constant;
import com.example.neeta.shaadi.utils.InsertProfileData;
import com.example.neeta.shaadi.utils.RetrofitInstance;
import com.example.neeta.shaadi.utils.RetrofitService;
import com.example.neeta.shaadi.utils.SelectProfileData;
import com.example.neeta.shaadi.utils.UpdateProfileData;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CardCommunication{

    public static int page = 10;
    public List<Profile> profileList;
    private RecyclerView rvCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCardView = (RecyclerView)findViewById(R.id.rvCardView);
        serviceCall();
    }


    public void serviceCall()
    {
        RetrofitService retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<JsonResponseGetResult> call= retrofitService.getProfileList(page);
        call.enqueue(new Callback<JsonResponseGetResult>() {
            @Override
            public void onResponse(Call<JsonResponseGetResult> call, Response<JsonResponseGetResult> response) {
                   if(response!=null && response.body()!=null)
                   {
                       if(response.body().getResults()!=null &&
                               response.body().getResults().size()>=1) {
                           List<Result> results = response.body().getResults();
                           List<Profile> profileList=new ArrayList<Profile>();
                           for(int i=0;i<results.size();i++)
                           {
                               Profile profile=new Profile();
                               if(results.get(i).getLogin()!=null
                                       && results.get(i).getLogin().getUuid()!=null
                                       && !results.get(i).getLogin().getUuid().isEmpty())
                               {
                                   profile.setUuid(results.get(i).getLogin().getUuid());
                               }
                               if(results.get(i).getDob()!=null
                                       && results.get(i).getDob().getAge()!=null)
                               {
                                   profile.setAge(results.get(i).getDob().getAge());
                               }
                               if(results.get(i).getGender()!=null
                                       && !results.get(i).getGender().isEmpty())
                               {
                                   profile.setGender(results.get(i).getGender());
                               }
                               if(results.get(i).getName()!=null
                                       && results.get(i).getName().getFirst()!=null
                                       && !results.get(i).getName().getFirst().isEmpty())
                               {
                                   profile.setFirstName(results.get(i).getName().getFirst());
                               }
                               if(results.get(i).getName()!=null
                                       && results.get(i).getName().getLast()!=null
                                       && !results.get(i).getName().getLast().isEmpty())
                               {
                                   profile.setLastName(results.get(i).getName().getLast());
                               }
                               if(results.get(i).getLocation()!=null
                                       && results.get(i).getLocation().getState()!=null
                                       && !results.get(i).getLocation().getState().isEmpty())
                               {
                                   profile.setState(results.get(i).getLocation().getState());
                               }
                               if(results.get(i).getLocation()!=null
                                       && results.get(i).getLocation().getCity()!=null
                                       && !results.get(i).getLocation().getCity().isEmpty())
                               {
                                   profile.setCity(results.get(i).getLocation().getCity());
                               }
                               if(results.get(i).getLocation()!=null
                                       && results.get(i).getLocation().getCountry()!=null
                                       && !results.get(i).getLocation().getCountry().isEmpty())
                               {
                                   profile.setCountry(results.get(i).getLocation().getCountry());
                               }
                               if(results.get(i).getPicture()!=null
                                       && results.get(i).getPicture().getLarge()!=null
                                       && !results.get(i).getPicture().getLarge().isEmpty())
                               {
                                   profile.setCountry(results.get(i).getPicture().getLarge());
                               }
                               profile.setStatus(Constant.STATUS_PENDING);
                               profileList.add(profile);

                           }
                       }
                       insertDataInTable(profileList);
                   }
            }

            @Override
            public void onFailure(Call<JsonResponseGetResult> call, Throwable t) {
                   Log.d("error","Error occured");
            }
        });
    }

    public void insertDataInTable(List<Profile> list)
    {
           new InsertProfileData(AppDatabase.getAppDatabaseInstance(MainActivity.this),list,MainActivity.this).execute();
    }

    public void callSelectQuery(int call){
         new SelectProfileData(AppDatabase.getAppDatabaseInstance(MainActivity.this),MainActivity.this).execute();
    }


    public void setAdapter(List<Profile> profiles) {
        LinearLayoutManager ll = new LinearLayoutManager(this);

    }

    public void updateProfile(String uuid,int status){
        new UpdateProfileData(AppDatabase.getAppDatabaseInstance(MainActivity.this),MainActivity.this,uuid,status).execute();
    }

}
