package com.cogect.monitorvcenter.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
@RequestMapping("/home")
public class AuthenticaController {

    @GetMapping
    public void authentica() throws IOException {
//        String command =
//                "curl -X GET https://postman-echo.com/get?foo1=bar1&foo2=bar2";
//        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//        Process process = processBuilder.start();
//        InputStream inputStream = process.getInputStream();
//        System.out.println(inputStream.toString());

//        BufferedReader reader;
//
//        try {
//            URL url = new URL("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
//
//            reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            String line = "";
//            String output = null;
//
//            while (( line = reader.readLine()) != null) {
//                JSONObject jsonObject = new JSONObject(output);
//                JSONObject jsonArray = new JSONObject(output);
//            }
//
//            reader.close();
//        } catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//        }

//        HttpURLConnection connection = null;
        try {
            URL url = new URL("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setUseCaches(false);
//            connection.setAllowUserInteraction(false);
//            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String output;
            while ((output = reader.readLine()) != null) {
                stringBuffer.append(output);
            }
            JSONObject jsonConvertido = new JSONObject(stringBuffer);
            String valorJson = (String) jsonConvertido.get("args");
            System.out.println(valorJson);
            reader.close();
            System.out.println(stringBuffer.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
