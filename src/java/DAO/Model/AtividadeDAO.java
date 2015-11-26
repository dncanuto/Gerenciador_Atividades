/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Model;

import VO.Model.Atividade;
import VO.Model.Funcionario;
import VO.Model.Funcionarioprojeto;
import VO.Model.Projeto;
import VO.Model.Sprint;
import VO.Model.Tag;
import VO.Model.Tptempo;
import br.com.configuration.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Programador
 */
public class AtividadeDAO {

    public static void salvarAtividade(Atividade atividade) {
        Session sessao = null;
        Transaction transaction = null;

        try {
            sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();

            sessao.saveOrUpdate(atividade);

            transaction.commit();
        } catch (HibernateException erro) {
            transaction.rollback();
        } catch (Exception erro) {
            erro.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public static Atividade pesquisaAtividade(int id) {
        Session sessao = HibernateUtility.getSession();

        Criteria cri = sessao.createCriteria(Atividade.class);
        cri.add(Restrictions.eq("id", id));

        return (Atividade) cri.uniqueResult();
    }

    public static List<Atividade> listarAtividades() {
        Session sessao = HibernateUtility.getSession();

        Criteria cri = sessao.createCriteria(Atividade.class);

        return cri.list();
    }

    public static List<Atividade> listarAtividades(Sprint s) {
        Session sessao = HibernateUtility.getSession();

        Criteria cri = sessao.createCriteria(Atividade.class);
        cri.add(Restrictions.eq("sprint", s));

        return cri.list();
    }

    public static List<Atividade> listarAtividadesFuncionario(Funcionario f) {
        Session sessao = HibernateUtility.getSession();
        
        Criteria cri = sessao.createCriteria(Funcionarioprojeto.class);
        cri.add(Restrictions.eq("funcionario", f));

        return getAtividadesFuncionarioProjeto(cri.list());
    }

    private static List<Atividade> getAtividadesFuncionarioProjeto(List<Funcionarioprojeto> lista) {

        Session sessao = HibernateUtility.getSession();
        List<Atividade> atividades = new ArrayList<Atividade>();

        for (Funcionarioprojeto f : lista) {

            atividades.addAll(f.getAtividades());
        }
        
        return atividades;
    }

    public static List<Tag> getFuncionarios(int projetoId, String funcionarioNome) {

        List<Tag> lista = new ArrayList<Tag>();

        Projeto p = new Projeto();
        p.setId(projetoId);

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Funcionarioprojeto.class);
        cri.add(Restrictions.eq("projeto", p));
        cri.add(Restrictions.eq("isAtivo", Boolean.TRUE));

        List<Funcionarioprojeto> data = cri.list();

        String aux = "";

        for (Funcionarioprojeto f : data) {

            aux = f.getFuncionario().getNome() + " " + f.getFuncionario().getSobrenome();

            if (aux.contains(funcionarioNome)) {
                lista.add(new Tag(f.getId(), aux));
            }
        }

        return lista;
    }

    public static Funcionarioprojeto getFuncAtividadeSelecionado(int funcionarioprojetoId) {
        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Funcionarioprojeto.class);
        cri.add(Restrictions.eq("id", funcionarioprojetoId));

        return (Funcionarioprojeto) cri.uniqueResult();
    }
}
