package Project.jdbc_World;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Project.jdbc_World.data.CityDao;
import Project.jdbc_World.data.CityDaoImpl;
import Project.jdbc_World.data.models.City;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		City ToAdd = new City(11121, "Aleppo", "AFG", "BMW", 45000);
		City Update = new City(11121, "Aleppooo", "AFG", "BMW", 47000);
		CityDaoImpl dao = new CityDaoImpl();

		while (true) {
			System.out.println("Welcome To DataBase " + "\n1-Find By ID " + "\n2-Find By Code " + "\n3-Find By Name "
					+ "\n4-Find All" + "\n5-Add City " + "\n6-Update City " + "\n7-Delete City");

			int Selections = in.nextInt();

			switch (Selections) {

			case 1:
				System.out.println(dao.findById(1));
				break;
			case 2:
				dao.findByCode("%AFG%").forEach(System.out::println);
				break;
			case 3:
				dao.findByName("%ST%").forEach(System.out::println);
				break;
			case 4:
				dao.findAll().forEach(System.out::println);
				break;
			case 5:
				System.out.println(dao.add(ToAdd));
				break;
			case 6:
				System.out.println(dao.update(Update));
				break;
			case 7:
				System.out.println(dao.delete(ToAdd));
				break;

			default:
				break;
			}
		}

////    	dao.printCities();
////    	System.out.println(dao.findById(34));		
////    	dao.findByCode("%BRA%").forEach(System.out::println);
////    	dao.findByName("%Ti%").forEach(System.out::println);
////////   	dao.findAll().forEach(System.out::println);
//   		dao.add(ToAdd);
//    		System.out.println(dao.findById(11121));
//    		dao.update(Update);
//    		System.out.println(dao.findById(11121));
//    		dao.delete(Update);

	}
}
