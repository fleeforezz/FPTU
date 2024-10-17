/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author jso
 */
public interface Business<T> {
    int insertData(T obj);
    int updateData(T obj);
    int deleteData(T obj);
    List<T> listAll();
    
//    Account
    T checkDataExist(String account);
    T getData(String account, String pass);
}
