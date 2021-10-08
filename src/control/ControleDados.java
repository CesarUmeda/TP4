package control;

import modelo.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ControleDados {
	
private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	//===============================================//
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	//===============================================//
	//================== PRODUTOS ===================//
	//===============================================//
	
	public Anel[] getAnel() {
		return this.d.getAnel();
	}
	
	public int getQtdAnel() {
		return this.d.getQtdAnel();
	}
	
	//===============================================//
	
	public Brinco[] getBrinco() {
		return this.d.getBrinco();
	}
	
	public int getQtdBrinco() {
		return this.d.getQtdBrinco();
	}
	
	//===============================================//
	
	public Colar[] getColar() {
		return this.d.getColar();
	}
	
	public int getQtdColar() {
		return this.d.getQtdColar();
	}
	
	//===============================================//
	
	public Pulseira[] getPulseira() {
		return this.d.getPulseira();
	}
	
	public int getQtdPulseira() {
		return this.d.getQtdPulseira();
	}
	
	//===============================================//
	//=================== PESSOA ====================//
	//===============================================//
	
	public Cliente[] getCliente() {
		return this.d.getCliente();
	}
	
	public int getQtdClientes() {
		return this.d.getQtdClientes();
	}
	
	//===============================================//
	
	public Vendedor[] getVendedor() {
		return this.d.getVendedor();
	}
	
	public int getQtdVendedores() {
		return this.d.getQtdVendedores();
	}
	
	//===============================================//
	//==================== VENDA ====================//
	//===============================================//
	
	public Venda[] getVenda() {
		return this.d.getVenda();
	}
	
	public int getQtdVenda() {
		return this.d.getQtdVenda();
	}
	
	//===============================================//
	//=============== CRUD PRODUTOS =================//
	//===============================================//
	
	/**
	 * Cadastra e Edita dados do tipo Anel
	 * @param dadosAnel String que recebe dados e confere se são do tipo correto de acordo com Anel.
	 * @return Dados do tipo Anel na lista de cadastrados.
	 */
	public boolean inserirEditarAnel(String[] dadosAnel) {
		if(!dadosAnel[6].matches("[0-9]+") || !dadosAnel[7].matches("[0-9]+")) {
			return false;
		} else {
				Anel a = new Anel(dadosAnel[1], dadosAnel[2], dadosAnel[3], dadosAnel[4], dadosAnel[5], Double.parseDouble(dadosAnel[6]), Integer.parseInt(dadosAnel[7]));
				d.inserirEditarAnel(a, Integer.parseInt(dadosAnel[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Anel da lista de Anel.
	 * @param i Posição na lista de Anel.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerAnel(int i) {
		
		String anelRemovido = d.getAnel()[i].getNomeProd();
		
		if(i == (d.getQtdAnel() - 1)) { // O produto a ser removido está no final do array
			d.setQtdAnel(d.getQtdAnel() - 1);
			d.getAnel()[d.getQtdAnel()] = null;
			return true;
		} else { // o produto a ser removido está no meio do array
			int cont = 0;
			while(d.getAnel()[cont].getNomeProd().compareTo(anelRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQtdAnel() - 1; j++) {
				d.getAnel()[j] = null;
				d.getAnel()[j] = d.getAnel()[j+1];
			}
			d.getAnel()[d.getQtdAnel()] = null;
			d.setQtdAnel(d.getQtdAnel() - 1);
			return true;
		}
	}
	
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Brinco.
	 * @param dadosBrinco String que recebe dados e confere se são do tipo correto de acordo com Brinco.
	 * @return Dados do tipo Brinco na lista de cadastrados.
	 */
	public boolean inserirEditarBrinco(String[] dadosBrinco) {
		if(!dadosBrinco[6].matches("[0-9]+")) {
			return false;
		} else {
				Brinco b = new Brinco(dadosBrinco[1], dadosBrinco[2], dadosBrinco[3], dadosBrinco[4], dadosBrinco[5], Double.parseDouble(dadosBrinco[6]));
				d.inserirEditarBrinco(b, Integer.parseInt(dadosBrinco[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Brinco da lista de Brinco.
	 * @param i Posição na lista de Brinco.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerBrinco(int i) {
		
		String brincoRemovido = d.getBrinco()[i].getNomeProd();
		
		if(i == (d.getQtdBrinco() - 1)) { 
			d.setQtdBrinco(d.getQtdBrinco() - 1);
			d.getBrinco()[d.getQtdBrinco()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getBrinco()[cont].getNomeProd().compareTo(brincoRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdBrinco() - 1; j++) {
				d.getBrinco()[j] = null;
				d.getBrinco()[j] = d.getBrinco()[j+1];
			}
			d.getBrinco()[d.getQtdBrinco()] = null;
			d.setQtdBrinco(d.getQtdBrinco() - 1);
			return true;
		}
	}
	
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Colar.
	 * @param dadosColar String que recebe dados e confere se são do tipo correto de acordo com Colar.
	 * @return	Dados do tipo Brinco na lista de cadastrados.
	 */
	public boolean inserirEditarColar(String[] dadosColar) {
		if(!dadosColar[6].matches("[0-9]+") || !dadosColar[7].matches("[0-9]+")) {
			return false;
		} else {
				Colar c = new Colar(dadosColar[1], dadosColar[2], dadosColar[3], dadosColar[4], dadosColar[5], Double.parseDouble(dadosColar[6]), Integer.parseInt(dadosColar[7]));
				d.inserirEditarColar(c, Integer.parseInt(dadosColar[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Colar da lista de Colar.
	 * @param i Posição na lista de Colar.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerColar(int i) {
		
		String colarRemovido = d.getColar()[i].getNomeProd();
		
		if(i == (d.getQtdColar() - 1)) { 
			d.setQtdColar(d.getQtdColar() - 1);
			d.getColar()[d.getQtdColar()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getColar()[cont].getNomeProd().compareTo(colarRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdColar() - 1; j++) {
				d.getColar()[j] = null;
				d.getColar()[j] = d.getColar()[j+1];
			}
			d.getColar()[d.getQtdColar()] = null;
			d.setQtdColar(d.getQtdColar() - 1);
			return true;
		}
	}
	
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Pulseira.
	 * @param dadosPulseira String que recebe dados e confere se são do tipo correto de acordo com Pulseira.
	 * @return Dados do tipo Pulseira na lista de cadastrados.
	 */
	public boolean inserirEditarPulseira(String[] dadosPulseira) {
		if(!dadosPulseira[6].matches("[0-9]+") || !dadosPulseira[7].matches("[0-9]+")) {
			return false;
		} else {
				Pulseira p = new Pulseira(dadosPulseira[1], dadosPulseira[2], dadosPulseira[3], dadosPulseira[4], dadosPulseira[5], Double.parseDouble(dadosPulseira[6]), Integer.parseInt(dadosPulseira[7]));
				d.inserirEditarPulseira(p, Integer.parseInt(dadosPulseira[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Pulseira da lista de Pulseira.
	 * @param i Posição na lista de Colar.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerPulseira(int i) {
		
		String pulseiraRemovido = d.getPulseira()[i].getNomeProd();
		
		if(i == (d.getQtdPulseira() - 1)) { 
			d.setQtdPulseira(d.getQtdPulseira() - 1);
			d.getPulseira()[d.getQtdPulseira()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getPulseira()[cont].getNomeProd().compareTo(pulseiraRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdPulseira() - 1; j++) {
				d.getPulseira()[j] = null;
				d.getPulseira()[j] = d.getPulseira()[j+1];
			}
			d.getPulseira()[d.getQtdPulseira()] = null;
			d.setQtdPulseira(d.getQtdPulseira() - 1);
			return true;
		}
	}
	
	//===============================================//
	//================ CRUD PESSOA ==================//
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Cliente.
	 * @param dadosCliente String que recebe dados e confere se são do tipo correto de acordo com Cliente.
	 * @return Dados do tipo Cliente na lista de cadastrados.
	 */
	public boolean inserirEditarCliente(String[] dadosCliente) {
		if(!dadosCliente[5].matches("[0-9]+")) {
			return false;
		} else {
				Cliente cli = new Cliente(dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4], new Telefone(Integer.parseInt(dadosCliente[5]), 0));
				d.inserirEditarCliente(cli, Integer.parseInt(dadosCliente[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Cliente da lista de Cliente.
	 * @param i Posição na lista de Cliente.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerCliente(int i) {
		
		String clienteRemovido = d.getCliente()[i].getNome();
		
		if(i == (d.getQtdClientes() - 1)) { 
			d.setQtdClientes(d.getQtdClientes() - 1);
			d.getCliente()[d.getQtdClientes()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getCliente()[cont].getNome().compareTo(clienteRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdClientes() - 1; j++) {
				d.getCliente()[j] = null;
				d.getCliente()[j] = d.getCliente()[j+1];
			}
			d.getCliente()[d.getQtdClientes()] = null;
			d.setQtdClientes(d.getQtdClientes() - 1);
			return true;
		}
	}
	
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Vendedor.
	 * @param dadosVendedor String que recebe dados e confere se são do tipo correto de acordo com Vendedor.
	 * @return Dados do tipo Cliente na lista de cadastrados.
	 */
	public boolean inserirEditarVendedor(String[] dadosVendedor) {
		if(!dadosVendedor[5].matches("[0-9]+") || !dadosVendedor[7].matches("[0-9]+")) {
			return false;
		} else {
				Vendedor v = new Vendedor(dadosVendedor[1], dadosVendedor[2], dadosVendedor[3], dadosVendedor[4], new Telefone(Integer.parseInt(dadosVendedor[5]), 0), dadosVendedor[6], Double.parseDouble(dadosVendedor[7]));
				d.inserirEditarVendedor(v, Integer.parseInt(dadosVendedor[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Vendedor da lista de Vendedor.
	 * @param i Posição na lista de Vendedor.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */ 
	public boolean removerVendedor(int i) {
		
		String vendedorRemovido = d.getVendedor()[i].getNome();
		
		if(i == (d.getQtdVendedores() - 1)) { 
			d.setQtdVendedores(d.getQtdVendedores() - 1);
			d.getVendedor()[d.getQtdVendedores()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getVendedor()[cont].getNome().compareTo(vendedorRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdVendedores() - 1; j++) {
				d.getVendedor()[j] = null;
				d.getVendedor()[j] = d.getVendedor()[j+1];
			}
			d.getVendedor()[d.getQtdVendedores()] = null;
			d.setQtdVendedores(d.getQtdVendedores() - 1);
			return true;
		}
	}
	
	//===============================================//
	//================ CRUD VENDA ===================//
	//===============================================//
	
	/**
	 * Cadastra e edita dados do tipo Venda.
	 * @param dadosVenda String que recebe dados e confere se são do tipo correto de acordo com Venda.
	 * @return Dados do tipo Venda na lista de cadastrados.
	 */
	public boolean inserirEditarVenda(String[] dadosVenda) {
		SimpleDateFormat sdfmt1 = new SimpleDateFormat();
		if(!dadosVenda[6].matches("[0-9]+")) {
			return false;
		} else {
				Venda vd = new Venda(dadosVenda[1], dadosVenda[2], dadosVenda[3], dadosVenda[4], new SimpleDateFormat(dadosVenda[5]), Double.parseDouble(dadosVenda[6]));
				d.inserirEditarVenda(vd, Integer.parseInt(dadosVenda[0]));
				return true;
		}
	}
	
	/**
	 * Remove dados do tipo Venda da lista de Venda.
	 * @param i Posição na lista de Venda.
	 * @return True ou False indicando se a exclusão foi um sucesso ou não.
	 */
	public boolean removerVenda(int i) {
		
		String vendaRemovido = d.getVenda()[i].getNomeProd();
		
		if(i == (d.getQtdVenda() - 1)) { 
			d.setQtdVenda(d.getQtdVenda() - 1);
			d.getVenda()[d.getQtdVenda()] = null;
			return true;
		} else { 
			int cont = 0;
			while(d.getVenda()[cont].getNomeProd().compareTo(vendaRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdVenda() - 1; j++) {
				d.getVenda()[j] = null;
				d.getVenda()[j] = d.getVenda()[j+1];
			}
			d.getVenda()[d.getQtdVenda()] = null;
			d.setQtdVenda(d.getQtdVenda() - 1);
			return true;
		}
	}
}
