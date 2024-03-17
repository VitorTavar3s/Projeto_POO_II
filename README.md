# ADA LocateCar - Locadora de veículos 🚗

## Autores:
- [Bruno Tavares](https://www.linkedin.com/in/brunoviniciusdev/)
- [Ingrid Maciel](https://www.linkedin.com/in/ingrid-m-maciel/)
- [Pedro Renan](https://www.linkedin.com/in/pedrorenan/)
- [Vitor Tavares](https://www.linkedin.com/in/vitortavares1/)

## Enunciado:
Este projeto consiste na criação de uma aplicação para gerenciar o aluguel de veículos, aplicando os conceitos estudados em aula. Os requisitos obrigatórios incluem:

- Cadastro de veículos;
- Alteração de veículos cadastrados;
- Busca de veículos por parte do nome;
- Cadastro de clientes (pessoa física e jurídica);
- Alteração de clientes (pessoa física e jurídica);
- Aluguel de veículos para pessoa física e jurídica;
- Devolução de veículos por parte de pessoas físicas e jurídicas.

Além disso, algumas regras de negócio devem ser seguidas:

- Os veículos não podem ser repetidos, utilizando a placa como identificador de unicidade;
- Tipos de veículos considerados: PEQUENO, MÉDIO e SUV;
- Os aluguéis e devoluções devem incluir local, data e horário;
- Aluguéis em horas quebradas contam como uma diária completa;
- Veículos alugados não podem estar disponíveis;
- Clientes não podem ser duplicados, utilizando CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
- Regras de devolução: desconto de 5% para clientes pessoa física com mais de 5 diárias e desconto de 10% para clientes pessoa jurídica com mais de 3 diárias.

Valores base da diária por tipo de veículo:

| Tipo de Veículo | Valor por dia |
| --------------- | -------------- |
| PEQUENO         | R$100,00       |
| MÉDIO           | R$150,00       |
| SUV             | R$200,00       |

## Utilizado:
- Java 17
- Programação Orientada a Objetos (POO)

## Overview do Projeto:
O projeto ADA LocateCar consiste em uma aplicação para gerenciamento de locadora de veículos. Utilizamos Java 17 e aplicamos os conceitos de Programação Orientada a Objetos (POO) para desenvolvê-lo.

### Facilidades e Dificuldades:
- **Facilidades:**  
    - Criar as classes.
    - Definir os pontos necessários para atender aos requisitos.
    - Tratar as excessões dentro das funções.
  
- **Dificuldades:**  
    - Transferir as funcionalidades do `main` para as classes específicas.
    - Entender onde aplicar todo o conhecimento do módulo nas classes.

---
