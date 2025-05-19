# DAOs - Projeto SpotiFei

## Visão Geral
Este projeto contém uma série de Data Access Objects (DAOs) para gerenciar a interação com um sistema de música estilo Spotify. Os DAOs fornecem operações CRUD para diferentes entidades do sistema.

## DAOs Implementados

### 1. ArtistaAdicionadoDAO
**Função**: Gerencia artistas adicionados pelo usuário  
**Principais métodos**:
- `inserir(Pesquisa artista)`: Adiciona um novo artista

### 2. Conexao
**Função**: Gerencia a conexão com o banco de dados PostgreSQL  
**Configuração**: Conecta ao banco "PROJETO_SPOTIFEI" com usuário "postgres"

### 3. CurtirDAO
**Função**: Gerencia músicas/artistas curtidos  
**Principais métodos**:
- `remover_curtida(Curtir curtir)`: Remove uma curtida
- `listarcurtidas()`: Lista todas as curtidas

### 4. HistoricoDAO
**Função**: Gerencia o histórico de reprodução  
**Principais métodos**:
- `inserir(Historico h)`: Adiciona item ao histórico
- `listarUltimos10()`: Recupera os 10 últimos itens
- `listarArtistasHistorico()`: Lista artistas do histórico

### 5. OuvirDAO
**Função**: Gerencia playlists e artistas para ouvir  
**Principais métodos**:
- `listarArtistasouvir()`: Lista artistas adicionados
- `remover_artistas(Ouvir ouvir)`: Remove artista
- `listarPlaylistouvir()`: Lista playlists disponíveis

### 6. PesquisaDAO
**Função**: Gerencia artistas e pesquisas  
**Principais métodos**:
- `inserir(Pesquisa pesquisa)`: Adiciona novo artista
- `curtir(Pesquisa pesquisa)`: Adiciona curtida
- `buscarPorNome(String nome)`: Busca artista por nome

### 7. PlaylistDAO
**Função**: Gerencia playlists do usuário  
**Principais métodos**:
- `inserir(Playlist playlist)`: Cria nova playlist
- `remover(Playlist playlist)`: Remove playlist
- `listarTudo()`: Lista todas as playlists

### 8. UsuarioDAO
**Função**: Gerencia usuários do sistema  
**Principais métodos**:
- `consultar(Cliente aluno)`: Autentica usuário
- `atualizar(Cliente aluno)`: Atualiza senha
- `remover(Cliente aluno)`: Remove usuário
- `inserir(Cliente aluno)`: Cadastra novo usuário

## Tecnologias Utilizadas
- Java
- JDBC
- PostgreSQL

## Observações
- O projeto está em desenvolvimento e pode receber novas funcionalidades
- Alguns métodos fecham a conexão prematuramente (deveria ser gerenciado pelo chamador)
- Algumas classes poderiam ser refatoradas para melhor organização



# 🎛️ Controllers - Projeto SpotiFei

## Visão Geral
Controladores responsáveis pela lógica de negócio e comunicação entre Views e DAOs no sistema de streaming musical.

## Controllers Implementados

### 1. `ControllerCadastro`
**Responsabilidade**: Gerenciar cadastro de usuários  
**Métodos principais**:
- `salvarAluno()`: Valida e persiste novo usuário

### 2. `ControllerCurtir`  
**Responsabilidade**: Gerenciar ações de curtir/descurtir  
**Métodos principais**:
- `excluirCurtidas()`: Remove curtida de artista
- `carregarArtistasCurtidos()`: Exibe lista formatada em HTML

### 3. `ControllerExcluir`  
**Responsabilidade**: Remoção de playlists  
**Método principal**:
- `excluirPlay()`: Remove playlist do sistema

### 4. `ControllerHistorico`  
**Responsabilidade**: Gerenciar histórico de reprodução  
**Método principal**:
- `carregarUltimosHistoricos()`: Lista últimas 10 reproduções

### 5. `ControllerLogin`  
**Responsabilidade**: Autenticação de usuários  
**Método principal**:
- `loginAluno()`: Valida credenciais e inicia sessão

### 6. `ControllerOuvir`  
**Responsabilidade**: Controle de reprodução  
**Métodos principais**:
- `carregarArtistasOuvir()`: Lista artistas disponíveis
- `remover_artista()`: Remove artista da lista
- `carregarPlaylistOuvir()`: Exibe playlists formatadas

### 7. `ControllerPesquisa`  
**Responsabilidade**: Gerenciar buscas e ações relacionadas  
**Métodos principais**:
- `buscarPesquisa()`: Busca artistas no sistema
- `adicionarPesquisa()`: Adiciona novo artista
- `adicionarCurtir()`: Registra curtidas

### 8. `ControllerPlaylist`  
**Responsabilidade**: Gerenciar playlists  
**Métodos principais**:
- `adicionarPlay()`: Cria nova playlist
- `buscarTudo()`: Lista todas playlists

### 9. `ControllerUsuario`  
**Responsabilidade**: Gerenciar dados do usuário  
**Método principal**:
- `atualizar()`: Atualiza informações do usuário

## Padrões Implementados
- MVC (Model-View-Controller)
- Injeção de Dependência (conexão DB)
- Try-with-resources (auto-close connections)


# 📦 Model Classes - Projeto SpotiFei

## Visão Geral
Classes que representam as entidades do sistema de streaming musical, seguindo o padrão Java Beans com getters/setters.

## Modelos Implementados

### 1. `Cliente`
**Atributos**:
- `nome` (String)
- `usuario` (String) 
- `senha` (String)

**Métodos**:
- Construtores padrão e parametrizado
- Getters e setters para todos atributos

### 2. `Curtir`  
**Atributo**:
- `nome` (String) - Nome do artista curtido

**Métodos**:  
- Construtores padrão e com parâmetro
- Getter/setter padrão

### 3. `Historico`  
**Atributo**:
- `nome` (String) - Item do histórico

**Métodos**:
- Construtores básicos
- Acesso controlado ao atributo

### 4. `Ouvir`  
**Atributo**:  
- `nome` (String) - Artista/playlist a ser ouvida

**Características**:
- Modelo simples com operações básicas

### 5. `Pesquisa`  
**Atributo**:
- `nome` (String) - Termo pesquisado

**Métodos**:
- Implementação Java Beans padrão

### 6. `Playlist`  
**Atributos**:
- `nome` (String)
- `musica1` a `musica5` (String) 
- `usuario` (String)

**Métodos**:
- Construtores completos
- Getters/setters para todas músicas
- Controle de usuário associado

## Padrões Utilizados
- Java Beans (atributos privados + getters/setters)
- Encapsulamento rigoroso
- Construtores múltiplos (padrão + parametrizado)



