# Pass-In

Pass-In é uma aplicação de gestão de participantes em eventos presenciais. Permite que organizadores cadastrem eventos, abram páginas públicas de inscrição e participantes inscritos emitam credenciais para check-in no dia do evento.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- HSQLDB
- Flyway (para migração de banco de dados)
- Lombok
- Spring Dev Tools

## Requisitos Funcionais

- Organizador pode cadastrar um novo evento
- Organizador pode visualizar dados de um evento
- Organizador pode visualizar a lista de participantes
- Participante pode se inscrever em um evento
- Participante pode visualizar seu crachá de inscrição
- Participante pode realizar check-in no evento

## Regras de Negócio

- Participante só pode se inscrever em um evento uma única vez
- Participante só pode se inscrever em eventos com vagas disponíveis
- Participante só pode realizar check-in em um evento uma única vez

## Requisitos Não Funcionais

- Check-in no evento é realizado através de um QR Code

## Como Executar o Projeto

Você pode usar qualquer software de gestão de API como o INSOMNIA, APIDog, Postman, etc...
1. Clone o repositório: `git clone https://github.com/seu-usuario/pass-in.git`
2. Navegue até o diretório do projeto: `cd pass-in`
3. Execute a aplicação: `./mvnw spring-boot:run`

Dentro do codigo é possivel vizualizar todos os caminhos de consumo


Certifique-se de ter o Java e o Maven instalados em sua máquina.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues para reportar bugs ou sugerir novas funcionalidades. Pull requests também são incentivados.

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
