//Class HomeworkOrganizier
public class VaccineRecipient{
	public String name;
	public String prevacQuestionare;
	public int numberOfDoses;
	public String vaccineCert;
	public int ID;
	
//Constructor which takes in an int int int String
public VaccineRecipient(int ID,String name, String prevacQuestionare, int numberOfDoses, String vaccineCert){
this.name = name;
this.prevacQuestionare = prevacQuestionare;
this.numberOfDoses = numberOfDoses;
this.vaccineCert = vaccineCert;
this.ID = ID;
}
//ToString method which 
@ Override
public String toString() {
	return "ID:"+ getID() + "Patient Name:" + getName() + "Patient Prevac Question:" + getprevacQuestionare() + "Number of Doses:" + getNumberofDoses() + "Vaccine Cert:" + getvaccineCert() + "\n";
}
//Get method which returns value of Assignment
public int getID(){
	return ID;
}
//Get method which returns value of year
public String getName() {
	return name;
}
//Get method which returns value of Day
public String getprevacQuestionare() {
	return prevacQuestionare;
}
//Get method which returns value of month
public int getNumberofDoses() {
	return numberOfDoses;
}
public String getvaccineCert() {
	return vaccineCert;
}

}

