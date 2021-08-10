package me.hypherionmc.modexporter.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HastebinAPI {

    public static String addToPaste(String pasteData) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost("https://hastebin.com/documents");

            List<NameValuePair> params = new ArrayList<>(1);
            params.add(new BasicNameValuePair("data", pasteData));
            uploadFile.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();
            return IOUtils.toString(responseEntity.getContent(), StandardCharsets.UTF_8).replace("{\"key\":\"", "").replace("\"}", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
