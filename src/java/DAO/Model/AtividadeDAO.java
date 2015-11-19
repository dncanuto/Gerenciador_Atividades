/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Atividade;
import br.com.configuration.HibernateUtility;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Programador
 */
public class AtividadeDAO {
    
    public static void salvarAtividade(Atividade atividade){
        Session sessao = null;
        Transaction transaction = null;
        
        try{
            sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();
            
            sessao.saveOrUpdate(atividade);
            transaction.commit();
        }catch(HibernateException erro){
            transaction.rollback();
            erro.printStackTrace();
        }catch(Exception erro){
            erro.printStackTrace();
        }finally{
            sessao.close();
        }
    }
    
    public static List<Atividade> listarAtividades(){
        Session sessao = HibernateUtility.getSession();
        
        Criteria cri = sessao.createCriteria(Atividade.class);        
        
        return cri.list();
    }
}
