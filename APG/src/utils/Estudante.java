package utils;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 * Classe utils.Estudante que possui os atributos matricula e curso gerados aleat�riamente.
 * @author Aline Vieira de Melo 
 * @Reviewed by Williamson Silva
 */
public class Estudante implements Comparable<Estudante>{
    private int matricula;
    private String curso;
	
    private static int nEstudantes = 0;
	private static Random geradorMatricula = new Random();
	private static Random geradorCurso = new Random();

    public Estudante(){
		geraMatricula();
		geraCurso();
    }
	
	/**
	 * Gera o n�mero de matricula de forma aleat�ria
	 */ 
	private void geraMatricula(){
		if(nEstudantes%2==0)
			this.matricula = 202050000 - geradorMatricula.nextInt(50000);
		else
			this.matricula = 202050000 + geradorMatricula.nextInt(50000);
		nEstudantes++;
	}
	
	/**
	 * Gera o curso aleatoriamente
	 */
	private void geraCurso(){
		int c = geradorCurso.nextInt(7);
		switch(c){
			case 0: this.curso = "Ciencia da Computacao"; break;
			case 1: this.curso = "Engenharia Agricola"; break;
			case 2: this.curso = "Engenharia Civil"; break;
			case 3: this.curso = "Engenharia de Software"; break;
			case 4: this.curso = "Engenharia de Telecomunicacoes"; break;
			case 5: this.curso = "Engenharia Eletrica"; break;
			case 6: this.curso = "Engenharia Mecanica"; break;
			default: new Exception("ERRO NA GERA��O DO CURSO");
		}
	}

    /**
     * @return o curso
     */
    public String getCurso() {
		return curso;
    }

    /**
     * @return o n�mero de matricula
     */
    public int getMatricula() {
        return matricula;
    }

	/**
	 * @return True se o curso � Engenharia de Software e False caso contr�rio
	 */
	public boolean isCursoES(){ 
		return (curso.equalsIgnoreCase("Engenharia de Software"));
	}
    
    /**
     * Compara se a matricula do utils.Estudante informado por par�metro com a matricula deste estudante.
     * @param e utils.Estudante a ser comparado
     * @return 1 se a matricula deste estudante � maior que a do estudante passado por par�metro, 0 se � igual e -1 se for menor.
     */
    @Override
    public int compareTo(Estudante e) {
       if (this.matricula > e.getMatricula()) return 1;
	   else if (this.matricula < e.getMatricula()) return -1;
	   else return 0;
    }
    
    @Override
    public String toString(){
        return "utils.Estudante matricula: "+ this.matricula + " curso: "+ this.curso;
    }
	
}