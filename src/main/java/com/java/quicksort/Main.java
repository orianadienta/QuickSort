package com.java.quicksort;

import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Array array = new Array();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Array berisi 10 elemen ");
            System.out.println("2. Generator Random Value ");
            System.out.println("3. Quick Sort ");
            System.out.println("4. Bubble Sort ");
            System.out.println("5. Exit ");
            System.out.print("Pilihan Anda: ");

            int pilihMenu = scanner.nextInt();
            scanner.nextLine();

            switch (pilihMenu) {
                case 1:
                    array = new Array();

                    array.add(8);
                    array.add(7);
                    array.add(9);
                    array.add(5);
                    array.add(2);
                    array.add(1);
                    array.add(0);
                    array.add(3);
                    array.add(4);
                    array.add(6);

                    System.out.println("Array berisi: ");
                    array.printArray();
                    break;

                case 2:
                    array = new Array();
                    System.out.println("Nilai random yang diperoleh: ");
                    array.generateRandomValue(10000);

                    array.printArray();
                    break;

                case 3:
                    if (array.getSize() > 0) {
                        System.out.println("Pilih metode quick sort:");
                        System.out.println("1. Pivot dibagian tengah array");
                        System.out.println("2. Pivot dibagian ujung array ");
                        System.out.print("Pilihan Anda: ");
                        int quickSortChoice = scanner.nextInt();
                        scanner.nextLine();

                        boolean printSteps = array.getSize() == 10;

                        Instant startTime = Instant.now();

                        if (quickSortChoice == 1) {
                            System.out.println("Quick Sort dengan pivot pada bagian tengah");
                            Array.quickSortMiddlePivot(array.getArray(), 0, array.getSize() - 1, printSteps);
                        } else if (quickSortChoice == 2) {
                            System.out.println("Quick Sort dengan pivot pada bagian kanan");
                            Array.quickSortLastPivot(array.getArray(), 0, array.getSize() - 1, printSteps);
                        } else {
                            System.out.println("Pilihan tidak valid, kembali ke menu utama.");
                            break;
                        }

                        Instant endTime = Instant.now();

                        System.out.println("Hasil setelah Quick Sort: ");
                        array.printArray();

                        Duration timeElapsed = Duration.between(startTime, endTime);
                        System.out.println("Waktu yang dibutuhkan: " + timeElapsed.toMillis() + " milisekon");
                        System.out.println();
                    } else {
                        System.out.println("Array kosong, harap pilih menu 1 atau 2 untuk mengisi array");
                    }
                    break;

                case 4:
                    if (array.getSize() > 0) {
                        Instant startTime = Instant.now();
                        array.bubbleSort(array.getSize() <= 10);
                        Instant endTime = Instant.now();

                        System.out.println("Hasil setelah sorting: ");
                        array.printArray();

                        Duration timeElapsed = Duration.between(startTime, endTime);
                        System.out.println("Waktu yang dibutuhkan: " + timeElapsed.toMillis() + " milisekon");
                        System.out.println();
                    } else {
                        System.out.println("Array kosong, harap pilih menu 1 atau 2 untuk mengisi array");
                    }
                    break;

                case 5:
                    System.out.println("Program berhenti");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia, silahkan coba lagi");
            }
        }
    }
}
