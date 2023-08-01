package br.rs.gbrolese.page;

import br.rs.gbrolese.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	public void acessarMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	public void acessarResumo() {
		clicarLink("Resumo Mensal");
	}
}
