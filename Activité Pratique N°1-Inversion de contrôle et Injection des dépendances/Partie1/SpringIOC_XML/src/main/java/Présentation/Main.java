package Présentation;

import DAO.IDAO;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        // Injection de dépendances par instanciation statique (new)
        /*IDAOImp daoImp = new IDAOImp();
        IMetierImp metier = new IMetierImp();
        metier.setDao(daoImp);
         */


        /*
            Les langages de programmation compilé offre deux mécanismes
            d'instanciation de classe :
            1. Statique par new
            2. Dynamique
         */

        // Injection de dépendances par instanciation dynamique
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClasseName= scanner.nextLine();
            Class cdao = Class.forName(daoClasseName);
            IDAO dao = (IDAO) cdao.newInstance(); // Objet o = cdao.newInstance();

            String metierClasseName= scanner.nextLine();
            Class cMetier = Class.forName(metierClasseName); //Charger la class dans la mémoire
            IMetier metier= (IMetier) cMetier.newInstance(); //Creer une instance

            Method m= cMetier.getMethod("setDao",IDAO.class);
            m.invoke(metier,dao);

            System.out.println(metier.calcul());

        /* Lors de l'instanciation d'une classe pour la premiere fois
           la classe est chargé dans la mémoire sous forme d'un objet de
           type Classe.
         */


    }
}