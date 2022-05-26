import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class DashController implements Initializable{

    @FXML
    private PieChart ChartInfS;

    @FXML
    private PieChart ChartInfT;

    @FXML
    private Label TotalData;

    @FXML
    private Label TotalS;

    @FXML
    private Label TotalT;

    
    @FXML
    private PieChart ChartPopu;

    @FXML
    private Pane pnlDashboard;
    
    public int TempT = 0;
    public int TempS = 0;
    public int TempAdata = 0;
    public int CountInfS = 0;
    public int CountInfSed = 0;
    public int CountInfT = 0;
    public int CountInfTed = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        TempT = (int) getLineDataT("E:/KMITL/1.2/oop/Project1/Main/record.txt");
        //System.out.println(TempT);
        TempS = (int) getLineDataT("E:/KMITL/1.2/oop/Project1/Main/recordStu.txt");
        //System.out.println(TempS);

        try {
            CountInfS = TempS - countFile("recordStu.txt");
            CountInfSed = countFile("recordStu.txt");
            //System.out.println(CountInfS);
            CountInfT = TempT - countFile("record.txt");
            CountInfTed = countFile("record.txt");

            //System.out.println(CountInfT);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        TotalT.setText(String.valueOf(getLineDataT("E:/KMITL/1.2/oop/Project1/Main/record.txt")));
        TotalS.setText(String.valueOf(getLineDataS("E:/KMITL/1.2/oop/Project1/Main/recordStu.txt")));
        TempAdata = TempT + TempS;
        TotalData.setText(String.valueOf(TempAdata));

        ObservableList<Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Teacher", TempT),
                new PieChart.Data("Student", TempS)
        );
        ChartPopu.setData(list);

        ObservableList<Data> list2 = FXCollections.observableArrayList(
            new PieChart.Data("Infected", CountInfTed),
            new PieChart.Data("Non Infected", CountInfT)
        );
        ChartInfT.setData(list2);

        ObservableList<Data> list3 = FXCollections.observableArrayList(
            new PieChart.Data("Infected", CountInfSed),
            new PieChart.Data("Non Infected", CountInfS)
        );
        ChartInfS.setData(list3);

        
        
        
    }
    public static long getLineDataS(String fileName) {

        java.nio.file.Path path = Paths.get(fileName);
  
        long lines = 0;
        try {
            lines = Files.lines(path).count();
  
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        return lines;
  
    }

    public static long getLineDataT(String fileName) {

        java.nio.file.Path path = Paths.get(fileName);
  
        long lines = 0;
        try {
            lines = Files.lines(path).count();
  
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        return lines;
  
    }

    public static int countFile(String filepath) throws FileNotFoundException{
        File file = new File(filepath);
            
            Scanner in = new Scanner(file);
            int Covidcount = 0;
            while (in.hasNext())
            {
                String[] line = (in.nextLine()).split(",");
                //System.out.println(line[0]);
                if(line[8].equals("Yes"))//no
                {
                    Covidcount++;
                }
            }
            return Covidcount;
    }

}
