package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }
// i) test delete
    @Test
    public void testDelete(){
        CityList cityList= new CityList();
        City city1=new City("Mirpur","Dhaka");
        cityList.add(city1);
        City city2=new City("teligati","Khulna");
        cityList.add(city2);

        assertEquals(2, cityList.getCities(1).size());
        cityList.delete(city1);
        assertEquals(1, cityList.getCities(1).size());
        assertTrue(!cityList.getCities(1).contains(city1));


    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
// ii) test delete exception
    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
// iii) test sort
    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 = new City("Mirpur", "Dhaka");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        assertEquals(0, city1.compareTo(cityList.getCities(2).get(0)));

        City city2 = new City("teligati", "Khulna");
        cityList.add(city2);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(1)));

        assertEquals(0, city1.compareTo(cityList.getCities(2).get(0)));
        assertEquals(0, city2.compareTo(cityList.getCities(2).get(1)));
    }

    // iv) test count
    @Test
    public void testCount(){
        CityList cityList= new CityList();
        City city1=new City("Mirpur","Dhaka");
        cityList.add(city1);
        City city2=new City("teligati","Khulna");
        cityList.add(city2);

        assertEquals(2, cityList.count());
        cityList.delete(city1);
        assertEquals(1, cityList.count());
        assertTrue(!cityList.getCities(1).contains(city1));
    }
}
