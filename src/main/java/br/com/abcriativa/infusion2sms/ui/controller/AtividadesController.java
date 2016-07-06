package br.com.abcriativa.infusion2sms.ui.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.accordionpanel.AccordionPanel;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;

import br.com.abcriativa.infusion2sms.dominio.Atividade;
import br.com.abcriativa.infusion2sms.dominio.Evidencia;
import br.com.abcriativa.infusion2sms.dominio.MesComAtividadesDoProjeto;
import br.com.abcriativa.infusion2sms.dominio.Projeto;

@ManagedBean
@SessionScoped
public class AtividadesController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Projeto projetoSelecionado;

	private List<Projeto> projetos = new ArrayList<Projeto>();

	private Atividade atividadeSelecionada;

	private List<Atividade> atividades = new ArrayList<Atividade>();

	private MesComAtividadesDoProjeto mesComAtividadesDoProjetoSelecionado;

	private List<MesComAtividadesDoProjeto> mesesComAtividadesNoProjeto = new ArrayList<MesComAtividadesDoProjeto>();

	public AtividadesController() {

		// reuniao
		Atividade reuniao = new Atividade("Reuniao de inicio do projeto",
				"Reuniao", "10/05/2014", "Addson");

		Evidencia ata = new Evidencia("Ata de Reuniao 2334", "Ata de Reuniao",
				"14/05/2014", "/ProjetoGED/Suprimentos/evidencias/Maio2014/");
		Evidencia visao = new Evidencia("Documento de Visao de suprimentos",
				"Doc de Visao", "20/05/2014",
				"/ProjetoGED/Suprimentos/evidencias/Maio2014/");

		reuniao.adicionarEvidencia(ata);
		reuniao.adicionarEvidencia(visao);

		atividades.add(reuniao);

		// Projeto GED
		Projeto projetoGed = new Projeto();
		projetoGed.setDescricao("Projeto GED");
		projetoGed.setAtividades(atividades);
		this.projetos.add(projetoGed);

		// analise
		Atividade analise = new Atividade("Levantamento de Requisitos",
				"Reuniao", "10/05/2014", "Addson");

		Evidencia requisitos = new Evidencia("Ata de Reuniao 2334",
				"Ata de Reuniao", "14/05/2014",
				"/ProjetoGED/Suprimentos/evidencias/Maio2014/");
		Evidencia regrasDeNegocio = new Evidencia(
				"Documento de Visao de suprimentos", "Doc de Visao",
				"20/05/2014", "/ProjetoGED/Suprimentos/evidencias/Maio2014/");

		analise.adicionarEvidencia(requisitos);
		analise.adicionarEvidencia(regrasDeNegocio);

		atividades.add(analise);

		// Projeto SharePoint
		Projeto projetoSharePoint = new Projeto();
		projetoSharePoint.setDescricao("Projeto Share Point");
		projetoSharePoint.setAtividades(atividades);
		this.projetos.add(projetoSharePoint);

		inicializarMesesComAtividadesNoProjeto();

	}

	private void inicializarMesesComAtividadesNoProjeto() {

		this.mesesComAtividadesNoProjeto = new ArrayList<MesComAtividadesDoProjeto>();

		MesComAtividadesDoProjeto mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Jan/2014");
		mesComAtividades.setMesAno("Jan/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Fev/2014");
		mesComAtividades.setMesAno("Fev/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Mar/2014");
		mesComAtividades.setMesAno("Mar/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Abr/2014");
		mesComAtividades.setMesAno("Abr/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Mai/2014");
		mesComAtividades.setMesAno("Mai/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public MesComAtividadesDoProjeto getMesComAtividadesDoProjetoSelecionado() {
		return mesComAtividadesDoProjetoSelecionado;
	}

	public void setMesComAtividadesDoProjetoSelecionado(
			MesComAtividadesDoProjeto mesComAtividadesDoProjeto) {
		this.mesComAtividadesDoProjetoSelecionado = mesComAtividadesDoProjeto;
	}

	public void onTabChange(TabChangeEvent event) {
		System.out.println("onTabChange...");

		Atividade atividade = (Atividade) event.getData();
		this.atividadeSelecionada = atividade;
		// RequestContext.getCurrentInstance().update("id-accordion");

		((AccordionPanel) event.getComponent()).setActiveIndex("-1");

	}

	public List<MesComAtividadesDoProjeto> getMesesComAtividadesNoProjeto() {

		return this.mesesComAtividadesNoProjeto;
	}

	public void atualizarMesesComAtividadesNoProjeto(ValueChangeEvent e) {

		if (e.getNewValue() == null) {
			return;
		}

		String ProjetoSelecionado = (this.projetoSelecionado = (Projeto) e
				.getNewValue()).getDescricao();

		this.mesesComAtividadesNoProjeto = new ArrayList<MesComAtividadesDoProjeto>();

		MesComAtividadesDoProjeto mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Jan/2014");
		mesComAtividades.setMesAno("Jan/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		mesComAtividades = new MesComAtividadesDoProjeto();
		mesComAtividades.setDescricao("Fev/2014");
		mesComAtividades.setMesAno("Fev/2014");
		this.mesesComAtividadesNoProjeto.add(mesComAtividades);

		this.projetoSelecionado
				.adicionarMesesComAtividadesDoProjeto(this.mesesComAtividadesNoProjeto);

		// RequestContext context = RequestContext.getCurrentInstance();
		// RequestContext.getCurrentInstance().update("id-mesComAtividadesDoProjeto");

	}

	public void atualizarAtividadesNoMes(ValueChangeEvent e) {

		if (e.getNewValue() == null) {
			return;
		}

		String mesSelecionado = (this.mesComAtividadesDoProjetoSelecionado = (MesComAtividadesDoProjeto) e
				.getNewValue()).getMesAno();

		atividades = new ArrayList<Atividade>();

		// analise
		Atividade analise = new Atividade("Levantamento de Requisitos",
				"Reuniao", "10/05/2014", "Addson");

		Evidencia requisitos = new Evidencia("Ata de Reuniao 2334",
				"Ata de Reuniao", "14/05/2014",
				"/ProjetoGED/Suprimentos/evidencias/Maio2014/");
		Evidencia regrasDeNegocio = new Evidencia(
				"Documento de Visao de suprimentos", "Doc de Visao",
				"20/05/2014", "/ProjetoGED/Suprimentos/evidencias/Maio2014/");

		analise.adicionarEvidencia(requisitos);
		analise.adicionarEvidencia(regrasDeNegocio);

		atividades.add(analise);

	}

	public void novoProjeto() {

//		String teste = (String) actionEvent.getComponent()
//				.getAttributes().get("teste");

	}
}
