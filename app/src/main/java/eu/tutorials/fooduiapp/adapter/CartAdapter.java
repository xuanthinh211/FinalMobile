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
import eu.tutorials.fooduiapp.models.CartModel;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CartModel> cartModelArrayList;

    public CartAdapter(Context context, ArrayList<CartModel> cartModelArrayList) {
        this.context = context;
        this.cartModelArrayList = cartModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartModel cartModel = cartModelArrayList.get(position);
        holder.bind(cartModel);
    }

    @Override
    public int getItemCount() {
        return cartModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_my_cart_name, my_cart_rating, txt_price;
        ImageView my_cart_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_my_cart_name = itemView.findViewById(R.id.txt_my_cart_name);
            my_cart_rating = itemView.findViewById(R.id.my_cart_rating);
            txt_price = itemView.findViewById(R.id.txt_price_card);
            my_cart_img = (ImageView) itemView.findViewById(R.id.my_cart_img);
        }

        public void bind(CartModel cartModel) {
            txt_my_cart_name.setText(cartModel.getName());
            my_cart_rating.setText(cartModel.getRatting());
            txt_price.setText(cartModel.getPrice());
            Glide.with(context).load(cartModel.getImage()).into(my_cart_img);
        }
    }
}
