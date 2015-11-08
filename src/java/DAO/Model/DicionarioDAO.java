/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Tpcargo;
import br.com.configuration.HibernateUtility;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class DicionarioDAO {

    public static List<Tpcargo> listarCargos() throws Exception{

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Tpcargo.class);
        cri.add(Restrictions.eq("isAtivo", Boolean.TRUE));

        return cri.list();
    }
    
    public static Tpcargo pesquisarCargo(int id) throws Exception{

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Tpcargo.class);
        cri.add(Restrictions.eq("id", id));

        return (Tpcargo)cri.uniqueResult();
    }    
}
