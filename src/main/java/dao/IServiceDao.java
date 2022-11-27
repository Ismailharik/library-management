package dao;

import java.util.List;

import exceptions.EtudiantNotFoundException;
import model.Etudiant;
import model.Exemplaire;
import model.Livre;

public interface IServiceDao {

	Etudiant getEtudiant(String string,String motPasse) throws EtudiantNotFoundException;
	void addEtudiant(Etudiant e);
	List<Object> getExemplaireDispo() throws Exception;
	void addExemplaire(Exemplaire e);
	void addLivre(Livre l);
	List<String> getCodeExemplaireDispo();
	void addEmprunt(String cne,String codeExemplaire) throws EtudiantNotFoundException;
	Etudiant getEtudiantByCNE(String cne) throws EtudiantNotFoundException;
}
