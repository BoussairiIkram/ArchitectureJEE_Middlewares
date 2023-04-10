package Metier;

import DAO.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IMetierImp implements IMetier{
    // Couplage faible
    @Autowired
    private IDAO dao;

    @Override
    public double calcul() {
        double d=dao.getData();
        double res=d+30;
        return res;}

    public void setDao(IDAO dao) {
        this.dao = dao;}
}
