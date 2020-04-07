package com.gmail.ptimofejev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Main.SaveToFile(path="savedtext.txt")
public class TextContainer {
    private String text;

    public TextContainer() {

    }

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Main.SaverService
    public void save(String path){
        File file = new File(path);
        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(file))) {
            bw1.write(text);
            bw1.newLine();
            System.out.println("File successfully written");
        } catch (IOException e) {
            System.out.println("Error occurred while writing the File. Check inputs and try again");
        }
    }
}
