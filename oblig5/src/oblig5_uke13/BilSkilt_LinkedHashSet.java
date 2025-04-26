package oblig5_uke13;

import java.util.LinkedHashSet;

public class BilSkilt_LinkedHashSet {
	
	private int maksStorrelse = 10;
	private LinkedHashSet<String>[] tabell;
	
	@SuppressWarnings("unchecked")
	public BilSkilt_LinkedHashSet(int kapasitet){
		maksStorrelse = kapasitet;
		tabell = new LinkedHashSet[maksStorrelse];
		
		for(int i = 0; i < maksStorrelse; i++) {
			tabell[i] = new LinkedHashSet<>();
		}
	}
		
		private int hash(String bilNummer) {
			return Character.getNumericValue(bilNummer.charAt(bilNummer.length() - 1)) % maksStorrelse;
			
		}
		
		public void settInn(String bilNummer) {
			int hashIndeks = hash(bilNummer);
			tabell[hashIndeks].add(bilNummer);
		}
		public void skrivUtHashTable(){
			System.out.println("Bilskilt : ");
			for(int i = 0; i < maksStorrelse; i++) {
				System.out.println(i +  " | " + tabell[i]);
			}
		}
			
			public static void main(String[]args) {
				BilSkilt_LinkedHashSet hashTable = new BilSkilt_LinkedHashSet(10);
				String[] bilNummerListe = {"EL65431", "TA14374", "ZX87181", "EL47007", "VV50000", "UV14544", "EL32944"};
				
				for(String bilNummer : bilNummerListe) {
					hashTable.settInn(bilNummer);
				}
				hashTable.skrivUtHashTable();
			}
}
