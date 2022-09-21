public class App {
    
    public static void imprimeEmpresa(Empresa empresa){
        //imprimindo os departamentos que já estão inseridos na empresa
        System.out.print("A empresa " + empresa.getNome() + " tem os seguintes departamentos: ");
        
        int i = 0;
        //o conceito disso aqui é o famigerado forEach, que verifica todos os elementos de uma lista encadeada
        //ele para no null de qualquer jeito
        //o i só tá ali pra poder impedir que a vírgula seja sempre impressa
        for (Departamento departamento : empresa.getDepartamentos()) {
            System.out.print(departamento.getNome());
            i++;
            if(i != empresa.getDepartamentos().size())
                System.out.print(", ");
        }
        System.out.printf("\n\n");

        //imprimindo os funcionarios de cada departamento na lista
        System.out.println("Os funcionarios de cada departamento, com seus salarios respectivos estão dispostos a seguir");
        for (Departamento departamento : empresa.getDepartamentos()) {
            System.out.println(departamento.getNome());
            
            //usando a função isEmpty da java.util.LinkedList
            if(departamento.getFuncionarios().isEmpty() == true) 
                System.out.println("Sem funcionarios nesse departamento");
            
                for (Funcionario trabalhador : departamento.getFuncionarios()) {
                System.out.print(trabalhador.getNome() + ", " + trabalhador.getCpf() + ", "); 
                System.out.printf("%.2f\n", trabalhador.getSalario());
            }
            System.out.printf("\n");
        }
    }
    public static void main(String[] args) {
        //criando a empresa na main
        Empresa mi = new Empresa("Mi");
        
        //criando os funcionarios e em seguida os departamentos para inserir
        Funcionario luca = new Funcionario("Luca", "123.456.789-01", 2000);
        Funcionario joao = new Funcionario("Joao", "098.765.432-10", 3000);
        Funcionario maria = new Funcionario("Maria", "234.567.890-12", 4000);

        luca.aumentarSalario(0.2f);
        Departamento suporteTI = new Departamento("SuporteTI");
        
        suporteTI.inscreveFuncionario(luca);
        suporteTI.inscreveFuncionario(joao);
        suporteTI.inscreveFuncionario(maria);
        
        mi.insereDepartamento(suporteTI);
        
        //não irei colocar nenhum funcionario nesse departamento de vendas
        Departamento vendas = new Departamento("Vendas");
        mi.insereDepartamento(vendas);

        Funcionario andre = new Funcionario("Andre", "456.789.012-34", 2000);
        Funcionario klarine = new Funcionario("Klarine", "567.890.123-45",3000);
        Funcionario carla = new Funcionario("Carla", "678.901.234-56",4000);

        Departamento rh = new Departamento("RH");

        rh.inscreveFuncionario(andre);
        rh.inscreveFuncionario(klarine);
        rh.inscreveFuncionario(carla);

        rh.aumentarSalarioDepartamento(0.3f);
        mi.insereDepartamento(rh);

        imprimeEmpresa(mi);

    }
}
