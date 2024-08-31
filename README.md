## Desafio de Projeto: 


### Diagrama de Classe:

```mermaid
classDiagram
    class User {
        -Long id
        -String name
        -String email
        -String cpf
        -Address address
        -List~ServicePackage~ packages
    }

    class Address {
        -String street
        -String number
        -String city
        -String state
        -String zipCode
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
    User *-- Address : has one
    ServicePackage <|.. MobilePackage : implements
    ServicePackage <|.. TVPackage : implements
    ServicePackage <|.. BroadbandPackage : implements
```
