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
	private int num=0;
	private int num1=0;
	private int cont=1;
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
				 //Otra opci�n es directamente coger el primer elemento que supere la predicci�n de 1.0
				 if (prediction.score > 3.0) 
				 {
					 if(prediction.name.equals("salida"))
					 {
						 Toast.makeText(this,"Hasta pronto", Toast.LENGTH_SHORT).show();
						 super.finish();
					 }
					 else
					 {
						 /* "cont" acumulador: la condici�n siguente se activa para cada vez que introduces dos n�mero seguidos (modulo 2) y tiene que ser
						  * distinto de cero para evitar que entre en la primera iteraci�n*/
						 if(cont%2==0 && cont!=0)
						 {
							 Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show();
							 num1=quenumero(prediction.name);
							 int valor=num1+num;
							 Toast.makeText(this, num+" + "+num1+" = "+valor, Toast.LENGTH_SHORT).show();
						 }
						 else
						 {
							 Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show();
							 num=quenumero(prediction.name);
						 }
						 cont++;
					 }
				 }	 
			 }
			
		 }
		 
		 public int quenumero(String numero)
		 {
			 int num=0;
		        if(numero.equals("uno"))
		        	num=1;
		        
		        if(numero.equals("dos"))
		        	num=2;
		        	
		        if(numero.equals("tres"))
		        	num=3;
		        
		        if(numero.equals("cuatro"))
			        num=4;
			       
			    if(numero.equals("cinco"))
			        num=5;
			    
			    if(numero.equals("seis"))
			        num=6;
			       
			    if(numero.equals("siete"))
			        num=7;
			        
			    if(numero.equals("ocho"))
			        num=8;
			       
			    if(numero.equals("nueve"))
			        num=9;
		        	
			    return num;
			 }
}

	
	 
		 
