package webservices;

public class Musique {

	private String titreMusique;
	private String dureeMusique;
	private String albumMusique;
	private String auteurMusique;

	public Musique(String titreMusique, String dureeMusique, String albumMusique, String auteurMusique) {
		super();
		this.titreMusique = titreMusique;
		this.dureeMusique = dureeMusique;
		this.albumMusique = albumMusique;
		this.auteurMusique = auteurMusique;
	}

	public Musique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitreMusique() {
		return titreMusique;
	}

	public void setTitreMusique(String titreMusique) {
		this.titreMusique = titreMusique;
	}

	public String getDureeMusique() {
		return dureeMusique;
	}

	public void setDureeMusique(String dureeMusique) {
		this.dureeMusique = dureeMusique;
	}

	public String getAlbumMusique() {
		return albumMusique;
	}

	public void setAlbumMusique(String albumMusique) {
		this.albumMusique = albumMusique;
	}

	public String getAuteurMusique() {
		return auteurMusique;
	}

	public void setAuteurMusique(String auteurMusique) {
		this.auteurMusique = auteurMusique;
	}
}
