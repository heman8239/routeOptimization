package me.ndPrince.routeOptimization;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MappingService {

    private String apiKey = "4KAQaOlqjIvZe8R2dLAX1m66XzE2WD4slRdOU3PSMGo";
    private String mode = "fastest;car;traffic:enabled";

    public void calculateMatrix() {
        RestTemplate restTemplate = new RestTemplate();
        URI calculateURI = buildURI();

        String result = restTemplate.getForObject(calculateURI, String.class);
        System.out.println("my result is: " + result);
    }

    private URI buildURI() {
        String endpointURI = "https://matrix.route.ls.hereapi.com/routing/7.2/calculatematrix.json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpointURI)
                .queryParam("apiKey", apiKey)
                .queryParam("mode", mode)
                .queryParams(locationListToMap(generateSampleLocations(), "start"))
                .queryParams(locationListToMap(generateSampleLocations(), "destination"));

        return builder.build().encode().toUri();
    }

    private MultiValueMap<String, String> locationListToMap(List<Location> locations, String prefix) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        for (int i = 0; i < locations.size(); i++) {
            map.add(prefix + i, locations.get(i).toString());
        }
        return map;
    }


    private List<Location> generateSampleLocations() {
        ArrayList<Location> list = new ArrayList<>();
        list.add(new Location(42.331328, 13.4));
        list.add(new Location(42.331328, 14.3));
        return list;
    }


}
