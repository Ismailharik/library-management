package web;


import java.util.Arrays;
import java.util.Date; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;


import util.HibernateUtil;



import model.Etudiant;
import dao.ServiceDao;
import exceptions.EtudiantNotFoundException;

public class ServiceAction extends ActionSupport {
	
	private String motPasse;
	private String cne;
	private String nom ;
	private String prenom ;
	private  List<String> codeExemplairesDispo;
	private   List<Object>  exemplairesDispo;
	private static final long serialVersionUID = 1L;
	private String codeExemplaire;
	


	private ServiceDao serviceDao = new ServiceDao();
	public ServiceAction() {
		
		try {
			this.codeExemplairesDispo = serviceDao.getCodeExemplaireDispo();
			this.exemplairesDispo = serviceDao.getExemplaireDispo();
			System.out.println(exemplairesDispo.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	


	public String login() {

		if(!motPasse.equals("") && !cne.equals("")) {
			try {
				Etudiant e = serviceDao.getEtudiant(cne, motPasse);
				if(e!=null) {
					ServletActionContext.getRequest().getSession().setAttribute("etudiant", e);
					nom=prenom=motPasse=null;
					return SUCCESS;
				}
			} catch (EtudiantNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addFieldError("cne or Password incorrect", "bad creadential");
		cne=nom=prenom=motPasse=null;
		return ERROR;
		
	}
	
	
	public String validerInscription() {
		if(!motPasse.equals("")&& !cne.equals("") && !prenom.equals("") && !nom.equals("")){
			try {
				Etudiant e = serviceDao.getEtudiantByCNE(cne);
				if(e==null) {
					e = new Etudiant(cne,nom,prenom,motPasse);
					serviceDao.addEtudiant(e);
					ServletActionContext.getRequest().getSession().setAttribute("etudiant", null);
					cne=nom=prenom=motPasse=null;
					return SUCCESS;
					
				}else {
					
					addFieldError("CNE","Already exist ! ");
					return ERROR;
				}
			} catch (EtudiantNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		addFieldError("fill all fields","all fields should be completed");
		return INPUT;
	}
	
	public String addEmprunt() {
		try {
			/*HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			Etudiant etudiant= (Etudiant) session.getAttribute("etudiant") ;
			*/
			serviceDao.addEmprunt(cne, codeExemplaire);
			codeExemplairesDispo=serviceDao.getCodeExemplaireDispo();
			exemplairesDispo=serviceDao.getExemplaireDispo();
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addFieldError("cne", "can't use this CNE :"+cne+" code"+codeExemplaire);
		return ERROR;
	}
	public String getAvailableExemplaire() {
		return "success";
	}

	// Geetters & Setters
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public List<String> getCodeExemplairesDispo() {
		return codeExemplairesDispo;
	}


	public void setCodeExemplairesDispo(List<String> codeExemplairesDispo) {
		this.codeExemplairesDispo = codeExemplairesDispo;
	}


	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	public String getCodeExemplaire() {
		return codeExemplaire;
	}

	public void setCodeExemplaire(String codeExemplaire) {
		this.codeExemplaire = codeExemplaire;
	}



	public List<Object> getExemplairesDispo() {
		return exemplairesDispo;
	}



	public void setExemplairesDispo(List<Object> exemplairesDispo) {
		this.exemplairesDispo = exemplairesDispo;
	}



		
}