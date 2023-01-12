public class Clinician {
    public String name;
    public int inventory, CID;

    //Clinician constructor
    public Clinician(int CID, String name, int inventoryRecords) {
        this.name = name;
        this.inventory = inventoryRecords;
        this.CID = CID;
    }

    // ToString method which ovverides the default method and displays the edited way
    @Override
    public String toString() {
        return "CID:" + getCID() + "Clinician Name:" + getName() + "Vaccine Cert:" + getInventory() + "\n";
    }

  //Get methods which return the value specified in the method title
    public int getCID() {
        return CID;
    }

    public String getName() {
        return name;
    }

    public int getInventory() {
    return inventory;
    }
    //Set methods which update the value specified in the method title for ex setName updates the name and returns the newName
    public void  setName(String newName) {
        this.name = newName;
        }
    public void  setInventory(int newInventory) {
    this.inventory = newInventory;
     }
    
}

