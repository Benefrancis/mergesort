package br.com.benefrancis.merge;

import java.util.Random;

/**
 * Ordenação de array utilizando o método merge sort
 * 
 * @author Francis
 *
 */
public class Merge {

	public static void main(String[] args) {
		long inicio;
		long fim;
		long decorrido;

		Random rand = new Random();
		int[] numbers = new int[10];

		// inserindo os números no array de forma aleatória.
		// No metodo nextInt sorteará apenas números Retorna um pseudorandom,
		// uniformemente distribuído entre o valor 0 (inclusive) e o valor especificado
		// (exclusivo).
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(numbers.length);
		}

		System.out.println("Antes: ");
		printArray(numbers);

		inicio = System.currentTimeMillis();
		sort(numbers);
		fim = System.currentTimeMillis();
		decorrido = fim - inicio;

		System.out.println("Depois: ");
		printArray(numbers);

		// @formatter:off
 		System.out.println("\r\nSorteamos " + numbers.length + " números e inserimos num vetor. "
				+ "\nEm seguida, utilizamos o Merge Sorte para ordenação. "
				+ "\nA ordenação dos elementos levou " + decorrido + " ms para ser concluído.");
 		// @formatter:on

	}

	private static void sort(int[] numbers) {
		int length = numbers.length;

		if (length < 2) {
			return;
		}

		int mid = length / 2;

		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = numbers[i];
		}

		for (int i = mid; i < length; i++) {
			right[i - mid] = numbers[i];
		}


		sort(left);

		sort(right);

		merge(numbers, left, right);

	}

	private static void merge(int[] numbers, int left[], int[] right) {
		int leftSize = left.length;
		int rightSize = right.length;

		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i++;
			} else {
				numbers[k] = right[j];
				j++;
			}
			k++;
		}

		// Como numbers pode ter lenght impar a divisão dos arrays pode ter tamanhp
		// diferente, por isso devemos fazer dois whiles para pegar os possíveis
		// remanecentes tanto da esquerda quanto da direita

		while (i < leftSize) {
			numbers[k] = left[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			numbers[k] = right[j];
			j++;
			k++;
		}

	}

	private static void printArray(int[] numbers) {
		if (numbers.length <= 1000) {
			for (int i : numbers) {
				System.out.print("[" + i + "] ");
			}
		} else {
			for (int i : numbers) {
				System.out.println("[" + i + "] ");
			}
		}

		System.out.println();
	}

}
