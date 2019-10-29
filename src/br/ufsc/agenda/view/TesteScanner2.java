package br.ufsc.agenda.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map.Entry;
import java.util.Scanner;

import br.ufsc.agenda.model.Contato;
import br.ufsc.agenda.model.Controlador;
import util.Util;

public class TesteScanner2 {
	
	private Controlador controla = new Controlador();

	private void insereAtualizaContatos2() {

		Contato contato;
		Scanner teclado = new Scanner(System.in);  
	        for (int i = 1 ; i<=5
				; i++){
			contato = new Contato();
			System.out.print("Nome["+i+"]:");			
			contato.setNome(teclado.nextLine());
			System.out.print("Rua["+i+"]:");			
			contato.setEndereco(teclado.nextLine());
			System.out.print("Telefone["+i+"]:");
			contato.setTelefone(teclado.nextLine());
			System.out.print("E-mail["+i+"]:");
			contato.setEmail(teclado.nextLine());
			System.out.print("CPF["+i+"]:");
			contato.setCpf(teclado.nextLine());
			System.out.print("Nascimento["+i+"]:");
			contato.setDataNascimento(teclado.nextLine());
			controla.adicionaContato(contato);
			System.out.println();
			if (i == 3){
				controla.removerContato(contato);
			}
	    }
		teclado.close();
			for (Entry<String, Contato> entry  : Util.entriesSortedByValues(controla.getContatos())) {  
				System.out.println("CPF: "+entry.getKey()+
			    		" - Contato: "+entry.getValue().getNome()
			    			+" Endereco: "+entry.getValue().getEndereco()
			    			+" Telefone: "+entry.getValue().getTelefone()
			    			+" Email: "+entry.getValue().getEmail()
			    			+" CPF: "+entry.getValue().getCpf()
			    			+" Data de Nascimento: "+entry.getValue().getFormattedDate());
			}
			System.out.println("");
	    } 
	
	private void insereAtualizaContatos3() {
		
		Calendar dn7 = new GregorianCalendar(1980,Calendar.AUGUST,1);
		Contato cont7 = new Contato("Fulano", "Rua G", "96672957", "cont7@hotmail.com", "092.312.579-57", dn7.getTime());
		controla.adicionaContato(cont7);
		System.out.println(cont7);
		System.out.println("");
		for (Entry<String, Contato> entry  : Util.entriesSortedByValues(controla.getContatos())) {  
			System.out.println("CPF: "+entry.getKey()+
		    		" - Contato: "+entry.getValue().getNome()
		    			+" Endereco: "+entry.getValue().getEndereco()
		    			+" Telefone: "+entry.getValue().getTelefone()
		    			+" Email: "+entry.getValue().getEmail()
		    			+" CPF: "+entry.getValue().getCpf()
		    			+" Data de Nascimento: "+entry.getValue().getFormattedDate());
	}
	System.out.println("");
}
	private void imprimeContatos2() {
		controla.imprimirContato();
		System.out.println("");
	}
				
	public static void main(String[] args) {

		TesteScanner2 teste = new TesteScanner2();
		teste.insereAtualizaContatos2();
		teste.insereAtualizaContatos3();
		teste.imprimeContatos2();
		System.out.println("Programa executado com sucesso!");
	}
}
