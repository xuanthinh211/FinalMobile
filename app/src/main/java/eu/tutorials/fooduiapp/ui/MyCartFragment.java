package eu.tutorials.fooduiapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eu.tutorials.fooduiapp.R;
import eu.tutorials.fooduiapp.adapter.CartAdapter;
import eu.tutorials.fooduiapp.models.CartModel;

public class MyCartFragment extends Fragment {


    RecyclerView cart_rec;
    ArrayList<CartModel> cartModelArrayList = new ArrayList<CartModel>();
    CartAdapter cartAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        cart_rec = view.findViewById(R.id.cart_rec);
        cart_rec.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        cartModelArrayList.add(new CartModel(R.drawable.s1, "Oder 1", "30", "4.3"));
        cartModelArrayList.add(new CartModel(R.drawable.s2, "Oder 2", "30", "4.3"));
        cartModelArrayList.add(new CartModel(R.drawable.fav1, "Oder 3", "30", "4.3"));
        cartModelArrayList.add(new CartModel(R.drawable.s3, "Oder 4", "30", "4.3"));
        cartModelArrayList.add(new CartModel(R.drawable.fav2, "Oder 5", "30", "4.3"));
        cartModelArrayList.add(new CartModel(R.drawable.icecream1, "Oder 6", "30", "4.3"));
        cartAdapter = new CartAdapter(getContext(), cartModelArrayList);
        cart_rec.setAdapter(cartAdapter);


        return view;

    }
}