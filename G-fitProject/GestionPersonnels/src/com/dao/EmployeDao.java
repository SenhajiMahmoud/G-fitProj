package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.models.Directeur;
import com.models.Employe;

public interface EmployeDao {

	public boolean creer(Employe emp);

	public List<Employe> lister();

	public void Delete(Employe emp);

	public void Modifier(Employe emp);
	
	public Employe findById(int id);
	
	public List<Employe> research(String nom,String prenom);
	
	public Query Verifier(String Email,String password);
	
	public boolean Verifierdirecteur(String Email,String password);
	
	public void creer(Directeur dir);
}
