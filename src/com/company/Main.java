package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // Insertion Sort
        // Selection Sort
        // Quick Sort

        int[] vetorPequeno = new int[1000];
        int[] vetorMedio   = new int[10000];
        int[] vetorGrande  = new int[100000];

        vetorPequeno = preencherVetor(vetorPequeno);
        vetorMedio   = preencherVetor(vetorMedio);
        vetorGrande  = preencherVetor(vetorGrande);

        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        MergeSort mergeSort = new MergeSort();

        int[] vetor = recreateVetor(vetorGrande);
        long tempoInicialInsertion = System.currentTimeMillis();
        insertionSort.sort(vetor);
        long tempoFinalInsertion = System.currentTimeMillis();
        System.out.println("Duração insertionSort: " + String.valueOf(tempoFinalInsertion - tempoInicialInsertion) + " ms");

        vetor = recreateVetor(vetorGrande);
        long tempoInicialSelection = System.currentTimeMillis();
        selectionSort.sort(vetor);
        long tempoFinalSelection = System.currentTimeMillis();
        System.out.println("Duração selectionSort: " + String.valueOf(tempoFinalSelection - tempoInicialSelection) + " ms");

        vetor = recreateVetor(vetorGrande);
        long tempoInicialQuick = System.currentTimeMillis();
        mergeSort.sort(vetor, 0, vetor.length - 1);
        long tempoFinalQuick = System.currentTimeMillis();
        System.out.println("Duração mergeSort: " + String.valueOf(tempoFinalQuick - tempoInicialQuick) + " ms");
    }

    static int[] preencherVetor(int[] vetor){
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(10000);
        }
        return vetor;
    }

    static int[] preencherVetorDecrescente(int[] vetor){
        for (int i = vetor.length - 1; i > 0; i--) {
            vetor[i] = i;
        }
        return vetor;
    }

    static int[] preencherVetorCrescente(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    static int[] preencherVetorQuaseOrdenado(int[] vetor){
        vetor = preencherVetorCrescente(vetor);
        Random random = new Random();
        int porcento = (vetor.length / 100) * 5;
        int contador = 0;
        ArrayList<Integer> indicesSortados = new ArrayList<>();
        while(contador <porcento){
            int indice = 0;

            do {
                indice = random.nextInt(vetor.length);
            }while (indicesSortados.contains(indice));

            indicesSortados.add(indice);
            vetor[indice] = random.nextInt(vetor.length);
            contador++;
        }
        return vetor;
    }

    static int[] recreateVetor(int[] vetor){
        int[] retorno = new int[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            retorno[i] = vetor[i];
        }
        return retorno;
    }
}
