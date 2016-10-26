package com.example.anton.player;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    private int[] image0 = {R.drawable.transport, R.drawable.stays};
    private int[] image1 = {R.drawable.visits};
    private int[] image2 = {R.drawable.sights, R.drawable.food};
    private int[] image3 = {R.drawable.call, R.drawable.news, R.drawable.map, R.drawable.more};
    private String[] text0 = {"交通資訊", "民宿飯店"};
    private String[] text1 = {"參觀伴手禮"};
    private String[] text2 = {"公共景點", "美食小吃"};
    private String[] text3 = {"緊急諮詢電話", "最新消息", "線上地圖", "更多"};

    private static Bitmap zoomBitmap(Bitmap bmp, float v, float v1){
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(v, v1);
        Bitmap newbmp = Bitmap.createBitmap(bmp, 0, 0, w, h, matrix, true);
        return newbmp;
    }

    DisplayMetrics dm, dm1, dm2;
    float vHeight, vWidth;
    float vHeight1, vWidth1;
    float vHeight2, vWidth2;
    float vHeight3, vWidth3;
    Bitmap[] bitmap = new Bitmap[2];
    Bitmap[] bitmap1 = new Bitmap[1];
    Bitmap[] bitmap2 = new Bitmap[2];
    Bitmap[] bitmap3 = new Bitmap[4];

    @SuppressWarnings("Deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int densityDPI = dm.densityDpi;
        vWidth = dm.widthPixels;
        vHeight = dm.heightPixels;
        float rateWidth = (vWidth/densityDPI) / (float)1.85;
        float rateHeight = (vHeight/densityDPI) / (float)1.85;

        dm1 = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm1);

        int densityDPI1 = dm1.densityDpi;
        vWidth1 = dm.widthPixels;
        vHeight1 = dm.heightPixels;
        float rateWidth1 = (vWidth1/densityDPI) / (float)1.85;
        float rateHeight1 = (vHeight1/densityDPI) / (float)1.85;

        dm2 = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm2);

        int densityDPI2 = dm2.densityDpi;
        vWidth2 = dm.widthPixels;
        vHeight2 = dm.heightPixels;
        float rateWidth2 = (vWidth2/densityDPI) / (float)1.85;
        float rateHeight2 = (vHeight2/densityDPI) / (float)1.85;

        Resources res = getResources();
        Bitmap bmp;

        for (int i = 0; i < image0.length; i++){
            bmp = BitmapFactory.decodeResource(res, image0[i]);
            bmp = zoomBitmap(bmp, (float)1, (float)1);
            bitmap[i] = zoomBitmap(bmp, rateWidth, rateHeight);
        }
        GridView view1 = (GridView)findViewById(R.id.left);
        view1.setAdapter(new GridAdapter(getBaseContext(), bitmap, text0));

        for (int i = 0; i < image1.length; i++){
            bmp = BitmapFactory.decodeResource(res, image1[i]);
            bmp = zoomBitmap(bmp, (float)1, (float)1);
            bitmap[i] = zoomBitmap(bmp, rateWidth, rateHeight);
        }
        GridView view2 = (GridView)findViewById(R.id.middle);
        view2.setAdapter(new GridAdapter(getBaseContext(), bitmap, text1));

        for (int i = 0; i < image2.length; i++){
            bmp = BitmapFactory.decodeResource(res, image2[i]);
            bmp = zoomBitmap(bmp, (float)1, (float)1);
            bitmap[i] = zoomBitmap(bmp, rateWidth, rateHeight);
        }
        GridView view3 = (GridView)findViewById(R.id.right);
        view3.setAdapter(new GridAdapter(getBaseContext(), bitmap, text2));

    }
}
