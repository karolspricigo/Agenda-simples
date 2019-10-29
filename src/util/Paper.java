package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paper {
	
	private String id = "";
	private String title = "";
	private String text = "";
	private Date publication;
	private String fragment = "";
	
	public Paper() {
	}

	public Paper(String id, final String title, final String text,
			Date publication, String fragment) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.publication = publication;
		this.fragment = fragment;
	}

	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getText() {
		return this.text;
	}

	public Date getPublication() {
		return this.publication;
	}

	public String getPublicationAsString() {
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");
		return sdt.format(this.publication);
	}

	public String getFormattedDate() {
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		return sdt.format(this.publication);
	}

	public String getFragment() {
		return fragment;
	}

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}
	
	

}
