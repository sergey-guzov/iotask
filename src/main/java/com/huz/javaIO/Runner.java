package com.huz.javaIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

    static String path = "src";
    public static void main(String[] args) {
        if (path == null) {
            throw new RuntimeException("Path is null");
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("Such path doesn't exist: " + path);
        }
        if (file.isDirectory()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/structure.txt"))) {
                StructureAnalyzer analyzer = new StructureAnalyzer();
                analyzer.createFileWithStructure(file,writer,0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.isFile()) {
            try {
                StructureAnalyzer analyzer = new StructureAnalyzer();
                analyzer.returnFileStructure(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
