package com.payment.java;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Creditcard.java.Creditcard;
import com.cheque.java.Cheque;

public class Main {

	public static <CreditCard> void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("Inheritance.cfg.xml").addAnnotatedClass(Payment.class)
	            .addAnnotatedClass(Creditcard.class)
	            .addAnnotatedClass(Cheque.class)
	            .buildSessionFactory();

        // Create a Session
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();

        // Create objects
        Payment ccPayment = new Creditcard(500.0, "1234-5678-9876-5432");
        Payment chequePayment = new Cheque(750.0, "CHK987654");

        // Save objects
        session.persist(ccPayment);
        session.persist(chequePayment);

        // Fetch and display records
     //   displayPayments();
        
        for (Payment payment : session.createQuery("FROM Payment", Payment.class).list()) {
            System.out.println("Payment ID: " + payment.getId() +
                               ", Amount: " + payment.getAmount() +
                               (payment instanceof Creditcard ? ", Card: " + ((Creditcard) payment).getCardNumber() : 
                                (payment instanceof Cheque ? ", Cheque: " + ((Cheque) payment).getChequeNumber() : "")));
        }

        session.getTransaction().commit();
        session.close();
   
		    }


	}