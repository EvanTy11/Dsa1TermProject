//Class 
public class VaccineRecipient{
	public String name, prevacQuestionare, vaccineCert;
	public int numberOfDoses, RID;


//Constructor which takes in an int int int String
public VaccineRecipient(int RID,String name, String prevacQuestionare, int numberOfDoses, String vaccineCert){
this.name = name;
this.prevacQuestionare = prevacQuestionare;
this.numberOfDoses = numberOfDoses;
this.vaccineCert = vaccineCert;
this.RID = RID;
	}

// ToString method which ovverides the default method and displays the edited way
@ Override
public String toString() {
	return "RID:"+getRID()+"Patient Name:"+ getName()+"Patient Prevac Question:"+getprevacQuestionare()+"Number of Doses:"+getNumberofDoses()+"Vaccine Cert:"+getvaccineCert()+"\n";
}
//Get method which returns value of RID
public int getRID(){
	return RID;
}

//Get method which returns value of name
public String getName() {
	return name;
}
//Get method which returns value of prevacQuestionare
public String getprevacQuestionare() {
	return prevacQuestionare;
}
//Get method which returns value of numberOdDoses
public int getNumberofDoses() {
	return numberOfDoses;
}
//Get method which returns value of vaccineCert
public String getvaccineCert() {
	return vaccineCert;
}

//Set method which sets value of name
public void setName(String newName) {
	this.name = newName;
}
//Set method which sets value of vaccineCert
public void setVaccineCert(String newVaccineCert){
	this.vaccineCert = newVaccineCert;
}
//Set method which sets value of Dosage count for a recipient
public void setNumberofDoses(int newNumberofDoses){
	this.numberOfDoses = newNumberofDoses;
}
}


