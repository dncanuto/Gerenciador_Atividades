/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Projeto;
import VO.Model.Sitsprint;
import VO.Model.Sprint;
import br.com.configuration.HibernateUtility;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class SprintDAO {
    
    public static void salvarSprint(Sprint s){
        Session sessao = null;
        Transaction transaction = null;
        
        try{
            sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();
            
            /*Sitsprint sit = new Sitsprint();
            sit.setId(1);            
            s.setSitsprint(sit);*/
            
            sessao.saveOrUpdate(s);
            transaction.commit();
        }
        catch(HibernateException erro){
            transaction.rollback();
            erro.printStackTrace();
        }
        catch(Exception erro){
            erro.printStackTrace();
        }
        finally{
            sessao.close();
        }
    }
    
    public static Sprint pesquisaSprint(int sprintId){
        Session sessao = HibernateUtility.getSession();
        
        Criteria cri = sessao.createCriteria(Sprint.class);
        cri.add(Restrictions.eq("id", sprintId));
        
        return (Sprint) cri.uniqueResult();
    }
    
    public static List<Sprint> listarSprints(){
        Session sessao = HibernateUtility.getSession();
        
        Criteria cri = sessao.createCriteria(Sprint.class);        
        
        return cri.list();
    }
    
    public static List<Sprint> listarSprints(Projeto p){
        Session sessao = HibernateUtility.getSession();
        
        Criteria cri = sessao.createCriteria(Sprint.class);
        cri.add(Restrictions.eq("projeto", p));
        
        return cri.list();
    }
}
