package Metier;

import DAO.IDAO;

public class IMetierImp implements IMetier{
    // Couplage faible
    private IDAO dao;

    @Override
    public double calcul() {
        double d=dao.getData();
        double res=d+30;
        return res;}

    public void setDao(IDAO dao) {
        this.dao = dao;}
}
