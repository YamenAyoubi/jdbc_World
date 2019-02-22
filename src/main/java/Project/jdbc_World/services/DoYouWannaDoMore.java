package Project.jdbc_World.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;



public class DoYouWannaDoMore {
	
	static LocalDate Today = LocalDate.now();
	static LocalTime Now = LocalTime.now();
	static Scanner in = new Scanner (System.in);
	
	public static boolean PlayAgain(String answer) {
		
		String upperCaseString = answer.toUpperCase();
 		switch(upperCaseString) {
 		case "Y":
 			System.out.println("Data Base Open Again");
 			return true;
 		default:
 			System.out.println(" ಠ_ಠ   See You Soon ಠ_ಠ");
 			System.out.println("  Closing Date      "+Today+" ");
 			System.out.println("  Closing Time      "+Now+" ");
 			return false;
}
}
	
	public static String GetPlayAgainAnswer() {
			return in.nextLine();
}

}
