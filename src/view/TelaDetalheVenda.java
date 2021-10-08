package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*;

public class TelaDetalheVenda implements ActionListener {

	private JFrame janela;
	private JLabel labelNomeProd = new JLabel("Nome do Produto: ");
	private JTextField valorNomeProd;
	private JLabel labelCodigoProd = new JLabel("Codigo Produto: ");
	private JTextField valorCodigoProd;
	private JLabel labelCodigoVenda = new JLabel("Codigo de Venda: ");
	private JTextField valorCodigoVenda;
	private JLabel labelNomeVendedor = new JLabel("Nome Vendedor: ");
	private JTextField valorNomeVendedor;
	private JLabel labelData = new JLabel("Data de Venda: ");
	private JTextField valorData;
	private JLabel labelValor = new JLabel("Valor: ");
	private JTextField valorValor;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	/**
	 * Apresenta ao usuário a tela de cadastro de venda ou destalhes sobre os dados aleatórios gerados em modelo ou 
	 * posteriomente cadastrados.
	 * @param op Opções que o usuário escolher.
	 * 1 - Cadastro de Venda, realiza o método de cadastro de Venda.
	 * 2 - Detalhe de Venda, mostra na tela a lista de Venda gerada pelo JList. 
	 * @param d Dados gerados em Dados e Cadastrados em ControleDados.
	 * @param tV Tela Venda.
	 * @param pos Posição do dado em Venda.
	 */
	public void inserirEditar(int op, ControleDados d, 
			TelaVenda tV, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de Venda";
		if (op == 2) s = "Detalhe Venda";
		
		janela = new JFrame(s);

		//Mostra dados da venda clicada
		if (op == 2) {
			valorNomeProd = new JTextField(dados.getVenda()[pos].getNomeProd(), 200);
			valorCodigoProd = new JTextField(dados.getVenda()[pos].getCodigoProd(), 200);
			valorCodigoVenda = new JTextField(dados.getVenda()[pos].getCodigoVenda(),200);
			valorNomeVendedor = new JTextField(dados.getVenda()[pos].getCodigoVenda(), 200);
			valorData = new JTextField(String.valueOf(dados.getVenda()[pos].getData().getDateFormatSymbols()), 200);
			valorValor = new JTextField(String.valueOf(dados.getVenda()[pos].getValor()), 200);

		} else { //Não preenche com dados

			valorNomeProd = new JTextField(200);
			valorCodigoProd = new JTextField(200);
			valorCodigoVenda = new JTextField(200);
			valorNomeVendedor = new JTextField(200);
			valorData = new JTextField(200);
			valorValor = new JTextField(200);

			botaoSalvar.setBounds(245, 240, 115, 30);
		}

		labelNomeProd.setBounds(30, 20, 150, 25);
		valorNomeProd.setBounds(180, 20, 180, 25);
		labelCodigoProd.setBounds(30, 50, 150, 25);
		valorCodigoProd.setBounds(180, 50, 180, 25);
		labelCodigoVenda.setBounds(30, 80, 180, 25);
		valorCodigoVenda.setBounds(180, 80, 180, 25);		
		labelNomeVendedor.setBounds(30, 110, 150, 25);
		valorNomeVendedor.setBounds(180, 110, 180, 25);
		labelData.setBounds(30, 140, 150, 25);
		valorData.setBounds(180, 140, 180, 25);
		labelValor.setBounds(30, 170, 150, 25);
		valorValor.setBounds(180, 170, 180, 25);

		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, 240, 115, 30);
			botaoExcluir.setBounds(245, 240, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNomeProd);
		this.janela.add(valorNomeProd);
		this.janela.add(labelCodigoProd);
		this.janela.add(valorCodigoProd);
		this.janela.add(labelCodigoVenda);
		this.janela.add(valorCodigoVenda);
		this.janela.add(labelNomeVendedor);
		this.janela.add(valorNomeVendedor);
		this.janela.add(labelData);
		this.janela.add(valorData);
		this.janela.add(labelValor);
		this.janela.add(valorValor);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 350);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de nova venda
					novoDado[0] = Integer.toString(dados.getQtdVenda());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNomeProd.getText();
				novoDado[2] =  valorCodigoProd.getText();
				novoDado[3] =  valorCodigoVenda.getText();
				novoDado[4] =  valorNomeVendedor.getText();
				novoDado[5] =  valorData.getText();
				novoDado[6] =  valorValor.getText();
				
				if (opcao == 1) {
					novoDado[1] =  valorNomeProd.getText();
					dados.inserirEditarVenda(novoDado);
				
					novoDado[2] =  valorCodigoProd.getText();
					dados.inserirEditarVenda(novoDado);
					
					novoDado[3] =  valorCodigoVenda.getText();
					dados.inserirEditarVenda(novoDado);
					
					novoDado[4] =  valorNomeVendedor.getText();
					dados.inserirEditarVenda(novoDado);
					
					novoDado[5] =  valorData.getText();
					dados.inserirEditarVenda(novoDado);
					
					novoDado[6] =  valorValor.getText();
					dados.inserirEditarVenda(novoDado);
					
				}
				
				if(res = true) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 2) {//exclui venda
				res = dados.removerVenda(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoVenda(); 
			}
		}
	}

	/**
	 * Janela de mensagens caso sucesso ou falha na execução de algum método, seja em cadastro, remoção, etc.
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n ", null, JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoVenda() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n ", null, JOptionPane.ERROR_MESSAGE);
	}
}