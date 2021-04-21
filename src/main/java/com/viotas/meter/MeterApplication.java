package com.viotas.meter;
/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 21.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import com.viotas.meter.util.InfoHost;
import com.viotas.server.model.Meter;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


@SpringBootApplication
public class MeterApplication {

	private static final String LOCAL_URL = "http://localhost:8085/api/v1/meter";
	private static final String HEROKU_SERVER = "https://server-monitoring-v1.herokuapp.com/api/v1/meter";
	private static final int MIN = 44;
	private static final int MAX = 65;
	public static void main(String[] args) {
		SpringApplication.run(MeterApplication.class, args);
		InfoHost infoHost = new InfoHost();
		Meter meter = new Meter();

		try {
			Client client = Client.create();
			WebResource webResource = client.resource(HEROKU_SERVER);

			while(true) {
				String timeStamp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss 'GMT'")
						.format(Calendar.getInstance().getTime());

				Random rand = new Random();
				float measure = (float) ((rand.nextInt((MAX - MIN) + 1) + MIN) * 0.01);

				JSONObject jo = new JSONObject();
				jo.put("meterId", infoHost.getIpHost());
				jo.put("measure", String.valueOf(measure));
				jo.put("timeMeasure", timeStamp);
				String input = jo.toString();

				ClientResponse response = webResource.type("application/json")
						.post(ClientResponse.class, input);

				if (response.getStatus() >= 201) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
				}

				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(input);
				Thread.sleep(1000);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
