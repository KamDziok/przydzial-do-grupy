/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class LoadData {

    private ArrayList<Data> list = new ArrayList();
    private int totalLine = 0;
    private int loadedLine = 0;

    public LoadData() throws IOException {
        BufferedReader fileReader = null;
        Data tempData = null;
        double FF = 0, FS = 0, SF = 0, SS = 0;
        String charGroup = null, number = null, numberTemp = null;
        boolean charTemp = false;
        int i = 0, charOfSet = 0;

        try {
            fileReader = new BufferedReader(new FileReader("learning.txt"));
            String line;
            while ((line = fileReader.readLine()) != null) {
                totalLine++;
            }
        } catch (Exception e) {
            System.out.println("Error1. " + e.getLocalizedMessage());
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

//        for (Data d : list) {
//            System.out.println(d.toString());
//        }
    }

    public void loadDataInt(int userLoadedLine) throws IOException {
        BufferedReader fileReader = null;
        Data tempData = null;
        double FF = 0, FS = 0, SF = 0, SS = 0;
        String charGroup = null, number = null, numberTemp = null;
        boolean charTemp = false;
        int i = 0, charOfSet = 0;

        int stop = userLoadedLine + loadedLine;
        if (stop <= totalLine) {
            try {
                fileReader = new BufferedReader(new FileReader("learning.txt"));
                String line;
                String[] tabString;
//            while ((line = fileReader.readLine()) != null) {
                for (int it = 0; it < stop; it++) {
                    if (it >= loadedLine) {
                        line = fileReader.readLine();
//                tabString = line.split("|");
//                 for(String temp : tabString){
                        String[] temp2;
//                     try{
//                         temp2 = temp.split(";");
//                         i = 0;
                        temp2 = line.split("");
                        for (String temp3 : temp2) {
                            if (!(temp3.equals(";")) && !(temp3.equals("|")) && !(temp3.equals(" ")) && !(temp3.equals("[")) && !(temp3.equals(")"))) {
                                //System.out.println(number);
                                if (number != null && !charTemp) {
                                    if (i == 0) {
                                        FF = Double.parseDouble(number);
                                    }
                                    if (i == 1) {
                                        FS = Double.parseDouble(number);
                                    }
                                    if (i == 2) {
                                        SF = Double.parseDouble(number);
                                    }
                                    if (i == 3) {
                                        SS = Double.parseDouble(number);
                                    }
                                    if (i < 4) {
                                        i++;
                                    }
                                    number = null;
                                }
                                if (temp3.equals(",")) {
                                    number = numberTemp + ".";
                                    charTemp = true;
                                } else {
                                    if (charTemp) {
                                        number = number + temp3;
                                        charTemp = false;
                                        i--;
                                    } else {
                                        number = temp3;
                                        numberTemp = number;
                                    }
                                    if (temp3.equals("A") || temp3.equals("B") || temp3.equals("C")) {
                                        if (temp3.equals("A")) {
                                            charGroup = "A";
                                        }
                                        if (temp3.equals("B")) {
                                            charGroup = "B";
                                        }
                                        if (temp3.equals("C")) {
                                            charGroup = "C";
                                        }
                                        i = 0;
                                        number = null;
                                    }
                                }
                            }
//                             System.out.println(temp3);
                        }
//                tempData.setFFnumber(FF);
//                tempData.setFSnumber(FS);
//                tempData.setSFnumber(SF);
//                tempData.setSSnumber(SS);
                        tempData = new Data(FF, FS, SF, SS);
                        if (charGroup.equals("A")) {
                            tempData.addToA();
                            charOfSet = 0;
                        }
                        if (charGroup.equals("B")) {
                            tempData.addToB();
                            charOfSet = 1;
                        }
                        if (charGroup.equals("C")) {
                            tempData.addToC();
                            charOfSet = 3;
                        }

                        //dodawanie do listy
                        if (list.isEmpty()) {
                            list.add(tempData);
                        } else {
                            for (Data d : list) {
                                if ( //d.getFFnumber() == tempData.getFFnumber() && d.getFSnumber() == tempData.getFSnumber() && d.getSFnumber() == tempData.getSFnumber() && d.getSSnumber() == tempData.getSSnumber() 
                                        d.porownanie(tempData)) {
                                    if (charOfSet == 0) {
                                        d.addToA();
                                    }
                                    if (charOfSet == 1) {
                                        d.addToB();
                                    }
                                    if (charOfSet == 2) {
                                        d.addToC();
                                    }
                                    break;
                                }
                                if (d.porownanie(list.get(list.size() - 1))) {
                                    list.add(tempData);
                                    break;
                                }
                                //System.out.println(d.toString());
                            }

                        }
                        //System.out.println(tempData.toString() + " " + charGroup);
//                     }catch(Exception e1){
//                         System.out.println("Error2. " + e1.getLocalizedMessage());
//                     }

//                 }
//                line = fileReader.readLine();
                    loadedLine++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error1. " + e.getLocalizedMessage());
            } finally {
                if (fileReader != null) {
                    fileReader.close();
                }
            }
        }
    }

    public int getloadedLine() {
        return loadedLine;
    }
    
    public int getTotalLine() {
        return totalLine;
    }

    public ArrayList<Data> lista() {
        return list;
    }

}
