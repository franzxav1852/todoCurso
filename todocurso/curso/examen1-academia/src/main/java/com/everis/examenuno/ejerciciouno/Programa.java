package com.everis.examenuno.ejerciciouno;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.logging.Logger;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String analizarTexto = "academia everis";
		System.out.println(analizarTexto.toUpperCase());
		
	}
private static String analizarTexto() {	 
		
		String analizarTexto="";
		 char [] Arraytexto ;
		 char caracter;
		 System.out.println("Introduce una palabra");
		 analizarTexto=Logger.data()
	     Arraytexto=analizarTexto.toCharArray();

		 char[] caracteres = new char[analizarTexto.length()];
		 int[] cuantasVeces = new int[analizarTexto.length()];

	      for(int i =0;i<Arraytexto.length;i++){
		  caracter = Arraytexto[i];   
		  caracteres[i] = caracter;
		      for (int j = i; j < Arraytexto.length; j++)   {                  
		          if(Arraytexto[j]==caracter){
		           }
		  cuantasVeces[i]++;
		  Arraytexto[j] = ' ';
			            }
			          
			    if(caracteres[i] != ' ')
			            System.out.println(caracteres[i] +" "+cuantasVeces[i]+" veces.");
			    }}}
