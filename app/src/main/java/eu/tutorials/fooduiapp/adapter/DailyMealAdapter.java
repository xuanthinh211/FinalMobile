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
import eu.tutorials.fooduiapp.models.DailyMealModel;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {

    private Context context;
    ArrayList<DailyMealModel> dailyMealModelArrayList;

    public DailyMealAdapter(Context context, ArrayList<DailyMealModel> dailyMealModelArrayList) {
        this.context = context;
        this.dailyMealModelArrayList = dailyMealModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyMealModel dailyMealModel = dailyMealModelArrayList.get(position);
        holder.bind(dailyMealModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedDailyMealActivity.class);
                intent.putExtra("type", dailyMealModelArrayList.get(position).getType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dailyMealModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_description, txt_discount;
        ImageView img_food;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);
            txt_discount = (TextView) itemView.findViewById(R.id.txt_discount);
            img_food = itemView.findViewById(R.id.img_food);
        }

        public void bind(DailyMealModel dailyMealModel) {
            txt_name.setText(dailyMealModel.getName());
            txt_description.setText(dailyMealModel.getDescription());
            txt_discount.setText(dailyMealModel.getDiscount());
            Glide.with(context).load(dailyMealModel.getImage()).into(img_food);
        }
    }
}
