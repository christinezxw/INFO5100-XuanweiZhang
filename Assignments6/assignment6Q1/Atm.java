package assignment6Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Atm {
    private int availableAmountInMachine;
    private int transactionFee;
    private ArrayList<ArrayList<String>> userData = new ArrayList<ArrayList<String>>();
    // name,age,address,phone,account,password,balance

    // store user logging info, key:accountNum value:password
    private HashMap<String, String> userLogInfo = new HashMap<String, String>();
    // store all users
    private ArrayList<User> users = new ArrayList<User>();
    private boolean logginStatus = false;
    private User curUser;

    public Atm(int availableAmountInMachine, int transactionFee, ArrayList<ArrayList<String>> userData) {
        super();
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userData = userData;
        generateUsers();
    }

    // initialize users and login info using userData
    private void generateUsers() {
        for (int i = 0; i < userData.size(); i++) {
            String[] ini = new String[7];
            User addingUser;
            for (int j = 0; j < userData.get(i).size(); j++) {
                ini[j] = userData.get(i).get(j);
            }
            addingUser = new User(ini[0], Integer.parseInt(ini[1]), ini[2], ini[3], ini[4]);
            users.add(addingUser);
            addingUser.setAvailableBalance(Integer.parseInt(ini[6]));
            userLogInfo.put(ini[4], ini[5]);
        }
    }

    // ask for user login
    public void startService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for New User, 2 for Current User:");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            createNewUser(scanner);
        }
        if (line.equals("2")) {
            userLogIn(scanner);
        }
    }

    private void createNewUser(Scanner scanner) {
        System.out.println(
                "Enter new user informations: name\\age\\address\\phone number\\bank account number\\password");
        String line = scanner.nextLine();
        String tokens[] = line.split("\\,");
        // new a user and store into users
        users.add(new User(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]));
        // update user login info
        userLogInfo.put(tokens[4], tokens[5]);
        // login after create
        System.out.println("New user created. Please loggin.");
        userLogIn(scanner);
    }

    // user log in
    private void userLogIn(Scanner scanner) {
        System.out.println("Enter user loggin informations: bank account number\\password");
        String line = scanner.nextLine();
        String tokens[] = line.split("\\,");
        // check if the account number and password match
        // not match:
        if (userLogInfo.containsKey(tokens[0]) == false || userLogInfo.get(tokens[0]).equals(tokens[1]) == false) {
            System.out.println("Wrong information! Enter 1 for retry, 2 for reset password, 3 for leave");
            line = scanner.nextLine();
            if (line.equals("1")) {
                // try again
                userLogIn(scanner);
            } else if (line.equals("2")) {
                // reset password
                resetPassword(scanner);
            } else if (line.equals("3")) {
                // leave system
                return;
            }

        }
        // match
        else {
            logginStatus = true;// log in success
            curUser = findUser(tokens[0]);
            mainInterface(scanner);
        }
    }

    // user forget password, reset
    private void resetPassword(Scanner scanner) {
        System.out.println("Validating identity! Enter bank account number");
        String line = scanner.nextLine();
        // find user according to account number
        User curUser = findUser(line);
        // not find:
        if (curUser == null) {
            System.out.println("Wrong account! Enter 1 for retry, 2 for create new account, 3 for leave");
            line = scanner.nextLine();
            if (line.equals("1")) {
                // retry
                resetPassword(scanner);
            } else if (line.equals("2")) {
                // create new account
                createNewUser(scanner);
            } else if (line.equals("3")) {
                // leave system
                return;
            }
        }
        // find:
        else {
            System.out.println("Validating identity! Enter user informations: name\\age\\phone number");
            line = scanner.nextLine();
            String tokens[] = line.split("\\,");
            // check identity
            // identity match:
            if (userInfoMatch(curUser, tokens)) {
                System.out.println("Validated! Enter: bank account number\\new password");
                line = scanner.nextLine();
                String tokens1[] = line.split("\\,");
                // reset password of user in users
                userLogInfo.put(tokens1[0], tokens1[1]);
                System.out.println("Already reset. Please loggin again.");
                // login again
                userLogIn(scanner);
            }
            // not match:
            else {
                System.out.println("Fail Validation! Enter 1 for retry, 2 for leave");
                if (line.equals("1")) {
                    // retry
                    resetPassword(scanner);
                } else if (line.equals("2")) {
                    // leave system
                    return;
                }
            }
        }
    }

    private boolean userInfoMatch(User user, String tokens[]) {
        if (user.getName().equals(tokens[0]) && user.getAge() == Integer.parseInt(tokens[1])
                && user.getPhoneNumber().equals(tokens[2])) {
            return true;
        }
        return false;
    }

    private User findUser(String bankAccountNumber) {
        for (User u : users) {
            if (u.getBankAccountNumber().equals(bankAccountNumber)) {
                return u;
            }
        }
        return null;
    }

    public boolean isLogginStatus() {
        return logginStatus;
    }

    // exit
    public void exit() {
        logginStatus = false;
        curUser = null;
    }

    // return user's current balance
    public void availableBalance(Scanner scanner) {
        if (logginStatus) {
            System.out.println(curUser.getName() + "'s available balance in account " + curUser.getBankAccountNumber()
                    + " is " + curUser.getAvailableBalance());
            // back to main menu
            System.out.println("Enter 1 back to main menu:");
            String line = scanner.nextLine();
            if (line.equals("1")) {
                mainInterface(scanner);
            }

        } else {
            System.out.println("Please login!");
        }
    }

    // withdraw money
    public void withDrawal(int money, Scanner scanner) {
        if (logginStatus) {
            // check if this machine has enough money
            if (this.availableAmountInMachine >= money) {
                // check if user's account has enough balance
                if (curUser.getAvailableBalance() >= money + this.transactionFee) {
                    // update user's balance with money as well as additional fee
                    curUser.setAvailableBalance(curUser.getAvailableBalance() - money - this.transactionFee);
                    // update transaction record
                    String newTransaction = "Withdraw --- $" + money;
                    curUser.addRecentTransaction(newTransaction);
                    // update this machine's remaining
                    this.availableAmountInMachine -= money;
                    // system output action
                    System.out.println(curUser.getName() + " withdraw $" + money + " from account "
                            + curUser.getBankAccountNumber());
                } else {
                    System.out.println("Amount exceed your balance!");
                }

            } else {
                System.out.println("Money not enough for this machine!");
            }
            // back to main menu
            System.out.println("Enter 1 back to main menu:");
            String line = scanner.nextLine();
            if (line.equals("1")) {
                mainInterface(scanner);
            }
        } else {
            System.out.println("Please login!");
        }
    }

    public void deposit(int money, Scanner scanner) {
        if (logginStatus) {
            // update user's balance with money as well as additional fee
            curUser.setAvailableBalance(curUser.getAvailableBalance() + money - this.transactionFee);
            // update transaction record
            curUser.addRecentTransaction("Deposit --- $" + money);
            // update this machine's remaining
            this.availableAmountInMachine += money;
            // system output action
            System.out.println(
                    curUser.getName() + " deposit $" + money + " into account " + curUser.getBankAccountNumber());
            // back to main menu
            System.out.println("Enter 1 back to main menu:");
            String line = scanner.nextLine();
            if (line.equals("1")) {
                mainInterface(scanner);
            }
        } else {
            System.out.println("Please login!");
        }
    }

    public void recentTransactions(Scanner scanner) {
        if (logginStatus) {
            // print transactions record
            System.out.println("Here is the recent transactions for " + curUser.getName() + " of account "
                    + curUser.getBankAccountNumber());
            for (int i = 0; i < curUser.getRecentTransaction().size(); i++) {
                System.out.println(curUser.getRecentTransaction().get(i));
            }
            // back to main menu
            System.out.println("Enter 1 back to main menu:");
            String line = scanner.nextLine();
            if (line.equals("1")) {
                mainInterface(scanner);
            }
        } else {
            System.out.println("Please login!");
        }
    }

    public void changePassword(Scanner scanner) {
        resetPassword(scanner);
    }

    public void mainInterface(Scanner scanner) {
        System.out.println("Hello " + curUser.getName() + "! ");
        System.out.println(
                "Enter 1 for check your available balance, 2 for withdraw, 3 for deposit, 4 for check recent transactions, 5 for change password, 6 for exit:");
        String line = scanner.nextLine();
        if (line.equals("1")) {
            availableBalance(scanner);
        } else if (line.equals("2")) {
            System.out.println("Enter amount:");
            line = scanner.nextLine();
            withDrawal(Integer.parseInt(line), scanner);
        } else if (line.equals("3")) {
            System.out.println("Enter amount:");
            line = scanner.nextLine();
            deposit(Integer.parseInt(line), scanner);
        } else if (line.equals("4")) {
            recentTransactions(scanner);
        } else if (line.equals("5")) {
            changePassword(scanner);
        } else if (line.equals("6")) {
            exit();
        }
    }

}
