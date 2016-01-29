package com.example.kitanoskan.json.com.Parsers;

import android.os.Message;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import com.example.kitanoskan.json.Models.JtoAddressDetails;
import com.example.kitanoskan.json.Models.JtoAnagrafica;
import com.example.kitanoskan.json.Models.JtoAzienda;
import com.example.kitanoskan.json.Models.JtoContactDetails;
import com.example.kitanoskan.json.Models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kitanoskan on 1.12.2015.
 */
public class JsonParser {

/*
    public static List readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        }
            finally{
                reader.close();
            }
        }

    public static List readMessagesArray(JsonReader reader) throws IOException {
        List messages = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
           messages.add(readAzienda(reader));
        reader.endArray();
    }
        return messages;
    }*/

    public static JtoAzienda readAzienda(JsonReader reader) throws IOException {

        JtoAnagrafica jtoAnagrafica = null;
        String name = null;
        String password = null;
        String companyCode = null;
        String marketSegmentCode = null;
        String marketSegmentDescr = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String data = reader.nextName();
            if (data.equals("username") && reader.peek()!= JsonToken.NULL) {
                name = reader.nextString();
            } else if (data.equals("password") && reader.peek()!= JsonToken.NULL) {
                password = reader.nextString();
            } else if (data.equals("companyCode") && reader.peek()!= JsonToken.NULL) {
                companyCode = reader.nextString();
            } else if (data.equals("marketSegmentCode") && reader.peek()!= JsonToken.NULL) {
                marketSegmentCode = reader.nextString();
            } else if (data.equals("marketSegmentDescr") && reader.peek()!= JsonToken.NULL) {
                marketSegmentDescr = reader.nextString();
            } else if (data.equals("jtoAnagrafica") && reader.peek()!= JsonToken.NULL) {
                jtoAnagrafica = readJtoAnagrafica(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new JtoAzienda(jtoAnagrafica,name,password,companyCode,marketSegmentCode,marketSegmentDescr);
    }

    public List readDoublesArray(JsonReader reader) throws IOException {
        List doubles = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }

    public static JtoContactDetails readJtoContactDetails(JsonReader reader) throws IOException
    {
        String email = null;
        String landline = null;
        String fax = null;
        String mobile = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("email") && reader.peek()!= JsonToken.NULL) {
                email = reader.nextString();
            } else if (name.equals("landline") && reader.peek()!= JsonToken.NULL) {
                landline = reader.nextString();
            } else if (name.equals("fax") && reader.peek()!= JsonToken.NULL) {
                fax = reader.nextString();
            } else if (name.equals("mobile") && reader.peek()!= JsonToken.NULL) {
                mobile = reader.nextString();
            }
            else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return new JtoContactDetails(email, landline,fax, mobile);
    }

    public static JtoAddressDetails readJtoAddressDetails(JsonReader reader) throws IOException
    {
        String address = null;
        String streetNumber = null;
        String postcode = null;
        String city = null;
        String province = null;
        String nationCode = null;
        String nationDescr = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("address") && reader.peek()!= JsonToken.NULL) {
                address = reader.nextString();
            } else if (name.equals("streetNumber") && reader.peek()!= JsonToken.NULL) {
                streetNumber = reader.nextString();
            } else if (name.equals("postcode") && reader.peek()!= JsonToken.NULL) {
                postcode = reader.nextString();
            } else if (name.equals("city") && reader.peek()!= JsonToken.NULL) {
                city = reader.nextString();
            }else if (name.equals("province") && reader.peek()!= JsonToken.NULL) {
                province = reader.nextString();
            }else if (name.equals("nationCode") && reader.peek()!= JsonToken.NULL) {
                nationCode = reader.nextString();
            }else if (name.equals("nationDescr") && reader.peek()!= JsonToken.NULL) {
                nationDescr = reader.nextString();
            }
            else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return new JtoAddressDetails(address, streetNumber, postcode, city, province, nationCode,nationDescr);
    }

    public static JtoAnagrafica readJtoAnagrafica(JsonReader reader) throws IOException
    {
        JtoContactDetails jtoContactDetails = null;
        JtoAddressDetails jtoAddressDetails = null;
        String corporateLegalForm = null;
        String companyName = null;
        String taxIdentificationNumber = null;
        String vatIdentificationNumber = null;
        String numberEemployee = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("corporateLegalForm") && reader.peek()!= JsonToken.NULL) {
                corporateLegalForm = reader.nextString();
            } else if (name.equals("companyName") && reader.peek()!= JsonToken.NULL) {
                companyName = reader.nextString();
            } else if (name.equals("taxIdentificationNumber")&& reader.peek()!= JsonToken.NULL) {
                taxIdentificationNumber = reader.nextString();
            } else if (name.equals("vatIdentificationNumber")&& reader.peek()!= JsonToken.NULL) {
                vatIdentificationNumber = reader.nextString();
            }  else if (name.equals("numberEemployee")&& reader.peek()!= JsonToken.NULL) {
                numberEemployee = reader.nextString();
            } else if (name.equals("jtoContactDetails")&& reader.peek()!= JsonToken.NULL) {
                jtoContactDetails = readJtoContactDetails(reader);
            } else if (name.equals("jtoAddressDetails")&& reader.peek()!= JsonToken.NULL) {
                jtoAddressDetails = readJtoAddressDetails(reader);
            }
            else {
                reader.skipValue();
            }
        }
        reader.endObject();

        return new JtoAnagrafica(jtoAddressDetails,jtoContactDetails,corporateLegalForm,companyName, taxIdentificationNumber,vatIdentificationNumber,numberEemployee);
    }

    //old method
    public static JtoAzienda parseJsonResponse(String jsonString) {

        JtoAzienda jtoAzienda = null;
        JtoAnagrafica jtoAnagrafica = null;
        JtoAddressDetails jtoAddressDetails = null;
        JtoContactDetails jtoContactDetails = null;

        try {
            JSONObject  jsonRootObject = new JSONObject(jsonString);
            JSONObject  jtoContactDetailsObj;
            JSONObject  jtoAddressDetailsObj;

            JSONObject jsonAnagraficaObj =  new JSONObject (jsonRootObject.optString("jtoAnagrafica").toString());

            if(jsonAnagraficaObj.optString("jtoAddressDetails").toString().equals("null"))
                jtoAddressDetailsObj = null;
            else  jtoAddressDetailsObj =  new JSONObject (jsonAnagraficaObj.optString("jtoAddressDetails").toString());

            if(jsonAnagraficaObj.optString("jtoContactDetails").toString().equals("null"))
                jtoContactDetailsObj = null;
            else  jtoContactDetailsObj =  new JSONObject (jsonAnagraficaObj.optString("jtoContactDetails").toString());

            if(jsonAnagraficaObj != null) {
                String corporateLegalForm = jsonAnagraficaObj.optString("corporateLegalForm").toString();
                String companyName = jsonAnagraficaObj.optString("companyName").toString();
                String taxIdentificationNumber = jsonAnagraficaObj.optString("taxIdentificationNumber").toString();
                String vatIdentificationNumber = jsonAnagraficaObj.optString("vatIdentificationNumber").toString();
                String numberEemployee = jsonAnagraficaObj.optString("numberEemployee").toString();

                //getting azienda details
                String name = jsonRootObject.optString("username").toString();
                String password = jsonRootObject.optString("password").toString();
                String companyCode = jsonRootObject.optString("companyCode").toString();
                String marketSegmentCode = jsonRootObject.optString("marketSegmentCode").toString();
                String marketSegmentDescr = jsonRootObject.optString("marketSegmentDescr").toString();

                //address details
                if (jtoAddressDetailsObj != null) {
                    String address = jtoAddressDetailsObj.optString("address").toString();
                    String streetNumber = jtoAddressDetailsObj.optString("streetNumber").toString();
                    String postcode = jtoAddressDetailsObj.optString("postcode").toString();
                    String city = jtoAddressDetailsObj.optString("city").toString();
                    String province = jtoAddressDetailsObj.optString("province").toString();
                    String nationCode = jtoAddressDetailsObj.optString("nationCode").toString();
                    String nationDescr = jtoAddressDetailsObj.optString("nationDescr").toString();

                    jtoAddressDetails = new JtoAddressDetails(address, streetNumber, postcode, city, province, nationCode,nationDescr);
                }
                else  jtoAddressDetails = new JtoAddressDetails(null, null, null, null, null, null,null);

                //address details
                if (jtoContactDetailsObj != null) {
                    String email = jtoContactDetailsObj.optString("email").toString();
                    String landLine = jtoContactDetailsObj.optString("landLine").toString();
                    String fax = jtoContactDetailsObj.optString("fax").toString();
                    String mobile = jtoContactDetailsObj.optString("mobile").toString();

                    jtoContactDetails = new JtoContactDetails(email, landLine, fax, mobile);
                }
                else jtoContactDetails = new JtoContactDetails(null, null, null, null);

                jtoAnagrafica = new JtoAnagrafica(jtoAddressDetails,jtoContactDetails,corporateLegalForm,companyName, taxIdentificationNumber,vatIdentificationNumber,numberEemployee);
                jtoAzienda = new JtoAzienda(jtoAnagrafica,name,password,companyCode,marketSegmentCode,marketSegmentDescr);

            }

            /*
            user = new User(id, name, pass, position);
            */

        } catch (JSONException e) {e.printStackTrace();}
        return jtoAzienda;
    }

}
