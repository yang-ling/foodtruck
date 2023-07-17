package ling.yang.foodtruck.controller;

import ling.yang.foodtruck.data.SearchCondition;
import ling.yang.foodtruck.data.SearchResult;
import ling.yang.foodtruck.service.FoodTruckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FoodTruckController {
    private final FoodTruckService service;

    @GetMapping("/list")
    public List<SearchResult> list(@RequestParam Map<String, String> allParams) {
        return this.service.search(SearchCondition.of(allParams));
    }
}
