package com.kdu.caching.service;

import com.kdu.caching.entities.Coordinates;
import com.kdu.caching.exceptions.customexceptions.InvalidAddressException;
import com.kdu.caching.exceptions.customexceptions.InvalidJsonException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GeoCodeService {

    @Value("${api-key}")
    private String apiKey;

    @Value("${geocoding-url}")
    private String geocodingUrl;

    /**
     * @param address Address of a location
     * @return Coordinates
     * @throws InvalidAddressException
     */
    @Cacheable(value = "geocoding", key = "#address", unless = "#result != null && #result.region.toLowerCase() == 'goa'")
    public Coordinates fetchGeocodeData(String address) throws InvalidAddressException {
        JSONArray jsonResponse;
        try{
            String url = geocodingUrl + "?access_key=" + apiKey + "&query=" + address;
            RestTemplate restTemplate = new RestTemplate();
            String stringResponse = restTemplate.getForObject(url, String.class);
            jsonResponse = parseJsonResponse(stringResponse);

        }
        catch (Exception e){
            throw new InvalidAddressException("Empty Address");
        }
        return fetchCoordinates(jsonResponse);
    }

    @CacheEvict(value = "geocoding", key = "#address")
    public void evictCache(String address) {
        // This method will evict the entry with the specified address from the cache,
        // but only if the result is not null.
    }

    /**
     * fetchCoordinates extracts latitude and longitude of the location and put it in the Coordinates object
     * @param jsonResponse is the json Array of the api response
     * @return
     */
    public Coordinates fetchCoordinates(JSONArray jsonResponse) {
        double latitude;
        double longitude;
        String region;
        if (jsonResponse != null) {
            try {

                latitude = jsonResponse.getJSONObject(0).getDouble("latitude");
                longitude = jsonResponse.getJSONObject(0).getDouble("longitude");
                region = jsonResponse.getJSONObject(0).getString("region");

            }
            catch (Exception e) {
                throw new InvalidJsonException("Invalid Address");
            }
            log.info("coordinates returned successfully");
            return new Coordinates(latitude, longitude, region);
        } else {
            throw new InvalidJsonException("JSON response is null");
        }
    }

    /**
     * parseJsonResponse converts thr string response to a json node
     * @param stringResponse
     * @return JsonNode
     */
    private JSONArray parseJsonResponse(String stringResponse) {
        JSONObject jsonObject = new JSONObject(stringResponse);
        return jsonObject.getJSONArray("data");
    }
}
