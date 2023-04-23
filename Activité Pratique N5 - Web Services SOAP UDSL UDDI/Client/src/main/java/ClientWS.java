import mypackage.BanqueService;
import mypackage.BanqueWS;
import mypackage.Compte;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stub =  new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(806));
        Compte cp=stub.getCompte(5);
        System.out.println(cp.getCode()+"-"+cp.getSolde());

    }
}
