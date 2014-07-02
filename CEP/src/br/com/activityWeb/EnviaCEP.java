package br.com.activityWeb;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import br.com.activity.ResultadoEndereco;
import br.com.web.WebClient;

import com.google.gson.Gson;

public class EnviaCEP extends AsyncTask<Object, Object, String> {

	private final String url;
	private final Activity activity;
	private ProgressDialog pd;

	
	public EnviaCEP(Activity activity, String cep) {
		this.url = "http://correiosapi.apphb.com/cep/" + cep;
		this.activity = activity;
	}

	@Override
	protected String doInBackground(Object... params) {
		WebClient wc = new WebClient(this.url);
		String retorno = wc.post();
		return retorno;
	}

	@Override
	protected void onPreExecute() {

		ProgressDialog progress = ProgressDialog.show(activity, "Enviando",
				"Enviando dados para web", true, true);
		this.pd = progress;

	}

	protected void onPostExecute(String result) {
		pd.dismiss();
		Gson gson = new Gson();
		Endereco endereco = gson.fromJson(result, Endereco.class);

		if (endereco.getMessage().equals("Endereço não encontado!")) {
			Toast.makeText(activity, "Endereço não encontado!",
					Toast.LENGTH_LONG).show();
		} else {

			
			Intent intent = new Intent(activity,ResultadoEndereco.class);
			intent.putExtra("cep", endereco.getCep());
			intent.putExtra("tipodelogradouro", endereco.getTipoDeLogradouro());
			intent.putExtra("logradouro", endereco.getLogradouro());
			intent.putExtra("bairro", endereco.getBairro());
			intent.putExtra("cidade", endereco.getCidade());
			intent.putExtra("estado", endereco.getEstado());
			activity.startActivity(intent);
			
		}
	}
	
}
