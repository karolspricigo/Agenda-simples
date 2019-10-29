package br.ufsc.agenda.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import util.Utils;

public class Contato implements Comparable<Contato>, Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String nome= "";
	private String endereco= "";
	private String telefone;
	private String email="";
	private String cpf="";
	private Date dataNascimento;
	
	
	public Contato (String nome, String endereco, String telefone, String email, String cpf, Date dataNascimento){
		this.setNome (nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
	}
	
	public Contato() {
		super();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getFormattedDate() {
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		if (this.dataNascimento!=null)
			return sdt.format(this.dataNascimento);
		else 
			return "";
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		try {
			this.dataNascimento = Utils.strToDate(dataNascimento);
		} catch (ParseException e) {
			System.out.println("Problemas na convers�o de data:"+e.getMessage());
		}
	}

	public int compareTo(Contato contato){
		int ordem = this.getNome().compareTo(contato.getNome());
		if (ordem == 0)
			return this.getCpf().compareTo(contato.getCpf());
		return ordem;
	}
	
	public static String calendarToStr(Calendar dataNascimento) {
		if (dataNascimento != null) {			
				SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");		
				String str = formatoDate.format(dataNascimento.getTime());
				return str;									
		}
		else {
			return null;
		}
	}
}

