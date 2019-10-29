package br.ufsc.agenda.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.ufsc.agenda.model.Contato;
import util.ObjectPersistence;

public class Controlador {

	private Map<String, Contato> contatos = new HashMap<String,Contato>();
	
	private String arquivo = "contato.txt";

	public Controlador() {
		this.restaura();
	}

	public void adicionaContato(Contato contato) {
		if (!contatos.containsKey(contato.getCpf())) {
			contatos.put(contato.getCpf(), contato);
			this.grava();
			System.out.println("Contato cadastrado com sucesso");
		}else
			System.out.println("N�o foi possivel adicionar, contato com o mesmo CPF");
	}

	public void removerContato(Contato contato){
		if(contatos.containsKey(contato.getCpf())){
			contatos.remove(contato.getCpf(), contato);
			this.grava();
			System.out.println("Contato removido");
		}
	}
	
	private void imprime(Contato contato) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Nome: "+contato.getNome()
				+" Endereco: "+contato.getEndereco()
				+" Telefone: "+contato.getTelefone()
				+" Email: "+contato.getEmail()
				+" CPF: "+contato.getCpf()
				+" Data de Nascimento: "+sdf.format(contato.getDataNascimento())
				);	  
	}

	public void imprimirContato(){
		for(Contato contato : contatos.values()){
			this.imprime(contato);
		}
	}
	
	
	public void imprimirContato(Calendar data){
		int dia, mes, ano, cdia, cmes, cano;
		dia = data.get(Calendar.DAY_OF_MONTH);
		mes = data.get(Calendar.MONTH)+1;
		ano = data.get(Calendar.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Contato contato : contatos.values()){
			String[] cal = sdf.format(contato.getDataNascimento()).split("/");
			cdia = new Integer(cal[0]);
			cmes = new Integer(cal[1]);
			cano = new Integer(cal[2]);
			
			if (cdia == dia && cmes == mes && cano == ano)
				this.imprime(contato);
		}
	}
	

	public Map<String, Contato> getContatos() {
		return contatos;
	}

	public void grava() {
		try {
			ObjectPersistence.store(arquivo, contatos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void restaura() {
		try {
			contatos = (Map<String, Contato>)ObjectPersistence.retrieve(arquivo);
			if (contatos == null)
				contatos = new HashMap<String,Contato>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
