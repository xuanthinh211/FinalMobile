package eu.tutorials.fooduiapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.adapter.FeatureAdapter;
import eu.tutorials.fooduiapp.adapter.FeaturedVerAdapter;
import eu.tutorials.fooduiapp.models.FeaturedModel;
import eu.tutorials.fooduiapp.models.FeaturedVerModel;


public class FirstFragment extends Fragment {


    //Hor
    ArrayList<FeaturedModel> featuredModelArrayList;
    RecyclerView recyclerView;
    FeatureAdapter featureAdapter;

    //Ver
    ArrayList<FeaturedVerModel> featuredVerModelArrayList;
    RecyclerView featured_ver_rec;
    FeaturedVerAdapter featuredVerAdapter;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        //Hor
        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        featuredModelArrayList = new ArrayList<>();
        featuredModelArrayList.add(new FeaturedModel(R.drawable.fav1, "Featured 1", "Description 1"));
        featuredModelArrayList.add(new FeaturedModel(R.drawable.fav2, "Featured 2", "Description 1"));
        featuredModelArrayList.add(new FeaturedModel(R.drawable.fav3, "Featured 3", "Description 1"));
        featureAdapter = new FeatureAdapter(getContext(), featuredModelArrayList);
        recyclerView.setAdapter(featureAdapter);

        //Ver
        featured_ver_rec = view.findViewById(R.id.featured_ver_rec);
        featured_ver_rec = view.findViewById(R.id.featured_ver_rec);
        featured_ver_rec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        featuredVerModelArrayList = new ArrayList<>();
        featuredVerModelArrayList.add(new FeaturedVerModel(R.drawable.ver1, "Featured 1", "Description 1", "4.8", "10:00 - 23:00"));
        featuredVerModelArrayList.add(new FeaturedVerModel(R.drawable.ver2, "Featured 2", "Description 1", "4.8", "10:00 - 23:00"));
        featuredVerModelArrayList.add(new FeaturedVerModel(R.drawable.ver3, "Featured 3", "Description 1", "4.8", "10:00 - 23:00"));
        featuredVerAdapter = new FeaturedVerAdapter(getContext(), featuredVerModelArrayList);
        featured_ver_rec.setAdapter(featuredVerAdapter);

        return view;
    }
}