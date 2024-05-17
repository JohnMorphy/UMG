import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoKsiazki {

	private Connection dbcon=null;
	private Statement dbstat=null;
	
	private void otworzCon()
	{
		
		String login = "postgres";
		String haslo = "postgres";
		String url =  "jdbc:postgresql://localhost:5432/postgres?currentSchema=\"users\"";
		
	try {
	Class.forName("org.postgresql.Driver");
	dbcon = DriverManager.getConnection(url, login, haslo);
	dbstat=dbcon.createStatement();
	}
	catch (ClassNotFoundException ex) {
		System.err.println("ClassNotFoundException z init:"
		+ex.getMessage());
	}
	catch (SQLException ex) {
		System.err.println("SQLException z init: " + ex.getMessage());}
	}
	
	private void zamknijCon() {
		if(dbcon==null) return;
		try {
		dbcon.close();
		}
		catch(SQLException ex) {
			System.out.println("Problem z zamknięciem bazy");
		}
	}

	public ArrayList<modelKategoria> listaKategorii() {
		ArrayList<modelKategoria> lk= new ArrayList<modelKategoria>();
		
		String pyt="SELECT * FROM ksiazki.kategoria";
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				modelKategoria k=new modelKategoria(wyniki.getInt("idk"), wyniki.getString("opis"));
				lk.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lk;
	}
	
	public ArrayList<modelWydawnictwo> listaWydawnictw() {
		ArrayList<modelWydawnictwo> lw= new ArrayList<modelWydawnictwo>();
		
		String pyt="SELECT * FROM ksiazki.wydawnictwo";
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				modelWydawnictwo k=new modelWydawnictwo(wyniki.getInt("idw"), wyniki.getString("nazwa"), wyniki.getString("adres"));
				lw.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lw;
	}
	
	public ArrayList<modelKategoria> listaKategoriiDoUsuniecia() {
		ArrayList<modelKategoria> lk= new ArrayList<modelKategoria>();
		
		String pyt= "SELECT ksiazki.kategoria.idk, ksiazki.kategoria.opis, ksiazki.ksiazka.idkat from ksiazki.kategoria LEFT OUTER JOIN ksiazki.ksiazka ON ksiazki.kategoria.idk = ksiazki.ksiazka.idkat WHERE ksiazki.ksiazka.idkat IS NULL;";
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				modelKategoria k=new modelKategoria(wyniki.getInt("idk"), wyniki.getString("opis"));
				lk.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lk;
	}
	
	public ArrayList<modelWydawnictwo> listaWydawnictwDoUsuniecia() {
		ArrayList<modelWydawnictwo> lw= new ArrayList<modelWydawnictwo>();
		
		String pyt="SELECT ksiazki.wydawnictwo.idw, ksiazki.wydawnictwo.nazwa, ksiazki.wydawnictwo.adres FROM ksiazki.wydawnictwo LEFT OUTER JOIN ksiazki.ksiazka ON ksiazki.wydawnictwo.idw = ksiazki.ksiazka.idwyd WHERE ksiazki.ksiazka.idwyd IS NULL;";
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				modelWydawnictwo k=new modelWydawnictwo(wyniki.getInt("idw"), wyniki.getString("nazwa"), wyniki.getString("adres"));
				lw.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lw;
	}

	
	
	public ArrayList<modelKsiazka> listaKsiazek() {
		ArrayList<modelKsiazka> lk= new ArrayList<modelKsiazka>();
		
		String pyt="SELECT * FROM ksiazki.ksiazka";

		ArrayList<modelWydawnictwo> listaWydawnictw=this.listaWydawnictw();
		ArrayList<modelKategoria> listaKategorii=this.listaKategorii();
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				
				int idwyd = wyniki.getInt("idwyd");
				int idkat = wyniki.getInt("idkat");
				
				modelKsiazka k=new modelKsiazka(wyniki.getInt("idk"), wyniki.getString("tytul"), 
						 listaWydawnictw.stream().
						 filter(wydawnictwo -> idwyd == wydawnictwo.getIdw())
						 .findAny().orElse(null),
						 listaKategorii.stream().
						 filter(kategoria -> idkat == kategoria.getIdk())
						 .findAny().orElse(null));
				lk.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lk;
	}
	
	public ArrayList<modelKsiazka> listaKsiazekKategorii(int id) {
		ArrayList<modelKsiazka> lk= new ArrayList<modelKsiazka>();
		
		String pyt="SELECT * FROM ksiazki.ksiazka WHERE idkat='"+id+"'";

		ArrayList<modelWydawnictwo> listaWydawnictw=this.listaWydawnictw();
		ArrayList<modelKategoria> listaKategorii=this.listaKategorii();
		
		try
		{
			otworzCon();
			ResultSet wyniki=dbstat.executeQuery(pyt);
			while(wyniki.next()) {
				
				int idwyd = wyniki.getInt("idwyd");
				int idkat = wyniki.getInt("idkat");
				
				modelKsiazka k=new modelKsiazka(wyniki.getInt("idk"), wyniki.getString("tytul"), 
						 listaWydawnictw.stream().
						 filter(wydawnictwo -> idwyd == wydawnictwo.getIdw())
						 .findAny().orElse(null),
						 listaKategorii.stream().
						 filter(kategoria -> idkat == kategoria.getIdk())
						 .findAny().orElse(null));
				lk.add(k); 
			}
		}
		catch (Exception e) {System.out.println(e);}
		finally {zamknijCon();}
		
		return lk;
	}
	
	public String dodajKsiazke(String tytul, int idwyd, int idkat) {
		
		String pyt="INSERT INTO ksiazki.ksiazka" +
		 " (tytul,idwyd,idkat) values (?, ?, ?);";

		String result = "Książka nie została dodana";

		try 
		{
			otworzCon();
			
			try (PreparedStatement preparedStatement = dbcon.prepareStatement(pyt)) {
	            preparedStatement.setString(1, tytul);
	            preparedStatement.setInt(2, idwyd);
	            preparedStatement.setInt(3, idkat);

	            if(preparedStatement.executeUpdate() > 0) {
	            	result = "Książa zatytułowana \"" + tytul + "\" została dodana";
	            }
	            
			} catch (SQLException e) {
	            e.printStackTrace();
	            result = e.getMessage();
	        }
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
	
		return result;
	}
	
	public String usunKsiazke(int idk) {
		
		String pyt="DELETE FROM ksiazki.ksiazka" +
				 " WHERE idk=\'"+ idk +"\';";

		String result = "Ksiazka nie została usunięta";

		try 
		{
			otworzCon();
			
			try {
		           
			PreparedStatement preparedStatement = dbcon.prepareStatement(pyt);
						
			if(preparedStatement.executeUpdate() > 0) {
			   	result = "Książka o id "+ idk +" usunięta pomyślnie";
			}
			            
			} catch (SQLException e) {
				e.printStackTrace();
			    result = e.getMessage();
			}
					
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
			
		return result;
	}
	
	
	public String dodajKategorie(String opis) {
		
		String pyt="INSERT INTO ksiazki.kategoria" +
		 " (opis) values (\'"+ opis +"\');";

		String result = "Kategoria nie została dodana";

		try 
		{
			otworzCon();
			
			try {
		           
				PreparedStatement preparedStatement = dbcon.prepareStatement(pyt);
								
				if(preparedStatement.executeUpdate() > 0) {
				   	result = "Kateogria o nazwie "+ opis +" dodana pomyślnie";
				}
			            
			} catch (SQLException e) {
				e.printStackTrace();
			    result = e.getMessage();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
	
		return result;
	}


	public String usunKategorie(int idk) {
		
		String pyt="DELETE FROM ksiazki.kategoria" +
				 " WHERE idk=\'"+ idk +"\';";

		String result = "Kategoria nie została usunięta";


		try 
		{
			otworzCon();
			
			try {
		           
				PreparedStatement preparedStatement = dbcon.prepareStatement(pyt);
								
				if(preparedStatement.executeUpdate() > 0) {
				   	result = "Kateogria o id "+ idk +" usunięta pomyślnie";
				}
			            
			} catch (SQLException e) {
				e.printStackTrace();
			    result = e.getMessage();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
	
		return result;
	}

	
	public String dodajWydawnictwo(String nazwa, String adres) {
		
		String pyt="INSERT INTO ksiazki.wydawnictwo" +
		 " (nazwa,adres) values (\'"+ nazwa +"\',\'"+ adres +"\');";

		String result = "Wydawnictwo nie zostało dodane";

		try 
		{
			otworzCon();
			
			try {
		           
				PreparedStatement preparedStatement = dbcon.prepareStatement(pyt);
								
				if(preparedStatement.executeUpdate() > 0) {
				   	result = "Wydawnictwo o nazwie " + nazwa + " dodana pomyślnie";
				}
			            
			} catch (SQLException e) {
				e.printStackTrace();
			    result = e.getMessage();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
	
		return result;
	}

	public String usunWydawnictwo(int idw) {
		
		String pyt="DELETE FROM ksiazki.wydawnictwo" +
				 " WHERE idw=\'"+ idw +"\';";

		String result = "Wydawnictwo nie zostało usunięte";


		try 
		{
			otworzCon();
			
			try {
		           
				PreparedStatement preparedStatement = dbcon.prepareStatement(pyt);
								
				if(preparedStatement.executeUpdate() > 0) {
				   	result = "Wydawnictwo o id " + idw + " usunięte pomyślnie";
				}
			            
			} catch (SQLException e) {
				e.printStackTrace();
			    result = e.getMessage();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		finally {
			zamknijCon();
		}
	
		return result;
	}

	
}
