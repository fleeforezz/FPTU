
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 * @param <Object>
 */
public interface Business<Object> {
    public int addRec(Object obj);
    
    public int updateRec(Object obj);
    
    public void listAll();
}
