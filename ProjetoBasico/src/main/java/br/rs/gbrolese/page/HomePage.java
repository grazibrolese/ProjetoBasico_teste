package br.rs.gbrolese.page;

import br.rs.gbrolese.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) { 
	
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	
}
	}
