package com.example.govimithuru;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final Context context;

    View mView;

    public LinearLayout linearLayout;

    public Holder( @NonNull final View itemView) {
        super(itemView);

        mView = itemView;
        context = itemView.getContext();
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
        // linearLayout = (LinearLayout) itemView.findViewById(R.id.layout);
    }

    public void setDetails(Context ctx,String vegetable,String image){
        TextView mTitleTv=mView.findViewById(R.id.rVeg);
        ImageView mImageIv=mView.findViewById(R.id.rImageView);



        mTitleTv.setText(vegetable);
        Picasso.with(ctx).load(image).into(mImageIv);


    }


    @Override
    public void onClick(View v) {
        final Intent intent ;
        switch (getAdapterPosition()) {
            case 0 :
                intent = new Intent(context, Carrot.class);
                break;
          
            default:
                intent=new Intent(context, Error.class);
                break;
        }
        context.startActivity(intent);
    }
}


