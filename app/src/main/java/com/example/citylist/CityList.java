package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This function returns the sorted List of the City according to the city or the province
     * @param whichSort
     *      if whichSort is equal to 1, it will sort by City
     *      if whichSort is other than 1, it will sort by Province
     * @return
     *      Return the sorted list of the cities
     */
    public List<City> getCities(int whichSort) {
        List<City> cityList = cities;
        if(whichSort==1){
            Collections.sort(cityList);
        }
        else{
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * This function deletes city from the list or throws exception
     * @param city
     *      This is the city to delete
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This function counts the number of the cities in the List
     * @return
     *     Return the number of cities
     */
    public int count(){
        return cities.size();
    }

}
