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

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }


    /**
     * This testDelete() function checks the deletion of the City.
     */
    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City cityA = new City("Kushtia","Khulna");
        cityList.add(cityA);
        cityList.delete(cityA);
        assertFalse(cityList.getCities(1).contains(cityA));
    }

    /**
     * This testDeleteException() function checks the throwing exception of the cities which can't be deleted.
     */
    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City cityB = new City("Munshiganj","Dhaka");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(cityB);
        });
    }

    /**
     * This testCount() function checks the number of cities in the cityList.
     */
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City cityA = new City("Kushtia","Khulna");
        City cityB = new City("Munshiganj","Dhaka");
        City cityC = new City("Habiganj","Sylhet");
        cityList.add(cityA);
        cityList.add(cityB);
        cityList.add(cityC);
        assertEquals(3,cityList.count());
        cityList.delete(cityC);
        assertEquals(2,cityList.count());
    }

    /**
     * This testModifiedGetCities() function will return the CityList in sorted order by City or by province
     * If the 'whichSort' parameter is 1, then it will be sorted by City
     * Or if the 'whichSort' parameter is other than 1, then it will sort by Province
     */
    @Test
    public void testModifiedGetCities() {
        CityList cityList = new CityList();
        City cityA = new City("Munshiganj","Dhaka");
        cityList.add(cityA);
        assertEquals(0, cityA.compareTo(cityList.getCities(1).get(0)));

        City cityB = new City("Charlottetown", "Prince Edward Island");
        cityList.add(cityB);

        //Sort by City
        assertEquals(0, cityB.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, cityA.compareTo(cityList.getCities(1).get(1)));

        //Sort by Province
        assertEquals(0, cityB.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0, cityA.compareTo(cityList.getCities(2).get(0)));
    }


}
