import java.util.Scanner;

//Creating Administrator Class
public class Administrator {

//Main
    public static void main(String[] args){
        //Creating instances of each Node class to be able to link each linked list and its associated methods to the admin class 
         VaccineNode AdminVN  = new VaccineNode(); 
         ClinicianNode AdminCN  = new ClinicianNode(); 
         AppointmentNode AdminApt  = new AppointmentNode();
         //initializing variables 
         String y = "y";
         String n = "n";
         boolean mainflag = true;
         int mainoption = 0;
         //Adding test information into the system
         AdminCN.add(new Clinician(455,"Walmart",20000));
         AdminCN.add(new Clinician(478,"CVS",10000));
         AdminVN.add(new VaccineRecipient(678,"Frank","Q1: n Q2: n Q3: heart Q4: n Q5: n", 1, "n"));
         AdminVN.add(new VaccineRecipient(600,"Bob","Q1: n Q2: n Q3: kidney Q4: n Q5: n", 0, "n"));
         AdminApt.add(new Appointment(111, 678, 455,"First Dose", 6, 2, 2021));
         AdminApt.add(new Appointment(234,600 ,478,"Second Dose", 6, 3, 2021));
      

    //Creating a scanner named scan
            Scanner scan = new Scanner(System.in);

    // Main while loop which brings up the admin dashboard which gives the users the options to edit each individual dashboard
    while(mainflag){
        //Main Dashboard
        System.out.println("Welcome to the Admin Dashboard! Please enter an option:");
        System.out.println("\n1) Modify the Vaccine Recipient Dashboard\n2) Modify the Clincian Dashboard \n3) Modify the Appointment Dashboard");
        mainoption = scan.nextInt();
        //While loop for vaccinerecip dashboard which executes and lets the user choose what option they want
        VaccineRecipiantLoop:
            while (mainoption == 1) {
                int option = 0;
    
                System.out.println("Welcome to the vaccine Dashboard! Please enter an option:");
                System.out.println("\n1) Add new vaccine recip record\n2) Print vaccine recipient list\n3) Remove a vaccine recipient information \n4) Edit Vaccine Recipient \n5) Exit to Admin dashboard");
                option = scan.nextInt();
        //option 1 takes in userRID, name, prevacQuestionare, numberOfDoses, VaccineCert
                if (option == 1) {
                    System.out.println("Enter the the patients name:");
                    String name = scan.next();
                    //Prevac questionnaire questions
                    System.out.println("Enter the the prevac Questionare:");
                    System.out.println("Have you had a flu in the last 24 hours? (y/n)");
                    String q1 = scan.next();
                    System.out.println("Have you had Covid in the past month? (y/n)");
                    String q2 = scan.next();
                    System.out.println("Do you have any health conditions? (y/n)");
                    String q3 = scan.next();
                    System.out.println("Have you been in close physical contact in the last 14 days with anyone that has Covid? (y/n)");
                    String q4 = scan.next();
                    System.out.println("Have you travelled in the last 10 days? (y/n)");
                    String q5 = scan.next();
                    //If any questions are not answered right then it tells the user they dont qualify
                    if(q1.equals(y) || q2.equals(y) || q4.equals(y) || q5.equals(y)){
                        System.out.println("Information not added REASON: You dont qualify for the vaccine!");
                        break VaccineRecipiantLoop;
                    }
                    
                    String space = " ";
                    String prevacQuestionare = "Q1: "+q1.concat(space.concat("Q2: "+q2.concat(space.concat("Q3: "+q3.concat(space.concat("Q4: "+q4.concat(space.concat("Q5: "+q5))))))));
                    System.out.println("Number of Doses:");
                    int NumberofDoses = scan.nextInt();
                    int RID = AdminVN.generateRID();
                    String vaccineCert = ""; 
                    // Adds a new VaccineRecip object to the instance of VaccineNode AdminVN's linkedlist
                AdminVN.add(new VaccineRecipient(RID,name,prevacQuestionare, NumberofDoses, vaccineCert));    
                //If number of doses == 2 updates the vaccinerecipiants vaccine cert to y (yes) and notifys user
                if(NumberofDoses == 2){
                    AdminVN.searchRIDString(RID, 2, y);
                    vaccineCert = AdminVN.getVaccineCert(RID);
                    System.out.println("The recipient has completed their doses and have recieved a Vaccine Certification.");
                }
                // else if the vaccine dose is less than 2 it updates the vaccinerecipiants cert to n (no)
                else{
                    AdminVN.searchRIDString(RID, 2, n);
                vaccineCert = AdminVN.getVaccineCert(RID);
                }
                    
                }
                // option 2 prints out the vaccine recipient list by looping and getting the values at index i and prints them out.
                if (option == 2) {
                    System.out.println("Vaccine Recip List:");
                    if(AdminVN.size() == 0) {
                        System.out.println("No patients added, list is empty!");
                    }
                    if(AdminVN.size() > 0) {
                    AdminVN.printVaccineRecipientList();
                    }
                    }
                
                //option 3 takes in the userRID and uses the .remove method to remove a node with a VaccineRecipient object filled with the users values
                if (option == 3) {
                    if (AdminVN.size() >= 1) {
                        System.out.println("Enter the Recipient ID you want removed:");
                        AdminVN.printVaccineRecipientListAppt();
                        int userremoveID = scan.nextInt();
                        AdminVN.printRemoved(userremoveID);
                        AdminApt.printRemovedAptRID(userremoveID);
                       
                    }
                }
                //option 4 allows for editing of components of the list by searching for the Recipient ID
                if (option == 4) {
                    System.out.println("Enter the Recipient ID you want to Edit");
                    AdminVN.printVaccineRecipientListEdit();
                    int searchRID = scan.nextInt();
                    System.out.println("Do you want to edit the Name? (y/n)");
                    String a1 = scan.next();
                    if (a1.equals(y)){
                        System.out.println("What do you want to change the name to?");
                        String userUpdatedName = scan.next();
                        int userchoice = 1;
                        AdminVN.searchRIDString(searchRID, userchoice, userUpdatedName);
                    }
                    System.out.println("Do you want to edit the doses? (y/n)");
                    String a3 = scan.next();
                    if (a3.equals(y)){
                        System.out.println("Do you want to 1) Increment Doses for the patient 2) Change doses");
                        int a4 = scan.nextInt();
                        //Allows for incrementation of the doses or straight editing of it which both make the vaccine certification value "Y"
                        if(a4 == 1){
                            if(AdminVN.getVaccineDoses(searchRID) <= 1){
                                int g = AdminVN.getVaccineDoses(searchRID);
                                 g++;
                                AdminVN.searchRIDInteger(searchRID, g);
                                System.out.println("The recipients doses have been incremented by 1.");
                            }
                            if(AdminVN.getVaccineDoses(searchRID) == 2){
                                AdminVN.searchRIDString(searchRID, 2, y);
                                System.out.println("The recipient has completed their doses and have recieved a Vaccine Certification.");
                            }
                        }
                        //option for manual editing of the doses
                        if(a4 == 2){
                        System.out.println("What do you want to change the doses to?");
                        int userUpdatedDoses = scan.nextInt();
                        AdminVN.searchRIDInteger(searchRID, userUpdatedDoses);
                        }
                    }
                }
                //Option 5 lets you edit the VaccineRecipiant dashboard
                if (option == 5) {
                    System.out.println("Are you sure you want to exit the VaccineRecipiant dashboard:(y/n)");
                    String exitanswer = scan.next();
                if(exitanswer.equals(n)){
                       continue; 
                   }
                   else{
                  
                       break VaccineRecipiantLoop;
                   }
                }
            }
            
            //Main menu option for the Clinician dashboard
            ClinicianLoop:
            while (mainoption == 2){
                int option = 0;
    
                System.out.println("Welcome to the Clinician Dashboard! Please enter an option:");
                System.out.println("1) Add new clinician record\n2) Print clinician list\n3) Remove a clinician \n4) Edit existing Clinician\n5) Exit to Admin dashboard");
                option = scan.nextInt();
                
                //option 1 adds a new clinician and the inventory that the clinician has as well as generates a clinician ID
                if(option == 1){
                   
                    System.out.println("Enter the clinicians name:");
                    String name = scan.next();
                    System.out.println("Enter the amount of inventory that clinician has:");
                    int inventory = scan.nextInt();
                    int userCID =  AdminCN.generateCID();
                    AdminCN.add(new Clinician(userCID,name,inventory));
                }
                //option 2 prints out the clinician list if there are components in there
                if(option == 2){
                    System.out.println("Clinician List:");
                    if(AdminCN.size() == 0){
                        System.out.println("List is empty!");
                    }
                    if(AdminCN.size() > 0){
                    AdminCN.printClinicianList();
                    }
                }
                //option 3 removes a clinician based ont he clinicians ID
                if(option == 3){
                    if(AdminCN.size() >= 1){
                        System.out.println("Enter the clinicians ID you want removed: ");
                        AdminCN.printClinicianList();
                        int userremoveCID = scan.nextInt();
                        AdminCN.printRemoved(userremoveCID);
                        AdminApt.printRemovedAptCID(userremoveCID);
                        }
                    }
                    //option 4 allows for editing of a clinician inside the clinician linked list
                    if(option == 4){
                        System.out.println("Enter the Clinician CID you want to Edit");
                        AdminCN.printClinicianList();
                        int searchCID = scan.nextInt();
                        System.out.println("Do you want to edit the name? (y/n)");
                        String a1 = scan.next();
                        if (a1.equals(y)){
                            System.out.println("What do you want to change the name to?");
                            String userUpdatedName = scan.next();
                            AdminCN.searchCIDString(searchCID, userUpdatedName);
                        }
                        System.out.println("Do you want to edit the inventory? (y/n)");
                        String a2 = scan.next();
                        if (a2.equals(y)){
                            System.out.println("What do you want to change the inventory amount to?");
                            int userUpdatedInventory = scan.nextInt();
                            AdminCN.searchCIDInt(searchCID, userUpdatedInventory);
                        }
                    }
                    //exits clinician dashboard
                    if (option == 5) {
                        System.out.println("Are you sure you want to exit the ClinicianRecipiant dashboard:(y/n)");
                        String exitanswer = scan.next();
                    if(exitanswer.equals(n)){
                           continue; 
                       }
                       else{
                      
                           break ClinicianLoop;
                       }
                    }
                }
                //Main Appointment option on menu
                AppointmentLoop:
                  while (mainoption == 3){
                    int option = 0;
        
                    System.out.println("Welcome to the Appointment Dashboard! Please enter an option:");
                    System.out.println("1) Add new Appointment\n2) Print Appointment list Options\n3) Remove an appointment\n4) Edit specific Appointment \n5) Exit to Admin dashboard ");
                    option = scan.nextInt();
                    
                    //option 1 creates a appointment with RID CID and classifying the appointment as first,second,or walk in doses
                    if(option == 1){
                        System.out.println("Choose your RID from list:");
                        AdminVN.printVaccineRecipientListAppt();
                        int userAptRID = scan.nextInt();
                        System.out.println("Choose CID from list:");
                        AdminCN.printClinicianList();
                        int userAptCID = scan.nextInt();
                        System.out.println("Enter a category: 1.)First Does 2.)Second Dose 3.) Walk-ins"); 
                        int categoryselect = scan.nextInt();
                        String category = "";
                        if(categoryselect == 1){
                            category = "First Dose";
                        }
                        if(categoryselect == 2){
                            category = "Second Dose";
                        }
                        if(categoryselect == 3){
                            category = "Walk-ins";
                        }
                        //makes the date component of the appointment
                        int set =1;
                        while(set == 1){
                         System.out.println("Enter the month you want the appointment");
                         int month = scan.nextInt();
                        System.out.println("Enter the day you want the appointment");
                        int day = scan.nextInt();
                        System.out.println("Enter the year you want the appointment");
                        int year = scan.nextInt();
                        AdminApt.searchDate(userAptCID,userAptRID,month,day, year);
                 if(AdminApt.searchDate(userAptCID,userAptRID,month,day, year) == 1){
                     int userAptID = AdminApt.generateAptID();
                    AdminApt.add(new Appointment(userAptID,userAptRID,userAptCID,category,month,day,year));
                        break;
                 }
                 System.out.println("You already have an appointment for this clinician for this day chose a new date!");
                 
                }
                    }
                    //option 2 prints the Appointment list
                    if(option == 2){
                        System.out.println("Welcome to the AppointmentList print menu! \n1.)Print list regularly\n2.)Print in order by date");
                        int aptprintchoice = scan.nextInt();
                        if(aptprintchoice == 1){
                            System.out.println("Appointmnet list:");
                            if(AdminApt.size() == 0){
                                System.out.println("List is empty!");
                            }
                            if(AdminCN.size() > 0){
                                AdminApt.printAppointmentList();
                            }
                        }
                        if(aptprintchoice == 2){
                            System.out.println("Appointmnet list:");
                            if(AdminApt.size() == 0){
                                System.out.println("List is empty!");
                            }
                            if(AdminApt.size() > 0){
                                System.out.println("List printed in least to greatest by date:");
                              AdminApt.compareDates();  
                            
                            }
                        }
                    }
                    //option 3 allows for the user to remove a appointment based on the appointment specific ID
                    if(option == 3){
                        if(AdminApt.size() >= 1){
                            System.out.println("Enter the AptID to remove an appointment: ");
                            AdminApt.printAppointmentList();
                            int userremoveAptID = scan.nextInt();
                            AdminApt.printRemovedApt(userremoveAptID);
                            }
                        }
                        //option 4 allows for editing of the components of an appointment
                        if (option == 4) {
                            System.out.println("Enter the Appointment AptID you want to Edit");
                            AdminApt.printAppointmentList();
                            int searchAptID = scan.nextInt();
                            System.out.println("Do you want to edit the RID? (y/n)");
                            AdminVN.printVaccineRecipientListAppt();
                            String a1 = scan.next();
                            if (a1.equals(y)){
                                System.out.println("What do you want to change the RID to?");
                                int userUpdatedRID = scan.nextInt();
                                int userchoice = 1;
                                AdminApt.searchAptIDInt(searchAptID, userchoice, userUpdatedRID);
                            }
                            System.out.println("Do you want to edit the CID? (y/n)");
                            String a2 = scan.next();
                            if (a2.equals(y)){
								System.out.println("What do you want to change the CID to?");
                                AdminCN.printClinicianList();
                                int userUpdatedCID = scan.nextInt();
                                int userchoice = 2;
                                AdminApt.searchAptIDInt(searchAptID,userchoice, userUpdatedCID);
                            }
                            System.out.println("Do you want to edit the category? (y/n)");
                            String a3 = scan.next();
                            if(a3.equals(y)){
                                System.out.println("What category do you want it updated to? 1) First Dose 2) Second Dose 3) Walk-ins");
                                int categorychoice = scan.nextInt();
                                String updatedcategory = "";
                                if(categorychoice == 1){     
                                    updatedcategory = "First Dose";   
                                }
                                if(categorychoice == 2){
                                    updatedcategory = "Second Dose";
                                }
                                if(categorychoice == 3){
                                    updatedcategory = "Walk-ins";
                                }
                                System.out.println("Success! Category updated to:"+ updatedcategory);
                                AdminApt.searchAptIDString(searchAptID, updatedcategory);
                            }
                            System.out.println("Do you want to edit the date? (y/n)");
                            String a4 = scan.next();
                            if (a4.equals(y)){
                                System.out.println("Day you want updated to:");
                                int userUpdatedDay = scan.nextInt();
                                int userchoice = 3;
                                AdminApt.searchAptIDInt(searchAptID, userchoice, userUpdatedDay);
                                System.out.println("Month you want updated to:");
                                int userUpdatedMonth = scan.nextInt();
                                userchoice = 4;
                                AdminApt.searchAptIDInt(searchAptID, userchoice, userUpdatedMonth);
                                System.out.println("Year you want updated to:");
                                int userUpdatedYear = scan.nextInt();
                                userchoice = 5;
                                AdminApt.searchAptIDInt(searchAptID, userchoice, userUpdatedYear);
                            }
                        }
                        //option 5 allows you to exit the appointment dashboard
                        if (option == 5) {
                            System.out.println("Are you sure you want to exit the Appointment dashboard:(y/n)");
                            String exitanswer = scan.next();
                        if(exitanswer.equals(n)){
                               continue;
                           }
                           else{
                          
                               break AppointmentLoop;
                           }
                        }
                    }
            }
            //closing the scanner
            scan.close();
        }
    }