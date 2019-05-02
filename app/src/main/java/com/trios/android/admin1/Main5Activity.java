package com.trios.android.admin1;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class Main5Activity extends AppCompatActivity {

    private Uri videoUri;
    private EditText mPostTitle;
    private static final int REQUEST_CODE = 101;
    private StorageReference videoRef2;
    private DatabaseReference mDatabase2;

    //az
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        //String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase2 = FirebaseDatabase.getInstance().getReference().child("advertisement");


        StorageReference storageRef =
                FirebaseStorage.getInstance().getReference();

        videoRef2 = storageRef.child("/advertisement/Thrissur");


        //}


//az


        //public void download(View view) {

        try {
            final File localFile = File.createTempFile("Thrissur", "mp4");

            videoRef2.getFile(localFile).addOnSuccessListener(
                    new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess
                                (FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(Main5Activity.this, "Playing....",
                                    Toast.LENGTH_LONG).show();

                            final VideoView videoView =
                                    (VideoView) findViewById(R.id.vv3);
                            videoView.setVideoURI(Uri.fromFile(localFile));
                            videoView.start();

                        }

                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Main5Activity.this,
                            "Download Failed:" + e.getLocalizedMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });

        } catch (Exception e) {
            Toast.makeText(Main5Activity.this,
                    "Failed to create temp  file;" + e.getLocalizedMessage(),
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }
}

