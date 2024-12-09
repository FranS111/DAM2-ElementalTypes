package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.Personaje;

public class ElementosMain {
    public static void main(String[] args) {
        // Lee los datos de los personajes desde el archivo Personajes.txt
        ArrayList<Personaje> personajes = new ArrayList<>();
        Set<String> elementosUnicos = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("rsrcs/personajes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    String tipoElemental = partes[1];
                    personajes.add(new Personaje(nombre, tipoElemental));
                    elementosUnicos.add(tipoElemental); // Agrega el elemento único al conjunto
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

	     // Calcular estadísticas
	        int totalPersonajes = personajes.size();
	        int totalElementosUtilizados = elementosUnicos.size() - (elementosUnicos.contains("E") ? 1 : 0);
	
	        Map<String, Integer> personajesPorElemento = new HashMap<>();
	        for (String elementoUnico : elementosUnicos) {
	            int cantidad = 0;
	            for (Personaje personaje : personajes) {
	                String tipoElementalPersonaje = personaje.getTipoElemental();
	                if (tipoElementalPersonaje.contains(elementoUnico)) {
	                    cantidad++;
	                }
	            }
	            personajesPorElemento.put(elementoUnico, cantidad);
	        }
	
	        try (FileWriter writer = new FileWriter("rsrcs/EstadisticasPersonajes.txt")) {
	            writer.write("Total de personajes: " + totalPersonajes + "\n");
	            writer.write("Total de elementos utilizados: " + totalElementosUtilizados + "\n");
	            writer.write("Total de personajes por elemento:\n");

	            // Eliminar el elemento "E" del mapa
	            personajesPorElemento.remove("E");

	            for (String elemento : personajesPorElemento.keySet()) {
	                int cantidad = personajesPorElemento.get(elemento);
	                writer.write("\t- " + elemento + " : " + cantidad + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	
	
	        // Imprimir estadísticas en un archivo
	        try (FileWriter writer = new FileWriter("rsrcs/EstadisticasPersonajes.txt")) {
	            writer.write("Total de personajes: " + totalPersonajes + "\n");
	            writer.write("Total de elementos únicos utilizados: " + totalElementosUtilizados + "\n");
	
	            for (Map.Entry<String, Integer> entry : personajesPorElemento.entrySet()) {
	                String elemento = entry.getKey();
	                int cantidad = entry.getValue();
	                writer.write("Total de personajes de elemento " + elemento + ": " + cantidad + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        procesarArchivoElementos("rsrcs/elementos.txt");
	
	    }
   

public static void procesarArchivoElementos(String archivoElementos) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivoElementos));
         FileWriter resultadoWriter = new FileWriter("rsrcs/ResultadosElementales.txt", false)) {
        String linea;

        while ((linea = br.readLine()) != null) {
            for (int i = 0; i < linea.length() - 1; i++) {
                char elemento1 = linea.charAt(i);
                char elemento2 = linea.charAt(i + 1);
                
                if (elemento1 == '*') {
                    elemento1 = elemento2;  // Si el primer elemento es '*', se toma el siguiente
                }

                String magiaElemental = calcularMagiaElemental(elemento1, elemento2);
                if (magiaElemental != null) {
                    resultadoWriter.write(magiaElemental + "\n");
                    i++;  // Saltar al siguiente elemento
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static String calcularMagiaElemental(char elemento1, char elemento2) {
    // Implementa las reglas para calcular la magia elemental
    // Ejemplo: F + A => Evaporación, R + A => Electro-carga, etc.
    // Devuelve el nombre de la magia elemental si existe, o null si no hay magia elemental.
    // Añade más reglas según sea necesario.

    String magiaElemental = null;

    // Ejemplo de regla:
    if ((elemento1 == 'F' && elemento2 == 'A') || (elemento1 == 'A' && elemento2 == 'F')) {
        magiaElemental = "Evaporación";
    }

    if ((elemento1 == 'R' && elemento2 == 'A') || (elemento1 == 'A' && elemento2 == 'R')) {
        magiaElemental = "Electro-carga";
    }

    if (elemento1 == 'V' && (elemento2 == 'F' || elemento2 == 'R' || elemento2 == 'A' || elemento2 == 'H')) {
        magiaElemental = "Torbellino";
    }

    if ((elemento1 == 'F' && elemento2 == 'R') || (elemento1 == 'R' && elemento2 == 'F')) {
        magiaElemental = "Sobrecarga";
    }

    if ((elemento1 == 'R' && elemento2 == 'H') || (elemento1 == 'H' && elemento2 == 'R')) {
        magiaElemental = "Superconductor";
    }

    if (elemento1 == 'T' && (elemento2 == 'F' || elemento2 == 'R' || elemento2 == 'A' || elemento2 == 'H')) {
        magiaElemental = "Cristalizar";
    }

    if ((elemento1 == 'A' && elemento2 == 'H') || (elemento1 == 'H' && elemento2 == 'A')) {
        magiaElemental = "Congelar";
    }

    // Añade las siguientes reacciones que faltan
    if ((elemento1 == 'F' && elemento2 == 'H') || (elemento1 == 'H' && elemento2 == 'F')) {
        magiaElemental = "Derretido";
    }

    if ((elemento1 == 'A' && elemento2 == 'N') || (elemento1 == 'N' && elemento2 == 'A')) {
        magiaElemental = "Quemadura";
    }	

    return magiaElemental;  // Devuelve la magia elemental o null si no se cumple ninguna regla.
}

}
