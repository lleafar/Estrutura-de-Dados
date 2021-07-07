package QuestaoUm;

import java.util.ArrayList;
import java.util.List;

public class AgendaEndereco implements IAgenda {
    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public void inserir(Object obj) {
        pessoas.add((Pessoa)obj);
    }

    @Override
    public String consultar(Object obj) {
        for (Pessoa p: pessoas){
            if(p.equals((Pessoa)obj)){
                return p.toString();
            }
        }

        return "\nContato inexistente!\n";
    }

    @Override
    public void excluir(Object obj) {
        pessoas.remove((Pessoa)obj);
    }

}
