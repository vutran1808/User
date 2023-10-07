/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.AccountDao;
import java.util.List;
import model.Account;

/**
 *
 * @author ASUS
 */
public class AccountRepository implements IAccountRepository{

    @Override
    public void addAccount(List<Account> userList) {
        AccountDao.Instance().createAccount(userList);
    }

    @Override
    public void login(List<Account> userList) {
        AccountDao.Instance().login(userList);
    }
    
}
