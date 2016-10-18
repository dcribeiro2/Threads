package br.univel.Thread;

public class Main {
     public static void main(String[] args) throws Exception {
	    System.out.println("Hello Word with thread");
	   final Thread thread = new Thread(new Runnable() {
		public void run() {
		Fornalha_Singleton.getInstancia(true);	//usando fornalha com Thread.
		//Fornalha não é obrigada a ser usada com thread
		}
	});
	   
	   final Thread thread2 = new Thread(new Runnable() {
		public void run() {
		    Fornalha_Singleton.getInstancia(false);	
		}
	});
	   
	    // final Contador contador = new Contador(10);
	    //final Contador contador2 = new Contador(10);
	    //contador.start();//aonde o java chama para iniciar o Run
	    //contador2.start();
	    thread.start();//executo pra cria o singleton
	    thread2.start();
	    thread2.join();//pra thread main espera a thread 2 termina 
	    System.out.println("Hello word finished");
}
}
