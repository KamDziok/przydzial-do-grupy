package psi_przedzialy;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import loadData.*;

public class GUIController {

    ArrayList<Data> list;
    private int loadedLine = 0;
    private int totalLine = 0;
    LoadData data;
    
    public GUIController() {
        try {
            data = new LoadData();
            updateData();
        } catch (IOException e) {
            System.out.println("Error. " + e.getLocalizedMessage());
        }
//        for (Data d : list) {
//            System.out.println(d.toString());
//        }
    }
    
    private void updateData(){
        list = data.lista();
        loadedLine = data.getloadedLine();
        totalLine = data.getTotalLine();
    }
    
    private void setTesttoLabel(){
        labelTotalLine.setText(inttoString(totalLine));
        labelLoadedLine.setText(inttoString(loadedLine));
        labelMaxLoadedLine.setText(inttoString( (totalLine - loadedLine) ));
    }
    
    private String inttoString(int i){
        return "" + i;
    }

    @FXML
    private Button ButtonCheck;

    @FXML
    private Label LabelResult;

    @FXML
    private Label LabelResult1;

    @FXML
    private TextField TFFFnumber;

    @FXML
    private TextField TFFSnumber;

    @FXML
    private TextField TFSFnumber;

    @FXML
    private TextField TFSSnumber;
    
    @FXML
    private Button buttonUserLoadedLine;

    @FXML
    private TextField tfUserLoadedLine;

    @FXML
    private Label labelTotalLine;

    @FXML
    private Label labelLoadedLine;

    @FXML
    private Label labelMaxLoadedLine;

    public void handleButtonClick() {
//        System.out.println("OK");
        double FFnumber = Double.parseDouble(TFFFnumber.getText());
        double FSnumber = Double.parseDouble(TFFSnumber.getText());
        double SFnumber = Double.parseDouble(TFSFnumber.getText());
        double SSnumber = Double.parseDouble(TFSSnumber.getText());
        int maxD = 0;
        boolean checkResult = false;

        Data tempData = new Data(FFnumber, FSnumber, SFnumber, SSnumber);
        for (Data d : list) {
//            System.out.println("");
            if (tempData.porownanie(d)) {
                maxD = 0;
                if (maxD < d.getB()) {
                    maxD = 1;
                }
                if (maxD < d.getC()) {
                    maxD = 2;
                }
                if (maxD == 0) {
                    LabelResult1.setText("A");
                    break;
                }
                if (maxD == 1) {
                    LabelResult1.setText("B");
                    break;
                }
                if (maxD == 2) {
                    LabelResult1.setText("C");
                    break;
                }
            }
            if (d.porownanie(list.get(list.size() - 1))) {
                checkResult = true;
//                LabelResult1.setText("brak danych");
            }
        }
        if (checkResult) {
            for (Data d : list) {
//            System.out.println("");
                if (tempData.porownanieApro(d)) {
                    maxD = 0;
                    if (maxD < d.getB()) {
                        maxD = 1;
                    }
                    if (maxD < d.getC()) {
                        maxD = 2;
                    }
                    if (maxD == 0) {
                        LabelResult1.setText("A");
                        break;
                    }
                    if (maxD == 1) {
                        LabelResult1.setText("B");
                        break;
                    }
                    if (maxD == 2) {
                        LabelResult1.setText("C");
                        break;
                    }
                }
                if (d.porownanie(list.get(list.size() - 1))) {
                    LabelResult1.setText("brak danych");
                }
            }
        }
    }//handleButtonClick
    
    @FXML
    void handleButtonLoadedLine() {
        try{
            int temp = 0;
            temp = Integer.parseInt(tfUserLoadedLine.getText());
            data.loadDataInt(temp);
            updateData();
        }catch(Exception e){
            System.out.println("Błąd. " + e.getLocalizedMessage());
        }
        setTesttoLabel();
    }//handleButtonLoadedLine

}//GUIController

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
