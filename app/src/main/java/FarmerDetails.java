package com.example.govimithuru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FarmerDetails extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Farmerlist");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Farmeract, FarHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Farmeract, FarHolder>(Farmeract.class,R.layout.row2,FarHolder.class,mRef) {
            @Override
            protected void populateViewHolder(FarHolder viewHolder,Farmeract model, int position) {
                viewHolder.setAll(getApplicationContext(),model.getName(),model.getLocation(),model.getVegetable(),model.getImage(),model.getContact());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }}

class FarHolder extends RecyclerView.ViewHolder{


    private final Context context;

    View mView;



    public FarHolder( @NonNull final View itemView) {
        super(itemView);

        mView = itemView;
        context = itemView.getContext();

    }

    public void setAll(Context ctx,String name,String location,String vegetable,String image, String contact){
        TextView mNameTv = mView.findViewById(R.id.rName);
        TextView mloca = mView.findViewById(R.id.rLocation);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        TextView mEmailTv = mView.findViewById(R.id.rVegetables);
        TextView mnum = mView.findViewById(R.id.contact);


        mNameTv.setText(name);
        mloca.setText(location);
        mEmailTv.setText(vegetable);
        mnum.setText(contact);
        Picasso.with(ctx).load(image).into(mImageIv);


    }

}

