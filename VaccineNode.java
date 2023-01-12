import java.util.LinkedList;
import java.util.Random;

//Creating the class VaccineNode
public class VaccineNode {
	//Creating a RanRID instance to use Random class methods which we use to generate a random RID
	Random ranRID = new Random();

	//Creating linked list VaccineRecipientList filled with VaccineRecipient objects
	LinkedList<VaccineRecipient> VaccineRecipientList = new LinkedList<>(); 

	//Adding a new VaccineRecipient node to the linkedlist
	public void add(VaccineRecipient newNode){

		VaccineRecipientList.add(newNode);
	 
	}

	//returning the size of the linked list
	public int size(){

		return VaccineRecipientList.size();
	}

	//Method which takes an RID which it uses to search for the correct node associated with the correct RID then it takes a updatechoice from the user which is uses to choose what element to update in the node then the updatedInfo is the String info which takes the place of the old info
	public void searchRIDString(int searchRID,int updatechoice, String updatedInfo){ 
        for(int i = 0; i < VaccineRecipientList.size(); i++){
            if(VaccineRecipientList.get(i).getRID() == searchRID){
				if(updatechoice == 1){
				VaccineRecipientList.get(i).setName(updatedInfo);
            	}
			if(updatechoice == 2)
			VaccineRecipientList.get(i).setVaccineCert(updatedInfo);
			}
		}
	}

//Method which takes an RID which it uses to search for the correct node associated with the correct RID then the updatedDoses is the  info which takes the place of the old updatedDoses
	public void searchRIDInteger(int searchRID, int updatedDoses){ 
        for(int i = 0; i < VaccineRecipientList.size(); i++){
            if(VaccineRecipientList.get(i).getRID() == searchRID){
				VaccineRecipientList.get(i).setNumberofDoses(updatedDoses);
            }
		}
	}

//method which takes in an RID and finds the node associated with the correct RID and prints the Vaccinerecipient RID, name, prevac questionare, NumberofDoses, and vaccineCert
	public void printVaccineRecipientList(){
			for (int i = 0; i < VaccineRecipientList.size(); i++) {
				System.out.println("Vaccine Recipient ID:" + VaccineRecipientList.get(i).getRID() + 
				"\nPatient Name:" + VaccineRecipientList.get(i).getName() + 
				"\nPrevac Survey:" + VaccineRecipientList.get(i).getprevacQuestionare() +
				"\nNumber of Doses:"+ VaccineRecipientList.get(i).getNumberofDoses() + 
				"\nVaccine Cert:"+ VaccineRecipientList.get(i).getvaccineCert());

			}	
	}

//method which takes in an RID and finds the node associated with the correct RID and prints the Vaccinerecipient RID, name, NumberofDoses, and vaccineCert
	public void printVaccineRecipientListEdit(){
		for (int i = 0; i < VaccineRecipientList.size(); i++) {
			System.out.println("Vaccine Recipient ID:" + VaccineRecipientList.get(i).getRID() + 
			"\nPatient Name:" + VaccineRecipientList.get(i).getName()+
			"\nNumber of Doses:"+ VaccineRecipientList.get(i).getNumberofDoses() + 
			"\nVaccine Cert:"+ VaccineRecipientList.get(i).getvaccineCert());
		}
	}
	
	//method which takes in an RID and finds the node associated with the correct RID and prints the Vaccinerecipient RID, and name
	public void printVaccineRecipientListAppt(){
		for (int i = 0; i < VaccineRecipientList.size(); i++) {
			System.out.println("Vaccine Recipient ID:" + VaccineRecipientList.get(i).getRID() + 
			"\nPatient Name:" + VaccineRecipientList.get(i).getName());
		}
	}

	//method which takes in an RID and finds the node associated with the RID and removes the info at that RID's node
	public void printRemoved(int userremoveRID){
		for (int i = 0; i < VaccineRecipientList.size(); i++) {
			if (VaccineRecipientList.get(i).getRID() == userremoveRID) {
				System.out.println("removed vaccine recip info for:" + VaccineRecipientList.remove(i));
			}
		}
	}

	//Method that generates a new RID whenever a new Node is created
	public int generateRID(){
		int randomNumber = ranRID.nextInt(1001);
		boolean repeat = true;
		while(repeat == true){
			repeat = false;
			for(int i = 0; i < VaccineRecipientList.size(); i++){
            	if(VaccineRecipientList.get(i).getRID() == randomNumber){
					randomNumber = ranRID.nextInt(1001);
					repeat = true;
				}
        	}
		}
		return randomNumber;
	}

	//Method that takes an RID and find the NumberofDoses associated with the RID and returns the NumberofDoses 
	public int getVaccineDoses(int searchRID){
		for(int i = 0; i < VaccineRecipientList.size(); i++){
            if(VaccineRecipientList.get(i).getRID() == searchRID){
				int numberofdoses = VaccineRecipientList.get(i).getNumberofDoses();
				return numberofdoses;
            }
		}
		return 0;
	}
	//Method that takes an RID and find a vaccine cert associated with the RID and returns the vaccine cert 
	public String getVaccineCert(int searchRID){
		for(int i = 0; i < VaccineRecipientList.size(); i++){
            if(VaccineRecipientList.get(i).getRID() == searchRID){
				String VaccineCert = VaccineRecipientList.get(i).getvaccineCert();
				return VaccineCert;
            }
		}
		return "";
	}
}
