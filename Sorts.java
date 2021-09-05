package eda;

public class Sorts {
	 public long insertionSortCasos(int[] vetor, String[] vetoribge){
			int j;
			int key;
			int i;
			String key1;
			long tempoInicial = System.currentTimeMillis();
			for (j = 1; j < vetor.length; j++)
			{
			
			  key = vetor[j];
			  key1 = vetoribge[j];
			  for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
			  {
				 vetor[i + 1] = vetor[i];
				 vetoribge[i+1] = vetoribge[i];
			   }
				vetor[i + 1] = key;
				
				vetoribge[i+1]= key1;
				
			}
			long tempoFinal = System.currentTimeMillis();
			return (tempoFinal - tempoInicial);
		}
	 public long insertionSortObitos(int[] vetor, String[] vetoribge){
			int j;
			int key;
			int i;
			String key1;
			long tempoInicial = System.currentTimeMillis();
			for (j = 1; j < vetor.length; j++)
			{
			
			  key = vetor[j];
			  key1 = vetoribge[j];
			  for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
			  {
				 vetor[i + 1] = vetor[i];
				 vetoribge[i+1] = vetoribge[i];
			   }
				vetor[i + 1] = key;
				
				vetoribge[i+1]= key1;
				
			}
			long tempoFinal = System.currentTimeMillis();
			return (tempoFinal - tempoInicial);
		}
	 public boolean insertionSortCidades(String a [], String vetoribge[]){
	        if (a == null) return false;   
	        int i,j;  
	        String x,x2;
	        for (j = 1; j < a.length; j++) {       
	            x = a[j];
	            x2 = vetoribge[j];
	            i = j - 1;

	            while (i >= 0) {
	                if (x.compareTo(a[i]) > 0) {
	                    break;
	                }
	                a[i + 1] = a[i];
	                vetoribge[i + 1] = vetoribge[i];
	                
	                i--;
	            }
	            a[i + 1] = x;
	            vetoribge[i + 1] = x2;
	        }
	        return true;
	}
	 
	 //------------------------------------------------------------------------ SELECTION SORT -------------------------------------------------------------------------------------------
	
	 public void selectionSortCasos(int[] array, String ibge[]) {
		  for (int fixo = 0; fixo < array.length - 1; fixo++) {
		    int menor = fixo;
		    for (int i = menor + 1; i < array.length; i++) {
		       if (array[i] < array[menor]) {
		          menor = i;
		       }
		    }
		    if (menor != fixo) {
		      int t = array[fixo];
		      String t2 = ibge[fixo];
		      array[fixo] = array[menor];
		      ibge[fixo] = ibge[menor];
		      array[menor] = t;
		      ibge[menor] = t2;
		    }
		  }
	 }
	 public void selectionSortObitos(int[] array, String ibge[]) {
		  for (int fixo = 0; fixo < array.length - 1; fixo++) {
		    int menor = fixo;
		    for (int i = menor + 1; i < array.length; i++) {
		       if (array[i] < array[menor]) {
		          menor = i;
		       }
		    }
		    if (menor != fixo) {
		      int t = array[fixo];
		      String t2 = ibge[fixo];
		      array[fixo] = array[menor];
		      ibge[fixo] = ibge[menor];
		      array[menor] = t;
		      ibge[menor] = t2;
		    }
		  }
	 }
	 public void selectionSortCidades(String arr[],String ibge[]){
		 int n = arr.length;
	     for(int i = 0; i < n - 1; i++){
	         int min_index = i;
	         String minStr = arr[i];
	         String minStrIbge = ibge[i];
	         for(int j = i + 1; j < n; j++){
	             if(arr[j].compareTo(minStr) < 0){
	                 minStr = arr[j];
	                 minStrIbge = ibge[j];
	                 min_index = j;
	             }
	         }
	     if(min_index != i){
	         String temp = arr[min_index];
	         String temp2 = ibge[min_index];
	         
	         arr[min_index] = arr[i];
	         ibge[min_index] = ibge[i];
	         
	         arr[i] = temp;
	         ibge[i] = temp2;
	     }
	     }
	 }
	 
	 
	 
//--------------------------------------------------------------------- MERGE SORT ---------------------------------------------------------------------
	 public void intercala(int[] vetor,String [] ibge ,int inicio, int meio, int fim){

		    int novoVetor[] = new int[fim - inicio];
		    String novoVetor2[] = new String[fim - inicio];
		    int i = inicio;
		    int m = meio;
		    int pos = 0;
		    
		    while(i < meio && m < fim) {
		      if(vetor[i] <= vetor[m]) {
		        novoVetor[pos] = vetor[i];
		        novoVetor2[pos] = ibge[i];
		        pos = pos + 1;
		        i = i + 1;
		      } else {
		        novoVetor[pos] = vetor[m];
		        novoVetor2[pos] = ibge[m];
		        pos = pos + 1;
		        m = m + 1;
		      }
		    }
		    while(i < meio) {
		      novoVetor[pos] = vetor[i];
		      novoVetor2[pos] = ibge[i];
		      pos = pos + 1;
		      i = i + 1;
		    }
		    while(m < fim) {
		      novoVetor[pos] = vetor[m];
		      novoVetor2[pos] = ibge[m];
		      pos = pos + 1;
		      m = m + 1;
		    }
		    for(pos = 0, i = inicio; i < fim; i++, pos++) {
		      vetor[i] = novoVetor[pos];
		      ibge[i] = novoVetor2[pos];
		    }
		  }
	 public void mergeSortCasos(int tamanho, int[] vetor,String ibge[]) {
		    int elementos = 1;
		    int inicio, meio, fim;
		    while(elementos < tamanho) {
		      inicio = 0;
		      while(inicio + elementos < tamanho) {
		        meio = inicio + elementos;
		        fim = inicio + 2 * elementos;
		        if(fim > tamanho)
		          fim = tamanho;
		        intercala(vetor,ibge,inicio, meio, fim);
		        inicio = fim;
		      }
		      elementos = elementos * 2;
		    }
	 }
	 public void mergeSortObitos(int tamanho, int[] vetor,String ibge[]) {
		    int elementos = 1;
		    int inicio, meio, fim;
		    while(elementos < tamanho) {
		      inicio = 0;
		      while(inicio + elementos < tamanho) {
		        meio = inicio + elementos;
		        fim = inicio + 2 * elementos;
		        if(fim > tamanho)
		          fim = tamanho;
		        intercala(vetor,ibge,inicio, meio, fim);
		        inicio = fim;
		      }
		      elementos = elementos * 2;
		    }
	 }
	 
	 
	 public  void mergeSortString(String[] a,String []ibge) {
	        if (a.length >= 2) {
	            String[] left = new String[a.length / 2];
	            String[] right = new String[a.length-a.length / 2];
	            
	            String[] left2 = new String[ibge.length / 2];
	            String[] right2 = new String[ibge.length-ibge.length / 2];

	            for (int i = 0; i < left.length; i++){
	                left[i] = a[i];
	                left2[i] = ibge[i];
	            }
	            for (int i = 0; i < right.length; i++)
	            {
	                right[i] = a[i + a.length / 2];
	                right2[i] = ibge[i + ibge.length / 2];
	            }
	            
	            
	            
	            mergeSortString(left,left2);
	            mergeSortString(right,right2);
	   
	           
	            

	            mergeString(a,ibge,left, right,left2,right2);
	        }
	    }

	    public void mergeString(String[] result,String result2[], String[] left, String[] right, String[] left2, String[] right2) {
	        int i1 = 0;
	        int i2 = 0;
	        for (int i = 0; i < result.length; i++) {
	          if (i2 >= right.length || (i1 < left.length &&
	            left[i1].compareToIgnoreCase(right[i2])<0)) {
	                      result[i] = left[i1];
	                      result2[i] = left2[i1];
	                      i1++;
	                 } else {
	                      result[i] = right[i2];
	                      result2[i] = right2[i2];
	                      i2++;
	                 }
	            }
	    }

//--------------------------------------------------------------------- QUICK SORT ------------------------------------------------------------------------------------------------------------------------------------------
	    public int partition(int arr[],String ibge[], int low, int high){
	        int pivot = arr[high];
	        int i = (low-1);
	        for (int j=low; j<high; j++){

	            if (arr[j] <= pivot){
	                i++;

	                int temp = arr[i];
	                String temp2 = ibge[i];
	                
	                arr[i] = arr[j];
	                ibge[i] = ibge[j];
	                
	                arr[j] = temp;
	                ibge[j] = temp2;
	            }
	        }

	        int temp = arr[i+1];
	        String temp2 = ibge[i+1];
	        
	        arr[i+1] = arr[high];
	        ibge[i+1] = ibge[high];
	        
	        arr[high] = temp;
	        ibge[high] = temp2;
	        return i+1;
	    }
	    public void QuickSortCasos(int arr[],String ibge[], int low, int high){
	        if (low < high){

	            int pi = partition(arr,ibge ,low, high);

	            QuickSortCasos(arr,ibge ,low, pi-1);
	            QuickSortCasos(arr,ibge ,pi+1, high);
	        }
	    }
	    public void QuickSortObitos(int arr[],String ibge[], int low, int high){
	        if (low < high){

	            int pi = partition(arr,ibge ,low, high);

	            QuickSortCasos(arr,ibge ,low, pi-1);
	            QuickSortCasos(arr,ibge ,pi+1, high);
	        }
	    }
	    public void swap(String[] a,String ibge[], int i, int j)
	    {
		    String temp = a[i];
		    String temp2 = ibge[i];
		    a[i] = a[j];
		    ibge[i] = ibge[j];
		    a[j] = temp;
		    ibge[j] = temp2;
	    }
	    public void quickSortString(String[] a,String[] ibge, int start, int end)
	    {
	        int i = start;
	        int j = end;
	        if (j - i >= 1)
	        {
	            String pivot = a[i];
	            while (j > i)
	            {
	                while (a[i].compareTo(pivot) <= 0 && i < end && j > i){
	                    i++;
	                }
	                while (a[j].compareTo(pivot) >= 0 && j > start && j >= i){
	                    j--;
	                }
	                if (j > i)
	                    swap(a,ibge, i, j);
	            }
	            swap(a,ibge, start, j);

	            quickSortString(a,ibge,start, j - 1);

	            quickSortString(a,ibge, j + 1, end);
	        }
	    }
//---------------------------------------------------------------------	QUICK SORT MEDIANA DE 3 ------------------------------------------------------------------------------------------------------------------------------------------     
	    public int partition1(int[] A,String ibge[], int inicio, int fim){
            int meio = (inicio + fim)/2;
            int a = A[inicio];
            int b = A[meio];
            int c = A[fim];
            int medianaIndice;
            if(a < b){
                if(b < c){
                    medianaIndice = meio;
                }else{                
                    if(a < c){

                        medianaIndice = fim;
                    }else{
                        medianaIndice = inicio;
                    }
                }
            }else{
                if(c < b){
                    medianaIndice = meio;
                }else{
                    if(c < a){
                        medianaIndice = fim;
                    }else{
                        medianaIndice = inicio;
                    }
                }
            }
            swap(A,ibge, medianaIndice, fim);
            int pivo = A[fim];
            int i = inicio - 1;
            for(int j = inicio; j <= fim - 1; j++){
                if(A[j] <= pivo){
                    i = i + 1;
                    swap(A,ibge, i, j);
                }
            }

            swap(A,ibge, i + 1, fim);
            return i + 1; //
        }
        
	        public void quicksortMedianaDeTresCasos(int[] A,String ibge[]){        
	            quicksortMedianaDeTres(A,ibge, 0, A.length - 1);
	        }
	        public void quicksortMedianaDeTresObitos(int[] A,String ibge[]){        
	            quicksortMedianaDeTres(A,ibge, 0, A.length - 1);
	        }
	        public void quicksortMedianaDeTres(int[] A,String ibge[],int inicio, int fim){        
	            if(inicio < fim){
	                int q = partition1(A,ibge, inicio, fim);
	                quicksortMedianaDeTres(A,ibge, inicio, q - 1);
	                quicksortMedianaDeTres(A,ibge, q + 1, fim);            
	            }
	        }
	        private static void swap(int[] A,String[] ibge, int i, int j){
	            int temp = A[i];
	            String temp2 = ibge[i];
	            
	            A[i] = A[j];
	            ibge[i] = ibge[j];
	            
	            A[j] = temp;
	            ibge[j] = temp2;
	        }
	        
	        
	        
	        	    

//--------------------------------------------------------------------- COUNTING SORT ------------------------------------------------------------------------------------------------------------------------------------------
	        
//--------------------------------------------------------------------- HEAP SORT ------------------------------------------------------------------------------------------------------------------------------------------
	        public void heapSortCasos(int arr[],String ibge[]){
	            int n = arr.length;

	            for (int i = n / 2 - 1; i >= 0; i--)
	                heapify(arr,ibge, n, i);
	            for (int i = n - 1; i > 0; i--) {
	                int temp = arr[0];
	                String temp2 = ibge[0];
	                arr[0] = arr[i];
	                ibge[0] = ibge[i];
	                arr[i] = temp;
	                ibge[i] = temp2;
	                heapify(arr,ibge, i, 0);
	            }
	        }
	        public void heapSortObitos(int arr[],String ibge[]){
	            int n = arr.length;

	            for (int i = n / 2 - 1; i >= 0; i--)
	                heapify(arr,ibge, n, i);
	            for (int i = n - 1; i > 0; i--) {
	                int temp = arr[0];
	                String temp2 = ibge[0];
	                arr[0] = arr[i];
	                ibge[0] = ibge[i];
	                arr[i] = temp;
	                ibge[i] = temp2;
	                heapify(arr,ibge, i, 0);
	            }
	        }
	        void heapify(int arr[],String ibge[], int n, int i)
	        {
	            int largest = i;
	            int l = 2 * i + 1;
	            int r = 2 * i + 2; 
	     

	            if (l < n && arr[l] > arr[largest])
	                largest = l;
	     

	            if (r < n && arr[r] > arr[largest])
	                largest = r;
	     

	            if (largest != i) {
	                int swap = arr[i];
	                String swap2 = ibge[i];
	                
	                arr[i] = arr[largest];
	                ibge[i] = ibge[largest];
	                
	                arr[largest] = swap;
	                ibge[largest] = swap2;
	     
	                heapify(arr,ibge, n, largest);
	            }
	        }
	        //HEAP STRING
	        public  void heapSortString(String as[],String[]ibge) {
	            heapSort(as,ibge, as.length);
	        }
	        public void heapSort(String as[],String ibge[], int i) {
	            for (int j = i / 2; j >= 0; j--)
	                fall(as,ibge, i, j);
	            for (int k = i - 1; k > 0; k--) {
	                String s = as[0];
	                String s2 = ibge[0];
	                
	                as[0] = as[k];
	                ibge[0] = ibge[k];
	                
	                as[k] = s;
	                ibge[k] = s2;
	                fall(as,ibge, k, 0);
	            }
	        }
	        private void fall(String as[],String ibge[], int i, int j) {
	            int k = 2 * j + 1;
	            if (k < i) {
	                if (k + 1 < i && as[k].compareTo(as[k + 1]) < 0)
	                    k = 2 * j + 2;
	                if (as[j].compareTo(as[k]) < 0) {
	                    String s = as[j];
	                    String s2 = ibge[j];
	                    
	                    as[j] = as[k];
	                    ibge[j] = ibge[k];
	                    
	                    as[k] = s;
	                    ibge[k] = s2;
	                    
	                    fall(as,ibge, i, k);
	                }
	            }
	        }
	    
	        
	        
	        
//--------------------------------------------------------------------- FUNÇOES AUXILIARES --------------------------------------------------------------------------------------------------------
	public void terminar(String vetorIbge[], String vetorFinal[],String vetorFinalCasos[],String matriz[][],int pos){
		int tam = vetorIbge.length;
		for(int i = 0;i<tam;i++){
			for(int j = 0;j < tam;j++){
					if(vetorIbge[i]==matriz[j][pos]){
						vetorFinalCasos[i] = vetorFinal[j];
						}
					}
		}
	}
	public void resetarVetorIbge(String ibge[],String original[]) {
		for(int i=0;i<ibge.length;i++)
			ibge[i] = original[i];
	}
	public void resetarVetorCasos(int casos[],int casosOriginal[]) {
		for(int i=0;i<casos.length;i++)
			casos[i] = casosOriginal[i];
	}
	public void resetarVetorObitos(int[] vetorObitos, int[] vetorObitosOriginal) {
		for(int i=0;i<vetorObitos.length;i++)
			vetorObitos[i] = vetorObitosOriginal[i];
		
	}
	public void resetarVetorCidades(String[] vetorCidade, String[] vetorCidadeOriginal) {
		for(int i=0;i<vetorCidade.length;i++)
			vetorCidade[i] = vetorCidadeOriginal[i];
	}
	
	public void StringToInt(String[] vetorString,int[] vetorInteiro) {
		for(int i=0;i<vetorString.length;i++) 
			if(vetorString[i]==" ") {
				vetorInteiro[i] = 0;
			}
			else {
			vetorInteiro[i] = Integer.parseInt(vetorString[i]);
			System.out.println(vetorInteiro[i]);
			}
			}
	
			
	}
	
	




