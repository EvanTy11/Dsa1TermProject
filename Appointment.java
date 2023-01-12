
public class Appointment {
//variables used in the Appointment class
    public  int RID;
    public int CID;
    public int AptID;
    public int day;
    public int month;
    public int year;
    public String category;

    //Appointmnet constructor
    public Appointment(int AptID,int RID,int CID, String category, int month,int day,int year){   
        this.RID = RID;
       this.CID = CID;
       this.AptID = AptID;
       this.day = day;
       this.month = month;
       this.year = year;
       this.category = category;
    }
    // ToString method which ovverides the default method and displays the edited way
    @Override
    public String toString() {
        return "AptID:" + getAptID() + "Recipiant ID:" + getRID() + "Clinician ID:" + getCID() +  "Category:" + getCategory()  + "Month:" + getMonth()+ "Day:" + getDay() + "Year:" + getYear() +"\n";
    }

    //Get methods which return the value specified in the method title
    public int getRID(){
        return RID;
    }
    public int getAptID(){
        return AptID;
    }
     public int getCID()
    {
        return CID;
    }
    public String getCategory()
    {
        return category;
    }
    public int getDay()
    {
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }

     //Set methods which update the value specified in the method title for ex setRID updates the RID and returns the newRID
    public void setRID(int newRID){
        this.RID = newRID;
    }
    public void setCID(int newCID){
        this.CID = newCID;
    }
    public void setYear(int newYear){
        this.year = newYear;
    }
    public void setMonth(int newMonth){
        this.month = newMonth;
    }
    public void setDay(int newDay){
        this.year = newDay;
    }
    public void setCategory(String newCategory){
        this.category = newCategory;
    }
   
}