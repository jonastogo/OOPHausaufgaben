package verwaltungMitarbeiter;

public class Angestellte extends Person{

	private double nursingInsurance;
	private boolean hasKids;
	protected double salary;

	public Angestellte(String surName, String firstName, String street,
			String city, int zip, int day, int month, int year, double salary, boolean hasKids) {
		super(surName, firstName, street, city, zip, day, month, year);	
		this.salary = salary;
		this.hasKids=hasKids;
		if (this.getAge() >= SocialInsurance.AGETHRESHOLD  && !this.hasKids) {
			this.nursingInsurance = SocialInsurance.NURSINGCAREWITHOUTKIDS ;
		} else {
			this.nursingInsurance = SocialInsurance.NURSINGCAREWITHKIDS; 
		}
		
	}

	public boolean haveToPayTaxes() {
		return getNetto() * 12 > SocialInsurance.TAXEXEMPTION;
	}
	
	private double getSocialInsuranceFaktor() {
		return 100 -(nursingInsurance+ SocialInsurance.HEALTHINSURANCE + SocialInsurance.UNIMPLOYMENTINSURANCE+ SocialInsurance.RETIREMENTINSURANCE);
	}
	
	public double getNetto() {
		double retVal = (salary * getSocialInsuranceFaktor()/100); 
		return retVal;
	}

	public String toString() {
		String s= super.toString();
		s += String.format("\t%10b" + "\t"+ "\t%6.2f" , this.haveToPayTaxes(), this.getNetto());
		return s;
	}

}
