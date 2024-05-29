import java.util.Random;

public class Arqueiro extends Personagem implements Curavel, ChanceDeErro {
    private int habilidadeComArco;
    private int destreza;

    public Arqueiro(String nome, int habilidadeComArco, int destreza) {
        super(nome, 5);
        this.habilidadeComArco = habilidadeComArco;
        this.destreza = destreza;
    }

    @Override
    public int atacar() {
        if (calcularChanceDeAcerto()) {
            int dano = super.getForca() * (habilidadeComArco + destreza);
            System.out.printf("%s atacou - forca do ataque [%d]\n", getNome(), dano);
            return dano;
        } else {
            System.out.printf("%s errou o ataque!\n", getNome());
            return 0; // Zero dano se o ataque errar
        }
    }

    @Override
    public void receberDano(int dano) {
        if (dano >= super.getHp()) {
            super.setHp(0);
            System.out.printf("%s teve seu hp zerado e está a mimir\n", super.getNome());
        } else {
            super.setHp(super.getHp() - dano);
            System.out.printf("%s recebeu %d de dano\n", super.getNome(), dano);
        }
    }

    @Override
    public void subirNivel() {
        setNivel(getNivel() + 1);
        setHabilidadeComArco(habilidadeComArco + 5);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Info de " + super.getNome());
        System.out.printf("Nome: %s\n", super.getNome());
        System.out.println("Nivel: " + super.getNivel());
        System.out.printf("HP: %d/100\n", super.getHp());
        System.out.println("Forca: " + super.getForca());
        System.out.println("Habilidade com arco: " + habilidadeComArco);
        System.out.printf("Destreza: %d\n\n", destreza);
    }

    @Override
    public boolean calcularChanceDeAcerto() {
        Random random = new Random();
        // A chance de acerto pode ser baseada na soma de habilidade com arco e destreza
        // Por exemplo, se habilidadeComArco + destreza > random.nextInt(100), o ataque acerta
        int chance = habilidadeComArco + destreza;
        return (random.nextInt(chance * 2)+1) < chance;
    }

    public int getHabilidadeComArco() {
        return habilidadeComArco;
    }

    public void setHabilidadeComArco(int habilidadeComArco) {
        this.habilidadeComArco = habilidadeComArco;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
