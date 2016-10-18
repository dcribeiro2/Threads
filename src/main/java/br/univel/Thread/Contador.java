package br.univel.Thread;

public class Contador extends Thread {
   
	private final Integer contarAte;
	
	public Contador(final Integer contarAte){
		this.contarAte = contarAte;
	}
	
	public void contar(){
		Integer contado = 0;
		while (contado <this.contarAte) {
			System.out.println(String.format("Thread: %s ->Numero atual : %d"
					,Thread.currentThread().getName(), contado));//indentificando a thread q esta fazendo a contagem
			contado++;
			
			try {
				Thread.currentThread().sleep(1000);//fazendo a thread demorar 1 segundo para mostrar o numero
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public void run() {//executa, é o ponto de partida das threads
		super.run();
		this.contar();
	}
}
