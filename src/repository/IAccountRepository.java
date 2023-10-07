/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Account;

/**
 *
 * @author ASUS
 */
public interface IAccountRepository {
    void addAccount(List<Account> userList);
    void login(List<Account> userList);
}
