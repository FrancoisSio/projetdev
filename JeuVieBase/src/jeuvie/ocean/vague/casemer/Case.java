package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;

public abstract class Case implements ICase {

	public abstract Couleur getCouleurCaseVide();
	protected abstract void setBestioleVivante();
	
	protected boolean vide=true;
	protected IBestiole occupant = null;
	
	
	public void setVivante(){
		this.vide=false;
		this.setBestioleVivante(); 
	}	

	public Couleur getCouleur(){
	Couleur C = getCouleurCaseVide();
	if (!vide) 
		C = this.occupant.getCouleur();
		return C;
	}


	@Override
	public boolean isVide() {
		return vide;
		
		
	}
	public boolean contientBestioleVivante() {	
		return this.occupant!=null && this.occupant.isVivante();
	}

	
	public void tuerEventuelOccupant(){
		if (contientBestioleVivante()) {
			this.occupant.tuer();
		}
	}
		
	
	
	
	public Case() {
		super();
	}
	
	public Case(boolean vide, IBestiole occupant) {
		super() ;
		this.vide = vide;
		this.occupant = occupant;
	}

}
