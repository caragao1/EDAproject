package eda;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerarCSV {
	
	public void Gerarcsv(String[] vetor,String nomeDoArquivo) {
	try{
	    FileWriter file = new FileWriter("C:\\Users\\Shisui\\eclipse-workspace\\eda\\src\\eda\\"+nomeDoArquivo+".csv");
	    PrintWriter write = new PrintWriter(file);
	    write.printf("epidemiological_week,date,order_for_place,state,city,city_ibge_code,place_type,last_available_confirmed,last_available_confirmed_per_100k_inhabitants,new_confirmed,last_available_deaths,new_deaths,last_available_death_rate,estimated_population,is_last,is_repeated");
	    for (int i = 0; i < vetor.length; i++){
	    	write.println(vetor[i]);
		}
		write.close();
	} catch(IOException exe){
		System.out.println("Cannot create file");
	}
}
}