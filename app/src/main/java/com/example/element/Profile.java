package com.example.element;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    Button choose_pic,take_pick;
    ImageView profilepic;
    private Dialog d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilepic = findViewById(R.id.picture);

    }

    public void clickNew(View v)
    {
        d= new Dialog(this);
        d.setContentView(R.layout.dialogprofile);
        d.setCancelable(true);
        choose_pic = d.findViewById(R.id.choose_pic_btn);
        take_pick = d.findViewById(R.id.take_pic_btn);
        choose_pic.setOnClickListener(this);
        take_pick.setOnClickListener(this);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        d.show();
    }

    @Override
    public void onClick(View view) {
        if (view==choose_pic)
        {
            Toast.makeText(this, "Please wait a bit for this feature", Toast.LENGTH_LONG).show();
        }
        else if (view==take_pick)
        {
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            profilepic.setImageBitmap(bitmap);
        }

    }
}