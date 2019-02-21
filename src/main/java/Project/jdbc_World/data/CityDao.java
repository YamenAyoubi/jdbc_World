package Project.jdbc_World.data;

import java.util.List;

import Project.jdbc_World.data.models.City;

public interface CityDao {

	void printCities();

	City findById(int id);

	List<City> findByCode(String code);

	List<City> findByName(String name);

	List<City> findAll();

	City add(City city);

	City update(City city);

	int delete(City city);

}
