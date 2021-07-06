package com.gussoft.controlles;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class BigSignerHash {
    static String api = "https://hlxis7wyh2.execute-api.us-east-1.amazonaws.com/demo/signer";
    public static void main(String[] args) {
        HashRequest hashRequest = new HashRequest();
        hashRequest.setHash("MUswGAYJKoZIhvcNAQkDMQsGCSqGSIb3DQEHATAvBgkqhkiG9w0BCQQxIgQgM+sSU7ibkOA0Qc1Xy6gLeakgoMzxHrcJkK0bTKw1QEc=");

        goDeferred(hashRequest);
    }

    private static void goHash() {
        try{
            URL url = new  URL(api);
            InputStream is = url.openStream();
            JsonReader rdr = Json.createReader(new InputStreamReader(is, "UTF-8"));
            JsonArray results= rdr.readArray();
            for (javax.json.JsonValue result : results) {
                JsonObject jsonObject = (JsonObject) result;
                System.out.println("JSON-> El id es: " + jsonObject.get("id").toString().toUpperCase() + ", el nombre es: " + jsonObject.get("nombre").toString().toUpperCase() + ", el puesto es: " + jsonObject.get("puesto").toString().toUpperCase());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String Hashed(HashRequest request) throws IOException {

        JSONObject json = new JSONObject();
        json.put("hash", "MUswGAYJKoZIhvcNAQkDMQsGCSqGSIb3DQEHATAvBgkqhkiG9w0BCQQxIgQgM+sSU7ibkOA0Qc1Xy6gLeakgoMzxHrcJkK0bTKw1QEc=");

            URL url = new URL(api);
            File file = new File("hello.ps");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/json");
            //conn.getOutputStream().write(json.get(0).toString()));

            //conn.setFixedLengthStreamingMode(documentLength);

            OutputStream os = conn.getOutputStream();
            try (InputStream documentIS = new BufferedInputStream(new FileInputStream(file))) {
                byte[] b = new byte[4096];

                int readCount;
                while (-1 != (readCount = documentIS.read(b))) {
                    os.write(b, 0, readCount);
                }
            }

            int statusCode = conn.getResponseCode();

            String responseFromServer = "";
            if (statusCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                while ((output = br.readLine()) != null) {
                    responseFromServer = output;
                }
            }
            conn.disconnect();

            System.out.println(statusCode);

            //Se imprime la respuesta del servidor
            System.out.println(responseFromServer);
    return responseFromServer;
    }

    private static void goDeferred(HashRequest hash) {
        HttpClient httpClient = new DefaultHttpClient();
        try{
            HttpPost request = new HttpPost(api);
            StringEntity params = new StringEntity(hash.getHash());
            request.addHeader("content-type", "application/json");

            request.setEntity(params);

            HttpResponse response = httpClient.execute(request);
            System.out.println(response);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
   /* public JSONObject requestPost(String sURL, HashRequest HashSend) throws Exception{
        //se crea el objeto de tipo URL
        URL url = new URL(sURL);
        //Convierte el JSONObject a un string y despues a un arreglo de Bytes
        byte[] postDataBytes = HashSend.toJSONString().getBytes("UTF-8");
        //Abre la conexión y asigna el objeto de la conexion a conn
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //establece el metodo o verbo de la conexión    conn.setRequestMethod("POST");
        //se establece que la solicitud tendrá salida
        conn.setDoOutput(true);
        //se escribe el cuerpo de la solicitud con el JSON convertido a Bytes
        conn.getOutputStream().write(postDataBytes);
        //Se realiza la solicitud y se lee la respuesta de la misma en el Reader
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        //Se convierte el Reader en un String
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        //Se crea el objeto que parseará la respuesta
        JSONParser parser = new JSONParser();
        //Se parsea la respuesta en un JSONObject
        JSONObject jsonResult = (JSONObject) parser.parse(response);
        //se Retorna la respuesta
        return jsonResult;
    }
    */

}


