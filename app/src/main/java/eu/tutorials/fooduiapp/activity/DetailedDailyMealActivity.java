package eu.tutorials.fooduiapp.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.adapter.DetailedDailyAdapter;
import eu.tutorials.fooduiapp.models.DetailedDailyModel;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView detailed_rec;
    ArrayList<DetailedDailyModel> detailedDailyModels = new ArrayList<DetailedDailyModel>();
    DetailedDailyAdapter adapter;
    ImageView detailed_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);
        anhXa();
        xuLy();
    }

    private void xuLy() {
        String type = getIntent().getStringExtra("type");

        detailed_rec.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DetailedDailyAdapter(getApplicationContext(), detailedDailyModels);
        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav1, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav2, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav3, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            adapter.notifyDataSetChanged();
        }
        detailed_rec.setAdapter(adapter);
        if (type != null && type.equalsIgnoreCase("sweets")) {
            Glide.with(this).load(R.drawable.sweets).into(detailed_img);
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s1, "Sweet", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s2, "Sweet", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.s3, "Sweet", "Description", "4.5", "40", "10:00 - 23:00"));
            adapter.notifyDataSetChanged();
        }
        detailed_rec.setAdapter(adapter);
        if (type != null && type.equalsIgnoreCase("lunch")) {
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav1, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav2, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav3, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            adapter.notifyDataSetChanged();
        }
        detailed_rec.setAdapter(adapter);
        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav1, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav2, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            detailedDailyModels.add(new DetailedDailyModel(R.drawable.fav3, "Breakfast", "Description", "4.5", "40", "10:00 - 23:00"));
            adapter.notifyDataSetChanged();
        }
        detailed_rec.setAdapter(adapter);
    }

    private void anhXa() {
        detailed_rec = findViewById(R.id.detailed_rec);
        detailed_img = findViewById(R.id.detailed_img);
    }
}