package br.univel.Thread;

import java.util.concurrent.Semaphore;

public class Fornalha_Singleton {
	//fazendo o singleton instanciar 2 vezes
	//private static final Fornalha_Singleton instancia = new Fornalha_Singleton();
	//dessa forma a VM vai controlar a instancia da thread, garante q so uma variavel vai ser instanciada
	//VM elege uma das thread para ser instanciada, VM sincroniza o tempo da variavel, as duas acessam a msm
	// locacao da variavel
	private static Fornalha_Singleton instancia;
	private static Semaphore semafaro = new Semaphore(1/*quantidade de locks permitido*/);
	private Boolean Emuso;
	
	private Fornalha_Singleton(final Boolean emUso){
		this.Emuso = emUso;
		
	}
	
	public static synchronized Fornalha_Singleton getInstancia(final Boolean emUso) {
		if (instancia == null) {
			System.out.println("Criando instancia singleton");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		instancia = new Fornalha_Singleton(emUso);
		}
		
		return instancia;
	}
	
	//nao e correto 2 getInstance para singleton
	public static Fornalha_Singleton getInstanciaSemafaro(final Boolean emUso){
		try {
			semafaro.acquire();//adiquira lock	
		} catch (InterruptedException e) {
		}
		
		if (instancia == null) {
			System.out.println("Criando instancia singleton");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		instancia = new Fornalha_Singleton(emUso);
		}
		
		semafaro.release();//libero o lock
		return instancia;
	}
}
