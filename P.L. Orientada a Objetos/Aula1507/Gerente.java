/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Aula1507;

/**
 *
 * @author LAB SALA39
 */
public class Gerente extends Funcionario {
    public String login_sistema;
    public String senha_sistema;

    public String getLogin_sistema() {
        return login_sistema;
    }

    public void setLogin_sistema(String login_sistema) {
        this.login_sistema = login_sistema;
    }

    public String getSenha_sistema() {
        return senha_sistema;
    }

    public void setSenha_sistema(String senha_sistema) {
        this.senha_sistema = senha_sistema;
    }
    
}
