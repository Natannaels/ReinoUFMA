public class App {
    public static void main(String[] args) {
       Personagem mago=new Mago("Valdemart", 10, 10);
       Personagem guer = new Guerreiro("Aquiles", 10, 10);
       Personagem arq = new Arqueiro("Merida", 10, 10);
       Personagem.combate(mago, arq);

    }
}
