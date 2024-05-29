public class Guerreiro extends Personagem implements Curavel{
    private int habilidadeDeCombate;
    private int escudo;

    public Guerreiro(String nome, int habilidadeDeCombate,int escudo){
        super(nome,5);
        this.habilidadeDeCombate=habilidadeDeCombate;
        this.escudo=escudo;
    }
    @Override
    public int atacar(){
        int dano=super.getForca()*habilidadeDeCombate;
        System.out.printf("%s atacou - forca do ataque [%d]\n",super.getNome(),dano);
        return dano;
    }

    @Override
    public void receberDano(int dano) {
        int novoHp;
        if(dano>0){
            if(getEscudo()>0 && getEscudo()>=dano){
                setEscudo(getEscudo()-dano);
                System.out.printf("%s Defendeu com o escudo\n", getNome());
                System.out.printf("Escudo: %d/50\n",getEscudo());
            }
            else if(getEscudo()>0 && getEscudo()<dano){
                dano-=escudo;
                System.out.printf("%s Perdeu o escudo!\n", getNome());
                setEscudo(0);
                System.out.printf("Escudo: %d/50\n",getEscudo());
                novoHp=super.getHp()-dano;
                if(novoHp<=0){
                    super.setHp(0);
                    System.out.printf("%s esta acabado e nao consegue mais lutar\n",getNome());
                }
                else{
                    super.setHp(novoHp);
                }
                System.out.printf("%s recebeu %d de dano\n",getNome(),dano);
            }
            else{
                novoHp=super.getHp()-dano;
                //super.setHp(novoHp);
                if(novoHp<=0){
                    super.setHp(0);
                    System.out.printf("%s esta acabado e nao consegue mais lutar\n",getNome());
                }
                else{
                    super.setHp(novoHp);
                }
                System.out.printf("%s recebeu %d de dano\n",getNome(),dano);
            }
        }
    }

    @Override
    public void subirNivel() {
        setNivel(getNivel() + 1);
        setEscudo(escudo + 5);
        setHabilidadeDeCombate(habilidadeDeCombate + 5);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Info de "+super.getNome());
        System.out.printf("Nome: %s\n",super.getNome());
        System.out.println("Nivel: "+super.getNivel());
        System.out.printf("HP: %d/100\n",super.getHp());
        System.out.println("Forca: "+super.getForca());
        System.out.println("Habilidade de combate: "+habilidadeDeCombate);
        System.out.printf("Escudo: %d/50: \n\n",escudo);
    }

    public int getHabilidadeDeCombate() {
        return habilidadeDeCombate;
    }

    public void setHabilidadeDeCombate(int habilidadeDeCombate) {
        this.habilidadeDeCombate = habilidadeDeCombate;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    
}
