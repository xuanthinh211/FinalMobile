package eu.tutorials.fooduiapp.ui.home;

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
import eu.tutorials.fooduiapp.activity.UpdateVerticalRecycleView;
import eu.tutorials.fooduiapp.adapter.HomeHorAdapter;
import eu.tutorials.fooduiapp.adapter.HomeVerAdapter;
import eu.tutorials.fooduiapp.models.HomeHorModel;
import eu.tutorials.fooduiapp.models.HomeVerModel;

public class HomeFragment extends Fragment implements UpdateVerticalRecycleView {

    RecyclerView recycler_view_home, recycler_view_home_ver;
    ArrayList<HomeHorModel> homeHorModelArrayList = new ArrayList<>();

    ArrayList<HomeVerModel> homeVerModelArrayList = new ArrayList<>();
    HomeHorAdapter homeHorAdapter;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recycler_view_home = (RecyclerView) root.findViewById(R.id.recycler_view_home);
        recycler_view_home_ver = (RecyclerView) root.findViewById(R.id.recycler_view_home_ver);


        //Home horizontal
        homeHorModelArrayList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelArrayList.add(new HomeHorModel(R.drawable.hamburger, "Hamburger"));
        homeHorModelArrayList.add(new HomeHorModel(R.drawable.fried_potatoes, "Potatoes"));
        homeHorModelArrayList.add(new HomeHorModel(R.drawable.ice_cream, "Ice cream"));
        homeHorModelArrayList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));
        homeHorAdapter = new HomeHorAdapter(homeHorModelArrayList, getActivity(), this);

        recycler_view_home.setAdapter(homeHorAdapter);
        recycler_view_home.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recycler_view_home.setHasFixedSize(true);
        recycler_view_home.setNestedScrollingEnabled(false);


        //Home vertical
        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelArrayList);

        recycler_view_home_ver.setAdapter(homeVerAdapter);
        recycler_view_home_ver.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(), list);
        homeVerAdapter.notifyDataSetChanged();
        recycler_view_home_ver.setAdapter(homeVerAdapter);
    }
}