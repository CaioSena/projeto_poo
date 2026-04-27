# Projeto POO ☕

Este é um projeto desenvolvido em Java para a disciplina de **Programação Orientada a Objetos**. O repositório foi criado para facilitar a colaboração entre a equipe e centralizar o código-fonte.

---

## 🚀 Como executar o projeto

Siga os passos abaixo para configurar o ambiente e rodar a aplicação no seu Debian ou outro sistema Linux:

### 📋 Pré-requisitos
Certifique-se de ter o JDK (Java Development Kit) instalado. Caso não tenha, você pode instalar a versão padrão com o comando:

```bash
sudo apt update
sudo apt install default-jdk
```
### Clone o repositório:

```Bash
git clone git@github.com:CaioSena/projeto_poo.git
```
#### Compile e Rode:

```Bash
cd projeto_poo
javac src/*.java -d bin/
java -cp bin Main
```
## 🪟 No Windows (PowerShell ou CMD)
Pré-requisito: Tenha o JDK instalado e configurado nas Variáveis de Ambiente (PATH).

### Clone o repositório:

```PowerShell
git clone [https://github.com/CaioSena/projeto_poo.git](https://github.com/CaioSena/projeto_poo.git)
```
Compile os arquivos:

```PowerShell
cd projeto_poo
if (!(Test-Path bin)) { New-Item -ItemType Directory -Name bin }
javac src/*.java -d bin
```
Execute o programa:

```PowerShell
java -cp bin Main
```
(Substitua 'Main' pelo nome da sua classe principal)

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 17+
* **Ambiente de Desenvolvimento:** Debian GNU/Linux
* **Versionamento:** Git

## 📂 Estrutura de Pastas
* `src/`: Contém todo o código-fonte `.java`.
* `bin/`: Arquivos compilados `.class` (pasta criada localmente).
* `.gitignore`: Filtro para evitar o envio de arquivos desnecessários.

## 👥 Colaboradores
* **Caio Sena** — [GitHub](https://github.com/CaioSena)
* **Enzo Alves** — [GitHub](https://github.com/link-do-perfil-do-enzo)

---
*Desenvolvido como parte dos estudos de POO.*
Enzo Alves - [Link do Perfil]

Desenvolvido como parte dos estudos de POO.
