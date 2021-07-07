package QuestaoUm;

public class Main {

    public static void main(String[] args){
            AgendaEndereco agenda = new AgendaEndereco();

            Pessoa p1 = new Pessoa("Aurora Fátima Aragão",
                                "Avenida Belo Horizonte 907",
                                 "(69) 98931-2554");

            Pessoa p2 = new Pessoa("João Marcelo Erick Teixeira",
                                "Rua Euclides Nunes Machado 112",
                                 "(83) 98241-7004");


            Pessoa p3 = new Pessoa("Martin Vicente Benedito Barros",
                                "Avenida Itália 942",
                                 "(53) 99106-7968");


            agenda.inserir(p1);
            agenda.inserir(p2);
            agenda.inserir(p3);

            agenda.excluir(p2);


             System.out.println(agenda.consultar(p1) + "" + agenda.consultar(p2) + "" +agenda.consultar(p3));


    }

}
