## Desafio de Projeto: 


### Diagrama de Classe:

```mermaid
classDiagram
    class User {
        -Long id
        -String name
        -String email
        -String cpf
        -Endereco endereco
        -List~ServicePackage~ packages
    }

    class Endereco {
        -String rua
        -String numero
        -String cidade
        -String estado
        -String cep
    }

    class ServicePackage {
        <<interface>>
    }

    class MobilePackage {
        -Long id
        -String name
        -double price
        -User user
        -int dataLimit
    }

    class TVPackage {
        -Long id
        -String name
        -double price
        -User user
        -int channelCount
    }

    class BroadbandPackage {
        -Long id
        -String name
        -double price
        -User user
        -int speed
    }

    User "1" --> "0..*" ServicePackage : possui
    User *-- Endereco : tem um
    ServicePackage <|.. MobilePackage : implements
    ServicePackage <|.. TVPackage : implements
    ServicePackage <|.. BroadbandPackage : implements
```