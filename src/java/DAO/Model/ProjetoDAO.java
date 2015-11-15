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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daniel
 */
public class ProjetoDAO {

    public static void salvarProjeto(Projeto p, ArrayList<Tag> tagFuncionarios, String operacao) {

        Transaction transaction = null;
        Session sessao = null;

        try {
            sessao = HibernateUtility.getSession();
            transaction = sessao.beginTransaction();

            HashSet<Funcionarioprojeto> funcionarios = tagToFuncionario(sessao, tagFuncionarios, p, operacao);
            p.setFuncionarioprojetos(funcionarios);
            Sitprojeto sitP = new Sitprojeto();
            sitP.setId(1);
            p.setSitprojeto(sitP);

            sessao.saveOrUpdate(p);

            for (Funcionarioprojeto f : funcionarios) {
                sessao.saveOrUpdate(f);
            }

            transaction.commit();

        } catch (HibernateException erro) {
            transaction.rollback();
            erro.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    private static HashSet<Funcionarioprojeto> tagToFuncionario(
            Session sessao, ArrayList<Tag> tags, Projeto p, String operacao) throws Exception {

        HashSet<Funcionarioprojeto> funcionarios = new HashSet<Funcionarioprojeto>();

        for (Tag tag : tags) {
            Criteria criteria = sessao.createCriteria(Funcionario.class).add(Restrictions.eq("id", tag.getTagId()));

            Funcionario funcionario = (Funcionario) criteria.uniqueResult();
            Funcionarioprojeto funcProjeto = funcionarioProjetoSalvo(sessao, funcionario, p);

            if (funcProjeto != null) {
                if (!funcProjeto.getIsAtivo()) {
                    funcProjeto.setIsAtivo(Boolean.TRUE);
                    funcProjeto.setDtalteracao(new Date());
                }
            } else {
                funcProjeto = new Funcionarioprojeto();
                funcProjeto.setFuncionario(funcionario);
                funcProjeto.setProjeto(p);
                funcProjeto.setDtcriacao(new Date());
                funcProjeto.setIsAtivo(Boolean.TRUE);
            }

            funcionarios.add(funcProjeto);
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

    public static void desabilitaFuncionarioProjeto(Funcionario f, Projeto p) {

        Session sessao = null;
        Transaction transaction = null;

        try {
            sessao = HibernateUtility.getSession();

            Funcionarioprojeto fprojeto = funcionarioProjetoSalvo(sessao, f, p);

            transaction = sessao.beginTransaction();

            fprojeto.setDtalteracao(new Date());
            fprojeto.setIsAtivo(Boolean.FALSE);

            sessao.update(fprojeto);

            transaction.commit();
        } catch (HibernateException erro) {
            transaction.rollback();
            erro.printStackTrace();
        } catch (Exception erro) {
            erro.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    private static Funcionarioprojeto funcionarioProjetoSalvo(Session sessao, Funcionario f, Projeto p) {

        if (p.getId() > 0) {
            Criteria cri = sessao.createCriteria(Funcionarioprojeto.class);
            cri.add(Restrictions.eq("funcionario", f));
            cri.add(Restrictions.eq("projeto", p));

            return (Funcionarioprojeto) cri.uniqueResult();
        }

        return null;
    }

    public static ArrayList<Tag> getFuncSalvoToTag(Projeto p) throws Exception {

        Session sessao = HibernateUtility.getSession();
        Criteria cri = sessao.createCriteria(Funcionarioprojeto.class);

        cri.add(Restrictions.eq("projeto", p));
        cri.add(Restrictions.eq("isAtivo", Boolean.TRUE));

        ArrayList<Tag> tags = new ArrayList<Tag>();
        Tag tag;
        String aux = "";

        for (Funcionarioprojeto fprojeto : (List<Funcionarioprojeto>) cri.list()) {
            tag = new Tag();
            aux = fprojeto.getFuncionario().getNome() + " "
                    + fprojeto.getFuncionario().getSobrenome();

            tag.setTagId(fprojeto.getFuncionario().getId());
            tag.setTagName(aux);
            tag.setIsExisteBD(true);

            tags.add(tag);
        }

        return tags;
    }
}
