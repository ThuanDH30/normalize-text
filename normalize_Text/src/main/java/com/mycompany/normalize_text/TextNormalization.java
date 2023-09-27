/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.normalize_text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Bravo
 */
public class TextNormalization {
    TextManager manager = new TextManager();

    public void NormalizingText(String inputFile, String outputFile) throws FileNotFoundException {
        String fileName = inputFile;
        PrintWriter pw = new PrintWriter(outputFile);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String data;
            for (int i = 0;; i++) {
                data = br.readLine();
                if (data == null) {
                    break;
                }
                if (!data.equals("")) {
                    data = manager.normalizeText(data);
                    pw.println(data);
                    System.out.println(data);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error happen while writing to file");
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }
}
