import javax.swing.JPanel;

import Default.Configuracoes;
import Default.Objetos.Objeto_Atendimento;
import Default.Objetos.Objeto_Mesa;
import Default.Telas.Tela_Principal;

public class Main {

    PainelPrincipal pp = new PainelPrincipal();
    Tela_Principal tela_principal = new Tela_Principal();

    public static void main(String[] args) {
        // new PainelPrincipal();

        Configuracoes configuracoes = new Configuracoes();
        configuracoes.Carregar_Configuracoes();

        new Tela_Principal();

        /***** TESTE CARLA *****/
        // Objeto_Atendimento atendimento;
        // Objeto_Mesa mesa;

        // atendimento = new Objeto_Atendimento(1, "Em Atendimento", "Observação
        // qualquer");
        // mesa = new Objeto_Mesa(0, "Em Aberto", null, null, null, null, null, null,
        // null);

        /*
         * System.out.println(
         * "=========================================================================");
         * System.out.println("= Número da mesa: " + atendimento.numero);
         * System.out.println("= Status: " + atendimento.status);
         * System.out.println("= Observação: " + atendimento.observacao);
         * System.out.println(
         * "=========================================================================");
         */

        // atendimento.FazAlgumaCoisa();
        // mesa.FazAlgumaCoisa();

    }
}
