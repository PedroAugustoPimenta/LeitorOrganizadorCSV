package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CSV {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String line = null;
        BufferedReader stream = null;
        List<Item> csvData = new ArrayList<Item>();
        List<Item> Ordenada = new ArrayList<Item>();

        List<Item> lista1 = new ArrayList<Item>();
        List<Item> lista2 = new ArrayList<Item>();
        List<Item> lista3 = new ArrayList<Item>();
        List<Item> lista4 = new ArrayList<Item>();

        try {
            stream = new BufferedReader(new FileReader("C:\\Users\\Pedro\\Documents\\NetBeansProjects\\CSV\\SitesDesordenados_20191023143316.csv")); // Podes usar BufferedReader ao invés do CSVReader 
            while ((line = stream.readLine()) != null) {
                String[] separador = line.split(";"); // Provavelmente teu separador é , ou ; depende do teu arquivo

                Item site = new Item(separador[0], Integer.valueOf(separador[1]));

                csvData.add(site);

            }
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        for (int i = 0; i < csvData.size(); i++) {

            if (csvData.get(i).getClassificacao() == 1) {

                lista1.add(csvData.get(i));
            }

            if (csvData.get(i).getClassificacao() == 2) {

                lista2.add(csvData.get(i));
            }

            if (csvData.get(i).getClassificacao() == 3) {

                lista3.add(csvData.get(i));
            }

            if (csvData.get(i).getClassificacao() == 4) {

                lista4.add(csvData.get(i));
            }

        }
        Comparador comparador = new Comparador();
        Collections.sort(lista1, comparador);
        Collections.sort(lista2, comparador);
        Collections.sort(lista3, comparador);
        Collections.sort(lista4, comparador);

        for (int i = 0; i < lista1.size(); i++) {
            Ordenada.add(lista1.get(i));
        }

        for (int i = 0; i < lista2.size(); i++) {
            Ordenada.add(lista2.get(i));
        }
        for (int i = 0; i < lista3.size(); i++) {
            Ordenada.add(lista3.get(i));
        }
        for (int i = 0; i < lista4.size(); i++) {
            Ordenada.add(lista4.get(i));
        }

        for (int i = 0; i < Ordenada.size(); i++) {
            System.out.println("Site: " + Ordenada.get(i).getSite() + "\n" + "Tipo;" + Ordenada.get(i).getClassificacao());
        }
        
        try {
            FileWriter fstream = new FileWriter("C:\\Users\\Pedro\\Documents\\NetBeansProjects\\CSV\\SitesOrdenados.csv");
            BufferedWriter out = new BufferedWriter(fstream);
            
            for (int i = 0; i < Ordenada.size(); i++) {
                out.write(Ordenada.get(i).getSite());
                out.append(";");
                int b = Ordenada.get(i).getClassificacao();
                out.write(String.valueOf(b));
                out.append("\n");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }
}