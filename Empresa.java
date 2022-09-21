import java.util.LinkedList;

public class Empresa {
    
    private String nome;
    //a empresa é composta por departamentos diferentes
    private LinkedList<Departamento> departamentos = new LinkedList<>();

    public Empresa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void insereDepartamento(Departamento novoDepartamento){
        departamentos.addLast(novoDepartamento);
    }

    public void removeDepartamento(Departamento departamentoTira){
        departamentos.remove(departamentoTira);
    }

    //isso aqui retorna uma cópia para a lista de departamentos da empresa
    //por isso que existe um new naquele return ali
    public LinkedList<Departamento> getDepartamentos() {
        return new LinkedList<Departamento>(departamentos);
    }

    //pré-condições: existir funcionários e salários em cada departamento
    //retorno: o total de salários da empresa
    public float getTotalSalariosEmpresa(){
        float totalSalarios = 0;
        for (Departamento departamento : departamentos) {
            totalSalarios += departamento.getTotalSalariosDepartamento();
        }

        return totalSalarios;
    }

    //pré-condições: existir funcionários em cada departamento
    //retorno: o total de funcionários da empresa
    public int getTotalFuncionarios(){
        int totalFuncionarios = 0;
        for (Departamento departamento : departamentos) {
            totalFuncionarios += departamento.getFuncionarios().size();
        }

        return totalFuncionarios;
    }

    //pré-condições: existir funcionários e salários em cada departamento
    //retorno: a média salarial da empresa
    //colocando o return 0 ali porque Java dá ArithmeticException se dividir 0 por 0
    public float getMediaSalarialEmpresa(){
        int totalFuncionarios = getTotalFuncionarios();
        if(totalFuncionarios == 0)
            return 0;
        return getTotalSalariosEmpresa() / totalFuncionarios;
    }

    /**
     * Aumenta o salário de todos os funcionários da empresa usando uma porcentagem de acréscimo ao salário atual
     * 
     * @param porcentagem: Porcentagem expressa como uma fração (ex.: 10% = 0.1f)
     */
    public void aumentarSalarioEmpresa(float porcentagem){
        for (Departamento departamento : departamentos) {
            departamento.aumentarSalarioDepartamento(porcentagem);
        }
    }
}
