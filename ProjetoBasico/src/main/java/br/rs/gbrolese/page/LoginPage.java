package br.rs.gbrolese.page;

import org.openqa.selenium.By;

import br.rs.gbrolese.core.BasePage;
import br.rs.gbrolese.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	public void entrar(){
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}
