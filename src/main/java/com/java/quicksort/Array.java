package com.java.quicksort;

import java.util.*;

public class Array {
    private int[] array;
    private int size;

    public Array() {
        this.array = new int[0];
        this.size = 0;
    }

    public int[] getArray() {
        return this.array;
    }

    public int getSize() {
        return size; // return variabel size yg menyimpan elemen array
    }

    public void add(int value) {
        int[] newArray = new int[size + 1]; //membuat array baru dengan penambahan 1 ukuran lebih besar dari array asli (disini bisa masukkan besar array lngsng kalau sudah tau, misal [10])
        System.arraycopy(array, 0, newArray, 0 , size); //untuk nyalin isi array lama ke array baru, parameter nya array sumber, indeks awal array sumber, newArray untuk ujuan, dan indek awal array tujuan
        newArray[size] = value;
        array = newArray;
        size++;
    }

    public void printArray() {
        int elementsPerRow = 100; // jumlah elemen per baris
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % elementsPerRow == 0) { //kalau sudah dicetak 40 elemen, pindah ke bawah
                System.out.println(); // pindah baris setelah 20 elemen
            }
        }
        System.out.println(); // baris baru di akhir
    }

    //generator angka acak
    public void generateRandomValue(int n) {
        Random random = new Random();
        array = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            int randomValue = 1 + random.nextInt(10000); //random value dari angka 1 sampai 10000
            array[i] = randomValue;
        }
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex, boolean printSteps) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = array[pivotIndex];

        if (printSteps) {
            System.out.println("Pivot selected: " + pivot + " at index " + pivotIndex);
            printStepArray(array);
        }

        swap(array, pivotIndex, highIndex);

        if (printSteps) {
            System.out.println("Array after moving pivot to the end: ");
            printStepArray(array);
        }

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {
            while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            if(leftPointer < rightPointer) {
                if (printSteps) {
                    System.out.println("Swapping elements: " + array[leftPointer] + " and " + array[rightPointer]);
                    printStepArray(array);
                }
                swap(array, leftPointer, rightPointer);
            }
        }
        swap(array, leftPointer, highIndex);

        if (printSteps) {
            System.out.println("Array after placing pivot in correct position: ");
            printStepArray(array);
        }

        quickSort(array, lowIndex, leftPointer - 1, printSteps);
        quickSort(array, leftPointer + 1, highIndex, printSteps);
    }

    // print setiap langkah untuk 10 angka acak
    public static void printStepArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    //metode untuk swap quicksort
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void bubbleSort(boolean printStep) {
        int size = array.length; // Mendapatkan panjang array
        if (size <= 1) return; //kemudian disimpan divariabel size, kalau elemennya bernilai 1 atau kurang dari 1 maka gak dilakukan sorting
        int count = 0;

        if (printStep) {
            System.out.println("Array sebelum sorting:");
            printArray();
        }

        for (int i = 0; i < size - 1; i++) { //looping dari i = 0 sampai size - 1 untuk menentukan jumlah loop dalam membandingkan elemen (size - 1 untuk bandingin elemen terakhir ke 2 dan elemen terakhir pertama. misal 1,2,4,3. bandingkan antara 3 dan 4)
            boolean swapped = false;
            // Pengulangan untuk setiap pasangan elemen
            for (int j = 0; j < size - i - 1; j++) { //j untuk membandingkan dan mennukar elemen di array (looping sampai size - i - 1 untuk menghilangkan looping kembali untuk variabel i yang sebelumnya sudah dibandingkan)
                count++;
                if (array[j] > array[j + 1]) { // kondisi dimana dilakukan swap jika elemen lebih besar dari elemen berikutnya
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                }
            }
            if (printStep) {
                System.out.println("Setelah perulangan " + (i + 1) + ": ");
                printArray();
            }

            // Jika tidak ada swap yang terjadi, array sudah terurut
            if (!swapped) break;
        }
        System.out.println("Jumlah Perulangan: " + count);
    }

}
