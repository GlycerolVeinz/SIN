# library problem

## Keywords
- Library
    - max 5 books of same kind
- Book
    - (can have more then one author)
    - only one Publisher 
- Author
    - contract (/w Publisher)
    - (writes books for publishers)
- Publisher


```mermaid
classDiagram
class Library{
    -String name
}

class Book {
    -String isbn 
    %% check ISBN when inputed to Library
    -String name
    -Date published 
    %%check less then 5 
}

class Publisher{
    -String name
}

class Author{
    -String name
    -String surname
    -String email
}

class Address{
    -Int homeNumber
    -String city
    -String street
}

class Genre{
    -String name
}

Author "1" --> "1" Address 
Author "0..*" -- "0..*" Publisher : "contract"
Author "0..*" -- "1..*" Book : "authorship"

Publisher "1" --> "1" Address
Library "1" --> "1" Address

Book "0..*" -- "1" Publisher
Book "0..*" -- "1" Genre : "has"
Book "0..*" <-- "0..1" Library : "owns" 
```

