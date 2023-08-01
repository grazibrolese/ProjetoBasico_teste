package br.rs.gbrolese.tests;

import org.junit.Assert;
import org.junit.Test;

import br.rs.gbrolese.core.BaseTest;
import br.rs.gbrolese.page.HomePage;

public class ContaSaldoTest extends BaseTest {

	HomePage page = new HomePage();
	
	@Test
	public void testContaSaldo() {
		Assert.assertEquals("500.00", page.obterSaldoConta("Conta de Teste 2"));
	}
}
