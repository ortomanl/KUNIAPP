package com.example.kitanoskan.json;

import android.app.Activity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kitanoskan.json.Models.JtoAzienda;
import com.example.kitanoskan.json.com.Parsers.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    TextView statusText;
    Button connectBtn;
    LinearLayout loginFormLinLay, detailsLinLay;
    JtoAzienda jtoAzienda;

    //String url = "http://localhost:8080/UniAppWS/rest/azienda/user";  change when testing on localhost
    String url = "http://192.168.60.12:8080/UniAppWS/rest/users/user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //statusText =(TextView) findViewById(R.id.statusText);
        connectBtn = (Button) findViewById(R.id.btn_connect);
        loginFormLinLay = (LinearLayout) findViewById(R.id.loginFormLinLay);
        detailsLinLay = (LinearLayout) findViewById(R.id.detailsLinLay);

        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameText = ((EditText) findViewById(R.id.userNameEditText)).getText().toString();
                String userPassText = ((EditText) findViewById(R.id.userPassEditText)).getText().toString();
                new JsonTask().execute(url+"/"+userNameText+"/"+userPassText);
            }
        });


    }

    public class JsonTask extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {

            String response = dataPOST(params[0]);
            if(response != null)
                return response;
            else return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

           // if(s!=null) {
            if (jtoAzienda != null){
                connectBtn.setVisibility(View.GONE);
                loginFormLinLay.setVisibility(View.GONE);
                detailsLinLay.setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.titleTextView)).setText("Welcome " + jtoAzienda.getUsername());

                fillDetails();
            }
           // }
           else  ((TextView) findViewById(R.id.titleTextView)).setText("Failed login!");

        }


        private String dataGET(String urlString)
        {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            URL url = null;
            try {

                url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(15000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                //connection.setDoOutput(true);
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while((line = reader.readLine())!= null)
                    buffer.append(line);
                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(connection!=null)
                    connection.disconnect();
                if(reader!=null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            return null;
        }

        private String dataPOST(String urlString)
        {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            URL url = null;
            try {

                url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                //connection.setRequestProperty("Content-Type", "application/json");  //uncomment when using JSON to send data
                connection.setRequestProperty("Content-Type", "text/plain");
                connection.setDoOutput(true);

               // String input = "{\"id\":100,\"userName\":\"iPad 4\"}";  //test
                String input = "";

                //prosldjivanje podataka --- uncomment when using JSON to send data
                //Write
                //OutputStream os = connection.getOutputStream();
               // os.write(input.getBytes());
                //os.flush();


                if(connection.getResponseCode()/100 != 2)
                {

                    Log.v("ERROR",connection.getErrorStream().toString());
                    throw new RuntimeException("Failed : HTTP error code : "
                            + connection.getResponseCode());

                }


                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (connection.getInputStream())));

                String output;
                StringBuffer buffer = new StringBuffer();
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    buffer.append(output);
                }

                // Create a Reader from String
                Reader stringReader = new StringReader(buffer.toString());

                // Pass the string reader to JsonReader constructor
                JsonReader readerJson = new JsonReader(stringReader);
                readerJson.setLenient(true);

                jtoAzienda = JsonParser.readAzienda(readerJson);
                connection.disconnect();

                //jtoAzienda = JsonParser.parseJsonResponse(buffer.toString()); //povlacenje JSONA u objekat User

               return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    private void fillDetails() {

        ((TextView) findViewById(R.id.usernameStaticTextView)).setText("Username: "+jtoAzienda.getUsername());
        ((TextView) findViewById(R.id.passStaticTextView)).setText("Pass: "+jtoAzienda.getPassword());
        ((TextView) findViewById(R.id.CompanyStaticTextView)).setText("Company Code: "+jtoAzienda.getCompanyCode());

        ((TextView) findViewById(R.id.addressStaticTextView)).setText("Address: "+jtoAzienda.getJtoAnagrafica().getJtoAddressDetails().getAddress());
        ((TextView) findViewById(R.id.streetNumberStaticTextView)).setText("Street Number: "+jtoAzienda.getJtoAnagrafica().getJtoAddressDetails().getStreetNumber());
        ((TextView) findViewById(R.id.postCodetaticTextView)).setText("Post Code: "+jtoAzienda.getJtoAnagrafica().getJtoAddressDetails().getPostcode());
        ((TextView) findViewById(R.id.cityStaticTextView)).setText("City: "+jtoAzienda.getJtoAnagrafica().getJtoAddressDetails().getCity());
        ((TextView) findViewById(R.id.provinceStaticTextView)).setText("Province: "+jtoAzienda.getJtoAnagrafica().getJtoAddressDetails().getProvince());

        ((TextView) findViewById(R.id.emailStaticTextView)).setText("Email: "+jtoAzienda.getJtoAnagrafica().getJtoContactDetails().getEmail());
        ((TextView) findViewById(R.id.landLineStaticTextView)).setText("Landline: "+jtoAzienda.getJtoAnagrafica().getJtoContactDetails().getLandLine());

    }


}
