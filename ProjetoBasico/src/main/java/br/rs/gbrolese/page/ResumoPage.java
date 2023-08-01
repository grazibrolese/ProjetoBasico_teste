package br.rs.gbrolese.page;

import org.openqa.selenium.By;

import br.rs.gbrolese.core.BasePage;

public class ResumoPage extends BasePage {

	
		public void excluirMovimentacao(){
			clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
		}
		
		public String obterMensagemSucesso(){
			return obterTexto(By.xpath("//div[@class='alert alert-success']"));
		}
	}

