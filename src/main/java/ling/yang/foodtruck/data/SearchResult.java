package ling.yang.foodtruck.data;

import ling.yang.foodtruck.entity.FoodTruckEntity;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchResult {
    String applicant;
    String facilityType;
    String locationDescription;
    String address;
    String status;
    String foodItems;

    public static SearchResult of(FoodTruckEntity entity) {
        return SearchResult.builder()
            .applicant(entity.getApplicant())
            .facilityType(entity.getFacilityType())
            .locationDescription(entity.getLocationDescription())
            .address(entity.getAddress())
            .status(entity.getStatus())
            .foodItems(entity.getFoodItems())
            .build();
    }
}
