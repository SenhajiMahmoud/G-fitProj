package com.models;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Query;

import com.dao.EmployeDao;
import com.dao.jdbc.EmployeDaoJDBC;

@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Employe emp = new Employe();
	private Directeur dir;
	private List<Employe> list;
	private List<Employe> list2;
	String nom,prenom;
	String password;
	@EJB
	private EmployeDao dao = new EmployeDaoJDBC();
	Query b;
	boolean d;
	public EmployeBeans() {
			emp = new Employe();
			dir = new Directeur();
			list = dao.lister();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Directeur getDir() {
		return dir;
	}

	public void setDir(Directeur dir) {
		this.dir = dir;
	}

	public List<Employe> getList2() {
		return list2;
	}
	public void setList2(List<Employe> list2) {
		this.list2 = list2;
	}
	public Employe getEmp() {
		return emp;
	}
public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public List<Employe> getList() {
		return list;
	}

	public String creer() {		
		boolean b;
		if(emp.getMotDePasse().equals(password)){
			b = dao.creer(emp);
			if(b == true){
				send(emp.getNom(), emp.getPrenom());
				emp = new Employe();
				list = dao.lister();
				return "droitInscription.xhtml?faces-redirect=true";
			
			}else{
//				emp = new Employe();
//				setPassword("");
				return "AjouterEr.xhtml?faces-redirect=true";
				}
		}else{
			emp.setMotDePasse("");
			setPassword("");
			return "Ajouterr.xhtml?faces-redirect=true";
		}
		
		
		}
	
	
	public String creerDirecteur() {
		dao.creer(dir);
		return "";
	}
	
	public String d(Employe e){
		setEmp(e);
		return "affiSupp.xhtml?faces-redirect=true";
	}
	
	public String d2(Employe e){
		setEmp(e);
		return "AffichageDr.xhtml?faces-redirect=true";
	}
	
	
	public String Delete(){
		dao.Delete(emp);
		list=dao.lister();
		return "Affichage.xhtml?faces-redirect=true";
	}
	
	public String Delete2(){
		dao.Delete(emp);
		list=dao.lister();
		return "droitInscription.xhtml?faces-redirect=true";
	}
	
	public String Update(){
		dao.Modifier(emp);
		emp = new Employe();
		nom="";
		prenom="";
		list=dao.lister();
		return "Affichage.xhtml?faces-redirect=true";
	}
	
	public String Update2(){
		dao.Modifier(emp);
		emp = new Employe();
		nom="";
		prenom="";
		list=dao.lister();
		return "droitInscription.xhtml?faces-redirect=true";
	}
	
	public String redirectInscr(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		
		return "UpdateIns.xhtml?faces-redirect=true";
	}
	
	
	public String redirect(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		
		return "testlightBox.xhtml?faces-redirect=true";
	}
	
	public String redirect2Inscr(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		
		return "ApercuIns.xhtml?faces-redirect=true";
	}
	
	
	public String redirect2(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		
		return "Apercu.xhtml?faces-redirect=true";
	}
	
	public String redirectApercu(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		return "ApercuEmploye.xhtml?faces-redirect=true";
	}
	
	public String redirect3(Employe employe){
		emp = new Employe();
		setEmp(employe);
		nom="";
		prenom="";
		
		return "Affichage2.xhtml?faces-redirect=true";
	}
	
	public String Annuler(){
		System.out.println("ok");
		return "Affichage.xhtml?faces-redirect=true";
	}
	
	public String RechercherNP2(){
		list2 = dao.research(nom, prenom);
		if(list2.isEmpty()){
			return "listeVide.xhtml?faces-redirect=true";
		}else{
			return "Affichage2.xhtml?faces-redirect=true";
		}
		
	}
	
	public String RechercherNP2Employe(){
		list2 = dao.research(nom, prenom);
		
		if(list2.isEmpty()){
			return "listeVide2.xhtml?faces-redirect=true";
		}else{
			emp = new Employe();
			return "Affichage2Employe.xhtml?faces-redirect=true";
		}
	}
	
	
	public String RechercherNP3(){
		
		list2 = dao.research(nom, prenom);
		
		if(list2.isEmpty()){
			return "listeVide.xhtml?faces-redirect=true";
		}else{
			emp = new Employe();
			return "Affichage2.xhtml?faces-redirect=true";
		}
	}
	
	public String RechercherNPIns(){
		list2 = dao.research(nom, prenom);
		
		if(list2.isEmpty()){
			return "listeVide3.xhtml?faces-redirect=true";
		}else{
			emp = new Employe();
			return "researchIns.xhtml?faces-redirect=true";
		}
	}
	
	public String redirectAjouter(){
		emp = new Employe();
		return "Ajouter.xhtml?faces-redirect=true";
	}
	public String Actualiser(){
		nom="";
		prenom="";
		emp=new Employe();
		return "Affichage.xhtml?faces-redirect=true";
	}
	
	public String Actualiser2(){
		nom="";
		prenom="";
		emp=new Employe();
		return "AffichageEmploye.xhtml?faces-redirect=true";
	}
	
	public String Actualiser3(){
		nom="";
		prenom="";
		emp=new Employe();
		return "droitInscription.xhtml?faces-redirect=true";
	}
	
	
	
	public String ActualiserEmpl(){
		emp=new Employe();
		nom="";
		prenom="";
		return "AffichageEmploye.xhtml?faces-redirect=true";
	}
	
	public String authentifier(String Email,String password){
		nom = "";
		prenom = "";
		b = dao.Verifier(Email,password);
		d = dao.Verifierdirecteur(Email, password);
			if (d) {
				System.out.println("directeur");
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
					System.out.println("Erreur" + e.getMessage());
				}
				return "droitInscription.xhtml?faces-redirect=true";
			}
			if(b!=null){
				if(b.getSingleResult().equals("Responsable RH") ){
					System.out.println("Responsable RH");
					try {
						Thread.sleep(1500);
					} catch (Exception e) {
						System.out.println("Erreur" + e.getMessage());
					}
					
					return "droitInscription.xhtml?faces-redirect=true";
				}
				else if(b.getSingleResult().equals("Chef Projets") ){
					System.out.println("Chef Projets");
					try {
						Thread.sleep(1500);
					} catch (Exception e) {
						System.out.println("Erreur" + e.getMessage());
					}
					return "Affichage.xhtml?faces-redirect=true";
				}
				else{
					System.out.println("employe");
					try {
						Thread.sleep(1500);
					} catch (Exception e) {
						System.out.println("Erreur" + e.getMessage());
					}
					return "AffichageEmploye.xhtml?faces-redirect=true";
				}
			}
				return "Loginn.xhtml?faces-redirect=true";
		}
	
	public String redirectionLogin(){
		nom = "";
		prenom = "";
		emp = new Employe();
		return "Login.xhtml?faces-redirect=true";
	}
	public void send(String nom,String prenom){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		 
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
		 
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("senmahm@gmail.com","se&mahmoud");
			}
		});
		 
		try {
		 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("senmahm@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse("sema_ma@hotmail.fr")); 
			message.setSubject("Insciption");
			message.setText("Bonjour Mr le directeur\n" + nom + " " + prenom + " " + "vient de s'inscrire");
			Transport.send(message);
		 
		} catch (MessagingException e) {
					throw new RuntimeException(e);
		}
	}
	
}
