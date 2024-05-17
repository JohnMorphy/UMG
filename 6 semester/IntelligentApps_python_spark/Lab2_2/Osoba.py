class Osoba:
  def __init__(self, dane):
    self.wiek = int(dane[0]);
    self.formaZatrudnienia = dane[1];
    self.wagaKontrolna = dane[2];
    self.wyksztalcenie = dane[3];
    self.wyksztalcenieLiczbowo = int(dane[4]);
    self.stanCywilny = dane[5];
    self.grupaZawodowa = dane[6];
    self.relacjaRodzinna = dane[7];
    self.rasa = dane[8];
    self.plec = dane[9];
    self.zysk = dane[10];
    self.strata = dane[11];
    self.godzinyTygodniowo = int(dane[12]);
    self.kraj = dane[13];
    self.klasaZysku = dane[14];
    
  def __str__(self):
    return str(vars(self))

  def __repr__(self):
    return "{"+str(self.wiek) + ", " + str(self.kraj) + ", " +str(self.wyksztalcenie) + "...}"
 