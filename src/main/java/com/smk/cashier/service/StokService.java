package com.smk.cashier.service;

import com.smk.cashier.Model.Stok;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class StokService {
    FileReader StokServiceReader;
    FileWriter StokServiceWriter;

    List<Stok> StokList = new LinkedList<>();

    private static StokService
            StokService=null;

    private StokService() {
        try {
            StokServiceReader = new FileReader("stok.txt");
            StokServiceWriter = new FileWriter("stok.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized StokService getInstance() {
        if (StokService == null){
            StokService = new StokService();
        }
        return StokService;
    }

    private void readFile(){
        BufferedReader bufferedReader = new BufferedReader(StokServiceReader);
        List<String> stringList = bufferedReader.lines().toList();
        StokList = new LinkedList<>();
        for (String string: stringList){
            StokList.add(parsingLineToStok(string));
        }
    }

    private void writeFile(){
        BufferedWriter bufferedWriter = new BufferedWriter(StokServiceWriter);
        for (int i = 0; i < StokList.size(); i++) {
            Stok stok = StokList.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(stok.getId());
            sb.append("|");
            sb.append(stok.getKodeBarang());
            sb.append("|");
            sb.append(stok.getStokBarang());

            try {
                bufferedWriter.write(sb.toString());
                if (i < StokList.size() - 1){
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <string> Stok parsingLineToStok(String string) {
        StringTokenizer st = new StringTokenizer(string, "|");
        int id = 0;
        Stok stok = new Stok();
        while (st.hasMoreElements()){
            if (id == 0) {
                stok.setId(Integer.parseInt(st.nextToken()));

            } else if (id == 1) {
                stok.setKodeBarang(st.nextToken());

            } else if (id == 2) {
                stok.setStokBarang(Integer.parseInt(st.nextToken()));

            }
            id++;
        }
        return stok;
    }

    public List<Stok> getKodeList(){
        readFile();
        return StokList;
    }

    public void addStok(Stok stok) {
        StokList.add(stok);
        writeFile();
    }

    public List<Stok>
    findByKodeBarang(String name){
        List<Stok>
                resultList = StokList.stream().filter( stok -> stok.getKodeBarang().equals(name)
        ).toList();
        return resultList;
    }
}
