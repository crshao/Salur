package com.example.salur;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.salur.API.ApiService;
import com.example.salur.API.RetrofitBuilder;
import com.example.salur.Manager.DefaultResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tambah extends Fragment {
    private final static String TAG = "Postingan";
    private Uri file;
    private final int PICK_IMAGE_GALLERY = 1;
    private String imgPath1 = null;
    private String imgPath2 = null;
    private String imgPath3 = null;
    private Uri imageUri1, imageUri2, imageUri3;
    private File fo;
    private File mPhoto1, mPhoto2, mPhoto3;
    private Uri selectedImage;
    private Bitmap bitmap;
    private InputStream ims;


    @BindView(R.id.tambah1)
    Button tambah1;

    @BindView(R.id.tambah2)
    Button tambah2;

    @BindView(R.id.tambah3)
    Button tambah3;

    @BindView(R.id.image1)
    ImageView image1;

    @BindView(R.id.image2)
    ImageView image2;

    @BindView(R.id.image3)
    ImageView image3;

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selectedImage = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

            if(imgPath1 != null)
            {
                imageUri1 = Uri.parse(imgPath1);
                fo = new File(imageUri1.getPath());
            }

            if(imgPath2 != null)
            {
                imageUri2 = Uri.parse(imgPath2);

            }

            Log.e("Activity", "Pick from Gallery::>>> ");
            try {
                fo.createNewFile();
                FileOutputStream fos = new FileOutputStream(fo);
                fos.write(byteArrayOutputStream.toByteArray());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Bitmap phot = getOriented(imageUri);

            ByteArrayOutputStream byy = new ByteArrayOutputStream();
            phot.compress(Bitmap.CompressFormat.PNG, 100, byy);

            try {
                fo.createNewFile();
                FileOutputStream foss = new FileOutputStream(fo);
                foss.write(byy.toByteArray());
                foss.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            ims = new FileInputStream(fo);

            if (requestCode == 1) {
                Glide.with(this)
                        .load(BitmapFactory.decodeStream(ims))
                        .centerCrop()
                        .into(image1);
                tambah1.setVisibility(View.INVISIBLE);
                image1.setVisibility(View.VISIBLE);
            } else if (requestCode == 2) {
                Glide.with(this)
                        .load(BitmapFactory.decodeStream(ims))
                        .centerCrop()
                        .into(image2);
                tambah2.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.VISIBLE);
            } else if (requestCode == 3) {
                Glide.with(this)
                        .load(BitmapFactory.decodeStream(ims))
                        .centerCrop()
                        .into(image3);
                tambah3.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.VISIBLE);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getOriented( Uri photoUri) throws IOException {
        InputStream is = getContext().getContentResolver().openInputStream(photoUri);
        BitmapFactory.Options dbo = new BitmapFactory.Options();
        dbo.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, dbo);
        is.close();

        int rotatedWidth, rotatedHeight;
        int orientation = getOrientation(photoUri);

        if (orientation == 90 || orientation == 270) {
            rotatedWidth = dbo.outHeight;
            rotatedHeight = dbo.outWidth;
        } else {
            rotatedWidth = dbo.outWidth;
            rotatedHeight = dbo.outHeight;
        }

        Bitmap srcBitmap;
        is = getContext().getContentResolver().openInputStream(photoUri);
        if (rotatedWidth > 600 || rotatedHeight > 600) {
            float widthRatio = ((float) rotatedWidth) / ((float) 600);
            float heightRatio = ((float) rotatedHeight) / ((float) 600);
            float maxRatio = Math.max(widthRatio, heightRatio);

            // Create the bitmap from file
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = (int) maxRatio;
            srcBitmap = BitmapFactory.decodeStream(is, null, options);
        } else {
            srcBitmap = BitmapFactory.decodeStream(is);
        }
        is.close();

        // if the orientation is not 0, we have to do a rotation.
        if (orientation > 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(orientation);

            srcBitmap = Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(),
                    srcBitmap.getHeight(), matrix, true);
        }

        return srcBitmap;
    }

    public static int getOrientation(Uri photoUri) throws IOException {

        ExifInterface exif = new ExifInterface(photoUri.getPath());
        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                orientation = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                orientation = 90 * 2;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                orientation = 90 * 3;
                break;
            default:
                // Default case, image is not rotated
                orientation = 0;
        }

        return orientation;
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
                            file = FileProvider.getUriForFile(getContext(),BuildConfig.APPLICATION_ID+".provider",getOutputMediaFile(id));
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

    private File getOutputMediaFile(int id){
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

        switch (id){
            case 1:
                imgPath = "file:" + image.getAbsolutePath();
                break;
            case 2:
                break;
            case 3:
                break;
        }


        return image;
    }

    @OnClick(R.id.masuk)
    void masuk()
    {
        String judul_post = jud.getText().toString();
        String deskripsi_post = desc.getText().toString();

        if(imgPath1 != null)
        {
            imageUri1 = Uri.parse(imgPath1);
            mPhoto1 = new File(imageUri1.getPath());
        }

        if(imgPath2 != null)
        {
            imageUri2 = Uri.parse(imgPath2);
            mPhoto2 = new File(imageUri2.getPath());
        }

        if(imgPath3 != null)
        {
            imageUri3 = Uri.parse(imgPath3);
            mPhoto3 = new File(imageUri3.getPath());
        }

        Bitmap test = BitmapFactory.decodeFile(mPhoto.getPath());
        int currWidth = test.getWidth();
        int currHeight = test.getHeight();

        if(currWidth>600 || currHeight>600){
            Bitmap b2 = Bitmap.createScaledBitmap(test,600,600,false);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            b2.compress(Bitmap.CompressFormat.PNG,100,outStream);
            File f = new File(imageUri.getPath());
            try{
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(outStream.toByteArray());
                fo.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpeg"),mPhoto);
        MultipartBody.Part part = MultipartBody.Part.createFormData("img",mPhoto.getName(),requestBody);

        call = service.post(part, judul_post, deskripsi_post);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                Log.w(TAG, "onResponse: " + response.body() + "Message: " + response.message() + response.code());
                if(response.isSuccessful())
                {
                    if(response.code() == 200)
                    {
                        Toast.makeText(getContext(), "Berhasil melakukan postingan", Toast.LENGTH_SHORT).show();
                        BottomNavigationView navigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_navigation);
                        navigationView.setSelectedItemId(R.id.beranda);
                    }
                    else {
                        try {
                            Log.w(TAG, response.errorBody().string());
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Log.w(TAG, t.getMessage());
            }
        });

    }


}
