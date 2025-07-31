public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    //Construtor
    public Shopping(String nome, Endereco endereco, int quantidadeMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaxLojas];
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    //Método toString
    @Override
    public String toString() {
        String resultado = "Shopping: " + nome +
                "\nEndereço: " + endereco +
                "\nLojas:\n";

        for (Loja loja : lojas) {
            if (loja != null) {
                resultado += loja.getNome() + "\n";
            }
        }
        return resultado;
    }

    //Método insereLoja
    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false; //Nehuma posição livre
    }

    //Método removeLoja
    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equalsIgnoreCase(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    //Método quantidadeLojasPorTipo
    public int quantidadeLojasPorTipo(String tipo) {
        int contador = 0;
        for (Loja loja : lojas) {
            if (loja != null) {
                if (tipo.equalsIgnoreCase("Cosmético") && loja instanceof Cosmetico) contador++;
                else if (tipo.equalsIgnoreCase("Vestuário") && loja instanceof Vestuario) contador++;
                else if (tipo.equalsIgnoreCase("Bijuteria") && loja instanceof Bijuteria) contador++;
                else if (tipo.equalsIgnoreCase("Alimentação") && loja instanceof Alimentacao) contador++;
                else if (tipo.equalsIgnoreCase("Informática") && loja instanceof Informatica) contador++;
            }
        }
        if (contador == 0 &&
            !tipo.equalsIgnoreCase("Cosmético") &&
            !tipo.equalsIgnoreCase("Vestuário") &&
            !tipo.equalsIgnoreCase("Bijuteria") &&
            !tipo.equalsIgnoreCase("Alimentação") &&
            !tipo.equalsIgnoreCase("Informática")) {
            return -1;
        }
        return contador;
    }

    //Método lojaSeguroMaisCaro
    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCara = null;
        double maiorSeguro = 0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica info = (Informatica) loja;
                if (info.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = info.getSeguroEletronicos();
                    maisCara = info;
                }
            }
        }
        return maisCara;
    }




}
