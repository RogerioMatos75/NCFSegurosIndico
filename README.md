# NCF Seguros Indica

## 📱 Sobre o Projeto
O NCF Seguros Indica é um aplicativo Android desenvolvido para facilitar o processo de indicações de seguros, permitindo um gerenciamento eficiente e intuitivo das indicações de clientes.

## 🚀 Tecnologias Utilizadas
- Kotlin
- Android Jetpack
  - Compose UI
  - Navigation
  - ViewModel
  - StateFlow
- Firebase
  - Authentication
- Dagger Hilt (Injeção de Dependência)
- Coroutines
- Clean Architecture
- MVVM (Model-View-ViewModel)

## 📋 Pré-requisitos
- Android Studio Arctic Fox ou superior
- JDK 11 ou superior
- Gradle 8.10.2 ou superior
- Dispositivo/Emulador Android com API 24 (Android 7.0) ou superior

## 🔧 Configuração do Ambiente
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/NCFSegurosIndico.git
```

2. Abra o projeto no Android Studio

3. Sincronize o projeto com os arquivos Gradle

4. Configure o arquivo google-services.json (necessário para o Firebase)

5. Execute o aplicativo

## 🏗️ Arquitetura do Projeto
O projeto segue os princípios da Clean Architecture e está organizado nas seguintes camadas:

- **data**: Implementação dos repositórios e fontes de dados
  - auth: Serviços de autenticação
  - repository: Implementação dos repositórios

- **domain**: Regras de negócio e entidades
  - models: Modelos de domínio
  - repository: Interfaces dos repositórios
  - usecase: Casos de uso da aplicação

- **ui**: Interface do usuário
  - screens: Telas do aplicativo
  - navigation: Configuração de navegação
  - theme: Estilos e temas

- **viewmodel**: ViewModels para gerenciamento de estado

## 🔐 Autenticação
O sistema utiliza o Firebase Authentication para gerenciar o acesso dos usuários, implementando:
- Login com e-mail e senha
- Tratamento de erros de autenticação
- Mensagens de erro localizadas

## 🧪 Testes
O projeto inclui:
- Testes unitários para ViewModels
- Testes de interface do usuário (UI Tests)
- Testes de integração

## 📱 Funcionalidades Principais
- Login de usuários
- Dashboard administrativo
- Gerenciamento de indicações
- Sistema de navegação intuitivo

## 🤝 Contribuição
Para contribuir com o projeto:
1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob a licença [MIT](https://opensource.org/licenses/MIT).

## 📞 Contato
NCF Seguros - [Website](https://www.ncfseguros.com.br)

---
Desenvolvido com ❤️ por Rogerio Matos/Regina Reine