
package projetolutador.tela;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import projetolutador.negocio.Lutador;
import projetolutador.negocio.ManipuladorArquivo;


public class CadastrarLutador extends JFrame {
    JLabel titulo = new JLabel("cadastro");
    JLabel id = new JLabel("id");
    JLabel nome = new JLabel("nome");
    JLabel apelido = new JLabel("apelido");
    JLabel peso = new JLabel("peso");
   
    JLabel idade = new JLabel("idade");
    JLabel altura = new JLabel("altura");
    JTextField idTF=new JTextField();
    JTextField nomeTF=new JTextField();
    JTextField apelidoTF=new JTextField();
    JTextField pesoTF=new JTextField();
  
    JTextField alturaTF=new JTextField();
    JTextField idadeTF=new JTextField();
    JButton cadastrar= new JButton("cadastrar");
    Container cp;
    public CadastrarLutador(){
    setTitle("Master MMA");
    setSize(500, 500);
    setLocationRelativeTo(null);// centraliza
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    titulo.setFont(new Font("SansSerif", Font.BOLD, 19));
    cp = getContentPane();// instancia o container da janela
    cp.setLayout(null);
    
    
    titulo.setBounds(100,5,150,25);

		id.setBounds(50, 48, 100, 25);
		nome.setBounds(50, 76, 100, 25);
		apelido.setBounds(50, 104, 100, 25);
		peso.setBounds(50, 132, 100, 25);
		
		altura.setBounds(50, 188, 100, 25);
		idade.setBounds(50, 216, 100, 25);
		idTF.setBounds(150, 48, 150, 25);
		nomeTF.setBounds(150, 76, 150, 25);
		apelidoTF.setBounds(150, 104, 150, 25);
		pesoTF.setBounds(150, 132, 150, 25);
		
		alturaTF.setBounds(150, 188, 150, 25);
		idadeTF.setBounds(150, 216, 150, 25);
		cadastrar.setBounds(305, 300, 110, 25);
                cp.add(id);
                cp.add(nome);
                cp.add(apelido);
                cp.add(peso);
                
                cp.add(altura);
                cp.add(idade);
                cp.add(idTF);
                cp.add(nomeTF);
                cp.add(apelidoTF);
                cp.add(pesoTF);
               
                cp.add(alturaTF);
                cp.add(idadeTF);
                cp.add(cadastrar);
                
               
		cadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				                        Lutador lt = new Lutador();
                                                        lt.setNome(nomeTF.getText());
                                                        lt.setAltura(Double.parseDouble(alturaTF.getText()));
                                                        lt.setId(Integer.parseInt(idTF.getText()));
                                                        lt.setApelido(apelidoTF.getText());
                                                        lt.setPeso(Double.parseDouble(pesoTF.getText()));
                                                        lt.setIdade(Integer.parseInt(idadeTF.getText()));
                            try {
                                ManipuladorArquivo.write("lutador.txt", lt.toString());
                                dispose();
                            } catch (IOException ex) {
                                Logger.getLogger(CadastrarLutador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                
					
				
			}
		});

              

    }
    
}

