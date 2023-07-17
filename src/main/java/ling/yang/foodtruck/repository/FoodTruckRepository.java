package ling.yang.foodtruck.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import ling.yang.foodtruck.entity.FoodTruckEntity;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Repository
public class FoodTruckRepository {
    private static final Path DB_FILE_PATH = Path.of("Mobile_Food_Facility_Permit.csv");
    private final List<FoodTruckEntity> data;

    public FoodTruckRepository() throws IOException {
        this.data = init();
    }

    private List<FoodTruckEntity> init() throws IOException {
        Path dbFilePath = DB_FILE_PATH.toRealPath();
        return new CsvToBeanBuilder<FoodTruckEntity>(new FileReader(dbFilePath.toFile())).withType(
            FoodTruckEntity.class).build().parse();
    }

    public List<FoodTruckEntity> all() {
        return this.data;
    }
}
