package eu.tutorials.fooduiapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.activity.UpdateVerticalRecycleView;
import eu.tutorials.fooduiapp.models.HomeHorModel;
import eu.tutorials.fooduiapp.models.HomeVerModel;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    private ArrayList<HomeHorModel> homeHorModelArrayList;
    private Activity activity;
    private UpdateVerticalRecycleView updateVerticalRecycleView;

    private int row_index = -1;
    boolean check = true;
    boolean selected = true;

    public HomeHorAdapter(ArrayList<HomeHorModel> homeHorModelArrayList, Activity activity, UpdateVerticalRecycleView updateVerticalRecycleView) {
        this.homeHorModelArrayList = homeHorModelArrayList;
        this.activity = activity;
        this.updateVerticalRecycleView = updateVerticalRecycleView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_hozirontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeHorModel homeHorModel = homeHorModelArrayList.get(position);
        holder.bind(homeHorModel);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;//Lấy giá trị của hàng
                notifyDataSetChanged();
                ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
                switch (position) {//Nếu chọn hàng nào thì giá trị tương ứng sẽ ở hàng đấy
                    case 0:
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza1, "Seafood pizza", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza2, "Sausage pizza", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.pizza3, "Mixed pizza", "10:00-23:00", "4.9", "Min - $34"));
                        break;
                    case 1:
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.burger2, "Bacon burger", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.burger4, "Sausage burger", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.burger1, "Mixed burger", "10:00-23:00", "4.9", "Min - $34"));
                        break;
                    case 2:
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.fries1, "Fries potatoes 1", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.fries2, "Fries potatoes 2", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.fries3, "Fries potatoes 3", "10:00-23:00", "4.9", "Min - $34"));
                        break;
                    case 3:
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.icecream1, "Ice cream chocolate", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.icecream2, "Ice cream vanilla", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.icecream3, "Ice cream milk", "10:00-23:00", "4.9", "Min - $34"));
                        break;
                    case 4:
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.sandwich1, "Seafood sandwich", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.sandwich2, "Sausage sandwich", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.sandwich3, "Mixed sandwich 1", "10:00-23:00", "4.9", "Min - $34"));
                        homeVerModelArrayList.add(new HomeVerModel(R.drawable.sandwich4, "Mixed sandwich 2", "10:00-23:00", "4.9", "Min - $34"));
                        break;
                }
                updateVerticalRecycleView.callBack(position, homeVerModelArrayList);
            }
        });

        if (row_index == holder.getAdapterPosition()) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg);
        }
    }

    @Override
    public int getItemCount() {
        return homeHorModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_pizza;
        ImageView img_pizza;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_pizza = itemView.findViewById(R.id.txt_pizza);
            img_pizza = itemView.findViewById(R.id.img_pizza);
            cardView = itemView.findViewById(R.id.card_view);
        }

        public void bind(HomeHorModel homeHorModel) {
            txt_pizza.setText(homeHorModel.getName());
            Glide.with(activity).load(homeHorModel.getImage()).into(img_pizza);
        }
    }
}
