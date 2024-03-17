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

Regras de negócio:

- RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;
- RN2: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;
- RN3: Os aluguéis e devoluções terão o local, data e horário;
- RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
- RN5: Os veículos que estiverem alugados não poderão estar disponíveis;
- RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
- RN7: Regras de devolução:
Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.
- Valores base da diária por tipo de veículo:
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
