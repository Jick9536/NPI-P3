package com.example.gesto2;

import java.util.ArrayList;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity2 extends Activity implements OnGesturePerformedListener 
{

	private GestureLibrary gestureLib;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);

		 /*Detecci�n de gestos (solo se abre al principio de la aplicaci�n). */
		 
		 GestureOverlayView gestureOverlayView = new GestureOverlayView(this);
		 View inflate = getLayoutInflater().inflate(R.layout.activity_main_activity2, null);
		 gestureOverlayView.addView(inflate);
		 gestureOverlayView.addOnGesturePerformedListener(this);
		 gestureLib = GestureLibraries.fromRawResource(this, R.raw.gestures);

		 if (!gestureLib.load()) 
		 {
		 finish();
		 }
		 setContentView(gestureOverlayView);
	}
	
		 /* M�todos para tratamiento de gestos. */
		 @Override
		 public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture)
		 {
			 ArrayList<Prediction> predictions = gestureLib.recognize(gesture);
			 for (Prediction prediction : predictions) 
			 {
				 if (prediction.score > 3.0) 
				 {
					 Toast.makeText(this, prediction.name+" "+prediction.score, Toast.LENGTH_SHORT).show();
				 }
			}
		 }
}
	
	 
		 
