/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Funcionario;
import VO.Model.Funcionarioprojeto;
import VO.Model.Projeto;
import VO.Model.Sitprojeto;
import VO.Model.Tag;
import br.com.configuration.HibernateUtility;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class ProjetoDAO {

    public static void salvarProjeto(Projeto p, ArrayList<Tag> tagFuncionarios) {

        Transaction transaction = null;

        try {
            Session sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();

            HashSet<Funcionarioprojeto> funcionarios = tagToFuncionario(sessao, tagFuncionarios, p);

            p.setFuncionarioprojetos(funcionarios);

            Sitprojeto sitP = new Sitprojeto();
            sitP.setId(1);
            p.setSitprojeto(sitP);

            sessao.saveOrUpdate(p);

            transaction.commit();
            sessao.close();
        } catch (Exception erro) {
            transaction.rollback();
        }
    }

    private static HashSet<Funcionarioprojeto> tagToFuncionario(Session sessao, ArrayList<Tag> tags, Projeto p) throws Exception {

        HashSet<Funcionarioprojeto> funcionarios = new HashSet<Funcionarioprojeto>();

        Funcionarioprojeto funcProjeto;

        for (Tag tag : tags) {
            Criteria criteria = sessao.createCriteria(Funcionario.class).add(Restrictions.eq("id", tag.getTagId()));

            funcProjeto = new Funcionarioprojeto();

            if (criteria.uniqueResult() != null) {
                funcProjeto.setFuncionario((Funcionario) criteria.uniqueResult());
                funcProjeto.setProjeto(p);
                funcProjeto.setDtcriacao(new Date());
                funcProjeto.setIsAtivo(Boolean.TRUE);

                funcionarios.add(funcProjeto);
            }
        }

        return funcionarios;
    }

    public static Projeto pesquisaProjeto(int id) throws Exception {

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Projeto.class);
        
        cri.add(Restrictions.eq("id", id));

        return (Projeto) cri.uniqueResult();

    }
    
    public static List<Projeto> listarProjetos() throws Exception {

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Projeto.class);  

        return cri.list();

    }
}
