package br.com.activity;



import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.activityWeb.EnviaCEP;
import br.com.web.Conexao;

import com.example.cep.R;

public class BuscarCEP extends ActionBarActivity {

		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar_cep);
	
		
		Button btn = (Button) findViewById(R.id.btn_buscar);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Conexao conectado = new Conexao(BuscarCEP.this);

				EditText cep = (EditText) findViewById(R.id.edt_cep);
			
				if (conectado.verificaConexao()) {
					if (cep.getEditableText().toString().equals("")) {
						Toast.makeText(BuscarCEP.this, "Digite um CEP!",
								Toast.LENGTH_LONG).show();

					} else {
						new EnviaCEP(BuscarCEP.this, cep.getEditableText()
								.toString()).execute();
						cep.setText("");
						
					}
				} else {
					Toast.makeText(BuscarCEP.this,
							"Você não está conectado a internet.",
							Toast.LENGTH_LONG).show();
				}

			}
		});
	}

}
