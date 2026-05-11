TP2 - Encapsulation



\## Objectif

Introduction de l’encapsulation et des validations pour sécuriser les données réseau.



\## Notions étudiées

\- private : protection des attributs.

\- getters : lecture contrôlée.

\- setters : modification avec validation.

\- validation : vérification des données (ex: masque entre 0 et 32).

\- this : référence à l'instance courante.



\## Tests réalisés

\- Test de création d'IP vide (résultat attendu : 0.0.0.0).

\- Test de masque CIDR à 55 (résultat attendu : forcé à 24).

\- Test de nom d'équipement vide (résultat attendu : "Inconnu").

\- Test de la méthode estAdresseLocale() avec "192.168.1.1".



\## Difficultés rencontrées

\- Compréhension de la structure des accolades dans les setters.

\- Configuration initiale de Git pour signer les commits.



\## Réponses aux questions



1. Pourquoi private ? **Pour empêcher que des parties externes du programme ne modifient les données de manière anarchique ou incorrecte.**



2\. Différence Public/Privé : **Un attribut public est accessible partout. Un attribut privé n'est accessible que par les méthodes de sa propre classe.**



3\. Rôle des Getters/Setters : **Les getters permettent de lire une donnée privée de manière sécurisée. Les setters permettent de modifier une donnée en y appliquant des règles de validation.**



4\. Importance en réseau : **Les configurations réseau (IP, masques) sont sensibles. Une erreur de saisie peut bloquer toute une infrastructure.**



5\. Rôle de this : **Il sert à lever l'ambiguïté entre un attribut de la classe et un paramètre de méthode qui porte le même nom.**



6\. Appel des setters dans le constructeur : **Pour s'assurer que même lors de la création de l'objet, les données sont validées immédiatement.**



7\. Validation du masque CIDR : **Un masque hors de la plage 0-32 est mathématiquement impossible en IPv4 et ferait échouer les calculs réseau.**



8\. Sécurité logicielle : **L'encapsulation limite la "surface d'attaque" en cachant les détails internes et en filtrant toutes les entrées utilisateur.**

