package pacote;

import javax.swing.JOptionPane;


public class ArvoresBinariasInt implements InterfaceArvoresBinariasInt {
	private NoArvoreInt noPai;
	private int tamanho;
	private String mensagem, titulo;
	private InterfaceArvoresBinariasInt arvore;

	public ArvoresBinariasInt() {
		noPai = null;
		tamanho = 0;
	}

	public void inserirNoCaractere() {
		char c;
		String s;
		mensagem = "Digite o caractere a ser inserido no Nó";

		do {
			s = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
		} while (s.isEmpty());

		c = s.charAt(0);

		NoArvoreInt novo = new NoArvoreInt(c, null, null);

		if (estaVazio())
			noPai = novo;
		else
			inserirNoFolha(noPai, novo);
		tamanho++;
	}

	public void inserirNoFolha(NoArvoreInt ultimoNo, NoArvoreInt no) {
		NoArvoreInt aux;
		if (no.getElemento() <= ultimoNo.getElemento()) {
			aux = ultimoNo.getEsquerda();
			if (aux != null)
				inserirNoFolha(aux, no);
			else
				ultimoNo.setEsquerda(no);
		} else {
			aux = ultimoNo.getDireita();
			if (aux != null)
				inserirNoFolha(aux, no);
			else
				ultimoNo.setDireita(no);
		}
	}

	public void mostrarAlturaArvore() {
		titulo = "Árvore Binária";
		if (estaVazio())
			mensagem = "Árvore Binária Vazia!";
		else
			mensagem = "Altura da árvore: " + obterAlturaArvore(noPai, 0);
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public void mostrarSeArvoreEhBinaria() {
		titulo = "Árvore Binária";
		if (estaVazio())
			mensagem = "Árvore Binária Vazia!";
		else {
			mensagem = "A árvore " + (ehArvoreBinaria(noPai) ? "é binária" : "não é binária");
		}
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public boolean ehArvoreBinaria(NoArvoreInt no) {
		if (no == null)
			return true;
		if (no.getEsquerda() == null && no.getDireita() == null)
			return true;
		if (no.getEsquerda() != null && no.getDireita() != null)
			return (ehArvoreBinaria(no.getEsquerda()) && ehArvoreBinaria(no.getDireita()));
		return false;
	}

	 public void mostrarOrdens() {
         mensagem = "Escolha o Percurso desejado:";
         titulo = "Árvore Binária";
         int opcaoOrdem;
         opcaoOrdem = JOptionPane.showOptionDialog(null, mensagem, titulo, 1, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Pré-Ordenado", "Ordenado", "Pós-Ordenado"}, null);
         switch(opcaoOrdem) {
             case 0: arvore.mostrarPreOrdenado();
                     break;
             case 1: arvore.mostrarOrdenado();
                     break;
             case 2: arvore.mostrarPosOrdenado();
                     break;
             default: break;
         }
	}

	public void mostrarPreOrdenado() {
		mensagem = "";
		titulo = "Percurso Pré-Ordenado";

		if (estaVazio())
			mensagem += "Árvore Binária Vazia!";
		else
			mostrarCaminho('p', noPai);
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
		ArvoresBinariasInt arvore = null;
	}
	
	public void mostrarOrdenado() {
		mensagem = "";
		titulo = "Percurso Ordenado";

		if (estaVazio())
			mensagem += "Árvore Binária Vazia!";
		else
			mostrarCaminho('o', noPai);
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public void mostrarPosOrdenado() {
		mensagem = "";
		titulo = "Percurso Pós-Ordenado";

		if (estaVazio())
			mensagem += "Árvore Binária Vazia!";
		else
			mostrarCaminho('P', noPai);
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public void mostrarCaminho(char tipo, NoArvoreInt no) {
		if (no != null) {
			if (tipo == 'p')
				mensagem += no.getElemento() + " ";
			mostrarCaminho(tipo, no.getEsquerda());
			if (tipo == 'o')
				mensagem += no.getElemento() + " ";
			mostrarCaminho(tipo, no.getDireita());
			if (tipo == 'P')
				mensagem += no.getElemento() + " ";
		}
	}

	public void mostrarArvore() {
		mensagem = "";
		titulo = "Árvore Binária";

		if (estaVazio())
			mensagem += "Árvore Binária Vazia!";
		else
			mostrarAltura(0, noPai);
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public void mostrarAltura(int nivel, NoArvoreInt no) {
		int i;

		if (no != null) {
			mostrarAltura(nivel + 1, no.getDireita());
			for (i = 0; i < nivel; i++)
				mensagem += "               ";
			mensagem += no.getElemento() + "\n";
			mostrarAltura(nivel + 1, no.getEsquerda());
		}
	}

	public int obterAlturaArvore(NoArvoreInt no, int l) {
		if (no == null)
			return l - 1;
		int a = obterAlturaArvore(no.getDireita(), l + 1);
		int b = obterAlturaArvore(no.getEsquerda(), l + 1);
		return java.lang.Math.max(a, b);
	}

	public void buscarNo() {
		char c;
		if (estaVazio())
			mensagem = "Árvore Binária Vazia!";
		else {
			mensagem = "Digite o Nó a ser localizado:";
			c = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE).charAt(0);
			mensagem = "O Nó '" + c;
			if (!estaNaArvore(c, noPai))
				mensagem += "' não";
			mensagem += "' se encontra na Árvore Binária";
		}
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public void atualizarNo() {
		char c;
		char novoC;

		if (estaVazio())
			mensagem = "Árvore Binária Vazia!";
		else {
			mensagem = "Digite o Nó a ser alterado:";
			c = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE).charAt(0);
			mensagem = "O Nó '" + c;
			if (!estaNaArvore(c, noPai))
				mensagem += "' não se encontra na";
			else {
				mensagem = "Digite um novo caractere para o nó:";
				novoC = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE).charAt(0);
				noPai = apagarNo(c, noPai);
				NoArvoreInt novo = new NoArvoreInt(novoC, null, null);
				tamanho--;
				if (estaVazio())
					noPai = novo;
				else
					inserirNoFolha(noPai, novo);
				mensagem = "O nó foi alterado com sucesso na";
				tamanho++;
			}
			mensagem += " Árvore Binária";
		}
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public boolean estaNaArvore(char c, NoArvoreInt no) {
		if (no != null) {
			if (c == no.getElemento())
				return true;
			else {
				if (c < no.getElemento()) {
					if (estaNaArvore(c, no.getEsquerda()))
						return true;
				} else {
					if (estaNaArvore(c, no.getDireita()))
						return true;
				}
			}
		}
		return false;
	}

	public void destruirNo() {
		char c;

		if (estaVazio())
			mensagem = "Árvore Binária Vazia!";
		else {
			mensagem = "Digite o Nó a ser eliminado:";
			c = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE).charAt(0);
			mensagem = "O Nó '" + c;
			if (!estaNaArvore(c, noPai))
				mensagem += "' não se encontra na";
			else {
				noPai = apagarNo(c, noPai);
				mensagem += "' foi eliminado da";
				tamanho--;
			}
			mensagem += " Árvore Binária";
		}
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public NoArvoreInt apagarNo(char c, NoArvoreInt no) {
		NoArvoreInt aux;

		if (no != null) {
			if (no.getElemento() == c) {
				if (no.getEsquerda() == no.getDireita())
					return null;
				else {
					if (no.getEsquerda() == null)
						return no.getDireita();
					else {
						if (no.getDireita() == null)
							return no.getEsquerda();
						else {
							aux = no.getDireita();
							while (aux.getEsquerda() != null)
								aux = aux.getEsquerda();
							aux.setEsquerda(no.getEsquerda());
							return no.getDireita();
						}
					}
				}
			}
			if (no.getElemento() < c)
				no.setDireita(apagarNo(c, no.getDireita()));
			else
				no.setEsquerda(apagarNo(c, no.getEsquerda()));
		}
		return no;
	}

	public boolean estaVazio() {
		return tamanho == 0;
	}

	@Override
	public void inserirNosInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentarNosIntPreOrdenados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentarNosIntOrdenados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentarNosIntPosOrdenados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentaPercursoInt(char cTipo, NoArvoreInt naNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentarArvoreInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentaNivelInt(char iNivel, NoArvoreInt naNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarNoInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estahNaArvore(char iNo, NoArvoreInt naNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarNoInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoArvoreInt excluiNoInt(char iNo, NoArvoreInt naNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ehVazia() {
		// TODO Auto-generated method stub
		return false;
	}
}