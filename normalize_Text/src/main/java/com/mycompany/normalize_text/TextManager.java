/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.normalize_text;

/**
 *
 * @author Bravo
 */
public class TextManager  {
    public String normalizeText(String input) {
        // Loại bỏ các khoảng trắng đầu và cuối chuỗi
        input = input.trim();

        // Loại bỏ khoảng trắng thừa giữa các từ
        input = input.replaceAll("\\s+", " ");

        // Loại bỏ khoảng trắng trước và sau dấu phẩy, dấu chấm, và dấu hai chấm
        input = input.replaceAll("\\s*,\\s*", ", ");
        input = input.replaceAll("\\s*\\.\\s*", ". ");
        input = input.replaceAll("\\s*:\\s*", ": ");

        // Chuyển đổi chữ cái đầu tiên sau dấu chấm thành chữ hoa
        input = capitalizeAfterDot(input);

        // Loại bỏ khoảng trắng sau dấu ngoặc kép đóng và trước dấu ngoặc kép mở
        input = input.replaceAll("(?<=\")\\s+|\\s+(?=\")", "");

        // Chuyển đổi chữ cái đầu tiên của câu thành chữ hoa
        input = capitalizeFirstLetter(input);

        // Loại bỏ các dòng trắng và thêm dấu chấm ở cuối nếu cần
        input = removeBlankLines(input);
        if (!input.endsWith(".")) {
            input += ".";
        }

        return input;
    }

    public String capitalizeAfterDot(String input) {
        String[] sentences = input.split("\\.");

        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            StringBuilder normalizedSentence = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                String word = words[i].trim();
                if (!word.isEmpty()) {
                    if (i == 0) {
                        word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                    } else {
                        word = word.toLowerCase();
                    }
                    normalizedSentence.append(word);
                    if (i < words.length - 1) {
                        normalizedSentence.append(" ");
                    }
                }
            }

            if (normalizedSentence.length() > 0) {
                result.append(normalizedSentence.toString());
                result.append(". "); // Thêm dấu chấm ở cuối câu
            }
        }
        return result.toString().trim();
    }

    public String capitalizeFirstLetter(String input) {
        String[] lines = input.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (!line.isEmpty()) {
                line = line.substring(0, 1).toUpperCase() + line.substring(1);
                result.append(line).append("\n");
            }
        }

        return result.toString().trim();
    }

    public String removeBlankLines(String input) {
        String[] lines = input.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                result.append(line).append("\n");
            }
        }

        return result.toString().trim();
    }
}
