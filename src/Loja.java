public class Loja {
    private String nome;
    private int quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos; //novo atributo array de produto

    //Construtor com todos os atributos
    public Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;
        this.estoqueProdutos = new Produto[tamanhoEstoque]; //Inicializa el array con el tamanho informado
    }

    //Construtor com nome e quantidadeFuncionarios (salarioBase = -1)
    public Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data dataFundacao, int tamanhoEstoque) {
        this(nome, quantidadeFuncionarios, -1, endereco, dataFundacao, tamanhoEstoque);
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    //toString
    @Override
    public String toString() {
        String resultado =  "Loja: " + nome +
                "\nFuncionários: " + quantidadeFuncionarios +
                "\nSalário Base: R$ " + salarioBaseFuncionario +
                "\nEndereço: " + endereco +
                "\nData de Fundação: " + dataFundacao +
                "\nProdutos em Estoque: ";

        for (Produto p : estoqueProdutos) {
            if (p != null) {
                resultado += p + "\n";
            }
        }
        return resultado;
    }

    //Método gastosComSalario
    public double gastosComSalario() {
        if (salarioBaseFuncionario == -1) return -1;
        return quantidadeFuncionarios * salarioBaseFuncionario;
    }

    //Método tamanhoDaLoja
    public char tamanhoDaLoja() {
        if (quantidadeFuncionarios < 10) return 'P';
        if (quantidadeFuncionarios <= 30) return 'M';
        return 'G';
    }

    //Método imprimeProdutos
    public void imprimeProdutos() {
        for (Produto p : estoqueProdutos) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }

    //Método insereProduto
    public boolean insereProduto(Produto produto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] == null) {
                estoqueProdutos[i] = produto;
                return true;
            }
        }
        return false; //Nenhuma posição livre
    }

    //Método removeProduto
    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < estoqueProdutos.length; i++) {
            if (estoqueProdutos[i] != null && estoqueProdutos[i].getNome().equalsIgnoreCase(nomeProduto)) {
                estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }
}
