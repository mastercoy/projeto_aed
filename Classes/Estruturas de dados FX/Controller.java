import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

/**
 * Created by Nylo on 23/08/2016.
 */
public class Controller implements Initializable {

		//objetos
		public Pane panel;
		private No[] lista1 = new No[10];
		private Fila fila = new Fila();
		private No[] fila1 = new No[10];
		private Pilha pilha = new Pilha();
		private No[] pilha1 = new No[10];
		private Lista lista = new Lista();
		private int contPilha = 0;
		private int contFila = 0;
		private int contLista = 0;

		//Criando retangulos da pilha
		@FXML
		private Rectangle pilhar0;
		@FXML
		private Rectangle pilhar1;
		@FXML
		private Rectangle pilhar2;
		@FXML
		private Rectangle pilhar3;
		@FXML
		private Rectangle pilhar4;
		@FXML
		private Rectangle pilhar5;
		@FXML
		private Rectangle pilhar6;
		@FXML
		private Rectangle pilhar7;
		@FXML
		private Rectangle pilhar8;
		@FXML
		private Rectangle pilhar9;

		//Criando retangulos da fila
		@FXML
		private Rectangle filar0;
		@FXML
		private Rectangle filar1;
		@FXML
		private Rectangle filar2;
		@FXML
		private Rectangle filar3;
		@FXML
		private Rectangle filar4;
		@FXML
		private Rectangle filar5;
		@FXML
		private Rectangle filar6;
		@FXML
		private Rectangle filar7;
		@FXML
		private Rectangle filar8;
		@FXML
		private Rectangle filar9;

		//Criando retangulos da lista
		@FXML
		private Rectangle listar0;
		@FXML
		private Rectangle listar1;
		@FXML
		private Rectangle listar2;
		@FXML
		private Rectangle listar3;
		@FXML
		private Rectangle listar4;
		@FXML
		private Rectangle listar5;
		@FXML
		private Rectangle listar6;
		@FXML
		private Rectangle listar7;
		@FXML
		private Rectangle listar8;
		@FXML
		private Rectangle listar9;

		//Criando Labels da pilha
		@FXML
		private Label pilhalb0;
		@FXML
		private Label pilhalb1;
		@FXML
		private Label pilhalb2;
		@FXML
		private Label pilhalb3;
		@FXML
		private Label pilhalb4;
		@FXML
		private Label pilhalb5;
		@FXML
		private Label pilhalb6;
		@FXML
		private Label pilhalb7;
		@FXML
		private Label pilhalb8;
		@FXML
		private Label pilhalb9;

		//Criando Labels da Fila
		@FXML
		private Label filalb0;
		@FXML
		private Label filalb1;
		@FXML
		private Label filalb2;
		@FXML
		private Label filalb3;
		@FXML
		private Label filalb4;
		@FXML
		private Label filalb5;
		@FXML
		private Label filalb6;
		@FXML
		private Label filalb7;
		@FXML
		private Label filalb8;
		@FXML
		private Label filalb9;

		//Criando Labels da lista
		@FXML
		private Label listalb0;
		@FXML
		private Label listalb1;
		@FXML
		private Label listalb2;
		@FXML
		private Label listalb3;
		@FXML
		private Label listalb4;
		@FXML
		private Label listalb5;
		@FXML
		private Label listalb6;
		@FXML
		private Label listalb7;
		@FXML
		private Label listalb8;
		@FXML
		private Label listalb9;

		//botões pilha
		@FXML
		private Button btAddPilha;
		@FXML
		private Button btRemovePilha;
		@FXML
		private Button btResetPilha;

		//botões fila
		@FXML
		private Button btAddFila;
		@FXML
		private Button btRemoveFila;
		@FXML
		private Button btResetFila;

		//botões lista
		@FXML
		private Button btAddLista;
		@FXML
		private Button btAddPosLista;
		@FXML
		private Button btRemoveLista;
		@FXML
		private Button btResetaLista;
		@FXML
		private Button btDelPosLista;
		@FXML
		private Button btInsertionSortLista;
		@FXML
		private Button btSelectionSortLista;
		@FXML
		private Button btBubbleSortLista;

		//TextField
		@FXML
		private TextField txtAddPilha;
		@FXML
		private TextField txtAddFila;
		@FXML
		private TextField txtAddLista;
		@FXML
		private TextField txtRemoveElementoLista;
		@FXML
		private TextField txtAddPosLista;
		@FXML
		private TextField txtAddPosListaValor;
		@FXML
		private TextField txtDelPosLista;

		@FXML
		private Button sobre;
		@FXML
		private Button ajuda;

		//Criação dos diversos vetores de retangulos
		private Rectangle[] listRetanguloPilha() {
				Rectangle recPilha[] = new Rectangle[10];

				recPilha[0] = pilhar0;
				recPilha[1] = pilhar1;
				recPilha[2] = pilhar2;
				recPilha[3] = pilhar3;
				recPilha[4] = pilhar4;
				recPilha[5] = pilhar5;
				recPilha[6] = pilhar6;
				recPilha[7] = pilhar7;
				recPilha[8] = pilhar8;
				recPilha[9] = pilhar9;

				return recPilha;

		}

		private Rectangle[] listRetanguloFila() {
				Rectangle recFila[] = new Rectangle[10];

				recFila[0] = filar0;
				recFila[1] = filar1;
				recFila[2] = filar2;
				recFila[3] = filar3;
				recFila[4] = filar4;
				recFila[5] = filar5;
				recFila[6] = filar6;
				recFila[7] = filar7;
				recFila[8] = filar8;
				recFila[9] = filar9;

				return recFila;

		}

		private Rectangle[] listRetanguloLista() {
				Rectangle recLista[] = new Rectangle[10];

				recLista[0] = listar0;
				recLista[1] = listar1;
				recLista[2] = listar2;
				recLista[3] = listar3;
				recLista[4] = listar4;
				recLista[5] = listar5;
				recLista[6] = listar6;
				recLista[7] = listar7;
				recLista[8] = listar8;
				recLista[9] = listar9;

				return recLista;

		}

		//Criação dos diversos vetores de labels
		private Label[] listaLabelsPilha() {
				Label lblsPilha[] = new Label[10];

				lblsPilha[0] = pilhalb0;
				lblsPilha[1] = pilhalb1;
				lblsPilha[2] = pilhalb2;
				lblsPilha[3] = pilhalb3;
				lblsPilha[4] = pilhalb4;
				lblsPilha[5] = pilhalb5;
				lblsPilha[6] = pilhalb6;
				lblsPilha[7] = pilhalb7;
				lblsPilha[8] = pilhalb8;
				lblsPilha[9] = pilhalb9;

				return lblsPilha;
		}

		private Label[] listaLabelsFila() {
				Label lblsFila[] = new Label[10];

				lblsFila[0] = filalb0;
				lblsFila[1] = filalb1;
				lblsFila[2] = filalb2;
				lblsFila[3] = filalb3;
				lblsFila[4] = filalb4;
				lblsFila[5] = filalb5;
				lblsFila[6] = filalb6;
				lblsFila[7] = filalb7;
				lblsFila[8] = filalb8;
				lblsFila[9] = filalb9;

				return lblsFila;
		}

		private Label[] listaLabelsLista() {
				Label lblsLista[] = new Label[10];

				lblsLista[0] = listalb0;
				lblsLista[1] = listalb1;
				lblsLista[2] = listalb2;
				lblsLista[3] = listalb3;
				lblsLista[4] = listalb4;
				lblsLista[5] = listalb5;
				lblsLista[6] = listalb6;
				lblsLista[7] = listalb7;
				lblsLista[8] = listalb8;
				lblsLista[9] = listalb9;

				return lblsLista;
		}

		//Métodos da Pilha ---------------------------------------------------------------
		@FXML
		private void adicionarNoPilha(ActionEvent event) { //adiciona nó na pilha

				if (contPilha < 10) {
						try {
								pilha.push(Integer.parseInt(txtAddPilha.getText())); //da o push() usando como valor o numero no campo de texto
								pilha1 = pilha.pilhaParaVetor(pilha1, pilha.getTopo(), contPilha); //método insere um objeto num vetor de objetos, caso tenha espaço
								contPilha++;
						} catch (NumberFormatException nf) {
								JOptionPane.showMessageDialog(null, "Insira valor com formato correto");
						}

						for (int i = 0; i < 10; i++) { //verifica se determinada posição do vetor é diferente de nula, setando os retangulos e labels como visiveis
								if (pilha1[i] != null) {
										listRetanguloPilha()[i].setVisible(true);
										listaLabelsPilha()[i].setText(Integer.toString(pilha1[i].getInfo()));
										listaLabelsPilha()[i].setVisible(true);
								}
						}

				} else {
						JOptionPane.showMessageDialog(null, "Pilha cheia!");
				}
				txtAddPilha.clear(); //limpa o campo de texto
		}

		@FXML
		private void removeNoPilha(ActionEvent event) {  //remove no da pilha

				try {
						pilha.pop(); //desempilha na estrutura
						if (contPilha > 0) {
								contPilha--;

								pilha1[contPilha] = null; //transforma a posição de numero do contator em nula para setar o retangulo e labem como nao visiveis
								listRetanguloPilha()[contPilha].setVisible(false);
								listaLabelsPilha()[contPilha].setText(null);
								listaLabelsPilha()[contPilha].setVisible(false);
						}
				} catch (NullPointerException xx) {
						JOptionPane.showMessageDialog(null, "Pilha vazia!");
				}

		}

		@FXML
		public void resetPilha() {
				for (int i = 0; i < 10; i++) { //transforma todas as posições em nula e invisiveis todos os objetos na tela
						pilha1[i] = null;
						listRetanguloPilha()[i].setVisible(false);
						listaLabelsPilha()[i].setText(null);
						listaLabelsPilha()[i].setVisible(false);

				}
				txtAddPilha.clear();
				contPilha = 0;
		}
		//--------------------------------------------------------------------------------

		//Métodos da Fila ---------------------------------------------------------------
		@FXML
		private void adicionarNoFila(ActionEvent event) throws NumberFormatException {
				try {
						if (contFila < 10) {
								fila.enQueue(Integer.parseInt(txtAddFila.getText())); //enfileira o valor do campo de texto
								fila1 = fila.filaParaVetor(fila1, fila.getUltimo(), contFila); //insidere o objeto no vetor de objetos
								contFila++;
								txtAddFila.clear();

								for (int i = 0; i < 10; i++) { //confere quem é diferente de nulo e seta objetos na tela como visiveis
										if (fila1[i] != null) {
												listRetanguloFila()[i].setVisible(true);
												listaLabelsFila()[i].setText(Integer.toString(fila1[i].getInfo()));
												listaLabelsFila()[i].setVisible(true);
										}
								}

						} else {
								JOptionPane.showMessageDialog(null, "Fila cheia");
						}
				} catch (RuntimeException ignored) {
				}

		}

		@FXML
		private void removeNoFila(ActionEvent event) {  //remove no da pilha

				try {
						fila.deQueue(); //desenfileira

						if (contFila > 0) {
								for (int i = 1; i < 10; i++) {  //começa da segunda casa "[0][1]" ja que o método faz que
										fila1[i - 1] = fila1[i]; //a posição anterior recebe o valor da posição atual
										listaLabelsFila()[i - 1].setText(listaLabelsFila()[i].getText()); //clona-se o texto da posição atual para a posição anterior
								}

								if (contFila == 10) { //tratamento pois não tem uma 11º casa com valor pra passar pra 10º
										fila1[9] = null;
										contFila--;

								} else {
										fila1[contFila] = null;
										contFila--;
								}

								for (int i = 0; i < 10; i++) { //confere posições nulas para setar objetos como invisiveis
										if (fila1[i] == null) {
												listRetanguloFila()[i].setVisible(false);
												listaLabelsFila()[i].setText(null);
												listaLabelsFila()[i].setVisible(false);
										}
								}

						}

				} catch (NullPointerException xx) {
						JOptionPane.showMessageDialog(null, "Fila vazia!");
				}

		}

		@FXML
		public void resetFila() {
				//seta todas posições nulas assim como seus objetos na tela
				for (int i = 0; i < 10; i++) {
						fila1[i] = null;
						listRetanguloFila()[i].setVisible(false);
						listaLabelsFila()[i].setText(null);
						listaLabelsFila()[i].setVisible(false);
				}

				txtAddFila.clear();
				contFila = 0;

		}
		//--------------------------------------------------------------------------------

		//Métodos da Lista ---------------------------------------------------------------
		@FXML
		private void adicionarInicioLista(ActionEvent event) {

				if (contLista < 10) {

						try {
								lista.incluirInicio(Integer.parseInt(txtAddLista.getText())); //inclui no começo da lista o valor da caixa de texto
								lista1 = lista.listaParaVetor(lista1, lista.getInicio(), 0); //insere objeto no vetor de objetos
								contLista++;
								System.out.println("cont = " + contLista);

						} catch (NumberFormatException xx) {
								JOptionPane.showMessageDialog(null, "Insita valor com formato correto");
						}

						for (int i = 0; i < 10; i++) { //confere quem é diferente de nulo e seta objetos na tela como visiveis
								if (lista1[i] != null) {
										listRetanguloLista()[i].setVisible(true);
										listaLabelsLista()[i].setText(Integer.toString(lista1[i].getInfo()));
										listaLabelsLista()[i].setVisible(true);
								}
						}

				} else {
						JOptionPane.showMessageDialog(null, "Lista Cheia!");
				}
				txtAddLista.clear();
		}

		@FXML
		private void adicionarPosicaoLista(ActionEvent event) {
				int temp = Integer.parseInt(txtAddPosLista.getText()); // variável recebe o valor da caixa de texto Pos

				if (contLista < 9 && contLista > 0) { //condição caso a lista não esteja cheia nem vazia

						try {

								for (int i = contLista; i > temp - 1; i--) {
										lista1[i] = lista1[i - 1];
										listaLabelsFila()[i].setText(listaLabelsFila()[i - 1].getText());
								}

								lista.incluirPosicao(temp, Integer.parseInt(txtAddPosListaValor.getText()));
								lista1 = lista.listaParaVetor(lista1, lista.getInicio(), 0);
								contLista++;

						} catch (RuntimeException xx) {
								System.out.println("error3");
						}

						for (int i = 0; i < 10; i++) { //confere quem é diferente de nulo e seta objetos na tela como visiveis
								if (lista1[i] != null) {
										listRetanguloLista()[i].setVisible(true);
										listaLabelsLista()[i].setText(Integer.toString(lista1[i].getInfo()));
										listaLabelsLista()[i].setVisible(true);
								}
						}

						txtAddPosLista.clear(); //limpa campos de texto
						txtAddPosListaValor.clear();
						System.out.println("cont = " + contLista); //obs apagar

				} else {

						if (contLista == 0) { //condição lista vazia

								try {

										lista.incluirInicio(Integer.parseInt(txtAddPosListaValor.getText())); //inclui no começo da lista o valor da caixa de texto "valor"
										lista1 = lista.listaParaVetor(lista1, lista.getInicio(), 0); //insere objeto no vetor de objetos
										contLista++;

								} catch (RuntimeException xx) {
										System.out.println("error");
								}

								for (int i = 0; i < 10; i++) { //confere quem é diferente de nulo e seta objetos na tela como visiveis
										if (lista1[i] != null) {
												listRetanguloLista()[i].setVisible(true);
												listaLabelsLista()[i].setText(Integer.toString(lista1[i].getInfo()));
												listaLabelsLista()[i].setVisible(true);
										}
								}

						} else if (contLista == 9) { //condição uma a menos que cheia

								try {

										for (int i = 8; i > temp - 1; i--) {
												lista1[i] = lista1[i - 1];
												listaLabelsLista()[i].setText(listaLabelsLista()[i - 1].getText());
										}

										lista.incluirPosicao(temp, Integer.parseInt(txtAddPosListaValor.getText()));
										lista1 = lista.listaParaVetor(lista1, lista.getInicio(), 0);
										contLista++;

								} catch (RuntimeException xx) {
										System.out.println("error2");
								}

								for (int i = 0; i < 10; i++) { //confere quem é diferente de nulo e seta objetos na tela como visiveis
										if (lista1[i] != null) {
												listRetanguloLista()[i].setVisible(true);
												listaLabelsLista()[i].setText(Integer.toString(lista1[i].getInfo()));
												listaLabelsLista()[i].setVisible(true);
										}
								}

						} else {
								JOptionPane.showMessageDialog(null, "Lista cheia.");
						}

						txtAddPosLista.clear();
						txtAddPosListaValor.clear();
						System.out.println("cont = " + contLista);
				}
		}

		@FXML
		private void removerElementoLista(ActionEvent event) {

				try {

						if (contLista > 0 && contLista < 10) { //confere se vetor não está vazio nem cheio

								for (int i = 0; i < 10; i++) { //percorre todo o vetor
										if (lista1[i].getInfo() == Integer.parseInt(txtRemoveElementoLista.getText())) { //comparando valor em cada posição, com o valor inserido

												for (int j = i; j < contLista; j++) { //a partir de onde achar o valor
														listaLabelsLista()[j].setText(listaLabelsLista()[j + 1].getText());  //clona-se na label, o valor da posição a frente
														lista1[j] = lista1[j + 1]; //clona-se no vetor, o objeto da posição a frente
												}

												contLista--;
												break; //supondo que o valor seja achado antes de percorrer todo o vetor, ja rola o break. caso contrário, mesmo a comparação de valores
												//sendo verdadeira, ia continuar verificando até o final do vetor

										}
								}

						} else {
								if (contLista == 10) { //caso o vetor estiver cheio

										for (int i = 0; i < 10; i++) { //percorre todo o vetor
												if (lista1[i].getInfo() == Integer.parseInt(txtRemoveElementoLista.getText())) { //comparando valor em cada posição, com o valor inserido

														for (int j = i; j < 9; j++) {//a partir de onde achar o valor, até uma posição a menos no vetor //observar que não existe uma 11º posição para se passar o valor pra 10º, por isso ele percorre até uma antes do final
																listaLabelsLista()[j].setText(listaLabelsLista()[j + 1].getText());//clona-se na label, o valor da posição a frente
																lista1[j] = lista1[j + 1];//clona-se no vetor, o objeto da posição a frente
														}

														lista1[9] = null; //seta a ultima casa como nula. ela ja passou seu valor pra casa anterior
														contLista--;
														break; // mesmo motivo do break de cima

												}
										}

										if (contLista == 10) { //caso contator ainda seja 10, significa que nenhum valor foi retirado
												JOptionPane.showMessageDialog(null, "Valor inexistente na Lista");
										}

								} else {
										JOptionPane.showMessageDialog(null, "Lista vazia");
								}
						}

						lista.removerElemento(Integer.parseInt(txtRemoveElementoLista.getText()));  //método Remover da Lista, usando como valor o inteiro na caixa de texto
						txtRemoveElementoLista.clear();

						for (int i = 0; i < 10; i++) { //confere todas as posições, as quais sendo nulas terão seus objetos na tela setados como invisíveis
								if (lista1[i] == null) {
										listRetanguloLista()[i].setVisible(false);
										listaLabelsLista()[i].setText(null);
										listaLabelsLista()[i].setVisible(false);
								}
						}

				} catch (RuntimeException xx) {
						JOptionPane.showMessageDialog(null, "Valor inexistente na Lista");
						txtRemoveElementoLista.clear();
				}

		}

		@FXML
		private void removerPosLista(ActionEvent event) {

				if (contLista > 0) {

						int temp = Integer.parseInt(txtDelPosLista.getText());

						for (int i = temp - 1; i < 9; i++) {
								listaLabelsLista()[i].setText(listaLabelsLista()[i + 1].getText());
								lista1[i] = lista1[i + 1];
						}

						lista.removerPosicao(temp);
						lista1[contLista - 1] = null;
						txtDelPosLista.clear();
						contLista--;

						for (int i = 0; i < 10; i++) { //confere todas as posições, as quais sendo nulas terão seus objetos na tela setados como invisíveis
								if (lista1[i] == null) {
										listRetanguloLista()[i].setVisible(false);
										listaLabelsLista()[i].setText(null);
										listaLabelsLista()[i].setVisible(false);
								}
						}
				}

				System.out.println("cont = " + contLista);

		}

		@FXML
		public void resetaLista() { //obs verificar linhas desnecessárias

				if (contLista > 0) {

						lista = new Lista();
						lista1 = new No[10];

						try {

								for (int i = 0; i < 10; i++) {
												lista1[i] = null;
												listRetanguloLista()[i].setVisible(false);
												listaLabelsLista()[i].setText(null);
												listaLabelsLista()[i].setVisible(false);
								}

								contLista = 0;
								txtAddLista.clear();
								System.out.println("cont = " + contLista);

						} catch (RuntimeException xx) {
								System.out.println("error");
						}

				} else {
						JOptionPane.showMessageDialog(null, "Lista ja está vazia.");
				}


		}
		//--------------------------------------------------------------------------------

		//Métodos de ordenação
		@FXML //afazer espera na tela
		public void insertionSortLista() {
				lista.insertionSort(lista);
				int duracao = 1;

				for (int i = 0; i < 10; i++) { //atualiza os valores na tela
						if (lista1[i] != null) {
								int finalI = i;
								duracao = duracao + 1;
								Timeline timer = new Timeline(new KeyFrame(Duration.seconds(duracao), new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
												System.out.println("foi o i: "+finalI);
												listRetanguloLista()[finalI].setVisible(true);
												listaLabelsLista()[finalI].setText(Integer.toString(lista1[finalI].getInfo()));
												listaLabelsLista()[finalI].setVisible(true);
										}
								}));
								timer.play();
						}
				}
		}

		@FXML //afazer espera na tela
		public void selectionSortLista() {
				lista.selectionSort(lista);

				int duracao = 1;

				for (int i = 0; i < 10; i++) { //atualiza os valores na tela
						if (lista1[i] != null) {
								int finalI = i;
								duracao = duracao + 1;
								Timeline timer = new Timeline(new KeyFrame(Duration.seconds(duracao), new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
												System.out.println("foi o i: " + finalI);
												listRetanguloLista()[finalI].setVisible(true);
												listaLabelsLista()[finalI].setText(Integer.toString(lista1[finalI].getInfo()));
												listaLabelsLista()[finalI].setVisible(true);
										}
								}));
								timer.play();
						}
				}

		}

		@FXML //afazer espera na tela
		public void bubbleSortLista() {
				lista.bubbleSort();

				int duracao = 1;

				for (int i = 0; i < 10; i++) { //atualiza os valores na tela
						if (lista1[i] != null) {
								int finalI = i;
								duracao = duracao + 1;
								Timeline timer = new Timeline(new KeyFrame(Duration.seconds(duracao), new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
												System.out.println("foi o i: " + finalI);
												listRetanguloLista()[finalI].setVisible(true);
												listaLabelsLista()[finalI].setText(Integer.toString(lista1[finalI].getInfo()));
												listaLabelsLista()[finalI].setVisible(true);
										}
								}));
								timer.play();
						}
				}

		}

		//--------------------------------------------------------------------------------

		//funções dos campos de texto
		//acionadas quando o botão ENTER for pressionado após ter sido clicado no campo de texto (digitado valor ou não, aciona-se o método)
		@FXML
		private void onEnter() {
				adicionarNoPilha(null);
		}

		@FXML
		private void onEnter2() {
				adicionarNoFila(null);
		}

		@FXML
		private void onEnter3() {
				adicionarInicioLista(null);
		}

		@FXML
		private void onEnter4() {
				removerElementoLista(null);
		}

		@FXML
		private void onEnter5() {
				adicionarPosicaoLista(null);
		}

		@FXML
		private void onEnter6() {
				removerPosLista(null);
		}

		@FXML
		public void ajudaSobre() {

				JOptionPane.showMessageDialog(null, "Desenvolvedores : \n Nylo Pinto. e-mail: mastercoy@gmail.com \n Brunna Reis. e-mail: reiisbrunna@gmail.com");

		}

		@FXML
		public void ajudaManual() {

				Desktop desktop = Desktop.getDesktop();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Selecione o manual do usuário");
				fileChooser.setInitialDirectory(new File("."));

				// filtro de extensões
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("DOCx files (*.docx)", "*.docx");
				fileChooser.getExtensionFilters().add(extFilter);

				// Mostra open file dialog
				File file = fileChooser.showOpenDialog(null);
				if (file != null) {
						try {
								desktop.open(file);
						} catch (IOException e) {
								e.printStackTrace();
						}
				}

		}

		//padrão
		@Override
		public void initialize(URL location, ResourceBundle resources) {

		}

}
