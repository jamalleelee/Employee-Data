package com.employeedata.employeedata;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Delete {
	// url of google map API we are connecting to
	protected static String endpoint = "http://localhost:1337/employee";

	// encoding of url parameters
	protected static String charset = "UTF-8";

	protected static void DeleteFromAPI(String idToDelete) {
		try {

			// creates the url parameters as a string encodeing them with the
			// defined charset

//			needed? String queryString = 
			String.format("idToDelete=%s", URLEncoder.encode(idToDelete, charset));

			// creates a new URL out of the endpoint, returnType and queryString
			URL employeeData = new URL(endpoint + "/" + idToDelete);
			HttpURLConnection connection = (HttpURLConnection) employeeData.openConnection();
			connection.setRequestMethod("DELETE");

			// if we did not get a 200 (success) throw an exception
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
			}

			// close connection to API
			connection.disconnect();

		} catch (

		MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
