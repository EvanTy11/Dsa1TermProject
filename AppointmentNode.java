import java.util.LinkedList;
import java.util.Random;

public class AppointmentNode {
//Creating linked list AppointmnetList filled with Appointment objects
LinkedList<Appointment> AppointmentList = new LinkedList<>(); 
//Creating a RanAptID instance to use Random class methods which we use to generate a random AptID
	Random RanAptID = new Random();

	//Adding a new Appointment node to the linkedlist
	public void add(Appointment newNode){

		AppointmentList.add(newNode);
	 
	}

	//returning the size of the linked list
	public int size(){

		return AppointmentList.size();
	}

	//Method which takes an AptID which it uses to search for the correct node associated with the correct AptID then it takes a updatechoice from the user which is uses to choose what element to update in the node then the updateinfo is the int info which takes the place of the old info
	public void searchAptIDInt(int searchAptID,int updatechoice, int updatedInfo){ // value 1-2
        for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getAptID() == searchAptID){
				if(updatechoice == 1){
				AppointmentList.get(i).setRID(updatedInfo);
            }
			if(updatechoice == 2)
			AppointmentList.get(i).setCID(updatedInfo);
			}
			if(updatechoice == 3){
			AppointmentList.get(i).setDay(updatedInfo);
			}
			if(updatechoice == 4){
			AppointmentList.get(i).setMonth(updatedInfo);
			}
			if(updatechoice == 5){
			AppointmentList.get(i).setYear(updatedInfo);
			}
		}
	}

//Method which takes an AptID which it uses to search for the correct node associated with the correct AptID then it takes a updatechoice from the user which is uses to choose what element to update in the node then the updateinfo is the String info which takes the place of the old info
	public void searchAptIDString(int searchAptID, String updatedInfo){ 
        for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getAptID() == searchAptID){
				AppointmentList.get(i).setCategory(updatedInfo);   
				
		}
	}
	}

//Method which prints out every node in the linkedlist AppointmentList
	public void printAppointmentList(){
        for(int i = 0; i < AppointmentList.size(); i++){
            System.out.println("\nApt ID: " + AppointmentList.get(i).getAptID() + 
            "\nRID: " + AppointmentList.get(i).getRID()+"\nApt CID: " + AppointmentList.get(i).getCID()+"\nCategory: " + AppointmentList.get(i).getCategory()+"\nDay: "+ AppointmentList.get(i).getDay()+"\nMonth: " + AppointmentList.get(i).getMonth()+"\nYear: " + AppointmentList.get(i).getYear());
        }
	}

//method which searches for an CID when the user removes a Clinician this way when a Clinician is removed it removes appointment data associated with the clinician
	public void printRemovedAptCID(int userremoveCID){
        for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getCID() == userremoveCID){
                System.out.println("Clinician info removed associated appointment info also removed:" + AppointmentList.remove(i));
            }
		}
	}

	//method which searches for an RID when the user removes a VaccineRecipiant this way when a VaccineRecipiant is removed it removes appointment data associated with the clinician
	public void printRemovedAptRID(int userremoveRID){
        for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getRID() == userremoveRID){
				System.out.println("Recipient info removed associated appointment info also removed:" + AppointmentList.remove(i)); 
		}
	}
}

	//method which takes in an AptID and finds the node associated with the AptID and removes the info at that AptID node
	public void printRemovedApt(int userremoveAptID){
        for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getAptID() == userremoveAptID){
                System.out.println("removed Appoitment for: " + AppointmentList.remove(i));
            }
		}
	}

	//Method that generates a new AptID whenever a new Node is created
	public int generateAptID(){
		int randomNumber = RanAptID.nextInt(1001);
		boolean repeat = true;
		while(repeat == true){
			repeat = false;
			for(int i = 0; i < AppointmentList.size(); i++){
            	if(AppointmentList.get(i).getAptID() == randomNumber){
					randomNumber = RanAptID.nextInt(1001);
					repeat = true;
				}
        	}
		}
		return randomNumber;
	}

	//Method to print out dates in order
	public void compareDates(){
		for(int a=2019; a < 2030; a++){
			for(int b = 1; b <= 12; b++){
				for(int c = 1; c <= 31; c++){
					for(int d = 0; d < AppointmentList.size(); d++){
						if(AppointmentList.get(d).getYear() == a && AppointmentList.get(d).getMonth() == b && AppointmentList.get(d).getDay() == c){
							System.out.println("\nApt ID: " + AppointmentList.get(d).getAptID() + 
            					"\nRID: " + AppointmentList.get(d).getRID()+"\nApt CID: " + AppointmentList.get(d).getCID()+"\nCategory: " 
								+ AppointmentList.get(d).getCategory()+"\nMonth: " + AppointmentList.get(d).getMonth()+"\nDay: "+ AppointmentList.get(d).getDay()+"\nYear: " 
								+ AppointmentList.get(d).getYear());
						}
					}
				}
			}
		}	
	}
	//frank walmart 2 3 2020 frank walmart 2 4 2020
	//Method that searches for the date
	public int searchDate(int userCID,int userRID, int month,int day, int year){
		int set = 0;
		for(int i = 0; i < AppointmentList.size(); i++){
            if(AppointmentList.get(i).getCID() == userCID && AppointmentList.get(i).getRID() == userRID && AppointmentList.get(i).getMonth() == month && AppointmentList.get(i).getDay() == day && AppointmentList.get(i).getYear() == year) {
				set = 2;
				return set;
            }
		}
		set = 1;
		return set;
	}

    }

