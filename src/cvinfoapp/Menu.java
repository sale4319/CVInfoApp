package cvinfoapp;

import java.util.Scanner;

/**
 *
 * @author Aleksandar Stojanovic
 */
public class Menu {

    static Scanner kb = new Scanner(System.in);
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    private void runMenu() {
        //This method prints general header, then runs main menu
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);

        }

    }

    private void printHeader() {
        //Contains general header
        displayHeader("Hello and welcome to my CV");
    }

    private void printMenu() {
        //Contains main menu
        displayHeader("Please make a selection");
        displayContent("1) Personal Infomation",
                "2) Work Experience",
                "3) Education",
                "4) Skills",
                "5) About this Application",
                "0) Exit\n");
    }

    private int getInput() {
        //Takes input from user on scale from 0 to 6
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            //Makes sure that input is integer
            try {
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Nubers only please.");
            }
            //Makes sure that input is between 1 and 6
            if (choice < 0 || choice > 5) {
                System.out.println("Choice outside of range. Please try again.");
            }
            //When input is correct returns selected case
        } while (choice < 0 || choice > 5);
        return choice;
    }

    private void performAction(int choice) {
        //Functionality options of main menu
        switch (choice) {
            //0 Closes the application
            case 0:
                System.out.println("Thank you for using my application.");
                System.exit(0);
                break;
            //1 Displays personal information
            case 1:
                printPersonalInfo();
                break;
            //2 Displays Work Experience    
            case 2:
                printWorkExperience();
                break;
            //3 Displays Education
            case 3:
                printEducation();
                break;
            //4 Allows you to select which type of general skills you want to display
            case 4: {
                try {
                    printSkills();
                } catch (Exception e) {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            break;

            //5 Displays information about this application
            case 5:
                printAppInfo();
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }

    private void displayHeader(String message) {
        //Reusable method for desplaying different headers

        System.out.println();
        //Defines message length as message + 6 spaces
        int width = message.length() + 6;
        //Creates StringBuilder method
        StringBuilder sb = new StringBuilder();
        //Appends + sign to beginning of toString
        sb.append("+");
        //Appends 1 sign - to body of toString in width per char
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Appends + sign to end of toString
        sb.append("+");
        //Prints built toString above the custom message
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        //Prints built toString below the custom message
        System.out.println(sb.toString());
    }

    private void displayContent(String... args) {
        //Creates StringBuilder
        StringBuilder sb = new StringBuilder();
        //Passes number of - signs to toString
        int width = 83;
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Prints toString on top
        System.out.println(sb.toString());
        //Prints all arguments 
        for (String arg : args) {
            System.out.println(arg);
        }
        //Prints toString on bottom
        System.out.println(sb.toString());
    }

    private void printPersonalInfo() {
        displayHeader("PERSONAL INFORMATION");
        displayContent("Name: Aleksandar Stojanovic", "Email: 1plsdontsapmme@gmail.com",
                "Address: Cara Dusana Doboj, Bosnia and Herzegovina", "Phone number: 0038765***900");
    }

    private void printWorkExperience() {
        displayHeader("WORK EXPERIENCE");
        displayContent("01.06.2017 - Present: Vice chief Accountant in international company.",
                "21.11.2016 - 03.05.2017: Bar Owner/Manager.",
                "03.10.2013 - 15.06.2016: Proffesional translator of ducments and scientific papaers.");
    }

    private void printEducation() {
        displayHeader("EDUCATION");
        displayContent("30.10.2013 - 06.09.2016: Master of Arts in English Language and Literature",
                "08.07.2019 - 18.06.2013: Bachelor of Arts in English Language and Literature",
                "02.09.2005 - 15.06.2009: Economics technician");
    }

    private void printSkills() {
        displayHeader("Please make a selection");
        displayContent("1)Communication skills",
                "2)Organizational/Menagerial skills",
                "3)Speciality knowledge",
                "4)PC skills",
                "5)Programming knowledge",
                "0)Back");
        int choice = getInput();

        switch (choice) {
            //0 Returns to main menu
            case 0:
                break;
            //1 Displays COMMUNICATION SKILLS
            case 1:
                displayHeader("COMMUNICATION SKILLS");
                ;
                displayContent("Advanced skills in communication with:",
                        "Superiors/Colleagues/Customers/Partners",
                        "Advanced business communication skills including:",
                        "Negotiation/Ordering/Advising/Consulting/Presentation");
                break;
            //2 Displays ORGANISATIONAL/MANAGERIAL SKILLS  
            case 2:
                displayHeader("ORGANISATIONAL/MANAGERIAL SKILLS:");
                displayContent("Department organization:",
                        "Organizing shifts/Vacation planning/Bonuses (rewards)/Staff requirements",
                        "Employee evaluations/Monitoring/Correcting/Training employees/Task prioritization");
                break;
            //3 Displays SPECIALITY KNOWLEDGE
            case 3:
                displayHeader("SPECIALITY KNOWLEDGE:");
                displayContent("Accounting/Finance/Management",
                        "PERSONAL TRAITS:",
                        "Precise/Hardworking/Responsible/Reliable/Determined/Great pressure handling");
                break;
            //4 Displays GENERAL PC SKILLS
            case 4:
                displayHeader("GENERAL PC SKILLS:");
                displayContent("Expert knowledge of Microsoft Office(Office Libre)",
                        "Expert knowledge of Excel (Formulas, LOOKUP, conditioning)",
                        "Expert knowledge of Diamant 3.0 accounting software(OfficialTraining&Experience)",
                        "User knowledge of Linux OS");
                break;
            //Displays PROGRAMMING KNOWLEDGE
            case 5:
                displayHeader("PROGRAMMING KNOWLEDGE:");
                displayContent("Good knowledge of Java(Swing,SceneBuilder)(Actively Learning)",
                        "Understanding of MySql(Actively Learning)",
                        "Work experience with Scrum tool 'Jira'",
                        "User knowledge of Git",
                        "JavaScript(Getting familiar with basics)");
                break;

            default:
                System.out.println("Unknown error has occured.");
        }
    }

    private void printAppInfo() {
        //Displays some info about this app
        displayHeader("APPLICATION INFO");
        displayContent("Display of personal information in this application is without much detail",
                "in order to avoid missue of my private information.\n",
                "However basic this app may be, it is 100% designed coded and developed",
                "by Aleksandar Stojanovc with purpose of learning and practicing Java code.\n",
                "Thank you for using it and respecting my prive information.");
    }

}
