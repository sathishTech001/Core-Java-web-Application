package controller;

import java.util.Scanner;

import service.ServiceImpl;

public class Controller {
	
	public static boolean menuOption() {
		ServiceImpl service = new ServiceImpl();
		Scanner obj = new Scanner(System.in);
		while(true){
			try {
				System.out.println("========STUDENT MANAGEMENT SERVICE========");
				System.out.println("1.add");
				System.out.println("2.update");
				System.out.println("3.put");
				System.out.println("4.delete");
				System.out.println("5.view all");
				System.out.println("6.exit");
				System.out.println("enter the given option :");
				String option= obj.nextLine();
				switch (option) {
				case "1":
					service.addMap();
					break;
				case "2":
					service.update();
					break;
				case "3":
					service.put();
					break;
				case "4":
					service.delete();
					break;
				case "5":
					service.viewAll();
					break;
				case "6":
					return true;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
		}
	}
}
