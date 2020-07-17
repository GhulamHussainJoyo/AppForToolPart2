package com.example.appfortool_iba;

import android.widget.ImageView;
import android.widget.TextView;

public class PartsName
{
    ImageView imageView;
    TextView selling_price,selling_num,total,total_num;

    public PartsName(ImageView imageView, TextView selling_price, TextView selling_num, TextView total, TextView total_num)
    {
        this.imageView = imageView;
        this.selling_price = selling_price;
        this.selling_num = selling_num;
        this.total = total;
        this.total_num = total_num;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(TextView selling_price) {
        this.selling_price = selling_price;
    }

    public TextView getSelling_num() {
        return selling_num;
    }

    public void setSelling_num(TextView selling_num) {
        this.selling_num = selling_num;
    }

    public TextView getTotal() {
        return total;
    }

    public void setTotal(TextView total) {
        this.total = total;
    }

    public TextView getTotal_num() {
        return total_num;
    }

    public void setTotal_num(TextView total_num) {
        this.total_num = total_num;
    }
}
