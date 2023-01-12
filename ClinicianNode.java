import java.util.LinkedList;
import java.util.Random;

public class ClinicianNode {

	//Creating a RanCID instance to use Random class methods which we use to generate a random CID
	Random RanCID = new Random();

	//Creating linked list ClinicianList filled with Clinician objects
    LinkedList<Clinician> ClinicianList = new LinkedList<>(); 

	//Adding a new Clinician node to the linkedlist
	public void add(Clinician c){

		ClinicianList.add(c);
	 
	}

	//returning the size of the linked list
	public int size(){

		return ClinicianList.size();
	}
//Method which takes a CID which it uses to search for the correct node associated with the correct CID then it takes a updatechoice from the user which is uses to choose what element to update in the node then the updatedName is the String name which takes the place of the old name
	public void searchCIDString(int searchCID, String updatedName){ 
        for(int i = 0; i < ClinicianList.size(); i++){
            if(ClinicianList.get(i).getCID() == searchCID){
				ClinicianList.get(i).setName(updatedName);
				
            }
		}
	}
//Method which takes a CID which it uses to search for the correct node associated with the correct CID then the int updateInventory is the value which takes the place of the old Inventory value
	public void searchCIDInt(int searchCID, int updatedInventory){ 
	for(int i = 0; i < ClinicianList.size(); i++){
            if(ClinicianList.get(i).getCID() == searchCID){
				ClinicianList.get(i).setInventory(updatedInventory);
            }
		}
	}
//method which takes in a CID and finds the node associated with the CID and prints the Clinician CID, name, and inventory
	public void printClinicianList(){
        for(int i = 0; i < ClinicianList.size(); i++){
            System.out.println("Clinician ID: " + ClinicianList.get(i).getCID() + 
            "\nClinician Name: " + ClinicianList.get(i).getName() + 
            "\nClinicians Inventory: " + ClinicianList.get(i).getInventory());
        }
	}
//method which takes in a CID and finds the node associated with the CID and removes the info at that CID's node
	public void printRemoved(int userremoveCID){
        for(int i = 0; i < ClinicianList.size(); i++){
            if(ClinicianList.get(i).getCID() == userremoveCID){
                System.out.println("removed clinician info for: " + ClinicianList.remove(i));
            }
		}
	}

//Method that generates a new CID whenever a new Node is created
	public int generateCID(){
		int randomNumber = RanCID.nextInt(1001);
		boolean repeat = true;
		while(repeat == true){
			repeat = false;
			for(int i = 0; i < ClinicianList.size(); i++){
            	if(ClinicianList.get(i).getCID() == randomNumber){
					randomNumber = RanCID.nextInt(1001);
					repeat = true;
				}
        	}
		}
		return randomNumber;
	}

}
