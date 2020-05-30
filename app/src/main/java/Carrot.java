package com.example.govimithuru;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Carrot extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrot);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Carrot");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<carrotact, CarHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<carrotact, CarHolder>(carrotact.class,R.layout.row3,CarHolder.class,mRef) {
            @Override
            protected void populateViewHolder(CarHolder viewHolder,carrotact model, int position) {
                viewHolder.setAll(getApplicationContext(),model.getName(),model.getQuantity(),model.getPrice(),model.getLocation(),model.getExpire(),model.getImage());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
        //MenuItem item = menu.findItem(R.id.action_cart);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_cart) {
            startActivity(new Intent(getApplicationContext(), Checkout.class));
        }
        return super.onOptionsItemSelected(item);
    }}

 class CarHolder extends RecyclerView.ViewHolder{


     private final Context context;
    View mView;




     public CarHolder(@NonNull View itemView) {
         super(itemView);
         mView = itemView;
         context = itemView.getContext();
     }

     public void setAll(Context ctx,String name,String quantity,String price,String location, String expire, String image){
        TextView mNameTv = mView.findViewById(R.id.rName);
        TextView mloca = mView.findViewById(R.id.rqtty);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        TextView mprice = mView.findViewById(R.id.rprices);
        TextView mEmailTv = mView.findViewById(R.id.rLocations);
        TextView mexpire = mView.findViewById(R.id.rexp);



        mNameTv.setText(name);
        mloca.setText(quantity);
        mprice.setText(price);
        mEmailTv.setText(location);
        mexpire.setText(expire);
        Picasso.with(ctx).load(image).into(mImageIv);


    }


}
