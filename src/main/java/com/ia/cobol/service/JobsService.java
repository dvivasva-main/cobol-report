package com.ia.cobol.service;


import com.ia.cobol.model.Job;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JobsService {

    public List<String> jobs(String filePath) {

        List<String> list = null;
        List<Job> listJob = null;
        Path path = Paths.get(filePath);

        if (Files.exists(path)) {
            list = new ArrayList<>();
            try {
                FileReader fr = new FileReader(filePath);
                BufferedReader reader = new BufferedReader(fr);
                String str;
                while ((str = reader.readLine()) != null) {
                    list.add(str);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;

    }

    public List<String> jobsX(String filePath) {
        List<String> list = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(fr)) {

            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.trim().equals("\\s+")) {
                    list.add(str);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<String> jobsXX(String filePath) {


        List<String> list = new ArrayList<>();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {

            inputStream = new FileInputStream(filePath);

            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.trim().equals("\\s+")) {

                    list.add(line);
                }
                // System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return list;
    }


}
