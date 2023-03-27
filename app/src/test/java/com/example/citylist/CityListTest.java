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

     /**
     * This is for testing the delete method.
     */
    @Test
    public void testDelete(){
        CityList cityList=new CityList();
        City city1=new City("Motijheel","Dhaka");
        City city2=new City("Hobiganj","Sylhet");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities(1).contains(city1));
    }

     /**
     * This is for testing the deleteException method.
     */
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("Hobiganj", "Sylhet");
        City city2 = new City("Motijheel", "Dhaka");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testCount()
    {
        CityList cityList=new CityList();
        assertEquals(0,cityList.count());

        City city1=new City("Motijheel","Dhaka");
        City city2=new City("Hobiganj","Sylhet");
        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2,cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList=new CityList();
        City city1=new City("ABC","ZZZ");
        cityList.add(city1);
        assertEquals(0,city1.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city1.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0, city.compareTo(cityList.getCities(2).get(0)));
    }
}
