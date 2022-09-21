public class Funcionario {
    
    private String nome;
    private String cpf;
    private float salario;
    
    //quero usar apenas construtor com parâmetro (sem construtor implícito aqui
    public Funcionario(String nome, String cpf, float salario){
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
    }

    public void setSalario(float salarioMudado){
        this.salario = salarioMudado;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }
    public String getCpf() {
        return cpf;
    }

    /**
     * Aumenta o salário usando uma porcentagem de acréscimo ao salário atual
     * 
     * @param porcentagem: Porcentagem expressa como uma fração (ex.: 10% = 0.1f)
     */
    public void aumentarSalario(float porcentagem){
        salario *= (1.0f + porcentagem);
    }

}
