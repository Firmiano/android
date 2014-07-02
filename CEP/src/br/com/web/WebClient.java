package br.com.web;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WebClient {

	private String url;

	public WebClient(String url) {
		this.url = url;
	}

	public String post() {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			get.addHeader("Content-type", "application/json");
			get.addHeader("Accept", "application/json");
			HttpResponse res = client.execute(get);
			String retornojson = EntityUtils.toString(res.getEntity());
			return retornojson;
		} catch (Exception e){
				throw new RuntimeException(e);
		}
	
	}
}
