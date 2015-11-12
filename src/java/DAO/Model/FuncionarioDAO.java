/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Funcionario;
import VO.Model.Tag;
import br.com.configuration.HibernateUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class FuncionarioDAO {

    public static void salvarFuncionario(Funcionario funcionario, String operacao) {

        Transaction transaction = null;

        try {
            Session sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();

            //Se o usuário não existe, seta data de criação e isAtivo...
            if (operacao.equalsIgnoreCase("I")) {
                funcionario.setDtcriacao(new Date());
                funcionario.setIsAtivo(Boolean.TRUE);
            }

            sessao.saveOrUpdate(funcionario);

            transaction.commit();
            sessao.close();
        } catch (Exception erro) {
            transaction.rollback();
        }
    }

    public static Funcionario pesquisaFuncionario(int id) {
        try {
            Session sessao = HibernateUtility.getSession();
            Criteria cri = sessao.createCriteria(Funcionario.class).add(Restrictions.eq("id", id));
            
            return (Funcionario) cri.uniqueResult();
        } catch (Exception erro) {
            return null;
        }
    }
    
    public static Funcionario autenticacaoLogin(String email, String senha){
        try{
            Session sessao = HibernateUtility.getSession();
            Criteria cri = sessao.createCriteria(Funcionario.class).add(Restrictions.eq("email", email));
            
            cri.add(Restrictions.eq("password", senha));
            
            return (Funcionario) cri.uniqueResult();
        }catch(Exception erro){
            return null;
        }
    }

    public static List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            Session sessao = HibernateUtility.getSession();
            Criteria cri = sessao.createCriteria(Funcionario.class);

            return cri.list();
        } catch (Exception erro) {
            return lista;
        }
    }

    public static List<Tag> getFuncionarios(String dados) {
        
        List<Tag> lista = new ArrayList<Tag>();

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Funcionario.class);

        List<Funcionario> data = cri.list();
        
        String aux = "";
        
        for (Funcionario f : data) {
            
            aux = f.getNome() + " " + f.getSobrenome();
            
            if (aux.contains(dados)) {
                
                lista.add(new Tag(f.getId(), aux));
            }
        }
        
        return lista;
    }
}
