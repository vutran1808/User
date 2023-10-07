/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.ScannerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ASUS
 */
public class AccountDao {

    ScannerFactory sc;
    private static List<Account> userList = new ArrayList<>();
    public static AccountDao instance = null;

    public AccountDao() {
        sc = new ScannerFactory();
    }

    public static AccountDao Instance() {
        if (instance == null) {
            synchronized (AccountDao.class) {
                if (instance == null) {
                    instance = new AccountDao();
                }
            }
        }
        return instance;
    }

    public void createFile() {
        try {
            File file = new File("src\\model\\user.dat");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already existed: " + file.getName());
            }
        } catch (IOException ex) {
            System.out.println("An error occured");
        }
    }

    public void readFile(List<Account> userList) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src\\model\\user.dat"));
            String line = bf.readLine();
            while (line != null) {
                String[] data = line.trim().split(",");
                String[] data1 = data[0].trim().split(":");
                String[] data2 = data[1].trim().split(":");
                String userName = data1[1].trim();
                String password = data2[1].trim();
                userList.add(new Account(userName, password));
                line = bf.readLine();
            }
        } catch (Exception e) {
        }
    }

    public void writeFile(List<Account> userList) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("src\\model\\user.dat"));
            for (Account acc : userList) {
                pw.println("userName: " + acc.getUserName() + ", password: " + acc.getPassword());
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong...");
        }
    }

    public Account getAccount() {
        System.out.println("Enter Username: ");
        String userName = sc.getString();
        System.out.println("Enter Password: ");
        String password = sc.getString();
        return new Account(userName, password);
    }

    public void createAccount(List<Account> userList) {
        createFile();
        Account acc = getAccount();
        if (checkAccount(userList, acc)) {
            userList.add(acc);
            System.out.println("Added");
            writeFile(userList);
        } else {
            System.out.println("UserName existed!");
        }
    }

    public boolean checkAccount(List<Account> userList, Account acc) {
        for (Account account : userList) {
            if (account.getUserName().equals(acc.getUserName())) {
                return false;
            }
        }
        return true;
    }

    public void login(List<Account> userList) {
        showAll(userList);
        Account loginAcc = getAccount();
        for (Account account : userList) {
            if (account.getUserName().equals(loginAcc.getUserName()) && account.getPassword().equals(loginAcc.getPassword())) {
                System.out.println("Login succesful!");
            } else {
                System.out.println("No acc found");
            }
        }
    }
    
    public void showAll(List<Account> userList){
        for (Account account : userList) {
            System.out.println(account.toString());
        }
    }

}
