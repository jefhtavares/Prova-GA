/** Aluno Jéferson Bueno Turma: 53  prova GrauA Lab I*/

public class TestaVendas
{   
    public static void main (String args[])
    {
        Teclado t = new Teclado();
        //Ler do teclado os nomes dos dois vendedores e o mês da venda
        
        String nomeComissionado = t.leString("Digite o nome do vendedor comissionado: ");
        String nomeNaoComissionado = t.leString("Digite o nome do vendedor NÃO comissionado: ");
        int mes = t.leInt("Entre com o mês da venda 1-12: ");
                       
        //Instanciar um objeto VendasDoMes, usando os dados lidos do teclado
        VendasDoMes v1 = new VendasDoMes(nomeComissionado, nomeNaoComissionado, mes);
        
        //para cada vendedor realizar duas vendas, com valores randômicos de 500 até 3999
        
        v1.vende(1, valorRandom());
        v1.vende(1, valorRandom());
        
        v1.vende(2, valorRandom());
        v1.vende(2, valorRandom());
        
        //Exibir o nome ... dos dois vendedores        
        exibirDados(v1.getVendedorSemComissao(), v1.getTotalNaoComissionado());
        exibirDados(v1.getVendedorComissionado(), v1.getTotalComissionado());
        
        System.out.println("Total comissão: " + v1.calculaComissao());
        
        System.out.println("\tMostrando o campeão do mês");
        String campeao = v1.oCampeaoDoMes();
        System.out.println(campeao == null ? "Empate" : campeao);
        
        double meta = t.leDouble("Entre com o valor da meta do mês");
        
        boolean atingiuMeta = v1.atingiuMeta(meta, 2);
        String msg = atingiuMeta ? "atingiu" : "não atingiu";
        
        System.out.println("O vendedor não comissionado (" + v1.getVendedorSemComissao().getNome() + ") " 
                            + msg + " a meta do mês");
    }
    
    public static double valorRandom()
    {
        double min = 500.0, max = 3999.0;
        return (min + (int)(Math.random() * (max - min)));
    }
    
    public static void exibirDados(Vendedor vend, double totalVendido)
    {
        System.out.println("Nome: " + vend.getNome());
        System.out.println("Total vendido: " + totalVendido);
        System.out.println("Tipo: " + vend.traduzTipo());                
    }
}
