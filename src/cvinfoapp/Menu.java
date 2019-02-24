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

    private void displayContent1(String message) {
        //Reusable method for desplaying content
        System.out.println();
        //Defines message length as message 
        int width = message.length();
        //Creates StringBuilder method
        StringBuilder sb = new StringBuilder();
        //Appends 1 sign - to body of toString in width per char
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Prints built toString above the custom message
        System.out.println(sb.toString());
        System.out.println(message);
        System.out.println(sb.toString());
    }

    private void displayContent3(String message, String message1, String message2) {
        //Reusable method for desplaying content
        System.out.println();
        //Defines message length as message + 25 spaces
        int width = message.length() + 25;
        //Creates StringBuilder method
        StringBuilder sb = new StringBuilder();
        //Appends 1 sign - to body of toString in width per char
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Prints built toString above the custom message
        System.out.println(sb.toString());
        System.out.println(message);
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(sb.toString());
    }

    private void displayContent4(String message, String message1, String message2, String message3) {
        //Reusable method for desplaying content
        System.out.println();
        //Defines message length as message + 25 spaces
        int width = message.length() + 25;
        //Creates StringBuilder method
        StringBuilder sb = new StringBuilder();
        //Appends 1 sign - to body of toString in width per char
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Prints built toString above the custom message
        System.out.println(sb.toString());
        System.out.println(message);
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
        System.out.println(sb.toString());
    }

    private void displayContent5(String message, String message1, String message2, String message3, String message4) {
        //Reusable method for desplaying content
        System.out.println();
        //Defines message length as message + 25 spaces
        int width = message.length() + 25;
        //Creates StringBuilder method
        StringBuilder sb = new StringBuilder();
        //Appends 1 sign - to body of toString in width per char
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        //Prints built toString above the custom message
        System.out.println(sb.toString());
        System.out.println(message);
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
        System.out.println(message4);
        System.out.println(sb.toString());
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

    private void printPersonalInfo() {
        displayHeader("PERSONAL INFORMATION");
        displayContent4("Name: Aleksandar Stojanovic", "Email: 1plsdontsapmme@gmail.com",
                "Address: Cara Dusana Doboj, Bosnia and Herzegovina", "Phone number: 0038765***900");
    }

    private void printWorkExperience() {
        displayHeader("WORK EXPERIENCE");
        displayContent3("01.06.2017 - Present: Vice chief Accountant in international company.",
                "21.11.2016 - 03.05.2017: Bar Owner/Manager.",
                "03.10.2013 - 15.06.2016: Proffesional translator of ducments and scientific papaers.");
    }

    private void printEducation() {
        displayHeader("EDUCATION");
        displayContent3("30.10.2013 - 06.09.2016: Master of Arts in English Language and Literature",
                "08.07.2019 - 18.06.2013: Bachelor of Arts in English Language and Literature",
                "02.09.2005 - 15.06.2009: Economics technician");
    }

    private void printGeneralSkills() throws InvalidSkillTypeExcetpion {
        displayHeader("GENERAL SKILLS");
        //Takes user selection
        String skillType = askQuestion("Please enter one of the following options: ", Arrays.asList("communication", "organization", "speciality", "traits"));
        //Displays first option
        if (skillType.equalsIgnoreCase("communication")) {
            displayHeader("COMMUNICATION SKILLS");;
            displayContent4("Advanced skills in communication with:",
                    "Superiors/Colleagues/Customers/Partners",
                    "Advanced business communication skills including:",
                    "Negotiation/Ordering/Advising/Consulting/Presentation");
            //Displays second option
        } else if (skillType.equalsIgnoreCase("organization")) {
            displayHeader("ORGANISATIONAL/MANAGERIAL SKILLS:");
            displayContent3("Department organization:",
                    "Organizing shifts/Vacation planning/Bonuses (rewards)/Staff requirements",
                    "Employee evaluations/Monitoring/Correcting/Training employees/Task prioritization");
            //Displays third option
        } else if (skillType.equalsIgnoreCase("speciality")) {
            displayHeader("SPECIALITY KNOWLEDGE:");
            displayContent1("Accounting/Finance/Management");
            //Displays fourth option
        } else if (skillType.equalsIgnoreCase("traits")) {
            displayHeader("PERSONAL TRAITS:");
            displayContent1("Precise/Hardworking/Responsible/Reliable/Determined/Great pressure handling");
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
            displayContent4("Expert knowledge of Microsoft Office(Office Libre)",
                    "Expert knowledge of Excel (Formulas, LOOKUP, conditioning)",
                    "Expert knowledge of Diamant 3.0 accounting software(OfficialTraining&Experience)",
                    "User knowledge of Linux OS");
            //Displays second option
        } else if (skillType.equalsIgnoreCase("programming")) {
            displayHeader("PROGRAMMING KNOWLEDGE:");
            displayContent5("Good knowledge of Java(Swing,SceneBuilder)(Actively Learning)",
                    "Understanding of MySql(Actively Learning)",
                    "Work experience with Scrum tool 'Jira'",
                    "User knowledge of Git",
                    "JavaScript(Getting familiar with basics)");
        } else {
            throw new InvalidSkillTypeExcetpion();
        }
    }

    private void printAppInfo() {
        //Displays some info about this app
        displayHeader("APPLICATION INFO");
        displayContent5("Display of personal information in this application is without much detail",
                "in order to avoid missue of my private information.\n",
                "However basic this app may be, it is 100% designed coded and developed",
                "by Aleksandar Stojanovc with purpose of learning and practicing Java code.\n",
                "Thank you for using it and respecting my prive information.");
    }

}
