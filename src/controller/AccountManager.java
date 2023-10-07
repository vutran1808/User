/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Account;
import repository.AccountRepository;
import repository.IAccountRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class AccountManager extends Menu{

    private List<Account> userList;
    IAccountRepository mn;
    static String[] mc = {"Create a new Account", "Login System", "Exit"}; 
    
    public AccountManager(){
        super("program", mc);
        mn = new AccountRepository();
        userList = new ArrayList<>();
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.addAccount(userList);
            case 2 -> mn.login(userList);
            case 3 -> System.exit(0);
        }
    }
    
}
