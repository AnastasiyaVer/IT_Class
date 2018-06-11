package app_two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=null;

        try{
            scanner=new Scanner(new File("src/in.txt"));
            int n=scanner.nextInt();
            int arr[]=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }

            System.out.println("Исходный массив:");
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }

            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]<0){
                    count++;
                }
            }

            int temp;
            int k=count;
            for(int i=0;i<n;i++){
                if(arr[i]<0 && i>k-1){
                    temp=arr[count-1];
                    arr[count-1]=arr[i];
                    arr[i]=temp;
                    count--;
                    i--;
                }
            }

            for(int j=0;j<n;j++) {
                for (int i = 0; i < k; i++) {
                    if (arr[i] > arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }

            count=0;

            for(int i=0;i<n;i++){
                if(arr[i]>10){
                    count++;
                }
            }


            k=count;
            for(int i=0;i<n;i++){
                if(arr[i]>10 && i<(n-k)){
                    temp=arr[n-count];
                    arr[n-count]=arr[i];
                    arr[i]=temp;
                    count--;
                    i--;
                }
            }

            for(int j=0;j<n;j++) {
                for (int i = n - k; i < n - 1; i++) {
                    if (arr[i] < arr[i + 1]) {
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }

            System.out.println("\nПолученный массив:");
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

