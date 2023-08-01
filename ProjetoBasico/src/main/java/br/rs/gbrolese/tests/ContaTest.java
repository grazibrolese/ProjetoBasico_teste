package br.rs.gbrolese.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.rs.gbrolese.core.BaseTest;
import br.rs.gbrolese.page.ContasPage;
import br.rs.gbrolese.page.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta de Teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta 2");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarAlterarConta("Conta de Teste");
		contasPage.setNome("Conta de Teste 2");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaDuplicada() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta de Teste 2");
		contasPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemBloqueio());
	}
	
	@Test
	public void test4_RemoverConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarExcluirConta("Conta 2");
		Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
	}
}
