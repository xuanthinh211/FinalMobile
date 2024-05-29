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
import eu.tutorials.fooduiapp.models.FeaturedVerModel;

public class FeaturedVerAdapter extends RecyclerView.Adapter<FeaturedVerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FeaturedVerModel> featuredVerModelArrayList;

    public FeaturedVerAdapter(Context context, ArrayList<FeaturedVerModel> featuredVerModelArrayList) {
        this.context = context;
        this.featuredVerModelArrayList = featuredVerModelArrayList;
    }

    @NonNull
    @Override
    public FeaturedVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_ver_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedVerAdapter.ViewHolder holder, int position) {
        FeaturedVerModel featuredVerModel = featuredVerModelArrayList.get(position);
        holder.bind(featuredVerModel);
    }

    @Override
    public int getItemCount() {
        return featuredVerModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc, ratting, timing;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_detailed_name);
            desc = itemView.findViewById(R.id.txt_description_detailed);
            ratting = itemView.findViewById(R.id.detailed_rating);
            timing = itemView.findViewById(R.id.txt_time);
            imageView = itemView.findViewById(R.id.detailed_img);
        }

        public void bind(FeaturedVerModel featuredVerModel) {
            name.setText(featuredVerModel.getName());
            desc.setText(featuredVerModel.getDescription());
            ratting.setText(featuredVerModel.getRating());
            timing.setText(featuredVerModel.getTiming());
            Glide.with(context).load(featuredVerModel.getImage()).into(imageView);
        }
    }
}
