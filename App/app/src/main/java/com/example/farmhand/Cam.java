package com.example.farmhand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.google.android.gms.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeling;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Timer;
import java.util.TimerTask;


public class Cam extends AppCompatActivity {

    private WebView mywebView;
    Timer timer;
    String url;
    Button saveBtn;
    TextView t;
    ImageView imageView;
   // ImageLabeler imageLabeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);


        saveBtn= findViewById(R.id.button2);
        t= findViewById(R.id.textView2);
        imageView= findViewById(R.id.imageView);

     //  imageLabeler= ImageLabeling.getClient()

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ion.with(getApplicationContext())
                        .load( )
                        .withBitmap()
                        //.placeholder(R.drawable.placeholder_image)
                        //.error(R.drawable.error_image)
                       // .animateLoad(spinAnimation)
                       // .animateIn(fadeInAnimation)
                        .intoImageView(imageView);


            }
        });



        imageView.buildDrawingCache();
        Bitmap bmap = imageView.getDrawingCache();
        processImage();

        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());

         url= "http://192.168.1.10/capture";
      // mywebView.loadUrl(url);
       // http://192.168.1.10:81/stream
        mywebView.loadUrl( "http://192.168.1.10:81/stream");
      //  mywebView.reload();
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);







    }

    private void processImage() {



    }


    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){




            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }







}