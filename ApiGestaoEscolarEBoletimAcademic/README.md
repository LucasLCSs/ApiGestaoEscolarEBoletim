📘 README.md
# 📚 Sistema de Gestão Escolar e Boletins – Tech Academy

Este projeto foi desenvolvido como solução para o desafio técnico de Desenvolvedor(a) de Software Júnior.  
O objetivo é automatizar a geração de boletins escolares utilizando uma arquitetura baseada em **dois serviços independentes**, simulando um cenário de microserviços.

---

## 🧱 Arquitetura

O sistema é composto por **dois projetos Spring Boot**, organizados em um **único repositório** (monorepo):

### 🔹 Serviço Core – Gestão Escolar
Responsável por:
- Gestão de **Alunos**
- Gestão de **Turmas**
- Orquestração da geração do boletim

📁 Projeto: `ApiGestaoEscolarEBoletim`  
🌐 Porta: `8080`  
🗄 Banco: `core_db`

---

### 🔹 Serviço Academic – Gestão Acadêmica
Responsável por:
- Gestão de **Notas**
- Consulta das notas dos alunos por turma/disciplina

📁 Projeto: `ApiGestaoEscolarEBoletimAcademic`  
🌐 Porta: `8081`  
🗄 Banco: `academic_db`

---

## 🧩 Padrão Arquitetural

Ambos os serviços seguem o padrão **MVC (Model–View–Controller)**, com separação clara de responsabilidades:

- `controller` → Camada de entrada (REST)
- `service` → Regras de negócio
- `repository` → Acesso a dados
- `model` → Entidades JPA
- `dto / mapper` → Transferência de dados
- `exception` → Tratamento de erros

---

## 🗄 Persistência e Migração de Banco

- Banco de dados: **PostgreSQL**
- Migração: **Flyway**
- Cada serviço possui:
    - Seu próprio banco
    - Seus próprios scripts de migração

### Estrutura Flyway


src/main/resources/db/migration

├── V1__create_tables.sql

├── V2__insert_mock_data.sql


Os dados iniciais são carregados automaticamente ao subir a aplicação.

---

## ▶️ Como Rodar o Projeto Localmente

### ✅ Pré-requisitos
- Java 17+
- Maven
- PostgreSQL
- IntelliJ IDEA (ou IDE compatível)

---

### 🔹 1. Clonar o repositório
```bash
git clone https://github.com/LucasLCSs/ApiGestaoEscolarEBoletim.git
cd ApiGestaoEscolarEBoletim
```

🔹 2. Criar os bancos no PostgreSQL
CREATE DATABASE core_db;
CREATE DATABASE academic_db;

🔹 3. Configurar variáveis de ambiente
DB_HOST=localhost
DB_POSTGRES_USER=postgres
DB_POSTGRES_PASSWORD=postgres

🔹 4. Abrir os projetos na IDE

⚠️ IMPORTANTE
Cada projeto deve ser aberto em uma janela separada da IDE.

Abra ApiGestaoEscolarEBoletim → New Window

Abra ApiGestaoEscolarEBoletimAcademic → New Window

🔹 5. Subir os serviços
Serviço Academic
mvn spring-boot:run


➡️ Porta 8081

Serviço Core

mvn spring-boot:run


➡️ Porta 8080

🔗 Comunicação entre Serviços

O Serviço Core consome o Serviço Academic via HTTP (REST), utilizando RestTemplate para consolidar as notas e gerar o boletim do aluno.

Fluxo:

Cliente → Core → Academic → Core → Cliente

🧪 Testes Manuais (Exemplo)
Listar turmas
GET http://localhost:8080/turmas

Listar alunos de uma turma
GET http://localhost:8080/turmas/{id}/alunos

Gerar boletim
GET http://localhost:8080/boletim/{idAluno}

🚀 Deploy dos Dois Projetos no Mesmo Repositório

Este repositório utiliza o modelo monorepo, onde cada serviço é independente.

📦 Estrutura do repositório
/
├── ApiGestaoEscolarEBoletim
│   ├── pom.xml
│   └── src
│
├── ApiGestaoEscolarEBoletimAcademic
│   ├── pom.xml
│   └── src

🔹 Opção 1 – Deploy Local / VPS / Docker (recomendado)

Cada serviço deve ser empacotado e executado separadamente:

# Core
cd ApiGestaoEscolarEBoletim

mvn clean package

java -jar target/*.jar

# Academic
- cd ApiGestaoEscolarEBoletimAcademic

- mvn clean package

- java -jar target/*.jar


Cada um roda em sua própria porta.

🔹 Opção 2 – Deploy em plataformas (Railway, Render, Fly.io)

- Criar um serviço por pasta

- Cada serviço aponta para:

- Um projeto Spring Boot

- Um banco de dados diferente

V- ariáveis de ambiente configuradas por serviço

🏁 Considerações Finais

- Este projeto demonstra:

- Separação de responsabilidades

- Comunicação entre serviços

- Uso de Flyway

- Organização de código

- Boas práticas em projetos Spring Boot

👨‍💻 Desenvolvido por João Lucas

---

## 🧠 O QUE VOCÊ FEZ (nível entrevista)

✔ Arquitetura correta  
✔ Dois serviços independentes  
✔ Flyway separado  
✔ Portas separadas  
✔ Comunicação REST  
✔ Organização profissional