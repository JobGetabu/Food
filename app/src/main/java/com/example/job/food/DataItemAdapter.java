package com.example.job.food;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.job.food.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by JOB on 8/26/2017.
 */

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.DataItemViewHolder> {

    List<DataItem> dataItemList ;
    Context mContext;

    public DataItemAdapter(List<DataItem> dataItemList, Context mContext) {
        this.dataItemList = dataItemList;
        this.mContext = mContext;
    }

    @Override
    public DataItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.food_entry, parent,false);
        DataItemViewHolder dataItemViewHolder = new DataItemViewHolder(view);

        return dataItemViewHolder;
    }

    Locale locale = Locale.getDefault();
    NumberFormat formatMoney = NumberFormat.getCurrencyInstance(locale);
    int mExpandedPosition = -1;

    @Override
    public void onBindViewHolder(final DataItemViewHolder holder, final int position) {

        //DataItem dataItem = new DataItem();
        holder.foodName.setText(dataItemList.get(position).getItemName());
        holder.foodDescription.setText(dataItemList.get(position).getDescription());
        holder.price.setText(String.valueOf(formatMoney.format(dataItemList.get(position).getPrice())));
        String imageFile = dataItemList.get(position).getImage();
        try {
            InputStream stream = mContext.getAssets().open(imageFile);
            Drawable drawable = Drawable.createFromStream(stream, imageFile);
            holder.imageFood.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }



        final boolean isExpanded = position==mExpandedPosition;
        holder.foodDescription.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);

        holder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(holder.cardView);
                mExpandedPosition = isExpanded ? -1:position;
                if (mExpandedPosition == position){
                    holder.moreInfo.setText(mContext.getText(R.string.less_info));
                }else {
                    holder.moreInfo.setText(mContext.getText(R.string.more_info));
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public class DataItemViewHolder extends RecyclerView.ViewHolder {

        TextView price;
        ImageView imageFood;
        TextView foodName;
        TextView foodDescription;
        CardView cardView;
        View mView;
        TextView moreInfo;
        public DataItemViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            price = (TextView)mView.findViewById(R.id.price);
            imageFood = (ImageView) mView.findViewById(R.id.image_food);
            foodName = (TextView) mView.findViewById(R.id.tv_item_name);
            foodDescription = (TextView) mView.findViewById(R.id.tv_item_description);
            cardView= (CardView) mView.findViewById(R.id.food_entry);
            moreInfo = (TextView) mView.findViewById(R.id.more_info);
        }
    }
}
