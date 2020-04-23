package pacote;

public class NoArvoreInt {
	private char elemento;
	private NoArvoreInt noEsquerdo;
	private NoArvoreInt noDireito;

	public NoArvoreInt() {
		elemento = 0;
		noEsquerdo = null;
		noDireito = null;
	}

	public NoArvoreInt(char e, NoArvoreInt newLeft, NoArvoreInt newRight) {
		elemento = e;
		noEsquerdo = newLeft;
		noDireito = newRight;
	}

	void setElemento(char c) {
		elemento = c;
	}

	void setEsquerda(NoArvoreInt newLeft) {
		noEsquerdo = newLeft;
	}

	void setDireita(NoArvoreInt newRight) {
		noDireito = newRight;
	}

	char getElemento() {
		return elemento;
	}

	NoArvoreInt getEsquerda() {
		return noEsquerdo;
	}

	NoArvoreInt getDireita() {
		return noDireito;
	}
}