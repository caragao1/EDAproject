package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.CovidDados;

public class Program {
	public static Double insertionSort(int[] vetor){
		double tempoinicial = System.currentTimeMillis();
		int j;
		int key;
		int i;
		
		for (j = 1; j < vetor.length; j++)
		{
		  key = vetor[j];
		  for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
		  {
			 vetor[i + 1] = vetor[i];
		   }
			vetor[i + 1] = key;
		}
		double tempofinal = System.currentTimeMillis();
		
		
		return (tempofinal-tempoinicial);
	}

	public static void main(String[] args) {

		String path = "C:\\Users\\Shisui\\Downloads\\covidteste.csv";
		//Ordenar ordenarw = new Ordenar();
		List<CovidDados> list = new ArrayList<CovidDados>();
		int tam = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				
				String[] vect = line.split(",");
				String cidade = vect[4];
				Integer casos = Integer.parseInt(vect[7]);
				Integer obitos = Integer.parseInt(vect[10]);
				
				CovidDados prod = new CovidDados(cidade, casos, obitos);
				list.add(prod);
				
				line = br.readLine();
				tam++;
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String cidades[] = new String[tam];
		int casos[] = new int[tam];
		int obitos[] = new int[tam];
		int aux = 0;
			for (CovidDados p : list) {
				cidades[aux] = p.getCidade();
				casos[aux] = p.getCasos();
				obitos[aux] = p.getObitos();
				aux++;
		}
		System.out.println(insertionSort(casos));
		
		for (CovidDados p : list) {
			System.out.println(p);
	}
		
        
		
		
		


		

		
		
	}
}

