 /*MIT License

  * Copyright (c) 2022 Rudra Shah

  * Permission is hereby granted, free of charge, to any person obtaining a copy
  * of this software and associated documentation files (the "Software"), to deal
  * in the Software without restriction, including without limitation the rights
  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  * copies of the Software, and to permit persons to whom the Software is
  * furnished to do so, subject to the following conditions:
  *
  * The above copyright notice and this permission notice shall be included in all
  * copies or substantial portions of the Software.
  *
  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  * SOFTWARE.
  *
  * -- LICENSE ENDS --
  *
  * Name: Rudra Shah
  * Roll No: 21BCM054
  * Class: 2nd Year CSE-MBA
  * Section: I
  * College: Nirma University
  * Subject: OOAD -> OBJECT ORIENTED APPLICATION DEVELOPMENT
  * Assignment: 1
  */

package com.rudrashah.filesplitter;

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
    public int fc = 0;
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
        int m=0;
        try{
            if(!finput.contains(".txt")){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Select a .txt file to split.",ButtonType.CANCEL);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CANCEL) {
                    alert.close();
                }
                throw new notTXT("\nFile is not a .txt file");
            }else{
                FileInputStream f = new FileInputStream(finput);
                BufferedReader br = new BufferedReader(new InputStreamReader(f));
                while(true){
                    try{
                        String s = br.readLine();
                        endl();
                        if(c%n==0 && c!=0){
                            fc++;
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
                fc++;
                m = (c/n)+1;
                String fname = dir+"/21bcm054_"+ m +".txt";
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
        Alert alert = new Alert(Alert.AlertType.NONE, "File split successfully.\n"+"Total Files Generated: "+ fc
                +"\nGenerated Directory: "+dir,ButtonType.OK);
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