package jm_id.com.samar.projectjmi_id.cameraandgallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.Manifest;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Context c=getBaseContext();
    Button b,b2;
    TextView show;
    ImageView img;
    AlertDialog.Builder  builder;
    private static final int CAMERA_REQUEST=1888;
    public static final int READ_STORAGE_PERMISSION_REQUEST_CODE=100;
    private static final int PICK_IMAGE=1234;
    Uri filepath;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    DatabaseReference mdatabase;
    FirebaseAuth firebaseAuth;
    int i=0;
    //Uri u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storageReference=FirebaseStorage.getInstance().getReference();
        mdatabase=FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();

        b=(Button)findViewById(R.id.buttonopen);
        b2=(Button)findViewById(R.id.ipload);
        show=(TextView)findViewById(R.id.showimage);
        img=(ImageView)findViewById(R.id.imageshow);
        builder=new AlertDialog.Builder(this);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("select to open").setTitle("opening");

                builder.setMessage("what do you want to open").setCancelable(false)
                        .setPositiveButton("camera", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent cameraintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(cameraintent,CAMERA_REQUEST);
                            }
                        }).setNegativeButton("gellery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent().setType("image/*")
                                .setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent,"Select picture"),PICK_IMAGE);
                    }
                });
                AlertDialog alert=builder.create();
                alert.setTitle("example");
                alert.show();

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean t= checkPermissionForReadExtertalStorage();
               Toast.makeText(getApplicationContext(),t+"",Toast.LENGTH_LONG).show();
               if (t==false){

                       requestPermissionForExternalStorage();

               }

                if (filepath != null) {

                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("uploading...");
                    progressDialog.show();

                    final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
                    try {
                        /*ref.putFile(filepath);
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                progressDialog.dismiss();
                                Upload u= new Upload(uri);
                                mdatabase.child("imagees").child("Image" + i).setValue(u);//.addOnCompleteListener();
                            }
                        })*/
                       ref.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                progressDialog.dismiss();

                                Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_LONG).show();
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        Upload u = new Upload(uri.toString());
                                        Toast.makeText(getApplicationContext(), ref.getDownloadUrl()+"", Toast.LENGTH_LONG).show();

                                        Toast.makeText(getApplicationContext(),"url wala code chal gya",Toast.LENGTH_LONG).show();
                                       mdatabase.child("imagees").child("Image"+i).setValue(u);//.addOnCompleteListener();
                                        i++;

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        e.printStackTrace();
                                        Toast.makeText(getApplicationContext(), "agya error", Toast.LENGTH_LONG).show();
                                    }
                                });
                               //Uri uri=taskSnapshot.getDownloadUrl();

                            }
                           })
                              .addOnFailureListener(new OnFailureListener () {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                        double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                                        progressDialog.setMessage("uploaded" + " " + (int) progress + "%");
                                    }
                                });

                    }
                    catch (Exception e){
                        e.printStackTrace();
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"ni hua",Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),secondActivity.class));
            }
        });






    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       // super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Toast.makeText(getApplicationContext(),"okie",Toast.LENGTH_LONG).show();


    }

    private void requestPermissionForExternalStorage()
    {
            try {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        READ_STORAGE_PERMISSION_REQUEST_CODE);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }


    private boolean checkPermissionForReadExtertalStorage() {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int result = getApplication().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
                return result == PackageManager.PERMISSION_GRANTED;
            }
            return false;

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==CAMERA_REQUEST){




            try {
                filepath=data.getData();
                Bitmap photo = (Bitmap) data.getExtras().get("data");
               // Bitmap photo1=MediaStore.Images.Media.getContentUri();

                img.setImageBitmap(photo);
                /*filepath=data.getData();*/
                Toast.makeText(this, filepath+"", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.printStackTrace();

            }

        }
        else if (requestCode==PICK_IMAGE){
            filepath=data.getData();
            Toast.makeText(this, filepath+"", Toast.LENGTH_SHORT).show();

            try{
                Bitmap pic=MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                img.setImageBitmap(pic);
            }
            catch (IOException e){
                e.printStackTrace();

            }
        }

    }



   /* public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.activity_main,menu);
       return  try
    }*/

}
