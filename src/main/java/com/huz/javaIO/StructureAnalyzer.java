package com.huz.javaIO;

import java.io.*;

public class StructureAnalyzer {

    public void createFileWithStructure (File directory, BufferedWriter writer, int level) throws IOException {
        File[] files = directory.listFiles();
        if (files.length == 0) {
            return;
        }
        for (File file:files) {
            for (int i = 0; i < level; i++) {
                writer.write("       ");
            }
            if (file.isDirectory()) {
                writer.write("|----- " + file.getName() + "\n" );
                createFileWithStructure(file,writer,level+1);
            } else if (file.isFile()) {
                writer.write("| " + file.getName() + "\n" );
            }

        }
    }

    public void returnFileStructure (File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int folderNumber = 0;
        int fileNumber = 0;
        int totalFileNameLength = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("|-----")) {
                folderNumber++;
            } else {
                fileNumber++;
                totalFileNameLength += line.replace(" ", "").length();
            }
        }
        reader.close();
        System.out.println("Folders count: " + folderNumber);
        System.out.println("Files count: " + fileNumber);
        System.out.println("Average count of files in folder: " + (double) fileNumber/folderNumber);
        System.out.println("Average length of files name: " + (double) totalFileNameLength/fileNumber);
    }
}
