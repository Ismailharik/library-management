import java.util.Arrays;
import java.util.List;

import dao.ServiceDao;
import exceptions.EtudiantNotFoundException;
import model.Etudiant;
import model.Exemplaire;
import model.Livre;
import model.Personne;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Etudiant etd1 = new Etudiant();
		etd1.setCNE("R123");
		//etd1.setId(1L);
		etd1.setMotPasse("M1234");
		etd1.setNom("harik");
		etd1.setPrenom("ismail");
		Etudiant etd2 = new Etudiant();
		etd2.setCNE("R124");
		etd2.setMotPasse("M1234");
		etd2.setNom("harik");
		etd2.setPrenom("ismail");
		
		ServiceDao srvDao = new ServiceDao();
		srvDao.addEtudiant(etd1);
		srvDao.addEtudiant(etd2);
		
		try {
			Etudiant e = srvDao.getEtudiant(etd1.getCNE(), etd1.getMotPasse());
			System.out.println(e);
		}catch(EtudiantNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		Livre l1= new Livre(1L,"clean Code book"); 
		Livre l2= new Livre(1L,"Apprendre les bons pratiques avec Clean code");
		srvDao.addLivre(l1);
		srvDao.addLivre(l2);
		Exemplaire ex1 = new Exemplaire();
		ex1.setCode("codeExp1");
		ex1.setDisponible(true);
		ex1.setLivre(l1);
		
		Exemplaire ex2 = new Exemplaire();
		ex2.setCode("codeExp2");
		ex2.setDisponible(true);
		ex2.setLivre(l1);

		
		//ex1.getPersonnes().add(etd1);// add pers to exp càd emprunter
		try {
			srvDao.addExemplaire(ex1);
			srvDao.addExemplaire(ex2);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// (Emprunt ) add user to exemplaire
		try {
			srvDao.addEmprunt(etd1.getCNE(),ex1.getCode() );
		} catch (EtudiantNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// AFFiICHER LIST DES (code , titre)pour chaque exmp
			List<Object> listExmp = srvDao.getExemplaireDispo();
			for (int i=0; i<listExmp.size(); i++){
			Object[] row = (Object[]) listExmp.get(i);
			System.out.println("Element "+i+Arrays.toString(row));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
