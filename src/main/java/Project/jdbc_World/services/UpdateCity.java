package Project.jdbc_World.services;

import java.util.Scanner;

import Project.jdbc_World.data.CityDaoImpl;
import Project.jdbc_World.data.models.City;

public class UpdateCity {

	static Scanner in = new Scanner(System.in);

	public static City Update() {

		CityDaoImpl dao = new CityDaoImpl();

		City UpdateOne = null;

		String Name;
		int Population;

		System.out.println("Please Type The City ID : ");
		UpdateOne = dao.findById(in.nextInt());

		System.out.print("Pleae Add The New City Name :");
		Name = in.next();
		System.out.print("Pleae Add The New City Population:");
		Population = in.nextInt();

		return new City(UpdateOne.getId(), Name, UpdateOne.getCountryCode(), UpdateOne.getDistrict(), Population);

	}
}
