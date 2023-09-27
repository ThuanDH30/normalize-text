/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.normalize_text;

import java.io.FileNotFoundException;

/**
 *
 * @author Bravo
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        TextNormalization program = new TextNormalization();
        program.NormalizingText("input.txt", "output.txt");
    }
}
