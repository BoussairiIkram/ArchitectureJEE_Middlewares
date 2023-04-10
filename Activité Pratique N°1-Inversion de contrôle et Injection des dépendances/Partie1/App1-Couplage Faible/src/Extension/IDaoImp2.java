package Extension;

import DAO.IDAO;

public class IDaoImp2 implements IDAO {
    @Override
    public double getData() {
        System.out.println("Version Web Service");
        return 10;
    }
}
