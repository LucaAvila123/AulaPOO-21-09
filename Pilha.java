//essa aplicação do java.util.LinkedList não necessariamente ajuda pra essa aula de laboratório

import java.util.LinkedList;

public class Pilha{
    //constrói uma lista encadeada
    private LinkedList<String> items = new LinkedList<String>();

    //os métodos são o que determina a pilha, nesse caso usando apenas empilha e desempilha
    //o tradicional LIFO (Last In First Out)
    public void empilha(String s){
        items.addLast(s);
    } 

    public String desempilha(){
        return items.removeLast();
    }

    public int getTamanho(){
        return items.size();
    }

    public LinkedList<String> getItems(){
        return new LinkedList<String>(items); //retorna uma cópia da lista de strings
    }
}