package eu.tutorials.fooduiapp.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.adapter.DailyMealAdapter;
import eu.tutorials.fooduiapp.models.DailyMealModel;

public class DailyMealFragment extends Fragment {
    RecyclerView daily_meal_recycler;
    ArrayList<DailyMealModel> dailyMealModelArrayList;
    DailyMealAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_daily_meal, container, false);
        daily_meal_recycler = root.findViewById(R.id.daily_meal_recycler);
        dailyMealModelArrayList = new ArrayList<>();
        daily_meal_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModelArrayList.add(new DailyMealModel(R.drawable.breakfast, "Breakfast", "30% off", "Description", "breakfast"));
        dailyMealModelArrayList.add(new DailyMealModel(R.drawable.lunch, "Lunch", "20% off", "Description", "lunch"));
        dailyMealModelArrayList.add(new DailyMealModel(R.drawable.dinner, "Dinner", "30% off", "Description", "dinner"));
        dailyMealModelArrayList.add(new DailyMealModel(R.drawable.sweets, "Sweets", "50% off", "Description", "sweets"));
        dailyMealModelArrayList.add(new DailyMealModel(R.drawable.coffee, "Coffee", "10% off", "Description", "coffees"));
        adapter = new DailyMealAdapter(getContext(), dailyMealModelArrayList);
        daily_meal_recycler.setAdapter(adapter);
        return root;
    }


}