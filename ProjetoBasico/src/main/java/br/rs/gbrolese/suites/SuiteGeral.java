package br.rs.gbrolese.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.rs.gbrolese.tests.ContaSaldoTest;
import br.rs.gbrolese.tests.ContaTest;
import br.rs.gbrolese.tests.MovimentacaoTest;
import br.rs.gbrolese.tests.ResumoTest;

@RunWith(Suite.class)
@SuiteClasses ({
	ContaTest.class,
	MovimentacaoTest.class,
	ContaSaldoTest.class,
	ResumoTest.class
	
	
})

public class SuiteGeral {

}
