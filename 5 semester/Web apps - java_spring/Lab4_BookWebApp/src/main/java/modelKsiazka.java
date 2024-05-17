

import java.io.Serializable;

public class modelKsiazka implements Serializable{

	
	private int idk; 
	private String tytul;
	private modelWydawnictwo wyd;
	private modelKategoria kat;
	
	private static final long serialVersionUID = 1L;

	public int getIdk() {
		return idk;
	}

	public void setIdk(int idk) {
		this.idk = idk;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public modelWydawnictwo getWyd() {
		return wyd;
	}

	public void setWyd(modelWydawnictwo wyd) {
		this.wyd = wyd;
	}

	public modelKategoria getKat() {
		return kat;
	}

	public void setKat(modelKategoria kat) {
		this.kat = kat;
	}

	public modelKsiazka(int idk, String tytul, modelWydawnictwo wyd, modelKategoria kat) {	super();
		this.idk = idk;
		this.tytul = tytul;
		this.wyd = wyd;
		this.kat = kat;
	}
	
		
	
}
