#### **TP5 - Moteur VLSM**

**Objectif**

Développer un moteur VLSM capable de proposer automatiquement un plan d'adressage IP optimisé à partir d'une liste de besoins (nombres d'hôtes) exprimés par l'utilisateur.



**Notions étudiées**

* VLSM (Variable Length Subnet Mask) : Segmentation de réseau à longueur variable.
* Tri de collections : Utilisation de Comparator pour classer les besoins par ordre décroissant.
* Classe de service métier : Centralisation de la logique algorithmique dans MoteurVLSM.
* Calcul CIDR : Détermination automatique du masque le plus court pour un besoin donné.
* Manipulation d'IP : Conversion entre format String et int pour les calculs arithmétiques.



**Scénarios testés**

Petite Entreprise : WIFI\_INVITES (40), ADMIN (25), COMPTABILITE (12), SERVEURS (8).



Campus Universitaire : ETUDIANTS (500), WIFI\_PUBLIC (200), PERSONNEL (120), LABORATOIRE (60), ADMINISTRATION (40).



**Résultats obtenus**

Les plans d'adressage générés respectent strictement la hiérarchie des besoins. Pour chaque sous-réseau, le moteur fournit :



L'adresse réseau et son CIDR.



Le masque décimal.



La plage d'adresses utilisables (Première - Dernière).



La capacité réelle du sous-réseau.



**Difficultés rencontrées**

Gestion de la conversion des octets d'une IP pour éviter les erreurs lors du passage à un nouveau bloc (ex: passage de .255 à .0 dans l'octet suivant).



Synchronisation des méthodes statiques entre le CalculateurReseau et le MoteurVLSM.



**Réponses aux questions**

1\. Pourquoi le VLSM permet-il d’économiser les adresses IP ?



Contrairement au subnetting classique qui impose un masque fixe, le VLSM adapte la taille de chaque sous-réseau au besoin réel. Cela évite de gaspiller des milliers d'adresses (par exemple, utiliser un masque /24 de 254 hôtes pour un besoin de seulement 10 machines).



2\. Pourquoi faut-il traiter les plus grands besoins en premier ?



C'est la règle d'or du VLSM. En commençant par les plus grands blocs, on s'assure qu'ils tiennent dans l'espace d'adressage sans fragmenter le réseau de manière inefficace, ce qui permet de coller les sous-réseaux les uns après les autres sans chevauchement.



3\. Quelle est la différence entre un besoin réseau et un résultat VLSM ?



Le Besoin est une donnée d'entrée (ce que l'utilisateur veut : "Comptabilité, 12 hôtes"). Le Résultat est une donnée de sortie calculée par le moteur (l'adresse exacte, le masque, et la plage d'IP attribuée).



4\. Pourquoi la classe MoteurVLSM est-elle une classe de service métier ?



Parce qu'elle ne stocke pas de données permanentes, mais contient "l'intelligence" du programme. Son rôle est de rendre un service : transformer une liste brute de besoins en un plan d'adressage cohérent.



5\. Pourquoi transforme-t-on une adresse IP en entier pour certains calculs ?



Une adresse IP en texte (192.168.1.1) est difficile à manipuler mathématiquement. En la transformant en un nombre entier de 32 bits, on peut simplement faire +1 pour trouver l'adresse suivante ou ajouter la taille d'un bloc pour passer au sous-réseau suivant.



6\. Quel est le rôle de la méthode calculerCidrPourHotes() ?



Elle détermine le masque le plus petit possible qui peut contenir le nombre d'hôtes demandé. Elle cherche la puissance de 2 immédiatement supérieure au besoin (en incluant l'adresse réseau et le broadcast).



7\. Pourquoi une adresse de réseau et une adresse de broadcast ne sont-elles pas attribuées aux machines ?



L'adresse réseau sert d'identifiant pour le groupe entier (la "rue"), et l'adresse de broadcast est réservée pour envoyer un message à toutes les machines du sous-réseau simultanément. Les utiliser sur une machine créerait des conflits de routage.



8\. Pourquoi le moteur VLSM représente-t-il une étape importante dans le projet IPPlan-Manager ?



C'est le cœur algorithmique du projet. Sans ce moteur, le logiciel n'est qu'une simple calculatrice. Avec lui, il devient un outil d'automatisation capable de concevoir l'architecture réseau complète d'une infrastructure.

