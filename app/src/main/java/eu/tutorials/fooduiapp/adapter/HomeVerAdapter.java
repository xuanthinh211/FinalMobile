package eu.tutorials.fooduiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.models.HomeVerModel;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {
    private Context context;
    ArrayList<HomeVerModel> homeVerAdapterArrayList;

    private BottomSheetDialog bottomSheetDialog;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> homeVerAdapterArrayList) {
        this.context = context;
        this.homeVerAdapterArrayList = homeVerAdapterArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_vertical_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerModel homeVerModel = homeVerAdapterArrayList.get(position);
        holder.bind(homeVerModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.bottomSheet(homeVerModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeVerAdapterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, time, txt_price, txt_ratting;

        ImageView img_dinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            txt_price = itemView.findViewById(R.id.txt_price_card);
            txt_ratting = itemView.findViewById(R.id.txt_ratting);
            img_dinner = (ImageView) itemView.findViewById(R.id.img_dinner);

        }

        public void bind(HomeVerModel homeVerModel) {
            name.setText(homeVerModel.getName());
            time.setText(homeVerModel.getTiming());
            txt_price.setText(homeVerModel.getPrice());
            txt_ratting.setText(homeVerModel.getRating());
            Glide.with(context).load(homeVerModel.getImage()).into(img_dinner);


        }

        public void bottomSheet(HomeVerModel homeVerModel) {
            bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
            View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null);
            sheetView.findViewById(R.id.add_to_card).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Add to Card", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
            TextView bottom_name = sheetView.findViewById(R.id.bottom_name);
            TextView bottom_rating = sheetView.findViewById(R.id.bottom_rating);
            TextView txt_time = sheetView.findViewById(R.id.txt_time);
            TextView bottom_price = sheetView.findViewById(R.id.bottom_price);

            bottom_name.setText(homeVerModel.getName());
            bottom_rating.setText(homeVerModel.getRating());
            txt_time.setText(homeVerModel.getTiming());
            bottom_price.setText(homeVerModel.getPrice());
            Glide.with(context).load(homeVerModel.getImage()).into(bottomImg);
            bottomSheetDialog.setContentView(sheetView);
            bottomSheetDialog.show();

        }
    }
}
