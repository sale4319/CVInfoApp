package cvinfoapp;

import java.util.Arrays;
import java.util.List;
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
        System.out.println("+--------------------------------------+");
        System.out.println("|      Hello and welcome to my CV      |");
        System.out.println("+--------------------------------------+");
    }

    private void printMenu() {
        //Contains main menu
        displayHeader("Please make a selection");
        System.out.println("1) Personal Infomation");
        System.out.println("2) Work Experience");
        System.out.println("3) Education");
        System.out.println("4) General Skills");
        System.out.println("5) Digital Skills");
        System.out.println("6) About this Application");
        System.out.println("0) Exit\n");
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
            if (choice < 0 || choice > 6) {
                System.out.println("Choice outside of range. Please try again.");
            }
            //When input is correct returns selected case
        } while (choice < 0 || choice > 6);
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
                    printGeneralSkills();
                } catch (InvalidSkillTypeExcetpion ex) {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            break;
            //5 Allows you to select which type of digital skills you want to display
            case 5: {
                try {
                    printDigitalSkills();
                } catch (InvalidSkillTypeExcetpion ex) {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            break;
            //6 Displays information about this application
            case 6:
                printAppInfo();
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }

    private void displayHeader(String message) {
        //Reusable method for desplaying different headers
        //Determines form of header 
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i < width; ++i) {
            sb.append("-");

        }
        //Formats header to specific look with custom text
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }

    private void printPersonalInfo() {
        displayHeader("PERSONAL INFORMATION");
        System.out.println("Name: Aleksandar Stojanovic");
        System.out.println("Email: 1plsdontsapmme@gmail.com");
        System.out.println("Address: Cara Dusana Doboj, Bosnia and Herzegovina");
        System.out.println("Phone number: 0038765***900");
        System.out.println("---------------------------------------------------");
    }

    private void printWorkExperience() {
        displayHeader("WORK EXPERIENCE");
        System.out.println("01.06.2017 - Present: Vice chief Accountant in international company.");
        System.out.println("21.11.2016 - 03.05.2017: Bar Owner/Manager.");
        System.out.println("03.10.2013 - 15.06.2016: Proffesional translator of ducments and scientific papaers.");
        System.out.println("-------------------------------------------------------------------------------------");
    }

    private void printEducation() {
        displayHeader("EDUCATION");
        System.out.println("30.10.2013 - 06.09.2016: Master of Arts in English Language and Literature");
        System.out.println("08.07.2019 - 18.06.2013: Bachelor of Arts in English Language and Literature");
        System.out.println("02.09.2005 - 15.06.2009: Economics technician");
        System.out.println("------------------------------------------------------------------------------");
    }

    private String askQuestion(String question, List<String> answers) {
        //This method is borrowed, I did not write it personally, but I tried to explain it in comments below
        String response = "";
        //This part takes user input which has to match one of predefined choices in array list
        Scanner input = new Scanner(System.in);
        boolean choices = ((answers == null) || answers.size() == 0) ? false : true;
        boolean firstRun = true;
        do {
            if (!firstRun) {
                System.out.println("Invalid selection. Please try again.");
            }
            //This part adds predifined options from Array list to displayed question
            System.out.print(question);
            if (choices) {
                System.out.print("(");
                for (int i = 0; i < answers.size() - 1; ++i) {
                    System.out.print(answers.get(i) + "/");
                }
                System.out.print(answers.get(answers.size() - 1));
                System.out.print("):");
            }
            //This asks for user input again if previous try was not correct rather than exiting menu
            response = input.nextLine();
            firstRun = false;
            if (!choices) {
                break;
            }
            //Returns user choices
        } while (!answers.contains(response));
        return response;
    }

    private void printGeneralSkills() throws InvalidSkillTypeExcetpion {
        displayHeader("GENERAL SKILLS");
        //Takes user selection
        String skillType = askQuestion("Please enter one of the following options: ", Arrays.asList("communication", "organization", "speciality", "traits"));
        //Displays first option
        if (skillType.equalsIgnoreCase("communication")) {
            displayHeader("COMMUNICATION SKILLS");;
            System.out.println("Advanced skills in communication with:");
            System.out.println("Superiors/Colleagues/Customers/Partners");
            System.out.println("Advanced business communication skills including:");
            System.out.println("Negotiation/Ordering/Advising/Consulting/Presentation");
            //Displays second option
        } else if (skillType.equalsIgnoreCase("organization")) {
            displayHeader("ORGANISATIONAL/MANAGERIAL SKILLS:");
            System.out.println("Department organization:");
            System.out.println("Organizing shifts/Vacation planning/Bonuses (rewards)/Staff requirements");
            System.out.println("Employee evaluations/Monitoring/Correcting/Training employees/Task prioritization\n");
            //Displays third option
        } else if (skillType.equalsIgnoreCase("speciality")) {
            displayHeader("SPECIALITY KNOWLEDGE:");
            System.out.println("Accounting/Finance/Management\n");
            //Displays fourth option
        } else if (skillType.equalsIgnoreCase("traits")) {
            displayHeader("PERSONAL TRAITS:");
            System.out.println("Precise/Hardworking/Responsible/Reliable/Determined/Great pressure handling");
        } else {
            throw new InvalidSkillTypeExcetpion();
        }
    }

    private void printDigitalSkills() throws InvalidSkillTypeExcetpion {
        displayHeader("DIGITAL SKILLS");
        //Takes user selection
        String skillType = askQuestion("Please enter one of following skill groups: ", Arrays.asList("pc", "programming"));
        //Displays first option
        if (skillType.equalsIgnoreCase("pc")) {
            displayHeader("GENERAL PC SKILLS:");
            System.out.println("Expert knowledge of Microsoft Office(Office Libre)");
            System.out.println("Expert knowledge of Excel (Formulas, LOOKUP, conditioning)");
            System.out.println("Expert knowledge of Diamant 3.0 accounting software(OfficialTraining&Experience)");
            System.out.println("User knowledge of Linux OS\n");
        //Displays second option
        } else if (skillType.equalsIgnoreCase("programming")) {
            displayHeader("PROGRAMMING KNOWLEDGE:");
            System.out.println("Good knowledge of Java (Actively Learning)");
            System.out.println("Understanding of Swing and SceneBuilder");
            System.out.println("Understanding of MySql(Actively Learning)");
            System.out.println("Work experience with Scrum tool 'Jira'");
            System.out.println("User knowledge of Git");
            System.out.println("JavaScript(Getting familiar with basics)");
        } else {
            throw new InvalidSkillTypeExcetpion();
        }
    }

    private void printAppInfo() {
        //Displays some info about this app
        displayHeader("APPLICATION INFO");
        System.out.println("Display of personal information in this application is without much detail");
        System.out.println("in order to avoid missue of my private information.\n");
        System.out.println("However basic this app may be, it is 100% designed coded and developed");
        System.out.println("by Aleksandar Stojanovc with purpose of learning and practicing Java code.\n");
        System.out.println("Thank you for using it and respecting my prive information.");
    }
}
