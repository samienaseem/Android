package jm_id.com.samar.projectjmi_id.cameraandgallery;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class secondActivity extends AppCompatActivity {
    EditText inputs;
    ImageView viewimages;
    Button b;
    DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    StorageReference storageReference;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inputs=(EditText)findViewById(R.id.input);
        viewimages=(ImageView)findViewById(R.id.imageshow1);
        b=(Button)findViewById(R.id.shown);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });




    }

    private void display() {


        String newid=inputs.getText().toString();

        progressDialog=new ProgressDialog(secondActivity.this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        storageReference=FirebaseStorage.getInstance().getReference();
        databaseReference=FirebaseDatabase.getInstance().getReference("imagees").child(newid);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                /*for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {*/
                   // Task<Uri> uri = storageReference.getDownloadUrl();
                    Upload ui = dataSnapshot.getValue(Upload.class);
                Uri uri=Uri.parse(ui.url);
                    Toast.makeText(getApplicationContext(),uri+"",Toast.LENGTH_LONG).show();


                    // Uri u=uri;

                    Picasso.get().load(uri).into(viewimages);


                //}
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
