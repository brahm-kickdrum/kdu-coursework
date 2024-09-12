package com.kdu.caching.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdu.caching.entities.Address;
import com.kdu.caching.exceptions.customexceptions.InvalidJsonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ReverseGeoCodeService {
    @Value("${api-key}")
    private String apiKey;

    @Value("${reverse-geocoding-url}")
    private String reverseGeocodingUrl;


    /**
     * @param latitude Latitude of a location
     * @param longitude Longitude of a location
     * @return Address
     */
    @Cacheable(value = "reverse-geocoding", key = "#latitude + ',' + #longitude", unless = "#result != null && #result.region.toLowerCase() == 'goa'")
    public Address fetchReverseGeocodeData(Double latitude, Double longitude){
        String url = reverseGeocodingUrl + "?access_key=" + apiKey + "&query=" + latitude + "," + longitude;
        RestTemplate restTemplate = new RestTemplate();
        String stringResponse = restTemplate.getForObject(url, String.class);
        JsonNode jsonResponse = parseReverseJsonResponse(stringResponse);
        return fetchAddress(jsonResponse);
    }

    @CacheEvict(value = "reverse-geocoding", key = "#latitude + ',' + #longitude")
    public void evictReverseGeocodeCache(String address) {
        // This method will evict the entry with the specified address from the cache,
        // but only if the result is not null .
    }

    /**
     * fetchAddress extracts various fields of a location and put it in the Address object
     * @param jsonResponse
     * @return
     */
    public Address fetchAddress(JsonNode jsonResponse) {
        if (jsonResponse != null) {
            try {
                String name = jsonResponse.at("/data/0/name").asText();
                String number = jsonResponse.at("/data/0/number").asText();
                String street = jsonResponse.at("/data/0/street").asText();
                String region = jsonResponse.at("/data/0/region").asText();
                String country = jsonResponse.at("/data/0/country").asText();
                int postalCode = jsonResponse.at("/data/0/postal_code").asInt();
                log.info("address returned successfully");
                return new Address(number, name, street, region, country, postalCode);
            } catch (Exception e) {
                throw new InvalidJsonException("Invalid JSON format for Address");
            }
        } else {
            throw new InvalidJsonException("JSON response is null for Address");
        }
    }


    /**
     * parseReverseJsonResponse converts thr string response to a json node
     * @param stringResponse
     * @return JsonNode
     */
    private JsonNode parseReverseJsonResponse(String stringResponse) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(stringResponse);
        } catch (Exception e) {
            log.error("Error parsing JSON response", e);
            return null;
        }
    }
}
