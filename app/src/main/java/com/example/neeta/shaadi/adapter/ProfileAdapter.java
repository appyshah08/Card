package com.example.neeta.shaadi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.neeta.shaadi.R;
import com.example.neeta.shaadi.activity.MainActivity;
import com.example.neeta.shaadi.entity.Profile;
import com.example.neeta.shaadi.utils.Constant;

import java.util.List;

/**
 * Created by Neeta on 10/12/2019.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewholder>{

    private List<Profile> profileList;
    private Context context;

    ProfileAdapter(List<Profile> profiles, Context context)
    {
        this.profileList=profiles;
        this.context=context;
    }


    @Override
    public ProfileAdapter.ProfileViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ProfileViewholder holder, int position) {
       Profile profile = profileList.get(position);
       holder.tvName.setText(profile.getFirstName()+" "+profile.getLastName());
       holder.tvAge.setText(profile.getAge());
       holder.tvCity.setText(profile.getCity());
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


    public class ProfileViewholder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvAge;
        TextView tvCity;
        RelativeLayout rlAccept;
        RelativeLayout rlReject;
        ImageView ivReject;
        ImageView ivAccept;

        public ProfileViewholder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvCity = itemView.findViewById(R.id.tvCity);
            rlAccept = itemView.findViewById(R.id.rlAccept);
            rlAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   ivAccept.setBackground(context.getResources().getDrawable(R.drawable.accept_green));
                   profileList.get(getAdapterPosition()).setStatus(Constant.STATUS_APPROVED);
                   ((MainActivity)context).updateProfile(profileList.get(getAdapterPosition()).getUuid(), Constant.STATUS_APPROVED);
                }
            });
            rlReject = itemView.findViewById(R.id.rlReject);
            rlReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   ivReject.setBackground(context.getResources().getDrawable(R.drawable.reject_red));
                   profileList.get(getAdapterPosition()).setStatus(Constant.STATUS_PENDING);
                    ((MainActivity)context).updateProfile(profileList.get(getAdapterPosition()).getUuid(), Constant.STATUS_PENDING);
                }
            });
            ivAccept = itemView.findViewById(R.id.ivAccept);
            ivReject = itemView.findViewById(R.id.ivReject);
        }


    }

}
