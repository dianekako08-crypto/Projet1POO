### **TP8 - Moteur de recommandations**



**Objectif**

L'objectif de ce TP était d'intégrer une couche d'intelligence à l'application IPPlan-Manager. Au-delà de la simple validation technique, l'outil est désormais capable d'analyser un plan d'adressage pour fournir des conseils stratégiques et de sécurité basés sur des règles métier prédéfinies.



**Notions étudiées**

Interfaces Java : Utilisation d'un contrat commun (RegleRecommandation) pour normaliser l'analyse.



Polymorphisme : Capacité du moteur à traiter différentes règles de manière générique.



Séparation des responsabilités : Distinction nette entre le calcul VLSM, la gestion des VLANs et l'analyse de recommandations.



Extensibilité : Architecture permettant d'ajouter de nouvelles règles sans modifier le code existant.



**Scénarios testés:** Nous avons testé un scénario d'infrastructure complète comprenant les besoins suivants :ADMINISTRATION : 50 hôtes (doit déclencher la règle de sécurité administrative).WIFI\_INVITES : 120 hôtes (doit déclencher l'isolation WiFi et la règle de marge d'adresse faible car $126 - 120 = 6$).SERVEURS : 20 hôtes (doit déclencher la règle de protection des données).CAMERAS : 80 hôtes.VOIP : 60 hôtes.



**Recommandations obtenues**

Le moteur a généré les conseils suivants lors de l'exécution :



* \[CRITIQUE] Sécurité Administration : "L'accès au VLAN ADMINISTRATION doit être restreint aux administrateurs réseau via des ACLs strictes."
* \[ÉLEVÉE] Isolation du WiFi : "Le VLAN WIFI\_INVITES doit être isolé par un Firewall pour protéger les réseaux internes."
* \[ÉLEVÉE] Protection Serveurs : "Le VLAN SERVEURS doit être protégé et surveillé en priorité."
* \[MOYENNE] Marge d'évolution faible : "Le VLAN WIFI\_INVITES n'a que 6 adresses de marge. Attention en cas d'ajout d'équipements."



**Difficultés rencontrées**

* Liaison des objets : Il a fallu s'assurer que l'objet VLAN contenait bien une référence vers le ResultatVLSM pour permettre à la règle RecommandationMargeAdresse d'accéder aux calculs de capacité.
* Gestion des listes : Assurer que le GestionnaireVLAN maintienne une liste persistante accessible par le moteur de recommandations.



**Réponses aux questions**



1. **Quel est le rôle d’un moteur de recommandations dans un outil IPAM ?**



Le moteur de recommandations sert d'assistant intelligent. Son rôle est d'analyser le plan d'adressage généré pour fournir des conseils stratégiques et sécuritaires (Best Practices). Il aide l'administrateur à identifier des risques potentiels que la simple validation technique ne détecte pas (ex: isolation, sécurité, optimisation).



**2. Pourquoi utilise-t-on une interface pour les règles de recommandation ?**

On utilise l'interface RegleRecommandation pour définir un contrat commun. Cela permet d'ajouter une infinité de nouvelles règles (WiFi, Serveurs, Admin, etc.) sans jamais modifier le code du MoteurRecommandation. C'est le principe d'extensibilité du code.



**3. Quelle est la différence entre une classe concrète et une interface ?**

Une classe concrète contient l'implémentation complète des méthodes (le "comment") et peut être instanciée (on peut créer un objet avec new). Une interface définit uniquement la signature des méthodes (le "quoi") sans les implémenter ; elle sert de modèle pour d'autres classes.



**4. Pourquoi la méthode analyser() peut-elle retourner null ?**



La méthode retourne null lorsqu'une règle ne s'applique pas au VLAN analysé. Par exemple, une règle qui cherche le mot "WiFi" retournera null si elle analyse un VLAN nommé "COMPTABILITE". Cela permet au moteur de ne conserver que les conseils pertinents.



**5. Pourquoi le moteur de recommandations illustre-t-il le polymorphisme ?**

Il illustre le polymorphisme car le moteur manipule une liste d'objets de type RegleRecommandation. Lorsqu'il appelle la méthode analyser(), Java exécute automatiquement la version spécifique de la méthode (WiFi, Admin, ou Marge) selon l'objet réel, sans que le moteur n'ait besoin de connaître le type précis de la règle.



**6. Pourquoi est-il préférable de créer une classe par règle au lieu de mettre tous les tests dans Main ?**

Cela respecte le principe de Responsabilité Unique. Chaque classe est indépendante, ce qui rend le code plus lisible, plus facile à tester et à maintenir. Si une règle contient une erreur, elle n'affecte pas les autres, et on peut les réutiliser dans d'autres projets.



**7. Pourquoi un VLAN WiFi invité doit-il être isolé des réseaux internes ?**

Pour des raisons de sécurité critique. Les invités (visiteurs, prestataires) ne doivent pas avoir accès aux ressources sensibles de l'entreprise (serveurs de fichiers, base de données RH). L'isolation empêche la propagation de malwares ou les tentatives d'intrusion depuis des appareils non maîtrisés.



**8. Pourquoi les VLANs de grande taille doivent-ils être surveillés ?**

Les VLANs avec beaucoup d'hôtes génèrent un volume important de trafic de broadcast (diffusion). Si ce trafic est trop élevé, il peut saturer la bande passante et ralentir les performances de tous les équipements du segment, créant ce qu'on appelle une "tempête de broadcast".



