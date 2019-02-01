# Programmation concurrente en Java
## Définitions
### Processus  
Un processus est un programme (ensemble d'instructions) en cours d'exécution, Un serveur exécute généralement plusieurs processus de façon quasi simultanée et qui sont totalement isolés les uns des autres, chaque processus possède ces propores ressources (mémoires, temps processeur,...).   
### Thread  
Un Thread est la plus petite unité d'excution (ensemble d'instructions) contenue dans un processus. Les threads d’un même processus partagent la même zone mémoire mais ils possèdent leur propre pile d'exécution. 

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Thread.png)  

### Ordonnanceur  

L’ordonnanceur/scheduler est un composant du noyau du système d'exploitation choisissant l'ordre d'exécution des processus/threads.


## Création des threads en java   

### Création par héritage de la classe Thread  
La classe Thread peut être utilisée pour créer et démarrer un nouveau thread, les étapes de création des instances sont:  

- Création d’une classe qui hérite de la classe Thread: ```` class MyThread extends Thread ````

- Redéfinition de la méthode run(): ````public void run() {...} ````

- Invocation de la méthode start() de l’instance créée:  ````  myThread.start() ```` 



### Création par implémentation de l'interface Runnable  
Lorsqu’on utilise la méthode précédente pour créer des Threads on perd la flexibilité d'hériter d'une autre classe, pour contourner ce problème, au lieu d'étendre la classe Thread, on utilise l’implémentation de l'interface Runnable. les étapes de création d'une instance Thread:

- Création d’une classe implémentant l’interface Runnable: ````class MyRunnable implements Runnable````   

- Implémentation de la méthode run(): ````public void run() {...} ````  

- Instanciation d’un Objet Thread en passant l’instance Runnable au constructeur:  
```` Thread myThread = new Thread(new Sing());```` 

- Invocation de la méthode start() de l’instance créée: ````  myThread.start() ````  




## Cycle de vie d’un Thread   

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Thread_lifecycle.png)  

### Lancer le thread   
Appel de la méthode start()  

### Suspendre l’exécution du Thread  
Un thread peut suspendre son exécution soit suite à l'appel d'une méthode explicite ou suite à l'expiration de la durée du temps processeur.  
- L’ordonnanceur déplace un thread de l'état RUNNING vers READY pour prendre en charge le traitement simultané des threads 
- Appel de la méthode yield() : La méthode statique yield() oblige le thread en cours d’exécution à suspendre son exécution et à abandonner son utilisation actuelle du processeur (passe à l’état READY aussi Il est possible que l’ordonnanceur peut aussi l'ignorer)
- Appel de la méthode sleep() : la méthode statique Thread.sleep() force le thread en cours d'exécution à abandonner temporairement son exécution pendant au moins le nombre de millisecondes (et de nanosecondes) spécifié et à passer à l'état TIMED_WAITING.
- Appel de la méthode JOIN() : La méthode join () garantit que le thread appelant n’exécutera pas son code restant jusqu'à ce que le thread sur lequel il appelle join() se termine.  


## Code thread-safe  




