package me.ndPrince.routeOptimization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

    private Double latitude = 0d;
    private Double longitude = 0d;

    @Override
    public String toString() {
        return getLatitude().toString() + "," + getLongitude().toString();
    }
}
