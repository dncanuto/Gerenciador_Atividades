/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.Model.AtividadeDAO;
import DAO.Model.DicionarioDAO;
import DAO.Model.SprintDAO;
import VO.Model.Atividade;
import VO.Model.Funcionario;
import VO.Model.Sitatividade;
import VO.Model.Sprint;
import VO.Model.Tpprioridade;
import VO.Model.Tptempo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel
 */
@Controller
public class controladorAtividade {

    @RequestMapping("nova-atividade-restrito")
    public ModelAndView novaAtividade(int sprintId) {
        Sprint s = SprintDAO.pesquisaSprint(sprintId);
        return montaCadAtividade(new Atividade(), s, "I");
    }

    @RequestMapping("alterar-atividade-restrito")
    public ModelAndView alterarAtividade(int atividadeId) {
        Atividade a = AtividadeDAO.pesquisaAtividade(atividadeId);
        return montaCadAtividade(a, a.getSprint(), "A");
    }
    
    @RequestMapping("alterar-atividade-funcionario-restrito")
    public ModelAndView alterarAtividadeFuncionario(int atividadeId) {
        Atividade a = AtividadeDAO.pesquisaAtividade(atividadeId);
        return montaCadAtividade(a, a.getSprint(), "U");
    }

    private ModelAndView montaCadAtividade(Atividade a, Sprint sprint, String operacao) {
        ModelAndView mv = new ModelAndView("modal/cad-atividade");
        mv.addObject("atividade", a);
        mv.addObject("sprint", sprint);
        mv.addObject("operacao", operacao);
        mv.addObject("funcAtividadeProjeto", a.getFuncionarioprojeto());
        mv.addObject("listaPrioridade", DicionarioDAO.listarDadosEntidade(Tpprioridade.class));
        mv.addObject("listaTempo", DicionarioDAO.listarDadosEntidade(Tptempo.class));
        mv.addObject("listaSituacao", DicionarioDAO.listarDadosEntidade(Sitatividade.class));
        return mv;
    }

    @RequestMapping("lista-atividade-restrito")
    public ModelAndView listarAtividade(int sprintId) {

        Sprint s = SprintDAO.pesquisaSprint(sprintId);

        ModelAndView mv = new ModelAndView("gridAtividade");
        mv.addObject("listaAtividade", AtividadeDAO.listarAtividades(s));
        return mv;
    }

    @RequestMapping("get-atividades-funcionario-restrito")
    public ModelAndView getAtividadesFuncionario(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        Funcionario f = (Funcionario) sessao.getAttribute("funcionario");

        ModelAndView mv = new ModelAndView("atividade-funcionario");
        mv.addObject("listaAtividade", AtividadeDAO.listarAtividadesFuncionario(f));

        return mv;
    }

    @RequestMapping(value = "get-funcionarios-projeto", method = RequestMethod.GET, headers = "Accept=*/*", produces = "text/html; charset=UTF-8")
    public @ResponseBody
    String getFuncionariosProjeto(int projetoId, @RequestParam String funcName) {

        String searchList = new Gson().toJson(AtividadeDAO.getFuncionarios(projetoId, funcName));
        return searchList;
    }

    @RequestMapping("get-funcionario-atividade-restrito")
    public ModelAndView getFuncAtividadeSelecionado(int funcionarioProjetoId) {
        ModelAndView mv = new ModelAndView("modal/funcionarioAtividade");
        mv.addObject("funcAtividadeProjeto", AtividadeDAO.getFuncAtividadeSelecionado(funcionarioProjetoId));
        return mv;
    }

    @RequestMapping("remove-funcionario-atividade-restrito")
    public ModelAndView removeFuncAtividadeSelecionado() {
        ModelAndView mv = new ModelAndView("modal/funcionarioAtividade");
        mv.addObject("funcAtividadeProjeto", null);
        return mv;
    }

    @RequestMapping(value = "salvar-atividade", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String salvarAtividade(String atividadeJson, String operacao) {

        try {
            Atividade atividade = new Gson().fromJson(atividadeJson, Atividade.class);

            HashMap<String, String> erros = new HashMap<String, String>();

            if (atividade.getNome().trim().length() == 0) {
                erros.put("erroAtividadeNome", "Informe um nome para a atividade!");
            }

            if (atividade.getDescricao().trim().length() == 0) {
                erros.put("erroAtividadeDescricao", "Informe uma descrição para a atividade!");
            }

            if (atividade.getTpprioridade().getId() == 0) {
                erros.put("erroTpPrioridade", "Selecione uma prioridade para a atividade!");
            }

            if (atividade.getSitatividade().getId() == 0) {
                erros.put("erroSitAtividade", "Selecione uma situação para a atividade!");
            }

            if (atividade.getTptempoByTptempoestimadoid().getId() == 0) {
                erros.put("erroTempoEstimado", "Selecione o tempo estimado de conclusção da atividade!");
            }

            if (atividade.getSitatividade().getId() == 3) {

                if (atividade.getTptempoByTptempoconclusaoid().getId() == 0) {
                    erros.put("erroTempoConclusao", "Selecione o tempo de conclusão!");
                }

                if (atividade.getDescconclusao().length() == 0) {
                    erros.put("erroDescricaoConclusao", "Informe a descricao da conclusao!");
                }
            }

            if (erros.isEmpty()) {

                if (operacao.equalsIgnoreCase("I")) {
                    atividade.setDtcriacao(new Date());
                } else {
                    atividade.setDtalteracao(new Date());
                }

                AtividadeDAO.salvarAtividade(atividade);
            }

            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();
            
            if(operacao.equalsIgnoreCase("U")){
                myObj.addProperty("isFuncionario", Boolean.TRUE);
            }

            myObj.addProperty("sucesso", erros.isEmpty());
            JsonElement objetoErrosEmJson = gson.toJsonTree(erros);
            myObj.add("erros", objetoErrosEmJson);

            return myObj.toString();

        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

}
