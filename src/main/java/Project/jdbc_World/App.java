package Project.jdbc_World;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.CRC32;

import Project.jdbc_World.data.CityDaoImpl;
import Project.jdbc_World.data.models.City;
import Project.jdbc_World.services.CreatNewCity;
import Project.jdbc_World.services.DoYouWannaDoMore;
import Project.jdbc_World.services.UpdateCity;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		CityDaoImpl dao = new CityDaoImpl();
		boolean Running = true;

		while (Running) {
			System.out.println("Welcome To DataBase " + "\n1-Find By ID " + "\n2-Find By Code " + "\n3-Find By Name "
					+ "\n4-Find All" + "\n5-Add City " + "\n6-Update City " + "\n7-Delete City");

			int Selections = in.nextInt();

			switch (Selections) {

			case 1:
				System.out.println("Please Type The City ID : ");
				System.out.print(dao.findById(in.nextInt()));
				break;
			case 2:
				System.out.print("Please Type The City Code: ");
				dao.findByCode(in.next()).forEach(System.out::println);
				break;
			case 3:
				System.out.print("Please Type The City Name: ");
				dao.findByName(in.next()).forEach(System.out::println);
				break;
			case 4:
				System.out.println("All Cities Table");
				dao.findAll().forEach(System.out::println);
				break;
			case 5:
				System.out.println(dao.add(CreatNewCity.creat()));
				break;
			case 6:
				System.out.println(dao.update(UpdateCity.Update()));
				break;
			case 7:
				System.out.println("Please Type The City ID You Want To Delete : ");
				System.out.println(dao.delete(dao.findById(in.nextInt())));
				break;

			default:
				break;
			}

			System.out.println("\nDo You Want To Access To Data Base Again ? (Y/N)");
			String answer = DoYouWannaDoMore.GetPlayAgainAnswer().toUpperCase();
			Running = DoYouWannaDoMore.PlayAgain(answer);
		}
	}
}