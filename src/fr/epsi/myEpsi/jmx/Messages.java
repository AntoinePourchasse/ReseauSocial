package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.dao.MessageDao;

public class Messages implements MessagesMBean {

	
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return "Le nombre de message est :";
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return fr.epsi.myEpsi.dao.MessageDao.nbrMessage();
	}

	@Override
	public void afficherNbrMes() {
		System.out.println(getNom() + " " + getValeur()); 

	}

}
