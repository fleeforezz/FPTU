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
 * @param <T>
 */
public interface Business<T> {
    int insertData(T obj);
    int updateData(T obj);
    int deleteData(T obj);
    List<T> listAll();
    
    T getDataById(T obj);
}