


public class modelWydawnictwo {

	private int idw;
	private String nazwa;
	private String adres;
	
	public void setIdw(int idw) {
		this.idw = idw;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public int getIdw() {
		return idw;
	}
	public String getNazwa() {
		return nazwa;
	}
	public String getAdres() {
		return adres;
	}
	public modelWydawnictwo(int idw, String nazwa, String adres) {
		super();
		this.idw = idw;
		this.nazwa = nazwa;
		this.adres = adres;
	}
	
	
	
}
