package me.ghui.gradledemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;


/**
 * Created by vann on 12/20/14.
 */
public class ImgViewer extends Activity {
    String[] urls = { ImgUrlContants.img1, ImgUrlContants.img2,
            ImgUrlContants.img3, ImgUrlContants.img4
            , ImgUrlContants.img5, ImgUrlContants.img6, ImgUrlContants.img7,
            ImgUrlContants.img8, ImgUrlContants.img9, ImgUrlContants.img10 };

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_viewer);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        onLoadImg();
    }

    private String getRandomImgUrl() {
        return urls[NumUtils.getRandomNum(9)];
    }

    private void onLoadImg() {
        final ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.networkImageView);

        ImageRequest request = new ImageRequest(getRandomImgUrl(),new Response.Listener<Bitmap>() {
            @Override public void onResponse(Bitmap response) {
                mImageView.setImageBitmap(response);
                mProgressBar.setVisibility(View.GONE);
            }
        },0,0,null,new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
                mImageView.setImageResource(R.drawable.img_error);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(request);
    }
}
