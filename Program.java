package eda;


import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;




public class Program {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GerarCSV gerar = new GerarCSV();
		String path = "C:\\Users\\Shisui\\Downloads\\covidteste.csv";
		Sorts ordenar = new Sorts();
		
		int tam = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				line = br.readLine();
				tam++;
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		String matriz[][] = new String[tam+1][15];
		String vetorCidade[] = new String[tam];
		String vetorCidadeOriginal[] = new String[tam];
		int vetorCasos[] = new int[tam];
		int vetorCasosOriginal[] = new int[tam];
		int vetorObitos[] = new int[tam];
		int vetorObitosOriginal[] = new int[tam];
		String vetorIbge[] = new String[tam];
		String vetorIbgeOriginal[] = new String[tam];
		String vetorFinal[] = new String[tam];
		String vetorFinalCasos[] = new String[tam];
		String vetorFinalObitos[] = new String[tam];
		String vetorFinalCidades[] = new String[tam];
		
		long tempoCasos[] = new long[7];
		long tempoObitos[] = new long[7];
		long tempoCidade[] = new long[7];
		String tipoDeOrdenacao[] = {"Insertion Sort","Selection Sort","Merge Sort","Quick Sort","Quick3 Sort","Counting Sort","Heap Sort"};
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			tam = 0;
			String line = br.readLine();
			line = br.readLine();
			
			while (line != null) {
				vetorFinal[tam] = line;
				String[] vect = line.split(",");
				for(int j = 0; j < 15; j++){
					matriz[tam][j] = vect[j];
					}
				String cidade = vect[4];
				Integer casos = Integer.parseInt(vect[7]);
				Integer obitos = Integer.parseInt(vect[10]);
				String ibge = vect[5];
				vetorCidade[tam] = cidade;
				vetorCasos[tam] = casos;
				vetorObitos[tam] = obitos;
				vetorIbge[tam] = ibge;

				
				line = br.readLine();
				tam++;
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		for(int i=0;i<vetorIbge.length;i++)
			vetorIbgeOriginal[i] = vetorIbge[i];
		for(int i=0;i<vetorObitos.length;i++)
			vetorObitosOriginal[i] = vetorObitos[i];
		for(int i=0;i<vetorCasos.length;i++)
			vetorCasosOriginal[i] = vetorCasos[i];
		for(int i=0;i<vetorCidade.length;i++)
			vetorCidadeOriginal[i] = vetorCidade[i];
		
		
		
		System.out.printf("------------------------------------------------------------------------------------------\n1 - Insertion Sort\n2 - Selection Sort\n3 - Merge Sort\n4 - Quick Sort\n5 - Quick3 Sort\n6 - Counting Sort(Não conseguimos fazer)\n7 - Heap Sort");
		int opcao = input.nextInt();
		int i = opcao-1;
		switch (i){
		
		case 0:
			
			long tempoInicial = System.currentTimeMillis();
			ordenar.insertionSortCasos(vetorCasos,vetorIbge);
			long tempoFinal = System.currentTimeMillis();
			tempoCasos[0] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge,vetorFinal,vetorFinalCasos,matriz,5);
            gerar.Gerarcsv(vetorFinalCasos,"iSort_ordena_casos");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);
            
            tempoInicial = System.currentTimeMillis();
            ordenar.insertionSortObitos(vetorObitos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[0] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
            gerar.Gerarcsv(vetorFinalObitos,"iSort_ordena_obitos");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorObitos, vetorObitosOriginal);
            
            
            tempoInicial = System.currentTimeMillis();
            ordenar.insertionSortCidades(vetorCidade, vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[0] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
            gerar.Gerarcsv(vetorFinalCidades,"iSort_ordena_cidades");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
            break;
            
		case 1:
			tempoInicial = System.currentTimeMillis();
			ordenar.selectionSortCasos(vetorCasos, vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCasos[1] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCasos, matriz,5);
			gerar.Gerarcsv(vetorFinalCasos,"sSort_ordena_casos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);
           
            
            tempoInicial = System.currentTimeMillis();
            ordenar.selectionSortObitos(vetorObitos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[1] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
            gerar.Gerarcsv(vetorFinalObitos,"sSort_ordena_obitos");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorObitos, vetorObitosOriginal);
                       
            
            tempoInicial = System.currentTimeMillis();
            ordenar.selectionSortCidades(vetorCidade,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[1] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
            gerar.Gerarcsv(vetorFinalCidades,"sSort_ordena_cidades");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
            break;
		case 2:
			tempoInicial = System.currentTimeMillis();
			ordenar.mergeSortCasos(tam,vetorCasos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCasos[2] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCasos, matriz,5);
			gerar.Gerarcsv(vetorFinalCasos,"mSort_ordena_casos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);
			
            
            tempoInicial = System.currentTimeMillis();
            ordenar.mergeSortObitos(tam,vetorObitos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[2] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
			gerar.Gerarcsv(vetorFinalObitos,"mSort_ordena_obitos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorCasos,vetorCasosOriginal);
			
            
            tempoInicial = System.currentTimeMillis();
            ordenar.mergeSortString(vetorCidade,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[2] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
			gerar.Gerarcsv(vetorFinalCidades,"mSort_ordena_cidades");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
            break;
		case 3:
			tempoInicial = System.currentTimeMillis();
			ordenar.QuickSortCasos(vetorCasos,vetorIbge,0,vetorCasos.length-1);
			tempoFinal = System.currentTimeMillis();
			tempoCasos[3] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCasos, matriz,5);
			gerar.Gerarcsv(vetorFinalCasos,"qSort_ordena_casos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);
			
            
            tempoInicial = System.currentTimeMillis();
            ordenar.QuickSortObitos(vetorObitos,vetorIbge,0,vetorObitos.length-1);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[3] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
			gerar.Gerarcsv(vetorFinalObitos,"qSort_ordena_obitos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorObitos,vetorObitosOriginal);
            
            
            tempoInicial = System.currentTimeMillis();
            ordenar.quickSortString(vetorCidade,vetorIbge,0, vetorCidade.length - 1);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[3] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
            gerar.Gerarcsv(vetorFinalCidades,"qSort_ordena_cidade");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
            break;
		case 4:     
			tempoInicial = System.currentTimeMillis();
			ordenar.quicksortMedianaDeTresCasos(vetorCasos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCasos[4] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCasos, matriz,5);
            gerar.Gerarcsv(vetorFinalCasos,"q3Sort_ordena_casos");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);
            
            tempoInicial = System.currentTimeMillis();
            ordenar.quicksortMedianaDeTresObitos(vetorObitos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[4] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
			gerar.Gerarcsv(vetorFinalObitos,"q3Sort_ordena_obitos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorObitos,vetorObitosOriginal);
            
            
            tempoInicial = System.currentTimeMillis();
            ordenar.quickSortString(vetorCidade,vetorIbge,0, vetorCidade.length - 1);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[4] = tempoFinal - tempoInicial;
            ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
            gerar.Gerarcsv(vetorFinalCidades,"q3Sort_ordena_cidade");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
            break;
		case 5:
			//Não conseguimos fazer o counting sort
			tempoCasos[5] = 0;
			tempoObitos[5] = 0;
			tempoCidade[5] = 0;
			System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
			break;
		case 6:
			tempoInicial = System.currentTimeMillis();
			ordenar.heapSortCasos(vetorCasos,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCasos[6] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCasos, matriz,5);
            gerar.Gerarcsv(vetorFinalCasos,"hSort_ordena_casos");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCasos(vetorCasos,vetorCasosOriginal);

            
            tempoInicial = System.currentTimeMillis();
            ordenar.heapSortObitos(vetorObitos, vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoObitos[6] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalObitos, matriz,5);
			gerar.Gerarcsv(vetorFinalObitos,"hSort_ordena_obitos");
			ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorObitos(vetorObitos,vetorObitosOriginal);
			
            
            tempoInicial = System.currentTimeMillis();
            ordenar.heapSortString(vetorCidade,vetorIbge);
			tempoFinal = System.currentTimeMillis();
			tempoCidade[6] = tempoFinal - tempoInicial;
			ordenar.terminar(vetorIbge, vetorFinal, vetorFinalCidades, matriz,5);
            gerar.Gerarcsv(vetorFinalCidades,"hSort_ordena_cidade");
            ordenar.resetarVetorIbge(vetorIbge,vetorIbgeOriginal);
            ordenar.resetarVetorCidades(vetorCidade,vetorCidadeOriginal);
            System.out.println(tipoDeOrdenacao[i]+":\tTempo para ordenar Casos: "+tempoCasos[i]+"ms\t Tempo para ordenar Obitos: "+tempoObitos[i]+"ms        Tempo para ordenar Cidades: "+tempoCidade[i]+"ms");
           break;
		
		default:
				System.out.println("Opçao invalida");

		input.close();
		
	}
}
}


