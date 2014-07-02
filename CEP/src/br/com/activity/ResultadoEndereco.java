package br.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.cep.R;

public class ResultadoEndereco extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado_endereco);
			
		final Intent intent = getIntent();
		
		TextView cep = (TextView) findViewById(R.id.edt_res_cep);
		cep.setText("CEP: " + intent.getStringExtra("cep"));

		TextView tipodelogradouro = (TextView) findViewById(R.id.edt_res_tipoLogradouro);
		tipodelogradouro.setText("Tipo De Logradouro: " + intent.getStringExtra("tipodelogradouro"));

		TextView logradouro = (TextView) findViewById(R.id.edt_res_logradouro);
		logradouro.setText("Logradouro: " + intent.getStringExtra("logradouro"));

		TextView bairro = (TextView) findViewById(R.id.edt_res_bairro);
		bairro.setText("Bairro: " + intent.getStringExtra("bairro"));

		TextView cidade = (TextView) findViewById(R.id.edt_res_cidade);
		cidade.setText("Cidade: " + intent.getStringExtra("cidade"));

		TextView estado = (TextView) findViewById(R.id.edt_res_estado);
		estado.setText("Estado: " + intent.getStringExtra("estado"));


	}

}
