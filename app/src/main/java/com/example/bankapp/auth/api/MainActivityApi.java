package com.example.bankapp.auth.api;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivityApi extends AsyncTask<Object, String, Object[]> {
    @Override
    protected Object[] doInBackground(Object... textViews) {
        // Init
        String urlPart = (String) textViews[2];
        HttpURLConnection httpURLConnection = null;
        InputStream stream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;


        try {
            // Создаем URL
            @SuppressLint("SimpleDateFormat") URL url = new URL(urlPart + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

            // Открываем соединения
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            // Читаем поток
            stream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));

            stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }

            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (stringBuilder != null) {
            return new Object[]{textViews[0], textViews[1], stringBuilder.toString()};
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object[] objects) {
        super.onPostExecute(objects);

        TextView rubUsd = (TextView) objects[0];
        TextView rubEu = (TextView) objects[1];
        String answer = (String) objects[2];

        DocumentBuilder builder;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;

        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(answer)));
            Element rootElement = document.getDocumentElement();
            NodeList valutes = rootElement.getChildNodes();

            for (int i = 0; i < valutes.getLength(); i++) {
                String numCode = valutes.item(i).getFirstChild().getTextContent();
                NodeList childs = valutes.item(i).getChildNodes();

                if (numCode.equals("840")) {
                    rubUsd.setText(childs.item(4).getTextContent());
                } else if (numCode.equals("978")) {
                    rubEu.setText(childs.item(4).getTextContent());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
