package webservices;

import network.Container;

public class Allocine implements Container{

	
	private String nomFilm;
	private String synopsisFilm;
	private String auteursFilm;

	public Allocine(String nomFilm, String synopsisFilm, String auteursFilm) {
		super();
		this.nomFilm = nomFilm;
		this.synopsisFilm = synopsisFilm;
		this.auteursFilm = auteursFilm;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public String getSynopsisFilm() {
		return synopsisFilm;
	}

	public void setSynopsisFilm(String synopsisFilm) {
		this.synopsisFilm = synopsisFilm;
	}

	public String getAuteursFilm() {
		return auteursFilm;
	}

	public void setAuteursFilm(String auteursFilm) {
		this.auteursFilm = auteursFilm;
	}

}
