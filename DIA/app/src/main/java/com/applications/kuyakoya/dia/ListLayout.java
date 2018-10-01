package com.applications.kuyakoya.dia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ListLayout extends ArrayAdapter<clothes> {

    private Activity context;
    private List<clothes> clothesList;

    public ListLayout(Activity context, List<clothes> clothesList){
        super(context, R.layout.list_layout, clothesList);
        this.context = context;
        this.clothesList = clothesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listView = inflater.inflate(R.layout.list_layout, null, true);

        TextView clothesKind = (TextView) listView.findViewById(R.id.tv_kind_list);
        TextView clothesType = (TextView) listView.findViewById(R.id.tv_type_list);
        TextView clothesDesc = (TextView) listView.findViewById(R.id.tv_desc_list);
        TextView clothesAvail = (TextView) listView.findViewById(R.id.tv_avail_list);
        ImageView clothesImage = (ImageView) listView.findViewById(R.id.iv_image_list);

        clothes clothes = clothesList.get(position);

        clothesKind.setText(clothes.getClothes_kind());
        clothesType.setText(clothes.getClothes_type());
        clothesDesc.setText(clothes.getClothes_description());
        clothesAvail.setText(clothes.getClothes_available());

        String path = clothes.getImage_Path();
        Bitmap myBitmap = BitmapFactory.decodeFile(path);
        clothesImage.setImageBitmap(myBitmap);

        return listView;
    }
}
