package br.com.web;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

public class Conexao {
	
	private Activity activity;
	
	public Conexao(Activity activity){
		this.activity = activity;
	}
	
	public  boolean verificaConexao() {  
	    boolean conectado;  
	    ConnectivityManager conectivtyManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);  
	    if (conectivtyManager.getActiveNetworkInfo() != null  
	            && conectivtyManager.getActiveNetworkInfo().isAvailable()  
	            && conectivtyManager.getActiveNetworkInfo().isConnected()) {  
	        conectado = true;  
	    } else {  
	        conectado = false;  
	    }  
	    return conectado;  
	}  

	
}
