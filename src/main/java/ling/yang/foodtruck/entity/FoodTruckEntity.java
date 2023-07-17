package ling.yang.foodtruck.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class FoodTruckEntity {
    @CsvBindByName(column = "Applicant")
    private String applicant;
    @CsvBindByName(column = "FacilityType")
    private String facilityType;
    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;
    @CsvBindByName(column = "Address")
    private String address;
    @CsvBindByName(column = "Status")
    private String status;
    @CsvBindByName(column = "FoodItems")
    private String foodItems;
}
