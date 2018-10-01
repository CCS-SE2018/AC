package com.applications.kuyakoya.dia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ListLayoutEdit extends ArrayAdapter<clothes> {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Activity context;
    private List<clothes> clothesList;

    public ListLayoutEdit(Activity context, List<clothes> clothesList){
        super(context, R.layout.list_layout_edit, clothesList);
        this.context = context;
        this.clothesList = clothesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listView = inflater.inflate(R.layout.list_layout_edit, null, true);

        TextView clothesKind = (TextView) listView.findViewById(R.id.tv_kind_list);
        TextView clothesType = (TextView) listView.findViewById(R.id.tv_type_list);
        TextView clothesDesc = (TextView) listView.findViewById(R.id.tv_desc_list);
        TextView clothesAvail = (TextView) listView.findViewById(R.id.tv_avail_list);
        ImageView clothesImg = (ImageView) listView.findViewById(R.id.iv_image_list_edit);

        clothes clothes = clothesList.get(position);

        clothesKind.setText(clothes.getClothes_kind());
        clothesType.setText(clothes.getClothes_type());
        clothesDesc.setText(clothes.getClothes_description());
        clothesAvail.setText(clothes.getClothes_available());
        clothesAvail.setText(clothes.getImage_Path());

//        Bitmap bitmap = BitmapFactory.decodeFile(clothes.getImage_Path());
//        clothesImg.setImageBitmap(bitmap);

        String photoUrl= clothes.getImage_Path();
        try{

            if(photoUrl !=null) {
                clothesImg.setImageURI(Uri.parse(photoUrl));
            }

        }catch (Exception e){

        }

        return listView;
    }
}
