package com.example.fbhack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.android.*;
import com.facebook.android.Facebook.*;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//NOTE THE OTHER .JAVA FILES ARE NOT REALLY USED AS OF NOW THEY ARE FROM EARLIER ATTEMPT
//CURRENTLY SUCCESFLY TAKES A PICTURE AND PLACES IN IMG VIEW
//TODO, MAKE THE IMAGE NOT DISPLAYED BUT RATHER POST TO FACEBOOK WALL
// AND TOSS THE METADATA SOMEHOW

public class MainActivity extends Activity {

	private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;
    Facebook facebook = new Facebook("157725621040134");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        this.imageView = (ImageView)this.findViewById(R.id.imageview1);
        Button photoButton = (Button) this.findViewById(R.id.postpictures);
        

    facebook.authorize(this, new String[] { "publish_stream" }, new DialogListener() {
    	 @Override
    	 public void onComplete(Bundle values) {
    		 //postToWall(values.getString(Facebook.TOKEN));
    	 }

    	 
    	 //THIS METHOD IS PROBABLY NOT WOTH SAVING
    	 //COULDNT GET IT TO NOT CRASH
    	 
		/*private void postToWall(String accessToken) {
			   Bundle params = new Bundle();

			    params.putString(Facebook.TOKEN, accessToken);

			    // The byte array is the data of a picture.
			    params.putByteArray("picture", getIntent().getExtras().getByteArray("data"));

			    try {
			        facebook.request("me/photos", params, "POST");

			    } catch (FileNotFoundException fileNotFoundException) {
			    } catch (MalformedURLException malformedURLException) {
			    } catch (IOException ioException) {
			    }			
		}*/

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
    
    photoButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
            startActivityForResult(cameraIntent, CAMERA_REQUEST); 
        }
    });
    

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    } 
	
  View.OnClickListener mCorkyListener = new View.OnClickListener() {
		Intent myIntent = new Intent();

		public void onClick(View view) {
			myIntent = new Intent(view.getContext(), PostActivity.class);			
		}

		};
 
    

    
    
    
    
    
    public void goTo(View view){
		Intent myIntent = new Intent();
		switch (view.getId()){
			case	R.id.postpictures: myIntent = new Intent(view.getContext(), MakePhotoActivity.class);
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
