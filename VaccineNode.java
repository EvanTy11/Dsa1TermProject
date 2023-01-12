import java.util.LinkedList;
import java.util.Scanner;


public class VaccineNode<E> {

	public static <VaccineRecipient> void main(String args[]) {
		
		boolean flag = true;
//Creating a scanner
		Scanner scan = new Scanner(System.in);
		// Creating a new LinkedList filled with HomeworkOrganizer objects
		LinkedList<VaccineRecipient> VaccineRecipientRecord = new  LinkedList<>();
//While loop which goes through options 1-5 and executes each service the user wants 
		while (flag) {
			int option = 0;

			System.out.println(
					"Welcome to the vaccine Dashboard! Please enter an option: Options: 1 = Add new vaccine recip record, Option 2 print vaccine recip list, Option 3 remove a vaccine recip, Option 4 find assignment with earliest due date ");
			option = scan.nextInt();

			if (option == 1) {
//option 1takes in user month,day,year, and name uses the .add method to create a new node with a HomeworkOrganizer object filled with the users values
				System.out.println("Enter the patients ID:");
				int userID = scan.nextInt();
				System.out.println("Enter the the patients name:");
				String name = scan.next();
				System.out.println("Enter the the prevac Questionare:");
				String prevacQuestionare = scan.next();
				System.out.println("Number of Doses:");
				int NumberofDoses = scan.nextInt();
				System.out.println("vaccineCert:");
				String vaccineCert = scan.next();
				VaccineRecipientRecord.add(new VaccineRecipient(userID,name,prevacQuestionare, NumberofDoses, vaccineCert));
			}
			// option 2 prints out the assignments by looping and getting the values at index i and prints them out.
			if (option == 2) {
				System.out.println("Vaccine Recip List:");
				if(VaccineRecipientRecord.size() == 0) {
					System.out.println("No patients added, list is empty!");
				}
				if(VaccineRecipientRecord.size() > 0) {
					for (int i = 0; i < VaccineRecipientRecord.size(); i++) {
						System.out.println("Patient Number:"+VaccineRecipientRecord.get(i).getID()+" " + "Patient Name:" + VaccineRecipientRecord.get(i).getName()+ " "  + "Prevac Survey:"+ VaccineRecipientRecord.get(i).getprevacQuestionare()
								+" " + "Number of Doses:"+ VaccineRecipientRecord.get(i).getNumberofDoses()+" " + "Vaccine Cert:" + VaccineRecipientRecord.get(i).getvaccineCert());

					}	
				}
				
			}
			//option 3 takes in user month,day,year, and name uses the .remove method to remove a node with a HomeworkOrganizer object filled with the users values
			//option 3 takes in user month,day,year, and name uses the .remove method to remove a node with a HomeworkOrganizer object filled with the users values
			if (option == 3) {
				if (VaccineRecipientRecord.size() >= 1) {
					System.out.println("Enter the patients ID you want removed:");
					int userremoveID = scan.nextInt();
					
					for (int i = 0; i < VaccineRecipientRecord.size(); i++) {
						if (VaccineRecipientRecord.get(i).getID() == userremoveID) {
							System.out.println("removed vaccine recip info for:" + VaccineRecipientRecord.remove(i));
						}

					}
				}
			}
			// Option gives you the assignment that is due the soonest
			

		}
	}
}
