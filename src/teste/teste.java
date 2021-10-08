package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.*;

class teste {
	ControleDados dados = new ControleDados();
	String[] dadosAnel = new String[8];
	String[] dadosCliente = new String[8];

	@Test
	void testeCadastro() {
		dadosAnel[0] = "0";
		dadosAnel[1] = "João";
		dadosAnel[2] = "1234";
		dadosAnel[3] = "Falange";
		dadosAnel[4] = "Dourado";
		dadosAnel[5] = "Aço";
		dadosAnel[6] = "65";
		dadosAnel[7] = "12";
		
		assertTrue(dados.inserirEditarAnel(dadosAnel));
		
	}
	
	@Test
	void testeExcluirAnel(){
		dadosAnel[0] = "0";
		dadosAnel[1] = "João";
		dadosAnel[2] = "1234";
		dadosAnel[3] = "Falange";
		dadosAnel[4] = "Dourado";
		dadosAnel[5] = "Aço";
		dadosAnel[6] = "65";
		dadosAnel[7] = "12";
		
		dados.inserirEditarAnel(dadosAnel);
		
		assertTrue(dados.removerAnel(0));
		
	}
	
	@Test
	void testeCadastroCliente() {
		dadosCliente[0] = "0";
		dadosCliente[1] = "Fuca";
		dadosCliente[2] = "098352617273";
		dadosCliente[3] = "Rio das Ostras";
		dadosCliente[4] = "23894234";
		dadosCliente[5] = "40028922";
		
		assertTrue(dados.inserirEditarCliente(dadosCliente));
		
	}
}
