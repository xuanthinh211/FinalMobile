package eu.tutorials.fooduiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.activity.DetailedDailyMealActivity;
import eu.tutorials.fooduiapp.models.DetailedDailyModel;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<DetailedDailyModel> detailedDailyModels;


    public DetailedDailyAdapter(Context mContext, ArrayList<DetailedDailyModel> detailedDailyModels) {
        this.mContext = mContext;
        this.detailedDailyModels = detailedDailyModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailedDailyModel detailedDailyModel = detailedDailyModels
                .get(position);
        holder.bind(detailedDailyModel);
    }

    @Override
    public int getItemCount() {
        return detailedDailyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_detailed_name, txt_description_detailed, detailed_rating, txt_time, detailed_price;
        ImageView detailed_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_detailed_name = (TextView) itemView.findViewById(R.id.txt_detailed_name);
            txt_description_detailed = (TextView) itemView.findViewById(R.id.txt_description_detailed);
            detailed_rating = (TextView) itemView.findViewById(R.id.detailed_rating);
            txt_time = (TextView) itemView.findViewById(R.id.txt_time);
            detailed_price = (TextView) itemView.findViewById(R.id.detailed_price);
            detailed_img = (ImageView) itemView.findViewById(R.id.detailed_img);
        }

        public void bind(DetailedDailyModel detailedDailyModel) {
            txt_detailed_name.setText(detailedDailyModel.getName());
            txt_description_detailed.setText(detailedDailyModel.getDescription());
            detailed_rating.setText(detailedDailyModel.getRatting());
            txt_time.setText(detailedDailyModel.getTiming());
            detailed_price.setText(detailedDailyModel.getPrice());
            Glide.with(mContext).load(detailedDailyModel.getImage()).into(detailed_img);

        }
    }
}
