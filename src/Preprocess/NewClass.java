/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preprocess;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class NewClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Stemword sw =new Stemword();
        //sw.readdata();
        sw.Stemming();
         
    }
}
