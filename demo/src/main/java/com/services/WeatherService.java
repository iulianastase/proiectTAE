package com.services;

import com.model.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;

/**
 * Created by inastase on 11/25/2016.
 */
@Service
public interface WeatherService {

    public String urlConstruction(String city);
    public String readAll(Reader reader);
    public JSONObject readJsonFromUrl(String url);
    public String getJson(String city);
    public Weather jsonParsing(String cityName);

}
