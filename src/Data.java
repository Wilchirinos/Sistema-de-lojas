public class Data {
    private int dia;
    private int mes;
    private int ano;

    //Construtor com validação
    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida! Usando data padrão: 1/1/2000");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    //Método para validar a data (considera meses e ano bissexto)
    private boolean validarData(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            return false;
        }

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //Ajuste para fevereiro em ano bissexto
        if (mes == 2 && verificaAnoBissexto(ano)) {
            diasPorMes[1] = 29;
        }

        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    //Verifica se o ano é bissexto (versão com parâmetro)
    public boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano %400 == 0);
    }

    //Verifica se o ano atual do objeto é bissexto
    public boolean verificaAnoBissexto() {
        return verificaAnoBissexto(this.ano);
    }

    //Getters e Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    //toString para imprimir data formatada
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
