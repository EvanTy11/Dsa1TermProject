//Class Clinician
public class Clinician{
    public String name;
    public String inventory;
    public int ID;

//
public Clinician(int ID,String name, String inventoryRecords){
this.name = name;
this.inventory = inventoryRecords;
this.ID = ID;
   }
//ToString method which 
@ Override
public String toString() {
    return "ID:"+getID()+"Clinician Name:"+ getName()+"Vaccine Cert:"+getInventory()+"\n";
}
//Get method which returns value of Assignment
public int getID(){
    return ID;
}
//Get method which returns value of year
public String getName() {
    return name;
}
public String getInventory() {
    return inventory;
}
}