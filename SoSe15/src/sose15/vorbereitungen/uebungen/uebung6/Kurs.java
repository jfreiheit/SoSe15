package sose15.vorbereitungen.uebungen.uebung6;

public class Kurs {
	private String kursName;
	private Integer obereGrenze;
	private Integer aktTeilnehmer;
	
	public String getKursName() {
		return kursName;
	}
	
	public Integer getObereGrenze() {
		return obereGrenze;
	}
	
	public Integer getAktTeilnehmer() {
		return aktTeilnehmer;
	}
	
	public Kurs(final String kursName, final Integer obereGrenze) {
		super();
		this.kursName = kursName;
		this.obereGrenze = obereGrenze;
		this.aktTeilnehmer = new Integer(0);
	}
	
	public boolean buchen()
	{
		if(aktTeilnehmer.intValue()>=obereGrenze.intValue()) 
			return false;
		else
		{
			aktTeilnehmer= new Integer(aktTeilnehmer.intValue()+1); //aktTeilnehmer++
			return true;
		}
	}

}
