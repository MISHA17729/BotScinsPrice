package com.company.services;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class Baterfly {
    public String getPrice(String price, String urldetection) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            // создаем объект клиента
            HttpGet request = new HttpGet(urldetection);
            CloseableHttpResponse response = httpClient.execute(request);

            try {

                /* получаем статус ответа
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK
                */
                HttpEntity entity = response.getEntity();
                // если есть тело ответа
                if (entity != null) {
                    // возвращаем строку
                    JSONObject result = new JSONObject(EntityUtils.toString(entity));
                    price = result.getString("lowest_price");
                    //System.out.println(price);
                }
            } finally {
                // закрываем соединения
                response.close();
            }
        } finally {
            httpClient.close();
        }
        return price;
    }
}
