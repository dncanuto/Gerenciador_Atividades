/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate.Dados;

import VO.Dados.FuncionarioVO;
import br.com.configuration.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daniel
 */
public class FuncionarioDAO {

    public static void criaFuncionario(FuncionarioVO funcionario) {

        try {
            Session sessao = HibernateUtility.getSession();
            Transaction transaction = sessao.beginTransaction();

            sessao.saveOrUpdate(funcionario);
            transaction.commit();
            sessao.close();
        } catch (Exception erro) {

        }
    }

}
