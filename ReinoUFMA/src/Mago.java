import java.util.Random;
public class Mago extends Personagem {
    public int habilidadeMagica;
    public int esquiva;

    public Mago(String nome, int habilidadeMagica, int esquiva){
        super(nome,5);
        this.habilidadeMagica=habilidadeMagica;
        this.esquiva=esquiva;
    }

    @Override
    public int atacar() {
        int dano=super.getForca()*habilidadeMagica;
        System.out.printf("%s atacou - forca do ataque [%d]\n",getNome(),dano);
        return dano;
    }

    @Override
    public void receberDano(int dano) {
        Random random= new Random();
        int chanceErro = random.nextInt(100);
        if(chanceErro <= getEsquiva()){
            System.out.printf("%s Esquivou do ataque\n",getNome());
        }
        else if(dano>=super.getHp()){
            super.setHp(0);
            System.out.printf("%s apanhou muito e esta inconsciente\n",getNome());
        }
        else{
            int novoHp=super.getHp()-dano;
            super.setHp(novoHp);
            System.out.printf("%s sofreu [%d] de dano\n",getNome(),dano);
        }
    }

    @Override
    public void subirNivel() {
        setNivel(getNivel() + 1);
        setEsquiva(esquiva + 5);
        setHabilidadeMagica(habilidadeMagica + 5);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Info de "+super.getNome());
        System.out.printf("Nome: %s\n",super.getNome());
        System.out.println("Nivel: "+super.getNivel());
        System.out.printf("HP: %d/100\n",super.getHp());
        System.out.println("Forca: "+super.getForca());
        System.out.println("Habilidade com magia: "+habilidadeMagica);
        System.out.printf("Chande de esquiva: %d\n\n",esquiva);
    }



    public int getHabilidadeMagica() {
        return habilidadeMagica;
    }

    public void setHabilidadeMagica(int habilidadeMagica) {
        this.habilidadeMagica = habilidadeMagica;
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }
    
}
