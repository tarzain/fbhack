package com.example.fbhack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.android.*;
import com.facebook.android.Facebook.*;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	Facebook facebook = new Facebook("157725621040134");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    

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
    }

    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
