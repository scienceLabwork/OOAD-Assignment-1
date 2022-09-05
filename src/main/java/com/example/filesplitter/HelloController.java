package com.example.filesplitter;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

import static java.lang.System.out;

public class HelloController {
    public TextField TextFieldNumber;
    public Button buttonFile;
    public Button splitButton;
    public String fname = "";
    public String dir = "";
    @FXML
    public void split() throws notTXT {
        String x = TextFieldNumber.getText();
        if(x.equals("")){
            Alert alert = new Alert(Alert.AlertType.NONE, "Enter minimum number of lines you want to split file into.",ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CANCEL) {
                alert.close();
            }
        }else if(fname.equals("nullnull") || fname.equals("")){
            Alert alert = new Alert(Alert.AlertType.NONE, "Select a file to split.",ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CANCEL) {
                alert.close();
            }
        }else{
            print(fname);
            int n = Integer.parseInt(x);
            splitFile(n,fname, dir);
        }
    }

    public void getButtonFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File fFile = fileChooser.showOpenDialog(buttonFile.getScene().getWindow());
        if (fFile != null) {
            fname = fFile.getAbsolutePath();
            dir = fFile.getParent();
            print(fname);
        }
    }

    public void splitFile(int n, String finput, String dir) throws notTXT{
        ArrayList<String> lines = new ArrayList<String>();
        int c=0;
        try{
            if(!finput.contains(".txt")){
                throw new notTXT("\nFile is not a .txt file");
            }else{
                FileInputStream f = new FileInputStream(finput);
                BufferedReader br = new BufferedReader(new InputStreamReader(f));
                while(true){
                    try{
                        String s = br.readLine();
                        endl();
                        if(c%n==0 && c!=0){
                            String fname = dir+"/21bcm054_"+(c/n)+".txt";
                            File f1 = new File(fname);
                            FileWriter fw = new FileWriter(f1);
                            for(String s1:lines){
                                fw.write(s1+"\n");
                            }
                            fw.close();
                            lines.clear();
                        }
                        if(s==null){
                            break;
                        }
                        lines.add(s);
                        c++;
                    }catch(Exception e){
                        print("There was an error reading the file");
                    }
                }
            }
        }catch(FileNotFoundException e){
            print("File not found");
        }
        if(lines.size()!=0){
            try {
                int m = (c/n)+1;
                String fname = dir+"/21bcm054_"+String.valueOf(m)+".txt";
                File f1 = new File(fname);
                FileWriter fw = new FileWriter(f1);
                for(String s1:lines){
                    fw.write(s1+"\n");
                }
                fw.close();
                lines.clear();
            } catch (Exception e) {
                print(e);
            }
        }
        Alert alert = new Alert(Alert.AlertType.NONE, "File split successfully.",ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            alert.close();
        }
    }
    private static <T>void print(T s){
        out.print(s);
    }
    public static void endl(){
        out.println();
    }
}