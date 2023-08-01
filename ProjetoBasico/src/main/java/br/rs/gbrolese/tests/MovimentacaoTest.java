package br.rs.gbrolese.tests;
import static br.rs.gbrolese.utils.DataUtils.obterDataFormatada;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.rs.gbrolese.core.BaseTest;
import br.rs.gbrolese.page.ContasPage;
import br.rs.gbrolese.page.MenuPage;
import br.rs.gbrolese.page.MovimentacaoPage;
import br.rs.gbrolese.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	ContasPage contasPage = new ContasPage();
	
	@Test	
	public void test2_InserirMovimentacao() {
		menuPage.acessarMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentacao do teste");
		movPage.setInteressado("qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta de Teste 2");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
		
	}
	@Test
	public void test1_CamposObrigatorios() {
		menuPage.acessarMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3_MovimentacaoFutura() {
		menuPage.acessarMovimentacao();
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentacao do teste");
		movPage.setInteressado("qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta de Teste 2");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.obterMensagemErro());
		
	}
	@Test
	public void test4_RemoverContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta de Teste 2");
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemBloqueio());
	}
	
	}
