package awad.ali.aliproject2020.MyUi;

import androidx.appcompat.app.AppCompatActivity;
import awad.ali.aliproject2020.R;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MakePhotoActivity extends AppCompatActivity {
    public final static String DEBUG_TAG = "MakePhotoActivity";
    private Camera camera;
    private int cameraId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_prview);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
            }
        }
        // do we have a camera?

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (!getPackageManager()
                            .hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                        Toast.makeText(this, "No camera on this device", Toast.LENGTH_LONG)
                                .show();
                    } else {
                        cameraId = findFrontFacingCamera();
                        if (cameraId < 0) {
                            Toast.makeText(this, "No front facing camera found.",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            camera = Camera.open(cameraId);
                        }
                    }
                } else {
                    Toast.makeText(this, "\"You declined to allow the app to access your camera\"", Toast.LENGTH_LONG).show();
                }
        }
    }
    public void onClick(View view) {
        camera.startPreview();
        camera.takePicture(null, null,
                new PhotoHandler(getApplicationContext()));
    }

    private int findFrontFacingCamera() {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                Log.d(DEBUG_TAG, "Camera found");
                cameraId = i;
                break;
            }
        }
        return cameraId;
    }

    @Override
    protected void onPause() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
        super.onPause();
    }

}