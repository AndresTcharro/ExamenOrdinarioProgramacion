/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
        String ruta;
        BufferedReader br = null;
        String cvsSplitBy = ";";
        String line = "";
        ArrayList<String[]> contenido = new ArrayList<String[]>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introuduza el nombre del archivo:");
        String rutaArchivo = entrada.nextLine();
        ruta = "sources\\Bomberos" + rutaArchivo;
        try {
            br = new BufferedReader(new FileReader(ruta));

            while ((line = br.readLine()) != null) {

                String[] datos = line.split(cvsSplitBy);
                //Imprime datos.
                System.out.println(datos[0] + "; " + datos[1] + "; " + datos[2] + "; " + datos[3]
                        + "; " + datos[4] + "; " + datos[5] + "; " + datos[5] + "; " + datos[6] + "; " + datos[7]
                        + "; " + datos[8] + "; " + datos[9] + "; " + datos[10] + "; " + datos[11]);

            }
          //Excepciones 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void intervencioMasSalidas(ArrayList<String[]> contenido) {
        ArrayList<String> masSalidas = new ArrayList<>();
        for (int x = 0; x < contenido.size(); x++) {
            String[] linea = contenido.get(x);
            masSalidas.add(linea[1]);
            Collections.sort(masSalidas);//se utiliza para almacenar los elementos en una lista en orden ascendente 
        }
        System.out.println("Más intervenciones: " + "\n"
                + masSalidas.get(masSalidas.size() - 1));
    }

    public static void intervncionesMenosSalidas(ArrayList<String[]> contenido) {
        ArrayList<String> menosSalidas = new ArrayList<String>();
        for (int x = 0; x < contenido.size(); x++) {
            String[] linea = contenido.get(x);
            menosSalidas.add(linea[2]);
            Collections.sort(menosSalidas);
        }
        System.out.println("Menos intervenciones: " +"\n"
                + menosSalidas.get(menosSalidas.size() - 1));

    }

   
}
