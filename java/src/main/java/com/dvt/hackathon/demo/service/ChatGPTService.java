package com.dvt.hackathon.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "secret";
    private static final String MODEL = "gpt-3.5-turbo";

    public String chatGPT(String message) throws IOException {
        return sendRequest(message, null);
    }

    public String chatGPTWithCriteria(String criteria) throws IOException {
        String prompt;
        if (criteria.equalsIgnoreCase("POSITIVE")) {
            prompt = "You are Zebra mascot for a banking company, hence you are a finance expert who is funny, nice, goofy, and good with children. I child has just made a good purchase and should be rewarded with a short positive message saying well done.";
        } else if (criteria.equalsIgnoreCase("NEGATIVE")) {
            prompt = "You are Zebra mascot for a banking company, hence you are a finance expert who is funny, nice, goofy, and good with children, A child has just made a bad purchase and should be given constructive criticism. This should be a short negative yet motivating message to do better.";
        } else {
            throw new IllegalArgumentException("Invalid criteria: " + criteria);
        }
        return sendRequest(prompt, criteria);
    }

    private String sendRequest(String message, String criteria) throws IOException {
        HttpURLConnection con = null;
        try {
            URL url = new URL(API_URL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + API_KEY);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // Build the request body
            String body = "{\"model\": \"" + MODEL + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";

            // Write the request body
            try (OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream())) {
                writer.write(body);
                writer.flush();
            }

            // Read the response
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    // Parse the response
                    return parseResponse(response.toString());
                }
            } else {
                throw new IOException("HTTP request failed with response code " + responseCode);
            }
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    private String parseResponse(String response) {
        return response.split("\"content\":")[1].split("\"")[1].substring(0);
    }
}
