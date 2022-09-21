import java.util.LinkedList;

public class Departamento {
    
    private String nome;
    //faz uma lista encadeada de funcionarios para o departamento em questão
    private LinkedList<Funcionario> funcionarios = new LinkedList<>();

    public Departamento(String nome){
        this.nome = nome;
    }
    
    //pré-condições: trabalhador válido
    //pós-condições: trabalhador inserido à lista
    //inserindo um funcionário na lista do departamento
    public void inscreveFuncionario(Funcionario trabalhador){
        funcionarios.addLast(trabalhador);
    }

    //pré-condições: trabalhador válido
    //pós-condições: trabalhador removido da lista
    //removendo um funcionário da lista do departamento
    public void removeFuncionario(Funcionario trabalhador){
        funcionarios.remove(trabalhador);
    }

    public String getNome() {
        return nome;
    }

    //retorno: cópia da lista de funcionários dessa classe
    public LinkedList<Funcionario> getFuncionarios() {
        return new LinkedList<Funcionario>(funcionarios);
    }

    //pré-condições: existir funcionários e salários no departamento
    //retorno: a média salarial do departamento
    public float getMediaSalarialDepartamento(){
        float totalSalarios = 0;
        for(Funcionario trabalhador : funcionarios) {
            totalSalarios += trabalhador.getSalario();
        }
        if(funcionarios.size() == 0) return 0;
        return totalSalarios / funcionarios.size();
    }

    //pré-condições: existir funcionários e salários no departamento
    //retorno: o total dos salários do departamento
    public float getTotalSalariosDepartamento(){
        float totalSalarios = 0;
        for(Funcionario trabalhador : funcionarios) {
            totalSalarios += trabalhador.getSalario();
        }
        return totalSalarios;
    }

    /**
     * Aumenta o salário de todos os funcionários do departamento usando uma porcentagem de acréscimo ao salário atual
     * 
     * @param porcentagem: Porcentagem expressa como uma fração (ex.: 10% = 0.1f)
     */
    public void aumentarSalarioDepartamento(float porcentagem){
        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentarSalario(porcentagem);
        }
    }
}
