package com.example.fbhack;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.android.*;
import com.facebook.android.Facebook.*;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	Facebook facebook = new Facebook("157725621040134");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  


    facebook.authorize(this, new DialogListener() {
    	 @Override
    	 public void onComplete(Bundle values) {}

		@Override
		public void onCancel() {			
		}

		@Override
		public void onError(DialogError e) {			
		}

		@Override
		public void onFacebookError(FacebookError e) {			
		}
    
    });
    
    OnClickListener mCorkyListener = new OnClickListener() {

		public void onClick(View view) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			
		}
		};
 
    

    
    
    }
    
    
    public void goTo(View view){
		Intent myIntent = new Intent();
		switch (view.getId()){
			case	R.id.postpictures: myIntent = new Intent(view.getContext(), PostActivity.class);
					break;

		}
		startActivityForResult(myIntent, 0);
	}

    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
