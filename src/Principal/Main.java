package Principal;

import Classes.OperacoesBD;
import Classes.Usuario;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        Usuario newUser = new Usuario();
        
        newUser.setNome(JOptionPane.showInputDialog(null, "Digite o nome: "));
        newUser.setEmail(JOptionPane.showInputDialog(null, "Digite o Email: "));
        newUser.setEndereco(JOptionPane.showInputDialog(null, "Digite o Endereço: "));
        newUser.setFone1(JOptionPane.showInputDialog(null, "Digite o 1º telefone: "));
        newUser.setFone2(JOptionPane.showInputDialog(null, "Digite o 2º telefone: "));
        
        OperacoesBD.cadastroDados(newUser);
        OperacoesBD.recuperaDados();
    }
}
