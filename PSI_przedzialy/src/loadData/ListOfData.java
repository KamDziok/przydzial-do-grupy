/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadData;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ListOfData {
    private ArrayList<Data> list = new ArrayList<>();
    
    public void add(Data data){
        list.add(data);
    }
}
