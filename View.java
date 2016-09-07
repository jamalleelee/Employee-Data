package com.employeedata.employeedata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class View {

	// url of google map API we are connecting to
	protected static String endpoint = "http://localhost:1337/employee";

	// encoding of url parameters
	protected static String charset = "UTF-8";
	protected static String read;

	protected static void viewEmployeeData() {
		try {

			// creates a new URL out of the endpoint, returnType and
			// queryString
			URL employeeData = new URL(endpoint);
			HttpURLConnection connection = (HttpURLConnection) employeeData.openConnection();
			connection.setRequestMethod("GET");

			// if we did not get a 200 (success) throw an exception
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
			}

			// read response into buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// loop of buffer line by line until there are no more lines
			while ((read = br.readLine()) != null) {

				read.split(",");
				System.out.println(read);

				// print out each line to the screen
				System.out.println(br.readLine());
			}

			// close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
