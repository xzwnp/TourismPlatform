package com.example.tourism;

import com.example.tourism.entity.City;
import com.example.tourism.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * com.example.tourism
 *
 * @author xzwnp
 * 2022/3/2
 * 20:59
 * Steps：
 */
@SpringBootTest
public class AddCityTest {
    @Autowired
    CityService cityService;
    @Test
    public void addBatch(){
        String[] cities = {"昆明市","曲靖市","昭通市","玉溪市","楚雄州","红河州","文山州","普洱市","版纳州","大理州","保山市","德宏州","丽江市","怒江州","迪庆州","临沧市"};
        ArrayList<City> list = new ArrayList<>();
        for (String name : cities) {
            City city = new City();
            city.setName(name);
            list.add(city);
        }
        cityService.saveBatch(list);
    }
}
