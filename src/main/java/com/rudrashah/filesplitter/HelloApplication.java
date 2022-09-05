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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader xml = new FXMLLoader(HelloApplication.class.getResource("21BCM054.fxml"));
        Scene scene = new Scene(xml.load());
        Image image = new Image("/filesplitter.png");
        stage.getIcons().add(image);
        stage.setTitle("21BCM054 Assignment-1 File Splitter");
        stage.setScene(scene);
        stage.show();
    }
}