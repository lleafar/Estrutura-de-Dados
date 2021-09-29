package tad.VetorOrdenado;
import utils.Estudante;

    public class VetorOrdenado{

        private Estudante[] estudantes = new Estudante[100000];

        private int totalDeEstudantes  = 0;


        public void adiciona(Estudante estudante){
            for(int i = 0; i < this.estudantes.length; i++){
                this.estudantes[this.totalDeEstudantes] = estudante;
                this.totalDeEstudantes++;
            }
        }

        public void apresentaEstudantes(){
            System.out.println(this.estudantes);
        }


        private boolean posicaoOcupada(int posicao) {
            return posicao >= 0 && posicao < this.totalDeEstudantes;
        }


        public void estudantesES(int posicao){
            int quantidade = 0;

            for(int i = posicao; i < this.totalDeEstudantes - 1; i++){
                if(estudantes[i].getCurso().equals("Engenharia de Software"));{
                    quantidade++;
                }
                    System.out.println(quantidade);
            }
        }


        public void removeMatricula(int posicao) {
            if (!this.posicaoOcupada(posicao)) {
                throw new IllegalArgumentException("Posicao inválida");
            }

            for (int i = posicao; i < this.totalDeEstudantes - 1; i++) {
                if(estudantes[i].getMatricula() <= 202060000){
                    this.estudantes[i] = this.estudantes[i + 1];
                }
                    this.totalDeEstudantes--;
                    System.out.println(this.estudantes[i]);
            }
        }
    }
