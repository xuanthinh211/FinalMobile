package eu.tutorials.fooduiapp.adapter;

import android.content.Context;
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
import eu.tutorials.fooduiapp.models.FeaturedModel;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FeaturedModel> featuredModels;

    public FeatureAdapter(Context context, ArrayList<FeaturedModel> featuredModels) {
        this.context = context;
        this.featuredModels = featuredModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeaturedModel featuredModel = featuredModels.get(position);
        holder.bind(featuredModel);
    }

    @Override
    public int getItemCount() {
        return featuredModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView feature_img;
        TextView feature_des, feature_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feature_des = itemView.findViewById(R.id.feature_des);
            feature_name = itemView.findViewById(R.id.feature_name);
            feature_img = itemView.findViewById(R.id.feature_img);
        }

        public void bind(FeaturedModel featuredModel) {
            feature_des.setText(featuredModel.getDes());
            feature_name.setText(featuredModel.getName());
            Glide.with(context).load(featuredModel.getImage()).into(feature_img);
        }
    }
}
