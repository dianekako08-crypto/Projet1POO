**# TP3 - Collections et composition**



**## Objectif**

L'objectif de ce TP est l'introduction des collections pour gérer la multiplicité des objets et l'approfondissement de la notion de composition pour modéliser des structures complexes.



**## Notions étudiées**

\- \*\*Composition\*\* : Relation entre objets où un objet "contient" d'autres objets.

\- \*\*ArrayList\*\* : Utilisation d'une liste dynamique pour stocker des objets.

\- \*\*Parcours de listes\*\* : Utilisation de la boucle for-each pour traiter les données.

\- \*\*Encapsulation avancée\*\* : Validation des données et accès aux collections.



**## Tests réalisés**

L'exécution de la classe `Main` a permis de valider :

1\. La création d'une infrastructure contenant 3 sous-réseaux et 1 réseau WiFi.

2\. La gestion d'équipements multi-interfaces (ex: Serveur avec 2 ports Ethernet).

3\. La création dynamique de 5 équipements clients via une boucle.

4\. Le bon fonctionnement de la méthode `rechercherEquipement` (cas trouvé et cas inexistant).



**## Difficultés rencontrées**

\- La gestion des types de paramètres dans les constructeurs entre `ReseauIP` et `SousReseau`.

\- La résolution des erreurs de compilation liées à l'oubli de l'import `java.util.ArrayList`.

\- Le positionnement correct des accolades pour l'insertion de la nouvelle méthode de recherche.



**## Réponses aux questions**



1\. \*\*Qu’est-ce qu’une composition en POO ?\*\*

C'est une relation entre classes où une classe "contient" une ou plusieurs instances d'une autre classe. C'est une relation de type "possède un" (has-a). Si l'objet parent est détruit, les objets composants le sont généralement aussi.



2\. \*\*Pourquoi utilise-t-on ArrayList dans ce TP ?\*\*

On utilise `ArrayList` car contrairement à un tableau classique, sa taille est dynamique. Elle permet d'ajouter autant d'équipements ou d'interfaces que l'on souhaite sans connaître leur nombre à l'avance.



3\. \*\*Quelle différence existe entre une variable simple et une collection ?\*\*

Une variable simple ne peut stocker qu'une seule valeur ou un seul objet à la fois (ex: une seule interface). Une collection peut stocker un groupe d'objets de même type, permettant de gérer des listes.



4\. \*\*Pourquoi un équipement possède-t-il plusieurs interfaces ?\*\*

Dans un réseau réel, un équipement comme un routeur ou un serveur peut être connecté à plusieurs réseaux différents simultanément (ex: une interface WiFi et une interface Ethernet).



5\. \*\*Pourquoi une infrastructure réseau contient-elle plusieurs sous-réseaux ?\*\*

Pour segmenter le trafic (sécurité, performance). Une entreprise sépare généralement le réseau de l'administration, celui des techniciens et celui du public (WiFi).



6\. \*\*Quel est le rôle de la boucle for-each ?\*\*

Elle permet de parcourir facilement tous les éléments d'une collection (comme une `ArrayList`) du premier au dernier sans utiliser d'index, ce qui rend le code plus lisible et moins sujet aux erreurs.



7\. \*\*Pourquoi la classe InfrastructureReseau devient-elle importante dans le projet ?\*\*

Elle joue le rôle de "cerveau" ou de conteneur global. C'est elle qui centralise tous les composants du réseau, permettant ainsi d'effectuer des opérations globales comme la recherche d'un équipement sur tout le parc informatique.



8\. \*\*Pourquoi les collections sont-elles indispensables dans les applications professionnelles ?\*\*

Car les applications réelles traitent des volumes de données variables (listes de clients, de factures, de capteurs). Les collections offrent la flexibilité et les méthodes nécessaires (tri, recherche, ajout) pour gérer ces données efficacement.

