# Javer Bank | Bridge

Esta API é responsável por ser a ponte para a segunda aplicação do sistema de cadastro de clientes do banco **JAVER**.

Os endpoints **REST** do **Serviço Javer de Armazenamento H2** são expostos por meio desse, possibilitando operações CRUD de clientes e, além disso, fornece um endpoint para calcular o score de crédito.

### Pré-requisitos
- Antes de executar esta aplicação, é necessário configurar e executar a segunda aplicação através do repositório [Serviço de Armazenamento](https://github.com/mateusdomelo/javer-bank-database).
- Certificar-se de ter o Java JDK 17 e o Maven instalados na máquina.

## Como Executar
1. Clonar o repositório: `git clone https://github.com/mateusdomelo/javer-bank-bridge.git`
2. Acessar o diretório do projeto: `cd javer-bank-bridge`
3. Executar o projeto usando o Maven: `mvn spring-boot:run`

## Como Acessar
1. Após iniciar a aplicação, é possível acessar os endpoints REST utilizando ferramentas como cURL, Postman, Insomnia ou qualquer outro cliente HTTP.
2. Os endpoints estão disponíveis a partir do endereço `http://localhost:8080/`.
   1. A url de integração com o [Serviço de Armazenamento](https://github.com/mateusdomelo/javer-bank-database) está definida como 'http://localhost:8081/ms', portanto, caso a porta dessa seja alterada, faz-se necessário também atualizar na outra aplicação e vice-versa.
3. Consultar a documentação da API para obter detalhes sobre os endpoints disponíveis e os payloads esperados em `http://localhost:8080/swagger-ui/index.html`.

## Testes Unitários

1. Garantir que os passos descritos na seção "_Como Executar_" foram realizados;
2. Executar os testes usando o Maven: `mvn test`.

---
## Contatos
Em caso de dúvidas, problemas ou sugestões, sinta-se à vontade para entrar em contato:

- **E-mail:** mateusdomelo@gmail.com
- **LinkedIn:** [Mateus Melo](https://www.linkedin.com/in/mateusdomelo/)