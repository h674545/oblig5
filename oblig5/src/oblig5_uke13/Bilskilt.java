package oblig5_uke13;

public class Bilskilt {
	private int maksStorrelse = 10;
	private int nyStorrelse = maksStorrelse *2;
	private String [] tabell;
	private String []tabell2;
	
	public Bilskilt(int kapasitet) {
		maksStorrelse = kapasitet;
		tabell = new String[maksStorrelse];
		tabell2 = new String[nyStorrelse];
	}
	
	private int hash(String bilNummer, int storrelse) {
		return Character.getNumericValue(bilNummer.charAt(bilNummer.length()-1)) % storrelse;
		
	}
	
	// hvis plassen er opptatt, øker vi indeksen med 1 til en ledig plass finnes 
	public void settInn(String bilNummer) {
		int hashIndeks = hash(bilNummer, maksStorrelse);
		
		while(tabell[hashIndeks] != null) {
			hashIndeks = (hashIndeks +1) % maksStorrelse; // +1 går altså til neste 
		}
		tabell[hashIndeks] = bilNummer;
		
	}
	
	public void nyTabell2 () { 
		for(String bilNummer : tabell) {
			if(bilNummer != null) {
				int hashIndeks = hash(bilNummer, nyStorrelse);
				
				while(tabell2[hashIndeks] != null) {
					hashIndeks = (hashIndeks +1) % nyStorrelse;
				}
				tabell2[hashIndeks] = bilNummer;
			}
		}
	}
	public void skrivUtHashTable() {
		
		System.out.println("Bilskilt : ");
		for(int i = 0; i < maksStorrelse; i++) {
				System.out.println(i + " | " + (tabell[i] != null ? tabell[i] : "[]"));
		}
		System.out.println("Bilskilt tabell med dobbel lengde : ");
		for(int j = 0; j < nyStorrelse; j++) {
				System.out.println(j + " | " + (tabell2[j] !=null ? tabell[j] : "[]"));
		}
	}
	
	public static void main(String[]args) {
		
		Bilskilt hashTable = new Bilskilt(10);
		
		String []bilNummerListe = {"EL65431","TA14374","ZX87181","EL47007", "VV50000","V14544","EL32944"};
		
		for(String bilNummer : bilNummerListe) {
			hashTable.settInn(bilNummer);
		}
	
	
	hashTable.nyTabell2();
		
	
	hashTable.skrivUtHashTable();
	}

}
