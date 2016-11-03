/** Aluno Jéferson Bueno Turma: 53  prova GrauA Lab I*/

public class VendasDoMes
{
    private Vendedor vendedorComissionado;
    private Vendedor vendedorSemComissao;
    private double totalComissionado;
    private double totalNaoComissionado;
    private double mesDaVenda;
    
    public VendasDoMes(String nomeComissionado, String nomeNaoComissionado, int mesDaVenda)
    {
        this.vendedorComissionado = new Vendedor(nomeComissionado, 1);
        this.vendedorSemComissao = new Vendedor(nomeNaoComissionado, 2);
        this.totalComissionado = this.totalNaoComissionado = 0;
        this.mesDaVenda = mesDaVenda;
    }
    
    public Vendedor getVendedorComissionado() {
    	return this.vendedorComissionado;
    }
    
    public void setVendedorComissionado(Vendedor vendedorComissionado) {
    	this.vendedorComissionado = vendedorComissionado;
    }
    
    public Vendedor getVendedorSemComissao() {
    	return this.vendedorSemComissao;
    }
    
    public void setVendedorSemComissao(Vendedor vendedorSemComissao) {
    	this.vendedorSemComissao = vendedorSemComissao;
    }
    
    public double getTotalComissionado() {
    	return this.totalComissionado;
    }
    
    public void setTotalComissionado(double totalComissionado) {
    	this.totalComissionado = totalComissionado;
    }
    
    public double getTotalNaoComissionado() {
    	return this.totalNaoComissionado;
    }
    
    public void setTotalNaoComissionado(double totalNaoComissionado) {
    	this.totalNaoComissionado = totalNaoComissionado;
    }
    
    public double getMesDaVenda() {
    	return this.mesDaVenda;
    }
    
    public void setMesDaVenda(double mesDaVenda) {
    	this.mesDaVenda = mesDaVenda;
    }
    
    public void vende(int tipoVendedor, double valorTotal)
    {
        if(tipoVendedor == 1)
            this.totalComissionado += valorTotal;
        else
            this.totalNaoComissionado += valorTotal;
    }
    
    public int oTrimestre()
    {
        return (int)Math.ceil(this.mesDaVenda / 3d);
    }
    
    public double calculaComissao()
    {        
        double comissao, percComissao = 0;
        int trimestre = oTrimestre();
             
        if(trimestre == 1)
        {            
            if(totalComissionado > 2000)
                percComissao = 0.2;
            else
                percComissao = 0.08;
        }
        
        if(trimestre == 2 || trimestre == 4)
        {
            if(totalComissionado > 3500)
                percComissao = 0.12;
        }
        
        if(trimestre == 3)
        {
            percComissao = 0.07;
        }
        
        comissao = (totalComissionado * percComissao);        
        return comissao;
    }
    
    public boolean atingiuMeta(double meta, int tipoVendedor)
    {
        if(tipoVendedor == 1){
            return totalComissionado >= meta;
        }
        
        return totalNaoComissionado >= meta;
    }
    
    public String oCampeaoDoMes()
    {
        if(totalComissionado == totalNaoComissionado)
            return null;
            
        if(totalComissionado > totalNaoComissionado)
            return vendedorComissionado.getNome();
        
        return vendedorSemComissao.getNome();
    }
}
