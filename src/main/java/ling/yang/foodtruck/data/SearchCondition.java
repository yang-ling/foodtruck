package ling.yang.foodtruck.data;

import ling.yang.foodtruck.entity.FoodTruckEntity;
import lombok.Builder;
import lombok.Value;

import java.util.Map;
import java.util.Objects;

@Value
@Builder
public class SearchCondition {
    String applicant;
    String facilityType;
    String locationDescription;
    String address;
    String status;
    String foodItems;

    public static SearchCondition of(Map<String, String> params) {
        return SearchCondition.builder()
            .applicant(params.getOrDefault("applicant", null))
            .facilityType(params.getOrDefault("facilityType", null))
            .locationDescription(params.getOrDefault("locationDescription", null))
            .address(params.getOrDefault("address", null))
            .status(params.getOrDefault("status", null))
            .foodItems(params.getOrDefault("foodItems", null))
            .build();
    }

    public boolean valid(FoodTruckEntity entity) {
        return isMatch(this.applicant, entity.getApplicant())
            && isMatch(this.facilityType, entity.getFacilityType())
            && isMatch(this.locationDescription, entity.getLocationDescription())
            && isMatch(this.address, entity.getAddress())
            && isMatch(this.status, entity.getStatus())
            && isMatch(this.foodItems, entity.getFoodItems());
    }

    private boolean isMatch(String condition, String input) {
        if (Objects.isNull(condition)) {
            return true;
        }
        if (Objects.isNull(input)) {
            return false;
        }
        return input.contains(condition);
    }
}
