/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

import java.util.Arrays;
import java.util.Scanner;


public class Banco {



/**
 *
 * @author Lel
 */
    
    static Scanner s = new Scanner(System.in);

    public static String[] AreaDoUsuario(String nome, String cpf, String[] cell, double valor, int posi) {
        String[] alteracao = new String[2];
        int op = 0, con = 0, con2 = 0;
        double auxD = valor;
        alteracao[0] = Double.toString(valor);
        alteracao[1] = cell[posi];
        

        System.out.printf("\n\n------Bem vindo %s------\n\n", nome);
        while (op != 99) {
            System.out.print("\nValor atual: R$" + valor + "\n1- Adicionar Valor \n2- Retirar Valor \n3- Alterar Numero \n4- Sair \nOpção: ");
            op = s.nextInt();
            con = 0;
            con2 = 0;

            switch (op) {
                case 1:

                    System.out.print("\nValor atual: R$" + valor + "\n\nInsira o valor a adicionar: R$");
                    auxD = valor + s.nextDouble();
                    valor = auxD;
                    alteracao[0] = Double.toString(auxD);
                    System.out.printf("\n\nOperação realizada com sucesso!! \n\n");
                    break;

                case 2:

                    while (con != 99) {
                        System.out.print("\nValor atual: R$" + valor + "\n\nInsira o valor a retirar: R$");
                        auxD = valor - s.nextDouble();
                        if (auxD < 0) {
                            System.out.print("\nSALDO INSUFICIENTE!!\n\n");
                        } else {
                            con = 99;
                        }
                    }
                    valor = auxD;
                    alteracao[0] = Double.toString(auxD);
                    System.out.printf("\n\nOperação realizada com sucesso!!\n");
                    break;

                case 3:

                    System.out.print("\nNumero atual: " + cell[posi] + "\n");
                    while (con2 != 99) {
                        System.out.print("\nInsira o numero novo: ");
                        alteracao[1] = s.next();
                        if (alteracao[1].length() != 11) {
                            System.out.print("\nNumero invalido!!\n");
                        } else if (Arrays.stream(cell).anyMatch(alteracao[1]::equals)) {
                            System.out.print("\nNumero ja cadastrado!!\n");
                        } else {
                            con2 = 99;
                        }
                    }
                    cell[posi] = alteracao[1];
                    System.out.print("\nNumero cadastrado com sucesso!! \nSeu novo numero é: " + cell[posi] + "\n");
                    break;

                case 4:

                    op = 99;
                    break;
            }
        }
        return alteracao;
    }

    public static int VerificaNome(String[] nome, String auxS) {

        int vOuF = 99, con;

        if (Arrays.stream(nome).anyMatch(auxS::equals)) {
            for (con = 0; con < nome.length; con++) {
                if (nome[con].equals(auxS)) {
                    vOuF = con;
                    return vOuF;
                }
            }
        }
        return vOuF;
    }

    public static int VerificaCpf(String[] cpf, String auxS) {

        int vOuF = 99, con;

        if (Arrays.stream(cpf).anyMatch(auxS::equals)) {
            for (con = 0; con < cpf.length; con++) {
                if (cpf[con].equals(auxS)) {
                    vOuF = con;
                    return vOuF;
                }
            }
        }
        return vOuF;
    }

    public static String[] CadastraUser(String[] nome, String[] cpf, String[] cell) {
        String[] cadastro = new String[4];
        int con = 0, con2 = 0;

        System.out.print("\nInsira Seu Nome: ");
        cadastro[0] = s.next();
        while (con != 99) {
            System.out.print("\nInsira Seu CPF: ");
            cadastro[1] = s.next();
            if (cadastro[1].length() != 11) {
                System.out.print("\ncpf invalido!!\n");
            } else if (Arrays.stream(cpf).anyMatch(cadastro[1]::equals)) {
                System.out.print("\ncpf ja cadastrado!!\n");
            } else {
                con = 99;
            }
        }
        while (con2 != 99) {
            System.out.print("\nInsira Seu Numero De Celular: ");
            cadastro[2] = s.next();
            if (cadastro[2].length() != 11) {
                System.out.print("\nNumero invalido!!\n");
            } else if (Arrays.stream(cell).anyMatch(cadastro[2]::equals)) {
                System.out.print("\nNumero ja cadastrado!!\n");
            } else {
                con2 = 99;
            }
        } 
        cadastro[3] = "0.00";
        System.out.print("\n\nParabens!! Usuario cadastrado com sucesso\n");
        System.out.printf("\n\nNOME: %s \nCPF: %s \nNUMERO: %s \nVALOR: R$%s\n\n", cadastro[0], cadastro[1], cadastro[2], cadastro[3]);

        return cadastro;
    }
    
    public static void main(String[] args) {

        String[] nome = new String[10];
        String auxS;
        String[] cpf = new String[10];
        String[] cell = new String[10];
        String[] dados = new String[2];
        String[] dados2 = new String[4];
        double[] valor = new double[10];
        int con = 0, con2 = 0, op = 0, auxI, auxI2, posi = 0;

        System.out.print("-----Banco Do Brasil-----\n\n");
        while (op != 99) {
            con = 0;
            System.out.print("1- Login \n2- Novo Usuario \n3- Encerrar\n");
            System.out.print("\nOpção:");
            op = s.nextInt();

            switch (op) {
                case 1:
                    dados[0] = null;
                    dados[1] = null;
                    while (con != 99) {
                        con = 0;
                        con2 = 0;
                        auxI = 0;
                        auxI2 = 0;
                        System.out.print("\nInsira Seu Nome: ");
                        auxS = s.next();
                        auxI = VerificaNome(nome, auxS);
                        while (con2 != 99) {
                            System.out.print("\nInsira Seu CPF: ");
                            auxS = s.next();
                            if (auxS.length() == 11) {
                                con2 = 99;
                            } else {
                                System.out.print("\ncpf invalido!!\n");
                            }
                        }
                        auxI2 = VerificaCpf(cpf, auxS);
                        if (auxI == auxI2) {
                            dados = AreaDoUsuario(nome[auxI], cpf[auxI], cell, valor[auxI], auxI);
                            valor[auxI] = Double.parseDouble(dados[0]);
                            con = 99;

                        } else {
                            System.out.print("\nNOME OU CPF INVALIDOS!!\n\n");
                            auxI = 0;
                            auxI2 = 0;
                            con2 = 0;
                        }
                    }
                    break;

                case 2:
                    dados2 = CadastraUser(nome, cpf, cell);
                    nome[posi] = dados2[0];
                    cpf[posi] = dados2[1];
                    cell[posi] = dados2[2];
                    valor[posi] = Double.parseDouble(dados2[3]);
                    posi += 1;
                    break;

                case 3:
                    op = 99;
                    break;
            }
        }
    }

    private static int parseInt(String[] cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
