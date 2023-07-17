package ling.yang.foodtruck.service;

import ling.yang.foodtruck.data.SearchCondition;
import ling.yang.foodtruck.data.SearchResult;
import ling.yang.foodtruck.repository.FoodTruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodTruckService {
    private final FoodTruckRepository repo;

    public List<SearchResult> search(SearchCondition conditions) {
        return this.repo.all().stream().filter(conditions::valid).map(SearchResult::of).collect(Collectors.toList());
    }
}
