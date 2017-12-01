public class Main {

    public static void main(String[] args) {
        ContaBancaria c1 = new ContaCorrente();
        c1.setNome("Henrique");
        c1.setAgencia("1234-0");
        c1.setConta("1234567-0");
        c1.setSenha(123);
        c1.setSaldo(1000);
        System.out.println("Cliente: "+c1.getNome()+"\nAgencia: "+c1.getAgencia()+" / Conta: "+c1.getConta()+"\nSeu Saldo atual é de: "+c1.getSaldo());
        
        c1.setNumerocartao(000000000);
        c1.setValidade("08/15");
        c1.setCodseguranca(157);
        System.out.println("\nInformações do cartão: numero: "+c1.getNumerocartao()+", validadade: "+c1.getValidade()+", codigo de seguranca: "+c1.getCodseguranca());
        
        c1.Deposito(4500);
        System.out.println("\nApós o Deposito seu Saldo é de: "+c1.getSaldo()+"\n");
        
        c1.Saque(6000);
        
        c1.Saque(500);
        System.out.println("\nApós o Saque seu Saldo é de: "+c1.getSaldo());
        
        c1.Juros();
        System.out.println("\nSaldo após o Juros anual: "+c1.getSaldo());
        
        ContaBancaria c2 = new ContaPoupanca();
        c2.setNome("Joao");
        c2.setAgencia("1234-0");
        c2.setConta("7654321-0");
        c2.setSenha(321);
        c2.setSaldo(100);
        
        System.out.println("\n\nCliente: "+c2.getNome()+"\nAgencia: "+c2.getAgencia()+" / Conta: "+c2.getConta()+"\nSeu Saldo atual é de: "+c2.getSaldo());
        
        c2.setNumerocartao(00000001);
        c2.setValidade("15/08");
        c2.setCodseguranca(751);
        System.out.println("\nInformações do cartão: numero: "+c2.getNumerocartao()+", validadade: "+c2.getValidade()+", codigo de seguranca: "+c2.getCodseguranca());
        
        c2.Deposito(900);
        System.out.println("\nApós o Deposito seu Saldo é de: "+c2.getSaldo()+"\n");
        
        c2.Saque(2000);
        
        c2.Saque(500);
        System.out.println("\nApós o Saque seu Saldo é de: "+c2.getSaldo());
        
        c2.Juros();
        System.out.println("\nSaldo após o Juros mensal: "+c2.getSaldo());
    }
    
}
