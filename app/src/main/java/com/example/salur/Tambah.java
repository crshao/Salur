package com.example.salur;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salur.API.ApiService;
import com.example.salur.API.RetrofitBuilder;
import com.example.salur.Manager.DefaultResponse;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tambah extends Fragment {
    private final static String TAG = "Postingan";
    private Uri file;
    private final int PICK_IMAGE_GALLERY = 1;
    private String imgPath = null;

    @BindView(R.id.tambah1)
    Button tambah1;

    @BindView(R.id.tambah2)
    Button tambah2;

    @BindView(R.id.tambah3)
    Button tambah3;

    @BindView(R.id.jud)
    EditText jud;

    @BindView(R.id.desc)
    EditText desc;

    @BindView(R.id.masuk)
    Button masuk;

    ApiService service = RetrofitBuilder.createService(ApiService.class);
    Call<DefaultResponse> call;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_tambah,container,false);
        ButterKnife.bind(this, view);
        getPerm();
        return view;
    }

    public void getPerm()
    {
        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }
    }

    @OnClick({R.id.tambah1, R.id.tambah2, R.id.tambah3})
    public void getPhoto(View view)
    {
        switch(view.getId())
        {
            case R.id.tambah1:
                takePhoto(1);
                break;
            case R.id.tambah2:
                takePhoto(2);
                break;
            case R.id.tambah3:
                takePhoto(3);
                break;
        }
    }

    void takePhoto(int id)
    {
        try {
            PackageManager pm = getContext().getPackageManager();
            int hasPerm = pm.checkPermission(Manifest.permission.CAMERA, getContext().getPackageName());
            if (hasPerm == PackageManager.PERMISSION_GRANTED) {
                final CharSequence[] options = {"Choose From Gallery", "Cancel"};
                androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Select Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (options[item].equals("Choose From Gallery")) {
                            dialog.dismiss();
                            Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            file = FileProvider.getUriForFile(getContext(),BuildConfig.APPLICATION_ID+".provider",getOutputMediaFile());
                            pickPhoto.putExtra(MediaStore.EXTRA_OUTPUT,file);
                            startActivityForResult(pickPhoto, id);
                        } else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            } else
                Toast.makeText(getContext(), "Camera Permission error", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Camera Permission error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File image = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");

        imgPath = "file:" + image.getAbsolutePath();

        return image;
    }
}
