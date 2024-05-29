import java.util.Random;
import java.util.Scanner;


public abstract class Personagem implements Curavel{
    private String nome;
    private int nivel;
    private int forca;
    private int hp;
    private int estus;
    
    public Personagem(String nome,int forca){
        this.nome=nome;
        this.nivel=1;
        this.forca=forca;
        this.hp=100;
        this.estus = 1;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract int atacar();
    public abstract void receberDano(int dano);
    public abstract void subirNivel();
    public abstract void exibirDetalhes();

    //quem tem maior nivel
    private static Personagem maiorNivel(Personagem p1, Personagem p2) {
        if (p1.getNivel() > p2.getNivel()) {
            return p1;
        }
        if (p1.getNivel() < p2.getNivel()) {
            return p2;
        }
        else {
            Random random=new Random();
            int r = random.nextInt(2);
            if (r == 0) {
                return p1;
            } else {
                return p2;
            }
        }
    }

    private static void mensagemVitoria(Personagem p) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+p.getNome() + " Venceu!");
        System.out.println(p.getNome() + " Subiu de Nivel!\n");
        System.out.println("**Enter para exibir detalhes dos personagens**");
        scanner.nextLine();
        p.exibirDetalhes();
        scanner.close();
    }

    @Override
    public void curar() {
        if (estus > 0) {
            setHp(getHp() + 10*getNivel());
            estus--;
            System.out.printf("\n%s usou Estus Flask - Usos restantes [%d]\n", getNome(), estus);
            System.out.printf("%s-HP: %d\n", getNome(), getHp());
        } else {
            System.out.printf("%s não tem mais Estus Flask para usar.\n", getNome());
        }

    }

    public static void combate(Personagem p1, Personagem p2) {
        Scanner input = new Scanner(System.in);
        Personagem atacante = Personagem.maiorNivel(p1, p2);

        int opcao = 1;
        System.out.printf("\n(%s X %s)\n", p1.getNome(), p2.getNome());
        while (p1.getHp() > 0 && p2.getHp() > 0 && opcao != 3){
            if (atacante == p1) {
                System.out.printf("\nTURNO DE '%s'", p1.getNome());
            } else {
                System.out.printf("\nTURNO DE '%s'", p2.getNome());
            }
            System.out.println("\nVai atacar ou fugir?");
            System.out.println("1-Atacar");
            System.out.println("2-Estus Flask");
            System.out.println("3-Fugir");

            opcao = input.nextInt();

            switch (opcao) {
                case 1 :
                    System.out.println("Atacando...\n");
                    if (atacante == p1) {
                        p2.receberDano(p1.atacar());
                        System.out.printf("%s-HP: %d\n",p2.getNome(),p2.getHp());
                        p1.subirNivel();
                        atacante = p2;
                    } else {
                        p1.receberDano(p2.atacar());
                        System.out.printf("%s-HP: %d\n",p1.getNome(),p1.getHp());
                        p2.subirNivel();
                        atacante = p1;
                    }
                    break;
                case 2 :
                    atacante.curar();
                    atacante = (atacante == p1) ? p2 : p1;
                    break;
                case 3 :
                    System.out.println("Fugindo...");
                    break;
                default :
                    System.out.println("Opção Invalida!");
                    break;
            }
        }

        if(opcao == 3) {
            System.out.println("Covarde!");
        } else {
            if (p1.getHp() > 0) {

                mensagemVitoria(p1);
                p2.exibirDetalhes();
            } else {

                mensagemVitoria(p2);
                p1.exibirDetalhes();
            }
        }
        input.close();
    }
    
}
