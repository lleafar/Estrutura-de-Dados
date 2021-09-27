package lib;

public interface IListaEncadeada<T> {

        public void adicionarInicio(T dado);

        public void adicionar(T dado);

        public void remover(T dado);

        public String exibirTodos();

        public T retornaPrimeiro();

        public T retornaUltimo();

        public T proximo(T dado);

        public int tamanho();

        public T buscar(int indice);
}
