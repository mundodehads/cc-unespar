abstract class ContaBancaria extends PessoaFisica {
 
       public String agencia;
       public String conta;
       protected double saldo;
       private int numerocartao;
       private String validade;
       private int codseguranca;
       
    abstract void Juros ();

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumerocartao() {
        return numerocartao;
    }

    public void setNumerocartao(int numerocartao) {
        this.numerocartao = numerocartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCodseguranca() {
        return codseguranca;
    }

    public void setCodseguranca(int codseguranca) {
        this.codseguranca = codseguranca;
    }

    
       
    public void Deposito (int x) {
        this.saldo = saldo + x;
    }
    
    public void Saque (int x) {
        if ( x < saldo) {
            this.saldo = saldo - x;
        } else {
            System.out.println("Valor de Saque maior que o Saldo !");
        }
    }
}
