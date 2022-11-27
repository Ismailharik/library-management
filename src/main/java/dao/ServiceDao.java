package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import exceptions.EtudiantNotFoundException;
import model.Etudiant;
import model.Exemplaire;
import model.Livre;
import util.HibernateUtil;

public class ServiceDao implements IServiceDao{

	/*
	 * 	  getEtudiant(CNE: long, motPasse:String) : Etudiant //verifie l’existance d’un etudiant dans la BD 
		- addEtudiant(etudiant : Etudiant) : boolean // ajout d’un nouveau etudiant à la BD
		- getExemplaireDispo() : list<Object> // liste des codes et titres des exemplaires disponibles
		+ getCodeExemplaireDispo() : list<String> // liste des codes des exemplaires disponibles
		+ addEmprunt(CNE : String, codeExemplaire: String) : boolean

	 * */
	
	public Etudiant getEtudiant(String string,String motPasse) throws EtudiantNotFoundException {
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Personne p where p.CNE = :cne and p.motPasse = :password ");
		query.setParameter("cne", string);
		query.setParameter("password", motPasse);
		Etudiant e = (Etudiant)	query.uniqueResult();
		if(e==null) {
			throw new EtudiantNotFoundException("Etudiant avec CNE: "+string+" est Non trouver");
		}
		session.getTransaction().commit();
		return e;
	}
	
	public void addEtudiant(Etudiant e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
	}
	public List<Object> getExemplaireDispo() throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query req=session.createQuery("Select ex.code, liv.titre FROM Exemplaire ex"
				+ " JOIN ex.livre liv where ex.disponible=true");
		
		return (req.list()) ;
    }
	
	public void addExemplaire(Exemplaire e) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
	}
	public void addLivre(Livre l) {
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(l);
		session.getTransaction().commit();
	}


	@Override
	public List<String> getCodeExemplaireDispo() {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req=session.createQuery("select code  from Exemplaire where disponible=true");
		return ( req.list()) ;
	}
	@Override
	public void addEmprunt(String cne, String codeExemplaire) throws EtudiantNotFoundException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Exemplaire e where e.disponible = 1 and e.code = :cd");
		query.setParameter("cd", codeExemplaire);
		Exemplaire e=(Exemplaire)query.uniqueResult();                                                 
		query=session.createQuery("from Etudiant e where e.CNE = :cne");                              
		query.setParameter("cne", cne);
		Etudiant etd = (Etudiant) query.uniqueResult();
		if(etd==null) {
			throw new EtudiantNotFoundException("etudiant avec Id + "+cne+" Not Found");
		}
		if(e==null) {
			System.out.println("Exemplaire with ID :"+codeExemplaire+"not found");
			System.out.println(e);
		}
		
		e.getPersonnes().add(etd);
		e.setDisponible(false);
		session.update(e);
		session.getTransaction().commit();
	}

	@Override
	public Etudiant getEtudiantByCNE(String cne) throws EtudiantNotFoundException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query= session.createQuery("from Personne p where p.CNE  like :cne");
		query.setParameter("cne", cne);
		Etudiant e = (Etudiant) query.uniqueResult();
		return e;
	}

	
}
