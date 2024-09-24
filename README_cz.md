# B4B36SIN - Návrhová cvičení 2022

Stránky předmětu jsou na [moodle](https://moodle.fel.cvut.cz/).

**Kontakt na cvičící:**  
[Šebek Jiří](mailto:sebekji1@fel.cvut.cz)

---

## Popis problému

Je potřeba navrhnout a implementovat centrální informační systém pro knihovny určený pro evidenci knih. Takovýto systém eviduje knihovny, nakladatelství, knihy a autory. Autoři mají smlouvy s několika nakladatelstvími, pro které píší knihy. Nakladatelství tyto knihy vydávají. Kniha může mít více autorů a je vydána právě jedním nakladatelstvím. V knihovně může být maximálně 5 stejných knih.

- **Knihovna** má název, adresu a vlastnění knihy.
- **Kniha** má unikátní identifikátor ISBN. Při vkládání nové knihy do systému je potřeba ověřit, že její ISBN ještě není v systému obsaženo a že uvedený autor má smlouvu s uvedeným nakladatelstvím. Dále má kniha název, autory, nakladatelství, datum vydání, žánr a apod.
- **Nakladatelství** má název, adresu, autory, se kterými má smlouvu, a vydané knihy.
- **Autor** má jméno, příjmení, e-mail, napsané knihy, nakladatelství, se kterými má smlouvu, apod.

---

## Cvičení 1 - Úvod, nastavení vývojového prostředí, základy, Vytvoření projektu

1. Stáhněte si a nainstalujte si vývojové prostředí:
   - IntelliJ IDEA Ultimate
   - JDK 8 a vyšší (JRE vs JDK)
   - Git a nějaký nástroj (GIT bash, cygwin, terminal)
   - Maven:
     - Pro ověření v terminálu proveďte `mvn -v`
     - Je potřeba nastavit systémové proměnné PATH a JAVA_HOME
   - PostgreSQL (nepovinné pokud nechcete dělat v H2):
     - Pro ověření se připojte k databázi přes terminál nebo pgAdmin

2. Vytvořte nový Maven projekt, do kterého během semestru postupně naimplementujete všechny úkoly.
   - Použijte `springboot init` a stáhněte si kostru aplikace: [https://start.spring.io/](https://start.spring.io/)

3. Zopakujte si rozdíly:
   - ANT vs MAVEN vs GRADLE
   - xml vs JSON vs html
   - java se vs java ee
   - run vs deploy (`mvn clean`, `mvn install`, `mvn package`...)

   [moodle](https://moodle.fel.cvut.cz/)  
   [postgresql](https://www.postgresql.org/)  
   [maven](https://maven.apache.org/)  
   [git-scm](https://git-scm.com/)  
   [oracle jdk8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
   [jetbrains idea](https://www.jetbrains.com/idea/)

4. Navrhněte datový model v UML class diagramu.
   - GIT
   - mvn příkazy

## Cvičení 2 - Implementace modelu, UML class diagram

1. Podle návrhu z cvičení 1 implementujte ORM v jazyce Java.
   - Použijte projekt z minulého cvičení.
   - **Java Persistence API**  
     Doimplementujte BO vrstvu (business object) – JPA:
     - přidejte závislosti do `pom.xml`
     - vytvořte třídy, atributy
     - gettery, settery (nebo použijte Lombok)  
       [https://projectlombok.org/features/GetterSetter](https://projectlombok.org/features/GetterSetter)
   - Implementujte vztahy mezi třídami (1:N, N:M, 1:1...)  
     [https://www.baeldung.com/jpa-many-to-many](https://www.baeldung.com/jpa-many-to-many)

   - Zjistěte, co znamenají parametry `fetch` a `mappedBy`.  
   
   ```java
   @ManyToMany(fetch = FetchType.LAZY, mappedBy = "entity2")
   private List<Book> entity;
   ```
   - Bean Validation (@NotNull)
   - Aplikaci můžete spouštět buď přes IDE nebo přes konzoli pomocí Maven příkazů:
     - `mvn clean`
     - `mvn install`
     - `mvn package`
     - `mvn deploy`

2. Navrhněte datový model v UML class diagramu, který reprezentuje strukturu aplikace.

3. Implementujte DAO vrstvu nebo repository s CRUD operacemi:
   - Použijte Spring Boot repository nebo DAO.
   - DAO musí mít interface a implementaci:
     - Dodržujte jmennou konvenci “BookDAO” pro interface a “BookDAOImpl” pro implementaci.
     - Můžete využít `GenericDAO`:  
       [https://github.com/slowercz/SIN-project-example/blob/master/src/main/java/cz/cvut/fel/cs/sin/dao/GenericDAO.java](https://github.com/slowercz/SIN-project-example/blob/master/src/main/java/cz/cvut/fel/cs/sin/dao/GenericDAO.java)

       [https://github.com/slowercz/SIN-project-example/blob/master/src/test/java/cz/cvut/fel/cs/sin/service/PersonRegistrationTest.java](https://github.com/slowercz/SIN-project-example/blob/master/src/test/java/cz/cvut/fel/cs/sin/service/PersonRegistrationTest.java)

4. h2 dependency
   [https://www.baeldung.com/spring-boot-h2-database](https://www.baeldung.com/spring-boot-h2-database)

5. zkontrolujte H2-postgre db
   [https://www.baeldung.com/spring-boot-h2-database](https://www.baeldung.com/spring-boot-h2-database)

## Cvičení 3 - Implementace servis, UML diagram nasazení

1. Navrhněte systémové operace a popište je pomocí UML sekvenčních diagramů.
   - Služby implementují byznys operace, např. přidání knihy do knihovny. Ke své práci využívají DAO/repository objekty a entity, které jsme vytvořili v předchozích cvičeních.
   - Popište následující tři služby:
     - Autor uzavře smlouvu s nakladatelstvím.
     - Nakladatelství vydá novou knihu.
     - Přidání knihy do knihovny.

2. Implementujte service layer:
   - Implementujte všechny tři služby ze sekvenčního diagramu.
   - Služba má interface a implementaci.

3. Loggujte do Loggeru:
   - Rozdělte hlášky na typy: error, warning, debug, info, trace.

4. Popište logickou strukturu aplikace pomocí UML diagramu nasazení.

5. Otestujte všechny metody service layer pomocí Junit tests:
   - [PersonRegistrationTest](https://github.com/slowercz/SIN-project-example/blob/master/src/test/java/cz/cvut/fel/cs/sin/service/PersonRegistrationTest.java)

---

**Verze pro A,B:**
- Verzování: SNAPSHOT, RC1, env (dev, test, prod)
- Začněte používat verzování v projektu:
  - `mvn versions:set -DnewVersion=0.0.3-SNAPSHOT`
  - `0.0.1-SNAPSHOT` pro cv1, `0.0.2-SNAPSHOT` pro cv2.
  - Odevzdání bude PROD verze (bez SNAPSHOT).
  - Verzování DB (flyway, liquibase):  
    [https://www.baeldung.com/liquibase-refactor-schema-of-java-app](https://www.baeldung.com/liquibase-refactor-schema-of-java-app)

## Cvičení 4 - Controllers... RMI, REST, beans

1. Vyzkoušejte různé přístupy:
   - Java RMI, SOAP, REST, GraphQL, bean approach.

2. Implementujte controller layer pro vytvořenou service layer.

3. Proveďte statickou analýzu kódu:
   - Použijte např. FindBugs nebo SpotBugs:
     - [FindBugs](http://findbugs.sourceforge.net/)
     - [SpotBugs](https://spotbugs.github.io/)
   - Odevzdávejte:
     - Výpis před opravou bugů.
     - Výpis po opravě bugů.

4. Interceptory – logování délky requestů.

5. Mapování BO na DTO objekty – mapstruct.

---

**Verze pro A,B:**
- Mockování endpointů:
  - Mockresponse anotace.
  - Endpoint vrací statický obsah (neřeší se hlavičky a jiné nastavení).
  - [Retromock Retrofit Calls](https://infinum.com/blog/retromock-retrofit-calls/)

## Cvičení 5 - Testy controller a service

1. Bezpečnost (autorizace, autentifikace):
   - [Spring Security](https://www.baeldung.com/security-spring)

2. Mockito pro testování:
   - [Mockito Annotations](https://www.baeldung.com/mockito-annotations)

3. Cache:
   - [Hazelcast Cache](https://www.baeldung.com/java-hazelcast)
   - Všechny backendové volání uložte do cache (TTL 10 minut max).
   - [Spring Boot Evict Cache](https://www.baeldung.com/spring-boot-evict-cache).

---

**Verze pro A,B:**
- U cache přidejte eviktování (jednotlivých i všech).
- Implementujte job, který každou minutu kontroluje, zda jsou data v cache platná a případně je aktualizuje:
  - [Spring Scheduled Tasks](https://www.baeldung.com/spring-scheduled-tasks)

## Cvičení 6 - Konzultace, odevzdávání, ukázka

1. Konzultace.

2. Speciality:
   - CI/CD, Helm, ukázka z reálného projektu.

---

**Verze pro A,B:**
- Kafka:
  - [Spring Scheduled Tasks](https://www.baeldung.com/spring-scheduled-tasks)
  - [Spring Boot Evict Cache](https://www.baeldung.com/spring-boot-evict-cache)
  - [Java Hazelcast](https://www.baeldung.com/java-hazelcast)
  - [Hazelcast Blog](https://hazelcast.com/blog/spring-boot/)
  - [Mockito Annotations](https://www.baeldung.com/mockito-annotations)
