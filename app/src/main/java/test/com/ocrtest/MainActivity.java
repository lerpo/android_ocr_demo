package test.com.ocrtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;


public class MainActivity extends AppCompatActivity {
    CameraView mCameraView;
    RecycledImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCameraView = (CameraView) findViewById(R.id.main_camera);
        mCameraView.setTextResult((TextView)findViewById(R.id.result));
        mImageView = (RecycledImageView) findViewById(R.id.main_image);
        mCameraView.setTag(mImageView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()){// 默认加载opencv_java.so库
        }
    }

    @Override
    public void finish() {
        super.finish();
        mCameraView.release();
    }
}
