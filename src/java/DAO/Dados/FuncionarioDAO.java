/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Dados;

import VO.Dados.Funcionario;
import VO.Dados.Funcionariocargo;
import VO.Dados.Tpcargo;
import br.com.configuration.HibernateUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class FuncionarioDAO {

    public static void salvarFuncionario(Funcionario funcionario, Tpcargo tpcargo) {

        Transaction transaction = null;

        try {
            Session sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();

            //Se o usuário não existe, seta data de criação e isAtivo...
            if (funcionario.getDtcriacao() == null) {
                funcionario.setDtcriacao(new Date());
                funcionario.setIsAtivo(Boolean.TRUE);
            }

            Criteria cargoAtivo = sessao.createCriteria(Funcionariocargo.class);
            
            //Retorna os cargos do funcionario que estão ativos...
            cargoAtivo.add(Restrictions.eq("funcionario", funcionario));
            cargoAtivo.add(Restrictions.eq("isAtual", Boolean.TRUE));

            if (!cargoAtivo.list().isEmpty()) {

                List<Funcionariocargo> lista = cargoAtivo.list();
                
                //Desativa os atuais cargos dos funcionario...
                for (Funcionariocargo c : lista) {
                    c.setIsAtual(Boolean.FALSE);
                    sessao.saveOrUpdate(c);
                }
            } 
            
            tpcargo = DicionarioDAO.pesquisarCargo(tpcargo.getId());
            
            Funcionariocargo fcargo = new Funcionariocargo();
            fcargo.setFuncionario(funcionario);
            fcargo.setTpcargo(tpcargo);
            fcargo.setIsAtual(Boolean.TRUE);
            fcargo.setDtcriacao(new Date());
            
            Set cargos = new HashSet();
            
            cargos.add(fcargo);
            
            funcionario.setFuncionariocargos(cargos);
            
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
    
}
