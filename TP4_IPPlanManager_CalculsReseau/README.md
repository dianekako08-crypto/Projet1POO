**# TP4 - Calculs réseau**



**## Objectif**

&#x20;L'objectif de ce TP est l'introduction des calculs automatiques réseau au sein de l'application IPPlan-Manager, en utilisant des méthodes statiques et des classes utilitaires.



**## Notions étudiées**

\- \*\*Méthodes statiques\*\* : Utilisation du mot-clé `static` pour créer des fonctions accessibles sans instancier la classe.

\- \*\*Calculs réseau\*\* : Automatisation du calcul du nombre d'hôtes (2^(32-CIDR)-2).

\- \*\*CIDR\*\* : Manipulation du format de routage sans classe.

\- \*\*Logique algorithmique\*\* : Analyse des octets d'une adresse IP pour déterminer sa classe et son type (public/privé).

\- \*\*Classes utilitaires\*\* : Création d'une classe `CalculateurReseau` regroupant toute la logique métier.



**## Tests réalisés**

Les tests suivants ont été effectués avec succès dans la classe `Main` :

1\. \*\*Validation des classes\*\* : Détection automatique de la Classe C (192.168.1.0), Classe B (172.16.0.0) et Classe A (10.0.0.0).

2\. \*\*Calcul de capacité\*\* : Vérification que le masque /24 donne 254 hôtes et le masque /8 donne plus de 16 millions d'hôtes.

3\. \*\*Détection du type\*\* : Confirmation que les adresses privées sont bien identifiées comme "Réseau Privé".

4\. \*\*Masques décimaux\*\* : Conversion correcte du CIDR en format décimal pointé (ex: 24 -> 255.255.255.0).



**## Difficultés rencontrées**

\- La manipulation de la méthode `Math.pow()` qui nécessite une conversion de type (cast) en `int`.

\- Le découpage de l'adresse IP avec `split("\\\\.")` qui nécessite un double antislash pour être interprété correctement en Java.

\- L'organisation de la classe utilitaire pour qu'elle soit parfaitement indépendante des autres objets.



**## Réponses aux questions**



1\. Pourquoi a-t-on créé une classe utilitaire ?



Pour centraliser tous les calculs mathématiques et logiques du réseau au même endroit. Cela rend le code plus propre, réutilisable et facile à tester sans avoir à manipuler des objets complexes.



2\. Quel est le rôle du mot-clé static ?



Il permet de définir des méthodes qui appartiennent à la classe elle-même et non à une instance particulière. On peut ainsi appeler `CalculateurReseau.calculerNombreHotes()` sans faire de `new`.



3\. Pourquoi les calculs réseau sont-ils importants dans un outil IPAM ?



Ils permettent d'éviter les erreurs humaines lors de la planification, de garantir qu'aucun hôte ne dépasse la capacité du sous-réseau et d'optimiser l'attribution des adresses.



4\. Quelle est l’utilité du CIDR ?



Le CIDR permet une notation plus compacte et flexible des masques de réseau, facilitant la lecture et la configuration des équipements par rapport à l'ancien système de classes rigides.



5\. Pourquoi le nombre d’hôtes dépend-il du masque réseau ?



Le masque détermine la portion de l'adresse (les bits) réservée aux machines. Plus le masque est petit, plus il reste de bits pour les hôtes, ce qui augmente exponentiellement la capacité.



6\. Pourquoi certaines adresses IP sont-elles privées ?



Elles permettent de créer des réseaux locaux sans consommer d'adresses IP publiques (qui sont limitées). Elles renforcent aussi la sécurité car elles ne sont pas directement accessibles depuis Internet.



7\. Pourquoi la séparation entre logique métier et logique de calcul améliore-t-elle le projet ?



Cela respecte le principe de responsabilité unique. Si la manière de calculer change demain, on ne modifie que le calculateur, sans toucher aux classes `ReseauIP` ou `Equipement`.



8\. Pourquoi les outils de planification réseau doivent-ils automatiser les calculs ?



L'automatisation garantit la rapidité et la fiabilité, surtout dans de grandes infrastructures où calculer manuellement des dizaines de sous-réseaux deviendrait source de pannes graves.

