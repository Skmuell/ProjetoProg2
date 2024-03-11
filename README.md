Projeto de programação 2

Este código é um sistema simples de gerenciamento de passagens aéreas que permite aos clientes comprar passagens, cadastrar novos clientes e aos funcionários realizar várias operações como editar/excluir passagens e clientes, listar passagens e clientes, entre outras. Aqui está uma explicação detalhada do código:

Pacotes e Importações:

O código importa as classes necessárias do pacote java.io.*, que são usadas para operações de entrada e saída.
Importa também as classes ArrayList, List, e Scanner do pacote java.util.*, necessárias para manipulação de listas e entrada de dados do usuário.
Classe Principal (Main):

A classe principal é onde o programa começa sua execução.
Inicializa as listas de clientes, passagens e funcionários.
Chama o método carregarDados para carregar os dados dos arquivos.
Usa um loop while (true) para exibir um menu principal até que o usuário escolha sair.
O usuário pode escolher entre ser um cliente, um funcionário ou sair do programa.
Dependendo da escolha, diferentes operações são realizadas.
Métodos:

buscarClientePorCPF: Recebe uma lista de clientes e um CPF como entrada e retorna o cliente correspondente ao CPF fornecido, se existir.
cadastrarNovoCliente: Solicita informações de um novo cliente (nome, idade, CPF) e adiciona o cliente à lista de clientes.
comprarPassagem: Permite que um cliente compre uma passagem, exibindo uma lista de passagens disponíveis e solicitando ao cliente o ID da passagem desejada.
buscarPassagemPorID: Recebe uma lista de passagens e um ID como entrada e retorna a passagem correspondente ao ID fornecido, se existir.
exibirMenuFuncionario: Exibe o menu de opções para funcionários, permitindo que eles realizem várias operações como editar/excluir passagens e clientes, listar passagens e clientes, entre outras.
editarPassagens, excluirPassagens, editarCliente, excluirCliente: Métodos auxiliares para realizar operações específicas de edição/exclusão de passagens e clientes.
listarPassagens, listarClientes: Métodos para listar todas as passagens e clientes cadastrados, respectivamente.
salvarDados, carregarDados: Métodos para salvar os dados das listas em arquivos e carregar os dados dos arquivos para as listas, respectivamente.
