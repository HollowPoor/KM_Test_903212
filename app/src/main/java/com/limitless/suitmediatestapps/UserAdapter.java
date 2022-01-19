package com.limitless.suitmediatestapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<UserDataModel> UserList;
    Context context;

    public UserAdapter(Context context, List<UserDataModel> User){
        this.context = context;
        UserList = User;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserDataModel userDataModel = UserList.get(position);
        holder.id.setText(userDataModel.getId());
        holder.FirstName.setText(userDataModel.getFirst_name());
        holder.LastName.setText(userDataModel.getLast_name());
        holder.Email.setText(userDataModel.getEmail());

    }

    @Override
    public int getItemCount() {
        return UserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView FirstName, LastName, Email,id;
        ImageView img;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            FirstName = itemView.findViewById(R.id.tvFirstName);
            LastName = itemView.findViewById(R.id.tvLastName);
            Email = itemView.findViewById(R.id.tvEmail);
            img = itemView.findViewById(R.id.icUSer);
            id = itemView.findViewById(R.id.tvId);
        }
    }
}
