## Desafio de Projeto: 


### Diagrama de Classe:
classDiagram
class User {
+Long id
+String name
+String email
+List~Package~ packages
}

```mermaid
class Pacage {
        <<abstract>>
        +Long id
        +String name
        +double price
        +User user
    }

    class MobilePackage {
        +int dataLimit
    }

    class TVPackage {
        +int channelCount
    }

    class BroadbandPackage {
        +int speed
    }

    User "1" --> "0..*" Package : possui
    Package <|-- MobilePackage : extends
    Package <|-- TVPackage : extends
    Package <|-- BroadbandPackage : extends
```