#### **TP7 - Validations avancées et détection des conflits**



**Objectif**

L'objectif de ce TP était de renforcer la robustesse de l'outil IPPlan-Manager en intégrant un système de gestion d'erreurs sophistiqué. Il s'agissait de détecter automatiquement les incohérences techniques (IP invalides, chevauchements de réseaux, doublons de VLAN) avant qu'elles ne soient appliquées sur une infrastructure réelle.



**Notions étudiées**

* Exceptions personnalisées : Création de classes héritant de Exception pour des erreurs métier spécifiques.
* Gestion des erreurs : Utilisation des mots-clés try, catch, throw et throws.
* Validation Réseau : Vérification de la conformité des adresses IPv4.
* Algorithmique de détection : Calcul de plages IP (début/fin) pour identifier les chevauchements (overlaps).
* Robustesse : Séparation de la logique de calcul (Moteur) et de la logique de contrôle (Validateur).



**Scénarios testés**



Génération normale : Création d'un plan VLSM sans erreur.



IP Invalide : Test avec une adresse hors plage (ex: 192.168.300.0).



Chevauchement de réseaux : Création manuelle de deux réseaux qui se partagent les mêmes adresses (ex: un /25 et un /26 sur la même plage).



Conflit VLAN : Tentative d'attribution d'un même ID à deux VLANs différents.



Capacité insuffisante : Test d'un besoin de 500 hôtes sur un réseau de départ de type /24 (254 hôtes).



**Résultats obtenus**

L'application ne "plante" plus de manière brute. Lorsqu'une erreur est détectée, elle affiche un message clair et explicatif :



\[ERREUR] Conflit VLAN : l'identifiant 10 est déjà utilisé.



\[ERREUR] Chevauchement détecté entre TECHNIQUE et WIFI.



\[ERREUR] Capacité insuffisante : Besoin (500) dépasse la limite du réseau.



**Difficultés rencontrées**

* Gestion des types : La conversion des adresses IP en int peut poser des problèmes de signe en Java (nombres négatifs). L'utilisation des opérateurs bit à bit (>>>, \&) a été nécessaire.
* Cohérence des méthodes : S'assurer que le MoteurVLSM et le Validateur utilisent les mêmes méthodes de conversion du CalculateurReseau.



**Réponses aux questions**



1\. Pourquoi les validations avancées sont-elles indispensables dans un outil IPAM ?  Un outil IPAM (IP Address Management) est le garant de la stabilité du réseau. Les validations avancées sont indispensables pour empêcher les erreurs humaines (doublons, fautes de frappe, mauvais calculs de masques) qui pourraient causer des pannes massives, des conflits d'adresses ou des failles de sécurité sur une infrastructure réelle.



2\. Quelle est la différence entre une erreur simple et une exception en Java ?  Une erreur simple (souvent gérée par des if/else) traite un cas prévisible localement. Une exception est un événement qui "rompt" le flux normal d'exécution du programme. Contrairement à une simple vérification, l'exception permet de transférer le contrôle à une autre partie du programme (le bloc catch) pour gérer l'anomalie de manière structurée.



3\. Pourquoi crée-t-on des exceptions personnalisées ?  On crée des exceptions personnalisées (comme ReseauInsuffisantException) pour rendre le code plus explicite et sémantique. Cela permet au développeur de savoir exactement quel type de problème métier est survenu, plutôt que d'avoir une erreur générique comme Exception ou RuntimeException.



4\. Quel est le rôle du bloc try/catch ?  Le bloc try sert à isoler une portion de code susceptible de générer une erreur (de "tenter" l'action). Le bloc catch sert à "attraper" l'exception si elle survient, afin de la traiter (afficher un message, journaliser l'erreur) sans que le programme ne s'arrête brutalement.



5\. Pourquoi deux VLANs ne doivent-ils pas avoir le même identifiant dans une même infrastructure ?  L'identifiant de VLAN (VLAN ID) est ce qui permet aux commutateurs (switches) de séparer le trafic de couche 2. Si deux VLANs ont le même ID, leurs domaines de diffusion fusionnent, ce qui entraîne des fuites de données entre services, des conflits d'adresses IP et l'échec de la segmentation réseau.



6\. Pourquoi deux sous-réseaux ne doivent-ils pas se chevaucher ?   Le chevauchement (overlap) crée une ambiguïté dans la table de routage. Si une même adresse IP appartient à deux réseaux différents, les routeurs ne peuvent pas déterminer la destination correcte des paquets, ce qui rend le réseau instable et empêche la communication.



7\. Pourquoi transforme-t-on les adresses IP en entiers pour comparer des plages réseau ?  Comparer des chaînes de caractères (ex: "192.168.1.2" vs "192.168.1.10") est complexe car l'ordre alphabétique ne respecte pas la hiérarchie numérique des adresses. En transformant l'IP en un entier de 32 bits, on peut utiliser des opérateurs mathématiques simples pour vérifier instantanément si une adresse se trouve dans une plage donnée.



8\. Pourquoi la classe ValidateurPlanAdressage doit-elle être séparée du moteur VLSM ?   Cela respecte le Principe de Responsabilité Unique (S.O.L.I.D). Le MoteurVLSM doit uniquement s'occuper de l'algorithme de calcul. La classe ValidateurPlanAdressage s'occupe uniquement du contrôle de cohérence. Cette séparation rend le code plus facile à maintenir, à tester et à faire évoluer.

