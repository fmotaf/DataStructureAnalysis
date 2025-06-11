# DataStructureAnalysis 📊

Projeto acadêmico em Java para análise de desempenho de estruturas de dados e algoritmos de ordenação, com foco em tempo de execução e complexidade. Inclui uma lista duplamente encadeada e diferentes métodos de ordenação como Bubble Sort.

---

## 📂 Estrutura do Projeto

```
DataStructureAnalysis/
├── dataSample/ # Arquivos de entrada com dados dos estudantes (CSV, etc)
│ └── updated_student_habits_performance.csv # Base de dados de testes (nome, idade, nota, etc)
│
├── main/ # Classes que representam os dados
│ └── StudentData.java # Classe com atributos do aluno (nome, idade, nota, etc)
│ ├── Link.java # Nó da lista duplamente encadeada
│ └── DoublyLinkedList.java # Implementação da lista com métodos de ordenação
│ └── CSVReader.java # Lê e carrega dados do arquivo CSV para a lista
│ └── Main.java # Classe principal que executa a leitura, ordenação e medição de tempo
│
├── test/ # Testes unitários
│ └── TestCSVReader.java # Testes para a classe CSVReader (Verifica se os dados são lidos corretamente)
│ └── TestDoubleLinkedList.java # Testes para a lista duplamente encadeada 
│ └── TestSudentDataLoader.java # Testes para a classe StudentDataLoader (Verifica se os dados são carregados corretamente)
│
└── README.md # Documentação do projeto
```


## 🚀 Como executar

### ✅ Requisitos

- Java 11 ou superior
- (Opcional) IDE como IntelliJ IDEA ou VSCode

### ▶️ Passos para rodar:

```bash
git clone https://github.com/fmotaf/DataStructureAnalysis.git
cd DataStructureAnalysis
javac Main.java
java Main
```

🧠 Funcionalidades
Leitura de dados de um arquivo CSV com informações de estudantes.

Armazenamento dos dados em uma lista duplamente encadeada.

Implementação de algoritmos de ordenação:

Bubble Sort genérico com Comparator

Ordenação por idade (via método fixo)

Medição do tempo de execução de cada ordenação (em milissegundos e nanossegundos).

⏱ Exemplo de saída (Bubble Sort por idade)
```
(BubbleSort) Tempo para ordenar por idade: 0.493 ms
````

```
long start = System.nanoTime();
// ordenação
long end = System.nanoTime();
double elapsedMs = (end - start) / 1_000_000.0;
System.out.printf("Tempo: %.3f ms\n", elapsedMs);
```

📄 Sobre os arquivos
```
StudentData.java: Contém os atributos e métodos de acesso dos estudantes.

DoublyLinkedList.java: Lista duplamente encadeada com métodos insert, display, sort, etc.

Link.java: Representa cada nó com referências prev e next.

CompareBy...: Classes que implementam Comparator<StudentData> para diferentes critérios.

CSVReader.java: Lê o arquivo de dados e carrega os alunos na lista.

Main.java: Responsável por orquestrar leitura, ordenação e medição de tempo.
```

## 🚧 Dificuldades Encontradas

Durante o desenvolvimento do projeto, algumas dificuldades foram identificadas:

- **Precisão na medição do tempo de execução**  
  A utilização de `System.currentTimeMillis()` apresentou baixa precisão para operações rápidas como o Bubble Sort com listas pequenas. A solução foi utilizar `System.nanoTime()` e converter para milissegundos com casas decimais.

- **Desempenho surpreendentemente alto**  
  Foi observado que a ordenação de listas com até 11.000 elementos via Bubble Sort estava sendo concluída em menos de 10ms. Isso levantou dúvidas sobre a veracidade dos tempos, mas testes repetidos confirmaram a consistência. Provavelmente, isso se deve à eficiência do código Java em execução local (sem I/O ou GC no caminho crítico).

- **Evitar uso de `Collections.sort()` ou `Arrays.sort()`**  
  Por se tratar de um exercício de estrutura de dados personalizada, optou-se por não utilizar estruturas prontas da API Java, mesmo que mais eficientes, para manter o foco didático.

- **Troca de nós versus troca de dados**  
  Inicialmente considerou-se fazer a troca de nós na ordenação, mas optou-se por trocar os dados dentro dos nós para simplificar a lógica e evitar bugs com ponteiros `prev`/`next`.

- **Leitura de arquivos CSV com formatação inconsistente**  
  Alguns arquivos CSV continham formatações inesperadas, o que exigiu um tratamento mais robusto na classe `CSVReader`.

## 🙋‍♂️ Autores:

- **Fernando Mota** - [fmotaf](https://github.com/fmotaf)
- **Bruno Melo** - [brunomelodev](https://github.com/BrunoOliMelo)
- **Daniel Menezes** - [danielmenezesjj](https://github.com/danielmenezesjj)