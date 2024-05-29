public class App {
    public static void main(String[] args) {
       Personagem mago=new Mago("Cabeçudinho", 10, 10);
       Personagem guer = new Guerreiro("Jurandir", 10, 10);
       Personagem arq = new Arqueiro("Hella", 10, 10);
        mago.setNivel(2);
       Personagem.combate(mago, arq);

    }
}
