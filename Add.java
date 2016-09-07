package com.employeedata.employeedata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Add {
	// url of google map API we are connecting to
	protected static String endpoint = "http://localhost:1337/employee";

	// encoding of url parameters
	protected static String charset = "UTF-8";

	protected static void AddToAPI() {
			try {

				// creates the url parameters as a string encodeing them with the
				// defined charset

				String queryString = String.format("firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone&password=%s&active=%s",
						URLEncoder.encode(firstName, charset), URLEncoder.encode(lastName, charset),
						URLEncoder.encode(email, charset),URLEncoder.encode(homePhone, charset),
						URLEncoder.encode(cellPhone, charset),URLEncoder.encode(password, charset),URLEncoder.encode(active,charset));

				// creates a new URL out of the endpoint, returnType and queryString
				URL employeeData = new URL(endpoint + "/" + queryString);
				HttpURLConnection connection = (HttpURLConnection) employeeData.openConnection();
				connection.setRequestMethod("POST");

				// if we did not get a 200 (success) throw an exception
				if (connection.getResponseCode() != 201) {
					throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
				}

				// close connection to API
				connection.disconnect();

			}catch (

			MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		
}
}